package programas.protexto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.Program;
import main.Root;
import main.Ventana;
import tools.Lector;

public class ProTexto extends Program implements ActionListener {

	JPanel panel;
	JMenuBar menuBar;
	JTextArea area;
	JList<String> list;

	JMenu m1;
	JMenu m2;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;
	JMenuItem mi14;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;

	File file;
	Object[] options = { "articulo", "verbo", "adjetivo", "sustantivo", "determinante", "pronombre", "adverbio",
			"preposicion", "conjuncion", "locucion", "interjeccion" };
	boolean newword;

	public ProTexto() {
		Ventana.getFrame().getContentPane().removeAll();
		panel = new JPanel();
		menuBar = new JMenuBar();
		area = new JTextArea();
		DefaultListModel<String> model = new DefaultListModel<String>();

		list = new JList<String>(model);

		m1 = new JMenu();
		m2 = new JMenu();

		mi11 = new JMenuItem();
		mi12 = new JMenuItem();
		mi13 = new JMenuItem();
		mi14 = new JMenuItem();

		mi21 = new JMenuItem();
		mi22 = new JMenuItem();
		mi23 = new JMenuItem();

		panel.setLayout(new BorderLayout());

		m1.setText("File");
		m2.setText("Mode");

		mi11.setText("New");
		mi12.setText("Open");
		mi13.setText("Guardar");
		mi14.setText("Exit");

		mi21.setText("Colectar");
		mi22.setText("Frec");

		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		mi14.addActionListener(this);

		mi21.addActionListener(this);
		mi22.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);

		m2.add(mi21);
		m2.add(mi22);

		menuBar.add(m1);
		menuBar.add(m2);
		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(area, BorderLayout.CENTER);
		panel.setVisible(true);
		Ventana.getFrame().add(panel);
		Ventana.getFrame().pack();
	}

	public void start() {

	}

	public void tick() {
		if (last() == ' ') {
			newword = true;
		}
		if (newword) {
			lastWord();
		}
		if (!list.isSelectionEmpty()) {

			String name = list.getSelectedValue();
			int n = JOptionPane.showOptionDialog(null, "categoria de la palabra " + name, "selector",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			((DefaultListModel<String>) list.getModel()).removeElementAt(list.getSelectedIndex());

			if (n != -1) {
				try {
					Lector.createFile("res/ProTexto/categoria/" + options[n],
							Lector.leerArchivoTexto("res/ProTexto/categoria/" + options[n]) + name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.setSelectedIndex(-1);
		}
	}

	public void render() {

	}

	public void debug() {

	}

	public void dispose() {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi11)) {

		} else if (e.getSource().equals(mi12)) {
			panel.removeAll();
			panel.add(menuBar, BorderLayout.NORTH);
			panel.add(area, BorderLayout.CENTER);
			file = open();
			try {
				area.setText(Lector.leerArchivoTexto(file.getPath()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(mi13)) {
			try {
				Lector.createFile(file.getPath(), area.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(mi14)) {
			Root.reset();
		} else if (e.getSource().equals(mi21)) {

			panel.removeAll();
			panel.add(menuBar, BorderLayout.NORTH);
			panel.add(list, BorderLayout.CENTER);
			String[] r = colectar();
			for (int i = 0; i < r.length; i++) {
				((DefaultListModel<String>) list.getModel()).addElement(r[i]);
			}
		}
	}

	private File open() {
		JFileChooser fileChooser = new JFileChooser(new File("/"));
		int r = fileChooser.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}

	private char last() {
		String txt = area.getText();
		if (txt.equals("")) {
			return 1;
		}
		return txt.charAt(txt.length() - 1);
	}

	private String lastWord() {
		String[] palabras = area.getText().split(" ");
		return palabras[palabras.length - 1];
	}

	private boolean buscar(String palabra, String ruta) {
		try {
			String[] r = Lector.leerArchivoTexto(ruta).split("\n");
			for (int i = 0; i < r.length; i++) {
				if (r[i].equals(palabra)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String[] colectar() {
		ArrayList<String> r = new ArrayList<String>();
		String[] palabras = area.getText().replaceAll("\n", "").split(" ");
		for (int i = 0; i < palabras.length; i++) {
			if (!check(palabras[i])) {
				r.add(palabras[i]);
			}
		}

		return r.toArray(new String[10]);
	}

	private boolean check(String string) {
		for (int i = 0; i < options.length; i++) {
			if (buscar(string, "res/ProTexto/categoria/" + options[i])) {
				return true;
			}
		}
		return false;
	}

}