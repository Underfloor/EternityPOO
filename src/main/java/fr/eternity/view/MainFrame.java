package fr.eternity.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.eternity.controller.MainFrameController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public MainFrame() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mainMenu = new JMenu("Menu");
		menuBar.add(mainMenu);
		
		JMenuItem playMenuItem = new JMenuItem("Jouer");
		mainMenu.add(playMenuItem);
		
		JMenuItem editMenuItem = new JMenuItem("Editer");
		mainMenu.add(editMenuItem);
		
		JMenu playMenu = new JMenu("Jeu");
		menuBar.add(playMenu);
		
		JMenuItem newMenuItem = new JMenuItem("Nouvelle partie");
		playMenu.add(newMenuItem);
		
		JMenuItem loadMenuItem = new JMenuItem("Charger partie");
		playMenu.add(loadMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Sauvegarder partie");
		playMenu.add(saveMenuItem);
		
		new MainFrameController(this, playMenuItem, editMenuItem, newMenuItem, loadMenuItem, saveMenuItem, playMenu);
	}
	
	public void draw() {
        Graphics g = this.getGraphics();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/Images/eternity.png"));        
        g.drawImage(image.getImage(), 8, 55, null);
	}
	
}
