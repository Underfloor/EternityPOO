package fr.eternity.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.eternity.game.objects.GameBoard;
import fr.eternity.game.objects.Piece;
import fr.eternity.utils.InputOutputManager;

@SuppressWarnings("serial")
public class PlayingGameAndDeckBoardPanel extends JPanel {

	private PiecePanel[][] puzzlePiecePanels;
	private PiecePanel[][] deckPiecePanels;
	
	public PlayingGameAndDeckBoardPanel() {
		this.puzzlePiecePanels = new PiecePanel[4][4];
		this.deckPiecePanels = new PiecePanel[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.puzzlePiecePanels[i][j] = new PiecePanel(null);
				this.deckPiecePanels[i][j] = new PiecePanel(null);
			}
		}
		
		JPanel puzzlePanel = new JPanel();
		JPanel deckPanel = new JPanel();
		puzzlePanel.setBackground(Color.BLACK);
		deckPanel.setBackground(Color.DARK_GRAY);
		this.add(puzzlePanel);
		this.add(deckPanel);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout gridBagLayout = new GridBagLayout();
		puzzlePanel.setLayout(gridBagLayout);
		gridBagLayout = new GridBagLayout();
		deckPanel.setLayout(gridBagLayout);
		
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				gridBagConstraints.gridx = i;
				gridBagConstraints.gridy = j;
				puzzlePanel.add(this.puzzlePiecePanels[i][j], gridBagConstraints);
				deckPanel.add(this.deckPiecePanels[i][j], gridBagConstraints);
			}
		}
		
		GameBoard gameBoard = (GameBoard) InputOutputManager.readObject(InputOutputManager.chooseFile("puzzles", false));
		
		int x = 0;
		int y = 0;
		for (Piece piece : gameBoard.getDeck()) {
			for (int i = 0; i <= Math.floor((Math.random() * 4)); i++) {
				piece.rotateToLeft();
			}
			
			
			this.deckPiecePanels[x][y].setPieceToCreate(piece);
			x++;
			
			if (x == 4) {
				x = 0;
				y++;
			}
		}
		
		
		
		this.setVisible(true);
	}
	
	public PiecePanel[][] getPuzzlePiecePanels() {
		return this.puzzlePiecePanels;
	}
	
	public PiecePanel[][] getDeckPiecePanels() {
		return this.deckPiecePanels;
	}
	
}
