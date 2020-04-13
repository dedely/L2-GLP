package gui.elements;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import data.Constants;
import process.Game;

public class TitleScreen extends Dashboard {

	private JButton playButton = new JButton("New game");

	public TitleScreen(Game game) {
		super(game);
		initLayout();
		initActions();
	}

	private void initLayout() {
		setLayout(new BorderLayout());
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