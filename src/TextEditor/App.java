package TextEditor;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GV
 */
public class App
{
    protected AbstractUI aui;
    protected Buffer buffer;
    public App()
    {
        
        buffer= new Buffer();
        aui = new AbstractUI();
        
        GUI gui = new GUI();
        GUI gui2 = new GUI();
        GUI gui3 = new GUI();
        
        gui.setUi( aui );
        gui2.setUi( aui );
        gui3.setUi( aui );
        
        buffer.addSubject( gui );
        buffer.addSubject( gui2 );
        buffer.addSubject( gui3 );
        
        ICommand backspace = new BackSpace(buffer,aui);
        ICommand copy = new Copy(buffer,aui);
        ICommand insert = new Insert(buffer,aui);
        ICommand paste = new Paste(buffer,aui);
        
        aui.setBackspace( backspace );
        aui.setCopy( copy );
        aui.setInsert( insert );
        aui.setPaste( paste );
        aui.setBuffer( buffer );
    }

    public static void main(String[] args)
    {
        try
        {
            // Set System L&F
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        }
        catch ( UnsupportedLookAndFeelException e )
        {
            // handle exception
        }
        catch ( ClassNotFoundException e )
        {
            // handle exception
        }
        catch ( InstantiationException e )
        {
            // handle exception
        }
        catch ( IllegalAccessException e )
        {
            // handle exception
        }
        App app = new App();

    }
}
