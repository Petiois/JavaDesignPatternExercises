/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author GV
 */
interface IBuffer
{
    void insert(String content);

    void paste();

    void copy(String clipboard);

    void backspace();

}
