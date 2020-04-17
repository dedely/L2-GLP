package gui.elements.buttons;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import data.Constants;
import data.order.CreateUnit;
import process.Faction;
import process.managers.SelectableManager;

public class WrathButton extends OrderButton {

	public WrathButton(Faction player, String action) {
		super(player, action);
		initStyle();
		initLayout();
		initAction();
	}

	private void initStyle() {
		getButton().setText(getAction());
		getButton().setOpaque(true);
		getButton().setContentAreaFilled(true);
		getButton().setBorderPainted(true);
	}

	private void initLayout() {
		// Center by default
		setLayout(new FlowLayout());
		add(getButton());

	}

	private void initAction() {
		getButton().addActionListener(new CreateWrathAction());
	}

	private class CreateWrathAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Integer> selectedCollection = getPlayer().getSelection();
			for (Integer selectedId : selectedCollection) {
				try {
					SelectableManager manager = getPlayer().getSelectableManager(selectedId);
					CreateUnit order = new CreateUnit(Constants.WRATH);
					manager.giveOrder(order);
				} catch (NoSuchElementException nsee) {
					System.err.println(nsee.getMessage());
				}
			}

		}

	}
}