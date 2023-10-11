package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowsListenerV4 extends JFrame {

	public WindowsListenerV4() {
		super("WindowsListener");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowsListenerV4();

	}

}
