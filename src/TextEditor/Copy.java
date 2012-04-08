/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public class Copy implements ICommand
{

    protected Buffer buffer;
    protected AbstractUI ui;

    @Override
    public void execute()
    {
        buffer.copy(ui.ClipBoard);
    }

    public void setBuffer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    public Copy(Buffer buffer, AbstractUI ui)
    {
        this.buffer = buffer;
        this.ui = ui;
    }
    
    
}
