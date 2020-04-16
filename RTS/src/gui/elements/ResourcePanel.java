package gui.elements;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Resource;

/**
 * @author Adel
 *
 */
public class ResourcePanel extends JPanel {

	private ArrayList<Resource> resources = new ArrayList<Resource>();

	private JLabel energyLabel = new JLabel("Energy:");
	private JLabel materialLabel = new JLabel("Materials:");

	private JLabel energyValue = new JLabel("");
	private JLabel materialValue = new JLabel("");

	public ResourcePanel() {
		initStyle();
		initLayout();
	}

	private void initStyle() {

	}

	private void initLayout() {
		setLayout(new GridLayout(2, 1));
	}

	private void updateValues() {
		
	}

	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

}