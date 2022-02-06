package com.google.youngandroid;

import android.content.Context;
import android.os.Handler;
import android.text.format.Formatter;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AssetFetcher;
import com.google.appinventor.components.runtime.util.CsvUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import com.google.appinventor.components.runtime.util.JavaStringUtils;
import com.google.appinventor.components.runtime.util.PropertyUtil;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.YailDictionary;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.util.YailNumberToString;
import com.google.appinventor.components.runtime.util.YailObject;
import gnu.bytecode.ClassType;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.CallCC;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.text.Char;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.strings;
import kawa.lib.thread;
import kawa.standard.Scheme;
import kawa.standard.expt;
import kawa.standard.syntax_case;

/* compiled from: runtime4407023393941543797.scm */
/* loaded from: classes.dex */
public class runtime extends ModuleBody implements Runnable {
    public static final ModuleMethod $Pcset$Mnand$Mncoerce$Mnproperty$Ex;
    public static final ModuleMethod $Pcset$Mnsubform$Mnlayout$Mnproperty$Ex;
    public static Object $Stalpha$Mnopaque$St;
    public static Object $Stcolor$Mnalpha$Mnposition$St;
    public static Object $Stcolor$Mnblue$Mnposition$St;
    public static Object $Stcolor$Mngreen$Mnposition$St;
    public static Object $Stcolor$Mnred$Mnposition$St;
    public static Boolean $Stdebug$St;
    public static final ModuleMethod $Stformat$Mninexact$St;
    public static Object $Stinit$Mnthunk$Mnenvironment$St;
    public static String $Stjava$Mnexception$Mnmessage$St;
    public static final Macro $Stlist$Mnfor$Mnruntime$St;
    public static Object $Stmax$Mncolor$Mncomponent$St;
    public static Object $Stnon$Mncoercible$Mnvalue$St;
    public static IntNum $Stnum$Mnconnections$St;
    public static DFloNum $Stpi$St;
    public static Random $Strandom$Mnnumber$Mngenerator$St;
    public static IntNum $Strepl$Mnport$St;
    public static String $Strepl$Mnserver$Mnaddress$St;
    public static Boolean $Strun$Mntelnet$Mnrepl$St;
    public static Object $Sttest$Mnenvironment$St;
    public static Object $Sttest$Mnglobal$Mnvar$Mnenvironment$St;
    public static Boolean $Sttesting$St;
    public static String $Stthe$Mnempty$Mnstring$Mnprinted$Mnrep$St;
    public static Object $Stthe$Mnnull$Mnvalue$Mnprinted$Mnrep$St;
    public static Object $Stthe$Mnnull$Mnvalue$St;
    public static Object $Stthis$Mnform$St;
    public static Object $Stthis$Mnis$Mnthe$Mnrepl$St;
    public static Object $Stui$Mnhandler$St;
    public static final ModuleMethod $Styail$Mnbreak$St;
    public static SimpleSymbol $Styail$Mnlist$St;
    public static Object ERROR_DIVISION_BY_ZERO;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SyntaxTemplate Lit102;
    static final SyntaxTemplate Lit111;
    static final PairWithPosition Lit131;
    static final SimpleSymbol Lit136;
    static final PairWithPosition Lit140;
    static final PairWithPosition Lit145;
    static final PairWithPosition Lit147;
    static final SimpleSymbol Lit15;
    static final PairWithPosition Lit154;
    static final IntNum Lit22;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit52;
    static final SyntaxRules Lit56;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SyntaxRules Lit83;
    static final SyntaxRules Lit87;
    static final SimpleSymbol Lit88;
    static final SyntaxTemplate Lit91;
    static final SyntaxTemplate Lit94;
    static final SimpleSymbol Lit95;
    static final SyntaxRules Lit98;
    public static final ModuleMethod acos$Mndegrees;
    public static final Macro add$Mncomponent;
    public static final ModuleMethod add$Mncomponent$Mnwithin$Mnrepl;
    public static final ModuleMethod add$Mnglobal$Mnvar$Mnto$Mncurrent$Mnform$Mnenvironment;
    public static final ModuleMethod add$Mninit$Mnthunk;
    public static final ModuleMethod add$Mnto$Mncurrent$Mnform$Mnenvironment;
    public static final ModuleMethod all$Mncoercible$Qu;
    public static final ModuleMethod alternate$Mnnumber$Mn$Grstring$Mnbinary;
    public static final ModuleMethod android$Mnlog;
    public static final ModuleMethod appinventor$Mnnumber$Mn$Grstring;
    public static final ModuleMethod array$Mn$Grlist;
    public static final ModuleMethod as$Mnnumber;
    public static final ModuleMethod asin$Mndegrees;
    public static final ModuleMethod atan$Mndegrees;
    public static final ModuleMethod atan2$Mndegrees;
    public static final ModuleMethod boolean$Mn$Grstring;
    public static final ModuleMethod call$MnInitialize$Mnof$Mncomponents;
    public static final ModuleMethod call$Mncomponent$Mnmethod;
    public static final ModuleMethod call$Mncomponent$Mntype$Mnmethod;
    public static final ModuleMethod call$Mnwith$Mncoerced$Mnargs;
    public static final ModuleMethod call$Mnyail$Mnprimitive;
    public static final ModuleMethod clarify;
    public static final ModuleMethod clarify1;
    public static final ModuleMethod clear$Mncurrent$Mnform;
    public static final ModuleMethod clear$Mninit$Mnthunks;
    public static Object clip$Mnto$Mnjava$Mnint$Mnrange;
    public static final ModuleMethod close$Mnapplication;
    public static final ModuleMethod close$Mnscreen;
    public static final ModuleMethod close$Mnscreen$Mnwith$Mnplain$Mntext;
    public static final ModuleMethod close$Mnscreen$Mnwith$Mnvalue;
    public static final ModuleMethod coerce$Mnarg;
    public static final ModuleMethod coerce$Mnargs;
    public static final ModuleMethod coerce$Mnto$Mnboolean;
    public static final ModuleMethod coerce$Mnto$Mncomponent;
    public static final ModuleMethod coerce$Mnto$Mncomponent$Mnand$Mnverify;
    public static final ModuleMethod coerce$Mnto$Mncomponent$Mnof$Mntype;
    public static final ModuleMethod coerce$Mnto$Mndictionary;
    public static final ModuleMethod coerce$Mnto$Mninstant;
    public static final ModuleMethod coerce$Mnto$Mnkey;
    public static final ModuleMethod coerce$Mnto$Mnnumber;
    public static final ModuleMethod coerce$Mnto$Mnpair;
    public static final ModuleMethod coerce$Mnto$Mnstring;
    public static final ModuleMethod coerce$Mnto$Mntext;
    public static final ModuleMethod coerce$Mnto$Mnyail$Mnlist;
    public static final ModuleMethod convert$Mnto$Mnstrings$Mnfor$Mncsv;
    public static final ModuleMethod cos$Mndegrees;
    public static final Macro define$Mnevent;
    public static final Macro define$Mnevent$Mnhelper;
    public static final Macro define$Mnform;
    public static final Macro define$Mnform$Mninternal;
    public static final Macro define$Mngeneric$Mnevent;
    public static final ModuleMethod degrees$Mn$Grradians;
    public static final ModuleMethod degrees$Mn$Grradians$Mninternal;
    public static final ModuleMethod delete$Mnfrom$Mncurrent$Mnform$Mnenvironment;
    public static final Macro foreach;
    public static final ModuleMethod format$Mnas$Mndecimal;
    public static final Macro forrange;
    public static final Macro gen$Mnevent$Mnname;
    public static final Macro gen$Mngeneric$Mnevent$Mnname;
    public static final Macro gen$Mnsimple$Mncomponent$Mntype;
    public static final ModuleMethod generate$Mnruntime$Mntype$Mnerror;
    public static final ModuleMethod get$Mndisplay$Mnrepresentation;
    public static final ModuleMethod get$Mninit$Mnthunk;
    public static Object get$Mnjson$Mndisplay$Mnrepresentation;
    public static Object get$Mnoriginal$Mndisplay$Mnrepresentation;
    public static final ModuleMethod get$Mnplain$Mnstart$Mntext;
    public static final ModuleMethod get$Mnproperty;
    public static final ModuleMethod get$Mnproperty$Mnand$Mncheck;
    public static final ModuleMethod get$Mnserver$Mnaddress$Mnfrom$Mnwifi;
    public static final ModuleMethod get$Mnstart$Mnvalue;
    static Numeric highest;
    public static final ModuleMethod in$Mnui;
    public static final ModuleMethod init$Mnruntime;
    public static final ModuleMethod insert$Mnyail$Mnlist$Mnheader;
    public static final ModuleMethod internal$Mnbinary$Mnconvert;
    public static final ModuleMethod is$Mnbase10$Qu;
    public static final ModuleMethod is$Mnbinary$Qu;
    public static final ModuleMethod is$Mncoercible$Qu;
    public static final ModuleMethod is$Mnhexadecimal$Qu;
    public static final ModuleMethod is$Mnnumber$Qu;
    public static final ModuleMethod java$Mncollection$Mn$Grkawa$Mnlist;
    public static final ModuleMethod java$Mncollection$Mn$Gryail$Mnlist;
    public static final ModuleMethod java$Mnmap$Mn$Gryail$Mndictionary;
    public static final ModuleMethod join$Mnstrings;
    public static final ModuleMethod kawa$Mnlist$Mn$Gryail$Mnlist;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn7;
    public static final ModuleMethod lookup$Mncomponent;
    public static final ModuleMethod lookup$Mnglobal$Mnvar$Mnin$Mncurrent$Mnform$Mnenvironment;
    public static final ModuleMethod lookup$Mnin$Mncurrent$Mnform$Mnenvironment;
    static Numeric lowest;
    public static final ModuleMethod make$Mncolor;
    public static final ModuleMethod make$Mndictionary$Mnpair;
    public static final ModuleMethod make$Mndisjunct;
    public static final ModuleMethod make$Mnexact$Mnyail$Mninteger;
    public static final ModuleMethod make$Mnyail$Mndictionary;
    public static final ModuleMethod make$Mnyail$Mnlist;
    public static final ModuleMethod math$Mnconvert$Mnbin$Mndec;
    public static final ModuleMethod math$Mnconvert$Mndec$Mnbin;
    public static final ModuleMethod math$Mnconvert$Mndec$Mnhex;
    public static final ModuleMethod math$Mnconvert$Mnhex$Mndec;
    public static final ModuleMethod open$Mnanother$Mnscreen;
    public static final ModuleMethod open$Mnanother$Mnscreen$Mnwith$Mnstart$Mnvalue;
    public static final ModuleMethod padded$Mnstring$Mn$Grnumber;
    public static final ModuleMethod pair$Mnok$Qu;
    public static final ModuleMethod patched$Mnnumber$Mn$Grstring$Mnbinary;
    public static final ModuleMethod process$Mnand$Mndelayed;
    public static final ModuleMethod process$Mnor$Mndelayed;
    public static final ModuleMethod radians$Mn$Grdegrees;
    public static final ModuleMethod radians$Mn$Grdegrees$Mninternal;
    public static final ModuleMethod random$Mnfraction;
    public static final ModuleMethod random$Mninteger;
    public static final ModuleMethod random$Mnset$Mnseed;
    public static final ModuleMethod remove$Mncomponent;
    public static final ModuleMethod rename$Mncomponent;
    public static final ModuleMethod rename$Mnin$Mncurrent$Mnform$Mnenvironment;
    public static final ModuleMethod reset$Mncurrent$Mnform$Mnenvironment;
    public static final ModuleMethod sanitize$Mnatomic;
    public static final ModuleMethod sanitize$Mncomponent$Mndata;
    public static final ModuleMethod send$Mnto$Mnblock;
    public static final ModuleMethod set$Mnand$Mncoerce$Mnproperty$Ex;
    public static final ModuleMethod set$Mnand$Mncoerce$Mnproperty$Mnand$Mncheck$Ex;
    public static final ModuleMethod set$Mnform$Mnname;
    public static final ModuleMethod set$Mnthis$Mnform;
    public static final ModuleMethod set$Mnyail$Mnlist$Mncontents$Ex;
    public static final ModuleMethod show$Mnarglist$Mnno$Mnparens;
    public static final ModuleMethod signal$Mnruntime$Mnerror;
    public static final ModuleMethod signal$Mnruntime$Mnform$Mnerror;
    public static final ModuleMethod sin$Mndegrees;
    public static final ModuleMethod split$Mncolor;
    public static final ModuleMethod string$Mncontains;
    public static final ModuleMethod string$Mncontains$Mnall;
    public static final ModuleMethod string$Mncontains$Mnany;
    public static final ModuleMethod string$Mnempty$Qu;
    public static final ModuleMethod string$Mnreplace;
    public static final ModuleMethod string$Mnreplace$Mnall;
    public static final ModuleMethod string$Mnreplace$Mnmappings$Mndictionary;
    public static final ModuleMethod string$Mnreplace$Mnmappings$Mnearliest$Mnoccurrence;
    public static final ModuleMethod string$Mnreplace$Mnmappings$Mnlongest$Mnstring;
    public static final ModuleMethod string$Mnreverse;
    public static final ModuleMethod string$Mnsplit;
    public static final ModuleMethod string$Mnsplit$Mnat$Mnany;
    public static final ModuleMethod string$Mnsplit$Mnat$Mnfirst;
    public static final ModuleMethod string$Mnsplit$Mnat$Mnfirst$Mnof$Mnany;
    public static final ModuleMethod string$Mnsplit$Mnat$Mnspaces;
    public static final ModuleMethod string$Mnstarts$Mnat;
    public static final ModuleMethod string$Mnsubstring;
    public static final ModuleMethod string$Mnto$Mnlower$Mncase;
    public static final ModuleMethod string$Mnto$Mnupper$Mncase;
    public static final ModuleMethod string$Mntrim;
    public static final ModuleMethod symbol$Mnappend;
    public static final ModuleMethod tan$Mndegrees;
    public static final ModuleMethod text$Mndeobfuscate;
    public static final ModuleMethod type$Mn$Grclass;
    public static final ModuleMethod unicode$Mnstring$Mn$Grlist;

