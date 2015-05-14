package fr.eternity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import fr.eternity.game.objects.GameBoard;
import fr.eternity.utils.InputOutputManager;
import fr.eternity.view.EditPiecePanel;
import fr.eternity.view.MainFrame;
import fr.eternity.view.PlayingGameAndDeckBoardPanel;
import fr.eternity.view.PlayingPanel;

public class MainFrameController implements ActionListener {

	
	
	private MainFrame mainFrame;
	
	private JMenuItem playMenuItem;
	private JMenuItem editMenuItem;
	private JMenuItem newMenuItem;
	private JMenuItem loadMenuItem;
	private JMenuItem saveMenuItem;
	
	private JMenu playMenu;
	
	private PlayingPanel playingPanel;

	public MainFrameController(
			MainFrame mainFrame,
			JMenuItem playMenuItem,
			JMenuItem editMenuItem,
			JMenuItem newMenuItem,
			JMenuItem loadMenuItem,
			JMenuItem saveMenuItem,
			JMenu playMenu) {
		this.mainFrame = mainFrame;
		this.playMenuItem = playMenuItem;
		this.editMenuItem = editMenuItem;
		this.newMenuItem = newMenuItem;
		this.loadMenuItem = loadMenuItem;
		this.saveMenuItem = saveMenuItem;
		this.playMenu = playMenu;

		this.playMenuItem.addActionListener(this);
		this.editMenuItem.addActionListener(this);
		this.newMenuItem.addActionListener(this);
		this.loadMenuItem.addActionListener(this);
		this.saveMenuItem.addActionListener(this);
		this.playMenu.setEnabled(false);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == this.playMenuItem) {
			this.playingPanel = new PlayingPanel();
			this.mainFrame.setContentPane(this.playingPanel);
			this.mainFrame.pack();
			
			this.playMenuItem.setEnabled(false);
			this.editMenuItem.setEnabled(true);
			this.playMenu.setEnabled(true);
		} else if (actionEvent.getSource() == this.editMenuItem) {
			this.mainFrame.setContentPane(new EditPiecePanel());
			this.mainFrame.pack();

			this.editMenuItem.setEnabled(false);
			this.playMenuItem.setEnabled(true);
			this.playMenu.setEnabled(false);
		} else if (actionEvent.getSource() == this.newMenuItem) {
			GameBoard gameBoard = (GameBoard) InputOutputManager.readObject(InputOutputManager.chooseFile("puzzles", false));
			
			this.playingPanel.getPlayingGameAndDeckBoardPanel().setDeck(gameBoard.getDeck());
		} else if (actionEvent.getSource() == this.loadMenuItem) {
			PlayingGameAndDeckBoardPanel playingGameAndDeckBoardPanel = (PlayingGameAndDeckBoardPanel) InputOutputManager.readObject(InputOutputManager.chooseFile("sauvegardes", false));
			
			this.playingPanel.setPlayingGameAndDeckBoardPanel(playingGameAndDeckBoardPanel);
		} else if (actionEvent.getSource() == this.saveMenuItem) {
			InputOutputManager.writeObject(this.playingPanel.getPlayingGameAndDeckBoardPanel(), InputOutputManager.chooseFile("sauvegardes", true));
		}
	}

}
