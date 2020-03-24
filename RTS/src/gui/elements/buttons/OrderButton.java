package gui.elements.buttons;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Adel
 *
 */
public abstract class OrderButton extends JPanel {

	private String action;
	private JButton button;

	public OrderButton(String action) {
		this.action = action;
		button = new JButton("action");
	}

	public String getAction() {
		return action;
	}

	public JButton getButton() {
		return button;
	}

}