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
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.VerticalArrangement;
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
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

/* compiled from: Screen1.yail */
/* loaded from: classes.dex */
public class Screen1 extends Form implements Runnable {
    static final IntNum Lit106;
    static final IntNum Lit12;
    static final SimpleSymbol Lit4;
    static final PairWithPosition Lit44;
    static final IntNum Lit53;
    static final IntNum Lit6;
    static final IntNum Lit75;
    static final IntNum Lit76;
    static final PairWithPosition Lit79;
    static final IntNum Lit90;
    static final IntNum Lit91;
    static final PairWithPosition Lit94;
    public static Screen1 Screen1;
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
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public HorizontalArrangement Head;
    public Label Label1;
    public Button Revision;
    public final ModuleMethod Revision$Click;
    public VerticalArrangement Selections;
    public Button Settings;
    public final ModuleMethod Settings$Click;
    public Label Welcome;
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
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public Button puffer0;
    public Button puffer1;
    public Button puffer2;
    public Button puffer3;
    public Button puffer4;
    public final ModuleMethod send$Mnerror;

    /* renamed from: Übung  reason: contains not printable characters */
    public Button f3bung;

    /* renamed from: Übung$Click  reason: contains not printable characters */
    public final ModuleMethod f4bung$Click;
    static final SimpleSymbol Lit121 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit120 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit119 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit118 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit117 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit116 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit115 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit114 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit113 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit112 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit111 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit110 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit109 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit108 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final FString Lit107 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit105 = IntNum.make(16);
    static final SimpleSymbol Lit104 = (SimpleSymbol) new SimpleSymbol("Label1").readResolve();
    static final FString Lit103 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit102 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit101 = IntNum.make(-1100);
    static final IntNum Lit100 = IntNum.make(16777215);
    static final IntNum Lit99 = IntNum.make(-1035);
    static final IntNum Lit98 = IntNum.make(16777215);
    static final SimpleSymbol Lit97 = (SimpleSymbol) new SimpleSymbol("puffer4").readResolve();
    static final FString Lit96 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit95 = (SimpleSymbol) new SimpleSymbol("Übung$Click").readResolve();
    static final FString Lit93 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit92 = IntNum.make(-1050);
    static final SimpleSymbol Lit89 = (SimpleSymbol) new SimpleSymbol("Übung").readResolve();
    static final FString Lit88 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit86 = IntNum.make(-2);
    static final IntNum Lit85 = IntNum.make(16777215);
    static final IntNum Lit84 = IntNum.make(-1002);
    static final IntNum Lit83 = IntNum.make(16777215);
    static final SimpleSymbol Lit82 = (SimpleSymbol) new SimpleSymbol("puffer3").readResolve();
    static final FString Lit81 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit80 = (SimpleSymbol) new SimpleSymbol("Revision$Click").readResolve();
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit77 = IntNum.make(-1050);
    static final SimpleSymbol Lit74 = (SimpleSymbol) new SimpleSymbol("Revision").readResolve();
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final IntNum Lit71 = IntNum.make(-1075);
    static final IntNum Lit70 = IntNum.make(16777215);
    static final SimpleSymbol Lit69 = (SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve();
    static final SimpleSymbol Lit68 = (SimpleSymbol) new SimpleSymbol("Selections").readResolve();
    static final FString Lit67 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit66 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit65 = IntNum.make(-1100);
    static final IntNum Lit64 = IntNum.make(16777215);
    static final IntNum Lit63 = IntNum.make(16777215);
    static final SimpleSymbol Lit62 = (SimpleSymbol) new SimpleSymbol("puffer2").readResolve();
    static final FString Lit61 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit60 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit59 = IntNum.make(-1100);
    static final IntNum Lit58 = IntNum.make(16777215);
    static final IntNum Lit57 = IntNum.make(16777215);
    static final SimpleSymbol Lit56 = (SimpleSymbol) new SimpleSymbol("puffer1").readResolve();
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit54 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit52 = IntNum.make(1);
    static final SimpleSymbol Lit51 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
    static final SimpleSymbol Lit50 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
    static final IntNum Lit49 = IntNum.make(27);
    static final SimpleSymbol Lit48 = (SimpleSymbol) new SimpleSymbol("Welcome").readResolve();
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit46 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
    static final SimpleSymbol Lit45 = (SimpleSymbol) new SimpleSymbol("Settings$Click").readResolve();
    static final FString Lit43 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit42 = (SimpleSymbol) new SimpleSymbol("Image").readResolve();
    static final IntNum Lit41 = IntNum.make(35);
    static final SimpleSymbol Lit40 = (SimpleSymbol) new SimpleSymbol("Height").readResolve();
    static final SimpleSymbol Lit39 = (SimpleSymbol) new SimpleSymbol("Settings").readResolve();
    static final FString Lit38 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit36 = IntNum.make(-1090);
    static final SimpleSymbol Lit35 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
    static final IntNum Lit34 = IntNum.make(16777215);
    static final SimpleSymbol Lit33 = (SimpleSymbol) new SimpleSymbol("TextColor").readResolve();
    static final SimpleSymbol Lit32 = (SimpleSymbol) new SimpleSymbol("ShowFeedback").readResolve();
    static final IntNum Lit31 = IntNum.make(0);
    static final SimpleSymbol Lit30 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
    static final SimpleSymbol Lit29 = (SimpleSymbol) new SimpleSymbol("Enabled").readResolve();
    static final IntNum Lit28 = IntNum.make(16777215);
    static final SimpleSymbol Lit27 = (SimpleSymbol) new SimpleSymbol("puffer0").readResolve();
    static final FString Lit26 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit25 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final IntNum Lit24 = IntNum.make(16777215);
    static final IntNum Lit23 = IntNum.make(2);
    static final SimpleSymbol Lit22 = (SimpleSymbol) new SimpleSymbol("Head").readResolve();
    static final FString Lit21 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("VersionName").readResolve();
    static final SimpleSymbol Lit19 = (SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
    static final SimpleSymbol Lit17 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
    static final SimpleSymbol Lit16 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
    static final SimpleSymbol Lit15 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
    static final SimpleSymbol Lit14 = (SimpleSymbol) new SimpleSymbol("Scrollable").readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol) new SimpleSymbol("Icon").readResolve();
    static final SimpleSymbol Lit11 = (SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol) new SimpleSymbol("AppName").readResolve();
    static final IntNum Lit9 = IntNum.make(3);
    static final SimpleSymbol Lit8 = (SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol) new SimpleSymbol("AccentColor").readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol) new SimpleSymbol("AboutScreen").readResolve();
    static final SimpleSymbol Lit2 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
    static final SimpleSymbol Lit0 = (SimpleSymbol) new SimpleSymbol("Screen1").readResolve();

