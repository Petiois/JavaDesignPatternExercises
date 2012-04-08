/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
public interface IUI
{


    // Méthodes pour invoquer les commandes
    public void invoqueBackSpace();

    public void invoqueCopy();

    public void invoqueInsert();

    public void invoquePaste();
    
    public void invoqueUndo();

    public ICommand getBackspace();

    public void setBackspace(ICommand backspace);

    public ICommand getCopy();

    public void setCopy(ICommand copy);

    public ICommand getInsert();

    public void setInsert(ICommand insert);

    public ICommand getPaste();

    public void setPaste(ICommand paste);
    
    public ICommand getUndo();

    public void setUndo(ICommand undo);

    public void setBuffer(Buffer buffer);
    
    public String getContent();
}
