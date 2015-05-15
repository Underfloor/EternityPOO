package fr.eternity.view;

import junit.framework.TestCase;

public class ControlPiecePanelTest extends TestCase {
	
	private ControlPiecePanel controlPiecePanel = new ControlPiecePanel();
	
	public void testGetPiecePanel() {
		assertEquals("class fr.eternity.view.PiecePanel", this.controlPiecePanel.getPiecePanel().getClass().toString());
	}

}