package com.google.appinventor.components.runtime;

import android.util.Log;
import android.view.View;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesAssets;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.LocationSensor;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.GeoJSONUtil;
import com.google.appinventor.components.runtime.util.GeometryUtil;
import com.google.appinventor.components.runtime.util.MapFactory;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.osmdroid.util.BoundingBox;

@SimpleObject
@UsesAssets(fileNames = "location.png, marker.svg")
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_FINE_LOCATION, android.permission.ACCESS_COARSE_LOCATION, android.permission.ACCESS_WIFI_STATE, android.permission.ACCESS_NETWORK_STATE, android.permission.WRITE_EXTERNAL_STORAGE, android.permission.READ_EXTERNAL_STORAGE")
@DesignerComponent(androidMinSdk = 8, category = ComponentCategory.MAPS, description = "<p>A two-dimensional container that renders map tiles in the background and allows for multiple Marker elements to identify points on the map. Map tiles are supplied by OpenStreetMap contributors and the United States Geological Survey.</p><p>The Map component provides three utilities for manipulating its boundaries within App Inventor. First, a locking mechanism is provided to allow the map to be moved relative to other components on the Screen. Second, when unlocked, the user can pan the Map to any location. At this new location, the &quot;Set Initial Boundary&quot; button can be pressed to save the current Map coordinates to its properties. Lastly, if the Map is moved to a different location, for example to add Markers off-screen, then the &quot;Reset Map to Initial Bounds&quot; button can be used to re-center the Map at the starting location.</p>", version = 5)
@UsesLibraries(libraries = "osmdroid.aar, osmdroid.jar, androidsvg.jar, jts.jar")
/* loaded from: classes.dex */
public class Map extends MapFeatureContainerBase implements MapFactory.MapEventListener {
    private static final String ERROR_INVALID_NUMBER = "%s is not a valid number.";
    private static final String ERROR_LATITUDE_OUT_OF_BOUNDS = "Latitude %f is out of bounds.";
    private static final String ERROR_LONGITUDE_OUT_OF_BOUNDS = "Longitude %f is out of bounds.";
    private static final String TAG = Map.class.getSimpleName();
    private MapFactory.MapController mapController = null;
    private LocationSensor sensor = null;

