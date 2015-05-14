package fr.eternity.controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import fr.eternity.game.objects.Piece;
import fr.eternity.game.objects.Side;
import fr.eternity.utils.InputOutputManager;
import fr.eternity.view.GameBoardPanel;
import fr.eternity.view.PiecePanel;

public class EditPiecePanelController implements ActionListener {

	private JComboBox<Side> rightSideComboBox;
	private JComboBox<Side> bottomSideComboBox;

	private JButton validateButton;
	private JButton autoCompleteButton;
	private JButton saveButton;

	private PiecePanel piecePanel;

	private GameBoardPanel gameBoardPanel;

	private int currentPieceX = 0;
	private int currentPieceY = 0;

	/**
	 * Constructor
	 * 
	 * @param rightSideComboBox
	 * @param bottomSideComboBox
	 * @param validateButton
	 * @param autoCompleteButton
	 * @param piecePanel
	 * @param gameBoardPanel
	 */
	public EditPiecePanelController(
			JComboBox<Side> rightSideComboBox,
			JComboBox<Side> bottomSideComboBox,
			JButton validateButton,
			JButton autoCompleteButton,
			JButton saveButton,
			PiecePanel piecePanel,
			GameBoardPanel gameBoardPanel
			) {
		this.rightSideComboBox = rightSideComboBox;
		this.bottomSideComboBox = bottomSideComboBox;
		this.validateButton = validateButton;
		this.autoCompleteButton = autoCompleteButton;
		this.saveButton = saveButton;
		this.piecePanel = piecePanel;
		this.gameBoardPanel = gameBoardPanel;

		this.rightSideComboBox.addActionListener(this);
		this.bottomSideComboBox.addActionListener(this);
		this.validateButton.addActionListener(this);
		this.autoCompleteButton.addActionListener(this);
		this.saveButton.addActionListener(this);
	}

	/**
	 * Event handler
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == this.rightSideComboBox || actionEvent.getSource() == this.bottomSideComboBox) {
			if (actionEvent.getSource() == this.rightSideComboBox) {
				this.piecePanel.getPieceToCreate().setRightSide((Side) this.rightSideComboBox.getSelectedItem());
			} else {
				this.piecePanel.getPieceToCreate().setBottomSide((Side) this.bottomSideComboBox.getSelectedItem());
			}

			Graphics piecePanelGraphics = this.piecePanel.getGraphics();
			this.piecePanel.paint(piecePanelGraphics);
		} else if(actionEvent.getSource() == this.validateButton) {
			this.addCurrentPieceToGameBoard(false);
		} else if (actionEvent.getSource() == this.autoCompleteButton) {
			while (this.currentPieceY < this.gameBoardPanel.getBoardSize()) {
				this.addCurrentPieceToGameBoard(true);
			}
		} else if (actionEvent.getSource() == this.saveButton) {
			this.saveDeck();
		}
	}

	/**
	 * save the current deck in a file
	 */
	private void saveDeck() {
		this.gameBoardPanel.getGameBoard().cleanPuzzle();

		InputOutputManager.writeObject(this.gameBoardPanel.getGameBoard(), InputOutputManager.chooseFile("puzzles", true));

		this.gameBoardPanel.repaint();
	}

	/**
	 * Add a the currently edited piece to the gameboard
	 * 
	 * @param isAutocomplete
	 */
	private void addCurrentPieceToGameBoard(boolean isAutocomplete) {
		this.gameBoardPanel.getGameBoard().setPiece(this.currentPieceX, this.currentPieceY, this.piecePanel.getPieceToCreate());
		this.gameBoardPanel.getGameBoard().drawGameBoard(this.gameBoardPanel.getGraphics());

		this.currentPieceX++;
		if (this.currentPieceX == this.gameBoardPanel.getBoardSize()) {
			this.currentPieceX = 0;
			this.currentPieceY++;
		}

		if (this.currentPieceY == this.gameBoardPanel.getBoardSize()) {
			this.validateButton.setEnabled(false);
			this.autoCompleteButton.setEnabled(false);
			this.rightSideComboBox.setEnabled(false);
			this.bottomSideComboBox.setEnabled(false);
			this.saveButton.setEnabled(true);
		} else {
			this.gameBoardPanelResetPiece(isAutocomplete);
		}
	}

	/**
	 * Reset the piece to edit
	 * 
	 * @param isAutocomplete
	 */
	private void gameBoardPanelResetPiece(boolean isAutocomplete) {
		boolean atRight = this.currentPieceX == this.gameBoardPanel.getBoardSize() - 1;
		boolean atBottom = this.currentPieceY == this.gameBoardPanel.getBoardSize() - 1;

		Object[] possibleSides = Side.getInternalSides();
		Side topSide = this.currentPieceY == 0 ? Side.BORDERSIDE : this.gameBoardPanel.getPiece(this.currentPieceX, this.currentPieceY - 1).getSide(Piece.BOTTOM);
		Side rightSide = atRight ? Side.BORDERSIDE : (Side) possibleSides[(int) (Math.random() * possibleSides.length)];
		Side bottomSide = atBottom ? Side.BORDERSIDE : (Side) possibleSides[(int) (Math.random() * possibleSides.length)];
		Side leftSide = this.currentPieceX == 0 ? Side.BORDERSIDE : this.gameBoardPanel.getPiece(this.currentPieceX - 1, this.currentPieceY).getSide(Piece.RIGHT);
		this.piecePanel.resetPieceToCreate(topSide, rightSide, bottomSide, leftSide);

		this.piecePanel.repaint();
		if (! isAutocomplete) {
			if (atRight) {
				this.rightSideComboBox.setEnabled(false);
			} else if (! this.rightSideComboBox.isEnabled()) {
				this.rightSideComboBox.setEnabled(true);
			}

			if (atBottom) {
				this.bottomSideComboBox.setEnabled(false);
			} else if (! this.bottomSideComboBox.isEnabled()) {
				this.bottomSideComboBox.setEnabled(true);
			}
		}
	}
	
}
