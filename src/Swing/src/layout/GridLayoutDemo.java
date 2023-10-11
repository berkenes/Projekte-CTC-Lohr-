package layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame {

	private static final Component Button = null;

	public GridLayoutDemo() {
		super("GridLayout");
		// Default: Hide on Close

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		// einen anderen LayoutManager

		getContentPane().setLayout(new GridLayout(2, 3, 30, 5));
		getContentPane().setBackground(Color.PINK);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				getContentPane().add(new JButton(i + "/" + j));
			}
		}
		getContentPane().add(new JButton("neu"));
		getContentPane().add(Button);

		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutDemo();

	}

}
