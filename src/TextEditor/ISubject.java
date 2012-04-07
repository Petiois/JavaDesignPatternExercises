/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public interface ISubject
{

    public void addSubject(IObserver o);

    public void removeSubject(IObserver o);

    public void notifySubjects();
}
