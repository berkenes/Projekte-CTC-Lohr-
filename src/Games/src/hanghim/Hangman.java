package hanghim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman extends JFrame implements MouseListener {

	private JLabel lblGuess;
	private JPanel pnlImage;
	private Letter[] letters;

	private static final int MAXFAILURE = 10;
	private String word;
	private Vector<String> words;
	private char[] guessed;
	private int failure;

	public Hangman(Vector<String> words) {
		super("Hangman");
		this.words = words;

		JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JLabel label = new JLabel("Ratewort: ");
		panelNorth.add(label);

		lblGuess = new JLabel();
		panelNorth.add(lblGuess);

		JButton button = new JButton("Neu");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panelNorth.add(button);

		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(pnlImage = new ImagePanel(), BorderLayout.CENTER);

		JPanel panelSouth = new JPanel(new GridLayout(2, 13));
		letters = new Letter[26];
		for (char c = 'A'; c <= 'Z'; c++) {
			letters[c - 'A'] = new Letter(c);
			panelSouth.add(letters[c - 'A']);
			letters[c - 'A'].addMouseListener(this);

		}
		panelSouth.setBorder(BorderFactory.createTitledBorder("Buchstaben"));
		getContentPane().add(panelSouth, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setResizable(false);
		reset();
		setVisible(true);
	}

	public void reset() {
		if (words.isEmpty()) {
			word = "ELEFANT";
		} else {
			word = words.get((int) (Math.random() * words.size()));
		}

		guessed = new char[word.length()];
		for (int i = 0; i < guessed.length; i++) {
			guessed[i] = '_';
		}

		failure = 0;

		pnlImage.repaint();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < guessed.length; i++) {
			builder.append(" " + guessed[i]);
		}
		builder.append(" ");
		lblGuess.setText(builder.toString());

		for (Letter l : letters) {
			l.resetLetters();
		}

	}

	class Letter extends JLabel {
		private char zeichen;

		public Letter(char zeichen) {
			super();
			this.zeichen = zeichen;

			setHorizontalAlignment(JLabel.CENTER);
			setText(String.valueOf(zeichen));
			setOpaque(true);
			setBackground(Color.BLACK);
			setForeground(Color.LIGHT_GRAY);

		}

		public void resetLetters() {
			setForeground(Color.LIGHT_GRAY);
//			System.out.println(getMouseListeners().length + " " + zeichen);
			if (getMouseListeners().length == 0) {
				addMouseListener(Hangman.this);
			}
		}

	}

	class ImagePanel extends JPanel {

		private Image[] images;

		public ImagePanel() {
			setBackground(Color.WHITE);

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			MediaTracker mediaTracker = new MediaTracker(this);
			images = new Image[11];
			for (int i = 0; i <= 10; i++) {
				images[i] = toolkit.createImage("images/hangman_" + i + ".jpg");
				mediaTracker.addImage(images[i], i);
			}
			try {
				mediaTracker.waitForAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			g.drawImage(images[failure], 0, 0, this);
		}
	}

	public static void main(String[] args) {
		Vector<String> strings = new Vector<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("woerter.txt"));

			String zeile;
			while ((zeile = reader.readLine()) != null) {
				strings.add(zeile.toUpperCase());

			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new Hangman(strings);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Letter letter = (Letter) e.getSource();
		letter.removeMouseListener(this);
		int pos = word.indexOf(letter.getText());
		if (pos == -1) {
			failure++;
			letter.setForeground(Color.RED);
			if (failure == MAXFAILURE) {
				JOptionPane.showMessageDialog(this, "Gesucht war: " + word, "Leider verloren!",
						JOptionPane.ERROR_MESSAGE);
				reset();
			}
		} else {
			letter.setForeground(Color.GREEN);
			guessed[pos] = letter.zeichen;

			while ((pos = word.indexOf(letter.getText(), pos + 1)) != -1) {
				guessed[pos] = letter.zeichen;
			}

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < guessed.length; i++) {
				builder.append(" " + guessed[i]);
			}
			builder.append(" ");
			lblGuess.setText(builder.toString());

			if (builder.indexOf("_") == -1) {
				JOptionPane.showMessageDialog(this, "Gelöst mit " + failure + " Fehlversuchen.",
						"Herzlichen Glückwunsch!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		pnlImage.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		((Letter) e.getSource()).setForeground(Color.YELLOW);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		((Letter) e.getSource()).setForeground(Color.LIGHT_GRAY);

	}

}
