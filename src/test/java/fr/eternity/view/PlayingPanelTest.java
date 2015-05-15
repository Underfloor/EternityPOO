package fr.eternity.view;

import junit.framework.TestCase;

public class PlayingPanelTest extends TestCase {
	private PlayingGameAndDeckBoardPanel pgadbp = new PlayingGameAndDeckBoardPanel();
	private PlayingPanel playingPanelToTest = new PlayingPanel();

	public void testGetPlayingGameAndDeckBoardPanel() {
		assertEquals("class fr.eternity.view.PlayingGameAndDeckBoardPanel", this.playingPanelToTest.getPlayingGameAndDeckBoardPanel().getClass().toString());
	}

	public void testSetPlayingGameAndDeckBoardPanel() {
		this.playingPanelToTest.setPlayingGameAndDeckBoardPanel(this.pgadbp);
		assertEquals(pgadbp, this.playingPanelToTest.getPlayingGameAndDeckBoardPanel());
	}
}
