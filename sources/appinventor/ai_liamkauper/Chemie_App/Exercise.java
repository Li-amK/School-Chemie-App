package appinventor.ai_liamkauper.Chemie_App;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.CheckBox;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
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

/* compiled from: Exercise.yail */
/* loaded from: classes.dex */
public class Exercise extends Form implements Runnable {
    public static Exercise Exercise;
    static final IntNum Lit103;
    static final IntNum Lit104;
    static final PairWithPosition Lit112;
    static final PairWithPosition Lit114;
    static final PairWithPosition Lit118;
    static final PairWithPosition Lit119;
    static final IntNum Lit12;
    static final PairWithPosition Lit122;
    static final PairWithPosition Lit123;
    static final PairWithPosition Lit126;
    static final PairWithPosition Lit127;
    static final PairWithPosition Lit131;
    static final PairWithPosition Lit132;
    static final PairWithPosition Lit136;
    static final PairWithPosition Lit137;
    static final SimpleSymbol Lit14;
    static final IntNum Lit142;
    static final IntNum Lit143;
    static final PairWithPosition Lit155;
    static final IntNum Lit35;
    static final SimpleSymbol Lit4;
    static final IntNum Lit51;
    static final IntNum Lit6;
    static final IntNum Lit67;
    static final IntNum Lit77;
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
    public final ModuleMethod Exercise$Initialize;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public Label aufgabe;
    public Button check;
    public final ModuleMethod check$Click;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public Notifier feedback;
    public final ModuleMethod feedback$AfterChoosing;
    public final ModuleMethod feedback$ChoosingCanceled;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public Label information;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;

