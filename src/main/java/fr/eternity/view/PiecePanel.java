package fr.eternity.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.eternity.game.objects.Piece;
import fr.eternity.game.objects.Side;

@SuppressWarnings("serial")
public class PiecePanel extends JPanel {

	private static ImageIcon background = null;
	
	private Piece pieceToCreate;
	
	/**
	 * Constructor
	 */
	public PiecePanel() {
		if (PiecePanel.background == null) {
			PiecePanel.background = new ImageIcon("Images/cross.png");
		}
		
		this.pieceToCreate = new Piece();
		try {
			Object[] possibleSides = Side.getInternalSides();
			this.pieceToCreate.addSide(Side.BORDERSIDE);
			this.pieceToCreate.addSide((Side) possibleSides[(int) (Math.random() * possibleSides.length)]);
			this.pieceToCreate.addSide((Side)possibleSides[(int) (Math.random() * possibleSides.length)]);
			this.pieceToCreate.addSide(Side.BORDERSIDE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Dimension dimension = new Dimension(Piece.WIDTH, Piece.WIDTH);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setVisible(true);
	}
	
	/**
	 * Draw the piece panel
	 */
	public void paintComponent(Graphics g) {
        g.drawImage(PiecePanel.background.getImage(), 0, 0, null);
        this.pieceToCreate.drawPiece(g);
    }
	
	/**
	 * Get the piece to create
	 * 
	 * @return
	 */
	public Piece getPieceToCreate() {
		return this.pieceToCreate;
	}
	
	/**
	 * Reset the piece to create
	 * 
	 * @param topSide
	 * @param rightSide
	 * @param bottomSide
	 * @param leftSide
	 */
	public void resetPieceToCreate(Side topSide, Side rightSide, Side bottomSide, Side leftSide) {
		this.pieceToCreate = new Piece();
		try {
			this.pieceToCreate.addSide(topSide);
			this.pieceToCreate.addSide(rightSide);
			this.pieceToCreate.addSide(bottomSide);
			this.pieceToCreate.addSide(leftSide);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