    public Map(ComponentContainer container) {
        super(container);
        Log.d(TAG, "Map.<init>");
        container.$add(this);
        Width(176);
        Height(144);
        CenterFromString("42.359144, -71.093612");
        ZoomLevel(13);
        EnableZoom(true);
        EnablePan(true);
        MapType(1);
        ShowCompass(false);
        LocationSensor(new LocationSensor(container.$form(), false));
        ShowUser(false);
        ShowZoom(false);
        EnableRotation(false);
        ShowScale(false);
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent
    public View getView() {
        if (this.mapController == null) {
            this.mapController = MapFactory.newMap(this.container.$form());
            this.mapController.addEventListener(this);
        }
        return this.mapController.getView();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "<p>Set the initial center coordinate of the map. The value is specified as a comma-separated pair of decimal latitude and longitude coordinates, for example, <code>42.359144, -71.093612</code>.</p><p>In blocks code, it is recommended for performance reasons to use SetCenter with numerical latitude and longitude rather than convert to the string representation for use with this property.</p>")
    @DesignerProperty(defaultValue = "42.359144, -71.093612", editorType = PropertyTypeConstants.PROPERTY_TYPE_GEOGRAPHIC_POINT)
    public void CenterFromString(String center) {
        String[] parts = center.split(",");
        if (parts.length != 2) {
            Log.e(TAG, center + " is not a valid point.");
            InvalidPoint(center + " is not a valid point.");
            return;
        }
        try {
            double latitude = Double.parseDouble(parts[0].trim());
            try {
                double longitude = Double.parseDouble(parts[1].trim());
                if (latitude > 90.0d || latitude < -90.0d) {
                    InvalidPoint(String.format(ERROR_LATITUDE_OUT_OF_BOUNDS, Double.valueOf(latitude)));
                } else if (longitude > 180.0d || longitude < -180.0d) {
                    InvalidPoint(String.format(ERROR_LONGITUDE_OUT_OF_BOUNDS, Double.valueOf(longitude)));
                } else {
                    Log.i(TAG, "Setting center to " + latitude + ", " + longitude);
                    this.mapController.setCenter(latitude, longitude);
                }
            } catch (NumberFormatException e) {
                Log.e(TAG, String.format(ERROR_INVALID_NUMBER, parts[1]));
                InvalidPoint(String.format(ERROR_INVALID_NUMBER, parts[1]));
            }
        } catch (NumberFormatException e2) {
            Log.e(TAG, String.format(ERROR_INVALID_NUMBER, parts[0]));
            InvalidPoint(String.format(ERROR_INVALID_NUMBER, parts[0]));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The latitude of the center of the map.")
    public double Latitude() {
        return this.mapController.getLatitude();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The longitude of the center of the map.")
    public double Longitude() {
        return this.mapController.getLongitude();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "13", editorType = PropertyTypeConstants.PROPERTY_TYPE_MAP_ZOOM)
    public void ZoomLevel(int zoom) {
        this.mapController.setZoom(zoom);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The zoom level of the map. Valid values of ZoomLevel are dependent on the tile provider and the latitude and longitude of the map. For example, zoom levels are more constrained over oceans than dense city centers to conserve space for storing tiles, so valid values may be 1-7 over ocean and 1-18 over cities. Tile providers may send warning or error tiles if the zoom level is too great for the server to support.")
    public int ZoomLevel() {
        return this.mapController.getZoom();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "True", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void EnableZoom(boolean zoom) {
        this.mapController.setZoomEnabled(zoom);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If this property is set to true, multitouch zoom gestures are allowed on the map. Otherwise, the map zoom cannot be changed by the user except via the zoom control buttons.")
    public boolean EnableZoom() {
        return this.mapController.isZoomEnabled();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "0.0", editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT)
    public void Rotation(float rotation) {
        this.mapController.setRotation(rotation);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Sets or gets the rotation of the map in decimal degrees if any")
    public float Rotation() {
        return this.mapController.getRotation();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "1", editorType = PropertyTypeConstants.PROPERTY_TYPE_MAP_TYPE)
    public void MapType(int type) {
        this.mapController.setMapType(MapFactory.MapType.values()[type]);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The type of tile layer to use as the base of the map. Valid values are: 1 (Roads), 2 (Aerial), 3 (Terrain)")
    public int MapType() {
        return this.mapController.getMapType().ordinal();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ShowCompass(boolean compass) {
        this.mapController.setCompassEnabled(compass);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Show a compass icon rotated based on user orientation.")
    public boolean ShowCompass() {
        return this.mapController.isCompassEnabled();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ShowZoom(boolean zoom) {
        this.mapController.setZoomControlEnabled(zoom);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Show zoom buttons on the map.")
    public boolean ShowZoom() {
        return this.mapController.isZoomControlEnabled();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ShowUser(boolean user) {
        this.mapController.setShowUserEnabled(user);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Show the user's location on the map.")
    public boolean ShowUser() {
        return this.mapController.isShowUserEnabled();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void EnableRotation(boolean rotation) {
        this.mapController.setRotationEnabled(rotation);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If set to true, the user can use multitouch gestures to rotate the map around its current center.")
    public boolean EnableRotation() {
        return this.mapController.isRotationEnabled();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "True", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void EnablePan(boolean pan) {
        this.mapController.setPanEnabled(pan);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Enable two-finger panning of the Map")
    public boolean EnablePan() {
        return this.mapController.isPanEnabled();
    }

    @SimpleProperty
    public void BoundingBox(YailList boundingbox) {
        double latNorth = GeometryUtil.coerceToDouble(((YailList) boundingbox.get(1)).get(1));
        double longWest = GeometryUtil.coerceToDouble(((YailList) boundingbox.get(1)).get(2));
        double latSouth = GeometryUtil.coerceToDouble(((YailList) boundingbox.get(2)).get(1));
        this.mapController.setBoundingBox(new BoundingBox(latNorth, GeometryUtil.coerceToDouble(((YailList) boundingbox.get(2)).get(2)), latSouth, longWest));
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Bounding box for the map stored as [[North, West], [South, East]].")
    public YailList BoundingBox() {
        BoundingBox bbox = this.mapController.getBoundingBox();
        return YailList.makeList(new YailList[]{YailList.makeList(new Double[]{Double.valueOf(bbox.getLatNorth()), Double.valueOf(bbox.getLonWest())}), YailList.makeList(new Double[]{Double.valueOf(bbox.getLatSouth()), Double.valueOf(bbox.getLonEast())})});
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase, com.google.appinventor.components.runtime.util.MapFactory.MapFeatureContainer
    @SimpleProperty
    public YailList Features() {
        return super.Features();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Uses the provided LocationSensor for user location data rather than the built-in location provider.")
    @DesignerProperty(editorType = "component:com.google.appinventor.components.runtime.LocationSensor")
    public void LocationSensor(LocationSensor sensor) {
        LocationSensor.LocationSensorListener listener = this.mapController.getLocationListener();
        if (this.sensor != null) {
            this.sensor.removeListener(listener);
        }
        this.sensor = sensor;
        if (this.sensor != null) {
            this.sensor.addListener(listener);
        }
    }

    public LocationSensor LocationSensor() {
        return this.sensor;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ShowScale(boolean show) {
        this.mapController.setScaleVisible(show);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Shows a scale reference on the map.")
    public boolean ShowScale() {
        return this.mapController.isScaleVisible();
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "1", editorType = PropertyTypeConstants.PROPERTY_TYPE_MAP_UNIT_SYSTEM)
    public void ScaleUnits(int units) {
        if (1 > units || units >= MapFactory.MapScaleUnits.values().length) {
            $form().dispatchErrorOccurredEvent(this, "ScaleUnits", ErrorMessages.ERROR_INVALID_UNIT_SYSTEM, Integer.valueOf(units));
        } else {
            this.mapController.setScaleUnits(MapFactory.MapScaleUnits.values()[units]);
        }
    }

    @SimpleProperty
    public int ScaleUnits() {
        switch (this.mapController.getScaleUnits()) {
            case METRIC:
                return 1;
            case IMPERIAL:
                return 2;
            default:
                return 0;
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the user's latitude if ShowUser is enabled.")
    public double UserLatitude() {
        if (this.sensor == null) {
            return -999.0d;
        }
        return this.sensor.Latitude();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the user's longitude if ShowUser is enabled.")
    public double UserLongitude() {
        if (this.sensor == null) {
            return -999.0d;
        }
        return this.sensor.Longitude();
    }

    @SimpleFunction(description = "Pans the map center to the given latitude and longitude and adjust the zoom level to the specified zoom.")
    public void PanTo(double latitude, double longitude, int zoom) {
        this.mapController.panTo(latitude, longitude, zoom, 1.0d);
    }

    @SimpleFunction(description = "Create a new marker with default properties at the specified latitude and longitude.")
    public Marker CreateMarker(double latitude, double longitude) {
        Marker marker = new Marker(this);
        marker.SetLocation(latitude, longitude);
        return marker;
    }

    @SimpleFunction(description = "Save the contents of the Map to the specified path.")
    public void Save(final String path) {
        final List<MapFactory.MapFeature> featuresToSave = new ArrayList<>(this.features);
        AsynchUtil.runAsynchronously(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GeoJSONUtil.writeFeaturesAsGeoJSON(featuresToSave, path);
                } catch (IOException e) {
                    final Form form = Map.this.$form();
                    form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            form.dispatchErrorOccurredEvent(Map.this, "Save", ErrorMessages.ERROR_EXCEPTION_DURING_MAP_SAVE, e.getMessage());
                        }
                    });
                }
            }
        });
    }

    @SimpleEvent(description = "Map has been initialized and is ready for user interaction.")
    public void Ready() {
        EventDispatcher.dispatchEvent(this, "Ready", new Object[0]);
    }

    @SimpleEvent(description = "User has changed the map bounds by panning or zooming the map.")
    public void BoundsChange() {
        EventDispatcher.dispatchEvent(this, "BoundsChange", new Object[0]);
    }

    @SimpleEvent(description = "User has changed the zoom level of the map.")
    public void ZoomChange() {
        EventDispatcher.dispatchEvent(this, "ZoomChange", new Object[0]);
    }

    @SimpleEvent(description = "An invalid coordinate was supplied during a maps operation. The message parameter will have more details about the issue.")
    public void InvalidPoint(String message) {
        EventDispatcher.dispatchEvent(this, "InvalidPoint", message);
    }

    @SimpleEvent(description = "The user tapped at a point on the map.")
    public void TapAtPoint(double latitude, double longitude) {
        EventDispatcher.dispatchEvent(this, "TapAtPoint", Double.valueOf(latitude), Double.valueOf(longitude));
    }

    @SimpleEvent(description = "The user double-tapped at a point on the map. This event will be followed by a ZoomChanged event if zooming gestures are enabled and the map is not at the highest possible zoom level.")
    public void DoubleTapAtPoint(double latitude, double longitude) {
        EventDispatcher.dispatchEvent(this, "DoubleTapAtPoint", Double.valueOf(latitude), Double.valueOf(longitude));
    }

    @SimpleEvent(description = "The user long-pressed at a point on the map.")
    public void LongPressAtPoint(double latitude, double longitude) {
        EventDispatcher.dispatchEvent(this, "LongPressAtPoint", Double.valueOf(latitude), Double.valueOf(longitude));
    }

    public MapFactory.MapController getController() {
        return this.mapController;
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onReady(MapFactory.MapController map) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.2
            @Override // java.lang.Runnable
            public void run() {
                Map.this.Ready();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onBoundsChanged() {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.3
            @Override // java.lang.Runnable
            public void run() {
                Map.this.BoundsChange();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onZoom() {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.4
            @Override // java.lang.Runnable
            public void run() {
                Map.this.ZoomChange();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onSingleTap(final double latitude, final double longitude) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.5
            @Override // java.lang.Runnable
            public void run() {
                Map.this.TapAtPoint(latitude, longitude);
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onDoubleTap(final double latitude, final double longitude) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.6
            @Override // java.lang.Runnable
            public void run() {
                Map.this.DoubleTapAtPoint(latitude, longitude);
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onLongPress(final double latitude, final double longitude) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.7
            @Override // java.lang.Runnable
            public void run() {
                Map.this.LongPressAtPoint(latitude, longitude);
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onFeatureClick(final MapFactory.MapFeature feature) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.8
            @Override // java.lang.Runnable
            public void run() {
                feature.Click();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onFeatureLongPress(final MapFactory.MapFeature feature) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.9
            @Override // java.lang.Runnable
            public void run() {
                feature.LongClick();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onFeatureStartDrag(final MapFactory.MapFeature feature) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.10
            @Override // java.lang.Runnable
            public void run() {
                feature.StartDrag();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onFeatureDrag(final MapFactory.MapFeature feature) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.11
            @Override // java.lang.Runnable
            public void run() {
                feature.Drag();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapEventListener
    public void onFeatureStopDrag(final MapFactory.MapFeature feature) {
        this.container.$form().runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.Map.12
            @Override // java.lang.Runnable
            public void run() {
                feature.StopDrag();
            }
        });
    }

    @Override // com.google.appinventor.components.runtime.util.MapFactory.MapFeatureContainer
    public Map getMap() {
        return this;
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase
    public void addFeature(MapFactory.MapMarker marker) {
        this.features.add(marker);
        marker.setMap(this);
        this.mapController.addFeature(marker);
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase
    public void addFeature(MapFactory.MapLineString lineString) {
        this.features.add(lineString);
        lineString.setMap(this);
        this.mapController.addFeature(lineString);
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase
    public void addFeature(MapFactory.MapPolygon polygon) {
        this.features.add(polygon);
        polygon.setMap(this);
        this.mapController.addFeature(polygon);
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase
    public void addFeature(MapFactory.MapRectangle rectangle) {
        this.features.add(rectangle);
        rectangle.setMap(this);
        this.mapController.addFeature(rectangle);
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase
    public void addFeature(MapFactory.MapCircle circle) {
        this.features.add(circle);
        circle.setMap(this);
        this.mapController.addFeature(circle);
    }

    @Override // com.google.appinventor.components.runtime.MapFeatureContainerBase, com.google.appinventor.components.runtime.util.MapFactory.MapFeatureContainer
    public void removeFeature(MapFactory.MapFeature feature) {
        this.features.remove(feature);
        this.mapController.removeFeature(feature);
    }
}
