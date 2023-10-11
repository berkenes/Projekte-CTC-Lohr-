package Test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyApplication {
	public static void main(String[] args) {
		JFrame frame = new JFrame("FlowLayout Örneği");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		// Etiketler (Label)
		JLabel label1 = new JLabel("Etiket 1:");
		JLabel label2 = new JLabel("Etiket 2:");

		// Düğmeler (Button)
		JButton button1 = new JButton("Düğme 1");
		JButton button2 = new JButton("Düğme 2");

		// Onay Kutuları (Checkbox)
		JCheckBox checkBox1 = new JCheckBox("Onay Kutusu 1");
		JCheckBox checkBox2 = new JCheckBox("Onay Kutusu 2");

		// Frame'e bileşenleri ekleme
		frame.add(label1);
		frame.add(button1);
		frame.add(checkBox1);
		frame.add(label2);
		frame.add(button2);
		frame.add(checkBox2);

		frame.setSize(300, 150);
		frame.setVisible(true);
	}
}
