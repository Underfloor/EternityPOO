package fr.eternity.game.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public enum Side implements Serializable {
	BORDERSIDE("/Images/borderSide.png"),
	GREENSIDE("/Images/greenSide.png"),
	REDSIDE("/Images/redSide.png"),
	BLUESIDE("/Images/blueSide.png"),
	ORANGESIDE("/Images/orangeSide.png"),
	PINKSIDE("/Images/pinkSide.png"),
	PURPLESIDE("/Images/purpleSide.png"),
	TURQUOISESIDE("/Images/turquoiseSide.png"),
	KHAKISIDE("/Images/khakiSide.png");
	
	private ImageIcon view;

	/**
	 * Constructor
	 * 
	 * @param image
	 */
	private Side(String image) {
		this.view = new ImageIcon(this.getClass().getResource(image));
	}

	/**
	 * Draw the side
	 * 
	 * @param g
	 * @param sideNumber
	 */
	public void drawSide(Graphics g, int sideNumber) {
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate((Math.PI / 2) * sideNumber, this.view.getIconWidth() / 2, this.view.getIconHeight() / 2);
		g2.drawImage(this.view.getImage(), 0, 0, null);
		g2.rotate((Math.PI / 2) * -sideNumber, this.view.getIconWidth() / 2, this.view.getIconHeight() / 2);
	}

	/**
	 * Draw the side with x and y offset
	 * 
	 * @param g
	 * @param sideNumber
	 * @param x
	 * @param y
	 */
	public void drawSide(Graphics g, int sideNumber, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(x * Piece.WIDTH, y * Piece.WIDTH);
		g2.rotate((Math.PI / 2) * sideNumber, this.view.getIconWidth() / 2, this.view.getIconHeight() / 2);
		g2.drawImage(this.view.getImage(), 0, 0, null);
		g2.rotate((Math.PI / 2) * -sideNumber, this.view.getIconWidth() / 2, this.view.getIconHeight() / 2);
		g2.translate(x * -Piece.WIDTH, y * -Piece.WIDTH);
	}
	
	/**
	 * Return all side without the borderSide
	 * 
	 * @return
	 */
	public static Object[] getInternalSides() {
		ArrayList<Side> sides = new ArrayList<Side>();
		for (Side side: Side.values()) {
			if (side != Side.BORDERSIDE) {
				sides.add(side);
			}
		}
		
		return sides.toArray();
	}
}
