/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public interface ICommand extends IMemento
{

    public void execute();

    public void setBuffer(Buffer buffer);
}
