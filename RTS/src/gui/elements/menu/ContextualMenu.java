package gui.elements.menu;

import java.awt.FlowLayout;
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
		setLayout(new FlowLayout());
		initStyle();
		layoutButtons();
	}

	private void initStyle() {

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
		removeAll();
		for (OrderButton button : buttons) {
			add(button);
		}
		repaint();
		revalidate();
	}
}