package fr.eternity.game.objects;

import java.util.ArrayList;

import junit.framework.TestCase;

public class GameBoardTest extends TestCase {

	public void testSetPiece() {
		GameBoard gameboard = new GameBoard(5);
		
		Piece p1 = new Piece();
		Piece p2 = new Piece();
		Piece p3 = new Piece();
		
		gameboard.setPiece(1, 2, p1);
		gameboard.setPiece(0, 0, p2);
		gameboard.setPiece(3, 2, p3);
		
		assertEquals(p1, gameboard.getPiece(1,2));
		assertEquals(p2, gameboard.getPiece(0,0));
		assertEquals(p3, gameboard.getPiece(3,2));
	}

	public void testDrawGameBoard() {
		fail("Not yet implemented");
	}

	public void testGetPiece() {
		fail("Not yet implemented");
	}

}
