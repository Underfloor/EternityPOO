package fr.eternity.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.eternity.game.objects.Piece;
import fr.eternity.game.objects.Side;
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
	
	public int[] isInPuzzle(PiecePanel piecePanel) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.puzzlePiecePanels[i][j] == piecePanel) {
					int[] retrunArray = new int[2];
					retrunArray[0] = i;
					retrunArray[1] = j;
					
					return retrunArray;
				}
			}
		}
		
		return null;
	}
	
	public void handlePuzzlePiece(PiecePanel piecePanel, int[] coordinates) {
		boolean isOk = true;
		
		Piece pieceToAdd = this.piecePanel.getPieceToCreate();
		
		if (pieceToAdd != null) {
			if (coordinates[0] == 0) {
				if (pieceToAdd.getSide(3) != Side.BORDERSIDE) {
					isOk = false;
				}
			} else {
				if (this.puzzlePiecePanels[coordinates[0] - 1][coordinates[1]].getPieceToCreate() != null && pieceToAdd.getSide(3) != this.puzzlePiecePanels[coordinates[0] - 1][coordinates[1]].getPieceToCreate().getSide(1)) {
					isOk = false;
				}
			}
			
			if (isOk && coordinates[0] == 3) {
				if (pieceToAdd.getSide(1) != Side.BORDERSIDE) {
					isOk = false;
				}
			} else if (isOk) {
				if (this.puzzlePiecePanels[coordinates[0] + 1][coordinates[1]].getPieceToCreate() != null && pieceToAdd.getSide(1) != this.puzzlePiecePanels[coordinates[0] + 1][coordinates[1]].getPieceToCreate().getSide(3)) {
					isOk = false;
				}
			}
			
			if (isOk && coordinates[1] == 0) {
				if (pieceToAdd.getSide(0) != Side.BORDERSIDE) {
					isOk = false;
				}
			} else if (isOk) {
				if (this.puzzlePiecePanels[coordinates[0]][coordinates[1] - 1].getPieceToCreate() != null && pieceToAdd.getSide(0) != this.puzzlePiecePanels[coordinates[0]][coordinates[1] - 1].getPieceToCreate().getSide(2)) {
					isOk = false;
				}
			}
			
			if (isOk && coordinates[1] == 3) {
				if (pieceToAdd.getSide(2) != Side.BORDERSIDE) {
					isOk = false;
				}
			} else  if (isOk) {
				if (this.puzzlePiecePanels[coordinates[0]][coordinates[1] + 1].getPieceToCreate() != null && pieceToAdd.getSide(2) != this.puzzlePiecePanels[coordinates[0]][coordinates[1] + 1].getPieceToCreate().getSide(0)) {
					isOk = false;
				}
			}
		}
		
		if (isOk) {
			Piece stock = piecePanel.getPieceToCreate();
			piecePanel.setPieceToCreate(this.piecePanel.getPieceToCreate());
			this.piecePanel.setPieceToCreate(stock);
			
			this.piecePanel.paint(this.piecePanel.getGraphics());
			piecePanel.paint(piecePanel.getGraphics());
		}
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		PiecePanel source = (PiecePanel) mouseEvent.getSource();
		int[] coordinates = this.isInPuzzle(source);
		
		if (coordinates != null) {
			this.handlePuzzlePiece(source, coordinates);
		} else {
			Piece stock = source.getPieceToCreate();
			source.setPieceToCreate(this.piecePanel.getPieceToCreate());
			this.piecePanel.setPieceToCreate(stock);
			
			this.piecePanel.paint(this.piecePanel.getGraphics());
			source.paint(source.getGraphics());
		}
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