    /* renamed from: lösungsfeld  reason: contains not printable characters */
    public TextBox f0lsungsfeld;
    public CheckBox nebenrechnung;
    public final ModuleMethod nebenrechnung$Changed;
    public TextBox nebenrechnung_notizen;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public Button puffer0;
    public Button puffer1;
    public Button puffer2;
    public Button puffer3;
    public Button puffer4;
    public final ModuleMethod send$Mnerror;
    public Button skip;
    public final ModuleMethod skip$Click;
    static final SimpleSymbol Lit173 = (SimpleSymbol) new SimpleSymbol("list").readResolve();
    static final SimpleSymbol Lit172 = (SimpleSymbol) new SimpleSymbol("any").readResolve();
    static final SimpleSymbol Lit171 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit170 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit169 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit168 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit167 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit166 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit165 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit164 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit163 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit162 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit161 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit160 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit159 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit158 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final SimpleSymbol Lit157 = (SimpleSymbol) new SimpleSymbol("ChoosingCanceled").readResolve();
    static final SimpleSymbol Lit156 = (SimpleSymbol) new SimpleSymbol("feedback$ChoosingCanceled").readResolve();
    static final SimpleSymbol Lit154 = (SimpleSymbol) new SimpleSymbol("AfterChoosing").readResolve();
    static final SimpleSymbol Lit153 = (SimpleSymbol) new SimpleSymbol("feedback$AfterChoosing").readResolve();
    static final PairWithPosition Lit152 = PairWithPosition.make(Lit173, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910924);
    static final PairWithPosition Lit151 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910900), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910896), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910892), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910888), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910884), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 910879);
    static final FString Lit150 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit149 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit148 = (SimpleSymbol) new SimpleSymbol("skip$Click").readResolve();
    static final PairWithPosition Lit147 = PairWithPosition.make(Lit173, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882372);
    static final PairWithPosition Lit146 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882348), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882344), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882340), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882336), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882332), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 882327);
    static final FString Lit145 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit144 = IntNum.make(-1050);
    static final SimpleSymbol Lit141 = (SimpleSymbol) new SimpleSymbol("skip").readResolve();
    static final FString Lit140 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit139 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
    static final SimpleSymbol Lit138 = (SimpleSymbol) new SimpleSymbol("check$Click").readResolve();
    static final PairWithPosition Lit135 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824593), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824588);
    static final PairWithPosition Lit134 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824458), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824453);
    static final PairWithPosition Lit133 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824288), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824283);
    static final PairWithPosition Lit130 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823639), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823634);
    static final PairWithPosition Lit129 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823527), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823522);
    static final PairWithPosition Lit128 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823385), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823380);
    static final PairWithPosition Lit125 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822743), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822738);
    static final PairWithPosition Lit124 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822618), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822613);
    static final PairWithPosition Lit121 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821996), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821991);
    static final PairWithPosition Lit120 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821868), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821863);
    static final PairWithPosition Lit117 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821246), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821241);
    static final PairWithPosition Lit116 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821133), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821128);
    static final PairWithPosition Lit115 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820990), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820985);
    static final SimpleSymbol Lit113 = (SimpleSymbol) new SimpleSymbol("ShowMessageDialog").readResolve();
    static final SimpleSymbol Lit111 = (SimpleSymbol) new SimpleSymbol("ShowChooseDialog").readResolve();
    static final SimpleSymbol Lit110 = (SimpleSymbol) new SimpleSymbol("feedback").readResolve();
    static final PairWithPosition Lit109 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820173), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820168);
    static final PairWithPosition Lit108 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820059), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820054);
    static final PairWithPosition Lit107 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 819915), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 819910);
    static final FString Lit106 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit105 = IntNum.make(-1050);
    static final SimpleSymbol Lit102 = (SimpleSymbol) new SimpleSymbol("check").readResolve();
    static final FString Lit101 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit100 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit99 = IntNum.make(-1100);
    static final IntNum Lit98 = IntNum.make(16777215);
    static final IntNum Lit97 = IntNum.make(-1002);
    static final IntNum Lit96 = IntNum.make(16777215);
    static final SimpleSymbol Lit95 = (SimpleSymbol) new SimpleSymbol("puffer4").readResolve();
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit93 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final IntNum Lit92 = IntNum.make(-1090);
    static final SimpleSymbol Lit91 = (SimpleSymbol) new SimpleSymbol("lösungsfeld").readResolve();
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit89 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit88 = IntNum.make(-1100);
    static final IntNum Lit87 = IntNum.make(16777215);
    static final IntNum Lit86 = IntNum.make(-1002);
    static final IntNum Lit85 = IntNum.make(16777215);
    static final SimpleSymbol Lit84 = (SimpleSymbol) new SimpleSymbol("puffer3").readResolve();
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit82 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final IntNum Lit81 = IntNum.make(-1090);
    static final SimpleSymbol Lit80 = (SimpleSymbol) new SimpleSymbol("MultiLine").readResolve();
    static final SimpleSymbol Lit79 = (SimpleSymbol) new SimpleSymbol("Hint").readResolve();
    static final IntNum Lit78 = IntNum.make(-1020);
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit75 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit74 = IntNum.make(-1100);
    static final IntNum Lit73 = IntNum.make(16777215);
    static final IntNum Lit72 = IntNum.make(-1002);
    static final IntNum Lit71 = IntNum.make(16777215);
    static final SimpleSymbol Lit70 = (SimpleSymbol) new SimpleSymbol("puffer2").readResolve();
    static final FString Lit69 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit66 = IntNum.make(15);
    static final FString Lit65 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit64 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit63 = IntNum.make(-1100);
    static final IntNum Lit62 = IntNum.make(16777215);
    static final IntNum Lit61 = IntNum.make(-1001);
    static final IntNum Lit60 = IntNum.make(16777215);
    static final SimpleSymbol Lit59 = (SimpleSymbol) new SimpleSymbol("puffer1").readResolve();
    static final FString Lit58 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit57 = (SimpleSymbol) new SimpleSymbol("Changed").readResolve();
    static final SimpleSymbol Lit56 = (SimpleSymbol) new SimpleSymbol("nebenrechnung$Changed").readResolve();
    static final PairWithPosition Lit55 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 278843), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 278838);
    static final PairWithPosition Lit54 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 278639), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 278634);
    static final SimpleSymbol Lit53 = (SimpleSymbol) new SimpleSymbol("Checked").readResolve();
    static final FString Lit52 = new FString("com.google.appinventor.components.runtime.CheckBox");
    static final SimpleSymbol Lit50 = (SimpleSymbol) new SimpleSymbol("nebenrechnung").readResolve();
    static final FString Lit49 = new FString("com.google.appinventor.components.runtime.CheckBox");
    static final FString Lit48 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit47 = IntNum.make(-1100);
    static final SimpleSymbol Lit46 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
    static final IntNum Lit45 = IntNum.make(16777215);
    static final SimpleSymbol Lit44 = (SimpleSymbol) new SimpleSymbol("ShowFeedback").readResolve();
    static final IntNum Lit43 = IntNum.make(-1001);
    static final SimpleSymbol Lit42 = (SimpleSymbol) new SimpleSymbol("Height").readResolve();
    static final IntNum Lit41 = IntNum.make(0);
    static final SimpleSymbol Lit40 = (SimpleSymbol) new SimpleSymbol("Enabled").readResolve();
    static final IntNum Lit39 = IntNum.make(16777215);
    static final SimpleSymbol Lit38 = (SimpleSymbol) new SimpleSymbol("puffer0").readResolve();
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit34 = (SimpleSymbol) new SimpleSymbol("TextColor").readResolve();
    static final IntNum Lit33 = IntNum.make(1);
    static final SimpleSymbol Lit32 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
    static final SimpleSymbol Lit31 = (SimpleSymbol) new SimpleSymbol("HTMLFormat").readResolve();
    static final IntNum Lit30 = IntNum.make(16);
    static final SimpleSymbol Lit29 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
    static final SimpleSymbol Lit28 = (SimpleSymbol) new SimpleSymbol("information").readResolve();
    static final FString Lit27 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit26 = (SimpleSymbol) new SimpleSymbol("Initialize").readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol) new SimpleSymbol("Exercise$Initialize").readResolve();
    static final PairWithPosition Lit24 = PairWithPosition.make(Lit173, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95886);
    static final PairWithPosition Lit23 = PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, PairWithPosition.make(Lit172, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95862), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95858), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95854), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95850), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95846), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 95841);
    static final SimpleSymbol Lit22 = (SimpleSymbol) new SimpleSymbol("Visible").readResolve();
    static final SimpleSymbol Lit21 = (SimpleSymbol) new SimpleSymbol("nebenrechnung_notizen").readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
    static final SimpleSymbol Lit19 = (SimpleSymbol) new SimpleSymbol("aufgabe").readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve();
    static final SimpleSymbol Lit17 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
    static final SimpleSymbol Lit16 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
    static final SimpleSymbol Lit15 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol) new SimpleSymbol("Scrollable").readResolve();
    static final SimpleSymbol Lit11 = (SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol) new SimpleSymbol("AppName").readResolve();
    static final IntNum Lit9 = IntNum.make(3);
    static final SimpleSymbol Lit8 = (SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol) new SimpleSymbol("AccentColor").readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol) new SimpleSymbol("AboutScreen").readResolve();
    static final SimpleSymbol Lit2 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
    static final SimpleSymbol Lit0 = (SimpleSymbol) new SimpleSymbol("Exercise").readResolve();

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit4 = simpleSymbol;
        Lit155 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 917582);
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit143 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -7829368;
        Lit142 = IntNum.make(iArr2);
        Lit137 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 825050), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 825045), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 825039);
        SimpleSymbol simpleSymbol2 = Lit4;
        SimpleSymbol simpleSymbol3 = Lit4;
        SimpleSymbol simpleSymbol4 = Lit4;
        SimpleSymbol simpleSymbol5 = Lit4;
        SimpleSymbol simpleSymbol6 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit14 = simpleSymbol6;
        Lit136 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol6, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824790), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824785), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824780), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824775), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824769);
        Lit132 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824079), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824074), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 824068);
        Lit131 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823836), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823831), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823826), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823821), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823815);
        Lit127 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823166), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823161), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 823155);
        Lit126 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822939), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822934), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822929), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822924), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822918);
        Lit123 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822422), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822417), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822411);
        Lit122 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822192), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822187), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822182), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822177), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 822171);
        Lit119 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821688), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821683), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821677);
        Lit118 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821443), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821438), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821433), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821428), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 821422);
        Lit114 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820617), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820612), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820606);
        Lit112 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820370), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820365), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820360), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820355), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Exercise.yail", 820349);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit104 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -7829368;
        Lit103 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -1;
        Lit77 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit67 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -1;
        Lit51 = IntNum.make(iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = -1;
        Lit35 = IntNum.make(iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = -13684426;
        Lit12 = IntNum.make(iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = -16711681;
        Lit6 = IntNum.make(iArr10);
    }

    public Exercise() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit158, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit159, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit160, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit161, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit162, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit163, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit164, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit165, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit166, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit167, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit168, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit169, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit170, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit171, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frameVar, 18, null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:622");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frameVar, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frameVar, 20, null, 0);
        this.Exercise$Initialize = new ModuleMethod(frameVar, 21, Lit25, 0);
        lambda$Fn3 = new ModuleMethod(frameVar, 22, null, 0);
        lambda$Fn4 = new ModuleMethod(frameVar, 23, null, 0);
        lambda$Fn5 = new ModuleMethod(frameVar, 24, null, 0);
        lambda$Fn6 = new ModuleMethod(frameVar, 25, null, 0);
        lambda$Fn7 = new ModuleMethod(frameVar, 26, null, 0);
        lambda$Fn8 = new ModuleMethod(frameVar, 27, null, 0);
        this.nebenrechnung$Changed = new ModuleMethod(frameVar, 28, Lit56, 0);
        lambda$Fn9 = new ModuleMethod(frameVar, 29, null, 0);
        lambda$Fn10 = new ModuleMethod(frameVar, 30, null, 0);
        lambda$Fn11 = new ModuleMethod(frameVar, 31, null, 0);
        lambda$Fn12 = new ModuleMethod(frameVar, 32, null, 0);
        lambda$Fn13 = new ModuleMethod(frameVar, 33, null, 0);
        lambda$Fn14 = new ModuleMethod(frameVar, 34, null, 0);
        lambda$Fn15 = new ModuleMethod(frameVar, 35, null, 0);
        lambda$Fn16 = new ModuleMethod(frameVar, 36, null, 0);
        lambda$Fn17 = new ModuleMethod(frameVar, 37, null, 0);
        lambda$Fn18 = new ModuleMethod(frameVar, 38, null, 0);
        lambda$Fn19 = new ModuleMethod(frameVar, 39, null, 0);
        lambda$Fn20 = new ModuleMethod(frameVar, 40, null, 0);
        lambda$Fn21 = new ModuleMethod(frameVar, 41, null, 0);
        lambda$Fn22 = new ModuleMethod(frameVar, 42, null, 0);
        lambda$Fn23 = new ModuleMethod(frameVar, 43, null, 0);
        lambda$Fn24 = new ModuleMethod(frameVar, 44, null, 0);
        lambda$Fn25 = new ModuleMethod(frameVar, 45, null, 0);
        lambda$Fn26 = new ModuleMethod(frameVar, 46, null, 0);
        lambda$Fn27 = new ModuleMethod(frameVar, 47, null, 0);
        lambda$Fn28 = new ModuleMethod(frameVar, 48, null, 0);
        lambda$Fn29 = new ModuleMethod(frameVar, 49, null, 0);
        lambda$Fn30 = new ModuleMethod(frameVar, 50, null, 0);
        lambda$Fn31 = new ModuleMethod(frameVar, 51, null, 0);
        lambda$Fn32 = new ModuleMethod(frameVar, 52, null, 0);
        this.check$Click = new ModuleMethod(frameVar, 53, Lit138, 0);
        lambda$Fn33 = new ModuleMethod(frameVar, 54, null, 0);
        lambda$Fn34 = new ModuleMethod(frameVar, 55, null, 0);
        this.skip$Click = new ModuleMethod(frameVar, 56, Lit148, 0);
        this.feedback$AfterChoosing = new ModuleMethod(frameVar, 57, Lit153, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.feedback$ChoosingCanceled = new ModuleMethod(frameVar, 58, Lit156, 0);
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
        Exercise = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Randomised exercises to current topics", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie_App", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Responsive", Lit4);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Exercise", Lit4);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.FALSE, Lit14), $result);
        } else {
            addToFormDoAfterCreation(new Promise(lambda$Fn2));
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit25, this.Exercise$Initialize);
        } else {
            addToFormEnvironment(Lit25, this.Exercise$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Exercise", "Initialize");
        } else {
            addToEvents(Lit0, Lit26);
        }
        this.information = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit27, Lit28, lambda$Fn3), $result);
        } else {
            addToComponents(Lit0, Lit36, Lit28, lambda$Fn4);
        }
        this.puffer0 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit37, Lit38, lambda$Fn5), $result);
        } else {
            addToComponents(Lit0, Lit48, Lit38, lambda$Fn6);
        }
        this.nebenrechnung = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit49, Lit50, lambda$Fn7), $result);
        } else {
            addToComponents(Lit0, Lit52, Lit50, lambda$Fn8);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit56, this.nebenrechnung$Changed);
        } else {
            addToFormEnvironment(Lit56, this.nebenrechnung$Changed);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "nebenrechnung", "Changed");
        } else {
            addToEvents(Lit50, Lit57);
        }
        this.puffer1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit58, Lit59, lambda$Fn9), $result);
        } else {
            addToComponents(Lit0, Lit64, Lit59, lambda$Fn10);
        }
        this.aufgabe = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit65, Lit19, lambda$Fn11), $result);
        } else {
            addToComponents(Lit0, Lit68, Lit19, lambda$Fn12);
        }
        this.puffer2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit69, Lit70, lambda$Fn13), $result);
        } else {
            addToComponents(Lit0, Lit75, Lit70, lambda$Fn14);
        }
        this.nebenrechnung_notizen = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit76, Lit21, lambda$Fn15), $result);
        } else {
            addToComponents(Lit0, Lit82, Lit21, lambda$Fn16);
        }
        this.puffer3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit83, Lit84, lambda$Fn17), $result);
        } else {
            addToComponents(Lit0, Lit89, Lit84, lambda$Fn18);
        }
        this.f0lsungsfeld = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit90, Lit91, lambda$Fn19), $result);
        } else {
            addToComponents(Lit0, Lit93, Lit91, lambda$Fn20);
        }
        this.puffer4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit94, Lit95, lambda$Fn21), $result);
        } else {
            addToComponents(Lit0, Lit100, Lit95, lambda$Fn22);
        }
        this.check = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit101, Lit102, lambda$Fn23), $result);
        } else {
            addToComponents(Lit0, Lit106, Lit102, lambda$Fn24);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit138, this.check$Click);
        } else {
            addToFormEnvironment(Lit138, this.check$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "check", "Click");
        } else {
            addToEvents(Lit102, Lit139);
        }
        this.skip = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit140, Lit141, lambda$Fn33), $result);
        } else {
            addToComponents(Lit0, Lit145, Lit141, lambda$Fn34);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit148, this.skip$Click);
        } else {
            addToFormEnvironment(Lit148, this.skip$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "skip", "Click");
        } else {
            addToEvents(Lit141, Lit139);
        }
        this.feedback = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit149, Lit110, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit150, Lit110, Boolean.FALSE);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit153, this.feedback$AfterChoosing);
        } else {
            addToFormEnvironment(Lit153, this.feedback$AfterChoosing);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "feedback", "AfterChoosing");
        } else {
            addToEvents(Lit110, Lit154);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit156, this.feedback$ChoosingCanceled);
        } else {
            addToFormEnvironment(Lit156, this.feedback$ChoosingCanceled);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "feedback", "ChoosingCanceled");
        } else {
            addToEvents(Lit110, Lit157);
        }
        runtime.initRuntime();
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Randomised exercises to current topics", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie_App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Responsive", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Exercise", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.FALSE, Lit14);
    }

    public Object Exercise$Initialize() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit19, Lit20, "", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit20, "", Lit4);
        SimpleSymbol simpleSymbol = Lit19;
        SimpleSymbol simpleSymbol2 = Lit20;
        ModuleMethod moduleMethod = runtime.yail$Mnlist$Mnpick$Mnrandom;
        ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
        Pair list1 = LList.list1(" Airbags sind mit dem Feststoff Natriumazid <b>(NaN<sub>3</sub>)</b> gefüllt, bei einem Autounfall wird durch einen Stromimpuls eine Anzündeeinheit ausgelöst. Diese Anzündeeinheit startet die Zersetzungsreaktion von <b>Natriumazid zu Stickstoff und Natrium</b>. Der Gasförmige Stickstoff nimmt sehr viel mehr Raum ein als das feste Natriumazid, dadurch breitet sich der Airbag schnell aus und bildet so das Kissen was Autoinsassen bei einem Unfall schützen kann.<br>  Wie viel Natriumazid wird unter Normalbedingungen für die Bildung von 60 Liter Stickstoff im Airbag gebraucht?");
        LList.chain1(LList.chain4(list1, " Bei der Durchführung des Thermitverfahrens reagieren Aluminium und Eisen(III)oxid zu Aluminiumoxid und Eisen. Um zwei Straßenbahnschienen miteinander zu verbinden braucht man 500 Gramm Eisen.<br> Wieviel Gramm Eisen(III)oxid ist hierfür erforderlich?", "Wie viel NaCl-Moleküle sind in einer Prise Salz (3 Gramm) enthalten?", "Welches Volumen nimmt eine Stoffmenge von 5,32 mol eines Gases unter Normbedingungen ein?", "Berechne die benötigte Masse an Aluminiumoxid (in kg) zur Herstellung eines acht Kilogramm schweren Fahrradrahmens."), "Ermittle die jeweils benötigte Masse an Eisen und Schwefel, um 20 Gramm Eisensulfid herzustellen.");
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, list1, Lit23, "make a list")), Lit24, "pick random item"), Lit4);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Lit30, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit31, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit20, "Willkommen zur <b>Übungs-Sektion!</b><br> Hier werden randomisiert Aufgaben zur <b>Stoffmenge</b>, <b>Atommasse</b>, <b>Molares Volumen</b> und zur <b>Molaren Masse</b> gestellt.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit32, Lit33, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit34, Lit35, Lit7);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Lit30, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit31, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit20, "Willkommen zur <b>Übungs-Sektion!</b><br> Hier werden randomisiert Aufgaben zur <b>Stoffmenge</b>, <b>Atommasse</b>, <b>Molares Volumen</b> und zur <b>Molaren Masse</b> gestellt.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit32, Lit33, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit34, Lit35, Lit7);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit11, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit42, Lit43, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit34, Lit45, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit46, Lit47, Lit7);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit11, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit42, Lit43, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit34, Lit45, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit46, Lit47, Lit7);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit50, Lit20, "Platz für Nebenrechnungen/Notizen anzeigen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit50, Lit34, Lit51, Lit7);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit50, Lit20, "Platz für Nebenrechnungen/Notizen anzeigen", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit50, Lit34, Lit51, Lit7);
    }

    public Object nebenrechnung$Changed() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit50, Lit53), Boolean.TRUE), Lit54, "=") != Boolean.FALSE) {
            return runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.TRUE, Lit14);
        }
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit50, Lit53), Boolean.FALSE), Lit55, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.FALSE, Lit14) : Values.empty;
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit59, Lit11, Lit60, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit42, Lit61, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit34, Lit62, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit59, Lit46, Lit63, Lit7);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit59, Lit11, Lit60, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit42, Lit61, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit34, Lit62, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit59, Lit46, Lit63, Lit7);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit29, Lit66, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit31, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit20, "Hier wird gleich ne Aufgabe stehen.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit32, Lit33, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit34, Lit67, Lit7);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit29, Lit66, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit31, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit20, "Hier wird gleich ne Aufgabe stehen.", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit32, Lit33, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit34, Lit67, Lit7);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit70, Lit11, Lit71, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit42, Lit72, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit34, Lit73, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit46, Lit74, Lit7);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit70, Lit11, Lit71, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit42, Lit72, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit70, Lit34, Lit73, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit46, Lit74, Lit7);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit11, Lit77, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit42, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit79, "Hier kannst du Nebenrechnungen/Notizen schreiben", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit80, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit46, Lit81, Lit7);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit11, Lit77, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit42, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit79, "Hier kannst du Nebenrechnungen/Notizen schreiben", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit80, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit46, Lit81, Lit7);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit84, Lit11, Lit85, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit42, Lit86, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit34, Lit87, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit84, Lit46, Lit88, Lit7);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit84, Lit11, Lit85, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit42, Lit86, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit84, Lit34, Lit87, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit84, Lit46, Lit88, Lit7);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit79, "Lösung hier eingeben", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit46, Lit92, Lit7);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit79, "Lösung hier eingeben", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit46, Lit92, Lit7);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit95, Lit11, Lit96, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit42, Lit97, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit34, Lit98, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit95, Lit46, Lit99, Lit7);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit95, Lit11, Lit96, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit40, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit29, Lit41, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit42, Lit97, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit44, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit34, Lit98, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit95, Lit46, Lit99, Lit7);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit102, Lit11, Lit103, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit102, Lit20, "Lösung überprüfen", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit102, Lit34, Lit104, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit102, Lit46, Lit105, Lit7);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit102, Lit11, Lit103, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit102, Lit20, "Lösung überprüfen", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit102, Lit34, Lit104, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit102, Lit46, Lit105, Lit7);
    }

    public Object check$Click() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), " Airbags sind mit dem Feststoff Natriumazid <b>(NaN<sub>3</sub>)</b> gefüllt, bei einem Autounfall wird durch einen Stromimpuls eine Anzündeeinheit ausgelöst. Diese Anzündeeinheit startet die Zersetzungsreaktion von <b>Natriumazid zu Stickstoff und Natrium</b>. Der Gasförmige Stickstoff nimmt sehr viel mehr Raum ein als das feste Natriumazid, dadurch breitet sich der Airbag schnell aus und bildet so das Kissen was Autoinsassen bei einem Unfall schützen kann.<br>  Wie viel Natriumazid wird unter Normalbedingungen für die Bildung von 60 Liter Stickstoff im Airbag gebraucht?"), Lit107, "=") != Boolean.FALSE) {
            if (runtime.processOrDelayed$V(new Object[]{lambda$Fn25, lambda$Fn26}) != Boolean.FALSE) {
                SimpleSymbol simpleSymbol = Lit110;
                SimpleSymbol simpleSymbol2 = Lit111;
                Pair list1 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
                LList.chain4(list1, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
                runtime.callComponentMethod(simpleSymbol, simpleSymbol2, list1, Lit112);
            } else {
                runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (xxx,xx Gramm oder xxx,xxg)", "Leider Falsch!", "Okay"), Lit114);
            }
        }
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), " Bei der Durchführung des Thermitverfahrens reagieren Aluminium und Eisen(III)oxid zu Aluminiumoxid und Eisen. Um zwei Straßenbahnschienen miteinander zu verbinden braucht man 500 Gramm Eisen.<br> Wieviel Gramm Eisen(III)oxid ist hierfür erforderlich?"), Lit115, "=") != Boolean.FALSE) {
            if (runtime.processOrDelayed$V(new Object[]{lambda$Fn27, lambda$Fn28}) != Boolean.FALSE) {
                SimpleSymbol simpleSymbol3 = Lit110;
                SimpleSymbol simpleSymbol4 = Lit111;
                Pair list12 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
                LList.chain4(list12, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
                runtime.callComponentMethod(simpleSymbol3, simpleSymbol4, list12, Lit118);
            } else {
                runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (xxx,x Gramm oder xxx,xg)", "Leider Falsch!", "Okay"), Lit119);
            }
        }
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), "Wie viel NaCl-Moleküle sind in einer Prise Salz (3 Gramm) enthalten?"), Lit120, "=") != Boolean.FALSE) {
            if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "0,05 mol"), Lit121, "=") != Boolean.FALSE) {
                SimpleSymbol simpleSymbol5 = Lit110;
                SimpleSymbol simpleSymbol6 = Lit111;
                Pair list13 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
                LList.chain4(list13, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
                runtime.callComponentMethod(simpleSymbol5, simpleSymbol6, list13, Lit122);
            } else {
                runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (x,xx mol)", "Leider Falsch!", "Okay"), Lit123);
            }
        }
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), "Welches Volumen nimmt eine Stoffmenge von 5,32 mol eines Gases unter Normbedingungen ein?"), Lit124, "=") != Boolean.FALSE) {
            if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "119 l"), Lit125, "=") != Boolean.FALSE) {
                SimpleSymbol simpleSymbol7 = Lit110;
                SimpleSymbol simpleSymbol8 = Lit111;
                Pair list14 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
                LList.chain4(list14, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
                runtime.callComponentMethod(simpleSymbol7, simpleSymbol8, list14, Lit126);
            } else {
                runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (xxx l)", "Leider Falsch!", "Okay"), Lit127);
            }
        }
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), "Berechne die benötigte Masse an Aluminiumoxid zur Herstellung eines acht Kilogramm schweren Fahrradrahmens."), Lit128, "=") != Boolean.FALSE) {
            if (runtime.processOrDelayed$V(new Object[]{lambda$Fn29, lambda$Fn30}) != Boolean.FALSE) {
                SimpleSymbol simpleSymbol9 = Lit110;
                SimpleSymbol simpleSymbol10 = Lit111;
                Pair list15 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
                LList.chain4(list15, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
                runtime.callComponentMethod(simpleSymbol9, simpleSymbol10, list15, Lit131);
            } else {
                runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (x,xx Gramm oder x,xxg)", "Leider Falsch!", "Okay"), Lit132);
            }
        }
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit19, Lit20), "Ermittle die jeweils benötigte Masse an Eisen und Schwefel, um 20 Gramm Eisensulfid herzustellen."), Lit133, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        if (runtime.processOrDelayed$V(new Object[]{lambda$Fn31, lambda$Fn32}) == Boolean.FALSE) {
            return runtime.callComponentMethod(Lit110, Lit113, LList.list3("Deine Lösung stimmt leider nicht oder du hast sie im falschen Format eingegeben. (xx,xx Gramm Eisen, x,xx Gramm Schwefel)", "Leider Falsch!", "Okay"), Lit137);
        }
        SimpleSymbol simpleSymbol11 = Lit110;
        SimpleSymbol simpleSymbol12 = Lit111;
        Pair list16 = LList.list1("Möchtest du noch eine Aufgabe rechnen?");
        LList.chain4(list16, "Sehr gut!", "Neue Aufgabe", "", Boolean.TRUE);
        return runtime.callComponentMethod(simpleSymbol11, simpleSymbol12, list16, Lit136);
    }

    static Object lambda26() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "116,07 Gramm"), Lit108, "=");
    }

    static Object lambda27() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "116,07g"), Lit109, "=");
    }

    static Object lambda28() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "715,1 Gramm"), Lit116, "=");
    }

    static Object lambda29() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "715,1g"), Lit117, "=");
    }

    static Object lambda30() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "3,15 Gramm"), Lit129, "=");
    }

    static Object lambda31() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "3,15g"), Lit130, "=");
    }

    static Object lambda32() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "12,71 Gramm Eisen, 7,29 Gramm Schwefel"), Lit134, "=");
    }

    static Object lambda33() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit91, Lit20), "12,71g Eisen, 7,29g Schwefel"), Lit135, "=");
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit11, Lit142, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit20, "Aufgabe überspringen :(", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit34, Lit143, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit46, Lit144, Lit7);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit11, Lit142, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit20, "Aufgabe überspringen :(", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit34, Lit143, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit46, Lit144, Lit7);
    }

    public Object skip$Click() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit19, Lit20, "", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit91, Lit20, "", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit20, "", Lit4);
        SimpleSymbol simpleSymbol = Lit19;
        SimpleSymbol simpleSymbol2 = Lit20;
        ModuleMethod moduleMethod = runtime.yail$Mnlist$Mnpick$Mnrandom;
        ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
        Pair list1 = LList.list1(" Airbags sind mit dem Feststoff Natriumazid <b>(NaN<sub>3</sub>)</b> gefüllt, bei einem Autounfall wird durch einen Stromimpuls eine Anzündeeinheit ausgelöst. Diese Anzündeeinheit startet die Zersetzungsreaktion von <b>Natriumazid zu Stickstoff und Natrium</b>. Der Gasförmige Stickstoff nimmt sehr viel mehr Raum ein als das feste Natriumazid, dadurch breitet sich der Airbag schnell aus und bildet so das Kissen was Autoinsassen bei einem Unfall schützen kann.<br>  Wie viel Natriumazid wird unter Normalbedingungen für die Bildung von 60 Liter Stickstoff im Airbag gebraucht?");
        LList.chain1(LList.chain4(list1, " Bei der Durchführung des Thermitverfahrens reagieren Aluminium und Eisen(III)oxid zu Aluminiumoxid und Eisen. Um zwei Straßenbahnschienen miteinander zu verbinden braucht man 500 Gramm Eisen.<br> Wieviel Gramm Eisen(III)oxid ist hierfür erforderlich?", "Wie viel NaCl-Moleküle sind in einer Prise Salz (3 Gramm) enthalten?", "Welches Volumen nimmt eine Stoffmenge von 5,32 mol eines Gases unter Normbedingungen ein?", "Berechne die benötigte Masse an Aluminiumoxid (in kg) zur Herstellung eines acht Kilogramm schweren Fahrradrahmens."), "Ermittle die jeweils benötigte Masse an Eisen und Schwefel, um 20 Gramm Eisensulfid herzustellen.");
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, list1, Lit146, "make a list")), Lit147, "pick random item"), Lit4);
    }

    public Object feedback$AfterChoosing(Object $choice) {
        runtime.sanitizeComponentData($choice);
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit21, Lit20, "", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit91, Lit20, "", Lit4);
        SimpleSymbol simpleSymbol = Lit19;
        SimpleSymbol simpleSymbol2 = Lit20;
        ModuleMethod moduleMethod = runtime.yail$Mnlist$Mnpick$Mnrandom;
        ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
        Pair list1 = LList.list1(" Airbags sind mit dem Feststoff Natriumazid <b>(NaN<sub>3</sub>)</b> gefüllt, bei einem Autounfall wird durch einen Stromimpuls eine Anzündeeinheit ausgelöst. Diese Anzündeeinheit startet die Zersetzungsreaktion von <b>Natriumazid zu Stickstoff und Natrium</b>. Der Gasförmige Stickstoff nimmt sehr viel mehr Raum ein als das feste Natriumazid, dadurch breitet sich der Airbag schnell aus und bildet so das Kissen was Autoinsassen bei einem Unfall schützen kann.<br>  Wie viel Natriumazid wird unter Normalbedingungen für die Bildung von 60 Liter Stickstoff im Airbag gebraucht?");
        LList.chain1(LList.chain4(list1, " Bei der Durchführung des Thermitverfahrens reagieren Aluminium und Eisen(III)oxid zu Aluminiumoxid und Eisen. Um zwei Straßenbahnschienen miteinander zu verbinden braucht man 500 Gramm Eisen.<br> Wieviel Gramm Eisen(III)oxid ist hierfür erforderlich?", "Wie viel NaCl-Moleküle sind in einer Prise Salz (3 Gramm) enthalten?", "Welches Volumen nimmt eine Stoffmenge von 5,32 mol eines Gases unter Normbedingungen ein?", "Berechne die benötigte Masse an Aluminiumoxid (in kg) zur Herstellung eines acht Kilogramm schweren Fahrradrahmens."), "Ermittle die jeweils benötigte Masse an Eisen und Schwefel, um 20 Gramm Eisensulfid herzustellen.");
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, list1, Lit151, "make a list")), Lit152, "pick random item"), Lit4);
    }

    public Object feedback$ChoosingCanceled() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Screen1"), Lit155, "open another screen");
    }

    /* compiled from: Exercise.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Exercise $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Exercise)) {
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
                    if (!(obj instanceof Exercise)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 57:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
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
                    if (!(obj instanceof Exercise)) {
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
                    if (!(obj instanceof Exercise)) {
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
                case 57:
                    return this.$main.feedback$AfterChoosing(obj);
                default:
                    return super.apply1(moduleMethod, obj);
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
                    Exercise exercise = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    exercise.dispatchGenericEvent(component, str, z, (Object[]) obj4);
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
                    return Exercise.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Exercise.lambda3();
                case 21:
                    return this.$main.Exercise$Initialize();
                case 22:
                    return Exercise.lambda4();
                case 23:
                    return Exercise.lambda5();
                case 24:
                    return Exercise.lambda6();
                case 25:
                    return Exercise.lambda7();
                case 26:
                    return Exercise.lambda8();
                case 27:
                    return Exercise.lambda9();
                case 28:
                    return this.$main.nebenrechnung$Changed();
                case 29:
                    return Exercise.lambda10();
                case 30:
                    return Exercise.lambda11();
                case 31:
                    return Exercise.lambda12();
                case 32:
                    return Exercise.lambda13();
                case 33:
                    return Exercise.lambda14();
                case 34:
                    return Exercise.lambda15();
                case 35:
                    return Exercise.lambda16();
                case 36:
                    return Exercise.lambda17();
                case 37:
                    return Exercise.lambda18();
                case 38:
                    return Exercise.lambda19();
                case 39:
                    return Exercise.lambda20();
                case 40:
                    return Exercise.lambda21();
                case 41:
                    return Exercise.lambda22();
                case 42:
                    return Exercise.lambda23();
                case 43:
                    return Exercise.lambda24();
                case 44:
                    return Exercise.lambda25();
                case 45:
                    return Exercise.lambda26();
                case 46:
                    return Exercise.lambda27();
                case 47:
                    return Exercise.lambda28();
                case 48:
                    return Exercise.lambda29();
                case 49:
                    return Exercise.lambda30();
                case 50:
                    return Exercise.lambda31();
                case 51:
                    return Exercise.lambda32();
                case 52:
                    return Exercise.lambda33();
                case 53:
                    return this.$main.check$Click();
                case 54:
                    return Exercise.lambda34();
                case 55:
                    return Exercise.lambda35();
                case 56:
                    return this.$main.skip$Click();
                case 57:
                default:
                    return super.apply0(moduleMethod);
                case 58:
                    return this.$main.feedback$ChoosingCanceled();
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
                default:
                    return super.match0(moduleMethod, callContext);
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
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
        Exercise = this;
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
