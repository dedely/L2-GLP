package gui.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContextualPanel extends JPanel {
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	protected JLabel contextLabel = new JLabel("context label");

	public ContextualPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.LIGHT_GRAY);
		contextLabel.setFont(font);
		contextLabel.setForeground(Color.WHITE);
		add(contextLabel);
	}

}