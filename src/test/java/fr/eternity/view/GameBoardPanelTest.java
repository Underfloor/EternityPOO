package fr.eternity.view;

import junit.framework.TestCase;
import fr.eternity.game.objects.Piece;
import fr.eternity.game.objects.Side;

public class GameBoardPanelTest extends TestCase {

	private GameBoardPanel gameBoardPanelToTest = new GameBoardPanel(8);

	public void testGetGameBoard() {
		assertEquals("class fr.eternity.game.objects.GameBoard", this.gameBoardPanelToTest.getGameBoard().getClass().toString());
	}

	public void testGetBoardSize() {
		assertEquals(8, this.gameBoardPanelToTest.getBoardSize());
	}

	public void testGetPiece() throws Exception {
		Side[] sidesToAdd = {Side.GREENSIDE,Side.KHAKISIDE,Side.ORANGESIDE,Side.PINKSIDE};
		Piece pieceToSet = new Piece(sidesToAdd);
		this.gameBoardPanelToTest.getGameBoard().setPiece(4, 2, pieceToSet);
		assertEquals(pieceToSet,this.gameBoardPanelToTest.getPiece(4, 2));
	}

}
