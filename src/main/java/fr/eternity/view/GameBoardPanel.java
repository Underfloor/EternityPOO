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
	
	/**
	 * Constructor
	 * 
	 * @param boardSize
	 */
	public GameBoardPanel(int boardSize) {
		this.gameBoard = new GameBoard(boardSize);
		this.boardSize = boardSize;
		
		Dimension dimension = new Dimension(Piece.WIDTH * this.boardSize, Piece.WIDTH * this.boardSize);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setVisible(true);
	}

	/**
	 * Get the gameboard
	 * 
	 * @return
	 */
	public GameBoard getGameBoard() {
		return this.gameBoard;
	}
	
	/**
	 * Get the gameboard size
	 * 
	 * @return
	 */
	public int getBoardSize() {
		return this.boardSize;
	}
	
	/**
	 * Draw this component
	 */
	public void paintComponent(Graphics g) {
        this.gameBoard.drawGameBoard(g);
    }

	/**
	 * Return the piece at x, y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Piece getPiece(int x, int y) {
		return this.gameBoard.getPiece(x, y);
	}
	
}
