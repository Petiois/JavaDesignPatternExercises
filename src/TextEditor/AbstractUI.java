/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public class AbstractUI implements IUI {

    protected ICommand backspace;
    protected ICommand copy;
    protected ICommand insert;
    protected ICommand paste;
    protected Buffer buffer;
    protected String content;
    protected String ClipBoard;


    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void invoqueBackSpace() {
        if (backspace != null) {
            backspace.execute();
        }
    }

    @Override
    public void invoqueCopy() {
        if (copy != null) {
            copy.execute();
        }
    }

    @Override
    public void invoqueInsert() {
        if (insert != null) {
            insert.execute();
        }
    }

    @Override
    public void invoquePaste() {
        if (paste != null) {
            paste.execute();
        }
    }

    @Override
    public ICommand getBackspace() {
        return backspace;
    }

    @Override
    public void setBackspace(ICommand backspace) {
        this.backspace = backspace;
    }

    @Override
    public ICommand getCopy() {
        return copy;
    }

    @Override
    public void setCopy(ICommand copy) {
        this.copy = copy;
    }

    @Override
    public ICommand getInsert() {
        return insert;
    }

    @Override
    public void setInsert(ICommand insert) {
        this.insert = insert;
    }

    @Override
    public ICommand getPaste() {
        return paste;
    }

    @Override
    public void setPaste(ICommand paste) {
        this.paste = paste;
    }

    @Override
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
        copy.setBuffer(buffer);
        paste.setBuffer(buffer);
        insert.setBuffer(buffer);
        backspace.setBuffer(buffer);
    }

    public Buffer getBuffer() {
        return buffer;
    }

}
