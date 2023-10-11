package Test;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocusEventExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Focus Event Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		JPanel panel = new JPanel();
		frame.add(panel);

		JTextField textField1 = new JTextField("Text Field 1");
		JTextField textField2 = new JTextField("Text Field 2");

		// FocusListener ekleyerek odak olaylarını dinliyoruz
		textField1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Odak kazanıldığında bu olay tetiklenir
				textField1.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Odak kaybedildiğinde bu olay tetiklenir
				textField1.setBackground(Color.WHITE);
			}
		});

		textField2.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField2.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				textField2.setBackground(Color.WHITE);
			}
		});

		panel.add(textField1);
		panel.add(textField2);

		frame.setVisible(true);
	}
}
