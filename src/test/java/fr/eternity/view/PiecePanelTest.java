package fr.eternity.view;

import junit.framework.TestCase;
import fr.eternity.game.objects.Side;

public class PiecePanelTest extends TestCase {

	private PiecePanel testPiecePanel = new PiecePanel();

	public void testGetPieceToCreate() {
		assertEquals("class fr.eternity.game.objects.Piece", this.testPiecePanel.getPieceToCreate().getClass().toString());
	}

	public void testResetPieceToCreate() throws Exception {
		Side[] sidesToTest = {Side.GREENSIDE,Side.KHAKISIDE,Side.ORANGESIDE,Side.PINKSIDE};
		testPiecePanel.resetPieceToCreate(sidesToTest[0], sidesToTest[1], sidesToTest[2], sidesToTest[3]);
		
		Side[] sidesToTest2 = {Side.PURPLESIDE,Side.REDSIDE,Side.TURQUOISESIDE,Side.BLUESIDE};
		testPiecePanel.resetPieceToCreate(sidesToTest2[0], sidesToTest2[1], sidesToTest2[2], sidesToTest2[3]);
		
		for(int i = 0 ; i < 4 ; i++) {
			assertTrue(testPiecePanel.getPieceToCreate().getSide(i) != sidesToTest[i]);
		}
	}
}
