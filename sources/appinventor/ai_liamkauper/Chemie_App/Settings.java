package appinventor.ai_liamkauper.Chemie_App;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.Switch;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

/* compiled from: Settings.yail */
/* loaded from: classes.dex */
public class Settings extends Form implements Runnable {
    static final IntNum Lit101;
    static final IntNum Lit102;
    static final PairWithPosition Lit104;
    static final IntNum Lit108;
    static final IntNum Lit14;
    static final SimpleSymbol Lit16;
    static final IntNum Lit29;
    static final IntNum Lit34;
    static final IntNum Lit39;
    static final SimpleSymbol Lit4;
    static final IntNum Lit43;
    static final IntNum Lit56;
    static final IntNum Lit6;
    static final PairWithPosition Lit60;
    static final IntNum Lit65;
    static final IntNum Lit71;
    static final IntNum Lit88;
    static final IntNum Lit91;
    public static Settings Settings;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public Switch Cache;
    public final ModuleMethod Cache$Changed;
    public Notifier Cache_notification;
    public final ModuleMethod Cache_notification$ChoosingCanceled;
    public Label Credits;
    public Button Puffer0;
    public Label Title;
    public Label Version;
    public Label What_for;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public Switch extended;
    public final ModuleMethod extended$Changed;
    public Label extended_infos;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public Button home;
    public final ModuleMethod home$Click;
    public Label info;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public Button puffer1;
    public Button puffer2;
    public Switch quit;
    public final ModuleMethod quit$Changed;
    public final ModuleMethod send$Mnerror;
    static final SimpleSymbol Lit127 = (SimpleSymbol) new SimpleSymbol("any").readResolve();
    static final SimpleSymbol Lit126 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit125 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit124 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit123 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit122 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit121 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit120 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit119 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit118 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit117 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit116 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit115 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit114 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit113 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final SimpleSymbol Lit112 = (SimpleSymbol) new SimpleSymbol("ChoosingCanceled").readResolve();
    static final SimpleSymbol Lit111 = (SimpleSymbol) new SimpleSymbol("Cache_notification$ChoosingCanceled").readResolve();
    static final SimpleSymbol Lit110 = (SimpleSymbol) new SimpleSymbol("On").readResolve();
    static final FString Lit109 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit107 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit106 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
    static final SimpleSymbol Lit105 = (SimpleSymbol) new SimpleSymbol("home$Click").readResolve();
    static final FString Lit103 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit100 = (SimpleSymbol) new SimpleSymbol("home").readResolve();
    static final FString Lit99 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit98 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit97 = IntNum.make(-1100);
    static final IntNum Lit96 = IntNum.make(16777215);
    static final IntNum Lit95 = IntNum.make(16777215);
    static final SimpleSymbol Lit94 = (SimpleSymbol) new SimpleSymbol("puffer2").readResolve();
    static final FString Lit93 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit92 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit89 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit85 = IntNum.make(-1100);
    static final IntNum Lit84 = IntNum.make(16777215);
    static final IntNum Lit83 = IntNum.make(16777215);
    static final SimpleSymbol Lit82 = (SimpleSymbol) new SimpleSymbol("puffer1").readResolve();
    static final FString Lit81 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit80 = (SimpleSymbol) new SimpleSymbol("extended$Changed").readResolve();
    static final PairWithPosition Lit79 = PairWithPosition.make(Lit127, PairWithPosition.make(Lit127, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524882), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524877);
    static final PairWithPosition Lit78 = PairWithPosition.make(Lit127, PairWithPosition.make(Lit127, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524779), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524774);
    static final PairWithPosition Lit77 = PairWithPosition.make(Lit127, PairWithPosition.make(Lit127, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524515), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524510);
    static final SimpleSymbol Lit76 = (SimpleSymbol) new SimpleSymbol("info").readResolve();
    static final PairWithPosition Lit75 = PairWithPosition.make(Lit127, PairWithPosition.make(Lit127, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524412), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 524407);
    static final SimpleSymbol Lit74 = (SimpleSymbol) new SimpleSymbol("Visible").readResolve();
    static final SimpleSymbol Lit73 = (SimpleSymbol) new SimpleSymbol("extended_infos").readResolve();
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.Switch");
    static final DFloNum Lit70 = DFloNum.make(19.5d);
    static final SimpleSymbol Lit69 = (SimpleSymbol) new SimpleSymbol("extended").readResolve();
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.Switch");
    static final SimpleSymbol Lit67 = (SimpleSymbol) new SimpleSymbol("quit$Changed").readResolve();
    static final FString Lit66 = new FString("com.google.appinventor.components.runtime.Switch");
    static final SimpleSymbol Lit64 = (SimpleSymbol) new SimpleSymbol("quit").readResolve();
    static final FString Lit63 = new FString("com.google.appinventor.components.runtime.Switch");
    static final SimpleSymbol Lit62 = (SimpleSymbol) new SimpleSymbol("Changed").readResolve();
    static final SimpleSymbol Lit61 = (SimpleSymbol) new SimpleSymbol("Cache$Changed").readResolve();
    static final SimpleSymbol Lit59 = (SimpleSymbol) new SimpleSymbol("ShowChooseDialog").readResolve();
    static final SimpleSymbol Lit58 = (SimpleSymbol) new SimpleSymbol("Cache_notification").readResolve();
    static final FString Lit57 = new FString("com.google.appinventor.components.runtime.Switch");
    static final SimpleSymbol Lit55 = (SimpleSymbol) new SimpleSymbol("Cache").readResolve();
    static final FString Lit54 = new FString("com.google.appinventor.components.runtime.Switch");
    static final FString Lit53 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit52 = IntNum.make(-1100);
    static final SimpleSymbol Lit51 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
    static final IntNum Lit50 = IntNum.make(16777215);
    static final IntNum Lit49 = IntNum.make(0);
    static final SimpleSymbol Lit48 = (SimpleSymbol) new SimpleSymbol("Enabled").readResolve();
    static final IntNum Lit47 = IntNum.make(16777215);
    static final SimpleSymbol Lit46 = (SimpleSymbol) new SimpleSymbol("Puffer0").readResolve();
    static final FString Lit45 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit44 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit42 = (SimpleSymbol) new SimpleSymbol("What_for").readResolve();
    static final FString Lit41 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit40 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit38 = (SimpleSymbol) new SimpleSymbol("HTMLFormat").readResolve();
    static final SimpleSymbol Lit37 = (SimpleSymbol) new SimpleSymbol("Credits").readResolve();
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit35 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit33 = IntNum.make(20);
    static final SimpleSymbol Lit32 = (SimpleSymbol) new SimpleSymbol("Version").readResolve();
    static final FString Lit31 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit30 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit28 = (SimpleSymbol) new SimpleSymbol("TextColor").readResolve();
    static final IntNum Lit27 = IntNum.make(1);
    static final SimpleSymbol Lit26 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
    static final IntNum Lit24 = IntNum.make(25);
    static final SimpleSymbol Lit23 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
    static final SimpleSymbol Lit22 = (SimpleSymbol) new SimpleSymbol("FontBold").readResolve();
    static final FString Lit21 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve();
    static final SimpleSymbol Lit19 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
    static final SimpleSymbol Lit17 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
    static final SimpleSymbol Lit15 = (SimpleSymbol) new SimpleSymbol("Scrollable").readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve();
    static final SimpleSymbol Lit12 = (SimpleSymbol) new SimpleSymbol("AppName").readResolve();
    static final IntNum Lit11 = IntNum.make(2);
    static final SimpleSymbol Lit10 = (SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve();
    static final IntNum Lit9 = IntNum.make(3);
    static final SimpleSymbol Lit8 = (SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol) new SimpleSymbol("AccentColor").readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol) new SimpleSymbol("AboutScreen").readResolve();
    static final SimpleSymbol Lit2 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
    static final SimpleSymbol Lit0 = (SimpleSymbol) new SimpleSymbol("Settings").readResolve();

