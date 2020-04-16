package gui.elements;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.Constants;
import process.Game;

public class TitleScreenTest extends Dashboard {

	private JLabel titleLabel = new JLabel("War Never Dies", SwingConstants.CENTER);
	private JButton playButton = new JButton("New game");

	private int state;

	
	public TitleScreenTest(Game game) {
		super(game);
		state = TitleScreenState.NEW;
		initLayout();
		initActions();
	}
	
	private void initLayout() {
		Dimension dimensionButtons = new Dimension(100, 100);
		playButton.setMinimumSize(dimensionButtons);
		setLayout(new GridLayout(3, 1));
		add(titleLabel);
		add(playButton);
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
