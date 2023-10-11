package event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionDemo extends JFrame implements ActionListener {

	public static final String YELLOW = "Gelb";
	private Color color = Color.PINK;

	public ActionDemo() {
		super("ActionDemo");
		// Default: Hide on Close

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		// einen anderen LayoutManager

		getContentPane().setBackground(color);

		JButton button = new JButton("Change");
		button.addActionListener(this);

		getContentPane().add(button, BorderLayout.SOUTH);

		button = new JButton(YELLOW);

		button.addActionListener(this);

		getContentPane().add(button, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		ActionDemo frame = new ActionDemo();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		String cmd = e.getActionCommand();
		if (cmd.equals(YELLOW)) {
			color = color.YELLOW;
		} else {
			color = color.PINK;

		}
		getContentPane().setBackground(color);
	}

}
