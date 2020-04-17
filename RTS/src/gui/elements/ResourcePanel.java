package gui.elements;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Constants;
import data.Resource;
import process.Faction;

/**
 * @author Adel
 *
 */
public class ResourcePanel extends JPanel {

	private Faction player;

	private JLabel materialLabel = new JLabel("Materials: ");
	private JLabel materialValue = new JLabel("");

	public ResourcePanel(Faction player) {
		this.player = player;
		initStyle();
		initLayout();
	}

	private void initStyle() {

	}

	private void initLayout() {
		setLayout(new GridLayout(2, 1));
		add(materialLabel);
		add(materialValue);
	}

	public void updateValues() {
		Resource materials = player.getResource(Constants.MATERIALS);
		int count = materials.getResourceCount();
		String newTxt = String.valueOf(count);
		materialValue.setText(newTxt);
	}

}