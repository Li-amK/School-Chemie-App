package kawa.lang;

import gnu.expr.Compilation;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.Vector;

/* loaded from: classes.dex */
public class SyntaxTemplate implements Externalizable {
    static final int BUILD_CONS = 1;
    static final int BUILD_DOTS = 5;
    static final int BUILD_LIST1 = 8;
    static final int BUILD_LITERAL = 4;
    static final int BUILD_MISC = 0;
    static final int BUILD_NIL = 16;
    static final int BUILD_SYNTAX = 24;
    static final int BUILD_VAR = 2;
    static final int BUILD_VAR_CAR = 3;
    static final int BUILD_VECTOR = 40;
    static final int BUILD_WIDE = 7;
    static final String dots3 = "...";
    Object[] literal_values;
    int max_nesting;
    String patternNesting;
    String template_program;

    public SyntaxTemplate() {
    }

    public SyntaxTemplate(String patternNesting, String template_program, Object[] literal_values, int max_nesting) {
        this.patternNesting = patternNesting;
        this.template_program = template_program;
        this.literal_values = literal_values;
        this.max_nesting = max_nesting;
    }

    public SyntaxTemplate(Object template, SyntaxForm syntax, Translator tr) {
        this.patternNesting = (tr == null || tr.patternScope == null) ? "" : tr.patternScope.patternNesting.toString();
        StringBuffer program = new StringBuffer();
        Vector literals_vector = new Vector();
        convert_template(template, syntax, program, 0, literals_vector, new IdentityHashMap(), false, tr);
        this.template_program = program.toString();
        this.literal_values = new Object[literals_vector.size()];
        literals_vector.copyInto(this.literal_values);
    }

