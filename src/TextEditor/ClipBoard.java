/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.util.ArrayList;

/**
 *
 * @author GV
 */
public class ClipBoard
{
    protected String ClipBoard = "";

    public ClipBoard(String ClipBoard) {
        this.ClipBoard = ClipBoard;
    }

    public ArrayList<String> getClipBoard() {
        ArrayList<String> tempo = new ArrayList<String>();
        if (ClipBoard != null) {
            for (int i = 0; i < ClipBoard.length(); i++) {
                tempo.add("" + ClipBoard.charAt(i));
            }
        }
        return tempo;
    }

    public void setClipBoard(String ClipBoard) {
        this.ClipBoard = ClipBoard;
    }
    
}
