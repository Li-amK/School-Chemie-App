package kawa;

import gnu.kawa.models.Paintable;
import gnu.kawa.models.Viewable;
import gnu.mapping.OutPort;
import gnu.text.Path;
import java.awt.Component;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* loaded from: classes.dex */
public class ReplPaneOutPort extends OutPort {
    ReplDocument document;
    String str;
    AttributeSet style;
    TextPaneWriter tout;

    public ReplPaneOutPort(ReplDocument document, String path, AttributeSet style) {
        this(new TextPaneWriter(document, style), document, path, style);
    }

    ReplPaneOutPort(TextPaneWriter tout, ReplDocument document, String path, AttributeSet style) {
        super(tout, true, true, Path.valueOf(path));
        this.str = "";
        this.tout = tout;
        this.document = document;
        this.style = style;
    }

    public void write(String str, MutableAttributeSet style) {
        flush();
        this.document.write(str, style);
        setColumnNumber(1);
    }

    public synchronized void write(Component c) {
        MutableAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setComponent(style, c);
        write(" ", style);
    }

    @Override // gnu.mapping.OutPort, java.io.PrintWriter
    public void print(Object v) {
        if (v instanceof Component) {
            write((Component) v);
        } else if (v instanceof Paintable) {
            MutableAttributeSet style = new SimpleAttributeSet();
            style.addAttribute("$ename", ReplPane.PaintableElementName);
            style.addAttribute(ReplPane.PaintableAttribute, v);
            write(" ", style);
        } else if (v instanceof Viewable) {
            MutableAttributeSet style2 = new SimpleAttributeSet();
            style2.addAttribute("$ename", ReplPane.ViewableElementName);
            style2.addAttribute(ReplPane.ViewableAttribute, v);
            write(" ", style2);
        } else {
            super.print(v);
        }
    }
}
