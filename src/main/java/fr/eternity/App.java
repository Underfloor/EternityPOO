package fr.eternity;

import javax.swing.JFrame;

import fr.eternity.view.EditPiecePanel;
import fr.eternity.view.PlayingPanel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EditPiecePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        JFrame frame2 = new JFrame("playing");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(new PlayingPanel());
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}
