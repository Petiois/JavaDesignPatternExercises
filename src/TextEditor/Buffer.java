/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.util.ArrayList;
import java.util.LinkedList;

public class Buffer implements ISubject, IBuffer, IMemento //IPHONE
{

    protected ArrayList<String> string = new ArrayList<String>();
    protected LinkedList<IObserver> ObserverList = new LinkedList<IObserver>();
    protected ClipBoard clipBoard = new ClipBoard("");
    protected int CaretDebut = 0;
    protected int CaretFin = 0;
    protected Caretaker caretaker = new Caretaker();




    Buffer() {
    }

    @Override
    public void insert(String content) {
        string.add(content);
        this.notifySubjects();
    }

    @Override
    public void paste() {
        if (CaretFin - CaretDebut > 0) {
            this.backspace();
        }
        ArrayList<String> clipBoard1 = clipBoard.getClipBoard();
        for (int i = 0; i < clipBoard1.size(); i++) {
            string.add(CaretDebut + i, clipBoard1.get(i));
        }
        this.notifySubjects();
    }

    @Override
    public void copy(String clipboard) {
        clipBoard.setClipBoard(clipboard);
    }
    
    public void undo() {
        try {
            this.restoreFromMomento(caretaker.getLastMemento());
            //index++;
        } 
        catch (Exception e) 
        {
        }
        this.notifySubjects();
    }

    @Override
    public void backspace() {
        if (!string.isEmpty()) {
            int debut = CaretDebut;
            int fin = CaretFin;
            if (debut - fin == 0) {
                int i = 0;
                do {
                    string.remove(Math.max(0, debut - 1));
                    i++;
                } while (i < fin - debut);
            } else {
                int i = 0;
                do {
                    string.remove(Math.max(0, debut));
                    i++;
                } while (i < fin - debut);
            }
        }
        this.notifySubjects();
    }

    @Override
    public void addSubject(IObserver o) {
        ObserverList.add(o);
    }

    @Override
    public void removeSubject(IObserver o) {
        ObserverList.remove(o);
    }

    @Override
    public void notifySubjects() {
        for (IObserver lObservateur : ObserverList) {
            lObservateur.update(this);
        }
    }

    String getText() {
        String content = "";
        for (int i = 0; i < this.string.size(); i++) {
            content = content + this.string.get(i);
        }
        return content;
    }

    public ClipBoard getClipBoard() {
        return clipBoard;
    }

    public int getCaretDebut() {
        return CaretDebut;
    }

    public void setCaretDebut(int CaretDebut) {
        this.CaretDebut = CaretDebut;
    }

    public int getCaretFin() {
        return CaretFin;
    }

    public void setCaretFin(int CaretFin) {
        this.CaretFin = CaretFin;
    }

    @Override
    public void restoreFromMomento(Memento pMemento) {
        ArrayList<String>  savedState =   (ArrayList<String>)  pMemento.getSavedState();
        string = savedState;
    }

    @Override
    public void saveInMemento() {
        ArrayList<String> clone = (ArrayList<String>)string.clone();
        this.caretaker.addMemento(new Memento(clone));
    }


}