    public int convert_template(Object form, SyntaxForm syntax, StringBuffer template_program, int nesting, Vector literals_vector, Object seen, boolean isVector, Translator tr) {
        int pattern_var_num;
        while (form instanceof SyntaxForm) {
            syntax = (SyntaxForm) form;
            form = syntax.getDatum();
        }
        if ((form instanceof Pair) || (form instanceof FVector)) {
            IdentityHashMap seen_map = (IdentityHashMap) seen;
            if (seen_map.containsKey(form)) {
                tr.syntaxError("self-referential (cyclic) syntax template");
                return -2;
            }
            seen_map.put(form, form);
        }
        if (form instanceof Pair) {
            Pair pair = (Pair) form;
            int ret_cdr = -2;
            int save_pc = template_program.length();
            Object car = pair.getCar();
            if (tr.matches(car, dots3)) {
                Object cdr = Translator.stripSyntax(pair.getCdr());
                if (cdr instanceof Pair) {
                    Pair cdr_pair = (Pair) cdr;
                    if (cdr_pair.getCar() == dots3 && cdr_pair.getCdr() == LList.Empty) {
                        form = dots3;
                    }
                }
            }
            int save_literals = literals_vector.size();
            template_program.append('\b');
            int num_dots3 = 0;
            Object rest = pair.getCdr();
            while (rest instanceof Pair) {
                Pair p = (Pair) rest;
                if (!tr.matches(p.getCar(), dots3)) {
                    break;
                }
                num_dots3++;
                rest = p.getCdr();
                template_program.append((char) 5);
            }
            int ret_car = convert_template(car, syntax, template_program, nesting + num_dots3, literals_vector, seen, false, tr);
            if (rest != LList.Empty) {
                template_program.setCharAt(save_pc, (char) ((((template_program.length() - save_pc) - 1) << 3) + 1));
                ret_cdr = convert_template(rest, syntax, template_program, nesting, literals_vector, seen, isVector, tr);
            }
            if (num_dots3 > 0) {
                if (ret_car < 0) {
                    tr.syntaxError("... follows template with no suitably-nested pattern variable");
                }
                int i = num_dots3;
                while (true) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                    template_program.setCharAt(save_pc + i + 1, (char) ((ret_car << 3) + 5));
                    int n = nesting + num_dots3;
                    if (n >= this.max_nesting) {
                        this.max_nesting = n;
                    }
                }
            }
            if (ret_car >= 0) {
                return ret_car;
            }
            if (ret_cdr >= 0) {
                return ret_cdr;
            }
            if (ret_car == -1 || ret_cdr == -1) {
                return -1;
            }
            if (isVector) {
                return -2;
            }
            literals_vector.setSize(save_literals);
            template_program.setLength(save_pc);
        } else if (form instanceof FVector) {
            template_program.append('(');
            return convert_template(LList.makeList((FVector) form), syntax, template_program, nesting, literals_vector, seen, true, tr);
        } else if (form == LList.Empty) {
            template_program.append((char) 16);
            return -2;
        } else if ((form instanceof Symbol) && tr != null && tr.patternScope != null && (pattern_var_num = indexOf(tr.patternScope.pattern_names, form)) >= 0) {
            int var_nesting = this.patternNesting.charAt(pattern_var_num);
            int op = (var_nesting & 1) != 0 ? 3 : 2;
            int var_nesting2 = var_nesting >> 1;
            if (var_nesting2 > nesting) {
                tr.syntaxError("inconsistent ... nesting of " + form);
            }
            template_program.append((char) ((pattern_var_num * 8) + op));
            if (var_nesting2 != nesting) {
                pattern_var_num = -1;
            }
            return pattern_var_num;
        }
        int literals_index = indexOf(literals_vector, form);
        if (literals_index < 0) {
            literals_index = literals_vector.size();
            literals_vector.addElement(form);
        }
        if (form instanceof Symbol) {
            tr.noteAccess(form, tr.currentScope());
        }
        if (!(form instanceof SyntaxForm) && form != dots3) {
            template_program.append((char) 24);
        }
        template_program.append((char) ((literals_index * 8) + 4));
        return form == dots3 ? -1 : -2;
    }

    public static int indexOf(Vector vec, Object elem) {
        int len = vec.size();
        for (int i = 0; i < len; i++) {
            if (vec.elementAt(i) == elem) {
                return i;
            }
        }
        return -1;
    }

    private int get_count(Object var, int nesting, int[] indexes) {
        for (int level = 0; level < nesting; level++) {
            var = ((Object[]) var)[indexes[level]];
        }
        return ((Object[]) var).length;
    }

    public Object execute(Object[] vars, TemplateScope templateScope) {
        return execute(0, vars, 0, new int[this.max_nesting], (Translator) Compilation.getCurrent(), templateScope);
    }

    public Object execute(Object[] vars, Translator tr, TemplateScope templateScope) {
        return execute(0, vars, 0, new int[this.max_nesting], tr, templateScope);
    }

    Object get_var(int var_num, Object[] vars, int[] indexes) {
        Object var = vars[var_num];
        if (var_num < this.patternNesting.length()) {
            int var_nesting = this.patternNesting.charAt(var_num) >> 1;
            for (int level = 0; level < var_nesting; level++) {
                var = ((Object[]) var)[indexes[level]];
            }
        }
        return var;
    }

    LList executeToList(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope) {
        int ch = this.template_program.charAt(pc);
        while ((ch & 7) == 7) {
            pc++;
            ch = ((ch - 7) << 13) | this.template_program.charAt(pc);
        }
        if ((ch & 7) == 3) {
            Pair p = (Pair) get_var(ch >> 3, vars, indexes);
            return Translator.makePair(p, p.getCar(), LList.Empty);
        } else if ((ch & 7) != 5) {
            return new Pair(execute(pc, vars, nesting, indexes, tr, templateScope), LList.Empty);
        } else {
            int count = get_count(vars[ch >> 3], nesting, indexes);
            LList result = LList.Empty;
            Pair last = null;
            int pc2 = pc + 1;
            for (int j = 0; j < count; j++) {
                indexes[nesting] = j;
                LList list = executeToList(pc2, vars, nesting + 1, indexes, tr, templateScope);
                if (last == null) {
                    result = list;
                } else {
                    last.setCdrBackdoor(list);
                }
                while (list instanceof Pair) {
                    last = (Pair) list;
                    list = (LList) last.getCdr();
                }
            }
            return result;
        }
    }

    /* JADX INFO: Multiple debug info for r15v1 java.lang.Object: [D('p' gnu.lists.Pair), D('q' gnu.lists.LList)] */
    Object execute(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope) {
        int ch = this.template_program.charAt(pc);
        while ((ch & 7) == 7) {
            pc++;
            ch = ((ch - 7) << 13) | this.template_program.charAt(pc);
        }
        if (ch == 8) {
            return executeToList(pc + 1, vars, nesting, indexes, tr, templateScope);
        }
        if (ch == 16) {
            return LList.Empty;
        }
        if (ch == 24) {
            Object v = execute(pc + 1, vars, nesting, indexes, tr, templateScope);
            return v != LList.Empty ? SyntaxForms.makeForm(v, templateScope) : v;
        } else if ((ch & 7) == 1) {
            Pair p = null;
            Object obj = null;
            do {
                int pc2 = pc + 1;
                Object executeToList = executeToList(pc2, vars, nesting, indexes, tr, templateScope);
                if (p == null) {
                    obj = executeToList;
                } else {
                    p.setCdrBackdoor(executeToList);
                }
                while (executeToList instanceof Pair) {
                    p = (Pair) executeToList;
                    executeToList = p.getCdr();
                }
                pc = pc2 + (ch >> 3);
                ch = this.template_program.charAt(pc);
            } while ((ch & 7) == 1);
            Object cdr = execute(pc, vars, nesting, indexes, tr, templateScope);
            if (p == null) {
                obj = cdr;
            } else {
                p.setCdrBackdoor(cdr);
            }
            return obj;
        } else if (ch == 40) {
            return new FVector((LList) execute(pc + 1, vars, nesting, indexes, tr, templateScope));
        } else {
            if ((ch & 7) == 4) {
                return this.literal_values[ch >> 3];
            } else if ((ch & 6) == 2) {
                Object var = get_var(ch >> 3, vars, indexes);
                if ((ch & 7) == 3) {
                    var = ((Pair) var).getCar();
                }
                return var;
            } else {
                throw new Error("unknown template code: " + ch + " at " + pc);
            }
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.patternNesting);
        out.writeObject(this.template_program);
        out.writeObject(this.literal_values);
        out.writeInt(this.max_nesting);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.patternNesting = (String) in.readObject();
        this.template_program = (String) in.readObject();
        this.literal_values = (Object[]) in.readObject();
        this.max_nesting = in.readInt();
    }
}