    static {
        int[] iArr = new int[2];
        iArr[0] = -13684426;
        Lit108 = IntNum.make(iArr);
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit4 = simpleSymbol;
        Lit104 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 839758);
        int[] iArr2 = new int[2];
        iArr2[0] = -1;
        Lit102 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -7829368;
        Lit101 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -1;
        Lit91 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -65536;
        Lit88 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit71 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -1;
        Lit65 = IntNum.make(iArr7);
        SimpleSymbol simpleSymbol2 = Lit4;
        SimpleSymbol simpleSymbol3 = Lit4;
        SimpleSymbol simpleSymbol4 = Lit4;
        SimpleSymbol simpleSymbol5 = Lit4;
        SimpleSymbol simpleSymbol6 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit16 = simpleSymbol6;
        Lit60 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol6, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 417997), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 417992), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 417987), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 417982), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Settings.yail", 417976);
        int[] iArr8 = new int[2];
        iArr8[0] = -1;
        Lit56 = IntNum.make(iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = -1;
        Lit43 = IntNum.make(iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = -1;
        Lit39 = IntNum.make(iArr10);
        int[] iArr11 = new int[2];
        iArr11[0] = -1;
        Lit34 = IntNum.make(iArr11);
        int[] iArr12 = new int[2];
        iArr12[0] = -1;
        Lit29 = IntNum.make(iArr12);
        int[] iArr13 = new int[2];
        iArr13[0] = -13684426;
        Lit14 = IntNum.make(iArr13);
        int[] iArr14 = new int[2];
        iArr14[0] = -16711681;
        Lit6 = IntNum.make(iArr14);
    }

    public Settings() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit113, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit114, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit115, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit116, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit117, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit118, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit119, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit120, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit121, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit122, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit123, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit124, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit125, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit126, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frameVar, 18, null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:622");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frameVar, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frameVar, 20, null, 0);
        lambda$Fn3 = new ModuleMethod(frameVar, 21, null, 0);
        lambda$Fn4 = new ModuleMethod(frameVar, 22, null, 0);
        lambda$Fn5 = new ModuleMethod(frameVar, 23, null, 0);
        lambda$Fn6 = new ModuleMethod(frameVar, 24, null, 0);
        lambda$Fn7 = new ModuleMethod(frameVar, 25, null, 0);
        lambda$Fn8 = new ModuleMethod(frameVar, 26, null, 0);
        lambda$Fn9 = new ModuleMethod(frameVar, 27, null, 0);
        lambda$Fn10 = new ModuleMethod(frameVar, 28, null, 0);
        lambda$Fn11 = new ModuleMethod(frameVar, 29, null, 0);
        lambda$Fn12 = new ModuleMethod(frameVar, 30, null, 0);
        lambda$Fn13 = new ModuleMethod(frameVar, 31, null, 0);
        lambda$Fn14 = new ModuleMethod(frameVar, 32, null, 0);
        this.Cache$Changed = new ModuleMethod(frameVar, 33, Lit61, 0);
        lambda$Fn15 = new ModuleMethod(frameVar, 34, null, 0);
        lambda$Fn16 = new ModuleMethod(frameVar, 35, null, 0);
        this.quit$Changed = new ModuleMethod(frameVar, 36, Lit67, 0);
        lambda$Fn17 = new ModuleMethod(frameVar, 37, null, 0);
        lambda$Fn18 = new ModuleMethod(frameVar, 38, null, 0);
        lambda$Fn19 = new ModuleMethod(frameVar, 39, null, 0);
        lambda$Fn20 = new ModuleMethod(frameVar, 40, null, 0);
        lambda$Fn21 = new ModuleMethod(frameVar, 41, null, 0);
        lambda$Fn22 = new ModuleMethod(frameVar, 42, null, 0);
        this.extended$Changed = new ModuleMethod(frameVar, 43, Lit80, 0);
        lambda$Fn23 = new ModuleMethod(frameVar, 44, null, 0);
        lambda$Fn24 = new ModuleMethod(frameVar, 45, null, 0);
        lambda$Fn25 = new ModuleMethod(frameVar, 46, null, 0);
        lambda$Fn26 = new ModuleMethod(frameVar, 47, null, 0);
        lambda$Fn27 = new ModuleMethod(frameVar, 48, null, 0);
        lambda$Fn28 = new ModuleMethod(frameVar, 49, null, 0);
        lambda$Fn29 = new ModuleMethod(frameVar, 50, null, 0);
        lambda$Fn30 = new ModuleMethod(frameVar, 51, null, 0);
        lambda$Fn31 = new ModuleMethod(frameVar, 52, null, 0);
        lambda$Fn32 = new ModuleMethod(frameVar, 53, null, 0);
        this.home$Click = new ModuleMethod(frameVar, 54, Lit105, 0);
        lambda$Fn33 = new ModuleMethod(frameVar, 55, null, 0);
        lambda$Fn34 = new ModuleMethod(frameVar, 56, null, 0);
        this.Cache_notification$ChoosingCanceled = new ModuleMethod(frameVar, 57, Lit111, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    @Override // java.lang.Runnable
    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Consumer $result = $ctx.consumer;
        runtime.$instance.run();
        this.$Stdebug$Mnform$St = Boolean.FALSE;
        this.form$Mnenvironment = Environment.make(Lit0.toString());
        FString stringAppend = strings.stringAppend(Lit0.toString(), "-global-vars");
        if (stringAppend == null) {
            obj = null;
        } else {
            obj = stringAppend.toString();
        }
        this.global$Mnvar$Mnenvironment = Environment.make(obj);
        Settings = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Einstellungen der App", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "Chemie_App", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Lit14, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit16);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit17, Boolean.TRUE, Lit16);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Responsive", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit19, "Settings", Lit4);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit20, Boolean.FALSE, Lit16), $result);
        } else {
            addToFormDoAfterCreation(new Promise(lambda$Fn2));
        }
        this.Title = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit21, Lit19, lambda$Fn3), $result);
        } else {
            addToComponents(Lit0, Lit30, Lit19, lambda$Fn4);
        }
        this.Version = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit31, Lit32, lambda$Fn5), $result);
        } else {
            addToComponents(Lit0, Lit35, Lit32, lambda$Fn6);
        }
        this.Credits = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit36, Lit37, lambda$Fn7), $result);
        } else {
            addToComponents(Lit0, Lit40, Lit37, lambda$Fn8);
        }
        this.What_for = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit41, Lit42, lambda$Fn9), $result);
        } else {
            addToComponents(Lit0, Lit44, Lit42, lambda$Fn10);
        }
        this.Puffer0 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit45, Lit46, lambda$Fn11), $result);
        } else {
            addToComponents(Lit0, Lit53, Lit46, lambda$Fn12);
        }
        this.Cache = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit54, Lit55, lambda$Fn13), $result);
        } else {
            addToComponents(Lit0, Lit57, Lit55, lambda$Fn14);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit61, this.Cache$Changed);
        } else {
            addToFormEnvironment(Lit61, this.Cache$Changed);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Cache", "Changed");
        } else {
            addToEvents(Lit55, Lit62);
        }
        this.quit = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit63, Lit64, lambda$Fn15), $result);
        } else {
            addToComponents(Lit0, Lit66, Lit64, lambda$Fn16);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit67, this.quit$Changed);
        } else {
            addToFormEnvironment(Lit67, this.quit$Changed);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "quit", "Changed");
        } else {
            addToEvents(Lit64, Lit62);
        }
        this.extended = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit68, Lit69, lambda$Fn17), $result);
        } else {
            addToComponents(Lit0, Lit72, Lit69, lambda$Fn18);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit80, this.extended$Changed);
        } else {
            addToFormEnvironment(Lit80, this.extended$Changed);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "extended", "Changed");
        } else {
            addToEvents(Lit69, Lit62);
        }
        this.puffer1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit81, Lit82, lambda$Fn23), $result);
        } else {
            addToComponents(Lit0, Lit86, Lit82, lambda$Fn24);
        }
        this.info = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit87, Lit76, lambda$Fn25), $result);
        } else {
            addToComponents(Lit0, Lit89, Lit76, lambda$Fn26);
        }
        this.extended_infos = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit90, Lit73, lambda$Fn27), $result);
        } else {
            addToComponents(Lit0, Lit92, Lit73, lambda$Fn28);
        }
        this.puffer2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit93, Lit94, lambda$Fn29), $result);
        } else {
            addToComponents(Lit0, Lit98, Lit94, lambda$Fn30);
        }
        this.home = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit99, Lit100, lambda$Fn31), $result);
        } else {
            addToComponents(Lit0, Lit103, Lit100, lambda$Fn32);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit105, this.home$Click);
        } else {
            addToFormEnvironment(Lit105, this.home$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "home", "Click");
        } else {
            addToEvents(Lit100, Lit106);
        }
        this.Cache_notification = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit107, Lit58, lambda$Fn33), $result);
        } else {
            addToComponents(Lit0, Lit109, Lit58, lambda$Fn34);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit111, this.Cache_notification$ChoosingCanceled);
        } else {
            addToFormEnvironment(Lit111, this.Cache_notification$ChoosingCanceled);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Cache_notification", "ChoosingCanceled");
        } else {
            addToEvents(Lit58, Lit112);
        }
        runtime.initRuntime();
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Einstellungen der App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "Chemie_App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Lit14, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Responsive", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit19, "Settings", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit20, Boolean.FALSE, Lit16);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit22, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit25, "Chemie Lern-App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit26, Lit27, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit28, Lit29, Lit7);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit22, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit25, "Chemie Lern-App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit26, Lit27, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit28, Lit29, Lit7);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit25, "Version 1.0", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit28, Lit34, Lit7);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit25, "Version 1.0", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit28, Lit34, Lit7);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit37, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit38, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit25, "Entwickelt von <b>Liam Kauper</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit37, Lit28, Lit39, Lit7);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit37, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit38, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit25, "Entwickelt von <b>Liam Kauper</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit37, Lit28, Lit39, Lit7);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit42, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit42, Lit25, "Erstellt im Rahmen eines Chemie-Schulprojektes.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit42, Lit26, Lit27, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit42, Lit28, Lit43, Lit7);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit42, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit42, Lit25, "Erstellt im Rahmen eines Chemie-Schulprojektes.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit42, Lit26, Lit27, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit42, Lit28, Lit43, Lit7);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit13, Lit47, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit48, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit28, Lit50, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit51, Lit52, Lit7);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit13, Lit47, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit48, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit28, Lit50, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit51, Lit52, Lit7);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit55, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit55, Lit25, "Cache leeren", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit55, Lit28, Lit56, Lit7);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit55, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit55, Lit25, "Cache leeren", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit55, Lit28, Lit56, Lit7);
    }

    public Object Cache$Changed() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit58;
        SimpleSymbol simpleSymbol2 = Lit59;
        Pair list1 = LList.list1("Möchtest du den Cache wirklich leeren?");
        LList.chain4(list1, "Cache leeren", "Ja, ich bin mir sicher", "", Boolean.TRUE);
        return runtime.callComponentMethod(simpleSymbol, simpleSymbol2, list1, Lit60);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit64, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit64, Lit25, "Beenden erzwingen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit64, Lit28, Lit65, Lit7);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit64, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit64, Lit25, "Beenden erzwingen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit64, Lit28, Lit65, Lit7);
    }

    public Object quit$Changed() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.close$Mnapplication, LList.Empty, LList.Empty, "close application");
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit23, Lit70, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit25, "Erweiterete Informationen anzeigen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit28, Lit71, Lit7);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit23, Lit70, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit25, "Erweiterete Informationen anzeigen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit28, Lit71, Lit7);
    }

    public Object extended$Changed() {
        runtime.setThisForm();
        if (runtime.processOrDelayed$V(new Object[]{lambda$Fn19, lambda$Fn20}) != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit73, Lit74, Boolean.TRUE, Lit16);
            return runtime.setAndCoerceProperty$Ex(Lit76, Lit74, Boolean.TRUE, Lit16);
        } else if (runtime.processOrDelayed$V(new Object[]{lambda$Fn21, lambda$Fn22}) == Boolean.FALSE) {
            return Values.empty;
        } else {
            runtime.setAndCoerceProperty$Ex(Lit73, Lit74, Boolean.FALSE, Lit16);
            return runtime.setAndCoerceProperty$Ex(Lit76, Lit74, Boolean.FALSE, Lit16);
        }
    }

    static Object lambda20() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit73, Lit74), Boolean.FALSE), Lit75, "=");
    }

    static Object lambda21() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit76, Lit74), Boolean.FALSE), Lit77, "=");
    }

    static Object lambda22() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit73, Lit74), Boolean.TRUE), Lit78, "=");
    }

    static Object lambda23() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit76, Lit74), Boolean.TRUE), Lit79, "=");
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit13, Lit83, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit28, Lit84, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit51, Lit85, Lit7);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit13, Lit83, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit28, Lit84, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit51, Lit85, Lit7);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit76, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit25, "Diese App ist noch nicht ausgereift und wird noch ergänzt!", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit26, Lit27, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit28, Lit88, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit76, Lit74, Boolean.FALSE, Lit16);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit76, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit25, "Diese App ist noch nicht ausgereift und wird noch ergänzt!", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit26, Lit27, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit76, Lit28, Lit88, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit76, Lit74, Boolean.FALSE, Lit16);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit73, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit38, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit25, "Außerdem könnte es noch Probleme in der <b>Übung</b>s Funktion geben.<br><br> <u>Quellen:</u> <br> <ul>\n<li>Chemie Buch ausgabe Bayern für Gymnasien</li>\n<li><a href=\"https://de.wikipedia.org\" target=\"_blank\">Wikipedia.org</li><li><a href=\"https://chemie-schule.de\" target=\"_blank\">chemie-schule.de</li><li><a href=\"https://de.serlo.org/chemie/\" target=\"_blank\">de.serlo.org</li><a href=\"https://Quelle: https://freie-referate.de/chemie/aufgabenbeispiele-mit-loesungen\" target=\"_blank\">freie-referate.de</li><li>Chemie Unterricht</li>\n</ul>", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit26, Lit27, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit28, Lit91, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit73, Lit74, Boolean.FALSE, Lit16);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit73, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit38, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit25, "Außerdem könnte es noch Probleme in der <b>Übung</b>s Funktion geben.<br><br> <u>Quellen:</u> <br> <ul>\n<li>Chemie Buch ausgabe Bayern für Gymnasien</li>\n<li><a href=\"https://de.wikipedia.org\" target=\"_blank\">Wikipedia.org</li><li><a href=\"https://chemie-schule.de\" target=\"_blank\">chemie-schule.de</li><li><a href=\"https://de.serlo.org/chemie/\" target=\"_blank\">de.serlo.org</li><a href=\"https://Quelle: https://freie-referate.de/chemie/aufgabenbeispiele-mit-loesungen\" target=\"_blank\">freie-referate.de</li><li>Chemie Unterricht</li>\n</ul>", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit26, Lit27, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit73, Lit28, Lit91, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit73, Lit74, Boolean.FALSE, Lit16);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit94, Lit13, Lit95, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit48, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit25, "Text for Button1", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit28, Lit96, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit94, Lit51, Lit97, Lit7);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit94, Lit13, Lit95, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit48, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit23, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit25, "Text for Button1", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit94, Lit28, Lit96, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit94, Lit51, Lit97, Lit7);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit100, Lit13, Lit101, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit100, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit100, Lit25, "Home", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit100, Lit28, Lit102, Lit7);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit100, Lit13, Lit101, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit100, Lit23, Lit33, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit100, Lit25, "Home", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit100, Lit28, Lit102, Lit7);
    }

    public Object home$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Screen1"), Lit104, "open another screen");
    }

    static Object lambda34() {
        return runtime.setAndCoerceProperty$Ex(Lit58, Lit13, Lit108, Lit7);
    }

    static Object lambda35() {
        return runtime.setAndCoerceProperty$Ex(Lit58, Lit13, Lit108, Lit7);
    }

    public Object Cache_notification$ChoosingCanceled() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit55, Lit110, Boolean.FALSE, Lit16);
    }

    /* compiled from: Settings.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Settings $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Settings)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return super.match1(moduleMethod, obj, callContext);
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 7:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (!(obj instanceof Settings)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 6:
                case 7:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
                case 8:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (!(obj instanceof Settings)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 16:
                    if (!(obj instanceof Settings)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return super.apply1(moduleMethod, obj);
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            boolean z = true;
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    Settings settings = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    settings.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 6:
                case 7:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                default:
                    return super.apply2(moduleMethod, obj, obj2);
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Settings.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Settings.lambda3();
                case 21:
                    return Settings.lambda4();
                case 22:
                    return Settings.lambda5();
                case 23:
                    return Settings.lambda6();
                case 24:
                    return Settings.lambda7();
                case 25:
                    return Settings.lambda8();
                case 26:
                    return Settings.lambda9();
                case 27:
                    return Settings.lambda10();
                case 28:
                    return Settings.lambda11();
                case 29:
                    return Settings.lambda12();
                case 30:
                    return Settings.lambda13();
                case 31:
                    return Settings.lambda14();
                case 32:
                    return Settings.lambda15();
                case 33:
                    return this.$main.Cache$Changed();
                case 34:
                    return Settings.lambda16();
                case 35:
                    return Settings.lambda17();
                case 36:
                    return this.$main.quit$Changed();
                case 37:
                    return Settings.lambda18();
                case 38:
                    return Settings.lambda19();
                case 39:
                    return Settings.lambda20();
                case 40:
                    return Settings.lambda21();
                case 41:
                    return Settings.lambda22();
                case 42:
                    return Settings.lambda23();
                case 43:
                    return this.$main.extended$Changed();
                case 44:
                    return Settings.lambda24();
                case 45:
                    return Settings.lambda25();
                case 46:
                    return Settings.lambda26();
                case 47:
                    return Settings.lambda27();
                case 48:
                    return Settings.lambda28();
                case 49:
                    return Settings.lambda29();
                case 50:
                    return Settings.lambda30();
                case 51:
                    return Settings.lambda31();
                case 52:
                    return Settings.lambda32();
                case 53:
                    return Settings.lambda33();
                case 54:
                    return this.$main.home$Click();
                case 55:
                    return Settings.lambda34();
                case 56:
                    return Settings.lambda35();
                case 57:
                    return this.$main.Cache_notification$ChoosingCanceled();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 54:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 55:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.AppInventorCompatActivity, android.app.Activity
    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(true);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        int i = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & 1;
        if (i != 0) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (i == 0) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.HandlesEventDispatching
    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        boolean x;
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this == componentObject) {
                    x = true;
                } else {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
                return false;
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
                return false;
            }
        }
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.HandlesEventDispatching
    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        boolean x = true;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName)));
        if (handler != Boolean.FALSE) {
            try {
                Scheme.apply.apply2(handler, lists.cons(componentObject, lists.cons(notAlreadyHandled ? Boolean.TRUE : Boolean.FALSE, LList.makeList(args, 0))));
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this != componentObject) {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    @Override // com.google.appinventor.components.runtime.Form
    public void $define() {
        Object obj;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Settings = this;
        addToFormEnvironment(Lit0, this);
        Object obj2 = this.events$Mnto$Mnregister;
        while (obj2 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj2;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj3 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj3, apply12 == null ? null : apply12.toString());
                obj2 = arg0.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, obj2);
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            Object reverse = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse != LList.Empty) {
                try {
                    Pair arg02 = (Pair) reverse;
                    misc.force(arg02.getCar());
                    reverse = arg02.getCdr();
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "arg0", -2, reverse);
                }
            }
            Object obj4 = components;
            while (obj4 != LList.Empty) {
                try {
                    Pair arg03 = (Pair) obj4;
                    Object component$Mninfo = arg03.getCar();
                    Object component$Mnname = lists.caddr.apply1(component$Mninfo);
                    lists.cadddr.apply1(component$Mninfo);
                    try {
                        Object component$Mnobject = Invoke.make.apply2(lists.cadr.apply1(component$Mninfo), lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo)));
                        SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                        try {
                            addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                            obj4 = arg03.getCdr();
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "add-to-form-environment", 0, component$Mnname);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "lookup-in-form-environment", 0, obj);
                    }
                } catch (ClassCastException e5) {
                    throw new WrongType(e5, "arg0", -2, obj4);
                }
            }
            Object reverse2 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse2 != LList.Empty) {
                try {
                    Pair arg04 = (Pair) reverse2;
                    Object var$Mnval = arg04.getCar();
                    Object var = lists.car.apply1(var$Mnval);
                    try {
                        addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                        reverse2 = arg04.getCdr();
                    } catch (ClassCastException e6) {
                        throw new WrongType(e6, "add-to-global-var-environment", 0, var);
                    }
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "arg0", -2, reverse2);
                }
            }
            Object obj5 = components;
            while (obj5 != LList.Empty) {
                try {
                    Pair arg05 = (Pair) obj5;
                    Object component$Mninfo2 = arg05.getCar();
                    lists.caddr.apply1(component$Mninfo2);
                    Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                    if (init$Mnthunk != Boolean.FALSE) {
                        Scheme.applyToArgs.apply1(init$Mnthunk);
                    }
                    obj5 = arg05.getCdr();
                } catch (ClassCastException e8) {
                    throw new WrongType(e8, "arg0", -2, obj5);
                }
            }
            Object obj6 = components;
            while (obj6 != LList.Empty) {
                try {
                    Pair arg06 = (Pair) obj6;
                    Object component$Mninfo3 = arg06.getCar();
                    Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                    lists.cadddr.apply1(component$Mninfo3);
                    callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                    obj6 = arg06.getCdr();
                } catch (ClassCastException e9) {
                    throw new WrongType(e9, "arg0", -2, obj6);
                }
            }
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        LList lList = symbols;
        while (lList != LList.Empty) {
            try {
                Pair arg0 = (Pair) lList;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(((Symbol) car).toString(), obj);
                    lList = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, lList);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
