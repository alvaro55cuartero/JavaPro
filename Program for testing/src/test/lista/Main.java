package test.lista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class Main implements ActionListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;

	JFrame frame;
	JPanel panel;
	JMenu menu;
	JMenuBar bar;
	JMenuItem mi;
	JMenuItem mi2;
	JMenuItem mi3;
	JMenuItem mi4;

	JTextArea ta;

	String ruta;

	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	JList<String> list;

	ArrayList<String> a;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		frame = new JFrame();
		panel = new JPanel();
		menu = new JMenu();
		bar = new JMenuBar();
		mi = new JMenuItem();
		mi2 = new JMenuItem();
		mi3 = new JMenuItem();
		mi4 = new JMenuItem();

		mi.setText("Open");
		mi.addActionListener(this);

		mi2.setText("Sort");
		mi2.addActionListener(this);

		mi3.setText("Save");
		mi3.addActionListener(this);

		mi4.setText("Add");
		mi4.addActionListener(this);

		menu.setText("File");
		menu.add(mi);
		menu.add(mi2);
		menu.add(mi3);
		menu.add(mi4);

		bar.add(menu);

		ta = new JTextArea();
		list = new JList<String>();
		list.setBounds(0, 0, 500, 500);

		panel.setBackground(Color.BLACK);
		panel.setLayout(null);

		frame.setBounds((dimension.width - WIDTH) / 2, (dimension.height - HEIGHT) / 2, WIDTH, HEIGHT);
		frame.setTitle("Mapa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(bar, BorderLayout.NORTH);
		frame.setVisible(true);

	}

	private String[] rellenar(ArrayList<String> a) {
		String[] b = new String[a.size()];

		for (int i = 0; i < a.size(); i++) {
			b[i] = a.get(i);
		}

		return b;
	}

	public String[] ordenar(String[] a) {

		String[] b = new String[a.length];
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (j != i) {
					if (!compare(a[i], a[j])) {
						c++;
					}
				}
			}
			b[c] = a[i];
			c = 0;
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi)) {
			ruta = JOptionPane.showInputDialog("Select File");
			procesadorTxt(ruta);
		}
		if (e.getSource().equals(mi2)) {
			ListModel<String> a = list.getModel();
			String[] b = new String[a.getSize()];
			for (int i = 0; i < a.getSize(); i++) {
				b[i] = a.getElementAt(i);
			}

			list.setListData(ordenar(b));
		}

		if (e.getSource().equals(mi3)) {
			ruta = JOptionPane.showInputDialog("Select File");

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

		if (e.getSource().equals(mi4)) {
			Buscador b = new Buscador();
		}
	}

	public String nombreArchivo(String ruta) {
		byte b = '/';
		int c = 0;
		byte[] a = ruta.getBytes();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				c++;
			}
		}
		int u = 0;
		for (int i = 0; i < a.length; i++) {
			if (c != 0) {
				u++;
			}
			if (a[i] == b) {
				c--;
			}
		}

		return ruta.substring(u);
	}

	public void procesadorTxt(String ruta) {
		if (ruta != null) {
			System.out.println(nombreArchivo(ruta));
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
}
