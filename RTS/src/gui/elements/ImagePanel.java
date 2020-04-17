package gui.elements;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;

	private int iWidth2;
	private int iHeight2;
	private boolean isSet = false;

	public ImagePanel(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.err.println("couldn't load image");
			this.iWidth2 = image.getWidth(this) / 2;
			this.iHeight2 = image.getHeight(this) / 2;
			isSet = true;
		}

	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
