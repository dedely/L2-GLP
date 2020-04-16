package gui.elements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Config;
import data.Constants;
import data.Player;
import process.Game;

/**
 * @author Awen
 *
 */
public class TitleScreen extends Dashboard {

	private JLabel titleLabel = new JLabel("War Never Dies", SwingConstants.CENTER);
	private JButton playButton = new JButton("New game");
	private JButton quitButton = new JButton("Quit game");
	private JLabel nameLabel = new JLabel("Your name", SwingConstants.CENTER);
	private JTextField nameField = new JTextField(SwingConstants.CENTER);
	private JLabel optionsLabel = new JLabel("Select your faction", SwingConstants.CENTER);
	private JButton union = new JButton("Union");
	private JButton federation = new JButton("Federation");
	private JButton republic = new JButton("Republic");
	private JButton back = new JButton("Go Back to Title Screen");

	private int state;

	private Config config;

	public TitleScreen(Game game) {
		super(game);
		state = TitleScreenState.NEW;
		initLayout();
		initActions();
	}

	private void initLayout() {
		setLayout(new GridLayout(3, 1, 2, 0));
		add(titleLabel);
		add(playButton);
		add(quitButton);
	}

	private void initActions() {
		playButton.addActionListener(new PlayAction());
		quitButton.addActionListener(new QuitAction());
		union.addActionListener(new UnionChoosen());
		federation.addActionListener(new FederationChoosen());
		republic.addActionListener(new RepublicChoosen());

	}

	private void showOptions() {
		removeAll();
		setLayout(new GridLayout(7, 1, 2, 0));
		add(nameLabel);
		add(nameField);
		add(optionsLabel);
		add(union);
		add(federation);
		add(republic);
		add(back);
		revalidate();
		repaint();
	}

	private class PlayAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// getGame().launch(Constants.DEFAULT_CONFIG);
			showOptions();
		}

	}

	private class QuitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}

	private class UnionChoosen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> players = new ArrayList<Player>();
			Player player = new Player(nameField.getText(), "Union");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

	private class FederationChoosen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> players = new ArrayList<Player>();
			Player player = new Player(nameField.getText(), "Federation");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

	private class RepublicChoosen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> players = new ArrayList<Player>();
			Player player = new Player(nameField.getText(), "Republic");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

}