package programas.protexto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.Program;
import main.Ventana;
import tools.Lector;

public class ProTexto extends Program implements ActionListener {

	JPanel panel;
	JMenuBar menuBar;
	JTextArea area;

	JMenu m1;
	JMenu m2;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;

	File file;

	boolean newword;

	public void start() {
		panel = new JPanel();
		menuBar = new JMenuBar();
		area = new JTextArea();

		m1 = new JMenu();
		m2 = new JMenu();

		mi11 = new JMenuItem();
		mi12 = new JMenuItem();
		mi13 = new JMenuItem();

		mi21 = new JMenuItem();
		mi22 = new JMenuItem();
		mi23 = new JMenuItem();

		panel.setLayout(new BorderLayout());

		m1.setText("File");
		m2.setText("Mode");

		mi11.setText("New");
		mi12.setText("Open");
		mi13.setText("Guardar");

		mi21.setText("Notas");
		mi22.setText("Frec");

		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);

		mi21.addActionListener(this);
		mi22.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);

		m2.add(mi21);
		m2.add(mi22);

		menuBar.add(m1);
		menuBar.add(m2);
		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(area, BorderLayout.CENTER);
		panel.setVisible(true);
		Ventana.getFrame().add(panel);
	}

	public void tick() {
		if (last() == ' ') {
			newword = true;
		}
		if (newword) {
			lastWord();
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
		}
	}

	private File open() {
		JFileChooser fileChooser = new JFileChooser();
		int r = fileChooser.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}

	private char last() {
		String txt = area.getText();
		return txt.charAt(txt.length());
	}

	private String lastWord() {
		String[] palabras = area.getText().split(" ");
		return palabras[palabras.length];
	}

	private String[] buscar(String palabra, String[] array) {
		String[] r;
		
		for
	}

}