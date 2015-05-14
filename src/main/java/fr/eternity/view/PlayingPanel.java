package fr.eternity.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.eternity.controller.PlayingPanelControl;

@SuppressWarnings("serial")
public class PlayingPanel extends JPanel {
	
	private PlayingGameAndDeckBoardPanel playingGameAndDeckBoardPanel;
	
	private ControlPiecePanel controlPiecePanel;
	
	public PlayingPanel() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		this.playingGameAndDeckBoardPanel = new PlayingGameAndDeckBoardPanel();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 4;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(2, 2, 2, 0);
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(this.playingGameAndDeckBoardPanel, gridBagConstraints);
		
		this.controlPiecePanel = new ControlPiecePanel();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(2, 2, 2, 0);
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		this.add(this.controlPiecePanel, gridBagConstraints);
		
		new PlayingPanelControl(this.playingGameAndDeckBoardPanel.getPuzzlePiecePanels(), this.playingGameAndDeckBoardPanel.getDeckPiecePanels(), this.controlPiecePanel.getPiecePanel());
	}
	
	public PlayingGameAndDeckBoardPanel getPlayingGameAndDeckBoardPanel() {
		return this.playingGameAndDeckBoardPanel;
	}

	public void setPlayingGameAndDeckBoardPanel(PlayingGameAndDeckBoardPanel playingGameAndDeckBoardPanel) {
		this.playingGameAndDeckBoardPanel = playingGameAndDeckBoardPanel;
	}

}
