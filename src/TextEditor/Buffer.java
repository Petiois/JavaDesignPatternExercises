/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.util.ArrayList;
import java.util.LinkedList;

public class Buffer implements ISubject, IBuffer
{

    protected ArrayList<String> string = new ArrayList<String>();
    protected Selection selection;
    protected LinkedList<IObserver> ObserverList = new LinkedList<IObserver>();

    Buffer()
    {
    }

    @Override
    public void insert(String content)
    {
        string.add( content );
        this.notifySubjects();
    }

    @Override
    public void paste()
    {
        throw new UnsupportedOperationException( "Not yet implemented" );

    }

    @Override
    public void copy()
    {
        throw new UnsupportedOperationException( "Not yet implemented" );
    }

    @Override
    public void backspace()
    {
        if ( !string.isEmpty() )
        {
            string.remove( string.size() - 1 );
        }
        this.notifySubjects();
    }

    @Override
    public void addSubject(IObserver o)
    {
        ObserverList.add( o );
    }

    @Override
    public void removeSubject(IObserver o)
    {
        ObserverList.remove( o );
    }

    @Override
    public void notifySubjects()
    {
        for ( IObserver lObservateur : ObserverList )
        {
            lObservateur.update(this);
        }
    }

    String getText()
    {
        String content = "";
        for ( int i = 0; i < this.string.size(); i++ )
        {
            content = content + this.string.get( i );
        }
        return content;
    }

}
