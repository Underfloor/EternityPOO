package fr.eternity.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eternity.controller.EditPiecePanelController;
import fr.eternity.game.objects.Side;

@SuppressWarnings("serial")
public class EditPiecePanel extends JPanel {
	
	private JComboBox<Side> rightSideComboBox;
	private JComboBox<Side> bottomSideComboBox;
	
	private JButton validateButton;
	private JButton autoCompleteButton;
	private JButton saveButton;
	
	private PiecePanel piecePanel;
	
	private GameBoardPanel gameBoardPanel;
	
	/**
	 * Constructor
	 */
	public EditPiecePanel() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		this.gameBoardPanel = new GameBoardPanel(8);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 8;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(2, 2, 2, 0);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		this.add(this.gameBoardPanel, gridBagConstraints);
		
		JLabel labelRight = new JLabel("Right Side :");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(6, 2, 2, 1);
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(labelRight, gridBagConstraints);
		
		Side[] sides = Side.values();
		this.rightSideComboBox = new JComboBox<Side>(sides);
		this.rightSideComboBox.removeItem(Side.BORDERSIDE);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.insets = new Insets(6, 1, 2, 1);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		this.add(this.rightSideComboBox, gridBagConstraints);
		
		JLabel labelBottom = new JLabel("Right Bottom :");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(2, 2, 2, 1);
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(labelBottom, gridBagConstraints);
		
		this.bottomSideComboBox = new JComboBox<Side>(sides);
		this.bottomSideComboBox.removeItem(Side.BORDERSIDE);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.insets = new Insets(2, 1, 2, 1);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		this.add(this.bottomSideComboBox, gridBagConstraints);
		
		this.validateButton = new JButton("Valider");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		this.add(this.validateButton, gridBagConstraints);
		
		this.autoCompleteButton = new JButton("Complétion");
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		this.add(this.autoCompleteButton, gridBagConstraints);
		
		this.saveButton = new JButton("Enregistrer");
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		this.add(this.saveButton, gridBagConstraints);
		
		this.piecePanel = new PiecePanel();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new Insets(2, 1, 2, 2);
		this.add(this.piecePanel, gridBagConstraints);
		
		new EditPiecePanelController(this.rightSideComboBox, this.bottomSideComboBox, this.validateButton, this.autoCompleteButton, this.piecePanel, this.gameBoardPanel);
		
		this.setVisible(true);
	}
}
