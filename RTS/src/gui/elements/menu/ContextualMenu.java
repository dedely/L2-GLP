package gui.elements.menu;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import gui.elements.buttons.OrderButton;
import gui.management.ButtonBuilder;

/**
 * The ContextualMenu is a JPanel used as a container for context dependant
 * buttons and labels which are generated dynamically.
 * 
 * @author Adel
 *
 */
public class ContextualMenu extends JPanel {

	ButtonBuilder builder = new ButtonBuilder();

	private ArrayList<OrderButton> buttons = new ArrayList<OrderButton>();

	public ContextualMenu() {
		super();
		layoutButtons();
	}

	public ArrayList<OrderButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<OrderButton> buttons) {
		this.buttons = buttons;
	}

	/**
	 * udpates the buttons list.
	 */
	public void update() {
		buttons = builder.getButtons();
		layoutButtons();
	}

	private void layoutButtons() {
		setLayout(new BorderLayout());
		if(buttons.isEmpty()) {
			System.out.println("buttons empty");
		}
		for (OrderButton button : buttons) {
			add(button);
		}
		repaint();
	}
}