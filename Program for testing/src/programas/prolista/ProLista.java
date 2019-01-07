package programas.prolista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import main.Program;
import main.Ventana;
import tools.Lector;

public class ProLista extends Program implements ActionListener {

	JPanel panel;

	JTextArea ta;

	JMenu m2;

	JMenuItem mi21;

	String ruta;

	JList<String> list;

	ArrayList<String> a;

	public ProLista() {
		Ventana.getFrame().getContentPane().removeAll();
		panel = new JPanel();

		m2 = new JMenu();

		mi21 = new JMenuItem();

		mi21.setText("Sort");
		mi21.addActionListener(this);

		m2.setText("Edit");
		m2.add(mi21);

		bar.add(m1);

		ta = new JTextArea();
		list = new JList<String>();
		list.setBounds(0, 0, 500, 500);

		panel.setBackground(Color.BLACK);
		panel.setLayout(null);

		Ventana.getFrame().setTitle("Mapa");
		Ventana.getFrame().setBackground(Color.BLACK);
		Ventana.getFrame().add(panel, BorderLayout.CENTER);
		Ventana.getFrame().add(bar, BorderLayout.NORTH);
		Ventana.getFrame().pack();

	}

	public void start() {

	}

	public void tick() {

	}

	public void render() {

	}

	public void debug() {

	}

	public void dispose() {

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(mi12)) {
			ListModel<String> a = list.getModel();
			String[] b = new String[a.getSize()];
			for (int i = 0; i < a.getSize(); i++) {
				b[i] = a.getElementAt(i);
			}

			Arrays.sort(b);
			list.setListData(b);
		}

		if (e.getSource().equals(mi13)) {
			File file = chooser();
			ruta = file.getPath();

			ListModel<String> a = list.getModel();

			String b = "";
			for (int i = 0; i < a.getSize(); i++) {
				b = b + "\n" + a.getElementAt(i);
			}

			try {
				Lector.createFile(ruta, b);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private String[] rellenar(ArrayList<String> a) {
		String[] b = new String[a.size()];

		for (int i = 0; i < a.size(); i++) {
			b[i] = a.get(i);
		}

		return b;
	}

	public boolean compare(String a, String b) {

		int length;

		if (a.length() > b.length()) {
			length = b.length();
		} else {
			length = a.length();
		}

		for (int i = 0; i < length; i++) {
			if (com(a.charAt(i), b.charAt(i)) == 0) {
				return true;
			} else if (com(a.charAt(i), b.charAt(i)) == 2) {
				return false;
			}
		}

		return true;
	}

	public int com(char a, char b) {
		int i = a;
		int j = b;
		if (j > i) {
			return 0;
		} else if (i == j) {
			return 1;
		} else {
			return 2;
		}

	}

	public void procesadorTxt(String ruta) {
		if (ruta != null) {

			String txt = "";
			try {
				txt = Lector.leerArchivoTexto(ruta);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			String[] palabras = txt.split("\n");
			if (palabras[0].matches("##list##")) {
				String[] a = new String[palabras.length - 1];

				for (int i = 0; i < a.length; i++) {
					a[i] = palabras[i + 1];
				}

				panel.removeAll();
				panel.add(list);
				list.setListData(a);
			} else if (palabras[0].matches("##txt##")) {
				panel.removeAll();
				panel.add(ta);
				ta.setText(txt);
			}

		}
	}

	private File chooser() {
		JFileChooser fileChooser = new JFileChooser();
		int r = fileChooser.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}

	public void new0() {
	}

	public void open() {
		File file = chooser();
		ruta = file.getPath();
		procesadorTxt(ruta);
	}

	public void save() {
	}

	public void exit() {
	}
}
