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
import com.google.appinventor.components.runtime.HorizontalScrollArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
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
import kawa.standard.require;

/* compiled from: Revision.yail */
/* loaded from: classes.dex */
public class Revision extends Form implements Runnable {
    static final IntNum Lit100;
    static final IntNum Lit104;
    static final IntNum Lit108;
    static final IntNum Lit112;
    static final IntNum Lit116;
    static final IntNum Lit12;
    static final IntNum Lit123;
    static final IntNum Lit127;
    static final IntNum Lit131;
    static final IntNum Lit135;
    static final IntNum Lit142;
    static final IntNum Lit146;
    static final IntNum Lit150;
    static final IntNum Lit154;
    static final IntNum Lit161;
    static final IntNum Lit165;
    static final IntNum Lit169;
    static final IntNum Lit182;
    static final IntNum Lit186;
    static final IntNum Lit190;
    static final IntNum Lit194;
    static final IntNum Lit198;
    static final IntNum Lit205;
    static final IntNum Lit217;
    static final IntNum Lit221;
    static final IntNum Lit225;
    static final IntNum Lit227;
    static final IntNum Lit232;
    static final IntNum Lit236;
    static final IntNum Lit240;
    static final IntNum Lit247;
    static final IntNum Lit251;
    static final IntNum Lit255;
    static final IntNum Lit259;
    static final IntNum Lit260;
    static final PairWithPosition Lit263;
    static final IntNum Lit39;
    static final SimpleSymbol Lit4;
    static final IntNum Lit42;
    static final IntNum Lit6;
    static final IntNum Lit80;
    static final IntNum Lit85;
    static final IntNum Lit89;
    static final IntNum Lit93;
    public static Revision Revision;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn100 = null;
    static final ModuleMethod lambda$Fn101 = null;
    static final ModuleMethod lambda$Fn102 = null;
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
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn41 = null;
    static final ModuleMethod lambda$Fn42 = null;
    static final ModuleMethod lambda$Fn43 = null;
    static final ModuleMethod lambda$Fn44 = null;
    static final ModuleMethod lambda$Fn45 = null;
    static final ModuleMethod lambda$Fn46 = null;
    static final ModuleMethod lambda$Fn47 = null;
    static final ModuleMethod lambda$Fn48 = null;
    static final ModuleMethod lambda$Fn49 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn50 = null;
    static final ModuleMethod lambda$Fn51 = null;
    static final ModuleMethod lambda$Fn52 = null;
    static final ModuleMethod lambda$Fn53 = null;
    static final ModuleMethod lambda$Fn54 = null;
    static final ModuleMethod lambda$Fn55 = null;
    static final ModuleMethod lambda$Fn56 = null;
    static final ModuleMethod lambda$Fn57 = null;
    static final ModuleMethod lambda$Fn58 = null;
    static final ModuleMethod lambda$Fn59 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn60 = null;
    static final ModuleMethod lambda$Fn61 = null;
    static final ModuleMethod lambda$Fn62 = null;
    static final ModuleMethod lambda$Fn63 = null;
    static final ModuleMethod lambda$Fn64 = null;
    static final ModuleMethod lambda$Fn65 = null;
    static final ModuleMethod lambda$Fn66 = null;
    static final ModuleMethod lambda$Fn67 = null;
    static final ModuleMethod lambda$Fn68 = null;
    static final ModuleMethod lambda$Fn69 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn70 = null;
    static final ModuleMethod lambda$Fn71 = null;
    static final ModuleMethod lambda$Fn72 = null;
    static final ModuleMethod lambda$Fn73 = null;
    static final ModuleMethod lambda$Fn74 = null;
    static final ModuleMethod lambda$Fn75 = null;
    static final ModuleMethod lambda$Fn76 = null;
    static final ModuleMethod lambda$Fn77 = null;
    static final ModuleMethod lambda$Fn78 = null;
    static final ModuleMethod lambda$Fn79 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn80 = null;
    static final ModuleMethod lambda$Fn81 = null;
    static final ModuleMethod lambda$Fn82 = null;
    static final ModuleMethod lambda$Fn83 = null;
    static final ModuleMethod lambda$Fn84 = null;
    static final ModuleMethod lambda$Fn85 = null;
    static final ModuleMethod lambda$Fn86 = null;
    static final ModuleMethod lambda$Fn87 = null;
    static final ModuleMethod lambda$Fn88 = null;
    static final ModuleMethod lambda$Fn89 = null;
    static final ModuleMethod lambda$Fn9 = null;
    static final ModuleMethod lambda$Fn90 = null;
    static final ModuleMethod lambda$Fn91 = null;
    static final ModuleMethod lambda$Fn92 = null;
    static final ModuleMethod lambda$Fn93 = null;
    static final ModuleMethod lambda$Fn94 = null;
    static final ModuleMethod lambda$Fn95 = null;
    static final ModuleMethod lambda$Fn96 = null;
    static final ModuleMethod lambda$Fn97 = null;
    static final ModuleMethod lambda$Fn98 = null;
    static final ModuleMethod lambda$Fn99 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public VerticalScrollArrangement Aktivierungenergie;
    public VerticalScrollArrangement Atommodell_von_Dalton;

    /* renamed from: Binäre_Verbindungen  reason: contains not printable characters */
    public VerticalScrollArrangement f1Binre_Verbindungen;
    public VerticalScrollArrangement Definition_der_Atommasse_und_Umrechnung_in_Gramm;
    public VerticalScrollArrangement Definition_der_Stoffmenge;
    public VerticalScrollArrangement Gasnachweise;

