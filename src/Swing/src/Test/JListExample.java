package Test;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JList Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] meyveler = { "Elma", "Armut", "Muz", "Çilek" };
		JList<String> meyveListesi = new JList<>(meyveler);
		meyveListesi.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// ListSelectionListener ekliyoruz
		meyveListesi.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Seçilen öğelerin dizisi
				int[] secilenIndeksler = meyveListesi.getSelectedIndices();

				// Seçilen öğelerin değerleri
				Object[] secilenMeyveler = meyveListesi.getSelectedValues();

				// Seçilen öğeleri ekrana yazdırma
				System.out.println("Seçilen İndeksler:");
				for (int indeks : secilenIndeksler) {
					System.out.println(indeks);
				}

				System.out.println("Seçilen Meyveler:");
				for (Object meyve : secilenMeyveler) {
					System.out.println(meyve.toString());
				}
			}
		});

		frame.add(new JScrollPane(meyveListesi));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
