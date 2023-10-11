package layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {

	public BorderLayoutDemo() {
		super("BorderLayout");
		// Default: Hide on Close

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// größe festlegen
		setSize(400, 300);
		// in einer Methode
		setBounds(500, 200, 400, 300);

		// mittig auf dem Desktopplatze
		setLocationRelativeTo(null);

		getContentPane().setBackground(Color.PINK);

		// für die Anordnung der Komponente ist ein LayoutManager verantwortlich

		// Standard-LayoutManager von JFrame:BorderLayout
		// 5 Bereich: North - West - East -South -Center

		JButton button = new JButton("Center");
		getContentPane().add(button, BorderLayout.CENTER);

		button = new JButton("South");
		getContentPane().add(button, BorderLayout.SOUTH);

		button = new JButton("North");
		getContentPane().add(button, BorderLayout.NORTH);

		button = new JButton("East");
		getContentPane().add(button, BorderLayout.EAST);

		button = new JButton("West");
		getContentPane().add(button, BorderLayout.WEST);

		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutDemo();

	}

}
