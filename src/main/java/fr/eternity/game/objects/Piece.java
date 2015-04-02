package fr.eternity.game.objects;

import java.awt.Graphics;

public class Piece {

	public final static int WIDTH = 64;
	public final static int TOP = 0;
	public final static int RIGHT = 1;
	public final static int BOTTOM = 2;
	public final static int LEFT = 3;

	private Side[] sides;
	private int currentSide;
	private final int maxSide = 4;
	
	public Piece() {
		this.sides = new Side[4];
		this.currentSide = 0;
	}
	
	public Piece(Side[] sides) throws Exception {
		if (sides.length == this.maxSide) {
			this.sides = sides;
		} else {
			throw new Exception("Incompatible side number. Must be 4");
		}
	}
	
	public void addSide(Side side) throws Exception {
		if (this.currentSide < this.maxSide) {
			this.sides[this.currentSide] = side;
			this.currentSide++;
		} else {
			throw new Exception("Piece is complete.");
		}
	}

	public void drawPiece(Graphics g) {
		for (int i = 0; i < this.sides.length; i++) {
			if (this.sides[i] != null) {
				this.sides[i].drawSide(g, i);
			}
		}
	}

	public void drawPiece(Graphics g, int x, int y) {
		for (int i = 0; i < this.sides.length; i++) {
			if (this.sides[i] != null) {
				this.sides[i].drawSide(g, i, x, y);
			}
		}
	}

	public void setRightSide(Side side) {
		this.sides[1] = side;
	}

	public void setBottomSide(Side side) {
		this.sides[2] = side;
	}
	
	public Side getSide(int side) {
		return this.sides[side];		
	}
	
}
