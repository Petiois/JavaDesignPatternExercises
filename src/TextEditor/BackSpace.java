/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public class BackSpace implements ICommand
{

    protected IBuffer buffer;
    protected IUI ui;

    public BackSpace(Buffer buffer, AbstractUI ui)
    {
        this.buffer = buffer;
        this.ui = ui;
    }

    
    
    @Override
    public void execute()
    {
        buffer.backspace();
    }

    @Override
    public void setBuffer(Buffer buffer)
    {
        this.buffer = buffer;
    }
}
