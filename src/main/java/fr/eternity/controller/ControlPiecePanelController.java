package fr.eternity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.eternity.view.PiecePanel;

public class ControlPiecePanelController implements ActionListener {
	
	private JButton rotateLeft;
	private JButton rotateRight;
	
	private PiecePanel piecePanel;
	
	public ControlPiecePanelController(
			JButton rotateLeft,
			JButton rotateRight,
			PiecePanel piecePanel
			) {
		this.rotateLeft = rotateLeft;
		this.rotateRight = rotateRight;
		this.piecePanel = piecePanel;

		this.rotateLeft.addActionListener(this);
		this.rotateRight.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == this.rotateLeft) {
			if (this.piecePanel.getPieceToCreate() != null) {
				this.piecePanel.getPieceToCreate().rotateToLeft();
				this.piecePanel.paint(this.piecePanel.getGraphics());
			}
		} else if (actionEvent.getSource() == this.rotateRight) {
			if (this.piecePanel.getPieceToCreate() != null) {
				this.piecePanel.getPieceToCreate().rotateToRight();
				this.piecePanel.paint(this.piecePanel.getGraphics());
			}
		}
	}

}
