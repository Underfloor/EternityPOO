package fr.eternity.game.objects;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

	public void testAddSide() throws Exception {
		Side[] listeSide = {Side.BORDERSIDE, Side.BLUESIDE,Side.KHAKISIDE
				,Side.GREENSIDE};
		Piece expectedPiece = new Piece(listeSide);
		
		Piece actualPiece = new Piece();
		actualPiece.addSide(Side.BORDERSIDE);
		actualPiece.addSide(Side.BLUESIDE);
		actualPiece.addSide(Side.KHAKISIDE);
		actualPiece.addSide(Side.GREENSIDE);
		
		assertEquals(expectedPiece.getSide(0), actualPiece.getSide(0));
		assertEquals(expectedPiece.getSide(1), actualPiece.getSide(1));
		assertEquals(expectedPiece.getSide(2), actualPiece.getSide(2));
		assertEquals(expectedPiece.getSide(3), actualPiece.getSide(3));		
	}

	public void testSetRightSide() throws Exception {
		Side[] sidesList = {Side.BORDERSIDE, Side.BLUESIDE,Side.KHAKISIDE
				,Side.GREENSIDE};
		Piece expectedPiece = new Piece(sidesList);
		
		sidesList[1] = Side.REDSIDE;
		Piece actualPiece = new Piece(sidesList);
		actualPiece.setRightSide(Side.BLUESIDE);
		
		assertEquals(expectedPiece.getSide(1), actualPiece.getSide(1));
	}

	public void testSetBottomSide() throws Exception {
		Side[] sidesList = {Side.BORDERSIDE, Side.BLUESIDE,Side.KHAKISIDE
				,Side.GREENSIDE};
		Piece expectedPiece = new Piece(sidesList);
		
		sidesList[2] = Side.REDSIDE;
		Piece actualPiece = new Piece(sidesList);
		actualPiece.setRightSide(Side.KHAKISIDE);
		
		assertEquals(expectedPiece.getSide(2), actualPiece.getSide(2));
	}

	public void testGetSide() throws Exception {
		Side[] sidesList = {Side.BORDERSIDE, Side.BLUESIDE,Side.KHAKISIDE
				,Side.GREENSIDE};
		Piece piece = new Piece(sidesList);
		
		assertEquals(Side.BORDERSIDE, piece.getSide(0));
		assertEquals(Side.BLUESIDE, piece.getSide(1));
		assertEquals(Side.KHAKISIDE, piece.getSide(2));
		assertEquals(Side.GREENSIDE, piece.getSide(3));
		
	}

}
