package event;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowsListenerV3 extends JFrame {

	public static final String YELLOW = "Gelb";

	private Color color = Color.PINK;

	public WindowsListenerV3() {
		super("WindowsListener");

		addWindowListener(new MyWindowListener());

		setSize(400, 400);
		setLocationRelativeTo(null);

		setVisible(true);
	}

	// einen anderen LayoutManager

	public static void main(String[] args) {
		new WindowsListenerV3();

	}

	class MyWindowListener extends WindowAdapter {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowOpened");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowClosing");
			dispose();
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowClosed");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowIconified");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowDeiconified");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowActivated");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowDeactivated");
		}

	}
}
