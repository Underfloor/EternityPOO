package fr.eternity.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import fr.eternity.game.objects.GameBoard;
import fr.eternity.game.objects.Piece;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel {
	
	private GameBoard gameBoard;
	private int boardSize;
	
	public GameBoardPanel(int boardSize) {
		this.gameBoard = new GameBoard(boardSize);
		this.boardSize = boardSize;
		
		Dimension dimension = new Dimension(Piece.WIDTH * this.boardSize, Piece.WIDTH * this.boardSize);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setVisible(true);
	}

	public GameBoard getGameBoard() {
		return this.gameBoard;
	}
	
	public int getBoardSize() {
		return this.boardSize;
	}
	
	public void paintComponent(Graphics g) {
        this.gameBoard.drawGameBoard(g);
    }

	public Piece getPiece(int x, int y) {
		return this.gameBoard.getPiece(x, y);
	}
	
}
