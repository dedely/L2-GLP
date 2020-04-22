package gui.management;

import java.util.ArrayList;

import data.Selectable;
import gui.elements.buttons.OrderButton;
import process.Faction;
import process.repository.SelectableRepository;
import process.visitor.selectable.ActionVisitor;

/**
 * This is a utility class used to generate a collection {@link OrderButton}
 * depending on which {@link Selectable} have been selected. We will add
 * additional logic later to process multiple selection.
 * 
 * @author Adel
 *
 */
public class ButtonBuilder {
	private Faction player;
	private ArrayList<Integer> selected = new ArrayList<Integer>();

	public ButtonBuilder(Faction player) {
		this.player = player;
	}

	/**
	 * 
	 * @return a collection of {@link OrderButton} which depends on the type and on
	 *         the amount of selected {@link Selectable}
	 */
	public ArrayList<OrderButton> getButtons() {
		SelectableRepository r = SelectableRepository.getInstance();
		selected = player.getSelection();

		ArrayList<OrderButton> buttons = new ArrayList<OrderButton>();
		Integer size = selected.size();

		if (size == 1) {
			buttons = buildButtons(r.getSelectable(selected.get(0)));
		}

		return buttons;

	}

	/**
	 * This method is called when only one {@link Selectable} is selected. It uses
	 * the visitor design pattern.
	 * 
	 * @param selectable
	 * @return the appropriate button collection.
	 */
	private ArrayList<OrderButton> buildButtons(Selectable selectable) {
		ArrayList<OrderButton> buttons = new ArrayList<OrderButton>();
		ActionVisitor visitor = new ActionVisitor();
		ArrayList<String> actions = selectable.accept(visitor);

		if (actions != null) {
			for (String type : actions) {
				OrderButton button = ButtonFactory.getInstance().createOrderButton(player, type);
				buttons.add(button);
			}
		}

		return buttons;
	}
}