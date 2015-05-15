package fr.eternity.view;

import junit.framework.TestCase;

public class PlayingGameAndDeckBoardPanelTest extends TestCase {

	private PlayingGameAndDeckBoardPanel pgadbp = new PlayingGameAndDeckBoardPanel();
	
	public void testGetPuzzlePiecePanels() {
		assertEquals(4,this.pgadbp.getPuzzlePiecePanels().length);
	}

	public void testGetDeckPiecePanels() {
		assertEquals(4,this.pgadbp.getDeckPiecePanels().length);
	}

}