    /* renamed from: HorizontalScrollArrangement_Binäre_Verbindungen_Tabellen  reason: contains not printable characters */
    public HorizontalScrollArrangement f2HorizontalScrollArrangement_Binre_Verbindungen_Tabellen;
    public VerticalScrollArrangement Molare_Masse;
    public VerticalScrollArrangement Molares_Volumen;
    public VerticalScrollArrangement Parent;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public Image aktivierungenergie;
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
    public Button home;
    public final ModuleMethod home$Click;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public Button puffer0;
    public Button puffer1;
    public ListPicker selector;
    public final ModuleMethod selector$AfterPicking;
    public final ModuleMethod selector$TouchUp;
    public final ModuleMethod send$Mnerror;
    public Button seperate;
    public Label text1;
    public Label text10;
    public Label text11;
    public Label text12;
    public Label text13;
    public Label text14;
    public Label text15;
    public Label text16;
    public Label text17;
    public Label text18;
    public Label text19;
    public Label text2;
    public Label text20;
    public Label text21;
    public Label text22;
    public Label text23;
    public Label text24;
    public Label text25;
    public Label text26;
    public Label text27;
    public Label text28;
    public Label text29;
    public Label text3;
    public Label text30;
    public Label text31;
    public Label text32;
    public Label text33;
    public Label text34;
    public Label text4;
    public Label text5;
    public Label text6;
    public Label text7;
    public Label text8;
    public Label text9;
    static final SimpleSymbol Lit280 = (SimpleSymbol) new SimpleSymbol("any").readResolve();
    static final SimpleSymbol Lit279 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit278 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit277 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit276 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit275 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit274 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit273 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit272 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit271 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit270 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit269 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit268 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit267 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit266 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final SimpleSymbol Lit265 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
    static final SimpleSymbol Lit264 = (SimpleSymbol) new SimpleSymbol("home$Click").readResolve();
    static final FString Lit262 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit261 = IntNum.make(-1055);
    static final SimpleSymbol Lit258 = (SimpleSymbol) new SimpleSymbol("home").readResolve();
    static final FString Lit257 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit256 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit254 = (SimpleSymbol) new SimpleSymbol("text34").readResolve();
    static final FString Lit253 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit252 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit250 = (SimpleSymbol) new SimpleSymbol("text33").readResolve();
    static final FString Lit249 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit248 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit246 = (SimpleSymbol) new SimpleSymbol("text32").readResolve();
    static final FString Lit245 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit244 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit243 = IntNum.make(16777215);
    static final FString Lit242 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit241 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit239 = (SimpleSymbol) new SimpleSymbol("text31").readResolve();
    static final FString Lit238 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit237 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit235 = (SimpleSymbol) new SimpleSymbol("text30").readResolve();
    static final FString Lit234 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit233 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit231 = (SimpleSymbol) new SimpleSymbol("text29").readResolve();
    static final FString Lit230 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit229 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit228 = IntNum.make(15);
    static final SimpleSymbol Lit226 = (SimpleSymbol) new SimpleSymbol("ShowFeedback").readResolve();
    static final SimpleSymbol Lit224 = (SimpleSymbol) new SimpleSymbol("seperate").readResolve();
    static final FString Lit223 = new FString("com.google.appinventor.components.runtime.Button");
    static final FString Lit222 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit220 = (SimpleSymbol) new SimpleSymbol("text28").readResolve();
    static final FString Lit219 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit218 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit216 = IntNum.make(1);
    static final SimpleSymbol Lit215 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
    static final SimpleSymbol Lit214 = (SimpleSymbol) new SimpleSymbol("text27").readResolve();
    static final FString Lit213 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit212 = new FString("com.google.appinventor.components.runtime.HorizontalScrollArrangement");
    static final IntNum Lit211 = IntNum.make(16777215);
    static final IntNum Lit210 = IntNum.make(2);
    static final SimpleSymbol Lit209 = (SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve();
    static final SimpleSymbol Lit208 = (SimpleSymbol) new SimpleSymbol("HorizontalScrollArrangement_Binäre_Verbindungen_Tabellen").readResolve();
    static final FString Lit207 = new FString("com.google.appinventor.components.runtime.HorizontalScrollArrangement");
    static final FString Lit206 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit204 = (SimpleSymbol) new SimpleSymbol("text26").readResolve();
    static final FString Lit203 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit202 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit201 = IntNum.make(16777215);
    static final FString Lit200 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit199 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit197 = (SimpleSymbol) new SimpleSymbol("text25").readResolve();
    static final FString Lit196 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit195 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit193 = (SimpleSymbol) new SimpleSymbol("text24").readResolve();
    static final FString Lit192 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit191 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit189 = (SimpleSymbol) new SimpleSymbol("text23").readResolve();
    static final FString Lit188 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit187 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit185 = (SimpleSymbol) new SimpleSymbol("text22").readResolve();
    static final FString Lit184 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit183 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit181 = (SimpleSymbol) new SimpleSymbol("text21").readResolve();
    static final FString Lit180 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit179 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit178 = IntNum.make(16777215);
    static final FString Lit177 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit176 = new FString("com.google.appinventor.components.runtime.Image");
    static final IntNum Lit175 = IntNum.make(255);
    static final SimpleSymbol Lit174 = (SimpleSymbol) new SimpleSymbol("Picture").readResolve();
    static final IntNum Lit173 = IntNum.make(155);
    static final SimpleSymbol Lit172 = (SimpleSymbol) new SimpleSymbol("aktivierungenergie").readResolve();
    static final FString Lit171 = new FString("com.google.appinventor.components.runtime.Image");
    static final FString Lit170 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit168 = (SimpleSymbol) new SimpleSymbol("text20").readResolve();
    static final FString Lit167 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit166 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit164 = (SimpleSymbol) new SimpleSymbol("text19").readResolve();
    static final FString Lit163 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit162 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit160 = (SimpleSymbol) new SimpleSymbol("text18").readResolve();
    static final FString Lit159 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit158 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit157 = IntNum.make(16777215);
    static final FString Lit156 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit155 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit153 = (SimpleSymbol) new SimpleSymbol("text17").readResolve();
    static final FString Lit152 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit151 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit149 = (SimpleSymbol) new SimpleSymbol("text16").readResolve();
    static final FString Lit148 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit147 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit145 = (SimpleSymbol) new SimpleSymbol("text15").readResolve();
    static final FString Lit144 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit143 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit141 = (SimpleSymbol) new SimpleSymbol("text14").readResolve();
    static final FString Lit140 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit139 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit138 = IntNum.make(16777215);
    static final FString Lit137 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit136 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit134 = (SimpleSymbol) new SimpleSymbol("text13").readResolve();
    static final FString Lit133 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit132 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit130 = (SimpleSymbol) new SimpleSymbol("text12").readResolve();
    static final FString Lit129 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit128 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit126 = (SimpleSymbol) new SimpleSymbol("text11").readResolve();
    static final FString Lit125 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit124 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit122 = (SimpleSymbol) new SimpleSymbol("text10").readResolve();
    static final FString Lit121 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit120 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit119 = IntNum.make(16777215);
    static final FString Lit118 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit117 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit115 = (SimpleSymbol) new SimpleSymbol("text9").readResolve();
    static final FString Lit114 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit113 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit111 = (SimpleSymbol) new SimpleSymbol("text8").readResolve();
    static final FString Lit110 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit109 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit107 = (SimpleSymbol) new SimpleSymbol("text7").readResolve();
    static final FString Lit106 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit105 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit103 = (SimpleSymbol) new SimpleSymbol("text6").readResolve();
    static final FString Lit102 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit101 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit99 = (SimpleSymbol) new SimpleSymbol("text5").readResolve();
    static final FString Lit98 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit97 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit96 = IntNum.make(16777215);
    static final FString Lit95 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit92 = (SimpleSymbol) new SimpleSymbol("text4").readResolve();
    static final FString Lit91 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit88 = (SimpleSymbol) new SimpleSymbol("text3").readResolve();
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit84 = IntNum.make(16);
    static final SimpleSymbol Lit83 = (SimpleSymbol) new SimpleSymbol("text2").readResolve();
    static final FString Lit82 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit81 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit79 = (SimpleSymbol) new SimpleSymbol("HTMLFormat").readResolve();
    static final IntNum Lit78 = IntNum.make(20);
    static final SimpleSymbol Lit77 = (SimpleSymbol) new SimpleSymbol("text1").readResolve();
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit75 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit74 = IntNum.make(16777215);
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit71 = IntNum.make(-2);
    static final IntNum Lit70 = IntNum.make(16777215);
    static final IntNum Lit69 = IntNum.make(16777215);
    static final SimpleSymbol Lit68 = (SimpleSymbol) new SimpleSymbol("puffer1").readResolve();
    static final FString Lit67 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit66 = (SimpleSymbol) new SimpleSymbol("TouchUp").readResolve();
    static final SimpleSymbol Lit65 = (SimpleSymbol) new SimpleSymbol("selector$TouchUp").readResolve();
    static final SimpleSymbol Lit64 = (SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve();
    static final SimpleSymbol Lit63 = (SimpleSymbol) new SimpleSymbol("selector$AfterPicking").readResolve();
    static final SimpleSymbol Lit62 = (SimpleSymbol) new SimpleSymbol("Atommodell_von_Dalton").readResolve();
    static final PairWithPosition Lit61 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 272029), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 272024);
    static final SimpleSymbol Lit60 = (SimpleSymbol) new SimpleSymbol("Binäre_Verbindungen").readResolve();
    static final PairWithPosition Lit59 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271809), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271804);
    static final SimpleSymbol Lit58 = (SimpleSymbol) new SimpleSymbol("Gasnachweise").readResolve();
    static final PairWithPosition Lit57 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271593), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271588);
    static final SimpleSymbol Lit56 = (SimpleSymbol) new SimpleSymbol("Aktivierungenergie").readResolve();
    static final PairWithPosition Lit55 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271383), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271378);
    static final SimpleSymbol Lit54 = (SimpleSymbol) new SimpleSymbol("Molares_Volumen").readResolve();
    static final PairWithPosition Lit53 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271169), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 271164);
    static final SimpleSymbol Lit52 = (SimpleSymbol) new SimpleSymbol("Molare_Masse").readResolve();
    static final PairWithPosition Lit51 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270962), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270957);
    static final SimpleSymbol Lit50 = (SimpleSymbol) new SimpleSymbol("Definition_der_Atommasse_und_Umrechnung_in_Gramm").readResolve();
    static final PairWithPosition Lit49 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270722), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270717);
    static final SimpleSymbol Lit48 = (SimpleSymbol) new SimpleSymbol("Visible").readResolve();
    static final SimpleSymbol Lit47 = (SimpleSymbol) new SimpleSymbol("Definition_der_Stoffmenge").readResolve();
    static final PairWithPosition Lit46 = PairWithPosition.make(Lit280, PairWithPosition.make(Lit280, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270469), "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 270464);
    static final SimpleSymbol Lit45 = (SimpleSymbol) new SimpleSymbol("Selection").readResolve();
    static final FString Lit44 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final IntNum Lit43 = IntNum.make(-1055);
    static final SimpleSymbol Lit41 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
    static final SimpleSymbol Lit40 = (SimpleSymbol) new SimpleSymbol("ElementsFromString").readResolve();
    static final SimpleSymbol Lit38 = (SimpleSymbol) new SimpleSymbol("selector").readResolve();
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit35 = IntNum.make(-1090);
    static final IntNum Lit34 = IntNum.make(16777215);
    static final SimpleSymbol Lit33 = (SimpleSymbol) new SimpleSymbol("Parent").readResolve();
    static final FString Lit32 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit31 = new FString("com.google.appinventor.components.runtime.Button");
    static final IntNum Lit30 = IntNum.make(-1100);
    static final SimpleSymbol Lit29 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
    static final IntNum Lit28 = IntNum.make(16777215);
    static final SimpleSymbol Lit27 = (SimpleSymbol) new SimpleSymbol("TextColor").readResolve();
    static final IntNum Lit26 = IntNum.make(-1003);
    static final SimpleSymbol Lit25 = (SimpleSymbol) new SimpleSymbol("Height").readResolve();
    static final IntNum Lit24 = IntNum.make(0);
    static final SimpleSymbol Lit23 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
    static final SimpleSymbol Lit22 = (SimpleSymbol) new SimpleSymbol("Enabled").readResolve();
    static final IntNum Lit21 = IntNum.make(16777215);
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("puffer0").readResolve();
    static final FString Lit19 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit18 = (SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve();
    static final SimpleSymbol Lit17 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
    static final SimpleSymbol Lit16 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
    static final SimpleSymbol Lit15 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
    static final SimpleSymbol Lit14 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
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
    static final SimpleSymbol Lit0 = (SimpleSymbol) new SimpleSymbol("Revision").readResolve();

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit4 = simpleSymbol;
        Lit263 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1615287726010_0.6847351420177257-0/youngandroidproject/../src/appinventor/ai_liamkauper/Chemie_App/Revision.yail", 2732110);
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit260 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -7829368;
        Lit259 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit255 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -1;
        Lit251 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -1;
        Lit247 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit240 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -1;
        Lit236 = IntNum.make(iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = -1;
        Lit232 = IntNum.make(iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = -1;
        Lit227 = IntNum.make(iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = -1;
        Lit225 = IntNum.make(iArr10);
        int[] iArr11 = new int[2];
        iArr11[0] = -1;
        Lit221 = IntNum.make(iArr11);
        int[] iArr12 = new int[2];
        iArr12[0] = -1;
        Lit217 = IntNum.make(iArr12);
        int[] iArr13 = new int[2];
        iArr13[0] = -1;
        Lit205 = IntNum.make(iArr13);
        int[] iArr14 = new int[2];
        iArr14[0] = -1;
        Lit198 = IntNum.make(iArr14);
        int[] iArr15 = new int[2];
        iArr15[0] = -1;
        Lit194 = IntNum.make(iArr15);
        int[] iArr16 = new int[2];
        iArr16[0] = -1;
        Lit190 = IntNum.make(iArr16);
        int[] iArr17 = new int[2];
        iArr17[0] = -1;
        Lit186 = IntNum.make(iArr17);
        int[] iArr18 = new int[2];
        iArr18[0] = -1;
        Lit182 = IntNum.make(iArr18);
        int[] iArr19 = new int[2];
        iArr19[0] = -1;
        Lit169 = IntNum.make(iArr19);
        int[] iArr20 = new int[2];
        iArr20[0] = -1;
        Lit165 = IntNum.make(iArr20);
        int[] iArr21 = new int[2];
        iArr21[0] = -1;
        Lit161 = IntNum.make(iArr21);
        int[] iArr22 = new int[2];
        iArr22[0] = -1;
        Lit154 = IntNum.make(iArr22);
        int[] iArr23 = new int[2];
        iArr23[0] = -1;
        Lit150 = IntNum.make(iArr23);
        int[] iArr24 = new int[2];
        iArr24[0] = -1;
        Lit146 = IntNum.make(iArr24);
        int[] iArr25 = new int[2];
        iArr25[0] = -1;
        Lit142 = IntNum.make(iArr25);
        int[] iArr26 = new int[2];
        iArr26[0] = -1;
        Lit135 = IntNum.make(iArr26);
        int[] iArr27 = new int[2];
        iArr27[0] = -1;
        Lit131 = IntNum.make(iArr27);
        int[] iArr28 = new int[2];
        iArr28[0] = -1;
        Lit127 = IntNum.make(iArr28);
        int[] iArr29 = new int[2];
        iArr29[0] = -1;
        Lit123 = IntNum.make(iArr29);
        int[] iArr30 = new int[2];
        iArr30[0] = -1;
        Lit116 = IntNum.make(iArr30);
        int[] iArr31 = new int[2];
        iArr31[0] = -1;
        Lit112 = IntNum.make(iArr31);
        int[] iArr32 = new int[2];
        iArr32[0] = -1;
        Lit108 = IntNum.make(iArr32);
        int[] iArr33 = new int[2];
        iArr33[0] = -1;
        Lit104 = IntNum.make(iArr33);
        int[] iArr34 = new int[2];
        iArr34[0] = -1;
        Lit100 = IntNum.make(iArr34);
        int[] iArr35 = new int[2];
        iArr35[0] = -1;
        Lit93 = IntNum.make(iArr35);
        int[] iArr36 = new int[2];
        iArr36[0] = -1;
        Lit89 = IntNum.make(iArr36);
        int[] iArr37 = new int[2];
        iArr37[0] = -1;
        Lit85 = IntNum.make(iArr37);
        int[] iArr38 = new int[2];
        iArr38[0] = -1;
        Lit80 = IntNum.make(iArr38);
        int[] iArr39 = new int[2];
        iArr39[0] = -1;
        Lit42 = IntNum.make(iArr39);
        int[] iArr40 = new int[2];
        iArr40[0] = -7829368;
        Lit39 = IntNum.make(iArr40);
        int[] iArr41 = new int[2];
        iArr41[0] = -13684426;
        Lit12 = IntNum.make(iArr41);
        int[] iArr42 = new int[2];
        iArr42[0] = -16711681;
        Lit6 = IntNum.make(iArr42);
    }

    public Revision() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit266, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit267, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit268, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit269, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit270, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit271, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit272, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit273, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit274, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit275, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit276, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit277, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit278, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit279, 8194);
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
        this.selector$AfterPicking = new ModuleMethod(frameVar, 27, Lit63, 0);
        this.selector$TouchUp = new ModuleMethod(frameVar, 28, Lit65, 0);
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
        lambda$Fn33 = new ModuleMethod(frameVar, 53, null, 0);
        lambda$Fn34 = new ModuleMethod(frameVar, 54, null, 0);
        lambda$Fn35 = new ModuleMethod(frameVar, 55, null, 0);
        lambda$Fn36 = new ModuleMethod(frameVar, 56, null, 0);
        lambda$Fn37 = new ModuleMethod(frameVar, 57, null, 0);
        lambda$Fn38 = new ModuleMethod(frameVar, 58, null, 0);
        lambda$Fn39 = new ModuleMethod(frameVar, 59, null, 0);
        lambda$Fn40 = new ModuleMethod(frameVar, 60, null, 0);
        lambda$Fn41 = new ModuleMethod(frameVar, 61, null, 0);
        lambda$Fn42 = new ModuleMethod(frameVar, 62, null, 0);
        lambda$Fn43 = new ModuleMethod(frameVar, 63, null, 0);
        lambda$Fn44 = new ModuleMethod(frameVar, 64, null, 0);
        lambda$Fn45 = new ModuleMethod(frameVar, 65, null, 0);
        lambda$Fn46 = new ModuleMethod(frameVar, 66, null, 0);
        lambda$Fn47 = new ModuleMethod(frameVar, 67, null, 0);
        lambda$Fn48 = new ModuleMethod(frameVar, 68, null, 0);
        lambda$Fn49 = new ModuleMethod(frameVar, 69, null, 0);
        lambda$Fn50 = new ModuleMethod(frameVar, 70, null, 0);
        lambda$Fn51 = new ModuleMethod(frameVar, 71, null, 0);
        lambda$Fn52 = new ModuleMethod(frameVar, 72, null, 0);
        lambda$Fn53 = new ModuleMethod(frameVar, 73, null, 0);
        lambda$Fn54 = new ModuleMethod(frameVar, 74, null, 0);
        lambda$Fn55 = new ModuleMethod(frameVar, 75, null, 0);
        lambda$Fn56 = new ModuleMethod(frameVar, 76, null, 0);
        lambda$Fn57 = new ModuleMethod(frameVar, 77, null, 0);
        lambda$Fn58 = new ModuleMethod(frameVar, 78, null, 0);
        lambda$Fn59 = new ModuleMethod(frameVar, 79, null, 0);
        lambda$Fn60 = new ModuleMethod(frameVar, 80, null, 0);
        lambda$Fn61 = new ModuleMethod(frameVar, 81, null, 0);
        lambda$Fn62 = new ModuleMethod(frameVar, 82, null, 0);
        lambda$Fn63 = new ModuleMethod(frameVar, 83, null, 0);
        lambda$Fn64 = new ModuleMethod(frameVar, 84, null, 0);
        lambda$Fn65 = new ModuleMethod(frameVar, 85, null, 0);
        lambda$Fn66 = new ModuleMethod(frameVar, 86, null, 0);
        lambda$Fn67 = new ModuleMethod(frameVar, 87, null, 0);
        lambda$Fn68 = new ModuleMethod(frameVar, 88, null, 0);
        lambda$Fn69 = new ModuleMethod(frameVar, 89, null, 0);
        lambda$Fn70 = new ModuleMethod(frameVar, 90, null, 0);
        lambda$Fn71 = new ModuleMethod(frameVar, 91, null, 0);
        lambda$Fn72 = new ModuleMethod(frameVar, 92, null, 0);
        lambda$Fn73 = new ModuleMethod(frameVar, 93, null, 0);
        lambda$Fn74 = new ModuleMethod(frameVar, 94, null, 0);
        lambda$Fn75 = new ModuleMethod(frameVar, 95, null, 0);
        lambda$Fn76 = new ModuleMethod(frameVar, 96, null, 0);
        lambda$Fn77 = new ModuleMethod(frameVar, 97, null, 0);
        lambda$Fn78 = new ModuleMethod(frameVar, 98, null, 0);
        lambda$Fn79 = new ModuleMethod(frameVar, 99, null, 0);
        lambda$Fn80 = new ModuleMethod(frameVar, 100, null, 0);
        lambda$Fn81 = new ModuleMethod(frameVar, 101, null, 0);
        lambda$Fn82 = new ModuleMethod(frameVar, 102, null, 0);
        lambda$Fn83 = new ModuleMethod(frameVar, 103, null, 0);
        lambda$Fn84 = new ModuleMethod(frameVar, 104, null, 0);
        lambda$Fn85 = new ModuleMethod(frameVar, 105, null, 0);
        lambda$Fn86 = new ModuleMethod(frameVar, 106, null, 0);
        lambda$Fn87 = new ModuleMethod(frameVar, 107, null, 0);
        lambda$Fn88 = new ModuleMethod(frameVar, 108, null, 0);
        lambda$Fn89 = new ModuleMethod(frameVar, 109, null, 0);
        lambda$Fn90 = new ModuleMethod(frameVar, 110, null, 0);
        lambda$Fn91 = new ModuleMethod(frameVar, 111, null, 0);
        lambda$Fn92 = new ModuleMethod(frameVar, 112, null, 0);
        lambda$Fn93 = new ModuleMethod(frameVar, 113, null, 0);
        lambda$Fn94 = new ModuleMethod(frameVar, 114, null, 0);
        lambda$Fn95 = new ModuleMethod(frameVar, 115, null, 0);
        lambda$Fn96 = new ModuleMethod(frameVar, 116, null, 0);
        lambda$Fn97 = new ModuleMethod(frameVar, 117, null, 0);
        lambda$Fn98 = new ModuleMethod(frameVar, 118, null, 0);
        lambda$Fn99 = new ModuleMethod(frameVar, 119, null, 0);
        lambda$Fn100 = new ModuleMethod(frameVar, 120, null, 0);
        lambda$Fn101 = new ModuleMethod(frameVar, 121, null, 0);
        lambda$Fn102 = new ModuleMethod(frameVar, 122, null, 0);
        this.home$Click = new ModuleMethod(frameVar, 123, Lit264, 0);
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
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            this.form$Mnenvironment = Environment.make(Lit0.toString());
            FString stringAppend = strings.stringAppend(Lit0.toString(), "-global-vars");
            this.global$Mnvar$Mnenvironment = Environment.make(stringAppend == null ? null : stringAppend.toString());
            Revision = null;
            this.form$Mnname$Mnsymbol = Lit0;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Revise and Learn!", Lit4);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie_App", Lit4);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Responsive", Lit4);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Revision", Lit4);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.FALSE, Lit14), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn2));
                }
                this.puffer0 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit19, Lit20, lambda$Fn3), $result);
                } else {
                    addToComponents(Lit0, Lit31, Lit20, lambda$Fn4);
                }
                this.Parent = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit32, Lit33, lambda$Fn5), $result);
                } else {
                    addToComponents(Lit0, Lit36, Lit33, lambda$Fn6);
                }
                this.selector = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit37, Lit38, lambda$Fn7), $result);
                } else {
                    addToComponents(Lit33, Lit44, Lit38, lambda$Fn8);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit63, this.selector$AfterPicking);
                } else {
                    addToFormEnvironment(Lit63, this.selector$AfterPicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "selector", "AfterPicking");
                } else {
                    addToEvents(Lit38, Lit64);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit65, this.selector$TouchUp);
                } else {
                    addToFormEnvironment(Lit65, this.selector$TouchUp);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "selector", "TouchUp");
                } else {
                    addToEvents(Lit38, Lit66);
                }
                this.puffer1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit67, Lit68, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit33, Lit72, Lit68, lambda$Fn10);
                }
                this.Definition_der_Stoffmenge = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit73, Lit47, lambda$Fn11), $result);
                } else {
                    addToComponents(Lit33, Lit75, Lit47, lambda$Fn12);
                }
                this.text1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit47, Lit76, Lit77, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit47, Lit81, Lit77, lambda$Fn14);
                }
                this.text2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit47, Lit82, Lit83, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit47, Lit86, Lit83, lambda$Fn16);
                }
                this.text3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit47, Lit87, Lit88, lambda$Fn17), $result);
                } else {
                    addToComponents(Lit47, Lit90, Lit88, lambda$Fn18);
                }
                this.text4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit47, Lit91, Lit92, lambda$Fn19), $result);
                } else {
                    addToComponents(Lit47, Lit94, Lit92, lambda$Fn20);
                }
                this.Definition_der_Atommasse_und_Umrechnung_in_Gramm = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit95, Lit50, lambda$Fn21), $result);
                } else {
                    addToComponents(Lit33, Lit97, Lit50, lambda$Fn22);
                }
                this.text5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit50, Lit98, Lit99, lambda$Fn23), $result);
                } else {
                    addToComponents(Lit50, Lit101, Lit99, lambda$Fn24);
                }
                this.text6 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit50, Lit102, Lit103, lambda$Fn25), $result);
                } else {
                    addToComponents(Lit50, Lit105, Lit103, lambda$Fn26);
                }
                this.text7 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit50, Lit106, Lit107, lambda$Fn27), $result);
                } else {
                    addToComponents(Lit50, Lit109, Lit107, lambda$Fn28);
                }
                this.text8 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit50, Lit110, Lit111, lambda$Fn29), $result);
                } else {
                    addToComponents(Lit50, Lit113, Lit111, lambda$Fn30);
                }
                this.text9 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit50, Lit114, Lit115, lambda$Fn31), $result);
                } else {
                    addToComponents(Lit50, Lit117, Lit115, lambda$Fn32);
                }
                this.Molare_Masse = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit118, Lit52, lambda$Fn33), $result);
                } else {
                    addToComponents(Lit33, Lit120, Lit52, lambda$Fn34);
                }
                this.text10 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit52, Lit121, Lit122, lambda$Fn35), $result);
                } else {
                    addToComponents(Lit52, Lit124, Lit122, lambda$Fn36);
                }
                this.text11 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit52, Lit125, Lit126, lambda$Fn37), $result);
                } else {
                    addToComponents(Lit52, Lit128, Lit126, lambda$Fn38);
                }
                this.text12 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit52, Lit129, Lit130, lambda$Fn39), $result);
                } else {
                    addToComponents(Lit52, Lit132, Lit130, lambda$Fn40);
                }
                this.text13 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit52, Lit133, Lit134, lambda$Fn41), $result);
                } else {
                    addToComponents(Lit52, Lit136, Lit134, lambda$Fn42);
                }
                this.Molares_Volumen = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit137, Lit54, lambda$Fn43), $result);
                } else {
                    addToComponents(Lit33, Lit139, Lit54, lambda$Fn44);
                }
                this.text14 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit140, Lit141, lambda$Fn45), $result);
                } else {
                    addToComponents(Lit54, Lit143, Lit141, lambda$Fn46);
                }
                this.text15 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit144, Lit145, lambda$Fn47), $result);
                } else {
                    addToComponents(Lit54, Lit147, Lit145, lambda$Fn48);
                }
                this.text16 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit148, Lit149, lambda$Fn49), $result);
                } else {
                    addToComponents(Lit54, Lit151, Lit149, lambda$Fn50);
                }
                this.text17 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit152, Lit153, lambda$Fn51), $result);
                } else {
                    addToComponents(Lit54, Lit155, Lit153, lambda$Fn52);
                }
                this.Aktivierungenergie = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit156, Lit56, lambda$Fn53), $result);
                } else {
                    addToComponents(Lit33, Lit158, Lit56, lambda$Fn54);
                }
                this.text18 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit56, Lit159, Lit160, lambda$Fn55), $result);
                } else {
                    addToComponents(Lit56, Lit162, Lit160, lambda$Fn56);
                }
                this.text19 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit56, Lit163, Lit164, lambda$Fn57), $result);
                } else {
                    addToComponents(Lit56, Lit166, Lit164, lambda$Fn58);
                }
                this.text20 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit56, Lit167, Lit168, lambda$Fn59), $result);
                } else {
                    addToComponents(Lit56, Lit170, Lit168, lambda$Fn60);
                }
                this.aktivierungenergie = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit56, Lit171, Lit172, lambda$Fn61), $result);
                } else {
                    addToComponents(Lit56, Lit176, Lit172, lambda$Fn62);
                }
                this.Gasnachweise = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit177, Lit58, lambda$Fn63), $result);
                } else {
                    addToComponents(Lit33, Lit179, Lit58, lambda$Fn64);
                }
                this.text21 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit58, Lit180, Lit181, lambda$Fn65), $result);
                } else {
                    addToComponents(Lit58, Lit183, Lit181, lambda$Fn66);
                }
                this.text22 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit58, Lit184, Lit185, lambda$Fn67), $result);
                } else {
                    addToComponents(Lit58, Lit187, Lit185, lambda$Fn68);
                }
                this.text23 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit58, Lit188, Lit189, lambda$Fn69), $result);
                } else {
                    addToComponents(Lit58, Lit191, Lit189, lambda$Fn70);
                }
                this.text24 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit58, Lit192, Lit193, lambda$Fn71), $result);
                } else {
                    addToComponents(Lit58, Lit195, Lit193, lambda$Fn72);
                }
                this.text25 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit58, Lit196, Lit197, lambda$Fn73), $result);
                } else {
                    addToComponents(Lit58, Lit199, Lit197, lambda$Fn74);
                }
                this.f1Binre_Verbindungen = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit200, Lit60, lambda$Fn75), $result);
                } else {
                    addToComponents(Lit33, Lit202, Lit60, lambda$Fn76);
                }
                this.text26 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit60, Lit203, Lit204, lambda$Fn77), $result);
                } else {
                    addToComponents(Lit60, Lit206, Lit204, lambda$Fn78);
                }
                this.f2HorizontalScrollArrangement_Binre_Verbindungen_Tabellen = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit60, Lit207, Lit208, lambda$Fn79), $result);
                } else {
                    addToComponents(Lit60, Lit212, Lit208, lambda$Fn80);
                }
                this.text27 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit208, Lit213, Lit214, lambda$Fn81), $result);
                } else {
                    addToComponents(Lit208, Lit218, Lit214, lambda$Fn82);
                }
                this.text28 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit208, Lit219, Lit220, lambda$Fn83), $result);
                } else {
                    addToComponents(Lit208, Lit222, Lit220, lambda$Fn84);
                }
                this.seperate = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit208, Lit223, Lit224, lambda$Fn85), $result);
                } else {
                    addToComponents(Lit208, Lit229, Lit224, lambda$Fn86);
                }
                this.text29 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit208, Lit230, Lit231, lambda$Fn87), $result);
                } else {
                    addToComponents(Lit208, Lit233, Lit231, lambda$Fn88);
                }
                this.text30 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit208, Lit234, Lit235, lambda$Fn89), $result);
                } else {
                    addToComponents(Lit208, Lit237, Lit235, lambda$Fn90);
                }
                this.text31 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit60, Lit238, Lit239, lambda$Fn91), $result);
                } else {
                    addToComponents(Lit60, Lit241, Lit239, lambda$Fn92);
                }
                this.Atommodell_von_Dalton = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit242, Lit62, lambda$Fn93), $result);
                } else {
                    addToComponents(Lit33, Lit244, Lit62, lambda$Fn94);
                }
                this.text32 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit62, Lit245, Lit246, lambda$Fn95), $result);
                } else {
                    addToComponents(Lit62, Lit248, Lit246, lambda$Fn96);
                }
                this.text33 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit62, Lit249, Lit250, lambda$Fn97), $result);
                } else {
                    addToComponents(Lit62, Lit252, Lit250, lambda$Fn98);
                }
                this.text34 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit62, Lit253, Lit254, lambda$Fn99), $result);
                } else {
                    addToComponents(Lit62, Lit256, Lit254, lambda$Fn100);
                }
                this.home = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit33, Lit257, Lit258, lambda$Fn101), $result);
                } else {
                    addToComponents(Lit33, Lit262, Lit258, lambda$Fn102);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit264, this.home$Click);
                } else {
                    addToFormEnvironment(Lit264, this.home$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "home", "Click");
                } else {
                    addToEvents(Lit258, Lit265);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "Revise and Learn!", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Chemie_App", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit11, Lit12, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Responsive", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Revision", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.FALSE, Lit14);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit20, Lit11, Lit21, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit22, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit25, Lit26, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit27, Lit28, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit20, Lit29, Lit30, Lit7);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit20, Lit11, Lit21, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit22, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit25, Lit26, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit20, Lit27, Lit28, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit20, Lit29, Lit30, Lit7);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit33, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit11, Lit34, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit33, Lit29, Lit35, Lit7);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit33, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit11, Lit34, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit33, Lit29, Lit35, Lit7);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit11, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit40, "Definition der Stoffmenge, Definition der Atommasse und Umrechnung in Gramm, Molare Masse, Molares Volumen, Aktivierungsenergie, Gasnachweise, Binäre Verbindungen, Atommodell von Dalton", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit41, "Wähle bitte ein Thema aus", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit27, Lit42, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit29, Lit43, Lit7);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit11, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit40, "Definition der Stoffmenge, Definition der Atommasse und Umrechnung in Gramm, Molare Masse, Molares Volumen, Aktivierungsenergie, Gasnachweise, Binäre Verbindungen, Atommodell von Dalton", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit41, "Wähle bitte ein Thema aus", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit27, Lit42, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit29, Lit43, Lit7);
    }

    public Object selector$AfterPicking() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Definition der Stoffmenge"), Lit46, "=") != Boolean.FALSE) {
            return runtime.setAndCoerceProperty$Ex(Lit47, Lit48, Boolean.TRUE, Lit14);
        }
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Definition der Atommasse und Umrechnung in Gramm"), Lit49, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit50, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Molare Masse"), Lit51, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit52, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Molares Volumen"), Lit53, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit54, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Aktivierungsenergie"), Lit55, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit56, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Gasnachweise"), Lit57, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit58, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Binäre Verbindungen"), Lit59, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit60, Lit48, Boolean.TRUE, Lit14) : runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit38, Lit45), "Atommodell von Dalton"), Lit61, "=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit62, Lit48, Boolean.TRUE, Lit14) : Values.empty;
    }

    public Object selector$TouchUp() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit47, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit50, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit52, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit58, Lit48, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit60, Lit48, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit11, Lit69, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit27, Lit70, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit29, Lit71, Lit7);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit11, Lit69, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit27, Lit70, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit29, Lit71, Lit7);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit47, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit47, Lit11, Lit74, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit47, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit47, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit47, Lit11, Lit74, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit47, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit77, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit77, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit77, Lit41, "<strong><u>Die Stoffmenge</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit27, Lit80, Lit7);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit77, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit77, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit77, Lit41, "<strong><u>Die Stoffmenge</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit27, Lit80, Lit7);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit83, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit41, "<ul>\n<li>Name: <b>Stoffmenge</b></li>\n<li>Formelzeichen: <b>n</b></li>\n<li>Einheit: <b>mol</b></li><li>Gibt die <b>Teilchenanzahl</b> an</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit83, Lit27, Lit85, Lit7);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit83, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit41, "<ul>\n<li>Name: <b>Stoffmenge</b></li>\n<li>Formelzeichen: <b>n</b></li>\n<li>Einheit: <b>mol</b></li><li>Gibt die <b>Teilchenanzahl</b> an</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit83, Lit27, Lit85, Lit7);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit88, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit41, "Die Einheit <b>mol</b> wird durch die Avogadro Konstante festgelegt. Das heißt also <b>1 mol = 6,022•10<sup>23</sup> teilchen</b>.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit88, Lit27, Lit89, Lit7);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit88, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit88, Lit41, "Die Einheit <b>mol</b> wird durch die Avogadro Konstante festgelegt. Das heißt also <b>1 mol = 6,022•10<sup>23</sup> teilchen</b>.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit88, Lit27, Lit89, Lit7);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit92, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit41, "<br> <<b>Berechnung der Stoffmenge mit der Teilchenzahl:</b><br>Das berechnen der Stoffmange mit der Teilchenzahl ist möglich, da die Teilchenzahl <N> proportional zu der Stoffmenge <b>u</b> ist. (Avogadro Konstante)<br><br> Ein Beispiel:<br>Gegeben: N = 10<sup>25</sup> Teilchen <br> n = N/N<sub>a</sub> = 10<sup>25</sup>/6,022•10<sup>23</sup>mol<sup>-1</sup> = 16,606 mol.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit92, Lit27, Lit93, Lit7);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit92, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit41, "<br> <<b>Berechnung der Stoffmenge mit der Teilchenzahl:</b><br>Das berechnen der Stoffmange mit der Teilchenzahl ist möglich, da die Teilchenzahl <N> proportional zu der Stoffmenge <b>u</b> ist. (Avogadro Konstante)<br><br> Ein Beispiel:<br>Gegeben: N = 10<sup>25</sup> Teilchen <br> n = N/N<sub>a</sub> = 10<sup>25</sup>/6,022•10<sup>23</sup>mol<sup>-1</sup> = 16,606 mol.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit92, Lit27, Lit93, Lit7);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit50, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit50, Lit11, Lit96, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit50, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit50, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit50, Lit11, Lit96, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit50, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit99, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit99, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit99, Lit41, "<strong><u>Die Atommasse und dessen Umrechnung in Gramm</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit99, Lit27, Lit100, Lit7);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit99, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit99, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit99, Lit41, "<strong><u>Die Atommasse und dessen Umrechnung in Gramm</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit99, Lit27, Lit100, Lit7);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit103, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit103, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit103, Lit41, "<ul>\n<li>Name: <b>absolute Atommasse</b></li>\n<li>Absolute Atommasse: <b>m<sub>a</sub></b></li>\n<li>Einheit: <b>u</b></li><li><b>1u</b> entspricht 1/12 der Masse eines Kohlenstoff-Atoms</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit103, Lit27, Lit104, Lit7);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit103, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit103, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit103, Lit41, "<ul>\n<li>Name: <b>absolute Atommasse</b></li>\n<li>Absolute Atommasse: <b>m<sub>a</sub></b></li>\n<li>Einheit: <b>u</b></li><li><b>1u</b> entspricht 1/12 der Masse eines Kohlenstoff-Atoms</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit103, Lit27, Lit104, Lit7);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit41, "Die absolute Atommasse (m<sub>a</sub>) kann mithilfe eines Massenspektrometers gemessen werden.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit27, Lit108, Lit7);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit41, "Die absolute Atommasse (m<sub>a</sub>) kann mithilfe eines Massenspektrometers gemessen werden.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit27, Lit108, Lit7);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit111, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit41, "Die Umrechnung von Unit(<b>u</b>) in Gramm(<b>g</b>): <br> 1u = 1,661•10<sup>-24</sup>g <br><br> und andersherum: <br><br> 1g = 6,022•10<sup>23</sup>u. <br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit27, Lit112, Lit7);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit111, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit41, "Die Umrechnung von Unit(<b>u</b>) in Gramm(<b>g</b>): <br> 1u = 1,661•10<sup>-24</sup>g <br><br> und andersherum: <br><br> 1g = 6,022•10<sup>23</sup>u. <br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit27, Lit112, Lit7);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit115, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit115, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit115, Lit41, "Die Masse eines Moleküls, erhält man durch die Addition der Atommassen der im Molekül gebundenen Atomen.<br> Beispiel bei einem Wasser-Molekül: <br> m<sub>a</sub>(H<sub>2</sub>O) = 2•m<sub>a</sub>(H)+m<sub>a</sub>(O)=2•1u+16u = 18u.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit27, Lit116, Lit7);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit115, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit115, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit115, Lit41, "Die Masse eines Moleküls, erhält man durch die Addition der Atommassen der im Molekül gebundenen Atomen.<br> Beispiel bei einem Wasser-Molekül: <br> m<sub>a</sub>(H<sub>2</sub>O) = 2•m<sub>a</sub>(H)+m<sub>a</sub>(O)=2•1u+16u = 18u.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit27, Lit116, Lit7);
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit52, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit52, Lit11, Lit119, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit52, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit52, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit52, Lit11, Lit119, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit52, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda36() {
        runtime.setAndCoerceProperty$Ex(Lit122, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit122, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit122, Lit41, "\n<strong><u>Die Molare Masse</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit122, Lit27, Lit123, Lit7);
    }

    static Object lambda37() {
        runtime.setAndCoerceProperty$Ex(Lit122, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit122, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit122, Lit41, "\n<strong><u>Die Molare Masse</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit122, Lit27, Lit123, Lit7);
    }

    static Object lambda38() {
        runtime.setAndCoerceProperty$Ex(Lit126, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit126, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit126, Lit41, "<ul>\n<li>Name: <b>molare Masse</b></li>\n<li>Formelzeichen: <b>M</b></li>\n<li>Einheit: <b>g/mol</b></li><li>Jeder Reinstoff besitzt eine charakteristische molare Masse</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit126, Lit27, Lit127, Lit7);
    }

    static Object lambda39() {
        runtime.setAndCoerceProperty$Ex(Lit126, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit126, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit126, Lit41, "<ul>\n<li>Name: <b>molare Masse</b></li>\n<li>Formelzeichen: <b>M</b></li>\n<li>Einheit: <b>g/mol</b></li><li>Jeder Reinstoff besitzt eine charakteristische molare Masse</li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit126, Lit27, Lit127, Lit7);
    }

    static Object lambda40() {
        runtime.setAndCoerceProperty$Ex(Lit130, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit130, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit130, Lit41, "Es gilt: <b>m = M•n</b> <br> Umgeformt: <b>M = m/n</b> <br> da <b>m ~ N</b>, bzw. <b>m ~ n</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit130, Lit27, Lit131, Lit7);
    }

    static Object lambda41() {
        runtime.setAndCoerceProperty$Ex(Lit130, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit130, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit130, Lit41, "Es gilt: <b>m = M•n</b> <br> Umgeformt: <b>M = m/n</b> <br> da <b>m ~ N</b>, bzw. <b>m ~ n</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit130, Lit27, Lit131, Lit7);
    }

    static Object lambda42() {
        runtime.setAndCoerceProperty$Ex(Lit134, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit41, "<br><b>Ermitteln der molaren Masse:</b><br> mittleren Zahlenwert aus dem PSE nehmen und g/mol anhängen.<br><br> <b>Berechnen von m mit gegebenem n:</b><br> <em>x</em> g/mol • <em>x</em> mol = <em>x</em> g.<br><br> <b>Berechnen von n bei gegebenem m:</b><br> Berechnung von 100 g Kohlenstoffdioxid. <br> n(CO<sub>2</sub>) = m(CO<sub>2</sub>)/M(CO<sub>2</sub>) = 100g/44g/m ≈ 2,3mol.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit27, Lit135, Lit7);
    }

    static Object lambda43() {
        runtime.setAndCoerceProperty$Ex(Lit134, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit41, "<br><b>Ermitteln der molaren Masse:</b><br> mittleren Zahlenwert aus dem PSE nehmen und g/mol anhängen.<br><br> <b>Berechnen von m mit gegebenem n:</b><br> <em>x</em> g/mol • <em>x</em> mol = <em>x</em> g.<br><br> <b>Berechnen von n bei gegebenem m:</b><br> Berechnung von 100 g Kohlenstoffdioxid. <br> n(CO<sub>2</sub>) = m(CO<sub>2</sub>)/M(CO<sub>2</sub>) = 100g/44g/m ≈ 2,3mol.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit27, Lit135, Lit7);
    }

    static Object lambda44() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit11, Lit138, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda45() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit11, Lit138, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda46() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit41, "\n\n<strong><u>DasMolare Volumen</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit27, Lit142, Lit7);
    }

    static Object lambda47() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit141, Lit41, "\n\n<strong><u>DasMolare Volumen</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit27, Lit142, Lit7);
    }

    /* compiled from: Revision.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Revision $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Revision)) {
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
                    if (!(obj instanceof Revision)) {
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
                    if (!(obj instanceof Revision)) {
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
                    if (!(obj instanceof Revision)) {
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
                    Revision revision = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    revision.dispatchGenericEvent(component, str, z, (Object[]) obj4);
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
                    return Revision.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Revision.lambda3();
                case 21:
                    return Revision.lambda4();
                case 22:
                    return Revision.lambda5();
                case 23:
                    return Revision.lambda6();
                case 24:
                    return Revision.lambda7();
                case 25:
                    return Revision.lambda8();
                case 26:
                    return Revision.lambda9();
                case 27:
                    return this.$main.selector$AfterPicking();
                case 28:
                    return this.$main.selector$TouchUp();
                case 29:
                    return Revision.lambda10();
                case 30:
                    return Revision.lambda11();
                case 31:
                    return Revision.lambda12();
                case 32:
                    return Revision.lambda13();
                case 33:
                    return Revision.lambda14();
                case 34:
                    return Revision.lambda15();
                case 35:
                    return Revision.lambda16();
                case 36:
                    return Revision.lambda17();
                case 37:
                    return Revision.lambda18();
                case 38:
                    return Revision.lambda19();
                case 39:
                    return Revision.lambda20();
                case 40:
                    return Revision.lambda21();
                case 41:
                    return Revision.lambda22();
                case 42:
                    return Revision.lambda23();
                case 43:
                    return Revision.lambda24();
                case 44:
                    return Revision.lambda25();
                case 45:
                    return Revision.lambda26();
                case 46:
                    return Revision.lambda27();
                case 47:
                    return Revision.lambda28();
                case 48:
                    return Revision.lambda29();
                case 49:
                    return Revision.lambda30();
                case 50:
                    return Revision.lambda31();
                case 51:
                    return Revision.lambda32();
                case 52:
                    return Revision.lambda33();
                case 53:
                    return Revision.lambda34();
                case 54:
                    return Revision.lambda35();
                case 55:
                    return Revision.lambda36();
                case 56:
                    return Revision.lambda37();
                case 57:
                    return Revision.lambda38();
                case 58:
                    return Revision.lambda39();
                case 59:
                    return Revision.lambda40();
                case 60:
                    return Revision.lambda41();
                case 61:
                    return Revision.lambda42();
                case 62:
                    return Revision.lambda43();
                case 63:
                    return Revision.lambda44();
                case 64:
                    return Revision.lambda45();
                case 65:
                    return Revision.lambda46();
                case 66:
                    return Revision.lambda47();
                case 67:
                    return Revision.lambda48();
                case 68:
                    return Revision.lambda49();
                case 69:
                    return Revision.lambda50();
                case 70:
                    return Revision.lambda51();
                case 71:
                    return Revision.lambda52();
                case 72:
                    return Revision.lambda53();
                case 73:
                    return Revision.lambda54();
                case 74:
                    return Revision.lambda55();
                case 75:
                    return Revision.lambda56();
                case 76:
                    return Revision.lambda57();
                case 77:
                    return Revision.lambda58();
                case 78:
                    return Revision.lambda59();
                case 79:
                    return Revision.lambda60();
                case 80:
                    return Revision.lambda61();
                case 81:
                    return Revision.lambda62();
                case 82:
                    return Revision.lambda63();
                case 83:
                    return Revision.lambda64();
                case 84:
                    return Revision.lambda65();
                case 85:
                    return Revision.lambda66();
                case 86:
                    return Revision.lambda67();
                case 87:
                    return Revision.lambda68();
                case 88:
                    return Revision.lambda69();
                case 89:
                    return Revision.lambda70();
                case 90:
                    return Revision.lambda71();
                case 91:
                    return Revision.lambda72();
                case 92:
                    return Revision.lambda73();
                case 93:
                    return Revision.lambda74();
                case 94:
                    return Revision.lambda75();
                case 95:
                    return Revision.lambda76();
                case 96:
                    return Revision.lambda77();
                case 97:
                    return Revision.lambda78();
                case 98:
                    return Revision.lambda79();
                case 99:
                    return Revision.lambda80();
                case 100:
                    return Revision.lambda81();
                case 101:
                    return Revision.lambda82();
                case 102:
                    return Revision.lambda83();
                case 103:
                    return Revision.lambda84();
                case 104:
                    return Revision.lambda85();
                case 105:
                    return Revision.lambda86();
                case 106:
                    return Revision.lambda87();
                case 107:
                    return Revision.lambda88();
                case 108:
                    return Revision.lambda89();
                case 109:
                    return Revision.lambda90();
                case 110:
                    return Revision.lambda91();
                case 111:
                    return Revision.lambda92();
                case 112:
                    return Revision.lambda93();
                case 113:
                    return Revision.lambda94();
                case 114:
                    return Revision.lambda95();
                case 115:
                    return Revision.lambda96();
                case 116:
                    return Revision.lambda97();
                case 117:
                    return Revision.lambda98();
                case 118:
                    return Revision.lambda99();
                case 119:
                    return Revision.lambda100();
                case 120:
                    return Revision.lambda101();
                case 121:
                    return Revision.lambda102();
                case 122:
                    return Revision.lambda103();
                case 123:
                    return this.$main.home$Click();
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
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 61:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 62:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 63:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 64:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 65:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 66:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 67:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 68:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 69:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 70:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 71:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 72:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 73:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 74:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 75:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 76:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 77:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 78:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 79:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 80:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 81:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 82:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 83:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 84:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 85:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 86:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 87:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 88:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 89:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 90:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 91:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 92:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 93:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 94:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 95:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 96:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 97:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 98:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 99:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 100:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 101:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 102:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 103:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 104:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 105:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 106:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 107:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 108:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 109:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 110:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 111:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 112:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 113:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 114:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 115:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 116:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 117:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 118:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 119:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 120:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 121:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 122:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 123:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    static Object lambda48() {
        runtime.setAndCoerceProperty$Ex(Lit145, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit145, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit145, Lit41, "<ul>\n<li>Name: <b>molares Volumen</b></li>\n<li>Formelzeichen: <b>V<sub>m</sub></b></li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit145, Lit27, Lit146, Lit7);
    }

    static Object lambda49() {
        runtime.setAndCoerceProperty$Ex(Lit145, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit145, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit145, Lit41, "<ul>\n<li>Name: <b>molares Volumen</b></li>\n<li>Formelzeichen: <b>V<sub>m</sub></b></li>\n</ul>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit145, Lit27, Lit146, Lit7);
    }

    static Object lambda50() {
        runtime.setAndCoerceProperty$Ex(Lit149, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit149, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit149, Lit41, "Es gilt: <b>V = V<sub>m</sub>•n</b> <br> Umgeformt: <b>V<sub>m</sub> = V/n</b> <br> da <b>V ~ n</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit149, Lit27, Lit150, Lit7);
    }

    static Object lambda51() {
        runtime.setAndCoerceProperty$Ex(Lit149, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit149, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit149, Lit41, "Es gilt: <b>V = V<sub>m</sub>•n</b> <br> Umgeformt: <b>V<sub>m</sub> = V/n</b> <br> da <b>V ~ n</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit149, Lit27, Lit150, Lit7);
    }

    static Object lambda52() {
        runtime.setAndCoerceProperty$Ex(Lit153, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit153, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit153, Lit41, "<br>Das molare Volumen ist sehr stark von der Temperatur abhänbgig! Es gilt für <b>Standartbedingengen</b> V<sub>m</sub> = 24,5 L/mol.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit153, Lit27, Lit154, Lit7);
    }

    static Object lambda53() {
        runtime.setAndCoerceProperty$Ex(Lit153, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit153, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit153, Lit41, "<br>Das molare Volumen ist sehr stark von der Temperatur abhänbgig! Es gilt für <b>Standartbedingengen</b> V<sub>m</sub> = 24,5 L/mol.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit153, Lit27, Lit154, Lit7);
    }

    static Object lambda54() {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit11, Lit157, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda55() {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit11, Lit157, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda56() {
        runtime.setAndCoerceProperty$Ex(Lit160, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit160, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit160, Lit41, "<strong><u>Aktivierungsenergie</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit160, Lit27, Lit161, Lit7);
    }

    static Object lambda57() {
        runtime.setAndCoerceProperty$Ex(Lit160, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit160, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit160, Lit41, "<strong><u>Aktivierungsenergie</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit160, Lit27, Lit161, Lit7);
    }

    static Object lambda58() {
        runtime.setAndCoerceProperty$Ex(Lit164, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit164, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit164, Lit41, "Bei Chemischen Reaktionen ist ein \"Startimpuls\" nötig, damit die Edukte reaktionsbereit sind. Dafür ist die Aktivierungsenergie nötig.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit164, Lit27, Lit165, Lit7);
    }

    static Object lambda59() {
        runtime.setAndCoerceProperty$Ex(Lit164, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit164, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit164, Lit41, "Bei Chemischen Reaktionen ist ein \"Startimpuls\" nötig, damit die Edukte reaktionsbereit sind. Dafür ist die Aktivierungsenergie nötig.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit164, Lit27, Lit165, Lit7);
    }

    static Object lambda60() {
        runtime.setAndCoerceProperty$Ex(Lit168, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit168, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit168, Lit41, "Es gibt auch einen sogennannten <b>Katalysator</b>, der die benötigte Aktivierungsenergie einer Chemischen Reaktion reduziert und die Reaktion beschleunigt.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit168, Lit27, Lit169, Lit7);
    }

    static Object lambda61() {
        runtime.setAndCoerceProperty$Ex(Lit168, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit168, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit168, Lit41, "Es gibt auch einen sogennannten <b>Katalysator</b>, der die benötigte Aktivierungsenergie einer Chemischen Reaktion reduziert und die Reaktion beschleunigt.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit168, Lit27, Lit169, Lit7);
    }

    static Object lambda62() {
        runtime.setAndCoerceProperty$Ex(Lit172, Lit25, Lit173, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit172, Lit174, "Aktivierungsenergie.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit172, Lit29, Lit175, Lit7);
    }

    static Object lambda63() {
        runtime.setAndCoerceProperty$Ex(Lit172, Lit25, Lit173, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit172, Lit174, "Aktivierungsenergie.png", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit172, Lit29, Lit175, Lit7);
    }

    static Object lambda64() {
        runtime.setAndCoerceProperty$Ex(Lit58, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit58, Lit11, Lit178, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit58, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda65() {
        runtime.setAndCoerceProperty$Ex(Lit58, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit58, Lit11, Lit178, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit58, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda66() {
        runtime.setAndCoerceProperty$Ex(Lit181, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit181, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit181, Lit41, "<strong><u>Gasnachweise</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit181, Lit27, Lit182, Lit7);
    }

    static Object lambda67() {
        runtime.setAndCoerceProperty$Ex(Lit181, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit181, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit181, Lit41, "<strong><u>Gasnachweise</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit181, Lit27, Lit182, Lit7);
    }

    static Object lambda68() {
        runtime.setAndCoerceProperty$Ex(Lit185, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit185, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit185, Lit41, "Gase können mit verschiedenen Techniken nachgewiesen werde.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit185, Lit27, Lit186, Lit7);
    }

    static Object lambda69() {
        runtime.setAndCoerceProperty$Ex(Lit185, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit185, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit185, Lit41, "Gase können mit verschiedenen Techniken nachgewiesen werde.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit185, Lit27, Lit186, Lit7);
    }

    static Object lambda70() {
        runtime.setAndCoerceProperty$Ex(Lit189, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit189, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit189, Lit41, "<b>Sauerstoff</b> mit der <em>Glimmspanprobe</em>:<br>->glimmenden Span in das Gas halten, flammt er wieder auf, ist Sauerstoff vorhanden.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit189, Lit27, Lit190, Lit7);
    }

    static Object lambda71() {
        runtime.setAndCoerceProperty$Ex(Lit189, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit189, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit189, Lit41, "<b>Sauerstoff</b> mit der <em>Glimmspanprobe</em>:<br>->glimmenden Span in das Gas halten, flammt er wieder auf, ist Sauerstoff vorhanden.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit189, Lit27, Lit190, Lit7);
    }

    static Object lambda72() {
        runtime.setAndCoerceProperty$Ex(Lit193, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit193, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit193, Lit41, "<br><b>Kohlenstoffdioxid</b> mit der <em>Kalkwasserproble</em>:<br>->Gas in Kalkwasser leiten. Trübt sich das Wasser, ist Kohlenstoffdioxid vorhanden.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit193, Lit27, Lit194, Lit7);
    }

    static Object lambda73() {
        runtime.setAndCoerceProperty$Ex(Lit193, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit193, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit193, Lit41, "<br><b>Kohlenstoffdioxid</b> mit der <em>Kalkwasserproble</em>:<br>->Gas in Kalkwasser leiten. Trübt sich das Wasser, ist Kohlenstoffdioxid vorhanden.", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit193, Lit27, Lit194, Lit7);
    }

    static Object lambda74() {
        runtime.setAndCoerceProperty$Ex(Lit197, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit197, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit197, Lit41, "<br><b>Wasserstoff</b> mit der <em>Knallgasprobe</em>:<br>->Reagenzglas mit dem Gas über ein Teelicht halten. Knallt es, so ist Wasserstoff vorhanden.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit197, Lit27, Lit198, Lit7);
    }

    static Object lambda75() {
        runtime.setAndCoerceProperty$Ex(Lit197, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit197, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit197, Lit41, "<br><b>Wasserstoff</b> mit der <em>Knallgasprobe</em>:<br>->Reagenzglas mit dem Gas über ein Teelicht halten. Knallt es, so ist Wasserstoff vorhanden.<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit197, Lit27, Lit198, Lit7);
    }

    static Object lambda76() {
        runtime.setAndCoerceProperty$Ex(Lit60, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit60, Lit11, Lit201, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit60, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda77() {
        runtime.setAndCoerceProperty$Ex(Lit60, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit60, Lit11, Lit201, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit60, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda78() {
        runtime.setAndCoerceProperty$Ex(Lit204, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit204, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit204, Lit41, "<strong><u>Binäre Verbindungen</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit204, Lit27, Lit205, Lit7);
    }

    static Object lambda79() {
        runtime.setAndCoerceProperty$Ex(Lit204, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit204, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit204, Lit41, "<strong><u>Binäre Verbindungen</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit204, Lit27, Lit205, Lit7);
    }

    static Object lambda80() {
        runtime.setAndCoerceProperty$Ex(Lit208, Lit209, Lit210, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit208, Lit11, Lit211, Lit7);
    }

    static Object lambda81() {
        runtime.setAndCoerceProperty$Ex(Lit208, Lit209, Lit210, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit208, Lit11, Lit211, Lit7);
    }

    static Object lambda82() {
        runtime.setAndCoerceProperty$Ex(Lit214, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit41, "Sauerstoff<br>Schwefel<br>Fluor<br>Chlor<br>Brom<br>Iod<br>Stickstoff<br>Wasserstoff", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit215, Lit216, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit214, Lit27, Lit217, Lit7);
    }

    static Object lambda83() {
        runtime.setAndCoerceProperty$Ex(Lit214, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit41, "Sauerstoff<br>Schwefel<br>Fluor<br>Chlor<br>Brom<br>Iod<br>Stickstoff<br>Wasserstoff", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit214, Lit215, Lit216, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit214, Lit27, Lit217, Lit7);
    }

    static Object lambda84() {
        runtime.setAndCoerceProperty$Ex(Lit220, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit220, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit220, Lit41, "<b>-oxid<br>-sulfid<br>-fluorid<br>-clorid<br>-bromid<br>-iodid<br>-nitrid<br>-hydrid</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit220, Lit27, Lit221, Lit7);
    }

    static Object lambda85() {
        runtime.setAndCoerceProperty$Ex(Lit220, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit220, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit220, Lit41, "<b>-oxid<br>-sulfid<br>-fluorid<br>-clorid<br>-bromid<br>-iodid<br>-nitrid<br>-hydrid</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit220, Lit27, Lit221, Lit7);
    }

    static Object lambda86() {
        runtime.setAndCoerceProperty$Ex(Lit224, Lit11, Lit225, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit25, Lit71, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit226, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit27, Lit227, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit224, Lit29, Lit228, Lit7);
    }

    static Object lambda87() {
        runtime.setAndCoerceProperty$Ex(Lit224, Lit11, Lit225, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit23, Lit24, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit25, Lit71, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit226, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit224, Lit27, Lit227, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit224, Lit29, Lit228, Lit7);
    }

    static Object lambda88() {
        runtime.setAndCoerceProperty$Ex(Lit231, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit231, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit231, Lit41, "1<br>2<br>3<br>4<br>5<br>6<br>7<br>8", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit231, Lit27, Lit232, Lit7);
    }

    static Object lambda89() {
        runtime.setAndCoerceProperty$Ex(Lit231, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit231, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit231, Lit41, "1<br>2<br>3<br>4<br>5<br>6<br>7<br>8", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit231, Lit27, Lit232, Lit7);
    }

    static Object lambda90() {
        runtime.setAndCoerceProperty$Ex(Lit235, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit235, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit235, Lit41, "<b>mono<br>di<br>tri<br>tetra<br>penta<br>hexa<br>hepta<br>octa</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit235, Lit27, Lit236, Lit7);
    }

    static Object lambda91() {
        runtime.setAndCoerceProperty$Ex(Lit235, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit235, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit235, Lit41, "<b>mono<br>di<br>tri<br>tetra<br>penta<br>hexa<br>hepta<br>octa</b>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit235, Lit27, Lit236, Lit7);
    }

    static Object lambda92() {
        runtime.setAndCoerceProperty$Ex(Lit239, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit41, "<br><b>Beispiele: </b><br> CO<sub>2</sub> - Kohlenstoff-di-oxid<br> N<sub>2</sub>O<sub>3</sub> - Di-Stickstoff-tri-oxid", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit215, Lit216, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit239, Lit27, Lit240, Lit7);
    }

    static Object lambda93() {
        runtime.setAndCoerceProperty$Ex(Lit239, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit41, "<br><b>Beispiele: </b><br> CO<sub>2</sub> - Kohlenstoff-di-oxid<br> N<sub>2</sub>O<sub>3</sub> - Di-Stickstoff-tri-oxid", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit239, Lit215, Lit216, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit239, Lit27, Lit240, Lit7);
    }

    static Object lambda94() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit11, Lit243, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda95() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit8, Lit9, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit11, Lit243, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit48, Boolean.FALSE, Lit14);
    }

    static Object lambda96() {
        runtime.setAndCoerceProperty$Ex(Lit246, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit246, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit246, Lit41, "<strong><u>Atommodell von Dalton</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit246, Lit27, Lit247, Lit7);
    }

    static Object lambda97() {
        runtime.setAndCoerceProperty$Ex(Lit246, Lit23, Lit78, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit246, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit246, Lit41, "<strong><u>Atommodell von Dalton</u></strong>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit246, Lit27, Lit247, Lit7);
    }

    static Object lambda98() {
        runtime.setAndCoerceProperty$Ex(Lit250, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit250, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit250, Lit41, "John Dalton entwickelte das Teilchenmodell zum \"Atommodell\" weiter. Dies besagt:<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit250, Lit27, Lit251, Lit7);
    }

    static Object lambda99() {
        runtime.setAndCoerceProperty$Ex(Lit250, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit250, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit250, Lit41, "John Dalton entwickelte das Teilchenmodell zum \"Atommodell\" weiter. Dies besagt:<br>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit250, Lit27, Lit251, Lit7);
    }

    static Object lambda100() {
        runtime.setAndCoerceProperty$Ex(Lit254, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit254, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit254, Lit41, "<ol>\n<li>Alle Stoffe bestehen aus <u>kleinsten</u>, <u>unteilbaren</u> Teilchen, den \"<u>Atomen.</u></li>\n<li>Es gibt genauso viele Sorten von Atomen, wie es <u>Elemente</u> gibt. Atome verschiedener Atomsorten unterscheiden sich in ihrer <u>Größe</u> und <u>Masse</u>.</li>\n<li>Bei chemischen Reaktionen werden miteinander verbundene Atome <u>getrennt</u> und in neuer <u>Kombination</u> miteinander verbunden.</li>\n</ol>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit254, Lit27, Lit255, Lit7);
    }

    static Object lambda101() {
        runtime.setAndCoerceProperty$Ex(Lit254, Lit23, Lit84, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit254, Lit79, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit254, Lit41, "<ol>\n<li>Alle Stoffe bestehen aus <u>kleinsten</u>, <u>unteilbaren</u> Teilchen, den \"<u>Atomen.</u></li>\n<li>Es gibt genauso viele Sorten von Atomen, wie es <u>Elemente</u> gibt. Atome verschiedener Atomsorten unterscheiden sich in ihrer <u>Größe</u> und <u>Masse</u>.</li>\n<li>Bei chemischen Reaktionen werden miteinander verbundene Atome <u>getrennt</u> und in neuer <u>Kombination</u> miteinander verbunden.</li>\n</ol>", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit254, Lit27, Lit255, Lit7);
    }

    static Object lambda102() {
        runtime.setAndCoerceProperty$Ex(Lit258, Lit11, Lit259, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit258, Lit41, "Home", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit258, Lit27, Lit260, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit258, Lit29, Lit261, Lit7);
    }

    static Object lambda103() {
        runtime.setAndCoerceProperty$Ex(Lit258, Lit11, Lit259, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit258, Lit41, "Home", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit258, Lit27, Lit260, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit258, Lit29, Lit261, Lit7);
    }

    public Object home$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Screen1"), Lit263, "open another screen");
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
        Revision = this;
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
