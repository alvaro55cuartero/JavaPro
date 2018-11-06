package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import programas.gp.ProGP;
import programas.pro.Pro;
import programas.prolector.ProLector;
import programas.prolista.ProLista;
import programas.promusic.ProMusic;
import programas.protexto.ProTexto;

public class Root implements ActionListener {

	private static Program program;
	static JPanel panel;

	JMenu m1;

	static JMenuBar bar;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;
	JMenuItem mi14;
	JMenuItem mi15;
	JMenuItem mi16;

	static boolean prog;

	public Root() {
		panel = new JPanel();

		bar = new JMenuBar();

		m1 = new JMenu();
		m1.setText("Mode");

		mi11 = new JMenuItem();
		mi11.setText("Pro");
		mi11.addActionListener(this);

		mi12 = new JMenuItem();
		mi12.setText("ProMusic");
		mi12.addActionListener(this);

		mi13 = new JMenuItem();
		mi13.setText("ProLista");
		mi13.addActionListener(this);

		mi14 = new JMenuItem();
		mi14.setText("ProLector");
		mi14.addActionListener(this);

		mi15 = new JMenuItem();
		mi15.setText("ProTexto");
		mi15.addActionListener(this);

		mi16 = new JMenuItem();
		mi16.setText("ProGP");
		mi16.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);
		m1.add(mi15);
		m1.add(mi16);

		bar.add(m1);

		panel.setBackground(Color.BLACK);
		panel.setLayout(null);

		Ventana.getFrame().setTitle("pro");
		Ventana.getFrame().setBackground(Color.BLACK);
		Ventana.getFrame().add(panel, BorderLayout.CENTER);
		Ventana.getFrame().add(bar, BorderLayout.NORTH);

	}

	public void start() {
		if (prog) {
			program.start();
		}
	}

	public void tick() {
		System.out.println();
		if (prog) {
			program.tick();

		}
	}

	public void render() {
		if (prog) {
			program.render();
		}
	}

	public void debug() {
		if (prog) {
			program.debug();
		}
	}

	public void dispose() {
		if (prog) {
			program.dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi11)) {
			program = new Pro();
			prog = true;
		} else if (e.getSource().equals(mi12)) {
			program = new ProMusic();
			prog = true;
		} else if (e.getSource().equals(mi13)) {
			program = new ProLista();
			prog = true;
		} else if (e.getSource().equals(mi14)) {
			program = new ProLector();
			prog = true;
		} else if (e.getSource().equals(mi15)) {
			program = new ProTexto();
			prog = true;
		} else if (e.getSource().equals(mi16)) {
			program = new ProGP();
			prog = true;
		}
	}

	public static void reset() {
		prog = false;
		Ventana.getFrame().getContentPane().removeAll();
		Ventana.getFrame().setTitle("pro");
		Ventana.getFrame().setBackground(Color.BLACK);
		Ventana.getFrame().add(panel, BorderLayout.CENTER);
		Ventana.getFrame().add(bar, BorderLayout.NORTH);
		Ventana.getFrame().pack();

	}
}
