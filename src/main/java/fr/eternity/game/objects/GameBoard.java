package fr.eternity.game.objects;

import java.awt.Graphics;
import java.util.ArrayList;


public class GameBoard {
	private Piece[][] puzzle;
	private ArrayList<Piece> deck;

	public GameBoard(ArrayList<Piece> deck, int size) {
		this.deck = deck;
		this.puzzle = new Piece[size][size];
	}

	public GameBoard(int size) {
		this.deck = new ArrayList<Piece>();
		this.puzzle = new Piece[size][size];
	}

	public void setPiece(int x, int y, Piece piece) {
		this.puzzle[x][y] = piece;
	}

	public void drawGameBoard(Graphics g) {
		for (int i = 0; i < this.puzzle.length; i++) {
			for (int j = 0; j < this.puzzle.length; j++) {
				if (this.puzzle[i][j] != null) {
					this.puzzle[i][j].drawPiece(g, i, j);
				}
			}
		}
	}

	public Piece getPiece(int x, int y) {
		return this.puzzle[x][y];
	}
}
