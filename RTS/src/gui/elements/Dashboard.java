package gui.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import process.Game;

/**
 * @author Adel
 *
 */
public class Dashboard extends JPanel{
	private Game game;

	public Dashboard(Game game) {
		this.game = game;
		setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		printMap(g2);
		printSelectables(g2);
	}

	private void printMap(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	private void printSelectables(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
}