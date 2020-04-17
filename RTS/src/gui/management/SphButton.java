package gui.management;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import data.Constants;
import data.order.CreateUnit;
import gui.elements.buttons.OrderButton;
import process.Faction;
import process.managers.SelectableManager;

public class SphButton extends OrderButton {
	public SphButton(Faction player, String action) {
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
		getButton().addActionListener(new CreateSphAction());
	}

	private class CreateSphAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Integer> selectedCollection = getPlayer().getSelection();
			for (Integer selectedId : selectedCollection) {
				try {
					SelectableManager manager = getPlayer().getSelectableManager(selectedId);
					CreateUnit order = new CreateUnit(Constants.SPH);
					manager.giveOrder(order);
				} catch (NoSuchElementException nsee) {
					System.err.println(nsee.getMessage());
				}
			}

		}

	}
}
