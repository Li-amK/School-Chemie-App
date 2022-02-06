package gnu.kawa.swingviews;

import javax.swing.text.BadLocationException;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingContent.java */
/* loaded from: classes.dex */
public class GapUndoableEdit extends AbstractUndoableEdit {
    SwingContent content;
    String data;
    boolean isInsertion;
    int nitems;
    int startOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GapUndoableEdit(int offset) {
        this.startOffset = offset;
    }

    private void doit(boolean isInsertion) throws BadLocationException {
        if (isInsertion) {
            this.content.insertString(this.startOffset, this.data);
        } else {
            this.content.remove(this.startOffset, this.nitems);
        }
    }

    public void undo() throws CannotUndoException {
        GapUndoableEdit.super.undo();
        try {
            doit(!this.isInsertion);
        } catch (BadLocationException e) {
            throw new CannotUndoException();
        }
    }

    public void redo() throws CannotUndoException {
        GapUndoableEdit.super.redo();
        try {
            doit(this.isInsertion);
        } catch (BadLocationException e) {
            throw new CannotRedoException();
        }
    }
}
