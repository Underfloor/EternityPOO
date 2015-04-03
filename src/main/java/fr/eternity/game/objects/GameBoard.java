package fr.eternity.game.objects;

import java.awt.Graphics;
import java.util.ArrayList;


public class GameBoard {
	private Piece[][] puzzle;
	private ArrayList<Piece> deck;

	/**
	 * Constructor
	 * 
	 * @param deck
	 * @param size
	 */
	public GameBoard(ArrayList<Piece> deck, int size) {
		this.deck = deck;
		this.puzzle = new Piece[size][size];
	}

	/**
	 * Constructor
	 * 
	 * @param size
	 */
	public GameBoard(int size) {
		this.deck = new ArrayList<Piece>();
		this.puzzle = new Piece[size][size];
	}

	/**
	 * Set piece in the puzzle at x, y
	 * 
	 * @param x
	 * @param y
	 * @param piece
	 */
	public void setPiece(int x, int y, Piece piece) {
		this.puzzle[x][y] = piece;
	}

	/**
	 * Draw the game board
	 * 
	 * @param g
	 */
	public void drawGameBoard(Graphics g) {
		for (int i = 0; i < this.puzzle.length; i++) {
			for (int j = 0; j < this.puzzle.length; j++) {
				if (this.puzzle[i][j] != null) {
					this.puzzle[i][j].drawPiece(g, i, j);
				}
			}
		}
	}

	/**
	 * Get piece in puzzle at x, y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Piece getPiece(int x, int y) {
		return this.puzzle[x][y];
	}
}
