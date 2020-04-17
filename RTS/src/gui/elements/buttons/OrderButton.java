package gui.elements.buttons;

import javax.swing.JButton;
import javax.swing.JPanel;

import process.Faction;

/**
 * @author Adel
 *
 */
public abstract class OrderButton extends JPanel {

	private Faction player;
	private String action;
	private JButton button;

	public OrderButton(Faction player, String action) {
		this.player = player;
		this.action = action;
		button = new JButton("action");
	}

	public String getAction() {
		return action;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public Faction getPlayer() {
		return player;
	}

}