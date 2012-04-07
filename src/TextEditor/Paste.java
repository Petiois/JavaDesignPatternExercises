/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public class Paste implements ICommand
{

    protected Buffer buffer;
    protected AbstractUI ui;

    public Paste(Buffer buffer, AbstractUI ui)
    {
        this.buffer = buffer;
        this.ui = ui;
    }
    
    @Override
    public void execute()
    {
        buffer.paste();
    }

    @Override
    public void setBuffer(Buffer buffer)
    {
        this.buffer = buffer;
    }
}
