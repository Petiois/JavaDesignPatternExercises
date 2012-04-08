/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public interface IMemento
{
    public void restoreFromMomento(Memento pMemento);
    public void saveInMemento();
}
