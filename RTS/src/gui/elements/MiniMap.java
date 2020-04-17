package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniMap extends JPanel {

	private JLabel miniMap = new JLabel("mini");

	public MiniMap() {
		setLayout(new BorderLayout());
		add(miniMap);
		setBackground(Color.GREEN);
	}

}