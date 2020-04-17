package gui.elements;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import gui.elements.buttons.OrderButton;
import gui.management.ButtonBuilder;
import process.Faction;

/**
 * The ContextualMenu is a JPanel used as a container for context dependant
 * buttons and labels which are generated dynamically.
 * 
 * @author Adel
 *
 */
public class ContextualMenu extends JPanel {

	
	private Faction player;
	private ButtonBuilder builder;

	private ArrayList<OrderButton> buttons = new ArrayList<OrderButton>();

	public ContextualMenu(Faction player) {
		super();
		this.player = player;
		builder = new ButtonBuilder(player);
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
		revalidate();
		repaint();
	}
}