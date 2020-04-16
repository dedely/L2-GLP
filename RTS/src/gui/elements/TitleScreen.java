package gui.elements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Config;
import data.Constants;
import data.Player;
import process.Game;
import tests.input.InputParameter;

/**
 * @author Awen
 *
 */
public class TitleScreen extends Dashboard {

	private JPanel content = new JPanel();
	private JLabel titleLabel = new JLabel("War Never Dies", SwingConstants.CENTER);
	private JButton playButton = new JButton("New game");
	private JButton quitButton = new JButton("Quit game");
	private JLabel optionsLabel = new JLabel("Select your faction", SwingConstants.CENTER);
	private JButton union = new JButton("Union");
	private JButton federation = new JButton("Federation");
	private JButton republic = new JButton("Republic");
	private JButton back = new JButton("Go Back to Title Screen");

	private Config config = new Config(10);
	
	public TitleScreen(Game game) {
		super(game);
		initBackground();
		initLayout();
		initActions();
	}

	private void initLayout() {
		setLayout(new BorderLayout());
		content.add(titleLabel);
		content.add(playButton);
		content.add(quitButton);
		add(content, BorderLayout.CENTER);
	}

	private void initBackground() {
		ImagePanel background = new ImagePanel(InputParameter.BACKGROUND);
		content = background;
	}

	private void initActions() {
		playButton.addActionListener(new PlayAction());
		quitButton.addActionListener(new QuitAction());
		union.addActionListener(new UnionChoosen());
		federation.addActionListener(new FederationChoosen());
		republic.addActionListener(new RepublicChoosen());
		back.addActionListener(new BackToTitle());
	}

	private void showOptions() {

		content.removeAll();
		content.setLayout(new FlowLayout());
		content.add(optionsLabel);
		content.add(union);
		content.add(federation);
		content.add(republic);
		content.add(back);

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
			Player player = new Player(Constants.PLAYER, "Union");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

	private class FederationChoosen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> players = new ArrayList<Player>();
			Player player = new Player(Constants.PLAYER, "Federation");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

	private class RepublicChoosen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> players = new ArrayList<Player>();
			Player player = new Player(Constants.PLAYER, "Republic");
			players.add(player);
			config.setPlayers(players);
			getGame().launch(config);
		}

	}

	private class BackToTitle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			removeAll();
			initBackground();
			initLayout();
			initActions();
			add(content, BorderLayout.CENTER);
			revalidate();
			repaint();
		}

	}

}