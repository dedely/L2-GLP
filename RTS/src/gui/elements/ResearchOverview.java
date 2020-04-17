package gui.elements;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import process.managers.ResearchManager;

/**
 * @author Adel
 *
 */
public class ResearchOverview extends JPanel {

	private ResearchManager manager;

	private JLabel researchLabel = new JLabel("Current research: ");
	private JLabel minuteLabel = new JLabel("Minute:");
	private JLabel secondLabel = new JLabel("Second:");

	private JLabel currentReseach = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");

	private JPanel control = new JPanel();

	/**
	 * Initial status of for the start button.
	 */
	private boolean stop = true;

	public ResearchOverview(ResearchManager manager) {
		this.manager = manager;
		initLayout();
		
		setBackground(Color.BLUE);
	}

	private void initLayout() {
		updateValues();
		
	}

	private void updateValues() {
		
	}

}