    static {
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit106 = IntNum.make(iArr);
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit4 = simpleSymbol;
        Lit94 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Screen1.yail", 700495);
        int[] iArr2 = new int[2];
        iArr2[0] = -1;
        Lit91 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -7829368;
        Lit90 = IntNum.make(iArr3);
        Lit79 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Screen1.yail", 561231);
        int[] iArr4 = new int[2];
        iArr4[0] = -1;
        Lit76 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -7829368;
        Lit75 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit53 = IntNum.make(iArr6);
        Lit44 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Screen1.yail", 254031);
        int[] iArr7 = new int[2];
        iArr7[0] = -13684426;
        Lit12 = IntNum.make(iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = -16711681;
        Lit6 = IntNum.make(iArr8);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit108, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit109, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit110, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit111, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit112, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit113, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit114, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit115, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit116, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit117, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit118, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit119, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit120, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit121, 8194);
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
        this.Settings$Click = new ModuleMethod(frameVar, 27, Lit45, 0);
        lambda$Fn9 = new ModuleMethod(frameVar, 28, null, 0);
        lambda$Fn10 = new ModuleMethod(frameVar, 29, null, 0);
        lambda$Fn11 = new ModuleMethod(frameVar, 30, null, 0);
        lambda$Fn12 = new ModuleMethod(frameVar, 31, null, 0);
        lambda$Fn13 = new ModuleMethod(frameVar, 32, null, 0);
        lambda$Fn14 = new ModuleMethod(frameVar, 33, null, 0);
        lambda$Fn15 = new ModuleMethod(frameVar, 34, null, 0);
        lambda$Fn16 = new ModuleMethod(frameVar, 35, null, 0);
        lambda$Fn17 = new ModuleMethod(frameVar, 36, null, 0);
        lambda$Fn18 = new ModuleMethod(frameVar, 37, null, 0);
        this.Revision$Click = new ModuleMethod(frameVar, 38, Lit80, 0);
        lambda$Fn19 = new ModuleMethod(frameVar, 39, null, 0);
        lambda$Fn20 = new ModuleMethod(frameVar, 40, null, 0);
        lambda$Fn21 = new ModuleMethod(frameVar, 41, null, 0);
        lambda$Fn22 = new ModuleMethod(frameVar, 42, null, 0);
        this.f4bung$Click = new ModuleMethod(frameVar, 43, Lit95, 0);
        lambda$Fn23 = new ModuleMethod(frameVar, 44, null, 0);
        lambda$Fn24 = new ModuleMethod(frameVar, 45, null, 0);
        lambda$Fn25 = new ModuleMethod(frameVar, 46, null, 0);
        lambda$Fn26 = new ModuleMethod(frameVar, 47, null, 0);
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
        Screen1 = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Home Screen der App", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie App", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "SArCaSm_icon.jpg", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit14, Boolean.TRUE, Lit15);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Boolean.TRUE, Lit15);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Startscreen", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.FALSE, Lit15);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "1.0.1", Lit4), $result);
        } else {
            addToFormDoAfterCreation(new Promise(lambda$Fn2));
        }
        this.Head = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit21, Lit22, lambda$Fn3), $result);
        } else {
            addToComponents(Lit0, Lit25, Lit22, lambda$Fn4);
        }
        this.puffer0 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit22, Lit26, Lit27, lambda$Fn5), $result);
        } else {
            addToComponents(Lit22, Lit37, Lit27, lambda$Fn6);
        }
        this.Settings = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit22, Lit38, Lit39, lambda$Fn7), $result);
        } else {
            addToComponents(Lit22, Lit43, Lit39, lambda$Fn8);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit45, this.Settings$Click);
        } else {
            addToFormEnvironment(Lit45, this.Settings$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Settings", "Click");
        } else {
            addToEvents(Lit39, Lit46);
        }
        this.Welcome = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit47, Lit48, lambda$Fn9), $result);
        } else {
            addToComponents(Lit0, Lit54, Lit48, lambda$Fn10);
        }
        this.puffer1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit55, Lit56, lambda$Fn11), $result);
        } else {
            addToComponents(Lit0, Lit60, Lit56, lambda$Fn12);
        }
        this.puffer2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit61, Lit62, lambda$Fn13), $result);
        } else {
            addToComponents(Lit0, Lit66, Lit62, lambda$Fn14);
        }
        this.Selections = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit67, Lit68, lambda$Fn15), $result);
        } else {
            addToComponents(Lit0, Lit72, Lit68, lambda$Fn16);
        }
        this.Revision = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit68, Lit73, Lit74, lambda$Fn17), $result);
        } else {
            addToComponents(Lit68, Lit78, Lit74, lambda$Fn18);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit80, this.Revision$Click);
        } else {
            addToFormEnvironment(Lit80, this.Revision$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Revision", "Click");
        } else {
            addToEvents(Lit74, Lit46);
        }
        this.puffer3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit68, Lit81, Lit82, lambda$Fn19), $result);
        } else {
            addToComponents(Lit68, Lit87, Lit82, lambda$Fn20);
        }
        this.f3bung = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit68, Lit88, Lit89, lambda$Fn21), $result);
        } else {
            addToComponents(Lit68, Lit93, Lit89, lambda$Fn22);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit95, this.f4bung$Click);
        } else {
            addToFormEnvironment(Lit95, this.f4bung$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Übung", "Click");
        } else {
            addToEvents(Lit89, Lit46);
        }
        this.puffer4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit96, Lit97, lambda$Fn23), $result);
        } else {
            addToComponents(Lit0, Lit102, Lit97, lambda$Fn24);
        }
        this.Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit103, Lit104, lambda$Fn25), $result);
        } else {
            addToComponents(Lit0, Lit107, Lit104, lambda$Fn26);
        }
        runtime.initRuntime();
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Home Screen der App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "SArCaSm_icon.jpg", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit14, Boolean.TRUE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Boolean.TRUE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Startscreen", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.FALSE, Lit15);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "1.0.1", Lit4);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit22, Lit8, Lit23, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit22, Lit11, Lit24, Lit7);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit22, Lit8, Lit23, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit22, Lit11, Lit24, Lit7);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit27, Lit11, Lit28, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit33, Lit34, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit35, Lit36, Lit7);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit27, Lit11, Lit28, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit33, Lit34, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit35, Lit36, Lit7);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit39, Lit40, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit42, "A63F8C7C-B78A-4280-820C-B101FC898124.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit39, Lit35, Lit41, Lit7);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit39, Lit40, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit39, Lit42, "A63F8C7C-B78A-4280-820C-B101FC898124.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit39, Lit35, Lit41, Lit7);
    }

    public Object Settings$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Settings"), Lit44, "open another screen");
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit30, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit50, "Willkommen in der Chemie-App!", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit51, Lit52, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit33, Lit53, Lit7);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit30, Lit49, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit50, "Willkommen in der Chemie-App!", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit51, Lit52, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit33, Lit53, Lit7);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit11, Lit57, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit33, Lit58, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit35, Lit59, Lit7);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit11, Lit57, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit33, Lit58, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit35, Lit59, Lit7);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit11, Lit63, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit33, Lit64, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit35, Lit65, Lit7);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit11, Lit63, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit33, Lit64, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit35, Lit65, Lit7);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit69, Lit23, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit11, Lit70, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit35, Lit71, Lit7);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit69, Lit23, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit11, Lit70, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit35, Lit71, Lit7);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit11, Lit75, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit50, "Lernen", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit33, Lit76, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit35, Lit77, Lit7);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit11, Lit75, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit50, "Lernen", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit33, Lit76, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit35, Lit77, Lit7);
    }

    public Object Revision$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Revision"), Lit79, "open another screen");
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit11, Lit83, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit40, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit33, Lit85, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit35, Lit86, Lit7);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit82, Lit11, Lit83, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit40, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit82, Lit33, Lit85, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit82, Lit35, Lit86, Lit7);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit89, Lit11, Lit90, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit50, "Übung", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit33, Lit91, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit89, Lit35, Lit92, Lit7);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit89, Lit11, Lit90, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit50, "Übung", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit33, Lit91, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit89, Lit35, Lit92, Lit7);
    }

    /* renamed from: Übung$Click  reason: contains not printable characters */
    public Object m0bung$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Exercise"), Lit94, "open another screen");
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit97, Lit11, Lit98, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit40, Lit99, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit33, Lit100, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit97, Lit35, Lit101, Lit7);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit97, Lit11, Lit98, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit29, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit30, Lit31, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit40, Lit99, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit32, Boolean.FALSE, Lit15);
        runtime.setAndCoerceProperty$Ex(Lit97, Lit33, Lit100, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit97, Lit35, Lit101, Lit7);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit104, Lit30, Lit105, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit104, Lit50, "©Liam Kauper 2021", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit33, Lit106, Lit7);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit104, Lit30, Lit105, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit104, Lit50, "©Liam Kauper 2021", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit33, Lit106, Lit7);
    }

    /* compiled from: Screen1.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Screen1 $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Screen1)) {
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
                    if (!(obj instanceof Screen1)) {
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
                    if (!(obj instanceof Screen1)) {
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
                    if (!(obj instanceof Screen1)) {
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
                    Screen1 screen1 = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    screen1.dispatchGenericEvent(component, str, z, (Object[]) obj4);
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
                    return Screen1.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Screen1.lambda3();
                case 21:
                    return Screen1.lambda4();
                case 22:
                    return Screen1.lambda5();
                case 23:
                    return Screen1.lambda6();
                case 24:
                    return Screen1.lambda7();
                case 25:
                    return Screen1.lambda8();
                case 26:
                    return Screen1.lambda9();
                case 27:
                    return this.$main.Settings$Click();
                case 28:
                    return Screen1.lambda10();
                case 29:
                    return Screen1.lambda11();
                case 30:
                    return Screen1.lambda12();
                case 31:
                    return Screen1.lambda13();
                case 32:
                    return Screen1.lambda14();
                case 33:
                    return Screen1.lambda15();
                case 34:
                    return Screen1.lambda16();
                case 35:
                    return Screen1.lambda17();
                case 36:
                    return Screen1.lambda18();
                case 37:
                    return Screen1.lambda19();
                case 38:
                    return this.$main.Revision$Click();
                case 39:
                    return Screen1.lambda20();
                case 40:
                    return Screen1.lambda21();
                case 41:
                    return Screen1.lambda22();
                case 42:
                    return Screen1.lambda23();
                case 43:
                    return this.$main.m0bung$Click();
                case 44:
                    return Screen1.lambda24();
                case 45:
                    return Screen1.lambda25();
                case 46:
                    return Screen1.lambda26();
                case 47:
                    return Screen1.lambda27();
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
        Screen1 = this;
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
