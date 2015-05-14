package fr.eternity.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.eternity.controller.ControlPiecePanelController;

@SuppressWarnings("serial")
public class ControlPiecePanel extends JPanel {
	
	private JButton rotateLeft;
	private JButton rotateRight;
	
	private PiecePanel piecePanel;

	public ControlPiecePanel() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		this.rotateLeft = new JButton("Tourner à gauche");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(4, 2, 2, 2);
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(rotateLeft, gridBagConstraints);
		
		this.piecePanel = new PiecePanel(null);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		this.add(this.piecePanel, gridBagConstraints);
		
		this.rotateRight = new JButton("Tourner à droite");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(2, 2, 4, 2);
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(rotateRight, gridBagConstraints);
		
		new ControlPiecePanelController(this.rotateLeft, this.rotateRight, this.piecePanel);
		
		this.setVisible(true);
	}
	
	public PiecePanel getPiecePanel() {
		return this.piecePanel;
	}
	
}
