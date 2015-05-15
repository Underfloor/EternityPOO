package fr.eternity.game.objects;

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

	public void testGetPiece() {
		GameBoard gameBoard = new GameBoard(8);
		
		Piece p1 = new Piece();
		Piece p2 = new Piece();
		Piece p3 = new Piece();
		
		gameBoard.setPiece(4, 2, p1);
		gameBoard.setPiece(3, 0, p2);
		gameBoard.setPiece(3, 2, p3);
		
		assertEquals(p1, gameBoard.getPiece(4,2));
		assertEquals(p2, gameBoard.getPiece(3,0));
		assertEquals(p3, gameBoard.getPiece(3,2));
	}

}