    /* renamed from: while  reason: not valid java name */
    public static final Macro f5while;
    public static final ModuleMethod yail$Mnalist$Mnlookup;
    public static final ModuleMethod yail$Mnatomic$Mnequal$Qu;
    public static final ModuleMethod yail$Mnceiling;
    public static final ModuleMethod yail$Mndictionary$Mnalist$Mnto$Mndict;
    public static final ModuleMethod yail$Mndictionary$Mncombine$Mndicts;
    public static final ModuleMethod yail$Mndictionary$Mncopy;
    public static final ModuleMethod yail$Mndictionary$Mndelete$Mnpair;
    public static final ModuleMethod yail$Mndictionary$Mndict$Mnto$Mnalist;
    public static final ModuleMethod yail$Mndictionary$Mnget$Mnkeys;
    public static final ModuleMethod yail$Mndictionary$Mnget$Mnvalues;
    public static final ModuleMethod yail$Mndictionary$Mnis$Mnkey$Mnin;
    public static final ModuleMethod yail$Mndictionary$Mnlength;
    public static final ModuleMethod yail$Mndictionary$Mnlookup;
    public static final ModuleMethod yail$Mndictionary$Mnrecursive$Mnlookup;
    public static final ModuleMethod yail$Mndictionary$Mnrecursive$Mnset;
    public static final ModuleMethod yail$Mndictionary$Mnset$Mnpair;
    public static final ModuleMethod yail$Mndictionary$Mnwalk;
    public static final ModuleMethod yail$Mndictionary$Qu;
    public static final ModuleMethod yail$Mndivide;
    public static final ModuleMethod yail$Mnequal$Qu;
    public static final ModuleMethod yail$Mnfloor;
    public static final ModuleMethod yail$Mnfor$Mneach;
    public static final ModuleMethod yail$Mnfor$Mnrange;
    public static final ModuleMethod yail$Mnfor$Mnrange$Mnwith$Mnnumeric$Mnchecked$Mnargs;
    public static final ModuleMethod yail$Mnlist$Mn$Grkawa$Mnlist;
    public static final ModuleMethod yail$Mnlist$Mnadd$Mnto$Mnlist$Ex;
    public static final ModuleMethod yail$Mnlist$Mnappend$Ex;
    public static final ModuleMethod yail$Mnlist$Mncandidate$Qu;
    public static final ModuleMethod yail$Mnlist$Mncontents;
    public static final ModuleMethod yail$Mnlist$Mncopy;
    public static final ModuleMethod yail$Mnlist$Mnempty$Qu;
    public static final ModuleMethod yail$Mnlist$Mnfrom$Mncsv$Mnrow;
    public static final ModuleMethod yail$Mnlist$Mnfrom$Mncsv$Mntable;
    public static final ModuleMethod yail$Mnlist$Mnget$Mnitem;
    public static final ModuleMethod yail$Mnlist$Mnindex;
    public static final ModuleMethod yail$Mnlist$Mninsert$Mnitem$Ex;
    public static final ModuleMethod yail$Mnlist$Mnjoin$Mnwith$Mnseparator;
    public static final ModuleMethod yail$Mnlist$Mnlength;
    public static final ModuleMethod yail$Mnlist$Mnmember$Qu;
    public static final ModuleMethod yail$Mnlist$Mnpick$Mnrandom;
    public static final ModuleMethod yail$Mnlist$Mnremove$Mnitem$Ex;
    public static final ModuleMethod yail$Mnlist$Mnreverse;
    public static final ModuleMethod yail$Mnlist$Mnset$Mnitem$Ex;
    public static final ModuleMethod yail$Mnlist$Mnto$Mncsv$Mnrow;
    public static final ModuleMethod yail$Mnlist$Mnto$Mncsv$Mntable;
    public static final ModuleMethod yail$Mnlist$Qu;
    public static final ModuleMethod yail$Mnnot;
    public static final ModuleMethod yail$Mnnot$Mnequal$Qu;
    public static final ModuleMethod yail$Mnnumber$Mnrange;
    public static final ModuleMethod yail$Mnround;
    static final SimpleSymbol Lit455 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit454 = (SimpleSymbol) new SimpleSymbol("init-components").readResolve();
    static final SimpleSymbol Lit453 = (SimpleSymbol) new SimpleSymbol("init-global-variables").readResolve();
    static final SimpleSymbol Lit452 = (SimpleSymbol) new SimpleSymbol("components").readResolve();
    static final SimpleSymbol Lit451 = (SimpleSymbol) new SimpleSymbol("create-components").readResolve();
    static final SimpleSymbol Lit450 = (SimpleSymbol) new SimpleSymbol("reverse").readResolve();
    static final SimpleSymbol Lit449 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
    static final SimpleSymbol Lit448 = (SimpleSymbol) new SimpleSymbol("register-events").readResolve();
    static final SimpleSymbol Lit447 = (SimpleSymbol) new SimpleSymbol("symbols").readResolve();
    static final SimpleSymbol Lit446 = (SimpleSymbol) new SimpleSymbol("symbol->string").readResolve();
    static final SimpleSymbol Lit445 = (SimpleSymbol) new SimpleSymbol("field").readResolve();
    static final SimpleSymbol Lit444 = (SimpleSymbol) new SimpleSymbol("cadddr").readResolve();
    static final SimpleSymbol Lit443 = (SimpleSymbol) new SimpleSymbol("caddr").readResolve();
    static final SimpleSymbol Lit442 = (SimpleSymbol) new SimpleSymbol("component-descriptors").readResolve();
    static final SimpleSymbol Lit441 = (SimpleSymbol) new SimpleSymbol("component-object").readResolve();
    static final SimpleSymbol Lit440 = (SimpleSymbol) new SimpleSymbol("component-container").readResolve();
    static final SimpleSymbol Lit439 = (SimpleSymbol) new SimpleSymbol("cadr").readResolve();
    static final SimpleSymbol Lit438 = (SimpleSymbol) new SimpleSymbol("component-info").readResolve();
    static final SimpleSymbol Lit437 = (SimpleSymbol) new SimpleSymbol("var-val-pairs").readResolve();
    static final SimpleSymbol Lit436 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit435 = (SimpleSymbol) new SimpleSymbol("var-val").readResolve();
    static final SimpleSymbol Lit434 = (SimpleSymbol) new SimpleSymbol("car").readResolve();
    static final SimpleSymbol Lit433 = (SimpleSymbol) new SimpleSymbol("for-each").readResolve();
    static final SimpleSymbol Lit432 = (SimpleSymbol) new SimpleSymbol("events").readResolve();
    static final SimpleSymbol Lit431 = (SimpleSymbol) new SimpleSymbol("event-info").readResolve();
    static final SimpleSymbol Lit430 = (SimpleSymbol) new SimpleSymbol("registerEventForDelegation").readResolve();
    static final SimpleSymbol Lit429 = (SimpleSymbol) new SimpleSymbol("SimpleEventDispatcher").readResolve();
    static final SimpleSymbol Lit428 = (SimpleSymbol) new SimpleSymbol("define-alias").readResolve();
    static final SimpleSymbol Lit427 = (SimpleSymbol) new SimpleSymbol("componentName").readResolve();
    static final SimpleSymbol Lit426 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit425 = (SimpleSymbol) new SimpleSymbol("java.lang.Throwable").readResolve();
    static final SimpleSymbol Lit424 = (SimpleSymbol) new SimpleSymbol("getPermissionNeeded").readResolve();
    static final SimpleSymbol Lit423 = (SimpleSymbol) new SimpleSymbol("PermissionDenied").readResolve();
    static final SimpleSymbol Lit422 = (SimpleSymbol) new SimpleSymbol("equal?").readResolve();
    static final SimpleSymbol Lit421 = (SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.errors.PermissionException").readResolve();
    static final SimpleSymbol Lit420 = (SimpleSymbol) new SimpleSymbol("notAlreadyHandled").readResolve();
    static final SimpleSymbol Lit419 = (SimpleSymbol) new SimpleSymbol("apply").readResolve();
    static final SimpleSymbol Lit418 = (SimpleSymbol) new SimpleSymbol("try-catch").readResolve();
    static final SimpleSymbol Lit417 = (SimpleSymbol) new SimpleSymbol("handler-symbol").readResolve();
    static final SimpleSymbol Lit416 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final SimpleSymbol Lit415 = (SimpleSymbol) new SimpleSymbol("string-append").readResolve();
    static final SimpleSymbol Lit414 = (SimpleSymbol) new SimpleSymbol("string->symbol").readResolve();
    static final SimpleSymbol Lit413 = (SimpleSymbol) new SimpleSymbol("void").readResolve();
    static final SimpleSymbol Lit412 = (SimpleSymbol) new SimpleSymbol("java.lang.Object[]").readResolve();
    static final SimpleSymbol Lit411 = (SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.Component").readResolve();
    static final SimpleSymbol Lit410 = (SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.HandlesEventDispatching").readResolve();
    static final SimpleSymbol Lit409 = (SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.EventDispatcher").readResolve();
    static final SimpleSymbol Lit408 = (SimpleSymbol) new SimpleSymbol("printStackTrace").readResolve();
    static final SimpleSymbol Lit407 = (SimpleSymbol) new SimpleSymbol("process-exception").readResolve();
    static final SimpleSymbol Lit406 = (SimpleSymbol) new SimpleSymbol("and").readResolve();
    static final SimpleSymbol Lit405 = (SimpleSymbol) new SimpleSymbol("exception").readResolve();
    static final SimpleSymbol Lit404 = (SimpleSymbol) new SimpleSymbol("args").readResolve();
    static final SimpleSymbol Lit403 = (SimpleSymbol) new SimpleSymbol("handler").readResolve();
    static final SimpleSymbol Lit402 = (SimpleSymbol) new SimpleSymbol("eventName").readResolve();
    static final SimpleSymbol Lit401 = (SimpleSymbol) new SimpleSymbol("componentObject").readResolve();
    static final SimpleSymbol Lit400 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit399 = (SimpleSymbol) new SimpleSymbol("eq?").readResolve();
    static final SimpleSymbol Lit398 = (SimpleSymbol) new SimpleSymbol("registeredObject").readResolve();
    static final SimpleSymbol Lit397 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit396 = (SimpleSymbol) new SimpleSymbol("registeredComponentName").readResolve();
    static final SimpleSymbol Lit395 = (SimpleSymbol) new SimpleSymbol("java.lang.String").readResolve();
    static final SimpleSymbol Lit394 = (SimpleSymbol) new SimpleSymbol("as").readResolve();
    static final SimpleSymbol Lit393 = (SimpleSymbol) new SimpleSymbol("YailRuntimeError").readResolve();
    static final SimpleSymbol Lit392 = (SimpleSymbol) new SimpleSymbol(GetNamedPart.INSTANCEOF_METHOD_NAME).readResolve();
    static final SimpleSymbol Lit391 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
    static final SimpleSymbol Lit390 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit389 = (SimpleSymbol) new SimpleSymbol("ex").readResolve();
    static final SimpleSymbol Lit388 = (SimpleSymbol) new SimpleSymbol("this").readResolve();
    static final SimpleSymbol Lit387 = (SimpleSymbol) new SimpleSymbol("when").readResolve();
    static final SimpleSymbol Lit386 = (SimpleSymbol) new SimpleSymbol("error").readResolve();
    static final SimpleSymbol Lit385 = (SimpleSymbol) new SimpleSymbol("thunk").readResolve();
    static final SimpleSymbol Lit384 = (SimpleSymbol) new SimpleSymbol("form-do-after-creation").readResolve();
    static final SimpleSymbol Lit383 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit382 = (SimpleSymbol) new SimpleSymbol("val-thunk").readResolve();
    static final SimpleSymbol Lit381 = (SimpleSymbol) new SimpleSymbol("var").readResolve();
    static final SimpleSymbol Lit380 = (SimpleSymbol) new SimpleSymbol("global-vars-to-create").readResolve();
    static final SimpleSymbol Lit379 = (SimpleSymbol) new SimpleSymbol("init-thunk").readResolve();
    static final SimpleSymbol Lit378 = (SimpleSymbol) new SimpleSymbol("component-type").readResolve();
    static final SimpleSymbol Lit377 = (SimpleSymbol) new SimpleSymbol("container-name").readResolve();
    static final SimpleSymbol Lit376 = (SimpleSymbol) new SimpleSymbol("components-to-create").readResolve();
    static final SimpleSymbol Lit375 = (SimpleSymbol) new SimpleSymbol("set!").readResolve();
    static final SimpleSymbol Lit374 = (SimpleSymbol) new SimpleSymbol("event-name").readResolve();
    static final SimpleSymbol Lit373 = (SimpleSymbol) new SimpleSymbol("component-name").readResolve();
    static final SimpleSymbol Lit372 = (SimpleSymbol) new SimpleSymbol("cons").readResolve();
    static final SimpleSymbol Lit371 = (SimpleSymbol) new SimpleSymbol("events-to-register").readResolve();
    static final SimpleSymbol Lit370 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit369 = (SimpleSymbol) new SimpleSymbol("gnu.lists.LList").readResolve();
    static final SimpleSymbol Lit368 = (SimpleSymbol) new SimpleSymbol("global-var-environment").readResolve();
    static final SimpleSymbol Lit367 = (SimpleSymbol) new SimpleSymbol("format").readResolve();
    static final SimpleSymbol Lit366 = (SimpleSymbol) new SimpleSymbol("make").readResolve();
    static final SimpleSymbol Lit365 = (SimpleSymbol) new SimpleSymbol("isBound").readResolve();
    static final SimpleSymbol Lit364 = (SimpleSymbol) new SimpleSymbol("default-value").readResolve();
    static final SimpleSymbol Lit363 = (SimpleSymbol) new SimpleSymbol("gnu.mapping.Symbol").readResolve();
    static final SimpleSymbol Lit362 = (SimpleSymbol) new SimpleSymbol("form-environment").readResolve();
    static final SimpleSymbol Lit361 = (SimpleSymbol) new SimpleSymbol("name").readResolve();
    static final SimpleSymbol Lit360 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit359 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit358 = (SimpleSymbol) new SimpleSymbol("gnu.mapping.Environment").readResolve();
    static final SimpleSymbol Lit357 = (SimpleSymbol) new SimpleSymbol("message").readResolve();
    static final SimpleSymbol Lit356 = (SimpleSymbol) new SimpleSymbol("*debug-form*").readResolve();
    static final SimpleSymbol Lit355 = (SimpleSymbol) new SimpleSymbol("icicle").readResolve();
    static final SimpleSymbol Lit354 = (SimpleSymbol) new SimpleSymbol("onCreate").readResolve();
    static final SimpleSymbol Lit353 = (SimpleSymbol) new SimpleSymbol("::").readResolve();
    static final SimpleSymbol Lit352 = (SimpleSymbol) new SimpleSymbol("object").readResolve();
    static final SimpleSymbol Lit351 = (SimpleSymbol) new SimpleSymbol("*").readResolve();
    static final SimpleSymbol Lit350 = (SimpleSymbol) new SimpleSymbol("define").readResolve();
    static final SimpleSymbol Lit349 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit348 = (SimpleSymbol) new SimpleSymbol(LispLanguage.quote_sym).readResolve();
    static final SimpleSymbol Lit347 = (SimpleSymbol) new SimpleSymbol("*this-is-the-repl*").readResolve();
    static final SimpleSymbol Lit346 = (SimpleSymbol) new SimpleSymbol("delay").readResolve();
    static final SimpleSymbol Lit345 = (SimpleSymbol) new SimpleSymbol("proc").readResolve();
    static final SimpleSymbol Lit344 = (SimpleSymbol) new SimpleSymbol("*yail-loop*").readResolve();
    static final SimpleSymbol Lit343 = (SimpleSymbol) new SimpleSymbol("begin").readResolve();
    static final SimpleSymbol Lit342 = (SimpleSymbol) new SimpleSymbol("let").readResolve();
    static final SimpleSymbol Lit341 = (SimpleSymbol) new SimpleSymbol("lambda").readResolve();
    static final SimpleSymbol Lit340 = (SimpleSymbol) new SimpleSymbol("call-with-current-continuation").readResolve();
    static final SimpleSymbol Lit339 = (SimpleSymbol) new SimpleSymbol("loop").readResolve();
    static final SimpleSymbol Lit338 = (SimpleSymbol) new SimpleSymbol("if").readResolve();
    static final SimpleSymbol Lit337 = (SimpleSymbol) new SimpleSymbol(LispLanguage.quasiquote_sym).readResolve();
    static final SimpleSymbol Lit336 = (SimpleSymbol) new SimpleSymbol("$lookup$").readResolve();
    static final SimpleSymbol Lit335 = (SimpleSymbol) new SimpleSymbol("_").readResolve();
    static final SimpleSymbol Lit334 = (SimpleSymbol) new SimpleSymbol("clarify1").readResolve();
    static final SimpleSymbol Lit333 = (SimpleSymbol) new SimpleSymbol("clarify").readResolve();
    static final SimpleSymbol Lit332 = (SimpleSymbol) new SimpleSymbol("set-this-form").readResolve();
    static final SimpleSymbol Lit331 = (SimpleSymbol) new SimpleSymbol("init-runtime").readResolve();
    static final SimpleSymbol Lit330 = (SimpleSymbol) new SimpleSymbol("rename-component").readResolve();
    static final SimpleSymbol Lit329 = (SimpleSymbol) new SimpleSymbol("remove-component").readResolve();
    static final SimpleSymbol Lit328 = (SimpleSymbol) new SimpleSymbol("set-form-name").readResolve();
    static final SimpleSymbol Lit327 = (SimpleSymbol) new SimpleSymbol("clear-current-form").readResolve();
    static final SimpleSymbol Lit326 = (SimpleSymbol) new SimpleSymbol("send-to-block").readResolve();
    static final SimpleSymbol Lit325 = (SimpleSymbol) new SimpleSymbol("in-ui").readResolve();
    static final SyntaxRules Lit324 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\u000b", new Object[]{Lit325, Lit346}, 0)}, 2);
    static final SimpleSymbol Lit323 = (SimpleSymbol) new SimpleSymbol("process-repl-input").readResolve();
    static final SimpleSymbol Lit322 = (SimpleSymbol) new SimpleSymbol("get-server-address-from-wifi").readResolve();
    static final SimpleSymbol Lit321 = (SimpleSymbol) new SimpleSymbol("close-screen-with-plain-text").readResolve();
    static final SimpleSymbol Lit320 = (SimpleSymbol) new SimpleSymbol("get-plain-start-text").readResolve();
    static final SimpleSymbol Lit319 = (SimpleSymbol) new SimpleSymbol("close-screen-with-value").readResolve();
    static final SimpleSymbol Lit318 = (SimpleSymbol) new SimpleSymbol("get-start-value").readResolve();
    static final SimpleSymbol Lit317 = (SimpleSymbol) new SimpleSymbol("open-another-screen-with-start-value").readResolve();
    static final SimpleSymbol Lit316 = (SimpleSymbol) new SimpleSymbol("open-another-screen").readResolve();
    static final SimpleSymbol Lit315 = (SimpleSymbol) new SimpleSymbol("close-application").readResolve();
    static final SimpleSymbol Lit314 = (SimpleSymbol) new SimpleSymbol("close-screen").readResolve();
    static final SimpleSymbol Lit313 = (SimpleSymbol) new SimpleSymbol("split-color").readResolve();
    static final SimpleSymbol Lit312 = (SimpleSymbol) new SimpleSymbol("make-color").readResolve();
    static final SimpleSymbol Lit311 = (SimpleSymbol) new SimpleSymbol("make-exact-yail-integer").readResolve();
    static final SimpleSymbol Lit310 = (SimpleSymbol) new SimpleSymbol("string-replace-mappings-earliest-occurrence").readResolve();
    static final SimpleSymbol Lit309 = (SimpleSymbol) new SimpleSymbol("string-replace-mappings-longest-string").readResolve();
    static final SimpleSymbol Lit308 = (SimpleSymbol) new SimpleSymbol("string-replace-mappings-dictionary").readResolve();
    static final SimpleSymbol Lit307 = (SimpleSymbol) new SimpleSymbol("text-deobfuscate").readResolve();
    static final SimpleSymbol Lit306 = (SimpleSymbol) new SimpleSymbol("string-empty?").readResolve();
    static final SimpleSymbol Lit305 = (SimpleSymbol) new SimpleSymbol("string-replace-all").readResolve();
    static final SimpleSymbol Lit304 = (SimpleSymbol) new SimpleSymbol("string-trim").readResolve();
    static final SimpleSymbol Lit303 = (SimpleSymbol) new SimpleSymbol("string-substring").readResolve();
    static final SimpleSymbol Lit302 = (SimpleSymbol) new SimpleSymbol("string-split-at-spaces").readResolve();
    static final SimpleSymbol Lit301 = (SimpleSymbol) new SimpleSymbol("string-split-at-any").readResolve();
    static final SimpleSymbol Lit300 = (SimpleSymbol) new SimpleSymbol("string-split").readResolve();
    static final SimpleSymbol Lit299 = (SimpleSymbol) new SimpleSymbol("string-split-at-first-of-any").readResolve();
    static final SimpleSymbol Lit298 = (SimpleSymbol) new SimpleSymbol("string-split-at-first").readResolve();
    static final SimpleSymbol Lit297 = (SimpleSymbol) new SimpleSymbol("string-contains-all").readResolve();
    static final SimpleSymbol Lit296 = (SimpleSymbol) new SimpleSymbol("string-contains-any").readResolve();
    static final SimpleSymbol Lit295 = (SimpleSymbol) new SimpleSymbol("string-contains").readResolve();
    static final SimpleSymbol Lit294 = (SimpleSymbol) new SimpleSymbol("string-starts-at").readResolve();
    static final SimpleSymbol Lit293 = (SimpleSymbol) new SimpleSymbol("array->list").readResolve();
    static final SimpleSymbol Lit292 = (SimpleSymbol) new SimpleSymbol("make-disjunct").readResolve();
    static final SimpleSymbol Lit291 = (SimpleSymbol) new SimpleSymbol("yail-dictionary?").readResolve();
    static final SimpleSymbol Lit290 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-combine-dicts").readResolve();
    static final SimpleSymbol Lit289 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-copy").readResolve();
    static final SimpleSymbol Lit288 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-dict-to-alist").readResolve();
    static final SimpleSymbol Lit287 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-alist-to-dict").readResolve();
    static final SimpleSymbol Lit286 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-length").readResolve();
    static final SimpleSymbol Lit285 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-is-key-in").readResolve();
    static final SimpleSymbol Lit284 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-get-values").readResolve();
    static final SimpleSymbol Lit283 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-get-keys").readResolve();
    static final SimpleSymbol Lit282 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-recursive-set").readResolve();
    static final SimpleSymbol Lit281 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-walk").readResolve();
    static final SimpleSymbol Lit280 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-recursive-lookup").readResolve();
    static final SimpleSymbol Lit279 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-lookup").readResolve();
    static final SimpleSymbol Lit278 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-delete-pair").readResolve();
    static final SimpleSymbol Lit277 = (SimpleSymbol) new SimpleSymbol("yail-dictionary-set-pair").readResolve();
    static final SimpleSymbol Lit276 = (SimpleSymbol) new SimpleSymbol("make-dictionary-pair").readResolve();
    static final SimpleSymbol Lit275 = (SimpleSymbol) new SimpleSymbol("make-yail-dictionary").readResolve();
    static final SimpleSymbol Lit274 = (SimpleSymbol) new SimpleSymbol("yail-list-join-with-separator").readResolve();
    static final SimpleSymbol Lit273 = (SimpleSymbol) new SimpleSymbol("pair-ok?").readResolve();
    static final SimpleSymbol Lit272 = (SimpleSymbol) new SimpleSymbol("yail-alist-lookup").readResolve();
    static final SimpleSymbol Lit271 = (SimpleSymbol) new SimpleSymbol("yail-number-range").readResolve();
    static final SimpleSymbol Lit270 = (SimpleSymbol) new SimpleSymbol("yail-for-range-with-numeric-checked-args").readResolve();
    static final SimpleSymbol Lit269 = (SimpleSymbol) new SimpleSymbol("yail-for-range").readResolve();
    static final SimpleSymbol Lit268 = (SimpleSymbol) new SimpleSymbol("yail-for-each").readResolve();
    static final SimpleSymbol Lit267 = (SimpleSymbol) new SimpleSymbol("yail-list-pick-random").readResolve();
    static final SimpleSymbol Lit266 = (SimpleSymbol) new SimpleSymbol("yail-list-member?").readResolve();
    static final SimpleSymbol Lit265 = (SimpleSymbol) new SimpleSymbol("yail-list-add-to-list!").readResolve();
    static final SimpleSymbol Lit264 = (SimpleSymbol) new SimpleSymbol("yail-list-append!").readResolve();
    static final SimpleSymbol Lit263 = (SimpleSymbol) new SimpleSymbol("yail-list-insert-item!").readResolve();
    static final SimpleSymbol Lit262 = (SimpleSymbol) new SimpleSymbol("yail-list-remove-item!").readResolve();
    static final SimpleSymbol Lit261 = (SimpleSymbol) new SimpleSymbol("yail-list-set-item!").readResolve();
    static final SimpleSymbol Lit260 = (SimpleSymbol) new SimpleSymbol("yail-list-get-item").readResolve();
    static final SimpleSymbol Lit259 = (SimpleSymbol) new SimpleSymbol("yail-list-index").readResolve();
    static final SimpleSymbol Lit258 = (SimpleSymbol) new SimpleSymbol("yail-list-length").readResolve();
    static final SimpleSymbol Lit257 = (SimpleSymbol) new SimpleSymbol("yail-list-from-csv-row").readResolve();
    static final SimpleSymbol Lit256 = (SimpleSymbol) new SimpleSymbol("yail-list-from-csv-table").readResolve();
    static final SimpleSymbol Lit255 = (SimpleSymbol) new SimpleSymbol("convert-to-strings-for-csv").readResolve();
    static final SimpleSymbol Lit254 = (SimpleSymbol) new SimpleSymbol("yail-list-to-csv-row").readResolve();
    static final SimpleSymbol Lit253 = (SimpleSymbol) new SimpleSymbol("yail-list-to-csv-table").readResolve();
    static final SimpleSymbol Lit252 = (SimpleSymbol) new SimpleSymbol("yail-list-reverse").readResolve();
    static final SimpleSymbol Lit251 = (SimpleSymbol) new SimpleSymbol("yail-list-copy").readResolve();
    static final SimpleSymbol Lit250 = (SimpleSymbol) new SimpleSymbol("make-yail-list").readResolve();
    static final SimpleSymbol Lit249 = (SimpleSymbol) new SimpleSymbol("yail-list-empty?").readResolve();
    static final SimpleSymbol Lit248 = (SimpleSymbol) new SimpleSymbol("yail-list->kawa-list").readResolve();
    static final SimpleSymbol Lit247 = (SimpleSymbol) new SimpleSymbol("kawa-list->yail-list").readResolve();
    static final SimpleSymbol Lit246 = (SimpleSymbol) new SimpleSymbol("insert-yail-list-header").readResolve();
    static final SimpleSymbol Lit245 = (SimpleSymbol) new SimpleSymbol("set-yail-list-contents!").readResolve();
    static final SimpleSymbol Lit244 = (SimpleSymbol) new SimpleSymbol("yail-list-contents").readResolve();
    static final SimpleSymbol Lit243 = (SimpleSymbol) new SimpleSymbol("yail-list-candidate?").readResolve();
    static final SimpleSymbol Lit242 = (SimpleSymbol) new SimpleSymbol("yail-list?").readResolve();
    static final SimpleSymbol Lit241 = (SimpleSymbol) new SimpleSymbol("internal-binary-convert").readResolve();
    static final SimpleSymbol Lit240 = (SimpleSymbol) new SimpleSymbol("alternate-number->string-binary").readResolve();
    static final SimpleSymbol Lit239 = (SimpleSymbol) new SimpleSymbol("patched-number->string-binary").readResolve();
    static final SimpleSymbol Lit238 = (SimpleSymbol) new SimpleSymbol("math-convert-dec-bin").readResolve();
    static final SimpleSymbol Lit237 = (SimpleSymbol) new SimpleSymbol("math-convert-bin-dec").readResolve();
    static final SimpleSymbol Lit236 = (SimpleSymbol) new SimpleSymbol("math-convert-hex-dec").readResolve();
    static final SimpleSymbol Lit235 = (SimpleSymbol) new SimpleSymbol("math-convert-dec-hex").readResolve();
    static final SimpleSymbol Lit234 = (SimpleSymbol) new SimpleSymbol("is-binary?").readResolve();
    static final SimpleSymbol Lit233 = (SimpleSymbol) new SimpleSymbol("is-hexadecimal?").readResolve();
    static final SimpleSymbol Lit232 = (SimpleSymbol) new SimpleSymbol("is-base10?").readResolve();
    static final SimpleSymbol Lit231 = (SimpleSymbol) new SimpleSymbol("is-number?").readResolve();
    static final SimpleSymbol Lit230 = (SimpleSymbol) new SimpleSymbol("format-as-decimal").readResolve();
    static final SimpleSymbol Lit229 = (SimpleSymbol) new SimpleSymbol("string-reverse").readResolve();
    static final SimpleSymbol Lit228 = (SimpleSymbol) new SimpleSymbol("unicode-string->list").readResolve();
    static final SimpleSymbol Lit227 = (SimpleSymbol) new SimpleSymbol("string-to-lower-case").readResolve();
    static final SimpleSymbol Lit226 = (SimpleSymbol) new SimpleSymbol("string-to-upper-case").readResolve();
    static final SimpleSymbol Lit225 = (SimpleSymbol) new SimpleSymbol("atan2-degrees").readResolve();
    static final SimpleSymbol Lit224 = (SimpleSymbol) new SimpleSymbol("atan-degrees").readResolve();
    static final SimpleSymbol Lit223 = (SimpleSymbol) new SimpleSymbol("acos-degrees").readResolve();
    static final SimpleSymbol Lit222 = (SimpleSymbol) new SimpleSymbol("asin-degrees").readResolve();
    static final SimpleSymbol Lit221 = (SimpleSymbol) new SimpleSymbol("tan-degrees").readResolve();
    static final SimpleSymbol Lit220 = (SimpleSymbol) new SimpleSymbol("cos-degrees").readResolve();
    static final SimpleSymbol Lit219 = (SimpleSymbol) new SimpleSymbol("sin-degrees").readResolve();
    static final SimpleSymbol Lit218 = (SimpleSymbol) new SimpleSymbol("radians->degrees").readResolve();
    static final SimpleSymbol Lit217 = (SimpleSymbol) new SimpleSymbol("degrees->radians").readResolve();
    static final SimpleSymbol Lit216 = (SimpleSymbol) new SimpleSymbol("radians->degrees-internal").readResolve();
    static final SimpleSymbol Lit215 = (SimpleSymbol) new SimpleSymbol("degrees->radians-internal").readResolve();
    static final SimpleSymbol Lit214 = (SimpleSymbol) new SimpleSymbol("yail-divide").readResolve();
    static final SimpleSymbol Lit213 = (SimpleSymbol) new SimpleSymbol("random-integer").readResolve();
    static final SimpleSymbol Lit212 = (SimpleSymbol) new SimpleSymbol("random-fraction").readResolve();
    static final SimpleSymbol Lit211 = (SimpleSymbol) new SimpleSymbol("random-set-seed").readResolve();
    static final SimpleSymbol Lit210 = (SimpleSymbol) new SimpleSymbol("yail-round").readResolve();
    static final SimpleSymbol Lit209 = (SimpleSymbol) new SimpleSymbol("yail-ceiling").readResolve();
    static final SimpleSymbol Lit208 = (SimpleSymbol) new SimpleSymbol("yail-floor").readResolve();
    static final SimpleSymbol Lit207 = (SimpleSymbol) new SimpleSymbol("process-or-delayed").readResolve();
    static final SimpleSymbol Lit206 = (SimpleSymbol) new SimpleSymbol("process-and-delayed").readResolve();
    static final SimpleSymbol Lit205 = (SimpleSymbol) new SimpleSymbol("yail-not-equal?").readResolve();
    static final SimpleSymbol Lit204 = (SimpleSymbol) new SimpleSymbol("as-number").readResolve();
    static final SimpleSymbol Lit203 = (SimpleSymbol) new SimpleSymbol("yail-atomic-equal?").readResolve();
    static final SimpleSymbol Lit202 = (SimpleSymbol) new SimpleSymbol("yail-equal?").readResolve();
    static final SimpleSymbol Lit201 = (SimpleSymbol) new SimpleSymbol("appinventor-number->string").readResolve();
    static final SimpleSymbol Lit200 = (SimpleSymbol) new SimpleSymbol("*format-inexact*").readResolve();
    static final SimpleSymbol Lit199 = (SimpleSymbol) new SimpleSymbol("padded-string->number").readResolve();
    static final SimpleSymbol Lit198 = (SimpleSymbol) new SimpleSymbol("boolean->string").readResolve();
    static final SimpleSymbol Lit197 = (SimpleSymbol) new SimpleSymbol("all-coercible?").readResolve();
    static final SimpleSymbol Lit196 = (SimpleSymbol) new SimpleSymbol("is-coercible?").readResolve();
    static final SimpleSymbol Lit195 = (SimpleSymbol) new SimpleSymbol("coerce-to-boolean").readResolve();
    static final SimpleSymbol Lit194 = (SimpleSymbol) new SimpleSymbol("coerce-to-dictionary").readResolve();
    static final SimpleSymbol Lit193 = (SimpleSymbol) new SimpleSymbol("coerce-to-pair").readResolve();
    static final SimpleSymbol Lit192 = (SimpleSymbol) new SimpleSymbol("coerce-to-yail-list").readResolve();
    static final SimpleSymbol Lit191 = (SimpleSymbol) new SimpleSymbol("string-replace").readResolve();
    static final SimpleSymbol Lit190 = (SimpleSymbol) new SimpleSymbol("join-strings").readResolve();
    static final SimpleSymbol Lit189 = (SimpleSymbol) new SimpleSymbol("get-display-representation").readResolve();
    static final SimpleSymbol Lit188 = (SimpleSymbol) new SimpleSymbol("coerce-to-string").readResolve();
    static final SyntaxRules Lit187 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\b", new Object[0], 0), "", "\u0018\u0004", new Object[]{PairWithPosition.make(Lit338, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("*testing*").readResolve(), PairWithPosition.make(Boolean.TRUE, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit351, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 5824523), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("SimpleForm").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("getActiveForm").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 5824542), LList.Empty, "/tmp/runtime4407023393941543797.scm", 5824541), LList.Empty, "/tmp/runtime4407023393941543797.scm", 5824541), "/tmp/runtime4407023393941543797.scm", 5824522), LList.Empty, "/tmp/runtime4407023393941543797.scm", 5824522), "/tmp/runtime4407023393941543797.scm", 5820436), "/tmp/runtime4407023393941543797.scm", 5820426), "/tmp/runtime4407023393941543797.scm", 5820422)}, 0)}, 0);
    static final SimpleSymbol Lit186 = (SimpleSymbol) new SimpleSymbol("use-json-format").readResolve();
    static final SimpleSymbol Lit185 = (SimpleSymbol) new SimpleSymbol("coerce-to-key").readResolve();
    static final SimpleSymbol Lit184 = (SimpleSymbol) new SimpleSymbol("coerce-to-number").readResolve();
    static final SimpleSymbol Lit183 = (SimpleSymbol) new SimpleSymbol("type->class").readResolve();
    static final SimpleSymbol Lit182 = (SimpleSymbol) new SimpleSymbol("coerce-to-component-of-type").readResolve();
    static final SimpleSymbol Lit181 = (SimpleSymbol) new SimpleSymbol("coerce-to-component").readResolve();
    static final SimpleSymbol Lit180 = (SimpleSymbol) new SimpleSymbol("coerce-to-instant").readResolve();
    static final SimpleSymbol Lit179 = (SimpleSymbol) new SimpleSymbol("coerce-to-text").readResolve();
    static final SimpleSymbol Lit178 = (SimpleSymbol) new SimpleSymbol("coerce-arg").readResolve();
    static final SimpleSymbol Lit177 = (SimpleSymbol) new SimpleSymbol("coerce-args").readResolve();
    static final SimpleSymbol Lit176 = (SimpleSymbol) new SimpleSymbol("show-arglist-no-parens").readResolve();
    static final SimpleSymbol Lit175 = (SimpleSymbol) new SimpleSymbol("generate-runtime-type-error").readResolve();
    static final SimpleSymbol Lit174 = (SimpleSymbol) new SimpleSymbol("%set-subform-layout-property!").readResolve();
    static final SimpleSymbol Lit173 = (SimpleSymbol) new SimpleSymbol("%set-and-coerce-property!").readResolve();
    static final SimpleSymbol Lit172 = (SimpleSymbol) new SimpleSymbol("call-with-coerced-args").readResolve();
    static final SimpleSymbol Lit171 = (SimpleSymbol) new SimpleSymbol("yail-not").readResolve();
    static final SimpleSymbol Lit170 = (SimpleSymbol) new SimpleSymbol("signal-runtime-form-error").readResolve();
    static final SimpleSymbol Lit169 = (SimpleSymbol) new SimpleSymbol("signal-runtime-error").readResolve();
    static final SimpleSymbol Lit168 = (SimpleSymbol) new SimpleSymbol("sanitize-atomic").readResolve();
    static final SimpleSymbol Lit167 = (SimpleSymbol) new SimpleSymbol("java-map->yail-dictionary").readResolve();
    static final SimpleSymbol Lit166 = (SimpleSymbol) new SimpleSymbol("java-collection->kawa-list").readResolve();
    static final SimpleSymbol Lit165 = (SimpleSymbol) new SimpleSymbol("java-collection->yail-list").readResolve();
    static final SimpleSymbol Lit164 = (SimpleSymbol) new SimpleSymbol("sanitize-component-data").readResolve();
    static final SimpleSymbol Lit163 = (SimpleSymbol) new SimpleSymbol("call-yail-primitive").readResolve();
    static final SimpleSymbol Lit162 = (SimpleSymbol) new SimpleSymbol("call-component-type-method").readResolve();
    static final SimpleSymbol Lit161 = (SimpleSymbol) new SimpleSymbol("call-component-method").readResolve();
    static final SyntaxRules Lit160 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", new Object[0], 3), "\u0001\u0001\u0003", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\b\u0003\b\u0011\u0018\u0014\u0011\u0018\u001c\t\u0010\b\u0011\u0018$\t\u000bA\u0011\u0018,\u0011\u0015\u0013\u00184\u0018<", new Object[]{Lit340, Lit341, Lit342, Lit339, Lit338, Lit343, PairWithPosition.make(PairWithPosition.make(Lit339, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3915779), LList.Empty, "/tmp/runtime4407023393941543797.scm", 3915779), PairWithPosition.make(Lit449, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3919880)}, 1)}, 3);
    static final SimpleSymbol Lit159 = (SimpleSymbol) new SimpleSymbol("while-with-break").readResolve();
    static final SyntaxRules Lit158 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\f'\f/\b", new Object[0], 6), "\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\b\u0003\b\u0011\u0018\u0014A\u0011\u0018\f\u0011\b\u000b\b\u0013\t\u001b\t#\b+", new Object[]{Lit340, Lit341, Lit269}, 0)}, 6);
    static final SimpleSymbol Lit157 = (SimpleSymbol) new SimpleSymbol("forrange-with-break").readResolve();
    static final SyntaxRules Lit156 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", new Object[0], 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\b\u0003\b\u0011\u0018\u0014i\b\u0011\u0018\u001c\b\u0011\u0018\f\u0011\b\u000b\b\u0013\b\u0011\u0018$\u0011\u0018\u001c\b\u001b", new Object[]{Lit340, Lit341, Lit342, Lit345, Lit268}, 0)}, 4);
    static final SimpleSymbol Lit155 = (SimpleSymbol) new SimpleSymbol("foreach-with-break").readResolve();
    static final PairWithPosition Lit153 = PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3731480);
    static final PairWithPosition Lit152 = PairWithPosition.make(PairWithPosition.make(Lit344, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3727391), LList.Empty, "/tmp/runtime4407023393941543797.scm", 3727391);
    static final PairWithPosition Lit151 = PairWithPosition.make(Lit343, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3723295);
    static final PairWithPosition Lit150 = PairWithPosition.make(Lit343, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3723288);
    static final PairWithPosition Lit149 = PairWithPosition.make(Lit338, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3719188);
    static final PairWithPosition Lit148 = PairWithPosition.make(Lit342, PairWithPosition.make(Lit344, PairWithPosition.make(LList.Empty, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3715107), "/tmp/runtime4407023393941543797.scm", 3715095), "/tmp/runtime4407023393941543797.scm", 3715090);
    static final PairWithPosition Lit146 = PairWithPosition.make(Lit341, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3710992);
    static final PairWithPosition Lit144 = PairWithPosition.make(Lit342, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3710980);
    static final SimpleSymbol Lit143 = (SimpleSymbol) new SimpleSymbol("while").readResolve();
    static final PairWithPosition Lit142 = PairWithPosition.make(Lit341, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3657751);
    static final PairWithPosition Lit141 = PairWithPosition.make(Lit269, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3657735);
    static final PairWithPosition Lit139 = PairWithPosition.make(Lit341, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3653637);
    static final PairWithPosition Lit138 = PairWithPosition.make(Lit340, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3649540);
    static final SimpleSymbol Lit137 = (SimpleSymbol) new SimpleSymbol("forrange").readResolve();
    static final PairWithPosition Lit135 = PairWithPosition.make(Lit268, PairWithPosition.make(Lit345, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3579928), "/tmp/runtime4407023393941543797.scm", 3579913);
    static final PairWithPosition Lit134 = PairWithPosition.make(Lit341, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3575827);
    static final PairWithPosition Lit133 = PairWithPosition.make(Lit345, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3575821);
    static final PairWithPosition Lit132 = PairWithPosition.make(Lit342, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3575815);
    static final PairWithPosition Lit130 = PairWithPosition.make(Lit341, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3571717);
    static final PairWithPosition Lit129 = PairWithPosition.make(Lit340, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3567620);
    static final SimpleSymbol Lit128 = (SimpleSymbol) new SimpleSymbol("foreach").readResolve();
    static final SimpleSymbol Lit127 = (SimpleSymbol) new SimpleSymbol("reset-current-form-environment").readResolve();
    static final SimpleSymbol Lit126 = (SimpleSymbol) new SimpleSymbol("lookup-global-var-in-current-form-environment").readResolve();
    static final SimpleSymbol Lit125 = (SimpleSymbol) new SimpleSymbol("add-global-var-to-current-form-environment").readResolve();
    static final SimpleSymbol Lit124 = (SimpleSymbol) new SimpleSymbol("rename-in-current-form-environment").readResolve();
    static final SimpleSymbol Lit123 = (SimpleSymbol) new SimpleSymbol("delete-from-current-form-environment").readResolve();
    static final SimpleSymbol Lit122 = (SimpleSymbol) new SimpleSymbol("lookup-in-current-form-environment").readResolve();
    static final SimpleSymbol Lit121 = (SimpleSymbol) new SimpleSymbol("add-to-current-form-environment").readResolve();
    static final SyntaxRules Lit120 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", new Object[0], 1), "\u0003", "\u0011\u0018\u0004\u0011\u0018\f1\u0011\u0018\u0014\b\u0005\u0003\b\u0011\u0018\u001c\b\u0011\u0018$\b\u0011\u0018\u0014\b\u0005\u0003", new Object[]{Lit338, Lit347, Lit343, Lit383, Lit346}, 1)}, 1);
    static final SimpleSymbol Lit119 = (SimpleSymbol) new SimpleSymbol("do-after-form-creation").readResolve();
    static final SyntaxRules Lit118 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\r\u000f\b\b\b\r\u0017\u0010\b\b", new Object[0], 3), "\u0001\u0003\u0003", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\u0018\u0014¡\u0011\u0018\u001c)\u0011\u0018$\b\u0003\b\u0011\u0018,\u0019\b\r\u000b\b\u0015\u0013\b\u0011\u00184)\u0011\u0018$\b\u0003\b\u0011\u0018,\t\u0010\b\u0011\u0018,\u0019\b\r\u000b\b\u0015\u0013", new Object[]{Lit343, Lit338, Lit347, Lit125, Lit348, Lit341, Lit349}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\u0018\u0014Y\u0011\u0018\u001c)\u0011\u0018$\b\u0003\b\u000b\b\u0011\u0018,)\u0011\u0018$\b\u0003\b\u0011\u00184\t\u0010\b\u000b", new Object[]{Lit343, Lit338, Lit347, Lit125, Lit348, Lit349, Lit341}, 0)}, 3);
    static final SimpleSymbol Lit117 = (SimpleSymbol) new SimpleSymbol("def").readResolve();
    static final SyntaxTemplate Lit116 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0010", new Object[0], 0);
    static final SyntaxTemplate Lit115 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\t\u001b\b\"", new Object[0], 0);
    static final SyntaxTemplate Lit114 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0013", new Object[0], 0);
    static final SyntaxTemplate Lit113 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u000b", new Object[0], 0);
    static final SimpleSymbol Lit112 = (SimpleSymbol) new SimpleSymbol("any$").readResolve();
    static final SyntaxTemplate Lit110 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0018\u0004", new Object[]{PairWithPosition.make(Lit343, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3039242)}, 0);
    static final SyntaxPattern Lit109 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\f\u001f#", new Object[0], 5);
    static final SimpleSymbol Lit108 = (SimpleSymbol) new SimpleSymbol("define-generic-event").readResolve();
    static final SyntaxTemplate Lit107 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\b\u0011\u0018\u0004\u0011\u0018\f\u0091\u0011\u0018\u0014\u0011\u0018\u001c)\u0011\u0018$\b\u000b\b\u0011\u0018$\b\u0013\b\u0011\u0018,)\u0011\u0018$\b\u000b\b\u0011\u0018$\b\u0013", new Object[]{Lit338, Lit347, PairWithPosition.make(Lit336, Pair.make(Lit409, Pair.make(Pair.make(Lit337, Pair.make(Lit430, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2994193), PairWithPosition.make(Lit394, PairWithPosition.make(Lit410, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("*this-form*").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2998359), "/tmp/runtime4407023393941543797.scm", 2998293), "/tmp/runtime4407023393941543797.scm", 2998289), Lit348, Lit370}, 0);
    static final SyntaxTemplate Lit106 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\t\u001b\b\"", new Object[0], 0);
    static final SyntaxTemplate Lit105 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0013", new Object[0], 0);
    static final SimpleSymbol Lit104 = (SimpleSymbol) new SimpleSymbol("$").readResolve();
    static final SyntaxTemplate Lit103 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u000b", new Object[0], 0);
    static final SyntaxTemplate Lit101 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0018\u0004", new Object[]{PairWithPosition.make(Lit343, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2965514)}, 0);
    static final SyntaxPattern Lit100 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\f\u001f#", new Object[0], 5);
    static final SimpleSymbol Lit99 = (SimpleSymbol) new SimpleSymbol("define-event").readResolve();
    static final SimpleSymbol Lit97 = (SimpleSymbol) new SimpleSymbol("*list-for-runtime*").readResolve();
    static final SyntaxRules Lit96 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007,\r\u000f\b\b\b,\r\u0017\u0010\b\b\b", new Object[0], 3), "\u0001\u0003\u0003", "\u0011\u0018\u0004Ù\u0011\u0018\f)\t\u0003\b\r\u000b\b\u0011\u0018\u0014Q\b\r\t\u000b\b\u0011\u0018\u001c\b\u000b\b\u0015\u0013\b\u0011\u0018$\u0011\u0018,Y\u0011\u00184)\u0011\u0018<\b\u0003\b\u0003\b\u0011\u0018D)\u0011\u0018<\b\u0003\b\u0003", new Object[]{Lit343, Lit350, Lit342, Lit164, Lit338, Lit347, Lit121, Lit348, Lit359}, 1)}, 3);
    static final SyntaxPattern Lit93 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\b", new Object[0], 3);
    static final SimpleSymbol Lit92 = (SimpleSymbol) new SimpleSymbol("gen-generic-event-name").readResolve();
    static final SyntaxPattern Lit90 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\b", new Object[0], 3);
    static final SimpleSymbol Lit89 = (SimpleSymbol) new SimpleSymbol("gen-event-name").readResolve();
    static final SimpleSymbol Lit86 = (SimpleSymbol) new SimpleSymbol("define-form-internal").readResolve();
    static final SyntaxRules Lit85 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", new Object[]{Lit86, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.ReplForm").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1224754), "/tmp/runtime4407023393941543797.scm", 1224754), PairWithPosition.make(Boolean.TRUE, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1224808), "/tmp/runtime4407023393941543797.scm", 1224805), "/tmp/runtime4407023393941543797.scm", 1224753)}, 0)}, 2);
    static final SimpleSymbol Lit84 = (SimpleSymbol) new SimpleSymbol("define-repl-form").readResolve();
    static final SimpleSymbol Lit82 = (SimpleSymbol) new SimpleSymbol("define-form").readResolve();
    static final SyntaxRules Lit81 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", new Object[0], 1), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0010\b\u0003", new Object[]{Lit207, Lit341}, 1)}, 1);
    static final SimpleSymbol Lit80 = (SimpleSymbol) new SimpleSymbol("or-delayed").readResolve();
    static final SyntaxRules Lit79 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", new Object[0], 1), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0010\b\u0003", new Object[]{Lit206, Lit341}, 1)}, 1);
    static final SimpleSymbol Lit78 = (SimpleSymbol) new SimpleSymbol("and-delayed").readResolve();
    static final SyntaxRules Lit77 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit375}, 0)}, 2);
    static final SimpleSymbol Lit76 = (SimpleSymbol) new SimpleSymbol("set-lexical!").readResolve();
    static final SyntaxRules Lit75 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0003\u0018\u0014Á\u0011\u0018\u001c\u0091\u0011\u0018$\u0011\u0018,I\u0011\u00184\b\u0011\u0018<\b\u0003\u0018D\u0018L\b\u0003", new Object[]{Lit338, Lit392, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<java.lang.Package>").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1048606), Lit169, Lit415, "The variable ", Lit189, Lit337, PairWithPosition.make(" is not bound in the current context", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1060890), PairWithPosition.make("Unbound Variable", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1064971)}, 0)}, 1);
    static final SimpleSymbol Lit74 = (SimpleSymbol) new SimpleSymbol("lexical-value").readResolve();
    static final SyntaxRules Lit73 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u000b", new Object[]{Lit125, Lit348}, 0)}, 2);
    static final SimpleSymbol Lit72 = (SimpleSymbol) new SimpleSymbol("set-var!").readResolve();
    static final SyntaxRules Lit71 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\u0018\u0014", new Object[]{Lit126, Lit348, PairWithPosition.make(Lit449, LList.Empty, "/tmp/runtime4407023393941543797.scm", 983103)}, 0)}, 1);
    static final SimpleSymbol Lit70 = (SimpleSymbol) new SimpleSymbol("get-var").readResolve();
    static final SimpleSymbol Lit69 = (SimpleSymbol) new SimpleSymbol("set-and-coerce-property-and-check!").readResolve();
    static final SimpleSymbol Lit68 = (SimpleSymbol) new SimpleSymbol("get-property-and-check").readResolve();
    static final SimpleSymbol Lit67 = (SimpleSymbol) new SimpleSymbol("coerce-to-component-and-verify").readResolve();
    static final SimpleSymbol Lit66 = (SimpleSymbol) new SimpleSymbol("get-property").readResolve();
    static final SimpleSymbol Lit65 = (SimpleSymbol) new SimpleSymbol("set-and-coerce-property!").readResolve();
    static final SimpleSymbol Lit64 = (SimpleSymbol) new SimpleSymbol("lookup-component").readResolve();
    static final SyntaxRules Lit63 = new SyntaxRules(new Object[]{Lit335}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\b\u0003", new Object[]{Lit122, Lit348}, 0)}, 1);
    static final SimpleSymbol Lit62 = (SimpleSymbol) new SimpleSymbol("get-component").readResolve();
    static final SimpleSymbol Lit61 = (SimpleSymbol) new SimpleSymbol("clear-init-thunks").readResolve();
    static final SimpleSymbol Lit60 = (SimpleSymbol) new SimpleSymbol("get-init-thunk").readResolve();
    static final SimpleSymbol Lit59 = (SimpleSymbol) new SimpleSymbol("add-init-thunk").readResolve();
    static final SimpleSymbol Lit58 = (SimpleSymbol) new SimpleSymbol("call-Initialize-of-components").readResolve();
    static final SimpleSymbol Lit57 = (SimpleSymbol) new SimpleSymbol("add-component-within-repl").readResolve();
    static final SimpleSymbol Lit55 = (SimpleSymbol) new SimpleSymbol("add-component").readResolve();
    static final SyntaxTemplate Lit54 = new SyntaxTemplate("\u0001\u0001", "\u000b", new Object[0], 0);
    static final SyntaxPattern Lit53 = new SyntaxPattern("\f\u0007\f\u000f\b", new Object[0], 2);
    static final SimpleSymbol Lit51 = (SimpleSymbol) new SimpleSymbol("android-log").readResolve();
    static final SimpleSymbol Lit50 = (SimpleSymbol) new SimpleSymbol("post").readResolve();
    static final SimpleSymbol Lit49 = (SimpleSymbol) new SimpleSymbol("getDhcpInfo").readResolve();
    static final IntNum Lit48 = IntNum.make(9999);
    static final IntNum Lit47 = IntNum.make(4);
    static final IntNum Lit46 = IntNum.make(3);
    static final IntNum Lit45 = IntNum.make(16);
    static final IntNum Lit44 = IntNum.make(24);
    static final IntNum Lit42 = IntNum.make(8);
    static final IntNum Lit41 = IntNum.make(255);
    static final SimpleSymbol Lit40 = (SimpleSymbol) new SimpleSymbol("setValueForKeyPath").readResolve();
    static final SimpleSymbol Lit38 = (SimpleSymbol) new SimpleSymbol("*list*").readResolve();
    static final DFloNum Lit37 = DFloNum.make(1.0E18d);
    static final Char Lit36 = Char.make(57343);
    static final Char Lit35 = Char.make(55296);
    static final Char Lit34 = Char.make(57343);
    static final Char Lit33 = Char.make(55296);
    static final IntNum Lit32 = IntNum.make(45);
    static final IntNum Lit31 = IntNum.make(-1);
    static final IntNum Lit30 = IntNum.make(90);
    static final IntNum Lit29 = IntNum.make(360);
    static final DFloNum Lit28 = DFloNum.make(6.2831853d);
    static final DFloNum Lit27 = DFloNum.make(6.2831853d);
    static final IntNum Lit26 = IntNum.make(180);
    static final DFloNum Lit25 = DFloNum.make(3.14159265d);
    static final IntNum Lit24 = IntNum.make(30);
    static final IntNum Lit23 = IntNum.make(2);
    static final IntNum Lit21 = IntNum.make(1);
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("toYailDictionary").readResolve();
    static final DFloNum Lit19 = DFloNum.make(Double.NEGATIVE_INFINITY);
    static final DFloNum Lit18 = DFloNum.make(Double.POSITIVE_INFINITY);
    static final DFloNum Lit17 = DFloNum.make(Double.NEGATIVE_INFINITY);
    static final DFloNum Lit16 = DFloNum.make(Double.POSITIVE_INFINITY);
    static final SimpleSymbol Lit14 = (SimpleSymbol) new SimpleSymbol("Screen").readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol) new SimpleSymbol("any").readResolve();
    static final SimpleSymbol Lit12 = (SimpleSymbol) new SimpleSymbol("dictionary").readResolve();
    static final SimpleSymbol Lit11 = (SimpleSymbol) new SimpleSymbol("key").readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol) new SimpleSymbol("pair").readResolve();
    static final SimpleSymbol Lit9 = (SimpleSymbol) new SimpleSymbol("component").readResolve();
    static final SimpleSymbol Lit8 = (SimpleSymbol) new SimpleSymbol("InstantInTime").readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
    static final SimpleSymbol Lit4 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol) new SimpleSymbol("remove").readResolve();
    static final PairWithPosition Lit2 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol("non-coercible").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 4145184);
    public static final Class AssetFetcher = AssetFetcher.class;
    public static final Class errorMessages = ErrorMessages.class;
    public static final Class JavaMap = Map.class;
    public static final Class JavaIterator = Iterator.class;
    public static final Class JavaCollection = Collection.class;
    public static final Class JavaStringUtils = JavaStringUtils.class;
    public static final Class PermissionException = PermissionException.class;
    public static final Class YailRuntimeError = YailRuntimeError.class;
    public static final Class YailNumberToString = YailNumberToString.class;
    public static final Class YailDictionary = YailDictionary.class;
    public static final Class YailList = YailList.class;
    public static final Class Pattern = Pattern.class;
    public static final Class String = String.class;
    public static final Class Short = Short.class;
    public static final Class Long = Long.class;
    public static final Class KawaEnvironment = Environment.class;
    public static final Class Integer = Integer.class;
    public static final Class Float = Float.class;
    public static final Class Double = Double.class;
    public static final Class CsvUtil = CsvUtil.class;
    public static final ClassType SimpleForm = ClassType.make("com.google.appinventor.components.runtime.Form");
    public static final runtime $instance = new runtime();
    public static final String simple$Mncomponent$Mnpackage$Mnname = "com.google.appinventor.components.runtime";
    public static final Macro get$Mncomponent = Macro.make(Lit62, Lit63, $instance);
    public static final Macro get$Mnvar = Macro.make(Lit70, Lit71, $instance);
    public static final Macro set$Mnvar$Ex = Macro.make(Lit72, Lit73, $instance);
    public static final Macro lexical$Mnvalue = Macro.make(Lit74, Lit75, $instance);
    public static final Macro set$Mnlexical$Ex = Macro.make(Lit76, Lit77, $instance);
    public static final Macro and$Mndelayed = Macro.make(Lit78, Lit79, $instance);
    public static final Macro or$Mndelayed = Macro.make(Lit80, Lit81, $instance);
    public static final Macro define$Mnrepl$Mnform = Macro.make(Lit84, Lit85, $instance);
    public static final Macro def = Macro.make(Lit117, Lit118, $instance);
    public static final Macro do$Mnafter$Mnform$Mncreation = Macro.make(Lit119, Lit120, $instance);
    public static final Macro foreach$Mnwith$Mnbreak = Macro.make(Lit155, Lit156, $instance);
    public static final Macro forrange$Mnwith$Mnbreak = Macro.make(Lit157, Lit158, $instance);
    public static final Macro while$Mnwith$Mnbreak = Macro.make(Lit159, Lit160, $instance);
    public static final Macro use$Mnjson$Mnformat = Macro.make(Lit186, Lit187, $instance);
    public static final Macro process$Mnrepl$Mninput = Macro.make(Lit323, Lit324, $instance);

    public runtime() {
        ModuleInfo.register(this);
    }

    public static Object lookupGlobalVarInCurrentFormEnvironment(Symbol symbol) {
        return lookupGlobalVarInCurrentFormEnvironment(symbol, Boolean.FALSE);
    }

    public static Object lookupInCurrentFormEnvironment(Symbol symbol) {
        return lookupInCurrentFormEnvironment(symbol, Boolean.FALSE);
    }

    @Override // gnu.expr.ModuleBody
    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
        $Stdebug$St = Boolean.FALSE;
        $Stthis$Mnis$Mnthe$Mnrepl$St = Boolean.FALSE;
        $Sttesting$St = Boolean.FALSE;
        $Stinit$Mnthunk$Mnenvironment$St = Environment.make("init-thunk-environment");
        $Sttest$Mnenvironment$St = Environment.make("test-env");
        $Sttest$Mnglobal$Mnvar$Mnenvironment$St = Environment.make("test-global-var-env");
        $Stthe$Mnnull$Mnvalue$St = null;
        $Stthe$Mnnull$Mnvalue$Mnprinted$Mnrep$St = "*nothing*";
        $Stthe$Mnempty$Mnstring$Mnprinted$Mnrep$St = "*empty-string*";
        $Stnon$Mncoercible$Mnvalue$St = Lit2;
        $Stjava$Mnexception$Mnmessage$St = "An internal system error occurred: ";
        get$Mnoriginal$Mndisplay$Mnrepresentation = lambda$Fn4;
        get$Mnjson$Mndisplay$Mnrepresentation = lambda$Fn7;
        $Strandom$Mnnumber$Mngenerator$St = new Random();
        Object apply2 = AddOp.$Mn.apply2(expt.expt(Lit23, Lit24), Lit21);
        try {
            highest = (Numeric) apply2;
            Object apply1 = AddOp.$Mn.apply1(highest);
            try {
                lowest = (Numeric) apply1;
                clip$Mnto$Mnjava$Mnint$Mnrange = lambda$Fn11;
                ERROR_DIVISION_BY_ZERO = Integer.valueOf(ErrorMessages.ERROR_DIVISION_BY_ZERO);
                $Stpi$St = Lit25;
                $Styail$Mnlist$St = Lit38;
                $Stmax$Mncolor$Mncomponent$St = numbers.exact(Lit41);
                $Stcolor$Mnalpha$Mnposition$St = numbers.exact(Lit44);
                $Stcolor$Mnred$Mnposition$St = numbers.exact(Lit45);
                $Stcolor$Mngreen$Mnposition$St = numbers.exact(Lit42);
                $Stcolor$Mnblue$Mnposition$St = numbers.exact(Lit22);
                $Stalpha$Mnopaque$St = numbers.exact(Lit41);
                $Strun$Mntelnet$Mnrepl$St = Boolean.TRUE;
                $Stnum$Mnconnections$St = Lit21;
                $Strepl$Mnserver$Mnaddress$St = "NONE";
                $Strepl$Mnport$St = Lit48;
                $Stui$Mnhandler$St = null;
                $Stthis$Mnform$St = null;
            } catch (ClassCastException e) {
                throw new WrongType(e, "lowest", -2, apply1);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "highest", -2, apply2);
        }
    }

    public static void androidLog(Object message) {
    }

    @Override // gnu.expr.ModuleBody
    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 11:
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
            case 14:
            case 15:
            case 17:
            case 19:
            case 20:
            case 22:
            case 23:
            case 24:
            case 29:
            case 31:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 58:
            case 59:
            case 63:
            case 71:
            case 72:
            case 83:
            case 84:
            case 86:
            case 87:
            case 88:
            case 93:
            case 94:
            case 96:
            case 107:
            case 112:
            case 127:
            case 132:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 156:
            case 157:
            case 158:
            case 159:
            case ComponentConstants.TEXTBOX_PREFERRED_WIDTH /* 160 */:
            case 161:
            case 162:
            case 163:
            case 164:
            case 167:
            case 172:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
            case 187:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG /* 189 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK /* 190 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY /* 191 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE /* 192 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_DURATION /* 196 */:
            case 197:
            case 199:
            case HttpRequestContext.HTTP_OK /* 200 */:
            case ErrorMessages.ERROR_NO_CAMERA_PERMISSION /* 202 */:
            case 204:
            case 205:
            case 206:
            case 207:
            case 210:
            case 211:
            case 212:
            default:
                return super.match1(moduleMethod, obj, callContext);
            case 16:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 18:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 21:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 25:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 26:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 27:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 28:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 30:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 32:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 35:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 39:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 45:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 46:
                if (!(obj instanceof Collection)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 47:
                if (!(obj instanceof Collection)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 48:
                if (!(obj instanceof Map)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 49:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 52:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 57:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 60:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 61:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 62:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 64:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 65:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 66:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 67:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 68:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 69:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 70:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 73:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 74:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 75:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 76:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 77:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 78:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 79:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 80:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 81:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 82:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 85:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 89:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 90:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 91:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 92:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 95:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 97:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 98:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 99:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 100:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 101:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 102:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 103:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 104:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 105:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 106:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 108:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 109:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 110:
                if (!(obj instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 111:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 113:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 114:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 115:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 116:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 117:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 118:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 119:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 120:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 121:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 122:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 123:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 124:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 125:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 126:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 128:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 129:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 130:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 131:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 133:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 134:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 135:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 136:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 137:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 138:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 139:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 140:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 149:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 155:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 165:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 166:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 168:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 169:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 170:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 171:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 173:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 174:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 175:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 184:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 186:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 188:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_STOP /* 193 */:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SOURCE /* 194 */:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_FULLSCREEN /* 195 */:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 198:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case ErrorMessages.ERROR_CAMERA_NO_IMAGE_RETURNED /* 201 */:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 203:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case YaVersion.YOUNG_ANDROID_VERSION /* 208 */:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 209:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 213:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 214:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
        }
    }

    static {
        SimpleSymbol simpleSymbol = Lit340;
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("cont").readResolve();
        Lit43 = simpleSymbol2;
        Lit154 = PairWithPosition.make(PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3735590), "/tmp/runtime4407023393941543797.scm", 3735558), LList.Empty, "/tmp/runtime4407023393941543797.scm", 3735558);
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol("*yail-break*").readResolve();
        Lit136 = simpleSymbol3;
        Lit147 = PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3711000);
        Lit145 = PairWithPosition.make(Lit43, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3710986);
        Lit140 = PairWithPosition.make(Lit136, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3653645);
        Lit131 = PairWithPosition.make(Lit136, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3571725);
        SimpleSymbol simpleSymbol4 = (SimpleSymbol) new SimpleSymbol("define-event-helper").readResolve();
        Lit95 = simpleSymbol4;
        Lit111 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0018\u0004", new Object[]{PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/runtime4407023393941543797.scm", 3043340)}, 0);
        Lit102 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0000", "\u0018\u0004", new Object[]{PairWithPosition.make(Lit95, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2969612)}, 0);
        Object[] objArr = {Lit335};
        SyntaxPattern syntaxPattern = new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", new Object[0], 1);
        SimpleSymbol simpleSymbol5 = (SimpleSymbol) new SimpleSymbol("list").readResolve();
        Lit7 = simpleSymbol5;
        Lit98 = new SyntaxRules(objArr, new SyntaxRule[]{new SyntaxRule(syntaxPattern, "\u0003", "\u0011\u0018\u0004\b\u0005\u0003", new Object[]{simpleSymbol5}, 1)}, 1);
        SimpleSymbol simpleSymbol6 = (SimpleSymbol) new SimpleSymbol("symbol-append").readResolve();
        Lit88 = simpleSymbol6;
        Lit94 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\t\u000b\u0011\u0018\u0014\b\u0013", new Object[]{simpleSymbol6, PairWithPosition.make(Lit348, PairWithPosition.make(Lit112, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2736180), "/tmp/runtime4407023393941543797.scm", 2736180), PairWithPosition.make(Lit348, PairWithPosition.make(Lit104, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2736201), "/tmp/runtime4407023393941543797.scm", 2736201)}, 0);
        Lit91 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u000b\u0011\u0018\f\b\u0013", new Object[]{Lit88, PairWithPosition.make(Lit348, PairWithPosition.make(Lit104, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2703427), "/tmp/runtime4407023393941543797.scm", 2703427)}, 0);
        Object[] objArr2 = {Lit335};
        SyntaxPattern syntaxPattern2 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\f'\b", new Object[0], 5);
        SimpleSymbol simpleSymbol7 = Lit350;
        PairWithPosition make = PairWithPosition.make(Lit359, PairWithPosition.make(Lit361, PairWithPosition.make(Lit353, PairWithPosition.make(Lit363, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1347652), "/tmp/runtime4407023393941543797.scm", 1347633), "/tmp/runtime4407023393941543797.scm", 1347630), "/tmp/runtime4407023393941543797.scm", 1347625), "/tmp/runtime4407023393941543797.scm", 1347600);
        PairWithPosition make2 = PairWithPosition.make(Lit360, PairWithPosition.make(PairWithPosition.make(Lit367, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make("Adding ~A to env ~A with value ~A", PairWithPosition.make(Lit361, PairWithPosition.make(Lit362, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1351777), "/tmp/runtime4407023393941543797.scm", 1351760), "/tmp/runtime4407023393941543797.scm", 1351755), "/tmp/runtime4407023393941543797.scm", 1351719), "/tmp/runtime4407023393941543797.scm", 1351716), "/tmp/runtime4407023393941543797.scm", 1351708), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1351708), "/tmp/runtime4407023393941543797.scm", 1351690);
        SimpleSymbol simpleSymbol8 = Lit336;
        SimpleSymbol simpleSymbol9 = Lit358;
        SimpleSymbol simpleSymbol10 = Lit337;
        SimpleSymbol simpleSymbol11 = (SimpleSymbol) new SimpleSymbol("put").readResolve();
        Lit0 = simpleSymbol11;
        SimpleSymbol simpleSymbol12 = Lit350;
        PairWithPosition make3 = PairWithPosition.make(Lit400, PairWithPosition.make(Lit361, PairWithPosition.make(Lit353, PairWithPosition.make(Lit363, PairWithPosition.make(Special.optional, PairWithPosition.make(PairWithPosition.make(Lit364, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1364065), "/tmp/runtime4407023393941543797.scm", 1364050), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1364050), "/tmp/runtime4407023393941543797.scm", 1364039), "/tmp/runtime4407023393941543797.scm", 1364020), "/tmp/runtime4407023393941543797.scm", 1364017), "/tmp/runtime4407023393941543797.scm", 1364012), "/tmp/runtime4407023393941543797.scm", 1363984);
        SimpleSymbol simpleSymbol13 = Lit338;
        PairWithPosition make4 = PairWithPosition.make(Lit406, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("not").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit399, PairWithPosition.make(Lit362, PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1368110), "/tmp/runtime4407023393941543797.scm", 1368093), "/tmp/runtime4407023393941543797.scm", 1368088), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1368088), "/tmp/runtime4407023393941543797.scm", 1368083), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit358, Pair.make(Pair.make(Lit337, Pair.make(Lit365, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1372180), PairWithPosition.make(Lit362, PairWithPosition.make(Lit361, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1372229), "/tmp/runtime4407023393941543797.scm", 1372212), "/tmp/runtime4407023393941543797.scm", 1372179), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1372179), "/tmp/runtime4407023393941543797.scm", 1368083), "/tmp/runtime4407023393941543797.scm", 1368078);
        SimpleSymbol simpleSymbol14 = Lit336;
        SimpleSymbol simpleSymbol15 = Lit358;
        SimpleSymbol simpleSymbol16 = Lit337;
        SimpleSymbol simpleSymbol17 = (SimpleSymbol) new SimpleSymbol("get").readResolve();
        Lit1 = simpleSymbol17;
        SimpleSymbol simpleSymbol18 = Lit350;
        PairWithPosition make5 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve(), PairWithPosition.make(Lit401, PairWithPosition.make(Lit353, PairWithPosition.make(Lit411, PairWithPosition.make(Lit396, PairWithPosition.make(Lit353, PairWithPosition.make(Lit395, PairWithPosition.make(Lit402, PairWithPosition.make(Lit353, PairWithPosition.make(Lit395, PairWithPosition.make(Lit404, PairWithPosition.make(Lit353, PairWithPosition.make(Lit412, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1736743), "/tmp/runtime4407023393941543797.scm", 1736740), "/tmp/runtime4407023393941543797.scm", 1736735), "/tmp/runtime4407023393941543797.scm", 1732652), "/tmp/runtime4407023393941543797.scm", 1732649), "/tmp/runtime4407023393941543797.scm", 1732639), "/tmp/runtime4407023393941543797.scm", 1728570), "/tmp/runtime4407023393941543797.scm", 1728567), "/tmp/runtime4407023393941543797.scm", 1728543), "/tmp/runtime4407023393941543797.scm", 1724466), "/tmp/runtime4407023393941543797.scm", 1724463), "/tmp/runtime4407023393941543797.scm", 1724447), "/tmp/runtime4407023393941543797.scm", 1724432);
        SimpleSymbol simpleSymbol19 = Lit353;
        SimpleSymbol simpleSymbol20 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit6 = simpleSymbol20;
        SimpleSymbol simpleSymbol21 = Lit342;
        PairWithPosition make6 = PairWithPosition.make(PairWithPosition.make(Lit398, PairWithPosition.make(PairWithPosition.make(Lit414, PairWithPosition.make(Lit396, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1761332), "/tmp/runtime4407023393941543797.scm", 1761316), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1761316), "/tmp/runtime4407023393941543797.scm", 1761298), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1761297);
        SimpleSymbol simpleSymbol22 = Lit338;
        PairWithPosition make7 = PairWithPosition.make(Lit397, PairWithPosition.make(Lit398, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1765428), "/tmp/runtime4407023393941543797.scm", 1765398);
        SimpleSymbol simpleSymbol23 = Lit338;
        PairWithPosition make8 = PairWithPosition.make(Lit399, PairWithPosition.make(PairWithPosition.make(Lit400, PairWithPosition.make(Lit398, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1769531), "/tmp/runtime4407023393941543797.scm", 1769503), PairWithPosition.make(Lit401, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1769549), "/tmp/runtime4407023393941543797.scm", 1769503), "/tmp/runtime4407023393941543797.scm", 1769498);
        SimpleSymbol simpleSymbol24 = Lit342;
        PairWithPosition make9 = PairWithPosition.make(PairWithPosition.make(Lit403, PairWithPosition.make(PairWithPosition.make(Lit426, PairWithPosition.make(Lit396, PairWithPosition.make(Lit402, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1773648), "/tmp/runtime4407023393941543797.scm", 1773624), "/tmp/runtime4407023393941543797.scm", 1773608), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1773608), "/tmp/runtime4407023393941543797.scm", 1773599), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1773598);
        SimpleSymbol simpleSymbol25 = Lit418;
        SimpleSymbol simpleSymbol26 = Lit343;
        SimpleSymbol simpleSymbol27 = Lit419;
        SimpleSymbol simpleSymbol28 = Lit403;
        SimpleSymbol simpleSymbol29 = Lit336;
        SimpleSymbol simpleSymbol30 = Lit369;
        SimpleSymbol simpleSymbol31 = Lit337;
        SimpleSymbol simpleSymbol32 = (SimpleSymbol) new SimpleSymbol("makeList").readResolve();
        Lit39 = simpleSymbol32;
        PairWithPosition make10 = PairWithPosition.make(simpleSymbol29, Pair.make(simpleSymbol30, Pair.make(Pair.make(simpleSymbol31, Pair.make(simpleSymbol32, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1810484);
        SimpleSymbol simpleSymbol33 = Lit404;
        IntNum make11 = IntNum.make(0);
        Lit22 = make11;
        Lit87 = new SyntaxRules(objArr2, new SyntaxRule[]{new SyntaxRule(syntaxPattern2, "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0013)\u0011\u0018\u0014\b\u0003)\u0011\u0018\u001c\b\u000b\u0011\u0018$\u0011\u0018,Ñ\u0011\u00184\u0011\u0018<\u0011\u0018D\u0011\u0018L)\u0011\u0018T\b#\b\u0011\u0018\\\t\u0013\u0018d\u0011\u0018l\u0011\u0018tÑ\u0011\u00184\u0011\u0018|\u0011\u0018D\u0011\u0018\u0084\b\u0011\u0018\u008c\b\u0011\u0018\u0094\b\u0011\u0018\u009c\b\u000b\u0011\u0018¤\u0011\u0018¬\u0011\u0018´ā\u0011\u00184\u0011\u0018¼\u0011\u0018D\u0011\u0018\u0084\b\u0011\u0018Ä\b\u0011\u0018ÌI\u0011\u0018\u0094\b\u0011\u0018\u009c\b\u000b\u0018Ô\u0011\u0018Üa\u0011\u00184\t\u000b\u0011\u0018D\t\u0003\u0018ä\u0091\u0011\u00184\u0011\u0018ì\u0011\u0018D\u0011\u0018ô\b\u0011\u0018\u009c\b\u000b\u0011\u0018ü\u0011\u0018Ą\u0011\u0018Č\u0011\u0018Ĕ\u0011\u0018Ĝ\u0011\u0018Ĥ\u0011\u0018Ĭ\u0011\u0018Ĵ\u0011\u0018ļ\u0089\u0011\u00184\u0011\u0018ń\u0011\u0018Ō\b\u0011\u0018Ŕ\t\u001b\u0018Ŝ\u0011\u0018Ť\u0011\u0018Ŭ\u0011\u0018Ŵ\b\u0011\u00184\u0011\u0018ż\u0011\u0018D\u0011\u0018L\u0011\u0018Ƅ\u0011\u0018ƌ\u0011\u0018Ɣ\u0011\u0018Ɯ\u0011\u0018Ƥ\u0011\u0018Ƭ\u0011\u0018ƴ9\u0011\u0018Ƽ\t\u000b\u0018ǄY\u0011\u0018ǌ)\u0011\u0018\u009c\b\u000b\u0018ǔ\u0018ǜ", new Object[]{Lit343, (SimpleSymbol) new SimpleSymbol("module-extends").readResolve(), (SimpleSymbol) new SimpleSymbol("module-name").readResolve(), (SimpleSymbol) new SimpleSymbol("module-static").readResolve(), PairWithPosition.make((SimpleSymbol) new SimpleSymbol("require").readResolve(), PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<com.google.youngandroid.runtime>").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1261585), "/tmp/runtime4407023393941543797.scm", 1261576), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit416, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1269793), "/tmp/runtime4407023393941543797.scm", 1269776), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit351, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("getSimpleName").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1273867), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit351, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("getClass").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1273884), PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1273895), "/tmp/runtime4407023393941543797.scm", 1273883), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1273883), "/tmp/runtime4407023393941543797.scm", 1273866), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1273866), "/tmp/runtime4407023393941543797.scm", 1269776), "/tmp/runtime4407023393941543797.scm", 1269768), Lit350, PairWithPosition.make(Lit354, PairWithPosition.make(Lit355, PairWithPosition.make(Lit353, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("android.os.Bundle").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1282084), "/tmp/runtime4407023393941543797.scm", 1282081), "/tmp/runtime4407023393941543797.scm", 1282074), "/tmp/runtime4407023393941543797.scm", 1282064), Lit353, Lit413, PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.AppInventorCompatActivity").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("setClassicModeFromYail").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1290251), (SimpleSymbol) new SimpleSymbol("invoke-special").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1294376), PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(Lit354, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1294384), "/tmp/runtime4407023393941543797.scm", 1294384), PairWithPosition.make(Lit355, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1294393), "/tmp/runtime4407023393941543797.scm", 1294383), "/tmp/runtime4407023393941543797.scm", 1294376), PairWithPosition.make(Lit350, PairWithPosition.make(Lit356, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1302557), "/tmp/runtime4407023393941543797.scm", 1302544), "/tmp/runtime4407023393941543797.scm", 1302536), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit360, PairWithPosition.make(Lit357, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1310754), "/tmp/runtime4407023393941543797.scm", 1310736), PairWithPosition.make(PairWithPosition.make(Lit387, PairWithPosition.make(Lit356, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("android.util.Log").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("i").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1314846), PairWithPosition.make("YAIL", PairWithPosition.make(Lit357, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1314872), "/tmp/runtime4407023393941543797.scm", 1314865), "/tmp/runtime4407023393941543797.scm", 1314845), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1314845), "/tmp/runtime4407023393941543797.scm", 1314832), "/tmp/runtime4407023393941543797.scm", 1314826), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1314826), "/tmp/runtime4407023393941543797.scm", 1310736), "/tmp/runtime4407023393941543797.scm", 1310728), Lit362, Lit358, PairWithPosition.make(Lit336, Pair.make(Lit358, Pair.make(Pair.make(Lit337, Pair.make(Lit366, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1339403), Lit446, Lit348, PairWithPosition.make(simpleSymbol7, PairWithPosition.make(make, PairWithPosition.make(make2, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(simpleSymbol8, Pair.make(simpleSymbol9, Pair.make(Pair.make(simpleSymbol10, Pair.make(simpleSymbol11, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1355787), PairWithPosition.make(Lit362, PairWithPosition.make(Lit361, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1355837), "/tmp/runtime4407023393941543797.scm", 1355832), "/tmp/runtime4407023393941543797.scm", 1355815), "/tmp/runtime4407023393941543797.scm", 1355786), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1355786), "/tmp/runtime4407023393941543797.scm", 1351690), "/tmp/runtime4407023393941543797.scm", 1347600), "/tmp/runtime4407023393941543797.scm", 1347592), PairWithPosition.make(simpleSymbol12, PairWithPosition.make(make3, PairWithPosition.make(PairWithPosition.make(simpleSymbol13, PairWithPosition.make(make4, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(simpleSymbol14, Pair.make(simpleSymbol15, Pair.make(Pair.make(simpleSymbol16, Pair.make(simpleSymbol17, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1376271), PairWithPosition.make(Lit362, PairWithPosition.make(Lit361, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1376316), "/tmp/runtime4407023393941543797.scm", 1376299), "/tmp/runtime4407023393941543797.scm", 1376270), PairWithPosition.make(Lit364, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1380366), "/tmp/runtime4407023393941543797.scm", 1376270), "/tmp/runtime4407023393941543797.scm", 1368078), "/tmp/runtime4407023393941543797.scm", 1368074), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1368074), "/tmp/runtime4407023393941543797.scm", 1363984), "/tmp/runtime4407023393941543797.scm", 1363976), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit397, PairWithPosition.make(Lit361, PairWithPosition.make(Lit353, PairWithPosition.make(Lit363, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1388598), "/tmp/runtime4407023393941543797.scm", 1388595), "/tmp/runtime4407023393941543797.scm", 1388590), "/tmp/runtime4407023393941543797.scm", 1388560), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit358, Pair.make(Pair.make(Lit337, Pair.make(Lit365, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1392651), PairWithPosition.make(Lit362, PairWithPosition.make(Lit361, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1392700), "/tmp/runtime4407023393941543797.scm", 1392683), "/tmp/runtime4407023393941543797.scm", 1392650), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1392650), "/tmp/runtime4407023393941543797.scm", 1388560), "/tmp/runtime4407023393941543797.scm", 1388552), Lit368, PairWithPosition.make(Lit336, Pair.make(Lit358, Pair.make(Pair.make(Lit337, Pair.make(Lit366, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1404939), Lit415, PairWithPosition.make("-global-vars", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1413161), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit436, PairWithPosition.make(Lit361, PairWithPosition.make(Lit353, PairWithPosition.make(Lit363, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1421386), "/tmp/runtime4407023393941543797.scm", 1421367), "/tmp/runtime4407023393941543797.scm", 1421364), "/tmp/runtime4407023393941543797.scm", 1421359), "/tmp/runtime4407023393941543797.scm", 1421328), PairWithPosition.make(PairWithPosition.make(Lit360, PairWithPosition.make(PairWithPosition.make(Lit367, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make("Adding ~A to env ~A with value ~A", PairWithPosition.make(Lit361, PairWithPosition.make(Lit368, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1425511), "/tmp/runtime4407023393941543797.scm", 1425488), "/tmp/runtime4407023393941543797.scm", 1425483), "/tmp/runtime4407023393941543797.scm", 1425447), "/tmp/runtime4407023393941543797.scm", 1425444), "/tmp/runtime4407023393941543797.scm", 1425436), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1425436), "/tmp/runtime4407023393941543797.scm", 1425418), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit358, Pair.make(Pair.make(Lit337, Pair.make(Lit0, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1429515), PairWithPosition.make(Lit368, PairWithPosition.make(Lit361, PairWithPosition.make(Lit352, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1429571), "/tmp/runtime4407023393941543797.scm", 1429566), "/tmp/runtime4407023393941543797.scm", 1429543), "/tmp/runtime4407023393941543797.scm", 1429514), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1429514), "/tmp/runtime4407023393941543797.scm", 1425418), "/tmp/runtime4407023393941543797.scm", 1421328), "/tmp/runtime4407023393941543797.scm", 1421320), PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1445928), (SimpleSymbol) new SimpleSymbol("form-name-symbol").readResolve(), Lit363, PairWithPosition.make(Lit350, PairWithPosition.make(Lit371, PairWithPosition.make(Lit353, PairWithPosition.make(Lit369, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(LList.Empty, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1470520), "/tmp/runtime4407023393941543797.scm", 1470520), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1470519), "/tmp/runtime4407023393941543797.scm", 1470503), "/tmp/runtime4407023393941543797.scm", 1470500), "/tmp/runtime4407023393941543797.scm", 1470480), "/tmp/runtime4407023393941543797.scm", 1470472), PairWithPosition.make(Lit350, PairWithPosition.make(Lit376, PairWithPosition.make(Lit353, PairWithPosition.make(Lit369, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(LList.Empty, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1491002), "/tmp/runtime4407023393941543797.scm", 1491002), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1491001), "/tmp/runtime4407023393941543797.scm", 1490985), "/tmp/runtime4407023393941543797.scm", 1490982), "/tmp/runtime4407023393941543797.scm", 1490960), "/tmp/runtime4407023393941543797.scm", 1490952), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit370, PairWithPosition.make(Lit373, PairWithPosition.make(Lit374, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1507374), "/tmp/runtime4407023393941543797.scm", 1507359), "/tmp/runtime4407023393941543797.scm", 1507344), PairWithPosition.make(PairWithPosition.make(Lit375, PairWithPosition.make(Lit371, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(Lit373, PairWithPosition.make(Lit374, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1515563), "/tmp/runtime4407023393941543797.scm", 1515548), "/tmp/runtime4407023393941543797.scm", 1515542), PairWithPosition.make(Lit371, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1519638), "/tmp/runtime4407023393941543797.scm", 1515542), "/tmp/runtime4407023393941543797.scm", 1515536), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1515536), "/tmp/runtime4407023393941543797.scm", 1511440), "/tmp/runtime4407023393941543797.scm", 1511434), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1511434), "/tmp/runtime4407023393941543797.scm", 1507344), "/tmp/runtime4407023393941543797.scm", 1507336), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit455, PairWithPosition.make(Lit377, PairWithPosition.make(Lit378, PairWithPosition.make(Lit373, PairWithPosition.make(Lit379, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1536080), "/tmp/runtime4407023393941543797.scm", 1536065), "/tmp/runtime4407023393941543797.scm", 1536050), "/tmp/runtime4407023393941543797.scm", 1536035), "/tmp/runtime4407023393941543797.scm", 1536016), PairWithPosition.make(PairWithPosition.make(Lit375, PairWithPosition.make(Lit376, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(PairWithPosition.make(Lit7, PairWithPosition.make(Lit377, PairWithPosition.make(Lit378, PairWithPosition.make(Lit373, PairWithPosition.make(Lit379, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1544265), "/tmp/runtime4407023393941543797.scm", 1544250), "/tmp/runtime4407023393941543797.scm", 1544235), "/tmp/runtime4407023393941543797.scm", 1544220), "/tmp/runtime4407023393941543797.scm", 1544214), PairWithPosition.make(Lit376, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1548310), "/tmp/runtime4407023393941543797.scm", 1544214), "/tmp/runtime4407023393941543797.scm", 1544208), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1544208), "/tmp/runtime4407023393941543797.scm", 1540112), "/tmp/runtime4407023393941543797.scm", 1540106), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1540106), "/tmp/runtime4407023393941543797.scm", 1536016), "/tmp/runtime4407023393941543797.scm", 1536008), PairWithPosition.make(Lit350, PairWithPosition.make(Lit380, PairWithPosition.make(Lit353, PairWithPosition.make(Lit369, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(LList.Empty, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1560635), "/tmp/runtime4407023393941543797.scm", 1560635), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1560634), "/tmp/runtime4407023393941543797.scm", 1560618), "/tmp/runtime4407023393941543797.scm", 1560615), "/tmp/runtime4407023393941543797.scm", 1560592), "/tmp/runtime4407023393941543797.scm", 1560584), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit349, PairWithPosition.make(Lit381, PairWithPosition.make(Lit382, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1572904), "/tmp/runtime4407023393941543797.scm", 1572900), "/tmp/runtime4407023393941543797.scm", 1572880), PairWithPosition.make(PairWithPosition.make(Lit375, PairWithPosition.make(Lit380, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(PairWithPosition.make(Lit7, PairWithPosition.make(Lit381, PairWithPosition.make(Lit382, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1581088), "/tmp/runtime4407023393941543797.scm", 1581084), "/tmp/runtime4407023393941543797.scm", 1581078), PairWithPosition.make(Lit380, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1585174), "/tmp/runtime4407023393941543797.scm", 1581078), "/tmp/runtime4407023393941543797.scm", 1581072), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1581072), "/tmp/runtime4407023393941543797.scm", 1576976), "/tmp/runtime4407023393941543797.scm", 1576970), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1576970), "/tmp/runtime4407023393941543797.scm", 1572880), "/tmp/runtime4407023393941543797.scm", 1572872), PairWithPosition.make(Lit350, PairWithPosition.make(Lit384, PairWithPosition.make(Lit353, PairWithPosition.make(Lit369, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(LList.Empty, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1605692), "/tmp/runtime4407023393941543797.scm", 1605692), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1605691), "/tmp/runtime4407023393941543797.scm", 1605675), "/tmp/runtime4407023393941543797.scm", 1605672), "/tmp/runtime4407023393941543797.scm", 1605648), "/tmp/runtime4407023393941543797.scm", 1605640), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit383, PairWithPosition.make(Lit385, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1613871), "/tmp/runtime4407023393941543797.scm", 1613840), PairWithPosition.make(PairWithPosition.make(Lit375, PairWithPosition.make(Lit384, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(Lit385, PairWithPosition.make(Lit384, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1626134), "/tmp/runtime4407023393941543797.scm", 1622038), "/tmp/runtime4407023393941543797.scm", 1622032), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1622032), "/tmp/runtime4407023393941543797.scm", 1617936), "/tmp/runtime4407023393941543797.scm", 1617930), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1617930), "/tmp/runtime4407023393941543797.scm", 1613840), "/tmp/runtime4407023393941543797.scm", 1613832), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit390, PairWithPosition.make(Lit386, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1634332), "/tmp/runtime4407023393941543797.scm", 1634320), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.util.RetValManager").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("sendError").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1638411), PairWithPosition.make(Lit386, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1638482), "/tmp/runtime4407023393941543797.scm", 1638410), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1638410), "/tmp/runtime4407023393941543797.scm", 1634320), "/tmp/runtime4407023393941543797.scm", 1634312), PairWithPosition.make(Lit407, PairWithPosition.make(Lit389, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1646627), "/tmp/runtime4407023393941543797.scm", 1646608), PairWithPosition.make(Lit428, PairWithPosition.make(Lit393, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<com.google.appinventor.components.runtime.errors.YailRuntimeError>").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1650729), "/tmp/runtime4407023393941543797.scm", 1650712), "/tmp/runtime4407023393941543797.scm", 1650698), Lit338, PairWithPosition.make(PairWithPosition.make(Lit387, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1671189), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("toastAllowed").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1671189), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1671188), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit357, PairWithPosition.make(PairWithPosition.make(Lit338, PairWithPosition.make(PairWithPosition.make(Lit392, PairWithPosition.make(Lit389, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("java.lang.Error").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675317), "/tmp/runtime4407023393941543797.scm", 1675314), "/tmp/runtime4407023393941543797.scm", 1675303), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit389, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("toString").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1675335), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675334), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit389, Pair.make(Pair.make(Lit337, Pair.make(Lit391, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1675349), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675348), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675348), "/tmp/runtime4407023393941543797.scm", 1675334), "/tmp/runtime4407023393941543797.scm", 1675303), "/tmp/runtime4407023393941543797.scm", 1675299), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675299), "/tmp/runtime4407023393941543797.scm", 1675290), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675289), PairWithPosition.make(PairWithPosition.make(Lit390, PairWithPosition.make(Lit357, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1679394), "/tmp/runtime4407023393941543797.scm", 1679382), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("android.widget.Toast").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("makeText").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1683480), PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1683510), PairWithPosition.make(Lit357, PairWithPosition.make(IntNum.make(5), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1683525), "/tmp/runtime4407023393941543797.scm", 1683517), "/tmp/runtime4407023393941543797.scm", 1683510), "/tmp/runtime4407023393941543797.scm", 1683479), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("show").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1683479), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1683478), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1683478), "/tmp/runtime4407023393941543797.scm", 1679382), "/tmp/runtime4407023393941543797.scm", 1675289), "/tmp/runtime4407023393941543797.scm", 1675284), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1675284), "/tmp/runtime4407023393941543797.scm", 1671188), "/tmp/runtime4407023393941543797.scm", 1671182), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.util.RuntimeErrorAlert").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("alert").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1691663), PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1695759), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit389, Pair.make(Pair.make(Lit337, Pair.make(Lit391, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1699856), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1699855), PairWithPosition.make(PairWithPosition.make(Lit338, PairWithPosition.make(PairWithPosition.make(Lit392, PairWithPosition.make(Lit389, PairWithPosition.make(Lit393, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1703969), "/tmp/runtime4407023393941543797.scm", 1703966), "/tmp/runtime4407023393941543797.scm", 1703955), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(Lit394, PairWithPosition.make(Lit393, PairWithPosition.make(Lit389, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1704009), "/tmp/runtime4407023393941543797.scm", 1703992), "/tmp/runtime4407023393941543797.scm", 1703988), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("getErrorType").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1703988), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1703987), PairWithPosition.make("Runtime Error", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1704027), "/tmp/runtime4407023393941543797.scm", 1703987), "/tmp/runtime4407023393941543797.scm", 1703955), "/tmp/runtime4407023393941543797.scm", 1703951), PairWithPosition.make("End Application", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1708047), "/tmp/runtime4407023393941543797.scm", 1703951), "/tmp/runtime4407023393941543797.scm", 1699855), "/tmp/runtime4407023393941543797.scm", 1695759), "/tmp/runtime4407023393941543797.scm", 1691662), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1691662), "/tmp/runtime4407023393941543797.scm", 1671182), PairWithPosition.make(simpleSymbol18, PairWithPosition.make(make5, PairWithPosition.make(simpleSymbol19, PairWithPosition.make(simpleSymbol20, PairWithPosition.make(PairWithPosition.make(simpleSymbol21, PairWithPosition.make(make6, PairWithPosition.make(PairWithPosition.make(simpleSymbol22, PairWithPosition.make(make7, PairWithPosition.make(PairWithPosition.make(simpleSymbol23, PairWithPosition.make(make8, PairWithPosition.make(PairWithPosition.make(simpleSymbol24, PairWithPosition.make(make9, PairWithPosition.make(PairWithPosition.make(simpleSymbol25, PairWithPosition.make(PairWithPosition.make(simpleSymbol26, PairWithPosition.make(PairWithPosition.make(simpleSymbol27, PairWithPosition.make(simpleSymbol28, PairWithPosition.make(PairWithPosition.make(make10, PairWithPosition.make(simpleSymbol33, PairWithPosition.make(make11, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1810514), "/tmp/runtime4407023393941543797.scm", 1810509), "/tmp/runtime4407023393941543797.scm", 1810483), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1810483), "/tmp/runtime4407023393941543797.scm", 1810475), "/tmp/runtime4407023393941543797.scm", 1810468), PairWithPosition.make(Boolean.TRUE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1814564), "/tmp/runtime4407023393941543797.scm", 1810468), "/tmp/runtime4407023393941543797.scm", 1806370), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make(Lit421, PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit408, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1851430), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1851429), PairWithPosition.make(PairWithPosition.make(Lit338, PairWithPosition.make(PairWithPosition.make(Lit406, PairWithPosition.make(PairWithPosition.make(Lit399, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1867827), PairWithPosition.make(Lit401, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1867834), "/tmp/runtime4407023393941543797.scm", 1867827), "/tmp/runtime4407023393941543797.scm", 1867822), PairWithPosition.make(PairWithPosition.make(Lit422, PairWithPosition.make(Lit402, PairWithPosition.make("PermissionNeeded", LList.Empty, "/tmp/runtime4407023393941543797.scm", 1871936), "/tmp/runtime4407023393941543797.scm", 1871926), "/tmp/runtime4407023393941543797.scm", 1871918), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1871918), "/tmp/runtime4407023393941543797.scm", 1867822), "/tmp/runtime4407023393941543797.scm", 1867817), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1888316), "/tmp/runtime4407023393941543797.scm", 1888297), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1892394), Pair.make(Pair.make(Lit337, Pair.make(Lit423, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1892394), PairWithPosition.make(Lit401, PairWithPosition.make(Lit402, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit424, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1896515), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1896514), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1896514), "/tmp/runtime4407023393941543797.scm", 1892434), "/tmp/runtime4407023393941543797.scm", 1892418), "/tmp/runtime4407023393941543797.scm", 1892393), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1892393), "/tmp/runtime4407023393941543797.scm", 1888297), "/tmp/runtime4407023393941543797.scm", 1867817), "/tmp/runtime4407023393941543797.scm", 1867813), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1900581), "/tmp/runtime4407023393941543797.scm", 1867813), "/tmp/runtime4407023393941543797.scm", 1851429), "/tmp/runtime4407023393941543797.scm", 1847331), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1847331), "/tmp/runtime4407023393941543797.scm", 1843245), "/tmp/runtime4407023393941543797.scm", 1843234), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make(Lit425, PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(Lit360, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit391, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1912888), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1912887), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1912887), "/tmp/runtime4407023393941543797.scm", 1912869), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit408, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1921062), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1921061), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1925176), "/tmp/runtime4407023393941543797.scm", 1925157), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1929253), "/tmp/runtime4407023393941543797.scm", 1925157), "/tmp/runtime4407023393941543797.scm", 1921061), "/tmp/runtime4407023393941543797.scm", 1912869), "/tmp/runtime4407023393941543797.scm", 1908771), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1908771), "/tmp/runtime4407023393941543797.scm", 1904685), "/tmp/runtime4407023393941543797.scm", 1904674), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1904674), "/tmp/runtime4407023393941543797.scm", 1843234), "/tmp/runtime4407023393941543797.scm", 1806370), "/tmp/runtime4407023393941543797.scm", 1802273), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1802273), "/tmp/runtime4407023393941543797.scm", 1773598), "/tmp/runtime4407023393941543797.scm", 1773593), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1933337), "/tmp/runtime4407023393941543797.scm", 1773593), "/tmp/runtime4407023393941543797.scm", 1769498), "/tmp/runtime4407023393941543797.scm", 1769494), PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit409, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("unregisterEventForDelegation").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 1945625), PairWithPosition.make(PairWithPosition.make(Lit394, PairWithPosition.make(Lit410, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1949792), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1949792), "/tmp/runtime4407023393941543797.scm", 1949726), "/tmp/runtime4407023393941543797.scm", 1949722), PairWithPosition.make(Lit396, PairWithPosition.make(Lit402, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1953842), "/tmp/runtime4407023393941543797.scm", 1953818), "/tmp/runtime4407023393941543797.scm", 1949722), "/tmp/runtime4407023393941543797.scm", 1945624), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1957912), "/tmp/runtime4407023393941543797.scm", 1945624), "/tmp/runtime4407023393941543797.scm", 1941526), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1941526), "/tmp/runtime4407023393941543797.scm", 1769494), "/tmp/runtime4407023393941543797.scm", 1765398), "/tmp/runtime4407023393941543797.scm", 1765394), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1765394), "/tmp/runtime4407023393941543797.scm", 1761297), "/tmp/runtime4407023393941543797.scm", 1761292), LList.Empty, "/tmp/runtime4407023393941543797.scm", 1761292), "/tmp/runtime4407023393941543797.scm", 1736766), "/tmp/runtime4407023393941543797.scm", 1736763), "/tmp/runtime4407023393941543797.scm", 1724432), "/tmp/runtime4407023393941543797.scm", 1724424), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve(), PairWithPosition.make(Lit401, PairWithPosition.make(Lit353, PairWithPosition.make(Lit411, PairWithPosition.make(Lit402, PairWithPosition.make(Lit353, PairWithPosition.make(Lit395, PairWithPosition.make(Lit420, PairWithPosition.make(Lit353, PairWithPosition.make(Lit6, PairWithPosition.make(Lit404, PairWithPosition.make(Lit353, PairWithPosition.make(Lit412, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1978414), "/tmp/runtime4407023393941543797.scm", 1978411), "/tmp/runtime4407023393941543797.scm", 1978406), "/tmp/runtime4407023393941543797.scm", 1974331), "/tmp/runtime4407023393941543797.scm", 1974328), "/tmp/runtime4407023393941543797.scm", 1974310), "/tmp/runtime4407023393941543797.scm", 1970227), "/tmp/runtime4407023393941543797.scm", 1970224), "/tmp/runtime4407023393941543797.scm", 1970214), "/tmp/runtime4407023393941543797.scm", 1966137), "/tmp/runtime4407023393941543797.scm", 1966134), "/tmp/runtime4407023393941543797.scm", 1966118), "/tmp/runtime4407023393941543797.scm", 1966096), PairWithPosition.make(Lit353, PairWithPosition.make(Lit413, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("let*").readResolve(), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit417, PairWithPosition.make(PairWithPosition.make(Lit414, PairWithPosition.make(PairWithPosition.make(Lit415, PairWithPosition.make("any$", PairWithPosition.make(PairWithPosition.make(Lit416, PairWithPosition.make(Lit401, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2015320), "/tmp/runtime4407023393941543797.scm", 2015303), PairWithPosition.make("$", PairWithPosition.make(Lit402, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2015341), "/tmp/runtime4407023393941543797.scm", 2015337), "/tmp/runtime4407023393941543797.scm", 2015303), "/tmp/runtime4407023393941543797.scm", 2015296), "/tmp/runtime4407023393941543797.scm", 2015281), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2015281), "/tmp/runtime4407023393941543797.scm", 2015265), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2015265), "/tmp/runtime4407023393941543797.scm", 2015249), PairWithPosition.make(PairWithPosition.make(Lit403, PairWithPosition.make(PairWithPosition.make(Lit400, PairWithPosition.make(Lit417, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2019382), "/tmp/runtime4407023393941543797.scm", 2019354), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2019354), "/tmp/runtime4407023393941543797.scm", 2019345), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2019345), "/tmp/runtime4407023393941543797.scm", 2015248), PairWithPosition.make(PairWithPosition.make(Lit338, PairWithPosition.make(Lit403, PairWithPosition.make(PairWithPosition.make(Lit418, PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(Lit419, PairWithPosition.make(Lit403, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(Lit401, PairWithPosition.make(PairWithPosition.make(Lit372, PairWithPosition.make(Lit420, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit369, Pair.make(Pair.make(Lit337, Pair.make(Lit39, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2035793), PairWithPosition.make(Lit404, PairWithPosition.make(Lit22, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2035823), "/tmp/runtime4407023393941543797.scm", 2035818), "/tmp/runtime4407023393941543797.scm", 2035792), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2035792), "/tmp/runtime4407023393941543797.scm", 2035774), "/tmp/runtime4407023393941543797.scm", 2035768), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2035768), "/tmp/runtime4407023393941543797.scm", 2035752), "/tmp/runtime4407023393941543797.scm", 2035746), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2035746), "/tmp/runtime4407023393941543797.scm", 2035738), "/tmp/runtime4407023393941543797.scm", 2035731), PairWithPosition.make(Boolean.TRUE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2039827), "/tmp/runtime4407023393941543797.scm", 2035731), "/tmp/runtime4407023393941543797.scm", 2031633), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make(Lit421, PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit408, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2052117), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2052116), PairWithPosition.make(PairWithPosition.make(Lit338, PairWithPosition.make(PairWithPosition.make(Lit406, PairWithPosition.make(PairWithPosition.make(Lit399, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2068514), PairWithPosition.make(Lit401, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2068521), "/tmp/runtime4407023393941543797.scm", 2068514), "/tmp/runtime4407023393941543797.scm", 2068509), PairWithPosition.make(PairWithPosition.make(Lit422, PairWithPosition.make(Lit402, PairWithPosition.make("PermissionNeeded", LList.Empty, "/tmp/runtime4407023393941543797.scm", 2072623), "/tmp/runtime4407023393941543797.scm", 2072613), "/tmp/runtime4407023393941543797.scm", 2072605), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2072605), "/tmp/runtime4407023393941543797.scm", 2068509), "/tmp/runtime4407023393941543797.scm", 2068504), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2089003), "/tmp/runtime4407023393941543797.scm", 2088984), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2093081), Pair.make(Pair.make(Lit337, Pair.make(Lit423, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2093081), PairWithPosition.make(Lit401, PairWithPosition.make(Lit402, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit424, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2097178), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2097177), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2097177), "/tmp/runtime4407023393941543797.scm", 2093121), "/tmp/runtime4407023393941543797.scm", 2093105), "/tmp/runtime4407023393941543797.scm", 2093080), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2093080), "/tmp/runtime4407023393941543797.scm", 2088984), "/tmp/runtime4407023393941543797.scm", 2068504), "/tmp/runtime4407023393941543797.scm", 2068500), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2101268), "/tmp/runtime4407023393941543797.scm", 2068500), "/tmp/runtime4407023393941543797.scm", 2052116), "/tmp/runtime4407023393941543797.scm", 2048018), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2048018), "/tmp/runtime4407023393941543797.scm", 2043932), "/tmp/runtime4407023393941543797.scm", 2043921), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make(Lit425, PairWithPosition.make(PairWithPosition.make(Lit343, PairWithPosition.make(PairWithPosition.make(Lit360, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit391, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2113575), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2113574), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2113574), "/tmp/runtime4407023393941543797.scm", 2113556), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit408, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2121749), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2121748), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2125863), "/tmp/runtime4407023393941543797.scm", 2125844), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2129940), "/tmp/runtime4407023393941543797.scm", 2125844), "/tmp/runtime4407023393941543797.scm", 2121748), "/tmp/runtime4407023393941543797.scm", 2113556), "/tmp/runtime4407023393941543797.scm", 2109458), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2109458), "/tmp/runtime4407023393941543797.scm", 2105372), "/tmp/runtime4407023393941543797.scm", 2105361), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2105361), "/tmp/runtime4407023393941543797.scm", 2043921), "/tmp/runtime4407023393941543797.scm", 2031633), "/tmp/runtime4407023393941543797.scm", 2027536), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2027536), "/tmp/runtime4407023393941543797.scm", 2023440), "/tmp/runtime4407023393941543797.scm", 2023436), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2023436), "/tmp/runtime4407023393941543797.scm", 2015248), "/tmp/runtime4407023393941543797.scm", 2015242), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2015242), "/tmp/runtime4407023393941543797.scm", 1978437), "/tmp/runtime4407023393941543797.scm", 1978434), "/tmp/runtime4407023393941543797.scm", 1966096), "/tmp/runtime4407023393941543797.scm", 1966088), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit426, PairWithPosition.make(Lit427, PairWithPosition.make(Lit402, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2138158), "/tmp/runtime4407023393941543797.scm", 2138144), "/tmp/runtime4407023393941543797.scm", 2138128), PairWithPosition.make(PairWithPosition.make(Lit400, PairWithPosition.make(PairWithPosition.make(Lit414, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit409, Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("makeFullEventName").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2150413), PairWithPosition.make(Lit427, PairWithPosition.make(Lit402, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2154523), "/tmp/runtime4407023393941543797.scm", 2154509), "/tmp/runtime4407023393941543797.scm", 2150412), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2150412), "/tmp/runtime4407023393941543797.scm", 2146315), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2146315), "/tmp/runtime4407023393941543797.scm", 2142218), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2142218), "/tmp/runtime4407023393941543797.scm", 2138128), "/tmp/runtime4407023393941543797.scm", 2138120), PairWithPosition.make((SimpleSymbol) new SimpleSymbol("$define").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2170896), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit448, PairWithPosition.make(Lit432, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2183203), "/tmp/runtime4407023393941543797.scm", 2183186), PairWithPosition.make(PairWithPosition.make(Lit428, PairWithPosition.make(Lit429, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<com.google.appinventor.components.runtime.EventDispatcher>").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2191374), "/tmp/runtime4407023393941543797.scm", 2187290), "/tmp/runtime4407023393941543797.scm", 2187276), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(PairWithPosition.make(Lit431, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2195486), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit429, Pair.make(Pair.make(Lit337, Pair.make(Lit430, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2203673), PairWithPosition.make(PairWithPosition.make(Lit394, PairWithPosition.make(Lit410, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2207839), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2207839), "/tmp/runtime4407023393941543797.scm", 2207773), "/tmp/runtime4407023393941543797.scm", 2207769), PairWithPosition.make(PairWithPosition.make(Lit434, PairWithPosition.make(Lit431, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2211870), "/tmp/runtime4407023393941543797.scm", 2211865), PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("cdr").readResolve(), PairWithPosition.make(Lit431, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2215966), "/tmp/runtime4407023393941543797.scm", 2215961), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2215961), "/tmp/runtime4407023393941543797.scm", 2211865), "/tmp/runtime4407023393941543797.scm", 2207769), "/tmp/runtime4407023393941543797.scm", 2203672), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2203672), "/tmp/runtime4407023393941543797.scm", 2195486), "/tmp/runtime4407023393941543797.scm", 2195478), PairWithPosition.make(Lit432, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2220054), "/tmp/runtime4407023393941543797.scm", 2195478), "/tmp/runtime4407023393941543797.scm", 2195468), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2195468), "/tmp/runtime4407023393941543797.scm", 2187276), "/tmp/runtime4407023393941543797.scm", 2183186), "/tmp/runtime4407023393941543797.scm", 2183178), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit453, PairWithPosition.make(Lit437, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2232361), "/tmp/runtime4407023393941543797.scm", 2232338), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(PairWithPosition.make(Lit435, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2240542), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit381, PairWithPosition.make(PairWithPosition.make(Lit434, PairWithPosition.make(Lit435, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2244648), "/tmp/runtime4407023393941543797.scm", 2244643), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2244643), "/tmp/runtime4407023393941543797.scm", 2244638), PairWithPosition.make(PairWithPosition.make(Lit382, PairWithPosition.make(PairWithPosition.make(Lit439, PairWithPosition.make(Lit435, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2248751), "/tmp/runtime4407023393941543797.scm", 2248745), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2248745), "/tmp/runtime4407023393941543797.scm", 2248734), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2248734), "/tmp/runtime4407023393941543797.scm", 2244637), PairWithPosition.make(PairWithPosition.make(Lit436, PairWithPosition.make(Lit381, PairWithPosition.make(PairWithPosition.make(Lit382, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2252861), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2252861), "/tmp/runtime4407023393941543797.scm", 2252857), "/tmp/runtime4407023393941543797.scm", 2252826), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2252826), "/tmp/runtime4407023393941543797.scm", 2244637), "/tmp/runtime4407023393941543797.scm", 2244632), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2244632), "/tmp/runtime4407023393941543797.scm", 2240542), "/tmp/runtime4407023393941543797.scm", 2240534), PairWithPosition.make(Lit437, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2256918), "/tmp/runtime4407023393941543797.scm", 2240534), "/tmp/runtime4407023393941543797.scm", 2240524), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2240524), "/tmp/runtime4407023393941543797.scm", 2232338), "/tmp/runtime4407023393941543797.scm", 2232330), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit451, PairWithPosition.make(Lit442, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2269221), "/tmp/runtime4407023393941543797.scm", 2269202), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2273310), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit373, PairWithPosition.make(PairWithPosition.make(Lit443, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2277429), "/tmp/runtime4407023393941543797.scm", 2277422), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2277422), "/tmp/runtime4407023393941543797.scm", 2277406), PairWithPosition.make(PairWithPosition.make(Lit379, PairWithPosition.make(PairWithPosition.make(Lit444, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2281522), "/tmp/runtime4407023393941543797.scm", 2281514), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2281514), "/tmp/runtime4407023393941543797.scm", 2281502), PairWithPosition.make(PairWithPosition.make(Lit378, PairWithPosition.make(PairWithPosition.make(Lit439, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2285620), "/tmp/runtime4407023393941543797.scm", 2285614), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2285614), "/tmp/runtime4407023393941543797.scm", 2285598), PairWithPosition.make(PairWithPosition.make(Lit440, PairWithPosition.make(PairWithPosition.make(Lit400, PairWithPosition.make(PairWithPosition.make(Lit434, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2289748), "/tmp/runtime4407023393941543797.scm", 2289743), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2289743), "/tmp/runtime4407023393941543797.scm", 2289715), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2289715), "/tmp/runtime4407023393941543797.scm", 2289694), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2289694), "/tmp/runtime4407023393941543797.scm", 2285598), "/tmp/runtime4407023393941543797.scm", 2281502), "/tmp/runtime4407023393941543797.scm", 2277405), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit441, PairWithPosition.make(PairWithPosition.make(Lit366, PairWithPosition.make(Lit378, PairWithPosition.make(Lit440, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2306119), "/tmp/runtime4407023393941543797.scm", 2306104), "/tmp/runtime4407023393941543797.scm", 2306098), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2306098), "/tmp/runtime4407023393941543797.scm", 2306080), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2306079), PairWithPosition.make(PairWithPosition.make(Lit375, PairWithPosition.make(PairWithPosition.make(Lit445, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2314281), PairWithPosition.make(Lit373, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2314288), "/tmp/runtime4407023393941543797.scm", 2314281), "/tmp/runtime4407023393941543797.scm", 2314274), PairWithPosition.make(Lit441, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2314304), "/tmp/runtime4407023393941543797.scm", 2314274), "/tmp/runtime4407023393941543797.scm", 2314268), PairWithPosition.make(PairWithPosition.make(Lit359, PairWithPosition.make(Lit373, PairWithPosition.make(Lit441, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2326596), "/tmp/runtime4407023393941543797.scm", 2326581), "/tmp/runtime4407023393941543797.scm", 2326556), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2326556), "/tmp/runtime4407023393941543797.scm", 2314268), "/tmp/runtime4407023393941543797.scm", 2306079), "/tmp/runtime4407023393941543797.scm", 2306074), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2306074), "/tmp/runtime4407023393941543797.scm", 2277405), "/tmp/runtime4407023393941543797.scm", 2277400), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2277400), "/tmp/runtime4407023393941543797.scm", 2273310), "/tmp/runtime4407023393941543797.scm", 2273302), PairWithPosition.make(Lit442, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2330646), "/tmp/runtime4407023393941543797.scm", 2273302), "/tmp/runtime4407023393941543797.scm", 2273292), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2273292), "/tmp/runtime4407023393941543797.scm", 2269202), "/tmp/runtime4407023393941543797.scm", 2269194), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit454, PairWithPosition.make(Lit442, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2342947), "/tmp/runtime4407023393941543797.scm", 2342930), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2351134), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit373, PairWithPosition.make(PairWithPosition.make(Lit443, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2355253), "/tmp/runtime4407023393941543797.scm", 2355246), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2355246), "/tmp/runtime4407023393941543797.scm", 2355230), PairWithPosition.make(PairWithPosition.make(Lit379, PairWithPosition.make(PairWithPosition.make(Lit444, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2359346), "/tmp/runtime4407023393941543797.scm", 2359338), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2359338), "/tmp/runtime4407023393941543797.scm", 2359326), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2359326), "/tmp/runtime4407023393941543797.scm", 2355229), PairWithPosition.make(PairWithPosition.make(Lit387, PairWithPosition.make(Lit379, PairWithPosition.make(PairWithPosition.make(Lit379, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2367531), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2367531), "/tmp/runtime4407023393941543797.scm", 2367520), "/tmp/runtime4407023393941543797.scm", 2367514), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2367514), "/tmp/runtime4407023393941543797.scm", 2355229), "/tmp/runtime4407023393941543797.scm", 2355224), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2355224), "/tmp/runtime4407023393941543797.scm", 2351134), "/tmp/runtime4407023393941543797.scm", 2351126), PairWithPosition.make(Lit442, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2371606), "/tmp/runtime4407023393941543797.scm", 2351126), "/tmp/runtime4407023393941543797.scm", 2351116), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2379806), PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit373, PairWithPosition.make(PairWithPosition.make(Lit443, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2383925), "/tmp/runtime4407023393941543797.scm", 2383918), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2383918), "/tmp/runtime4407023393941543797.scm", 2383902), PairWithPosition.make(PairWithPosition.make(Lit379, PairWithPosition.make(PairWithPosition.make(Lit444, PairWithPosition.make(Lit438, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2388018), "/tmp/runtime4407023393941543797.scm", 2388010), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2388010), "/tmp/runtime4407023393941543797.scm", 2387998), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2387998), "/tmp/runtime4407023393941543797.scm", 2383901), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2396187), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("callInitialize").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2396187), PairWithPosition.make(PairWithPosition.make(Lit445, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2396216), PairWithPosition.make(Lit373, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2396223), "/tmp/runtime4407023393941543797.scm", 2396216), "/tmp/runtime4407023393941543797.scm", 2396209), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2396209), "/tmp/runtime4407023393941543797.scm", 2396186), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2396186), "/tmp/runtime4407023393941543797.scm", 2383901), "/tmp/runtime4407023393941543797.scm", 2383896), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2383896), "/tmp/runtime4407023393941543797.scm", 2379806), "/tmp/runtime4407023393941543797.scm", 2379798), PairWithPosition.make(Lit442, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2400278), "/tmp/runtime4407023393941543797.scm", 2379798), "/tmp/runtime4407023393941543797.scm", 2379788), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2379788), "/tmp/runtime4407023393941543797.scm", 2351116), "/tmp/runtime4407023393941543797.scm", 2342930), "/tmp/runtime4407023393941543797.scm", 2342922), PairWithPosition.make(Lit350, PairWithPosition.make(PairWithPosition.make(Lit88, Lit447, "/tmp/runtime4407023393941543797.scm", 2412562), PairWithPosition.make(PairWithPosition.make(Lit414, PairWithPosition.make(PairWithPosition.make(Lit419, PairWithPosition.make(Lit415, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("map").readResolve(), PairWithPosition.make(Lit446, PairWithPosition.make(Lit447, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2424872), "/tmp/runtime4407023393941543797.scm", 2424857), "/tmp/runtime4407023393941543797.scm", 2424852), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2424852), "/tmp/runtime4407023393941543797.scm", 2420756), "/tmp/runtime4407023393941543797.scm", 2420749), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2420749), "/tmp/runtime4407023393941543797.scm", 2416652), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2416652), "/tmp/runtime4407023393941543797.scm", 2412562), "/tmp/runtime4407023393941543797.scm", 2412554), PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("gnu.expr.Language").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("setDefaults").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2445323), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make((SimpleSymbol) new SimpleSymbol("kawa.standard.Scheme").readResolve(), Pair.make(Pair.make(Lit337, Pair.make((SimpleSymbol) new SimpleSymbol("getInstance").readResolve(), LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2445354), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2445353), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2445353), "/tmp/runtime4407023393941543797.scm", 2445322), PairWithPosition.make(Lit418, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("invoke").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2482195), PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("run").readResolve(), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2482203), "/tmp/runtime4407023393941543797.scm", 2482203), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2482202), "/tmp/runtime4407023393941543797.scm", 2482195), "/tmp/runtime4407023393941543797.scm", 2482187), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("java.lang.Exception").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit360, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit336, Pair.make(Lit405, Pair.make(Pair.make(Lit337, Pair.make(Lit391, LList.Empty)), LList.Empty)), "/tmp/runtime4407023393941543797.scm", 2490399), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2490398), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2490398), "/tmp/runtime4407023393941543797.scm", 2490380), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2494495), "/tmp/runtime4407023393941543797.scm", 2494476), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2494476), "/tmp/runtime4407023393941543797.scm", 2490380), "/tmp/runtime4407023393941543797.scm", 2486294), "/tmp/runtime4407023393941543797.scm", 2486283), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2486283), "/tmp/runtime4407023393941543797.scm", 2482187), "/tmp/runtime4407023393941543797.scm", 2478090), Lit375, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2498586), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2498586), Lit359, PairWithPosition.make(PairWithPosition.make(Lit388, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2506798), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2506798), PairWithPosition.make(PairWithPosition.make(Lit448, PairWithPosition.make(Lit371, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2514971), "/tmp/runtime4407023393941543797.scm", 2514954), PairWithPosition.make(PairWithPosition.make(Lit418, PairWithPosition.make(PairWithPosition.make(Lit342, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit452, PairWithPosition.make(PairWithPosition.make(Lit450, PairWithPosition.make(Lit376, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2527270), "/tmp/runtime4407023393941543797.scm", 2527261), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2527261), "/tmp/runtime4407023393941543797.scm", 2527249), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2527248), PairWithPosition.make(PairWithPosition.make(Lit349, PairWithPosition.make(PairWithPosition.make(Lit348, PairWithPosition.make(Lit449, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2547746), "/tmp/runtime4407023393941543797.scm", 2547746), PairWithPosition.make(PairWithPosition.make(Lit341, PairWithPosition.make(LList.Empty, PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2547774), "/tmp/runtime4407023393941543797.scm", 2547771), "/tmp/runtime4407023393941543797.scm", 2547763), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2547763), "/tmp/runtime4407023393941543797.scm", 2547745), "/tmp/runtime4407023393941543797.scm", 2547725), PairWithPosition.make(PairWithPosition.make(Lit433, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("force").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit450, PairWithPosition.make(Lit384, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2564134), "/tmp/runtime4407023393941543797.scm", 2564125), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2564125), "/tmp/runtime4407023393941543797.scm", 2564119), "/tmp/runtime4407023393941543797.scm", 2564109), PairWithPosition.make(PairWithPosition.make(Lit451, PairWithPosition.make(Lit452, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2568224), "/tmp/runtime4407023393941543797.scm", 2568205), PairWithPosition.make(PairWithPosition.make(Lit453, PairWithPosition.make(PairWithPosition.make(Lit450, PairWithPosition.make(Lit380, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2592813), "/tmp/runtime4407023393941543797.scm", 2592804), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2592804), "/tmp/runtime4407023393941543797.scm", 2592781), PairWithPosition.make(PairWithPosition.make(Lit454, PairWithPosition.make(Lit452, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2621470), "/tmp/runtime4407023393941543797.scm", 2621453), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2621453), "/tmp/runtime4407023393941543797.scm", 2592781), "/tmp/runtime4407023393941543797.scm", 2568205), "/tmp/runtime4407023393941543797.scm", 2564109), "/tmp/runtime4407023393941543797.scm", 2547725), "/tmp/runtime4407023393941543797.scm", 2527248), "/tmp/runtime4407023393941543797.scm", 2527243), PairWithPosition.make(PairWithPosition.make(Lit405, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.errors.YailRuntimeError").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit407, PairWithPosition.make(Lit405, LList.Empty, "/tmp/runtime4407023393941543797.scm", 2633769), "/tmp/runtime4407023393941543797.scm", 2633750), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2633750), "/tmp/runtime4407023393941543797.scm", 2625558), "/tmp/runtime4407023393941543797.scm", 2625547), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2625547), "/tmp/runtime4407023393941543797.scm", 2527243), "/tmp/runtime4407023393941543797.scm", 2523146), LList.Empty, "/tmp/runtime4407023393941543797.scm", 2523146), "/tmp/runtime4407023393941543797.scm", 2514954)}, 0)}, 5);
        Object[] objArr3 = {Lit335};
        SyntaxPattern syntaxPattern3 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2);
        SimpleSymbol simpleSymbol34 = Lit348;
        SimpleSymbol simpleSymbol35 = (SimpleSymbol) new SimpleSymbol("com.google.appinventor.components.runtime.Form").readResolve();
        Lit15 = simpleSymbol35;
        Lit83 = new SyntaxRules(objArr3, new SyntaxRule[]{new SyntaxRule(syntaxPattern3, "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", new Object[]{Lit86, PairWithPosition.make(PairWithPosition.make(simpleSymbol34, PairWithPosition.make(simpleSymbol35, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1196082), "/tmp/runtime4407023393941543797.scm", 1196082), PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1196132), "/tmp/runtime4407023393941543797.scm", 1196129), "/tmp/runtime4407023393941543797.scm", 1196081)}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", new Object[0], 3), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0011\u0018\f\u0011\u0018\u0014\b\u0013", new Object[]{Lit86, PairWithPosition.make(Lit348, PairWithPosition.make(Lit15, LList.Empty, "/tmp/runtime4407023393941543797.scm", 1204274), "/tmp/runtime4407023393941543797.scm", 1204274), Boolean.FALSE}, 0)}, 3);
        Object[] objArr4 = {Lit335};
        SyntaxPattern syntaxPattern4 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", new Object[0], 3);
        SimpleSymbol simpleSymbol36 = (SimpleSymbol) new SimpleSymbol("gen-simple-component-type").readResolve();
        Lit52 = simpleSymbol36;
        Lit56 = new SyntaxRules(objArr4, new SyntaxRule[]{new SyntaxRule(syntaxPattern4, "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0081\u0011\u0018\f\t\u0013\u0011\u0018\u0014)\u0011\u0018\u001c\b\u000b\u0018$\b\u0011\u0018,\u0011\u00184¹\u0011\u0018<)\u0011\u0018D\b\u0003)\u0011\u0018\u001c\b\u000b)\u0011\u0018D\b\u0013\u0018L\b\u0011\u0018T)\u0011\u0018D\b\u0003)\u0011\u0018\u001c\b\u000b)\u0011\u0018D\b\u0013\u0018\\", new Object[]{Lit343, Lit350, Lit353, simpleSymbol36, PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 241741), Lit338, Lit347, Lit57, Lit348, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 262183), Lit455, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/tmp/runtime4407023393941543797.scm", 278559)}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\r\u001f\u0018\b\b", new Object[0], 4), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\u0081\u0011\u0018\f\t\u0013\u0011\u0018\u0014)\u0011\u0018\u001c\b\u000b\u0018$\b\u0011\u0018,\u0011\u00184ñ\u0011\u0018<)\u0011\u0018D\b\u0003)\u0011\u0018\u001c\b\u000b)\u0011\u0018D\b\u0013\b\u0011\u0018L\t\u0010\b\u001d\u001b\b\u0011\u0018T)\u0011\u0018D\b\u0003)\u0011\u0018\u001c\b\u000b)\u0011\u0018D\b\u0013\b\u0011\u0018L\t\u0010\b\u001d\u001b", new Object[]{Lit343, Lit350, Lit353, Lit52, PairWithPosition.make(null, LList.Empty, "/tmp/runtime4407023393941543797.scm", 290893), Lit338, Lit347, Lit57, Lit348, Lit341, Lit455}, 1)}, 4);
        runtime runtimeVar = $instance;
        android$Mnlog = new ModuleMethod(runtimeVar, 11, Lit51, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        SimpleSymbol simpleSymbol37 = Lit52;
        ModuleMethod moduleMethod = new ModuleMethod(runtimeVar, 12, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:40");
        gen$Mnsimple$Mncomponent$Mntype = Macro.make(simpleSymbol37, moduleMethod, $instance);
        add$Mncomponent = Macro.make(Lit55, Lit56, $instance);
        add$Mncomponent$Mnwithin$Mnrepl = new ModuleMethod(runtimeVar, 13, Lit57, 16388);
        call$MnInitialize$Mnof$Mncomponents = new ModuleMethod(runtimeVar, 14, Lit58, -4096);
        add$Mninit$Mnthunk = new ModuleMethod(runtimeVar, 15, Lit59, 8194);
        get$Mninit$Mnthunk = new ModuleMethod(runtimeVar, 16, Lit60, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        clear$Mninit$Mnthunks = new ModuleMethod(runtimeVar, 17, Lit61, 0);
        lookup$Mncomponent = new ModuleMethod(runtimeVar, 18, Lit64, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        set$Mnand$Mncoerce$Mnproperty$Ex = new ModuleMethod(runtimeVar, 19, Lit65, 16388);
        get$Mnproperty = new ModuleMethod(runtimeVar, 20, Lit66, 8194);
        coerce$Mnto$Mncomponent$Mnand$Mnverify = new ModuleMethod(runtimeVar, 21, Lit67, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        get$Mnproperty$Mnand$Mncheck = new ModuleMethod(runtimeVar, 22, Lit68, 12291);
        set$Mnand$Mncoerce$Mnproperty$Mnand$Mncheck$Ex = new ModuleMethod(runtimeVar, 23, Lit69, 20485);
        define$Mnform = Macro.make(Lit82, Lit83, $instance);
        define$Mnform$Mninternal = Macro.make(Lit86, Lit87, $instance);
        symbol$Mnappend = new ModuleMethod(runtimeVar, 24, Lit88, -4096);
        SimpleSymbol simpleSymbol38 = Lit89;
        ModuleMethod moduleMethod2 = new ModuleMethod(runtimeVar, 25, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod2.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:657");
        gen$Mnevent$Mnname = Macro.make(simpleSymbol38, moduleMethod2, $instance);
        SimpleSymbol simpleSymbol39 = Lit92;
        ModuleMethod moduleMethod3 = new ModuleMethod(runtimeVar, 26, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod3.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:665");
        gen$Mngeneric$Mnevent$Mnname = Macro.make(simpleSymbol39, moduleMethod3, $instance);
        define$Mnevent$Mnhelper = Macro.make(Lit95, Lit96, $instance);
        $Stlist$Mnfor$Mnruntime$St = Macro.make(Lit97, Lit98, $instance);
        SimpleSymbol simpleSymbol40 = Lit99;
        ModuleMethod moduleMethod4 = new ModuleMethod(runtimeVar, 27, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod4.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:721");
        define$Mnevent = Macro.make(simpleSymbol40, moduleMethod4, $instance);
        SimpleSymbol simpleSymbol41 = Lit108;
        ModuleMethod moduleMethod5 = new ModuleMethod(runtimeVar, 28, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod5.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:739");
        define$Mngeneric$Mnevent = Macro.make(simpleSymbol41, moduleMethod5, $instance);
        add$Mnto$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 29, Lit121, 8194);
        lookup$Mnin$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 30, Lit122, 8193);
        delete$Mnfrom$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 32, Lit123, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        rename$Mnin$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 33, Lit124, 8194);
        add$Mnglobal$Mnvar$Mnto$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 34, Lit125, 8194);
        lookup$Mnglobal$Mnvar$Mnin$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 35, Lit126, 8193);
        reset$Mncurrent$Mnform$Mnenvironment = new ModuleMethod(runtimeVar, 37, Lit127, 0);
        foreach = Macro.makeNonHygienic(Lit128, new ModuleMethod(runtimeVar, 38, null, 12291), $instance);
        $Styail$Mnbreak$St = new ModuleMethod(runtimeVar, 39, Lit136, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        forrange = Macro.makeNonHygienic(Lit137, new ModuleMethod(runtimeVar, 40, null, 20485), $instance);
        f5while = Macro.makeNonHygienic(Lit143, new ModuleMethod(runtimeVar, 41, null, -4094), $instance);
        call$Mncomponent$Mnmethod = new ModuleMethod(runtimeVar, 42, Lit161, 16388);
        call$Mncomponent$Mntype$Mnmethod = new ModuleMethod(runtimeVar, 43, Lit162, 20485);
        call$Mnyail$Mnprimitive = new ModuleMethod(runtimeVar, 44, Lit163, 16388);
        sanitize$Mncomponent$Mndata = new ModuleMethod(runtimeVar, 45, Lit164, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        java$Mncollection$Mn$Gryail$Mnlist = new ModuleMethod(runtimeVar, 46, Lit165, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        java$Mncollection$Mn$Grkawa$Mnlist = new ModuleMethod(runtimeVar, 47, Lit166, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        java$Mnmap$Mn$Gryail$Mndictionary = new ModuleMethod(runtimeVar, 48, Lit167, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        sanitize$Mnatomic = new ModuleMethod(runtimeVar, 49, Lit168, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        signal$Mnruntime$Mnerror = new ModuleMethod(runtimeVar, 50, Lit169, 8194);
        signal$Mnruntime$Mnform$Mnerror = new ModuleMethod(runtimeVar, 51, Lit170, 12291);
        yail$Mnnot = new ModuleMethod(runtimeVar, 52, Lit171, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        call$Mnwith$Mncoerced$Mnargs = new ModuleMethod(runtimeVar, 53, Lit172, 16388);
        $Pcset$Mnand$Mncoerce$Mnproperty$Ex = new ModuleMethod(runtimeVar, 54, Lit173, 16388);
        $Pcset$Mnsubform$Mnlayout$Mnproperty$Ex = new ModuleMethod(runtimeVar, 55, Lit174, 12291);
        generate$Mnruntime$Mntype$Mnerror = new ModuleMethod(runtimeVar, 56, Lit175, 8194);
        show$Mnarglist$Mnno$Mnparens = new ModuleMethod(runtimeVar, 57, Lit176, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnargs = new ModuleMethod(runtimeVar, 58, Lit177, 12291);
        coerce$Mnarg = new ModuleMethod(runtimeVar, 59, Lit178, 8194);
        coerce$Mnto$Mntext = new ModuleMethod(runtimeVar, 60, Lit179, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mninstant = new ModuleMethod(runtimeVar, 61, Lit180, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mncomponent = new ModuleMethod(runtimeVar, 62, Lit181, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mncomponent$Mnof$Mntype = new ModuleMethod(runtimeVar, 63, Lit182, 8194);
        type$Mn$Grclass = new ModuleMethod(runtimeVar, 64, Lit183, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mnnumber = new ModuleMethod(runtimeVar, 65, Lit184, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mnkey = new ModuleMethod(runtimeVar, 66, Lit185, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mnstring = new ModuleMethod(runtimeVar, 67, Lit188, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ModuleMethod moduleMethod6 = new ModuleMethod(runtimeVar, 68, Lit189, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod6.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1445");
        get$Mndisplay$Mnrepresentation = moduleMethod6;
        ModuleMethod moduleMethod7 = new ModuleMethod(runtimeVar, 69, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod7.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1455");
        lambda$Fn4 = moduleMethod7;
        ModuleMethod moduleMethod8 = new ModuleMethod(runtimeVar, 70, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod8.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1478");
        lambda$Fn7 = moduleMethod8;
        join$Mnstrings = new ModuleMethod(runtimeVar, 71, Lit190, 8194);
        string$Mnreplace = new ModuleMethod(runtimeVar, 72, Lit191, 8194);
        coerce$Mnto$Mnyail$Mnlist = new ModuleMethod(runtimeVar, 73, Lit192, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mnpair = new ModuleMethod(runtimeVar, 74, Lit193, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mndictionary = new ModuleMethod(runtimeVar, 75, Lit194, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        coerce$Mnto$Mnboolean = new ModuleMethod(runtimeVar, 76, Lit195, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        is$Mncoercible$Qu = new ModuleMethod(runtimeVar, 77, Lit196, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        all$Mncoercible$Qu = new ModuleMethod(runtimeVar, 78, Lit197, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        boolean$Mn$Grstring = new ModuleMethod(runtimeVar, 79, Lit198, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        padded$Mnstring$Mn$Grnumber = new ModuleMethod(runtimeVar, 80, Lit199, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        $Stformat$Mninexact$St = new ModuleMethod(runtimeVar, 81, Lit200, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        appinventor$Mnnumber$Mn$Grstring = new ModuleMethod(runtimeVar, 82, Lit201, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnequal$Qu = new ModuleMethod(runtimeVar, 83, Lit202, 8194);
        yail$Mnatomic$Mnequal$Qu = new ModuleMethod(runtimeVar, 84, Lit203, 8194);
        as$Mnnumber = new ModuleMethod(runtimeVar, 85, Lit204, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnnot$Mnequal$Qu = new ModuleMethod(runtimeVar, 86, Lit205, 8194);
        process$Mnand$Mndelayed = new ModuleMethod(runtimeVar, 87, Lit206, -4096);
        process$Mnor$Mndelayed = new ModuleMethod(runtimeVar, 88, Lit207, -4096);
        yail$Mnfloor = new ModuleMethod(runtimeVar, 89, Lit208, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnceiling = new ModuleMethod(runtimeVar, 90, Lit209, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnround = new ModuleMethod(runtimeVar, 91, Lit210, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        random$Mnset$Mnseed = new ModuleMethod(runtimeVar, 92, Lit211, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        random$Mnfraction = new ModuleMethod(runtimeVar, 93, Lit212, 0);
        random$Mninteger = new ModuleMethod(runtimeVar, 94, Lit213, 8194);
        ModuleMethod moduleMethod9 = new ModuleMethod(runtimeVar, 95, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        moduleMethod9.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1780");
        lambda$Fn11 = moduleMethod9;
        yail$Mndivide = new ModuleMethod(runtimeVar, 96, Lit214, 8194);
        degrees$Mn$Grradians$Mninternal = new ModuleMethod(runtimeVar, 97, Lit215, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        radians$Mn$Grdegrees$Mninternal = new ModuleMethod(runtimeVar, 98, Lit216, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        degrees$Mn$Grradians = new ModuleMethod(runtimeVar, 99, Lit217, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        radians$Mn$Grdegrees = new ModuleMethod(runtimeVar, 100, Lit218, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        sin$Mndegrees = new ModuleMethod(runtimeVar, 101, Lit219, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        cos$Mndegrees = new ModuleMethod(runtimeVar, 102, Lit220, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        tan$Mndegrees = new ModuleMethod(runtimeVar, 103, Lit221, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        asin$Mndegrees = new ModuleMethod(runtimeVar, 104, Lit222, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        acos$Mndegrees = new ModuleMethod(runtimeVar, 105, Lit223, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        atan$Mndegrees = new ModuleMethod(runtimeVar, 106, Lit224, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        atan2$Mndegrees = new ModuleMethod(runtimeVar, 107, Lit225, 8194);
        string$Mnto$Mnupper$Mncase = new ModuleMethod(runtimeVar, 108, Lit226, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        string$Mnto$Mnlower$Mncase = new ModuleMethod(runtimeVar, 109, Lit227, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        unicode$Mnstring$Mn$Grlist = new ModuleMethod(runtimeVar, 110, Lit228, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        string$Mnreverse = new ModuleMethod(runtimeVar, 111, Lit229, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        format$Mnas$Mndecimal = new ModuleMethod(runtimeVar, 112, Lit230, 8194);
        is$Mnnumber$Qu = new ModuleMethod(runtimeVar, 113, Lit231, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        is$Mnbase10$Qu = new ModuleMethod(runtimeVar, 114, Lit232, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        is$Mnhexadecimal$Qu = new ModuleMethod(runtimeVar, 115, Lit233, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        is$Mnbinary$Qu = new ModuleMethod(runtimeVar, 116, Lit234, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        math$Mnconvert$Mndec$Mnhex = new ModuleMethod(runtimeVar, 117, Lit235, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        math$Mnconvert$Mnhex$Mndec = new ModuleMethod(runtimeVar, 118, Lit236, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        math$Mnconvert$Mnbin$Mndec = new ModuleMethod(runtimeVar, 119, Lit237, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        math$Mnconvert$Mndec$Mnbin = new ModuleMethod(runtimeVar, 120, Lit238, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        patched$Mnnumber$Mn$Grstring$Mnbinary = new ModuleMethod(runtimeVar, 121, Lit239, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        alternate$Mnnumber$Mn$Grstring$Mnbinary = new ModuleMethod(runtimeVar, 122, Lit240, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        internal$Mnbinary$Mnconvert = new ModuleMethod(runtimeVar, 123, Lit241, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Qu = new ModuleMethod(runtimeVar, 124, Lit242, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mncandidate$Qu = new ModuleMethod(runtimeVar, 125, Lit243, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mncontents = new ModuleMethod(runtimeVar, 126, Lit244, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        set$Mnyail$Mnlist$Mncontents$Ex = new ModuleMethod(runtimeVar, 127, Lit245, 8194);
        insert$Mnyail$Mnlist$Mnheader = new ModuleMethod(runtimeVar, 128, Lit246, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        kawa$Mnlist$Mn$Gryail$Mnlist = new ModuleMethod(runtimeVar, 129, Lit247, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mn$Grkawa$Mnlist = new ModuleMethod(runtimeVar, 130, Lit248, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnempty$Qu = new ModuleMethod(runtimeVar, 131, Lit249, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        make$Mnyail$Mnlist = new ModuleMethod(runtimeVar, 132, Lit250, -4096);
        yail$Mnlist$Mncopy = new ModuleMethod(runtimeVar, 133, Lit251, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnreverse = new ModuleMethod(runtimeVar, 134, Lit252, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnto$Mncsv$Mntable = new ModuleMethod(runtimeVar, 135, Lit253, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnto$Mncsv$Mnrow = new ModuleMethod(runtimeVar, 136, Lit254, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        convert$Mnto$Mnstrings$Mnfor$Mncsv = new ModuleMethod(runtimeVar, 137, Lit255, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnfrom$Mncsv$Mntable = new ModuleMethod(runtimeVar, 138, Lit256, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnfrom$Mncsv$Mnrow = new ModuleMethod(runtimeVar, 139, Lit257, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnlength = new ModuleMethod(runtimeVar, 140, Lit258, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnindex = new ModuleMethod(runtimeVar, 141, Lit259, 8194);
        yail$Mnlist$Mnget$Mnitem = new ModuleMethod(runtimeVar, 142, Lit260, 8194);
        yail$Mnlist$Mnset$Mnitem$Ex = new ModuleMethod(runtimeVar, 143, Lit261, 12291);
        yail$Mnlist$Mnremove$Mnitem$Ex = new ModuleMethod(runtimeVar, 144, Lit262, 8194);
        yail$Mnlist$Mninsert$Mnitem$Ex = new ModuleMethod(runtimeVar, 145, Lit263, 12291);
        yail$Mnlist$Mnappend$Ex = new ModuleMethod(runtimeVar, 146, Lit264, 8194);
        yail$Mnlist$Mnadd$Mnto$Mnlist$Ex = new ModuleMethod(runtimeVar, 147, Lit265, -4095);
        yail$Mnlist$Mnmember$Qu = new ModuleMethod(runtimeVar, 148, Lit266, 8194);
        yail$Mnlist$Mnpick$Mnrandom = new ModuleMethod(runtimeVar, 149, Lit267, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnfor$Mneach = new ModuleMethod(runtimeVar, 150, Lit268, 8194);
        yail$Mnfor$Mnrange = new ModuleMethod(runtimeVar, 151, Lit269, 16388);
        yail$Mnfor$Mnrange$Mnwith$Mnnumeric$Mnchecked$Mnargs = new ModuleMethod(runtimeVar, 152, Lit270, 16388);
        yail$Mnnumber$Mnrange = new ModuleMethod(runtimeVar, 153, Lit271, 8194);
        yail$Mnalist$Mnlookup = new ModuleMethod(runtimeVar, 154, Lit272, 12291);
        pair$Mnok$Qu = new ModuleMethod(runtimeVar, 155, Lit273, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mnlist$Mnjoin$Mnwith$Mnseparator = new ModuleMethod(runtimeVar, 156, Lit274, 8194);
        make$Mnyail$Mndictionary = new ModuleMethod(runtimeVar, 157, Lit275, -4096);
        make$Mndictionary$Mnpair = new ModuleMethod(runtimeVar, 158, Lit276, 8194);
        yail$Mndictionary$Mnset$Mnpair = new ModuleMethod(runtimeVar, 159, Lit277, 12291);
        yail$Mndictionary$Mndelete$Mnpair = new ModuleMethod(runtimeVar, ComponentConstants.TEXTBOX_PREFERRED_WIDTH, Lit278, 8194);
        yail$Mndictionary$Mnlookup = new ModuleMethod(runtimeVar, 161, Lit279, 12291);
        yail$Mndictionary$Mnrecursive$Mnlookup = new ModuleMethod(runtimeVar, 162, Lit280, 12291);
        yail$Mndictionary$Mnwalk = new ModuleMethod(runtimeVar, 163, Lit281, 8194);
        yail$Mndictionary$Mnrecursive$Mnset = new ModuleMethod(runtimeVar, 164, Lit282, 12291);
        yail$Mndictionary$Mnget$Mnkeys = new ModuleMethod(runtimeVar, 165, Lit283, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mnget$Mnvalues = new ModuleMethod(runtimeVar, 166, Lit284, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mnis$Mnkey$Mnin = new ModuleMethod(runtimeVar, 167, Lit285, 8194);
        yail$Mndictionary$Mnlength = new ModuleMethod(runtimeVar, 168, Lit286, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mnalist$Mnto$Mndict = new ModuleMethod(runtimeVar, 169, Lit287, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mndict$Mnto$Mnalist = new ModuleMethod(runtimeVar, 170, Lit288, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mncopy = new ModuleMethod(runtimeVar, 171, Lit289, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        yail$Mndictionary$Mncombine$Mndicts = new ModuleMethod(runtimeVar, 172, Lit290, 8194);
        yail$Mndictionary$Qu = new ModuleMethod(runtimeVar, 173, Lit291, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        make$Mndisjunct = new ModuleMethod(runtimeVar, 174, Lit292, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        array$Mn$Grlist = new ModuleMethod(runtimeVar, 175, Lit293, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        string$Mnstarts$Mnat = new ModuleMethod(runtimeVar, 176, Lit294, 8194);
        string$Mncontains = new ModuleMethod(runtimeVar, 177, Lit295, 8194);
        string$Mncontains$Mnany = new ModuleMethod(runtimeVar, 178, Lit296, 8194);
        string$Mncontains$Mnall = new ModuleMethod(runtimeVar, 179, Lit297, 8194);
        string$Mnsplit$Mnat$Mnfirst = new ModuleMethod(runtimeVar, 180, Lit298, 8194);
        string$Mnsplit$Mnat$Mnfirst$Mnof$Mnany = new ModuleMethod(runtimeVar, 181, Lit299, 8194);
        string$Mnsplit = new ModuleMethod(runtimeVar, 182, Lit300, 8194);
        string$Mnsplit$Mnat$Mnany = new ModuleMethod(runtimeVar, 183, Lit301, 8194);
        string$Mnsplit$Mnat$Mnspaces = new ModuleMethod(runtimeVar, 184, Lit302, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        string$Mnsubstring = new ModuleMethod(runtimeVar, 185, Lit303, 12291);
        string$Mntrim = new ModuleMethod(runtimeVar, 186, Lit304, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        string$Mnreplace$Mnall = new ModuleMethod(runtimeVar, 187, Lit305, 12291);
        string$Mnempty$Qu = new ModuleMethod(runtimeVar, 188, Lit306, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        text$Mndeobfuscate = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG, Lit307, 8194);
        string$Mnreplace$Mnmappings$Mndictionary = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK, Lit308, 8194);
        string$Mnreplace$Mnmappings$Mnlongest$Mnstring = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY, Lit309, 8194);
        string$Mnreplace$Mnmappings$Mnearliest$Mnoccurrence = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE, Lit310, 8194);
        make$Mnexact$Mnyail$Mninteger = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_STOP, Lit311, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        make$Mncolor = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SOURCE, Lit312, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        split$Mncolor = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_FULLSCREEN, Lit313, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        close$Mnscreen = new ModuleMethod(runtimeVar, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_DURATION, Lit314, 0);
        close$Mnapplication = new ModuleMethod(runtimeVar, 197, Lit315, 0);
        open$Mnanother$Mnscreen = new ModuleMethod(runtimeVar, 198, Lit316, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        open$Mnanother$Mnscreen$Mnwith$Mnstart$Mnvalue = new ModuleMethod(runtimeVar, 199, Lit317, 8194);
        get$Mnstart$Mnvalue = new ModuleMethod(runtimeVar, HttpRequestContext.HTTP_OK, Lit318, 0);
        close$Mnscreen$Mnwith$Mnvalue = new ModuleMethod(runtimeVar, ErrorMessages.ERROR_CAMERA_NO_IMAGE_RETURNED, Lit319, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        get$Mnplain$Mnstart$Mntext = new ModuleMethod(runtimeVar, ErrorMessages.ERROR_NO_CAMERA_PERMISSION, Lit320, 0);
        close$Mnscreen$Mnwith$Mnplain$Mntext = new ModuleMethod(runtimeVar, 203, Lit321, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        get$Mnserver$Mnaddress$Mnfrom$Mnwifi = new ModuleMethod(runtimeVar, 204, Lit322, 0);
        in$Mnui = new ModuleMethod(runtimeVar, 205, Lit325, 8194);
        send$Mnto$Mnblock = new ModuleMethod(runtimeVar, 206, Lit326, 8194);
        clear$Mncurrent$Mnform = new ModuleMethod(runtimeVar, 207, Lit327, 0);
        set$Mnform$Mnname = new ModuleMethod(runtimeVar, YaVersion.YOUNG_ANDROID_VERSION, Lit328, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        remove$Mncomponent = new ModuleMethod(runtimeVar, 209, Lit329, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        rename$Mncomponent = new ModuleMethod(runtimeVar, 210, Lit330, 8194);
        init$Mnruntime = new ModuleMethod(runtimeVar, 211, Lit331, 0);
        set$Mnthis$Mnform = new ModuleMethod(runtimeVar, 212, Lit332, 0);
        clarify = new ModuleMethod(runtimeVar, 213, Lit333, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        clarify1 = new ModuleMethod(runtimeVar, 214, Lit334, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    }

    static Object lambda16(Object stx) {
        Object[] allocVars = SyntaxPattern.allocVars(2, null);
        if (!Lit53.match(stx, allocVars, 0)) {
            return syntax_case.error("syntax-case", stx);
        }
        Object[] objArr = new Object[3];
        objArr[0] = "";
        objArr[1] = "";
        Object execute = Lit54.execute(allocVars, TemplateScope.make());
        try {
            objArr[2] = ((Symbol) execute).toString();
            return SyntaxForms.makeWithTemplate(stx, strings.stringAppend(objArr));
        } catch (ClassCastException e) {
            throw new WrongType(e, "symbol->string", 1, execute);
        }
    }

    public static Object addComponentWithinRepl(Object container$Mnname, Object component$Mntype, Object componentName, Object initPropsThunk) {
        frame frameVar = new frame();
        frameVar.component$Mnname = componentName;
        frameVar.init$Mnprops$Mnthunk = initPropsThunk;
        try {
            Object lookupInCurrentFormEnvironment = lookupInCurrentFormEnvironment((Symbol) container$Mnname);
            try {
                ComponentContainer container = (ComponentContainer) lookupInCurrentFormEnvironment;
                Object obj = frameVar.component$Mnname;
                try {
                    frameVar.existing$Mncomponent = lookupInCurrentFormEnvironment((Symbol) obj);
                    frameVar.component$Mnto$Mnadd = Invoke.make.apply2(component$Mntype, container);
                    Object obj2 = frameVar.component$Mnname;
                    try {
                        addToCurrentFormEnvironment((Symbol) obj2, frameVar.component$Mnto$Mnadd);
                        return addInitThunk(frameVar.component$Mnname, frameVar.lambda$Fn1);
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-current-form-environment", 0, obj2);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "lookup-in-current-form-environment", 0, obj);
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "container", -2, lookupInCurrentFormEnvironment);
            }
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "lookup-in-current-form-environment", 0, container$Mnname);
        }
    }

    @Override // gnu.expr.ModuleBody
    public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 13:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 19:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 42:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 44:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 53:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 54:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 151:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 152:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            default:
                return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
        }
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Object component$Mnname;
        Object component$Mnto$Mnadd;
        Object existing$Mncomponent;
        Object init$Mnprops$Mnthunk;
        final ModuleMethod lambda$Fn1;

        public frame() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 0);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:99");
            this.lambda$Fn1 = moduleMethod;
        }

        @Override // gnu.expr.ModuleBody
        public Object apply0(ModuleMethod moduleMethod) {
            return moduleMethod.selector == 1 ? lambda1() : super.apply0(moduleMethod);
        }

        Object lambda1() {
            if (this.init$Mnprops$Mnthunk != Boolean.FALSE) {
                Scheme.applyToArgs.apply1(this.init$Mnprops$Mnthunk);
            }
            if (this.existing$Mncomponent == Boolean.FALSE) {
                return Values.empty;
            }
            runtime.androidLog(Format.formatToString(0, "Copying component properties for ~A", this.component$Mnname));
            Object obj = this.existing$Mncomponent;
            try {
                Component component = (Component) obj;
                Object obj2 = this.component$Mnto$Mnadd;
                try {
                    return PropertyUtil.copyComponentProperties(component, (Component) obj2);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "com.google.appinventor.components.runtime.util.PropertyUtil.copyComponentProperties(com.google.appinventor.components.runtime.Component,com.google.appinventor.components.runtime.Component)", 2, obj2);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "com.google.appinventor.components.runtime.util.PropertyUtil.copyComponentProperties(com.google.appinventor.components.runtime.Component,com.google.appinventor.components.runtime.Component)", 1, obj);
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            if (moduleMethod.selector != 1) {
                return super.match0(moduleMethod, callContext);
            }
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
    }

    /* JADX INFO: Multiple debug info for r0v5 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object call$MnInitializeOfComponents$V(Object[] argsArray) {
        LList component$Mnnames = LList.makeList(argsArray, 0);
        Object obj = component$Mnnames;
        while (obj != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj;
                Object init$Mnthunk = getInitThunk(arg0.getCar());
                if (init$Mnthunk != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                obj = arg0.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, obj);
            }
        }
        Object arg02 = component$Mnnames;
        while (arg02 != LList.Empty) {
            try {
                Pair arg03 = (Pair) arg02;
                Object component$Mnname = arg03.getCar();
                try {
                    ((Form) $Stthis$Mnform$St).callInitialize(lookupInCurrentFormEnvironment((Symbol) component$Mnname));
                    arg02 = arg03.getCdr();
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "lookup-in-current-form-environment", 0, component$Mnname);
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "arg0", -2, arg02);
            }
        }
        return Values.empty;
    }

    @Override // gnu.expr.ModuleBody
    public int matchN(ModuleMethod moduleMethod, Object[] objArr, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 14:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 23:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 24:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 40:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 41:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 43:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 87:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 88:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 132:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 147:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 157:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            default:
                return super.matchN(moduleMethod, objArr, callContext);
        }
    }

    public static Object addInitThunk(Object component$Mnname, Object thunk) {
        return Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, $Stinit$Mnthunk$Mnenvironment$St, component$Mnname, thunk});
    }

    @Override // gnu.expr.ModuleBody
    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 15:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 20:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 29:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 30:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 33:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Symbol)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 34:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 35:
                if (!(obj instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 50:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 56:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 59:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 63:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 71:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 72:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 83:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 84:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 86:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 94:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 96:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 107:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 112:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 127:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 141:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 142:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 144:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 146:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 148:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 150:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 153:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 156:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 158:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case ComponentConstants.TEXTBOX_PREFERRED_WIDTH /* 160 */:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 163:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 167:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 172:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 176:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 177:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 178:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 179:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 180:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 181:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 182:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 183:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG /* 189 */:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK /* 190 */:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY /* 191 */:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE /* 192 */:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 199:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 205:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 206:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 210:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            default:
                return super.match2(moduleMethod, obj, obj2, callContext);
        }
    }

    public static Object getInitThunk(Object component$Mnname) {
        Object obj = $Stinit$Mnthunk$Mnenvironment$St;
        try {
            try {
                boolean x = ((Environment) obj).isBound((Symbol) component$Mnname);
                if (x) {
                    return Invoke.invokeStatic.apply4(KawaEnvironment, Lit1, $Stinit$Mnthunk$Mnenvironment$St, component$Mnname);
                }
                return x ? Boolean.TRUE : Boolean.FALSE;
            } catch (ClassCastException e) {
                throw new WrongType(e, "gnu.mapping.Environment.isBound(gnu.mapping.Symbol)", 2, component$Mnname);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "gnu.mapping.Environment.isBound(gnu.mapping.Symbol)", 1, obj);
        }
    }

    public static void clearInitThunks() {
        $Stinit$Mnthunk$Mnenvironment$St = Environment.make("init-thunk-environment");
    }

    @Override // gnu.expr.ModuleBody
    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 37:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 93:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_DURATION /* 196 */:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 197:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case HttpRequestContext.HTTP_OK /* 200 */:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case ErrorMessages.ERROR_NO_CAMERA_PERMISSION /* 202 */:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 204:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 207:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 211:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            case 212:
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            default:
                return super.match0(moduleMethod, callContext);
        }
    }

    public static Object lookupComponent(Object comp$Mnname) {
        try {
            Object verified = lookupInCurrentFormEnvironment((Symbol) comp$Mnname, Boolean.FALSE);
            return verified != Boolean.FALSE ? verified : Lit2;
        } catch (ClassCastException e) {
            throw new WrongType(e, "lookup-in-current-form-environment", 0, comp$Mnname);
        }
    }

    public static Object setAndCoerceProperty$Ex(Object component, Object prop$Mnsym, Object property$Mnvalue, Object property$Mntype) {
        return $PcSetAndCoerceProperty$Ex(coerceToComponentAndVerify(component), prop$Mnsym, property$Mnvalue, property$Mntype);
    }

    public static Object getProperty$1(Object component, Object prop$Mnname) {
        return sanitizeComponentData(Invoke.invoke.apply2(coerceToComponentAndVerify(component), prop$Mnname));
    }

    public static Object coerceToComponentAndVerify(Object possible$Mncomponent) {
        Object component = coerceToComponent(possible$Mncomponent);
        return !(component instanceof Component) ? signalRuntimeError(strings.stringAppend("Cannot find the component: ", getDisplayRepresentation(possible$Mncomponent)), "Problem with application") : component;
    }

    public static Object getPropertyAndCheck(Object possible$Mncomponent, Object component$Mntype, Object prop$Mnname) {
        Object component = coerceToComponentOfType(possible$Mncomponent, component$Mntype);
        return !(component instanceof Component) ? signalRuntimeError(Format.formatToString(0, "Property getter was expecting a ~A component but got a ~A instead.", component$Mntype, possible$Mncomponent.getClass().getSimpleName()), "Problem with application") : sanitizeComponentData(Invoke.invoke.apply2(component, prop$Mnname));
    }

    @Override // gnu.expr.ModuleBody
    public int match3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 22:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 38:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 51:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 55:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 58:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 143:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 145:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 154:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 159:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 161:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 162:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 164:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 185:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 187:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            default:
                return super.match3(moduleMethod, obj, obj2, obj3, callContext);
        }
    }

    public static Object setAndCoercePropertyAndCheck$Ex(Object possible$Mncomponent, Object comp$Mntype, Object prop$Mnsym, Object property$Mnvalue, Object property$Mntype) {
        Object component = coerceToComponentOfType(possible$Mncomponent, comp$Mntype);
        return !(component instanceof Component) ? signalRuntimeError(Format.formatToString(0, "Property setter was expecting a ~A component but got a ~A instead.", comp$Mntype, possible$Mncomponent.getClass().getSimpleName()), "Problem with application") : $PcSetAndCoerceProperty$Ex(component, prop$Mnsym, property$Mnvalue, property$Mntype);
    }

    public static SimpleSymbol symbolAppend$V(Object[] argsArray) {
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

    static Object lambda17(Object stx) {
        Object[] allocVars = SyntaxPattern.allocVars(3, null);
        if (!Lit90.match(stx, allocVars, 0)) {
            return syntax_case.error("syntax-case", stx);
        }
        return SyntaxForms.makeWithTemplate(stx, Lit91.execute(allocVars, TemplateScope.make()));
    }

    static Object lambda18(Object stx) {
        Object[] allocVars = SyntaxPattern.allocVars(3, null);
        if (!Lit93.match(stx, allocVars, 0)) {
            return syntax_case.error("syntax-case", stx);
        }
        return SyntaxForms.makeWithTemplate(stx, Lit94.execute(allocVars, TemplateScope.make()));
    }

    static Object lambda19(Object stx) {
        Object consX;
        Object[] allocVars = SyntaxPattern.allocVars(5, null);
        if (!Lit100.match(stx, allocVars, 0)) {
            return syntax_case.error("syntax-case", stx);
        }
        TemplateScope make = TemplateScope.make();
        consX = LList.consX(new Object[]{symbolAppend$V(new Object[]{Lit103.execute(allocVars, make), Lit104, Lit105.execute(allocVars, make)}), Lit106.execute(allocVars, make)});
        return Quote.append$V(new Object[]{Lit101.execute(allocVars, make), Pair.make(Quote.append$V(new Object[]{Lit102.execute(allocVars, make), consX}), Lit107.execute(allocVars, make))});
    }

    static Object lambda20(Object stx) {
        Object consX;
        Object[] allocVars = SyntaxPattern.allocVars(5, null);
        if (!Lit109.match(stx, allocVars, 0)) {
            return syntax_case.error("syntax-case", stx);
        }
        TemplateScope make = TemplateScope.make();
        consX = LList.consX(new Object[]{symbolAppend$V(new Object[]{Lit112, Lit113.execute(allocVars, make), Lit104, Lit114.execute(allocVars, make)}), Lit115.execute(allocVars, make)});
        return Quote.append$V(new Object[]{Lit110.execute(allocVars, make), Pair.make(Quote.append$V(new Object[]{Lit111.execute(allocVars, make), consX}), Lit116.execute(allocVars, make))});
    }

    @Override // gnu.expr.ModuleBody
    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        switch (moduleMethod.selector) {
            case 11:
                androidLog(obj);
                return Values.empty;
            case 12:
                return lambda16(obj);
            case 13:
            case 14:
            case 15:
            case 17:
            case 19:
            case 20:
            case 22:
            case 23:
            case 24:
            case 29:
            case 31:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 58:
            case 59:
            case 63:
            case 71:
            case 72:
            case 83:
            case 84:
            case 86:
            case 87:
            case 88:
            case 93:
            case 94:
            case 96:
            case 107:
            case 112:
            case 127:
            case 132:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 156:
            case 157:
            case 158:
            case 159:
            case ComponentConstants.TEXTBOX_PREFERRED_WIDTH /* 160 */:
            case 161:
            case 162:
            case 163:
            case 164:
            case 167:
            case 172:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
            case 187:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG /* 189 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK /* 190 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY /* 191 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE /* 192 */:
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_DURATION /* 196 */:
            case 197:
            case 199:
            case HttpRequestContext.HTTP_OK /* 200 */:
            case ErrorMessages.ERROR_NO_CAMERA_PERMISSION /* 202 */:
            case 204:
            case 205:
            case 206:
            case 207:
            case 210:
            case 211:
            case 212:
            default:
                return super.apply1(moduleMethod, obj);
            case 16:
                return getInitThunk(obj);
            case 18:
                return lookupComponent(obj);
            case 21:
                return coerceToComponentAndVerify(obj);
            case 25:
                return lambda17(obj);
            case 26:
                return lambda18(obj);
            case 27:
                return lambda19(obj);
            case 28:
                return lambda20(obj);
            case 30:
                try {
                    return lookupInCurrentFormEnvironment((Symbol) obj);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "lookup-in-current-form-environment", 1, obj);
                }
            case 32:
                try {
                    return deleteFromCurrentFormEnvironment((Symbol) obj);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "delete-from-current-form-environment", 1, obj);
                }
            case 35:
                try {
                    return lookupGlobalVarInCurrentFormEnvironment((Symbol) obj);
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "lookup-global-var-in-current-form-environment", 1, obj);
                }
            case 39:
                return signalRuntimeError("Break should be run only from within a loop", "Bad use of Break");
            case 45:
                return sanitizeComponentData(obj);
            case 46:
                try {
                    return javaCollection$To$YailList((Collection) obj);
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "java-collection->yail-list", 1, obj);
                }
            case 47:
                try {
                    return javaCollection$To$KawaList((Collection) obj);
                } catch (ClassCastException e5) {
                    throw new WrongType(e5, "java-collection->kawa-list", 1, obj);
                }
            case 48:
                try {
                    return javaMap$To$YailDictionary((Map) obj);
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "java-map->yail-dictionary", 1, obj);
                }
            case 49:
                return sanitizeAtomic(obj);
            case 52:
                return yailNot(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 57:
                return showArglistNoParens(obj);
            case 60:
                return coerceToText(obj);
            case 61:
                return coerceToInstant(obj);
            case 62:
                return coerceToComponent(obj);
            case 64:
                return type$To$Class(obj);
            case 65:
                return coerceToNumber(obj);
            case 66:
                return coerceToKey(obj);
            case 67:
                return coerceToString(obj);
            case 68:
                return getDisplayRepresentation(obj);
            case 69:
                return lambda4(obj);
            case 70:
                return lambda7(obj);
            case 73:
                return coerceToYailList(obj);
            case 74:
                return coerceToPair(obj);
            case 75:
                return coerceToDictionary(obj);
            case 76:
                return coerceToBoolean(obj);
            case 77:
                return isIsCoercible(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 78:
                return isAllCoercible(obj);
            case 79:
                return boolean$To$String(obj);
            case 80:
                return paddedString$To$Number(obj);
            case 81:
                return $StFormatInexact$St(obj);
            case 82:
                return appinventorNumber$To$String(obj);
            case 85:
                return asNumber(obj);
            case 89:
                return yailFloor(obj);
            case 90:
                return yailCeiling(obj);
            case 91:
                return yailRound(obj);
            case 92:
                return randomSetSeed(obj);
            case 95:
                return lambda11(obj);
            case 97:
                return degrees$To$RadiansInternal(obj);
            case 98:
                return radians$To$DegreesInternal(obj);
            case 99:
                return degrees$To$Radians(obj);
            case 100:
                return radians$To$Degrees(obj);
            case 101:
                return sinDegrees(obj);
            case 102:
                return cosDegrees(obj);
            case 103:
                return tanDegrees(obj);
            case 104:
                return asinDegrees(obj);
            case 105:
                return acosDegrees(obj);
            case 106:
                return atanDegrees(obj);
            case 108:
                return stringToUpperCase(obj);
            case 109:
                return stringToLowerCase(obj);
            case 110:
                try {
                    return unicodeString$To$List((CharSequence) obj);
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "unicode-string->list", 1, obj);
                }
            case 111:
                return stringReverse(obj);
            case 113:
                return isIsNumber(obj);
            case 114:
                return isIsBase10(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 115:
                return isIsHexadecimal(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 116:
                return isIsBinary(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 117:
                return mathConvertDecHex(obj);
            case 118:
                return mathConvertHexDec(obj);
            case 119:
                return mathConvertBinDec(obj);
            case 120:
                return mathConvertDecBin(obj);
            case 121:
                return patchedNumber$To$StringBinary(obj);
            case 122:
                return alternateNumber$To$StringBinary(obj);
            case 123:
                return internalBinaryConvert(obj);
            case 124:
                return isYailList(obj);
            case 125:
                return isYailListCandidate(obj);
            case 126:
                return yailListContents(obj);
            case 128:
                return insertYailListHeader(obj);
            case 129:
                return kawaList$To$YailList(obj);
            case 130:
                return yailList$To$KawaList(obj);
            case 131:
                return isYailListEmpty(obj);
            case 133:
                return yailListCopy(obj);
            case 134:
                return yailListReverse(obj);
            case 135:
                return yailListToCsvTable(obj);
            case 136:
                return yailListToCsvRow(obj);
            case 137:
                return convertToStringsForCsv(obj);
            case 138:
                return yailListFromCsvTable(obj);
            case 139:
                return yailListFromCsvRow(obj);
            case 140:
                return Integer.valueOf(yailListLength(obj));
            case 149:
                return yailListPickRandom(obj);
            case 155:
                return isPairOk(obj);
            case 165:
                return yailDictionaryGetKeys(obj);
            case 166:
                return yailDictionaryGetValues(obj);
            case 168:
                return Integer.valueOf(yailDictionaryLength(obj));
            case 169:
                return yailDictionaryAlistToDict(obj);
            case 170:
                return yailDictionaryDictToAlist(obj);
            case 171:
                return yailDictionaryCopy(obj);
            case 173:
                return isYailDictionary(obj);
            case 174:
                return makeDisjunct(obj);
            case 175:
                return array$To$List(obj);
            case 184:
                return stringSplitAtSpaces(obj);
            case 186:
                return stringTrim(obj);
            case 188:
                return isStringEmpty(obj);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_STOP /* 193 */:
                return makeExactYailInteger(obj);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SOURCE /* 194 */:
                return makeColor(obj);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_FULLSCREEN /* 195 */:
                return splitColor(obj);
            case 198:
                openAnotherScreen(obj);
                return Values.empty;
            case ErrorMessages.ERROR_CAMERA_NO_IMAGE_RETURNED /* 201 */:
                closeScreenWithValue(obj);
                return Values.empty;
            case 203:
                closeScreenWithPlainText(obj);
                return Values.empty;
            case YaVersion.YOUNG_ANDROID_VERSION /* 208 */:
                return setFormName(obj);
            case 209:
                return removeComponent(obj);
            case 213:
                return clarify(obj);
            case 214:
                return clarify1(obj);
        }
    }

    public static Object addToCurrentFormEnvironment(Symbol name, Object object) {
        return $Stthis$Mnform$St != null ? Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, SlotGet.getSlotValue(false, $Stthis$Mnform$St, "form-environment", "form$Mnenvironment", "getFormEnvironment", "isFormEnvironment", Scheme.instance), name, object}) : Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, $Sttest$Mnenvironment$St, name, object});
    }

    public static Object lookupInCurrentFormEnvironment(Symbol name, Object default$Mnvalue) {
        Object env = $Stthis$Mnform$St != null ? SlotGet.getSlotValue(false, $Stthis$Mnform$St, "form-environment", "form$Mnenvironment", "getFormEnvironment", "isFormEnvironment", Scheme.instance) : $Sttest$Mnenvironment$St;
        try {
            if (((Environment) env).isBound(name)) {
                return Invoke.invokeStatic.apply4(KawaEnvironment, Lit1, env, name);
            }
            return default$Mnvalue;
        } catch (ClassCastException e) {
            throw new WrongType(e, "gnu.mapping.Environment.isBound(gnu.mapping.Symbol)", 1, env);
        }
    }

    public static Object deleteFromCurrentFormEnvironment(Symbol name) {
        return $Stthis$Mnform$St != null ? Invoke.invokeStatic.apply4(KawaEnvironment, Lit3, SlotGet.getSlotValue(false, $Stthis$Mnform$St, "form-environment", "form$Mnenvironment", "getFormEnvironment", "isFormEnvironment", Scheme.instance), name) : Invoke.invokeStatic.apply4(KawaEnvironment, Lit3, $Sttest$Mnenvironment$St, name);
    }

    public static Object renameInCurrentFormEnvironment(Symbol old$Mnname, Symbol new$Mnname) {
        if (Scheme.isEqv.apply2(old$Mnname, new$Mnname) != Boolean.FALSE) {
            return Values.empty;
        }
        Object old$Mnvalue = lookupInCurrentFormEnvironment(old$Mnname);
        if ($Stthis$Mnform$St != null) {
            Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, SlotGet.getSlotValue(false, $Stthis$Mnform$St, "form-environment", "form$Mnenvironment", "getFormEnvironment", "isFormEnvironment", Scheme.instance), new$Mnname, old$Mnvalue});
        } else {
            Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, $Sttest$Mnenvironment$St, new$Mnname, old$Mnvalue});
        }
        return deleteFromCurrentFormEnvironment(old$Mnname);
    }

    public static Object addGlobalVarToCurrentFormEnvironment(Symbol name, Object object) {
        if ($Stthis$Mnform$St != null) {
            Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, SlotGet.getSlotValue(false, $Stthis$Mnform$St, "global-var-environment", "global$Mnvar$Mnenvironment", "getGlobalVarEnvironment", "isGlobalVarEnvironment", Scheme.instance), name, object});
            return null;
        }
        Invoke.invokeStatic.applyN(new Object[]{KawaEnvironment, Lit0, $Sttest$Mnglobal$Mnvar$Mnenvironment$St, name, object});
        return null;
    }

    public static Object lookupGlobalVarInCurrentFormEnvironment(Symbol name, Object default$Mnvalue) {
        Object env = $Stthis$Mnform$St != null ? SlotGet.getSlotValue(false, $Stthis$Mnform$St, "global-var-environment", "global$Mnvar$Mnenvironment", "getGlobalVarEnvironment", "isGlobalVarEnvironment", Scheme.instance) : $Sttest$Mnglobal$Mnvar$Mnenvironment$St;
        try {
            if (((Environment) env).isBound(name)) {
                return Invoke.invokeStatic.apply4(KawaEnvironment, Lit1, env, name);
            }
            return default$Mnvalue;
        } catch (ClassCastException e) {
            throw new WrongType(e, "gnu.mapping.Environment.isBound(gnu.mapping.Symbol)", 1, env);
        }
    }

    public static void resetCurrentFormEnvironment() {
        if ($Stthis$Mnform$St != null) {
            Object form$Mnname = SlotGet.getSlotValue(false, $Stthis$Mnform$St, "form-name-symbol", "form$Mnname$Mnsymbol", "getFormNameSymbol", "isFormNameSymbol", Scheme.instance);
            try {
                SlotSet.set$Mnfield$Ex.apply3($Stthis$Mnform$St, "form-environment", Environment.make(((Symbol) form$Mnname).toString()));
                try {
                    addToCurrentFormEnvironment((Symbol) form$Mnname, $Stthis$Mnform$St);
                    SlotSet slotSet = SlotSet.set$Mnfield$Ex;
                    Object obj = $Stthis$Mnform$St;
                    Object[] objArr = new Object[2];
                    try {
                        objArr[0] = ((Symbol) form$Mnname).toString();
                        objArr[1] = "-global-vars";
                        FString stringAppend = strings.stringAppend(objArr);
                        slotSet.apply3(obj, "global-var-environment", Environment.make(stringAppend == null ? null : stringAppend.toString()));
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "symbol->string", 1, form$Mnname);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "add-to-current-form-environment", 0, form$Mnname);
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "symbol->string", 1, form$Mnname);
            }
        } else {
            $Sttest$Mnenvironment$St = Environment.make("test-env");
            Invoke.invoke.apply3(Environment.getCurrent(), "addParent", $Sttest$Mnenvironment$St);
            $Sttest$Mnglobal$Mnvar$Mnenvironment$St = Environment.make("test-global-var-env");
        }
    }

    static Object lambda21(Object arg$Mnname, Object bodyform, Object list$Mnof$Mnargs) {
        Object consX;
        Object consX2;
        Object consX3;
        PairWithPosition pairWithPosition = Lit131;
        consX = LList.consX(new Object[]{arg$Mnname, LList.Empty});
        consX2 = LList.consX(new Object[]{bodyform, LList.Empty});
        Pair make = Pair.make(Quote.append$V(new Object[]{Lit133, Pair.make(Quote.append$V(new Object[]{Lit134, Pair.make(consX, consX2)}), LList.Empty)}), LList.Empty);
        consX3 = LList.consX(new Object[]{list$Mnof$Mnargs, LList.Empty});
        return Quote.append$V(new Object[]{Lit129, Pair.make(Quote.append$V(new Object[]{Lit130, Pair.make(pairWithPosition, Pair.make(Quote.append$V(new Object[]{Lit132, Pair.make(make, Pair.make(Quote.append$V(new Object[]{Lit135, consX3}), LList.Empty))}), LList.Empty))}), LList.Empty)});
    }

    static Object lambda22(Object lambda$Mnarg$Mnname, Object body$Mnform, Object start, Object end, Object step) {
        Object consX;
        Object consX2;
        Object consX3;
        Object consX4;
        Object consX5;
        PairWithPosition pairWithPosition = Lit140;
        consX = LList.consX(new Object[]{lambda$Mnarg$Mnname, LList.Empty});
        consX2 = LList.consX(new Object[]{body$Mnform, LList.Empty});
        Object append$V = Quote.append$V(new Object[]{Lit142, Pair.make(consX, consX2)});
        consX3 = LList.consX(new Object[]{step, LList.Empty});
        consX4 = LList.consX(new Object[]{end, consX3});
        consX5 = LList.consX(new Object[]{start, consX4});
        return Quote.append$V(new Object[]{Lit138, Pair.make(Quote.append$V(new Object[]{Lit139, Pair.make(pairWithPosition, Pair.make(Quote.append$V(new Object[]{Lit141, Pair.make(append$V, consX5)}), LList.Empty))}), LList.Empty)});
    }

    static Object lambda23$V(Object condition, Object body, Object[] argsArray) {
        Object consX;
        Object consX2;
        LList rest = LList.makeList(argsArray, 0);
        PairWithPosition pairWithPosition = Lit147;
        consX = LList.consX(new Object[]{body, rest});
        consX2 = LList.consX(new Object[]{condition, Pair.make(Quote.append$V(new Object[]{Lit150, Pair.make(Quote.append$V(new Object[]{Lit151, consX}), Lit152)}), Lit153)});
        return Quote.append$V(new Object[]{Lit144, Pair.make(Pair.make(Quote.append$V(new Object[]{Lit145, Pair.make(Quote.append$V(new Object[]{Lit146, Pair.make(pairWithPosition, Pair.make(Quote.append$V(new Object[]{Lit148, Pair.make(Quote.append$V(new Object[]{Lit149, consX2}), LList.Empty)}), LList.Empty))}), LList.Empty)}), LList.Empty), Lit154)});
    }

    public static Object callComponentMethod(Object component$Mnname, Object method$Mnname, Object arglist, Object typelist) {
        Object applyN;
        Object result;
        Object consX;
        Object consX2;
        Object coerced$Mnargs = coerceArgs(method$Mnname, arglist, typelist);
        if (isAllCoercible(coerced$Mnargs) != Boolean.FALSE) {
            try {
                Apply apply = Scheme.apply;
                Invoke invoke = Invoke.invoke;
                Object[] objArr = new Object[2];
                try {
                    objArr[0] = lookupInCurrentFormEnvironment((Symbol) component$Mnname);
                    consX = LList.consX(new Object[]{method$Mnname, Quote.append$V(new Object[]{coerced$Mnargs, LList.Empty})});
                    objArr[1] = consX;
                    consX2 = LList.consX(objArr);
                    applyN = apply.apply2(invoke, consX2);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "lookup-in-current-form-environment", 0, component$Mnname);
                }
            } catch (PermissionException exception) {
                Invoke invoke2 = Invoke.invoke;
                Object[] objArr2 = new Object[5];
                objArr2[0] = Form.getActiveForm();
                objArr2[1] = "dispatchPermissionDeniedEvent";
                try {
                    objArr2[2] = lookupInCurrentFormEnvironment((Symbol) component$Mnname);
                    objArr2[3] = method$Mnname;
                    objArr2[4] = exception;
                    applyN = invoke2.applyN(objArr2);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "lookup-in-current-form-environment", 0, component$Mnname);
                }
            }
            result = applyN;
        } else {
            result = generateRuntimeTypeError(method$Mnname, arglist);
        }
        return sanitizeComponentData(result);
    }

    public static Object callComponentTypeMethod(Object possible$Mncomponent, Object component$Mntype, Object method$Mnname, Object arglist, Object typelist) {
        Object result;
        Object consX;
        Object consX2;
        Object coerced$Mnargs = coerceArgs(method$Mnname, arglist, lists.cdr.apply1(typelist));
        Object component$Mnvalue = coerceToComponentOfType(possible$Mncomponent, component$Mntype);
        if (!(component$Mnvalue instanceof Component)) {
            return generateRuntimeTypeError(method$Mnname, LList.list1(getDisplayRepresentation(possible$Mncomponent)));
        }
        if (isAllCoercible(coerced$Mnargs) != Boolean.FALSE) {
            Apply apply = Scheme.apply;
            Invoke invoke = Invoke.invoke;
            consX = LList.consX(new Object[]{method$Mnname, Quote.append$V(new Object[]{coerced$Mnargs, LList.Empty})});
            consX2 = LList.consX(new Object[]{component$Mnvalue, consX});
            result = apply.apply2(invoke, consX2);
        } else {
            result = generateRuntimeTypeError(method$Mnname, arglist);
        }
        return sanitizeComponentData(result);
    }

    public static Object callYailPrimitive(Object prim, Object arglist, Object typelist, Object codeblocks$Mnname) {
        Object coerced$Mnargs = coerceArgs(codeblocks$Mnname, arglist, typelist);
        return isAllCoercible(coerced$Mnargs) != Boolean.FALSE ? Scheme.apply.apply2(prim, coerced$Mnargs) : generateRuntimeTypeError(codeblocks$Mnname, arglist);
    }

    public static Object sanitizeComponentData(Object data) {
        if (strings.isString(data) || isYailDictionary(data) != Boolean.FALSE) {
            return data;
        }
        if (data instanceof Map) {
            try {
                return javaMap$To$YailDictionary((Map) data);
            } catch (ClassCastException e) {
                throw new WrongType(e, "java-map->yail-dictionary", 0, data);
            }
        } else if (isYailList(data) != Boolean.FALSE) {
            return data;
        } else {
            if (lists.isList(data)) {
                return kawaList$To$YailList(data);
            }
            if (!(data instanceof Collection)) {
                return sanitizeAtomic(data);
            }
            try {
                return javaCollection$To$YailList((Collection) data);
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "java-collection->yail-list", 0, data);
            }
        }
    }

    public static Object javaCollection$To$YailList(Collection collection) {
        return kawaList$To$YailList(javaCollection$To$KawaList(collection));
    }

    public static Object javaCollection$To$KawaList(Collection collection) {
        LList lList = LList.Empty;
        for (Object obj : collection) {
            lList = lists.cons(sanitizeComponentData(obj), lList);
        }
        try {
            return LList.reverseInPlace(lList);
        } catch (ClassCastException e) {
            throw new WrongType(e, "reverse!", 1, lList);
        }
    }

    public static Object javaMap$To$YailDictionary(Map jMap) {
        YailDictionary dict = new YailDictionary();
        for (Object key : jMap.keySet()) {
            dict.put(key, sanitizeComponentData(jMap.get(key)));
        }
        return dict;
    }

    public static Object sanitizeAtomic(Object arg) {
        if (arg == null || Values.empty == arg) {
            return null;
        }
        if (numbers.isNumber(arg)) {
            return Arithmetic.asNumeric(arg);
        }
        return arg;
    }

    public static Object signalRuntimeError(Object message, Object error$Mntype) {
        String str = null;
        String obj = message == null ? null : message.toString();
        if (error$Mntype != null) {
            str = error$Mntype.toString();
        }
        throw new YailRuntimeError(obj, str);
    }

    public static Object signalRuntimeFormError(Object function$Mnname, Object error$Mnnumber, Object message) {
        return Invoke.invoke.applyN(new Object[]{$Stthis$Mnform$St, "runtimeFormErrorOccurredEvent", function$Mnname, error$Mnnumber, message});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean yailNot(Object foo) {
        return ((foo != Boolean.FALSE ? 1 : 0) + 1) & 1;
    }

    public static Object callWithCoercedArgs(Object func, Object arglist, Object typelist, Object codeblocks$Mnname) {
        Object coerced$Mnargs = coerceArgs(codeblocks$Mnname, arglist, typelist);
        return isAllCoercible(coerced$Mnargs) != Boolean.FALSE ? Scheme.apply.apply2(func, coerced$Mnargs) : generateRuntimeTypeError(codeblocks$Mnname, arglist);
    }

    public static Object $PcSetAndCoerceProperty$Ex(Object comp, Object prop$Mnname, Object property$Mnvalue, Object property$Mntype) {
        androidLog(Format.formatToString(0, "coercing for setting property ~A -- value ~A to type ~A", prop$Mnname, property$Mnvalue, property$Mntype));
        Object coerced$Mnarg = coerceArg(property$Mnvalue, property$Mntype);
        androidLog(Format.formatToString(0, "coerced property value was: ~A ", coerced$Mnarg));
        if (isAllCoercible(LList.list1(coerced$Mnarg)) == Boolean.FALSE) {
            return generateRuntimeTypeError(prop$Mnname, LList.list1(property$Mnvalue));
        }
        try {
            return Invoke.invoke.apply3(comp, prop$Mnname, coerced$Mnarg);
        } catch (PermissionException exception) {
            return Invoke.invoke.applyN(new Object[]{Form.getActiveForm(), "dispatchPermissionDeniedEvent", comp, prop$Mnname, exception});
        }
    }

    public static Object $PcSetSubformLayoutProperty$Ex(Object layout, Object prop$Mnname, Object value) {
        return Invoke.invoke.apply3(layout, prop$Mnname, value);
    }

    public static Object generateRuntimeTypeError(Object proc$Mnname, Object arglist) {
        androidLog(Format.formatToString(0, "arglist is: ~A ", arglist));
        Object string$Mnname = coerceToString(proc$Mnname);
        Object[] objArr = new Object[4];
        objArr[0] = "The operation ";
        objArr[1] = string$Mnname;
        Object[] objArr2 = new Object[2];
        objArr2[0] = " cannot accept the argument~P: ";
        try {
            objArr2[1] = Integer.valueOf(lists.length((LList) arglist));
            objArr[2] = Format.formatToString(0, objArr2);
            objArr[3] = showArglistNoParens(arglist);
            return signalRuntimeError(strings.stringAppend(objArr), strings.stringAppend("Bad arguments to ", string$Mnname));
        } catch (ClassCastException e) {
            throw new WrongType(e, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, arglist);
        }
    }

    /* JADX INFO: Multiple debug info for r0v5 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    /* JADX INFO: Multiple debug info for r0v8 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object showArglistNoParens(Object args) {
        Object obj = LList.Empty;
        Object arg0 = args;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(getDisplayRepresentation(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        Object elements = LList.reverseInPlace(obj);
        Object obj2 = LList.Empty;
        Object arg04 = elements;
        while (arg04 != LList.Empty) {
            try {
                Pair arg05 = (Pair) arg04;
                Object arg06 = arg05.getCdr();
                obj2 = Pair.make(strings.stringAppend("[", arg05.getCar(), "]"), obj2);
                arg04 = arg06;
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, arg04);
            }
        }
        Object obj3 = "";
        for (LList bracketed = LList.reverseInPlace(obj2); !lists.isNull(bracketed); bracketed = lists.cdr.apply1(bracketed)) {
            obj3 = strings.stringAppend(obj3, ", ", lists.car.apply1(bracketed));
        }
        return obj3;
    }

    /* JADX INFO: Multiple debug info for r1v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object coerceArgs(Object procedure$Mnname, Object arglist, Object typelist) {
        if (lists.isNull(typelist)) {
            return lists.isNull(arglist) ? arglist : signalRuntimeError(strings.stringAppend("The procedure ", procedure$Mnname, " expects no arguments, but it was called with the arguments: ", showArglistNoParens(arglist)), strings.stringAppend("Wrong number of arguments for", procedure$Mnname));
        }
        try {
            try {
                if (lists.length((LList) arglist) != lists.length((LList) typelist)) {
                    return signalRuntimeError(strings.stringAppend("The arguments ", showArglistNoParens(arglist), " are the wrong number of arguments for ", getDisplayRepresentation(procedure$Mnname)), strings.stringAppend("Wrong number of arguments for", getDisplayRepresentation(procedure$Mnname)));
                }
                Object obj = LList.Empty;
                Object arg0 = arglist;
                Object obj2 = typelist;
                while (arg0 != LList.Empty && obj2 != LList.Empty) {
                    try {
                        Pair arg02 = (Pair) arg0;
                        try {
                            Pair arg1 = (Pair) obj2;
                            Object arg03 = arg02.getCdr();
                            Object arg12 = arg1.getCdr();
                            obj = Pair.make(coerceArg(arg02.getCar(), arg1.getCar()), obj);
                            obj2 = arg12;
                            arg0 = arg03;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "arg1", -2, obj2);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "arg0", -2, arg0);
                    }
                }
                return LList.reverseInPlace(obj);
            } catch (ClassCastException e3) {
                throw new WrongType(e3, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, typelist);
            }
        } catch (ClassCastException e4) {
            throw new WrongType(e4, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, arglist);
        }
    }

    public static Object coerceArg(Object arg, Object type) {
        Object arg2 = sanitizeAtomic(arg);
        if (IsEqual.apply(type, Lit4)) {
            return coerceToNumber(arg2);
        }
        if (IsEqual.apply(type, Lit5)) {
            return coerceToText(arg2);
        }
        if (IsEqual.apply(type, Lit6)) {
            return coerceToBoolean(arg2);
        }
        if (IsEqual.apply(type, Lit7)) {
            return coerceToYailList(arg2);
        }
        if (IsEqual.apply(type, Lit8)) {
            return coerceToInstant(arg2);
        }
        if (IsEqual.apply(type, Lit9)) {
            return coerceToComponent(arg2);
        }
        if (IsEqual.apply(type, Lit10)) {
            return coerceToPair(arg2);
        }
        if (IsEqual.apply(type, Lit11)) {
            return coerceToKey(arg2);
        }
        if (IsEqual.apply(type, Lit12)) {
            return coerceToDictionary(arg2);
        }
        return !IsEqual.apply(type, Lit13) ? coerceToComponentOfType(arg2, type) : arg2;
    }

    public static Object coerceToText(Object arg) {
        return arg == null ? Lit2 : coerceToString(arg);
    }

    public static Object coerceToInstant(Object arg) {
        if (arg instanceof Calendar) {
            return arg;
        }
        Object as$Mnmillis = coerceToNumber(arg);
        if (!numbers.isNumber(as$Mnmillis)) {
            return Lit2;
        }
        try {
            return Clock.MakeInstantFromMillis(((Number) as$Mnmillis).longValue());
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.Clock.MakeInstantFromMillis(long)", 1, as$Mnmillis);
        }
    }

    public static Object coerceToComponent(Object arg) {
        if (!strings.isString(arg)) {
            return arg instanceof Component ? arg : misc.isSymbol(arg) ? lookupComponent(arg) : Lit2;
        }
        if (strings.isString$Eq(arg, "")) {
            return null;
        }
        try {
            return lookupComponent(misc.string$To$Symbol((CharSequence) arg));
        } catch (ClassCastException e) {
            throw new WrongType(e, "string->symbol", 1, arg);
        }
    }

    public static Object coerceToComponentOfType(Object arg, Object type) {
        Object component = coerceToComponent(arg);
        return (component == Lit2 || Scheme.apply.apply2(Scheme.instanceOf, LList.list2(arg, type$To$Class(type))) == Boolean.FALSE) ? Lit2 : component;
    }

    public static Object type$To$Class(Object type$Mnname) {
        return type$Mnname == Lit14 ? Lit15 : type$Mnname;
    }

    public static Object coerceToNumber(Object arg) {
        if (numbers.isNumber(arg)) {
            return arg;
        }
        if (!strings.isString(arg)) {
            return Lit2;
        }
        Object x = paddedString$To$Number(arg);
        if (x == Boolean.FALSE) {
            x = Lit2;
        }
        return x;
    }

    public static Object coerceToKey(Object arg) {
        if (numbers.isNumber(arg)) {
            return coerceToNumber(arg);
        }
        if (strings.isString(arg)) {
            return coerceToString(arg);
        }
        return !(arg instanceof Component) ? Lit2 : arg;
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    /* JADX INFO: Multiple debug info for r0v8 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object coerceToString(Object arg) {
        frame0 frame0Var = new frame0();
        frame0Var.arg = arg;
        if (frame0Var.arg == null) {
            return "*nothing*";
        }
        if (strings.isString(frame0Var.arg)) {
            return frame0Var.arg;
        }
        if (numbers.isNumber(frame0Var.arg)) {
            return appinventorNumber$To$String(frame0Var.arg);
        }
        if (misc.isBoolean(frame0Var.arg)) {
            return boolean$To$String(frame0Var.arg);
        }
        if (isYailList(frame0Var.arg) != Boolean.FALSE) {
            return coerceToString(yailList$To$KawaList(frame0Var.arg));
        }
        if (!lists.isList(frame0Var.arg)) {
            return ports.callWithOutputString(frame0Var.lambda$Fn3);
        }
        if (Form.getActiveForm().ShowListsAsJson()) {
            Object arg0 = frame0Var.arg;
            Object obj = LList.Empty;
            while (arg0 != LList.Empty) {
                try {
                    Pair arg02 = (Pair) arg0;
                    Object arg03 = arg02.getCdr();
                    obj = Pair.make(((Procedure) get$Mnjson$Mndisplay$Mnrepresentation).apply1(arg02.getCar()), obj);
                    arg0 = arg03;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "arg0", -2, arg0);
                }
            }
            return strings.stringAppend("[", joinStrings(LList.reverseInPlace(obj), ", "), "]");
        }
        Object arg04 = frame0Var.arg;
        Object obj2 = LList.Empty;
        while (arg04 != LList.Empty) {
            try {
                Pair arg05 = (Pair) arg04;
                Object arg06 = arg05.getCdr();
                obj2 = Pair.make(coerceToString(arg05.getCar()), obj2);
                arg04 = arg06;
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, arg04);
            }
        }
        frame0Var.pieces = LList.reverseInPlace(obj2);
        return ports.callWithOutputString(frame0Var.lambda$Fn2);
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame0 extends ModuleBody {
        Object arg;
        final ModuleMethod lambda$Fn2;
        final ModuleMethod lambda$Fn3;
        LList pieces;

        public frame0() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 2, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1435");
            this.lambda$Fn2 = moduleMethod;
            ModuleMethod moduleMethod2 = new ModuleMethod(this, 3, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod2.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1436");
            this.lambda$Fn3 = moduleMethod2;
        }

        void lambda2(Object port) {
            ports.display(this.pieces, port);
        }

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 2:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 2:
                    lambda2(obj);
                    return Values.empty;
                case 3:
                    lambda3(obj);
                    return Values.empty;
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        void lambda3(Object port) {
            ports.display(this.arg, port);
        }
    }

    public static Object getDisplayRepresentation(Object arg) {
        return Form.getActiveForm().ShowListsAsJson() ? ((Procedure) get$Mnjson$Mndisplay$Mnrepresentation).apply1(arg) : ((Procedure) get$Mnoriginal$Mndisplay$Mnrepresentation).apply1(arg);
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    static Object lambda4(Object arg) {
        frame1 frame1Var = new frame1();
        frame1Var.arg = arg;
        if (Scheme.numEqu.apply2(frame1Var.arg, Lit16) != Boolean.FALSE) {
            return "+infinity";
        }
        if (Scheme.numEqu.apply2(frame1Var.arg, Lit17) != Boolean.FALSE) {
            return "-infinity";
        }
        if (frame1Var.arg == null) {
            return "*nothing*";
        }
        if (misc.isSymbol(frame1Var.arg)) {
            Object obj = frame1Var.arg;
            try {
                return ((Symbol) obj).toString();
            } catch (ClassCastException e) {
                throw new WrongType(e, "symbol->string", 1, obj);
            }
        } else if (strings.isString(frame1Var.arg)) {
            if (strings.isString$Eq(frame1Var.arg, "")) {
                return "*empty-string*";
            }
            return frame1Var.arg;
        } else if (numbers.isNumber(frame1Var.arg)) {
            return appinventorNumber$To$String(frame1Var.arg);
        } else {
            if (misc.isBoolean(frame1Var.arg)) {
                return boolean$To$String(frame1Var.arg);
            }
            if (isYailList(frame1Var.arg) != Boolean.FALSE) {
                return getDisplayRepresentation(yailList$To$KawaList(frame1Var.arg));
            }
            if (!lists.isList(frame1Var.arg)) {
                return ports.callWithOutputString(frame1Var.lambda$Fn6);
            }
            Object arg0 = frame1Var.arg;
            Object obj2 = LList.Empty;
            while (arg0 != LList.Empty) {
                try {
                    Pair arg02 = (Pair) arg0;
                    Object arg03 = arg02.getCdr();
                    obj2 = Pair.make(getDisplayRepresentation(arg02.getCar()), obj2);
                    arg0 = arg03;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "arg0", -2, arg0);
                }
            }
            frame1Var.pieces = LList.reverseInPlace(obj2);
            return ports.callWithOutputString(frame1Var.lambda$Fn5);
        }
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame1 extends ModuleBody {
        Object arg;
        final ModuleMethod lambda$Fn5;
        final ModuleMethod lambda$Fn6;
        LList pieces;

        public frame1() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 4, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1470");
            this.lambda$Fn5 = moduleMethod;
            ModuleMethod moduleMethod2 = new ModuleMethod(this, 5, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod2.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1471");
            this.lambda$Fn6 = moduleMethod2;
        }

        void lambda5(Object port) {
            ports.display(this.pieces, port);
        }

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 4:
                    lambda5(obj);
                    return Values.empty;
                case 5:
                    lambda6(obj);
                    return Values.empty;
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        void lambda6(Object port) {
            ports.display(this.arg, port);
        }
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    static Object lambda7(Object arg) {
        frame2 frame2Var = new frame2();
        frame2Var.arg = arg;
        if (Scheme.numEqu.apply2(frame2Var.arg, Lit18) != Boolean.FALSE) {
            return "+infinity";
        }
        if (Scheme.numEqu.apply2(frame2Var.arg, Lit19) != Boolean.FALSE) {
            return "-infinity";
        }
        if (frame2Var.arg == null) {
            return "*nothing*";
        }
        if (misc.isSymbol(frame2Var.arg)) {
            Object obj = frame2Var.arg;
            try {
                return ((Symbol) obj).toString();
            } catch (ClassCastException e) {
                throw new WrongType(e, "symbol->string", 1, obj);
            }
        } else if (strings.isString(frame2Var.arg)) {
            return strings.stringAppend("\"", frame2Var.arg, "\"");
        } else {
            if (numbers.isNumber(frame2Var.arg)) {
                return appinventorNumber$To$String(frame2Var.arg);
            }
            if (misc.isBoolean(frame2Var.arg)) {
                return boolean$To$String(frame2Var.arg);
            }
            if (isYailList(frame2Var.arg) != Boolean.FALSE) {
                return ((Procedure) get$Mnjson$Mndisplay$Mnrepresentation).apply1(yailList$To$KawaList(frame2Var.arg));
            }
            if (!lists.isList(frame2Var.arg)) {
                return ports.callWithOutputString(frame2Var.lambda$Fn8);
            }
            Object arg0 = frame2Var.arg;
            Object obj2 = LList.Empty;
            while (arg0 != LList.Empty) {
                try {
                    Pair arg02 = (Pair) arg0;
                    Object arg03 = arg02.getCdr();
                    obj2 = Pair.make(((Procedure) get$Mnjson$Mndisplay$Mnrepresentation).apply1(arg02.getCar()), obj2);
                    arg0 = arg03;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "arg0", -2, arg0);
                }
            }
            return strings.stringAppend("[", joinStrings(LList.reverseInPlace(obj2), ", "), "]");
        }
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame2 extends ModuleBody {
        Object arg;
        final ModuleMethod lambda$Fn8;

        public frame2() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 6, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1491");
            this.lambda$Fn8 = moduleMethod;
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            if (moduleMethod.selector != 6) {
                return super.apply1(moduleMethod, obj);
            }
            lambda8(obj);
            return Values.empty;
        }

        void lambda8(Object port) {
            ports.display(this.arg, port);
        }

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            if (moduleMethod.selector != 6) {
                return super.match1(moduleMethod, obj, callContext);
            }
            callContext.value1 = obj;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
    }

    public static Object joinStrings(Object list$Mnof$Mnstrings, Object separator) {
        try {
            return JavaStringUtils.joinStrings((List) list$Mnof$Mnstrings, separator == null ? null : separator.toString());
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.JavaStringUtils.joinStrings(java.util.List,java.lang.String)", 1, list$Mnof$Mnstrings);
        }
    }

    public static Object stringReplace(Object original, Object replacement$Mntable) {
        if (lists.isNull(replacement$Mntable)) {
            return original;
        }
        return strings.isString$Eq(original, lists.caar.apply1(replacement$Mntable)) ? lists.cadar.apply1(replacement$Mntable) : stringReplace(original, lists.cdr.apply1(replacement$Mntable));
    }

    public static Object coerceToYailList(Object arg) {
        if (isYailList(arg) != Boolean.FALSE) {
            return arg;
        }
        return isYailDictionary(arg) != Boolean.FALSE ? yailDictionaryDictToAlist(arg) : Lit2;
    }

    public static Object coerceToPair(Object arg) {
        return coerceToYailList(arg);
    }

    public static Object coerceToDictionary(Object arg) {
        Object arg2;
        if (isYailDictionary(arg) != Boolean.FALSE) {
            return arg;
        }
        if (isYailList(arg) != Boolean.FALSE) {
            return yailDictionaryAlistToDict(arg);
        }
        try {
            arg2 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(arg, Lit20));
        } catch (Exception e) {
            arg2 = Scheme.applyToArgs.apply1(Lit2);
        }
        return arg2;
    }

    public static Object coerceToBoolean(Object arg) {
        return misc.isBoolean(arg) ? arg : Lit2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isIsCoercible(Object x) {
        return ((x == Lit2 ? 1 : 0) + 1) & 1;
    }

    public static Object isAllCoercible(Object args) {
        if (lists.isNull(args)) {
            return Boolean.TRUE;
        }
        boolean x = isIsCoercible(lists.car.apply1(args));
        if (x) {
            return isAllCoercible(lists.cdr.apply1(args));
        }
        return x ? Boolean.TRUE : Boolean.FALSE;
    }

    public static String boolean$To$String(Object b) {
        return b != Boolean.FALSE ? "true" : "false";
    }

    public static Object paddedString$To$Number(Object s) {
        return numbers.string$To$Number(s.toString().trim(), 10);
    }

    public static String $StFormatInexact$St(Object n) {
        try {
            return YailNumberToString.format(((Number) n).doubleValue());
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailNumberToString.format(double)", 1, n);
        }
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame3 extends ModuleBody {
        final ModuleMethod lambda$Fn10;
        final ModuleMethod lambda$Fn9;
        Object n;

        public frame3() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 7, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1616");
            this.lambda$Fn9 = moduleMethod;
            ModuleMethod moduleMethod2 = new ModuleMethod(this, 8, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            moduleMethod2.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:1624");
            this.lambda$Fn10 = moduleMethod2;
        }

        void lambda9(Object port) {
            ports.display(this.n, port);
        }

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 7:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 8:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 7:
                    lambda9(obj);
                    return Values.empty;
                case 8:
                    lambda10(obj);
                    return Values.empty;
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        void lambda10(Object port) {
            Object obj = this.n;
            try {
                ports.display(numbers.exact((Number) obj), port);
            } catch (ClassCastException e) {
                throw new WrongType(e, "exact", 1, obj);
            }
        }
    }

    public static Object appinventorNumber$To$String(Object n) {
        frame3 frame3Var = new frame3();
        frame3Var.n = n;
        if (!numbers.isReal(frame3Var.n)) {
            return ports.callWithOutputString(frame3Var.lambda$Fn9);
        }
        if (numbers.isInteger(frame3Var.n)) {
            return ports.callWithOutputString(frame3Var.lambda$Fn10);
        }
        if (!numbers.isExact(frame3Var.n)) {
            return $StFormatInexact$St(frame3Var.n);
        }
        Object obj = frame3Var.n;
        try {
            return appinventorNumber$To$String(Arithmetic.toInexact((Number) obj));
        } catch (ClassCastException e) {
            throw new WrongType(e, "exact->inexact", 1, obj);
        }
    }

    /* JADX INFO: Multiple debug info for r0v4 java.lang.Object: [D('x' boolean), D('x' java.lang.Object)] */
    /* JADX INFO: Multiple debug info for r0v5 java.lang.Object: [D('x' java.lang.Object), D('x' boolean)] */
    public static Object isYailEqual(Object x1, Object x2) {
        boolean x = lists.isNull(x1);
        if (!x ? x : lists.isNull(x2)) {
            return Boolean.TRUE;
        }
        boolean x3 = lists.isNull(x1);
        if (!x3 ? lists.isNull(x2) : x3) {
            return Boolean.FALSE;
        }
        int i = ((lists.isPair(x1) ? 1 : 0) + 1) & 1;
        if (i == 0 ? i != 0 : !lists.isPair(x2)) {
            return isYailAtomicEqual(x1, x2);
        }
        int i2 = ((lists.isPair(x1) ? 1 : 0) + 1) & 1;
        if (i2 == 0 ? !lists.isPair(x2) : i2 != 0) {
            return Boolean.FALSE;
        }
        Object x4 = isYailEqual(lists.car.apply1(x1), lists.car.apply1(x2));
        if (x4 != Boolean.FALSE) {
            return isYailEqual(lists.cdr.apply1(x1), lists.cdr.apply1(x2));
        }
        return x4;
    }

    public static Object isYailAtomicEqual(Object x1, Object x2) {
        if (IsEqual.apply(x1, x2)) {
            return Boolean.TRUE;
        }
        Object nx1 = asNumber(x1);
        if (nx1 == Boolean.FALSE) {
            return nx1;
        }
        Object nx2 = asNumber(x2);
        return nx2 != Boolean.FALSE ? Scheme.numEqu.apply2(nx1, nx2) : nx2;
    }

    public static Object asNumber(Object x) {
        Object nx = coerceToNumber(x);
        return nx == Lit2 ? Boolean.FALSE : nx;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isYailNotEqual(Object x1, Object x2) {
        return ((isYailEqual(x1, x2) != Boolean.FALSE ? 1 : 0) + 1) & 1;
    }

    public static Object processAndDelayed$V(Object[] argsArray) {
        for (Object makeList = LList.makeList(argsArray, 0); !lists.isNull(makeList); makeList = lists.cdr.apply1(makeList)) {
            Object conjunct = Scheme.applyToArgs.apply1(lists.car.apply1(makeList));
            Object coerced$Mnconjunct = coerceToBoolean(conjunct);
            if (!isIsCoercible(coerced$Mnconjunct)) {
                return signalRuntimeError(strings.stringAppend("The AND operation cannot accept the argument ", getDisplayRepresentation(conjunct), " because it is neither true nor false"), strings.stringAppend("Bad argument to AND" instanceof Object[] ? "Bad argument to AND" : new Object[]{"Bad argument to AND"}));
            } else if (coerced$Mnconjunct == Boolean.FALSE) {
                return coerced$Mnconjunct;
            }
        }
        return Boolean.TRUE;
    }

    public static Object processOrDelayed$V(Object[] argsArray) {
        for (Object makeList = LList.makeList(argsArray, 0); !lists.isNull(makeList); makeList = lists.cdr.apply1(makeList)) {
            Object disjunct = Scheme.applyToArgs.apply1(lists.car.apply1(makeList));
            Object coerced$Mndisjunct = coerceToBoolean(disjunct);
            if (!isIsCoercible(coerced$Mndisjunct)) {
                return signalRuntimeError(strings.stringAppend("The OR operation cannot accept the argument ", getDisplayRepresentation(disjunct), " because it is neither true nor false"), strings.stringAppend("Bad argument to OR" instanceof Object[] ? "Bad argument to OR" : new Object[]{"Bad argument to OR"}));
            } else if (coerced$Mndisjunct != Boolean.FALSE) {
                return coerced$Mndisjunct;
            }
        }
        return Boolean.FALSE;
    }

    public static Number yailFloor(Object x) {
        try {
            return Arithmetic.toExact(numbers.floor(LangObjType.coerceRealNum(x)));
        } catch (ClassCastException e) {
            throw new WrongType(e, "floor", 1, x);
        }
    }

    public static Number yailCeiling(Object x) {
        try {
            return Arithmetic.toExact(numbers.ceiling(LangObjType.coerceRealNum(x)));
        } catch (ClassCastException e) {
            throw new WrongType(e, "ceiling", 1, x);
        }
    }

    public static Number yailRound(Object x) {
        try {
            return Arithmetic.toExact(numbers.round(LangObjType.coerceRealNum(x)));
        } catch (ClassCastException e) {
            throw new WrongType(e, "round", 1, x);
        }
    }

    public static Object randomSetSeed(Object seed) {
        if (numbers.isNumber(seed)) {
            try {
                $Strandom$Mnnumber$Mngenerator$St.setSeed(((Number) seed).longValue());
                return Values.empty;
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.util.Random.setSeed(long)", 2, seed);
            }
        } else if (strings.isString(seed)) {
            return randomSetSeed(paddedString$To$Number(seed));
        } else {
            if (lists.isList(seed)) {
                return randomSetSeed(lists.car.apply1(seed));
            }
            if (Boolean.TRUE == seed) {
                return randomSetSeed(Lit21);
            }
            if (Boolean.FALSE == seed) {
                return randomSetSeed(Lit22);
            }
            return randomSetSeed(Lit22);
        }
    }

    public static double randomFraction() {
        return $Strandom$Mnnumber$Mngenerator$St.nextDouble();
    }

    public static Object randomInteger(Object low, Object high) {
        try {
            RealNum low2 = numbers.ceiling(LangObjType.coerceRealNum(low));
            try {
                RealNum low3 = numbers.floor(LangObjType.coerceRealNum(high));
                while (Scheme.numGrt.apply2(low2, low3) != Boolean.FALSE) {
                    low2 = low3;
                    low3 = low2;
                }
                Object clow = ((Procedure) clip$Mnto$Mnjava$Mnint$Mnrange).apply1(low2);
                Object chigh = ((Procedure) clip$Mnto$Mnjava$Mnint$Mnrange).apply1(low3);
                AddOp addOp = AddOp.$Pl;
                Random random = $Strandom$Mnnumber$Mngenerator$St;
                Object apply2 = AddOp.$Pl.apply2(Lit21, AddOp.$Mn.apply2(chigh, clow));
                try {
                    Object apply22 = addOp.apply2(Integer.valueOf(random.nextInt(((Number) apply2).intValue())), clow);
                    try {
                        return Arithmetic.toExact((Number) apply22);
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "inexact->exact", 1, apply22);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "java.util.Random.nextInt(int)", 2, apply2);
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "floor", 1, high);
            }
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "ceiling", 1, low);
        }
    }

    static Object lambda11(Object x) {
        return numbers.max(lowest, numbers.min(x, highest));
    }

    public static Object yailDivide(Object n, Object d) {
        Object apply2 = Scheme.numEqu.apply2(d, Lit22);
        try {
            boolean x = ((Boolean) apply2).booleanValue();
            if (!x ? x : Scheme.numEqu.apply2(n, Lit22) != Boolean.FALSE) {
                signalRuntimeFormError("Division", ERROR_DIVISION_BY_ZERO, n);
                return n;
            } else if (Scheme.numEqu.apply2(d, Lit22) != Boolean.FALSE) {
                signalRuntimeFormError("Division", ERROR_DIVISION_BY_ZERO, n);
                Object apply22 = DivideOp.$Sl.apply2(n, d);
                try {
                    return Arithmetic.toInexact((Number) apply22);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "exact->inexact", 1, apply22);
                }
            } else {
                Object apply23 = DivideOp.$Sl.apply2(n, d);
                try {
                    return Arithmetic.toInexact((Number) apply23);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "exact->inexact", 1, apply23);
                }
            }
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "x", -2, apply2);
        }
    }

    public static Object degrees$To$RadiansInternal(Object degrees) {
        return DivideOp.$Sl.apply2(MultiplyOp.$St.apply2(degrees, Lit25), Lit26);
    }

    public static Object radians$To$DegreesInternal(Object radians) {
        return DivideOp.$Sl.apply2(MultiplyOp.$St.apply2(radians, Lit26), Lit25);
    }

    public static Object degrees$To$Radians(Object degrees) {
        Object rads = DivideOp.modulo.apply2(degrees$To$RadiansInternal(degrees), Lit27);
        if (Scheme.numGEq.apply2(rads, Lit25) != Boolean.FALSE) {
            return AddOp.$Mn.apply2(rads, Lit28);
        }
        return rads;
    }

    public static Object radians$To$Degrees(Object radians) {
        return DivideOp.modulo.apply2(radians$To$DegreesInternal(radians), Lit29);
    }

    public static Object sinDegrees(Object degrees) {
        if (Scheme.numEqu.apply2(DivideOp.modulo.apply2(degrees, Lit30), Lit22) != Boolean.FALSE) {
            return Scheme.numEqu.apply2(DivideOp.modulo.apply2(DivideOp.$Sl.apply2(degrees, Lit30), Lit23), Lit22) != Boolean.FALSE ? Lit22 : Scheme.numEqu.apply2(DivideOp.modulo.apply2(DivideOp.$Sl.apply2(AddOp.$Mn.apply2(degrees, Lit30), Lit26), Lit23), Lit22) != Boolean.FALSE ? Lit21 : Lit31;
        }
        Object degrees$To$RadiansInternal = degrees$To$RadiansInternal(degrees);
        try {
            return Double.valueOf(numbers.sin(((Number) degrees$To$RadiansInternal).doubleValue()));
        } catch (ClassCastException e) {
            throw new WrongType(e, "sin", 1, degrees$To$RadiansInternal);
        }
    }

    public static Object cosDegrees(Object degrees) {
        if (Scheme.numEqu.apply2(DivideOp.modulo.apply2(degrees, Lit30), Lit22) != Boolean.FALSE) {
            return Scheme.numEqu.apply2(DivideOp.modulo.apply2(DivideOp.$Sl.apply2(degrees, Lit30), Lit23), Lit21) != Boolean.FALSE ? Lit22 : Scheme.numEqu.apply2(DivideOp.modulo.apply2(DivideOp.$Sl.apply2(degrees, Lit26), Lit23), Lit21) != Boolean.FALSE ? Lit31 : Lit21;
        }
        Object degrees$To$RadiansInternal = degrees$To$RadiansInternal(degrees);
        try {
            return Double.valueOf(numbers.cos(((Number) degrees$To$RadiansInternal).doubleValue()));
        } catch (ClassCastException e) {
            throw new WrongType(e, "cos", 1, degrees$To$RadiansInternal);
        }
    }

    public static Object tanDegrees(Object degrees) {
        if (Scheme.numEqu.apply2(DivideOp.modulo.apply2(degrees, Lit26), Lit22) != Boolean.FALSE) {
            return Lit22;
        }
        if (Scheme.numEqu.apply2(DivideOp.modulo.apply2(AddOp.$Mn.apply2(degrees, Lit32), Lit30), Lit22) != Boolean.FALSE) {
            return Scheme.numEqu.apply2(DivideOp.modulo.apply2(DivideOp.$Sl.apply2(AddOp.$Mn.apply2(degrees, Lit32), Lit30), Lit23), Lit22) != Boolean.FALSE ? Lit21 : Lit31;
        }
        Object degrees$To$RadiansInternal = degrees$To$RadiansInternal(degrees);
        try {
            return Double.valueOf(numbers.tan(((Number) degrees$To$RadiansInternal).doubleValue()));
        } catch (ClassCastException e) {
            throw new WrongType(e, "tan", 1, degrees$To$RadiansInternal);
        }
    }

    public static Object asinDegrees(Object y) {
        try {
            return radians$To$DegreesInternal(Double.valueOf(numbers.asin(((Number) y).doubleValue())));
        } catch (ClassCastException e) {
            throw new WrongType(e, "asin", 1, y);
        }
    }

    public static Object acosDegrees(Object y) {
        try {
            return radians$To$DegreesInternal(Double.valueOf(numbers.acos(((Number) y).doubleValue())));
        } catch (ClassCastException e) {
            throw new WrongType(e, "acos", 1, y);
        }
    }

    public static Object atanDegrees(Object ratio) {
        return radians$To$DegreesInternal(numbers.atan.apply1(ratio));
    }

    public static Object atan2Degrees(Object y, Object x) {
        return radians$To$DegreesInternal(numbers.atan.apply2(y, x));
    }

    public static String stringToUpperCase(Object s) {
        return s.toString().toUpperCase();
    }

    public static String stringToLowerCase(Object s) {
        return s.toString().toLowerCase();
    }

    public static LList unicodeString$To$List(CharSequence str) {
        boolean x;
        LList result = LList.Empty;
        int i = strings.stringLength(str);
        while (true) {
            i--;
            if (i < 0) {
                return result;
            }
            if (i >= 1) {
                x = true;
            } else {
                x = false;
            }
            if (x) {
                char c = strings.stringRef(str, i);
                char c1 = strings.stringRef(str, i - 1);
                boolean x2 = characters.isChar$Gr$Eq(Char.make(c), Lit33);
                if (x2) {
                    boolean x3 = characters.isChar$Ls$Eq(Char.make(c), Lit34);
                    if (x3) {
                        boolean x4 = characters.isChar$Gr$Eq(Char.make(c1), Lit35);
                        if (x4) {
                            if (characters.isChar$Ls$Eq(Char.make(c1), Lit36)) {
                                result = new Pair(Char.make(strings.stringRef(str, i)), new Pair(Char.make(strings.stringRef(str, i - 1)), result));
                                i--;
                            } else {
                                result = new Pair(Char.make(strings.stringRef(str, i)), result);
                            }
                        } else if (!x4) {
                            result = new Pair(Char.make(strings.stringRef(str, i)), result);
                        } else {
                            result = new Pair(Char.make(strings.stringRef(str, i)), new Pair(Char.make(strings.stringRef(str, i - 1)), result));
                            i--;
                        }
                    } else if (x3) {
                        result = new Pair(Char.make(strings.stringRef(str, i)), new Pair(Char.make(strings.stringRef(str, i - 1)), result));
                        i--;
                    } else {
                        result = new Pair(Char.make(strings.stringRef(str, i)), result);
                    }
                } else if (x2) {
                    result = new Pair(Char.make(strings.stringRef(str, i)), new Pair(Char.make(strings.stringRef(str, i - 1)), result));
                    i--;
                } else {
                    result = new Pair(Char.make(strings.stringRef(str, i)), result);
                }
            } else if (x) {
                result = new Pair(Char.make(strings.stringRef(str, i)), new Pair(Char.make(strings.stringRef(str, i - 1)), result));
                i--;
            } else {
                result = new Pair(Char.make(strings.stringRef(str, i)), result);
            }
        }
    }

    public static CharSequence stringReverse(Object s) {
        try {
            return strings.list$To$String(lists.reverse(unicodeString$To$List((CharSequence) s)));
        } catch (ClassCastException e) {
            throw new WrongType(e, "unicode-string->list", 0, s);
        }
    }

    public static Object formatAsDecimal(Object number, Object places) {
        if (Scheme.numEqu.apply2(places, Lit22) != Boolean.FALSE) {
            return yailRound(number);
        }
        boolean x = numbers.isInteger(places);
        if (!x ? x : Scheme.numGrt.apply2(places, Lit22) != Boolean.FALSE) {
            return Format.formatToString(0, strings.stringAppend("~,", appinventorNumber$To$String(places), "f"), number);
        }
        return signalRuntimeError(strings.stringAppend("format-as-decimal was called with ", getDisplayRepresentation(places), " as the number of decimal places.  This number must be a non-negative integer."), strings.stringAppend("Bad number of decimal places for format as decimal" instanceof Object[] ? "Bad number of decimal places for format as decimal" : new Object[]{"Bad number of decimal places for format as decimal"}));
    }

    public static Boolean isIsNumber(Object arg) {
        boolean x;
        boolean x2 = numbers.isNumber(arg);
        return (!x2 ? !(x = strings.isString(arg)) ? !x : paddedString$To$Number(arg) == Boolean.FALSE : !x2) ? Boolean.FALSE : Boolean.TRUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isIsBase10(Object arg) {
        try {
            boolean x = Pattern.matches("[0123456789]*", (CharSequence) arg);
            if (!x) {
                return x;
            }
            return ((isStringEmpty(arg) != Boolean.FALSE ? 1 : 0) + 1) & 1;
        } catch (ClassCastException e) {
            throw new WrongType(e, "java.util.regex.Pattern.matches(java.lang.String,java.lang.CharSequence)", 2, arg);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isIsHexadecimal(Object arg) {
        try {
            boolean x = Pattern.matches("[0-9a-fA-F]*", (CharSequence) arg);
            if (!x) {
                return x;
            }
            return ((isStringEmpty(arg) != Boolean.FALSE ? 1 : 0) + 1) & 1;
        } catch (ClassCastException e) {
            throw new WrongType(e, "java.util.regex.Pattern.matches(java.lang.String,java.lang.CharSequence)", 2, arg);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isIsBinary(Object arg) {
        try {
            boolean x = Pattern.matches("[01]*", (CharSequence) arg);
            if (!x) {
                return x;
            }
            return ((isStringEmpty(arg) != Boolean.FALSE ? 1 : 0) + 1) & 1;
        } catch (ClassCastException e) {
            throw new WrongType(e, "java.util.regex.Pattern.matches(java.lang.String,java.lang.CharSequence)", 2, arg);
        }
    }

    public static Object mathConvertDecHex(Object x) {
        if (!isIsBase10(x)) {
            return signalRuntimeError(Format.formatToString(0, "Convert base 10 to hex: '~A' is not a positive integer", getDisplayRepresentation(x)), "Argument is not a positive integer");
        }
        try {
            Object string$To$Number = numbers.string$To$Number((CharSequence) x, 10);
            try {
                return stringToUpperCase(numbers.number$To$String((Number) string$To$Number, 16));
            } catch (ClassCastException e) {
                throw new WrongType(e, "number->string", 1, string$To$Number);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "string->number", 1, x);
        }
    }

    public static Object mathConvertHexDec(Object x) {
        if (isIsHexadecimal(x)) {
            return numbers.string$To$Number(stringToUpperCase(x), 16);
        }
        return signalRuntimeError(Format.formatToString(0, "Convert hex to base 10: '~A' is not a hexadecimal number", getDisplayRepresentation(x)), "Invalid hexadecimal number");
    }

    public static Object mathConvertBinDec(Object x) {
        if (!isIsBinary(x)) {
            return signalRuntimeError(Format.formatToString(0, "Convert binary to base 10: '~A' is not a  binary number", getDisplayRepresentation(x)), "Invalid binary number");
        }
        try {
            return numbers.string$To$Number((CharSequence) x, 2);
        } catch (ClassCastException e) {
            throw new WrongType(e, "string->number", 1, x);
        }
    }

    public static Object mathConvertDecBin(Object x) {
        if (!isIsBase10(x)) {
            return signalRuntimeError(Format.formatToString(0, "Convert base 10 to binary: '~A' is not a positive integer", getDisplayRepresentation(x)), "Argument is not a positive integer");
        }
        try {
            return patchedNumber$To$StringBinary(numbers.string$To$Number((CharSequence) x, 10));
        } catch (ClassCastException e) {
            throw new WrongType(e, "string->number", 1, x);
        }
    }

    public static Object patchedNumber$To$StringBinary(Object x) {
        try {
            if (Scheme.numLss.apply2(numbers.abs((Number) x), Lit37) == Boolean.FALSE) {
                return alternateNumber$To$StringBinary(x);
            }
            try {
                return numbers.number$To$String((Number) x, 2);
            } catch (ClassCastException e) {
                throw new WrongType(e, "number->string", 1, x);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "abs", 1, x);
        }
    }

    public static Object alternateNumber$To$StringBinary(Object x) {
        try {
            Number abs = numbers.abs((Number) x);
            try {
                RealNum clean$Mnx = numbers.floor(LangObjType.coerceRealNum(abs));
                Object converted$Mnclean$Mnx = internalBinaryConvert(clean$Mnx);
                return clean$Mnx.doubleValue() >= 0.0d ? converted$Mnclean$Mnx : strings.stringAppend("-", converted$Mnclean$Mnx);
            } catch (ClassCastException e) {
                throw new WrongType(e, "floor", 1, abs);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "abs", 1, x);
        }
    }

    public static Object internalBinaryConvert(Object x) {
        return Scheme.numEqu.apply2(x, Lit22) != Boolean.FALSE ? "0" : Scheme.numEqu.apply2(x, Lit21) != Boolean.FALSE ? "1" : strings.stringAppend(internalBinaryConvert(DivideOp.quotient.apply2(x, Lit23)), internalBinaryConvert(DivideOp.remainder.apply2(x, Lit23)));
    }

    public static Object isYailList(Object x) {
        Object x2 = isYailListCandidate(x);
        return x2 != Boolean.FALSE ? x instanceof YailList ? Boolean.TRUE : Boolean.FALSE : x2;
    }

    public static Object isYailListCandidate(Object x) {
        boolean x2 = lists.isPair(x);
        return x2 ? IsEqual.apply(lists.car.apply1(x), Lit38) ? Boolean.TRUE : Boolean.FALSE : x2 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object yailListContents(Object yail$Mnlist) {
        return lists.cdr.apply1(yail$Mnlist);
    }

    public static void setYailListContents$Ex(Object yail$Mnlist, Object contents) {
        try {
            ((Pair) yail$Mnlist).setCdr(contents);
        } catch (ClassCastException e) {
            throw new WrongType(e, "set-cdr!", 1, yail$Mnlist);
        }
    }

    public static Object insertYailListHeader(Object x) {
        return Invoke.invokeStatic.apply3(YailList, Lit39, x);
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object kawaList$To$YailList(Object x) {
        if (lists.isNull(x)) {
            return new YailList();
        }
        if (!lists.isPair(x)) {
            return sanitizeAtomic(x);
        }
        if (isYailList(x) != Boolean.FALSE) {
            return x;
        }
        Object obj = LList.Empty;
        Object arg0 = x;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(kawaList$To$YailList(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        return YailList.makeList((List) LList.reverseInPlace(obj));
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object yailList$To$KawaList(Object data) {
        if (isYailList(data) == Boolean.FALSE) {
            return data;
        }
        Object arg0 = yailListContents(data);
        Object obj = LList.Empty;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(yailList$To$KawaList(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        return LList.reverseInPlace(obj);
    }

    public static Object isYailListEmpty(Object x) {
        Object x2 = isYailList(x);
        return x2 != Boolean.FALSE ? lists.isNull(yailListContents(x)) ? Boolean.TRUE : Boolean.FALSE : x2;
    }

    public static YailList makeYailList$V(Object[] argsArray) {
        return YailList.makeList((List) LList.makeList(argsArray, 0));
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object yailListCopy(Object yl) {
        if (isYailListEmpty(yl) != Boolean.FALSE) {
            return new YailList();
        }
        if (!lists.isPair(yl)) {
            return yl;
        }
        Object arg0 = yailListContents(yl);
        Object obj = LList.Empty;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(yailListCopy(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        return YailList.makeList((List) LList.reverseInPlace(obj));
    }

    public static Object yailListReverse(Object yl) {
        if (isYailList(yl) == Boolean.FALSE) {
            return signalRuntimeError("Argument value to \"reverse list\" must be a list", "Expecting list");
        }
        Object yailListContents = yailListContents(yl);
        try {
            return insertYailListHeader(lists.reverse((LList) yailListContents));
        } catch (ClassCastException e) {
            throw new WrongType(e, "reverse", 1, yailListContents);
        }
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object yailListToCsvTable(Object yl) {
        if (isYailList(yl) == Boolean.FALSE) {
            return signalRuntimeError("Argument value to \"list to csv table\" must be a list", "Expecting list");
        }
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = make$Mnyail$Mnlist;
        Object arg0 = yailListContents(yl);
        Object obj = LList.Empty;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(convertToStringsForCsv(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return CsvUtil.toCsvTable((YailList) apply2);
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "com.google.appinventor.components.runtime.util.CsvUtil.toCsvTable(com.google.appinventor.components.runtime.util.YailList)", 1, apply2);
        }
    }

    public static Object yailListToCsvRow(Object yl) {
        if (isYailList(yl) == Boolean.FALSE) {
            return signalRuntimeError("Argument value to \"list to csv row\" must be a list", "Expecting list");
        }
        Object convertToStringsForCsv = convertToStringsForCsv(yl);
        try {
            return CsvUtil.toCsvRow((YailList) convertToStringsForCsv);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.CsvUtil.toCsvRow(com.google.appinventor.components.runtime.util.YailList)", 1, convertToStringsForCsv);
        }
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object convertToStringsForCsv(Object yl) {
        if (isYailListEmpty(yl) != Boolean.FALSE) {
            return yl;
        }
        if (isYailList(yl) == Boolean.FALSE) {
            return makeYailList$V(new Object[]{yl});
        }
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = make$Mnyail$Mnlist;
        Object arg0 = yailListContents(yl);
        Object obj = LList.Empty;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object arg03 = arg02.getCdr();
                obj = Pair.make(coerceToString(arg02.getCar()), obj);
                arg0 = arg03;
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        return apply.apply2(moduleMethod, LList.reverseInPlace(obj));
    }

    public static Object yailListFromCsvTable(Object str) {
        String obj;
        if (str == null) {
            obj = null;
        } else {
            try {
                obj = str.toString();
            } catch (Exception exception) {
                return signalRuntimeError("Cannot parse text argument to \"list from csv table\" as a CSV-formatted table", exception.getMessage());
            }
        }
        return CsvUtil.fromCsvTable(obj);
    }

    public static Object yailListFromCsvRow(Object str) {
        String obj;
        if (str == null) {
            obj = null;
        } else {
            try {
                obj = str.toString();
            } catch (Exception exception) {
                return signalRuntimeError("Cannot parse text argument to \"list from csv row\" as CSV-formatted row", exception.getMessage());
            }
        }
        return CsvUtil.fromCsvRow(obj);
    }

    public static int yailListLength(Object yail$Mnlist) {
        Object yailListContents = yailListContents(yail$Mnlist);
        try {
            return lists.length((LList) yailListContents);
        } catch (ClassCastException e) {
            throw new WrongType(e, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, yailListContents);
        }
    }

    public static Object yailListIndex(Object object, Object yail$Mnlist) {
        Object obj = Lit21;
        for (Object yailListContents = yailListContents(yail$Mnlist); !lists.isNull(yailListContents); yailListContents = lists.cdr.apply1(yailListContents)) {
            if (isYailEqual(object, lists.car.apply1(yailListContents)) != Boolean.FALSE) {
                return obj;
            }
            obj = AddOp.$Pl.apply2(obj, Lit21);
        }
        return Lit22;
    }

    public static Object yailListGetItem(Object yail$Mnlist, Object index) {
        if (Scheme.numLss.apply2(index, Lit21) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Select list item: Attempt to get item number ~A, of the list ~A.  The minimum valid item number is 1.", index, getDisplayRepresentation(yail$Mnlist)), "List index smaller than 1");
        }
        int len = yailListLength(yail$Mnlist);
        if (Scheme.numGrt.apply2(index, Integer.valueOf(len)) != Boolean.FALSE) {
            return signalRuntimeError(Format.formatToString(0, "Select list item: Attempt to get item number ~A of a list of length ~A: ~A", index, Integer.valueOf(len), getDisplayRepresentation(yail$Mnlist)), "Select list item: List index too large");
        }
        Object yailListContents = yailListContents(yail$Mnlist);
        Object apply2 = AddOp.$Mn.apply2(index, Lit21);
        try {
            return lists.listRef(yailListContents, ((Number) apply2).intValue());
        } catch (ClassCastException e) {
            throw new WrongType(e, "list-ref", 2, apply2);
        }
    }

    public static void yailListSetItem$Ex(Object yail$Mnlist, Object index, Object value) {
        if (Scheme.numLss.apply2(index, Lit21) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Replace list item: Attempt to replace item number ~A of the list ~A.  The minimum valid item number is 1.", index, getDisplayRepresentation(yail$Mnlist)), "List index smaller than 1");
        }
        int len = yailListLength(yail$Mnlist);
        if (Scheme.numGrt.apply2(index, Integer.valueOf(len)) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Replace list item: Attempt to replace item number ~A of a list of length ~A: ~A", index, Integer.valueOf(len), getDisplayRepresentation(yail$Mnlist)), "List index too large");
        }
        Object yailListContents = yailListContents(yail$Mnlist);
        Object apply2 = AddOp.$Mn.apply2(index, Lit21);
        try {
            Object listTail = lists.listTail(yailListContents, ((Number) apply2).intValue());
            try {
                ((Pair) listTail).setCar(value);
            } catch (ClassCastException e) {
                throw new WrongType(e, "set-car!", 1, listTail);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "list-tail", 2, apply2);
        }
    }

    public static void yailListRemoveItem$Ex(Object yail$Mnlist, Object index) {
        Object index2 = coerceToNumber(index);
        if (index2 == Lit2) {
            signalRuntimeError(Format.formatToString(0, "Remove list item: index -- ~A -- is not a number", getDisplayRepresentation(index)), "Bad list index");
        }
        if (isYailListEmpty(yail$Mnlist) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Remove list item: Attempt to remove item ~A of an empty list", getDisplayRepresentation(index)), "Invalid list operation");
        }
        if (Scheme.numLss.apply2(index2, Lit21) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Remove list item: Attempt to remove item ~A of the list ~A.  The minimum valid item number is 1.", index2, getDisplayRepresentation(yail$Mnlist)), "List index smaller than 1");
        }
        int len = yailListLength(yail$Mnlist);
        if (Scheme.numGrt.apply2(index2, Integer.valueOf(len)) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Remove list item: Attempt to remove item ~A of a list of length ~A: ~A", index2, Integer.valueOf(len), getDisplayRepresentation(yail$Mnlist)), "List index too large");
        }
        Object apply2 = AddOp.$Mn.apply2(index2, Lit21);
        try {
            Object pair$Mnpointing$Mnto$Mndeletion = lists.listTail(yail$Mnlist, ((Number) apply2).intValue());
            try {
                ((Pair) pair$Mnpointing$Mnto$Mndeletion).setCdr(lists.cddr.apply1(pair$Mnpointing$Mnto$Mndeletion));
            } catch (ClassCastException e) {
                throw new WrongType(e, "set-cdr!", 1, pair$Mnpointing$Mnto$Mndeletion);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "list-tail", 2, apply2);
        }
    }

    public static void yailListInsertItem$Ex(Object yail$Mnlist, Object index, Object item) {
        Object index2 = coerceToNumber(index);
        if (index2 == Lit2) {
            signalRuntimeError(Format.formatToString(0, "Insert list item: index (~A) is not a number", getDisplayRepresentation(index)), "Bad list index");
        }
        if (Scheme.numLss.apply2(index2, Lit21) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Insert list item: Attempt to insert item ~A into the list ~A.  The minimum valid item number is 1.", index2, getDisplayRepresentation(yail$Mnlist)), "List index smaller than 1");
        }
        int len$Pl1 = yailListLength(yail$Mnlist) + 1;
        if (Scheme.numGrt.apply2(index2, Integer.valueOf(len$Pl1)) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Insert list item: Attempt to insert item ~A into the list ~A.  The maximum valid item number is ~A.", index2, getDisplayRepresentation(yail$Mnlist), Integer.valueOf(len$Pl1)), "List index too large");
        }
        Object contents = yailListContents(yail$Mnlist);
        if (Scheme.numEqu.apply2(index2, Lit21) != Boolean.FALSE) {
            setYailListContents$Ex(yail$Mnlist, lists.cons(item, contents));
            return;
        }
        Object apply2 = AddOp.$Mn.apply2(index2, Lit23);
        try {
            Object at$Mnitem = lists.listTail(contents, ((Number) apply2).intValue());
            try {
                ((Pair) at$Mnitem).setCdr(lists.cons(item, lists.cdr.apply1(at$Mnitem)));
            } catch (ClassCastException e) {
                throw new WrongType(e, "set-cdr!", 1, at$Mnitem);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "list-tail", 2, apply2);
        }
    }

    public static void yailListAppend$Ex(Object yail$Mnlist$MnA, Object yail$Mnlist$MnB) {
        Object yailListContents = yailListContents(yail$Mnlist$MnA);
        try {
            Object listTail = lists.listTail(yail$Mnlist$MnA, lists.length((LList) yailListContents));
            try {
                ((Pair) listTail).setCdr(lambda12listCopy(yailListContents(yail$Mnlist$MnB)));
            } catch (ClassCastException e) {
                throw new WrongType(e, "set-cdr!", 1, listTail);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, yailListContents);
        }
    }

    public static Object lambda12listCopy(Object l) {
        return lists.isNull(l) ? LList.Empty : lists.cons(lists.car.apply1(l), lambda12listCopy(lists.cdr.apply1(l)));
    }

    public static void yailListAddToList$Ex$V(Object yail$Mnlist, Object[] argsArray) {
        yailListAppend$Ex(yail$Mnlist, Scheme.apply.apply2(make$Mnyail$Mnlist, LList.makeList(argsArray, 0)));
    }

    public static Boolean isYailListMember(Object object, Object yail$Mnlist) {
        return lists.member(object, yailListContents(yail$Mnlist), yail$Mnequal$Qu) != Boolean.FALSE ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object yailListPickRandom(Object yail$Mnlist) {
        if (isYailListEmpty(yail$Mnlist) != Boolean.FALSE) {
            signalRuntimeError(Format.formatToString(0, "Pick random item: Attempt to pick a random element from an empty list" instanceof Object[] ? "Pick random item: Attempt to pick a random element from an empty list" : new Object[]{"Pick random item: Attempt to pick a random element from an empty list"}), "Invalid list operation");
        }
        return yailListGetItem(yail$Mnlist, randomInteger(Lit21, Integer.valueOf(yailListLength(yail$Mnlist))));
    }

    /* JADX INFO: Multiple debug info for r0v3 gnu.lists.Pair: [D('arg0' gnu.lists.Pair), D('arg0' java.lang.Object)] */
    public static Object yailForEach(Object proc, Object yail$Mnlist) {
        Object verified$Mnlist = coerceToYailList(yail$Mnlist);
        if (verified$Mnlist == Lit2) {
            return signalRuntimeError(Format.formatToString(0, "The second argument to foreach is not a list.  The second argument is: ~A", getDisplayRepresentation(yail$Mnlist)), "Bad list argument to foreach");
        }
        Object arg0 = yailListContents(verified$Mnlist);
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Scheme.applyToArgs.apply2(proc, arg02.getCar());
                arg0 = arg02.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, arg0);
            }
        }
        return null;
    }

    public static Object yailForRange(Object proc, Object start, Object end, Object step) {
        Object nstart = coerceToNumber(start);
        Object nend = coerceToNumber(end);
        Object nstep = coerceToNumber(step);
        if (nstart == Lit2) {
            signalRuntimeError(Format.formatToString(0, "For range: the start value -- ~A -- is not a number", getDisplayRepresentation(start)), "Bad start value");
        }
        if (nend == Lit2) {
            signalRuntimeError(Format.formatToString(0, "For range: the end value -- ~A -- is not a number", getDisplayRepresentation(end)), "Bad end value");
        }
        if (nstep == Lit2) {
            signalRuntimeError(Format.formatToString(0, "For range: the step value -- ~A -- is not a number", getDisplayRepresentation(step)), "Bad step value");
        }
        return yailForRangeWithNumericCheckedArgs(proc, nstart, nend, nstep);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r3 != false) goto L_0x004b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (r3 == false) goto L_0x0071;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0 A[LOOP:0: B:29:0x0080->B:43:0x00b0, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object yailForRangeWithNumericCheckedArgs(java.lang.Object r9, java.lang.Object r10, java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.youngandroid.runtime.yailForRangeWithNumericCheckedArgs(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // gnu.expr.ModuleBody
    public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
        switch (moduleMethod.selector) {
            case 13:
                return addComponentWithinRepl(obj, obj2, obj3, obj4);
            case 19:
                return setAndCoerceProperty$Ex(obj, obj2, obj3, obj4);
            case 42:
                return callComponentMethod(obj, obj2, obj3, obj4);
            case 44:
                return callYailPrimitive(obj, obj2, obj3, obj4);
            case 53:
                return callWithCoercedArgs(obj, obj2, obj3, obj4);
            case 54:
                return $PcSetAndCoerceProperty$Ex(obj, obj2, obj3, obj4);
            case 151:
                return yailForRange(obj, obj2, obj3, obj4);
            case 152:
                return yailForRangeWithNumericCheckedArgs(obj, obj2, obj3, obj4);
            default:
                return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
        }
    }

    public static Object yailNumberRange(Object low, Object high) {
        try {
            try {
                return kawaList$To$YailList(lambda13loop(Arithmetic.toExact(numbers.ceiling(LangObjType.coerceRealNum(low))), Arithmetic.toExact(numbers.floor(LangObjType.coerceRealNum(high)))));
            } catch (ClassCastException e) {
                throw new WrongType(e, "floor", 1, high);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "ceiling", 1, low);
        }
    }

    public static Object lambda13loop(Object a, Object b) {
        return Scheme.numGrt.apply2(a, b) != Boolean.FALSE ? LList.Empty : lists.cons(a, lambda13loop(AddOp.$Pl.apply2(a, Lit21), b));
    }

    public static Object yailAlistLookup(Object key, Object yail$Mnlist$Mnof$Mnpairs, Object obj) {
        androidLog(Format.formatToString(0, "List alist lookup key is  ~A and table is ~A", key, yail$Mnlist$Mnof$Mnpairs));
        for (Object pairs$Mnto$Mncheck = yailListContents(yail$Mnlist$Mnof$Mnpairs); !lists.isNull(pairs$Mnto$Mncheck); pairs$Mnto$Mncheck = lists.cdr.apply1(pairs$Mnto$Mncheck)) {
            if (isPairOk(lists.car.apply1(pairs$Mnto$Mncheck)) == Boolean.FALSE) {
                return signalRuntimeError(Format.formatToString(0, "Lookup in pairs: the list ~A is not a well-formed list of pairs", getDisplayRepresentation(yail$Mnlist$Mnof$Mnpairs)), "Invalid list of pairs");
            } else if (isYailEqual(key, lists.car.apply1(yailListContents(lists.car.apply1(pairs$Mnto$Mncheck)))) != Boolean.FALSE) {
                return lists.cadr.apply1(yailListContents(lists.car.apply1(pairs$Mnto$Mncheck)));
            }
        }
        return obj;
    }

    public static Object isPairOk(Object candidate$Mnpair) {
        Object x = isYailList(candidate$Mnpair);
        if (x == Boolean.FALSE) {
            return x;
        }
        Object yailListContents = yailListContents(candidate$Mnpair);
        try {
            return lists.length((LList) yailListContents) == 2 ? Boolean.TRUE : Boolean.FALSE;
        } catch (ClassCastException e) {
            throw new WrongType(e, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, yailListContents);
        }
    }

    public static Object yailListJoinWithSeparator(Object yail$Mnlist, Object separator) {
        return joinStrings(yailListContents(yail$Mnlist), separator);
    }

    public static YailDictionary makeYailDictionary$V(Object[] argsArray) {
        return YailDictionary.makeDictionary(LList.makeList(argsArray, 0));
    }

    @Override // gnu.expr.ModuleBody
    public Object applyN(ModuleMethod moduleMethod, Object[] objArr) {
        switch (moduleMethod.selector) {
            case 14:
                return call$MnInitializeOfComponents$V(objArr);
            case 23:
                return setAndCoercePropertyAndCheck$Ex(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            case 24:
                return symbolAppend$V(objArr);
            case 40:
                return lambda22(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            case 41:
                Object obj = objArr[0];
                Object obj2 = objArr[1];
                int length = objArr.length - 2;
                Object[] objArr2 = new Object[length];
                while (true) {
                    length--;
                    if (length < 0) {
                        return lambda23$V(obj, obj2, objArr2);
                    }
                    objArr2[length] = objArr[length + 2];
                }
            case 43:
                return callComponentTypeMethod(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            case 87:
                return processAndDelayed$V(objArr);
            case 88:
                return processOrDelayed$V(objArr);
            case 132:
                return makeYailList$V(objArr);
            case 147:
                Object obj3 = objArr[0];
                int length2 = objArr.length - 1;
                Object[] objArr3 = new Object[length2];
                while (true) {
                    length2--;
                    if (length2 < 0) {
                        yailListAddToList$Ex$V(obj3, objArr3);
                        return Values.empty;
                    }
                    objArr3[length2] = objArr[length2 + 1];
                }
            case 157:
                return makeYailDictionary$V(objArr);
            default:
                return super.applyN(moduleMethod, objArr);
        }
    }

    public static YailList makeDictionaryPair(Object key, Object value) {
        return makeYailList$V(new Object[]{key, value});
    }

    public static Object yailDictionarySetPair(Object key, Object yail$Mndictionary, Object value) {
        return ((YailDictionary) yail$Mndictionary).put(key, value);
    }

    public static Object yailDictionaryDeletePair(Object yail$Mndictionary, Object key) {
        return ((YailDictionary) yail$Mndictionary).remove(key);
    }

    public static Object yailDictionaryLookup(Object key, Object yail$Mndictionary, Object obj) {
        Object result = yail$Mndictionary instanceof YailList ? yailAlistLookup(key, yail$Mndictionary, obj) : yail$Mndictionary instanceof YailDictionary ? ((YailDictionary) yail$Mndictionary).get(key) : obj;
        if (result == null) {
            return obj;
        }
        return result;
    }

    public static Object yailDictionaryRecursiveLookup(Object keys, Object yail$Mndictionary, Object obj) {
        YailDictionary yailDictionary = (YailDictionary) yail$Mndictionary;
        Object yailListContents = yailListContents(keys);
        try {
            Object result = yailDictionary.getObjectAtKeyPath((List) yailListContents);
            return result == null ? obj : result;
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailDictionary.getObjectAtKeyPath(java.util.List)", 2, yailListContents);
        }
    }

    public static YailList yailDictionaryWalk(Object path, Object dict) {
        try {
            YailObject yailObject = (YailObject) dict;
            Object yailListContents = yailListContents(path);
            try {
                return YailList.makeList((List) YailDictionary.walkKeyPath(yailObject, (List) yailListContents));
            } catch (ClassCastException e) {
                throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailDictionary.walkKeyPath(com.google.appinventor.components.runtime.util.YailObject,java.util.List)", 2, yailListContents);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "com.google.appinventor.components.runtime.util.YailDictionary.walkKeyPath(com.google.appinventor.components.runtime.util.YailObject,java.util.List)", 1, dict);
        }
    }

    public static Object yailDictionaryRecursiveSet(Object keys, Object yail$Mndictionary, Object value) {
        return Scheme.applyToArgs.apply3(GetNamedPart.getNamedPart.apply2(yail$Mndictionary, Lit40), yailListContents(keys), value);
    }

    public static YailList yailDictionaryGetKeys(Object yail$Mndictionary) {
        return YailList.makeList((Set) ((YailDictionary) yail$Mndictionary).keySet());
    }

    public static YailList yailDictionaryGetValues(Object yail$Mndictionary) {
        return YailList.makeList(((YailDictionary) yail$Mndictionary).values());
    }

    public static boolean yailDictionaryIsKeyIn(Object key, Object yail$Mndictionary) {
        return ((YailDictionary) yail$Mndictionary).containsKey(key);
    }

    public static int yailDictionaryLength(Object yail$Mndictionary) {
        return ((YailDictionary) yail$Mndictionary).size();
    }

    public static Object yailDictionaryAlistToDict(Object alist) {
        for (Object pairs$Mnto$Mncheck = yailListContents(alist); !lists.isNull(pairs$Mnto$Mncheck); pairs$Mnto$Mncheck = lists.cdr.apply1(pairs$Mnto$Mncheck)) {
            if (isPairOk(lists.car.apply1(pairs$Mnto$Mncheck)) == Boolean.FALSE) {
                signalRuntimeError(Format.formatToString(0, "List of pairs to dict: the list ~A is not a well-formed list of pairs", getDisplayRepresentation(alist)), "Invalid list of pairs");
                break;
            }
        }
        try {
            return YailDictionary.alistToDict((YailList) alist);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailDictionary.alistToDict(com.google.appinventor.components.runtime.util.YailList)", 1, alist);
        }
    }

    public static Object yailDictionaryDictToAlist(Object dict) {
        try {
            return YailDictionary.dictToAlist((YailDictionary) dict);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailDictionary.dictToAlist(com.google.appinventor.components.runtime.util.YailDictionary)", 1, dict);
        }
    }

    public static Object yailDictionaryCopy(Object yail$Mndictionary) {
        return ((YailDictionary) yail$Mndictionary).clone();
    }

    public static void yailDictionaryCombineDicts(Object first$Mndictionary, Object second$Mndictionary) {
        try {
            ((YailDictionary) first$Mndictionary).putAll((Map) second$Mndictionary);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.YailDictionary.putAll(java.util.Map)", 2, second$Mndictionary);
        }
    }

    public static Object isYailDictionary(Object x) {
        return x instanceof YailDictionary ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object makeDisjunct(Object x) {
        String str = null;
        if (lists.isNull(lists.cdr.apply1(x))) {
            Object apply1 = lists.car.apply1(x);
            if (apply1 != null) {
                str = apply1.toString();
            }
            return Pattern.quote(str);
        }
        Object[] objArr = new Object[2];
        Object apply12 = lists.car.apply1(x);
        if (apply12 != null) {
            str = apply12.toString();
        }
        objArr[0] = Pattern.quote(str);
        objArr[1] = strings.stringAppend("|", makeDisjunct(lists.cdr.apply1(x)));
        return strings.stringAppend(objArr);
    }

    public static Object array$To$List(Object arr) {
        try {
            return insertYailListHeader(LList.makeList((Object[]) arr, 0));
        } catch (ClassCastException e) {
            throw new WrongType(e, "gnu.lists.LList.makeList(java.lang.Object[],int)", 1, arr);
        }
    }

    public static int stringStartsAt(Object text, Object piece) {
        return text.toString().indexOf(piece.toString()) + 1;
    }

    public static Boolean stringContains(Object text, Object piece) {
        return stringStartsAt(text, piece) == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Object stringContainsAny(Object text, Object piece$Mnlist) {
        for (Object piece$Mnlist2 = yailListContents(piece$Mnlist); !lists.isNull(piece$Mnlist2); piece$Mnlist2 = lists.cdr.apply1(piece$Mnlist2)) {
            Boolean x = stringContains(text, lists.car.apply1(piece$Mnlist2));
            if (x != Boolean.FALSE) {
                return x;
            }
        }
        return Boolean.FALSE;
    }

    public static Object stringContainsAll(Object text, Object piece$Mnlist) {
        for (Object piece$Mnlist2 = yailListContents(piece$Mnlist); !lists.isNull(piece$Mnlist2); piece$Mnlist2 = lists.cdr.apply1(piece$Mnlist2)) {
            Boolean x = stringContains(text, lists.car.apply1(piece$Mnlist2));
            if (x == Boolean.FALSE) {
                return x;
            }
        }
        return Boolean.TRUE;
    }

    public static Object stringSplitAtFirst(Object text, Object at) {
        return array$To$List(text.toString().split(Pattern.quote(at == null ? null : at.toString()), 2));
    }

    public static Object stringSplitAtFirstOfAny(Object text, Object at) {
        if (lists.isNull(yailListContents(at))) {
            return signalRuntimeError("split at first of any: The list of places to split at is empty.", "Invalid text operation");
        }
        String obj = text.toString();
        Object makeDisjunct = makeDisjunct(yailListContents(at));
        return array$To$List(obj.split(makeDisjunct == null ? null : makeDisjunct.toString(), 2));
    }

    public static Object stringSplit(Object text, Object at) {
        return array$To$List(text.toString().split(Pattern.quote(at == null ? null : at.toString())));
    }

    public static Object stringSplitAtAny(Object text, Object at) {
        if (lists.isNull(yailListContents(at))) {
            return signalRuntimeError("split at any: The list of places to split at is empty.", "Invalid text operation");
        }
        String obj = text.toString();
        Object makeDisjunct = makeDisjunct(yailListContents(at));
        return array$To$List(obj.split(makeDisjunct == null ? null : makeDisjunct.toString(), -1));
    }

    public static Object stringSplitAtSpaces(Object text) {
        return array$To$List(text.toString().trim().split("\\s+", -1));
    }

    public static Object stringSubstring(Object wholestring, Object start, Object length) {
        try {
            int len = strings.stringLength((CharSequence) wholestring);
            if (Scheme.numLss.apply2(start, Lit21) != Boolean.FALSE) {
                return signalRuntimeError(Format.formatToString(0, "Segment: Start is less than 1 (~A).", start), "Invalid text operation");
            }
            if (Scheme.numLss.apply2(length, Lit22) != Boolean.FALSE) {
                return signalRuntimeError(Format.formatToString(0, "Segment: Length is negative (~A).", length), "Invalid text operation");
            }
            if (Scheme.numGrt.apply2(AddOp.$Pl.apply2(AddOp.$Mn.apply2(start, Lit21), length), Integer.valueOf(len)) != Boolean.FALSE) {
                return signalRuntimeError(Format.formatToString(0, "Segment: Start (~A) + length (~A) - 1 exceeds text length (~A).", start, length, Integer.valueOf(len)), "Invalid text operation");
            }
            try {
                CharSequence charSequence = (CharSequence) wholestring;
                Object apply2 = AddOp.$Mn.apply2(start, Lit21);
                try {
                    int intValue = ((Number) apply2).intValue();
                    Object apply22 = AddOp.$Pl.apply2(AddOp.$Mn.apply2(start, Lit21), length);
                    try {
                        return strings.substring(charSequence, intValue, ((Number) apply22).intValue());
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "substring", 3, apply22);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "substring", 2, apply2);
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "substring", 1, wholestring);
            }
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "string-length", 1, wholestring);
        }
    }

    public static String stringTrim(Object text) {
        return text.toString().trim();
    }

    public static String stringReplaceAll(Object text, Object substring, Object replacement) {
        return text.toString().replaceAll(Pattern.quote(substring.toString()), replacement.toString());
    }

    @Override // gnu.expr.ModuleBody
    public Object apply3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3) {
        switch (moduleMethod.selector) {
            case 22:
                return getPropertyAndCheck(obj, obj2, obj3);
            case 38:
                return lambda21(obj, obj2, obj3);
            case 51:
                return signalRuntimeFormError(obj, obj2, obj3);
            case 55:
                return $PcSetSubformLayoutProperty$Ex(obj, obj2, obj3);
            case 58:
                return coerceArgs(obj, obj2, obj3);
            case 143:
                yailListSetItem$Ex(obj, obj2, obj3);
                return Values.empty;
            case 145:
                yailListInsertItem$Ex(obj, obj2, obj3);
                return Values.empty;
            case 154:
                return yailAlistLookup(obj, obj2, obj3);
            case 159:
                return yailDictionarySetPair(obj, obj2, obj3);
            case 161:
                return yailDictionaryLookup(obj, obj2, obj3);
            case 162:
                return yailDictionaryRecursiveLookup(obj, obj2, obj3);
            case 164:
                return yailDictionaryRecursiveSet(obj, obj2, obj3);
            case 185:
                return stringSubstring(obj, obj2, obj3);
            case 187:
                return stringReplaceAll(obj, obj2, obj3);
            default:
                return super.apply3(moduleMethod, obj, obj2, obj3);
        }
    }

    public static Object isStringEmpty(Object text) {
        try {
            return strings.stringLength((CharSequence) text) == 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (ClassCastException e) {
            throw new WrongType(e, "string-length", 1, text);
        }
    }

    public static Object textDeobfuscate(Object text, Object confounder) {
        frame4 frame4Var = new frame4();
        frame4Var.text = text;
        frame4Var.lc = confounder;
        ModuleMethod moduleMethod = frame4Var.cont$Fn12;
        CallCC.callcc.apply1(frame4Var.cont$Fn12);
        Object obj = Lit22;
        LList lList = LList.Empty;
        Object obj2 = frame4Var.text;
        try {
            Integer valueOf = Integer.valueOf(strings.stringLength((CharSequence) obj2));
            while (true) {
                NumberCompare numberCompare = Scheme.numGEq;
                Object obj3 = frame4Var.text;
                try {
                    if (numberCompare.apply2(obj, Integer.valueOf(strings.stringLength((CharSequence) obj3))) == Boolean.FALSE) {
                        Object obj4 = frame4Var.text;
                        try {
                            try {
                                int c = Char.make(strings.stringRef((CharSequence) obj4, ((Number) obj).intValue())).intValue();
                                Object b3 = BitwiseOp.and.apply2(BitwiseOp.ior.apply2(BitwiseOp.ashiftl.apply2(BitwiseOp.and.apply2(BitwiseOp.xor.apply2(Integer.valueOf(c >> 8), obj), Lit41), Lit42), BitwiseOp.and.apply2(BitwiseOp.xor.apply2(Integer.valueOf(c), AddOp.$Mn.apply2(valueOf, obj)), Lit41)), Lit41);
                                BitwiseOp bitwiseOp = BitwiseOp.and;
                                BitwiseOp bitwiseOp2 = BitwiseOp.xor;
                                Object obj5 = frame4Var.lc;
                                try {
                                    try {
                                        Pair acc = lists.cons(bitwiseOp.apply2(bitwiseOp2.apply2(b3, Integer.valueOf(Char.make(strings.stringRef((CharSequence) obj5, ((Number) obj).intValue())).intValue())), Lit41), lList);
                                        obj = AddOp.$Pl.apply2(Lit21, obj);
                                        lList = acc;
                                    } catch (ClassCastException e) {
                                        throw new WrongType(e, "string-ref", 2, obj);
                                    }
                                } catch (ClassCastException e2) {
                                    throw new WrongType(e2, "string-ref", 1, obj5);
                                }
                            } catch (ClassCastException e3) {
                                throw new WrongType(e3, "string-ref", 2, obj);
                            }
                        } catch (ClassCastException e4) {
                            throw new WrongType(e4, "string-ref", 1, obj4);
                        }
                    } else {
                        try {
                            break;
                        } catch (ClassCastException e5) {
                            throw new WrongType(e5, "reverse", 1, lList);
                        }
                    }
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "string-length", 1, obj3);
                }
            }
            LList reverse = lists.reverse(lList);
            Object obj6 = LList.Empty;
            while (reverse != LList.Empty) {
                try {
                    Pair arg0 = (Pair) reverse;
                    Object arg02 = arg0.getCdr();
                    Object car = arg0.getCar();
                    try {
                        obj6 = Pair.make(Char.make(((Number) car).intValue()), obj6);
                        reverse = arg02;
                    } catch (ClassCastException e7) {
                        throw new WrongType(e7, "integer->char", 1, car);
                    }
                } catch (ClassCastException e8) {
                    throw new WrongType(e8, "arg0", -2, reverse);
                }
            }
            return strings.list$To$String(LList.reverseInPlace(obj6));
        } catch (ClassCastException e9) {
            throw new WrongType(e9, "string-length", 1, obj2);
        }
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame4 extends ModuleBody {
        final ModuleMethod cont$Fn12 = new ModuleMethod(this, 9, runtime.Lit43, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        Object lc;
        Object text;

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            return moduleMethod.selector == 9 ? lambda14cont(obj) : super.apply1(moduleMethod, obj);
        }

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            if (moduleMethod.selector != 9) {
                return super.match1(moduleMethod, obj, callContext);
            }
            callContext.value1 = obj;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }

        public Object lambda14cont(Object $Styail$Mnbreak$St) {
            while (true) {
                Object obj = this.lc;
                try {
                    int stringLength = strings.stringLength((CharSequence) obj);
                    Object obj2 = this.text;
                    try {
                        if (stringLength >= strings.stringLength((CharSequence) obj2)) {
                            return null;
                        }
                        this.lc = strings.stringAppend(this.lc, this.lc);
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "string-length", 1, obj2);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "string-length", 1, obj);
                }
            }
        }
    }

    public static String stringReplaceMappingsDictionary(Object text, Object mappings) {
        try {
            return JavaStringUtils.replaceAllMappingsDictionaryOrder(text == null ? null : text.toString(), (Map) mappings);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.JavaStringUtils.replaceAllMappingsDictionaryOrder(java.lang.String,java.util.Map)", 2, mappings);
        }
    }

    public static String stringReplaceMappingsLongestString(Object text, Object mappings) {
        try {
            return JavaStringUtils.replaceAllMappingsLongestStringOrder(text == null ? null : text.toString(), (Map) mappings);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.JavaStringUtils.replaceAllMappingsLongestStringOrder(java.lang.String,java.util.Map)", 2, mappings);
        }
    }

    public static String stringReplaceMappingsEarliestOccurrence(Object text, Object mappings) {
        try {
            return JavaStringUtils.replaceAllMappingsEarliestOccurrenceOrder(text == null ? null : text.toString(), (Map) mappings);
        } catch (ClassCastException e) {
            throw new WrongType(e, "com.google.appinventor.components.runtime.util.JavaStringUtils.replaceAllMappingsEarliestOccurrenceOrder(java.lang.String,java.util.Map)", 2, mappings);
        }
    }

    public static Number makeExactYailInteger(Object x) {
        Object coerceToNumber = coerceToNumber(x);
        try {
            return numbers.exact(numbers.round(LangObjType.coerceRealNum(coerceToNumber)));
        } catch (ClassCastException e) {
            throw new WrongType(e, "round", 1, coerceToNumber);
        }
    }

    public static Object makeColor(Object color$Mncomponents) {
        Number alpha;
        Number red = makeExactYailInteger(yailListGetItem(color$Mncomponents, Lit21));
        Number green = makeExactYailInteger(yailListGetItem(color$Mncomponents, Lit23));
        Number blue = makeExactYailInteger(yailListGetItem(color$Mncomponents, Lit46));
        if (yailListLength(color$Mncomponents) > 3) {
            alpha = makeExactYailInteger(yailListGetItem(color$Mncomponents, Lit47));
        } else {
            Object obj = $Stalpha$Mnopaque$St;
            try {
                alpha = (Number) obj;
            } catch (ClassCastException e) {
                throw new WrongType(e, "alpha", -2, obj);
            }
        }
        return BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ashiftl.apply2(BitwiseOp.and.apply2(alpha, $Stmax$Mncolor$Mncomponent$St), $Stcolor$Mnalpha$Mnposition$St), BitwiseOp.ashiftl.apply2(BitwiseOp.and.apply2(red, $Stmax$Mncolor$Mncomponent$St), $Stcolor$Mnred$Mnposition$St)), BitwiseOp.ashiftl.apply2(BitwiseOp.and.apply2(green, $Stmax$Mncolor$Mncomponent$St), $Stcolor$Mngreen$Mnposition$St)), BitwiseOp.ashiftl.apply2(BitwiseOp.and.apply2(blue, $Stmax$Mncolor$Mncomponent$St), $Stcolor$Mnblue$Mnposition$St));
    }

    public static Object splitColor(Object color) {
        Number intcolor = makeExactYailInteger(color);
        return kawaList$To$YailList(LList.list4(BitwiseOp.and.apply2(BitwiseOp.ashiftr.apply2(intcolor, $Stcolor$Mnred$Mnposition$St), $Stmax$Mncolor$Mncomponent$St), BitwiseOp.and.apply2(BitwiseOp.ashiftr.apply2(intcolor, $Stcolor$Mngreen$Mnposition$St), $Stmax$Mncolor$Mncomponent$St), BitwiseOp.and.apply2(BitwiseOp.ashiftr.apply2(intcolor, $Stcolor$Mnblue$Mnposition$St), $Stmax$Mncolor$Mncomponent$St), BitwiseOp.and.apply2(BitwiseOp.ashiftr.apply2(intcolor, $Stcolor$Mnalpha$Mnposition$St), $Stmax$Mncolor$Mncomponent$St)));
    }

    public static void closeScreen() {
        Form.finishActivity();
    }

    public static void closeApplication() {
        Form.finishApplication();
    }

    public static void openAnotherScreen(Object screen$Mnname) {
        Object coerceToString = coerceToString(screen$Mnname);
        Form.switchForm(coerceToString == null ? null : coerceToString.toString());
    }

    public static void openAnotherScreenWithStartValue(Object screen$Mnname, Object start$Mnvalue) {
        Object coerceToString = coerceToString(screen$Mnname);
        Form.switchFormWithStartValue(coerceToString == null ? null : coerceToString.toString(), start$Mnvalue);
    }

    public static Object getStartValue() {
        return sanitizeComponentData(Form.getStartValue());
    }

    public static void closeScreenWithValue(Object result) {
        Form.finishActivityWithResult(result);
    }

    public static String getPlainStartText() {
        return Form.getStartText();
    }

    public static void closeScreenWithPlainText(Object string) {
        Form.finishActivityWithTextResult(string == null ? null : string.toString());
    }

    public static String getServerAddressFromWifi() {
        Object slotValue = SlotGet.getSlotValue(false, Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(((Context) $Stthis$Mnform$St).getSystemService(Context.WIFI_SERVICE), Lit49)), "ipAddress", "ipAddress", "getIpAddress", "isIpAddress", Scheme.instance);
        try {
            return Formatter.formatIpAddress(((Number) slotValue).intValue());
        } catch (ClassCastException e) {
            throw new WrongType(e, "android.text.format.Formatter.formatIpAddress(int)", 1, slotValue);
        }
    }

    public static Object inUi(Object blockid, Object promise) {
        frame5 frame5Var = new frame5();
        frame5Var.blockid = blockid;
        frame5Var.promise = promise;
        $Stthis$Mnis$Mnthe$Mnrepl$St = Boolean.TRUE;
        return Scheme.applyToArgs.apply2(GetNamedPart.getNamedPart.apply2($Stui$Mnhandler$St, Lit50), thread.runnable(frame5Var.lambda$Fn13));
    }

    /* compiled from: runtime4407023393941543797.scm */
    /* loaded from: classes.dex */
    public class frame5 extends ModuleBody {
        Object blockid;
        final ModuleMethod lambda$Fn13;
        Object promise;

        public frame5() {
            ModuleMethod moduleMethod = new ModuleMethod(this, 10, null, 0);
            moduleMethod.setProperty("source-location", "/tmp/runtime4407023393941543797.scm:2937");
            this.lambda$Fn13 = moduleMethod;
        }

        @Override // gnu.expr.ModuleBody
        public Object apply0(ModuleMethod moduleMethod) {
            return moduleMethod.selector == 10 ? lambda15() : super.apply0(moduleMethod);
        }

        Object lambda15() {
            Pair list2;
            Object obj;
            try {
                obj = this.blockid;
                try {
                    list2 = LList.list2("OK", runtime.getDisplayRepresentation(misc.force(this.promise)));
                } catch (PermissionException exception) {
                    exception.printStackTrace();
                    list2 = LList.list2("NOK", strings.stringAppend("Failed due to missing permission: ", exception.getPermissionNeeded()));
                } catch (YailRuntimeError exception2) {
                    runtime.androidLog(exception2.getMessage());
                    list2 = LList.list2("NOK", exception2.getMessage());
                }
            } catch (Throwable exception3) {
                runtime.androidLog(exception3.getMessage());
                exception3.printStackTrace();
                list2 = LList.list2("NOK", exception3 instanceof Error ? exception3.toString() : exception3.getMessage());
            }
            return runtime.sendToBlock(obj, list2);
        }

        @Override // gnu.expr.ModuleBody
        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            if (moduleMethod.selector != 10) {
                return super.match0(moduleMethod, callContext);
            }
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
    }

    public static Object sendToBlock(Object blockid, Object message) {
        String str = null;
        Object good = lists.car.apply1(message);
        Object value = lists.cadr.apply1(message);
        String obj = blockid == null ? null : blockid.toString();
        String obj2 = good == null ? null : good.toString();
        if (value != null) {
            str = value.toString();
        }
        RetValManager.appendReturnValue(obj, obj2, str);
        return Values.empty;
    }

    public static Object clearCurrentForm() {
        if ($Stthis$Mnform$St == null) {
            return Values.empty;
        }
        clearInitThunks();
        resetCurrentFormEnvironment();
        EventDispatcher.unregisterAllEventsForDelegation();
        return Invoke.invoke.apply2($Stthis$Mnform$St, "clear");
    }

    public static Object setFormName(Object form$Mnname) {
        return Invoke.invoke.apply3($Stthis$Mnform$St, "setFormName", form$Mnname);
    }

    public static Object removeComponent(Object component$Mnname) {
        try {
            SimpleSymbol component$Mnsymbol = misc.string$To$Symbol((CharSequence) component$Mnname);
            Object component$Mnobject = lookupInCurrentFormEnvironment(component$Mnsymbol);
            deleteFromCurrentFormEnvironment(component$Mnsymbol);
            return $Stthis$Mnform$St != null ? Invoke.invoke.apply3($Stthis$Mnform$St, "deleteComponent", component$Mnobject) : Values.empty;
        } catch (ClassCastException e) {
            throw new WrongType(e, "string->symbol", 1, component$Mnname);
        }
    }

    public static Object renameComponent(Object old$Mncomponent$Mnname, Object new$Mncomponent$Mnname) {
        try {
            try {
                return renameInCurrentFormEnvironment(misc.string$To$Symbol((CharSequence) old$Mncomponent$Mnname), misc.string$To$Symbol((CharSequence) new$Mncomponent$Mnname));
            } catch (ClassCastException e) {
                throw new WrongType(e, "string->symbol", 1, new$Mncomponent$Mnname);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "string->symbol", 1, old$Mncomponent$Mnname);
        }
    }

    @Override // gnu.expr.ModuleBody
    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        switch (moduleMethod.selector) {
            case 15:
                return addInitThunk(obj, obj2);
            case 20:
                return getProperty$1(obj, obj2);
            case 29:
                try {
                    return addToCurrentFormEnvironment((Symbol) obj, obj2);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "add-to-current-form-environment", 1, obj);
                }
            case 30:
                try {
                    return lookupInCurrentFormEnvironment((Symbol) obj, obj2);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "lookup-in-current-form-environment", 1, obj);
                }
            case 33:
                try {
                    try {
                        return renameInCurrentFormEnvironment((Symbol) obj, (Symbol) obj2);
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "rename-in-current-form-environment", 2, obj2);
                    }
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "rename-in-current-form-environment", 1, obj);
                }
            case 34:
                try {
                    return addGlobalVarToCurrentFormEnvironment((Symbol) obj, obj2);
                } catch (ClassCastException e5) {
                    throw new WrongType(e5, "add-global-var-to-current-form-environment", 1, obj);
                }
            case 35:
                try {
                    return lookupGlobalVarInCurrentFormEnvironment((Symbol) obj, obj2);
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "lookup-global-var-in-current-form-environment", 1, obj);
                }
            case 50:
                return signalRuntimeError(obj, obj2);
            case 56:
                return generateRuntimeTypeError(obj, obj2);
            case 59:
                return coerceArg(obj, obj2);
            case 63:
                return coerceToComponentOfType(obj, obj2);
            case 71:
                return joinStrings(obj, obj2);
            case 72:
                return stringReplace(obj, obj2);
            case 83:
                return isYailEqual(obj, obj2);
            case 84:
                return isYailAtomicEqual(obj, obj2);
            case 86:
                return isYailNotEqual(obj, obj2) ? Boolean.TRUE : Boolean.FALSE;
            case 94:
                return randomInteger(obj, obj2);
            case 96:
                return yailDivide(obj, obj2);
            case 107:
                return atan2Degrees(obj, obj2);
            case 112:
                return formatAsDecimal(obj, obj2);
            case 127:
                setYailListContents$Ex(obj, obj2);
                return Values.empty;
            case 141:
                return yailListIndex(obj, obj2);
            case 142:
                return yailListGetItem(obj, obj2);
            case 144:
                yailListRemoveItem$Ex(obj, obj2);
                return Values.empty;
            case 146:
                yailListAppend$Ex(obj, obj2);
                return Values.empty;
            case 148:
                return isYailListMember(obj, obj2);
            case 150:
                return yailForEach(obj, obj2);
            case 153:
                return yailNumberRange(obj, obj2);
            case 156:
                return yailListJoinWithSeparator(obj, obj2);
            case 158:
                return makeDictionaryPair(obj, obj2);
            case ComponentConstants.TEXTBOX_PREFERRED_WIDTH /* 160 */:
                return yailDictionaryDeletePair(obj, obj2);
            case 163:
                return yailDictionaryWalk(obj, obj2);
            case 167:
                return yailDictionaryIsKeyIn(obj, obj2) ? Boolean.TRUE : Boolean.FALSE;
            case 172:
                yailDictionaryCombineDicts(obj, obj2);
                return Values.empty;
            case 176:
                return Integer.valueOf(stringStartsAt(obj, obj2));
            case 177:
                return stringContains(obj, obj2);
            case 178:
                return stringContainsAny(obj, obj2);
            case 179:
                return stringContainsAll(obj, obj2);
            case 180:
                return stringSplitAtFirst(obj, obj2);
            case 181:
                return stringSplitAtFirstOfAny(obj, obj2);
            case 182:
                return stringSplit(obj, obj2);
            case 183:
                return stringSplitAtAny(obj, obj2);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG /* 189 */:
                return textDeobfuscate(obj, obj2);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK /* 190 */:
                return stringReplaceMappingsDictionary(obj, obj2);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY /* 191 */:
                return stringReplaceMappingsLongestString(obj, obj2);
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE /* 192 */:
                return stringReplaceMappingsEarliestOccurrence(obj, obj2);
            case 199:
                openAnotherScreenWithStartValue(obj, obj2);
                return Values.empty;
            case 205:
                return inUi(obj, obj2);
            case 206:
                return sendToBlock(obj, obj2);
            case 210:
                return renameComponent(obj, obj2);
            default:
                return super.apply2(moduleMethod, obj, obj2);
        }
    }

    public static void initRuntime() {
        setThisForm();
        $Stui$Mnhandler$St = new Handler();
    }

    public static void setThisForm() {
        $Stthis$Mnform$St = Form.getActiveForm();
    }

    @Override // gnu.expr.ModuleBody
    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 17:
                clearInitThunks();
                return Values.empty;
            case 37:
                resetCurrentFormEnvironment();
                return Values.empty;
            case 93:
                return Double.valueOf(randomFraction());
            case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_DURATION /* 196 */:
                closeScreen();
                return Values.empty;
            case 197:
                closeApplication();
                return Values.empty;
            case HttpRequestContext.HTTP_OK /* 200 */:
                return getStartValue();
            case ErrorMessages.ERROR_NO_CAMERA_PERMISSION /* 202 */:
                return getPlainStartText();
            case 204:
                return getServerAddressFromWifi();
            case 207:
                return clearCurrentForm();
            case 211:
                initRuntime();
                return Values.empty;
            case 212:
                setThisForm();
                return Values.empty;
            default:
                return super.apply0(moduleMethod);
        }
    }

    public static Object clarify(Object sl) {
        return clarify1(yailListContents(sl));
    }

    public static Object clarify1(Object sl) {
        String sp;
        if (lists.isNull(sl)) {
            return LList.Empty;
        }
        if (IsEqual.apply(lists.car.apply1(sl), "")) {
            sp = "<empty>";
        } else {
            sp = IsEqual.apply(lists.car.apply1(sl), " ") ? "<space>" : lists.car.apply1(sl);
        }
        return lists.cons(sp, clarify1(lists.cdr.apply1(sl)));
    }
}
