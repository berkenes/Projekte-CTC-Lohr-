package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {

	public FlowLayoutDemo() {
		super("BorderLayout");
		// Default: Hide on Close

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		getContentPane().setBackground(Color.PINK);

		// einen anderen LayoutManager

		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

		JButton button = new JButton("Button 1");
		getContentPane().add(button);

		button = new JButton("langer Button");
		getContentPane().add(button);

		button = new JButton("sehr sehr langer Button");
		// button.setSize(200, 50); Darauf hört der FlowLayout-Manager NICHT!!
		button.setPreferredSize(new Dimension(200, 50));
		getContentPane().add(button);

		button = new JButton("Mini");
		getContentPane().add(button);

		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutDemo();

	}

}
