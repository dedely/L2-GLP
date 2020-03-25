package gui.elements.buttons;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.order.CreateUnit;
import data.unit.Unit;
import gui.elements.SimuPara;
import process.OrderTreatment;
import process.SelectableRepository;
import process.factory.UnitFactory;

/**
 * @author Adel
 *
 */
public class CreateTestUnitButton extends OrderButton {

	public CreateTestUnitButton(String action) {
		super(action);
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
		getButton().addActionListener(new CreateTestUnitAction());
	}

	private class CreateTestUnitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelectableRepository r = SelectableRepository.getInstance();
			ArrayList<Selectable> selectedCollection = r.getSelected();
			// the position of the new selectable should be around the building. the
			// following is artificial.
			for (Selectable selected : selectedCollection) {
				Coordinates position = new Coordinates(selected.getPositionX() - SimuPara.RADIUS * 4, selected.getPositionX() -  SimuPara.RADIUS * 4, 0);
				//CreateUnit order = new CreateUnit(Constants.TEST_GROUND, position, 100);
				Unit newUnit = UnitFactory.createUnit(Constants.TEST_GROUND,position, selected.getFaction());
				SelectableRepository.getInstance().addNewUnit(newUnit);
				//System.out.println(SelectableRepository.getInstance().getPositions().values().size());
				//System.out.println("registered!");
				//r.addNewUnit(newUnit);
				//OrderTreatment.giveOrderReplace(selected, order);
			}
		}

	}
}