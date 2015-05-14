package fr.eternity.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.eternity.game.objects.Piece;
import fr.eternity.view.PiecePanel;

public class PlayingPanelControl implements MouseListener {

	private PiecePanel[][] puzzlePiecePanels;
	private PiecePanel[][] deckPiecePanels;
	
	private PiecePanel piecePanel;

	public PlayingPanelControl(
			PiecePanel[][] puzzlePiecePanels,
			PiecePanel[][] deckPiecePanels,
			PiecePanel piecePanel) {
		this.puzzlePiecePanels = puzzlePiecePanels;
		this.deckPiecePanels = deckPiecePanels;
		this.piecePanel = piecePanel;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.puzzlePiecePanels[i][j].addMouseListener(this);
				this.deckPiecePanels[i][j].addMouseListener(this);
			}
		}
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		Piece stock = ((PiecePanel) mouseEvent.getSource()).getPieceToCreate();
		((PiecePanel) mouseEvent.getSource()).setPieceToCreate(this.piecePanel.getPieceToCreate());
		this.piecePanel.setPieceToCreate(stock);
		
		this.piecePanel.paint(this.piecePanel.getGraphics());
		((PiecePanel) mouseEvent.getSource()).paint(((PiecePanel) mouseEvent.getSource()).getGraphics());
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
