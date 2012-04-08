/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public class Insert implements ICommand
{

    protected Buffer buffer;
    protected AbstractUI ui;
    @Override
    
    
    public void execute()
    {
        buffer.saveInMemento();
        buffer.insert(ui.getContent());
    }

    public Insert(Buffer buffer, AbstractUI ui)
    {
        this.buffer = buffer;
        this.ui = ui;
    }

    @Override
    public void setBuffer(Buffer buffer)
    {
        this.buffer = buffer;
    }
    
}
