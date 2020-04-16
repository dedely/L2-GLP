package gui.elements;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import data.Config;
import data.Constants;
import process.Game;

/**
 * @author Adel
 *
 */
public class TitleScreen extends Dashboard {

	private JLabel titleLabel = new JLabel("War Never Dies");
	private JButton playButton = new JButton("New game");
	
	private int state;
	
	private Config config;

	public TitleScreen(Game game) {
		super(game);
		state = TitleScreenState.NEW;
		initLayout();
		initActions();
	}

	private void initLayout() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, titleLabel);
		add(BorderLayout.CENTER, playButton);
	}

	private void initActions() {
		playButton.addActionListener(new PlayAction());

	}

	private class PlayAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getGame().launch(Constants.DEFAULT_CONFIG);

		}

	}

}