package gui.elements.buttons;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//Center by default
		setLayout(new FlowLayout());
		add(getButton());

	}

	private void initAction() {
		// TODO Auto-generated method stub

	}

	private class CreateTestUnitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}

	}
}