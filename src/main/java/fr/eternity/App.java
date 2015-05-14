package fr.eternity;

import javax.swing.JFrame;

import fr.eternity.view.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(288, 335);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.draw();
    }
}
