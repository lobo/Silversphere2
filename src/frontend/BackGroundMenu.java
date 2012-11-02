package frontend;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackGroundMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a BackGround
	 */
	public BackGroundMenu() {
		setOpaque(false);
		setLayout(null);
	}

	/**
	 * Draws the BackGround Image, taken from the resources folder
	 */
	@Override
	public void paint(Graphics g) {
		Image imagen = Toolkit.getDefaultToolkit().getImage(
				"./resources/dani.jpg");
		g.drawImage(imagen, 0, 0, getSize().width, getSize().height, this);
		super.paint(g);
	}

}