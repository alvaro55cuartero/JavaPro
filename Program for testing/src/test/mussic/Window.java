package test.mussic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import music.Acorde;
import music.Musica;

public class Window extends JFrame implements ActionListener {

	public static int ancho;
	public static int alto;

	public static String nombre;

	Musica musica;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JMenuItem menuItem1;
	JMenuItem menuItem2;

	public Window(int ancho, int alto, String nombre, Lienzo lienzo) {
		this.setTitle(nombre);
		this.setSize(ancho, alto);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBackground(Color.black);

		musica = new Musica(50000);

		menuBar = new JMenuBar();
		menu = new JMenu();
		menuItem = new JMenuItem();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();

		menu.setText("hola");

		menuItem.setText("root");
		menuItem.addActionListener(this);

		menuItem1.setText("Guardar");
		menuItem1.addActionListener(this);

		menuItem2.setText("Aceptar");
		menuItem2.addActionListener(this);

		menu.add(menuItem);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menuBar.add(menu);

		this.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);

		this.add(lienzo, 1);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(menuItem)) {
			random(4);
		}

		if (e.getSource().equals(menuItem2)) {
			musica.play(MenuFrec.nota(100000), 0, 100000);
		}
	}

	public void random(int a) {
		for (int i = 0; i < a; i++) {
			byte[] cancion = musica.binToChord(0, Acorde.rand(), 100000);
			musica.play(cancion, 0, cancion.length);

		}
		// musica.stopLine();
	}
}
