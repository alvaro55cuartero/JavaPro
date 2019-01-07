package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class Program implements ActionListener {

	protected JMenuBar bar = new JMenuBar();

	protected JMenu m1 = new JMenu();

	protected JMenuItem mi11 = new JMenuItem();
	protected JMenuItem mi12 = new JMenuItem();
	protected JMenuItem mi13 = new JMenuItem();
	protected JMenuItem mi14 = new JMenuItem();

	public Program() {
		bar.add(m1);
		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);

		m1.setText("File");

		mi11.setText("New");
		mi12.setText("Open");
		mi13.setText("Save");
		mi14.setText("Exit");

		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		mi14.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi11)) {
			new0();
		}
		if (e.getSource().equals(mi12)) {
			open();
		}
		if (e.getSource().equals(mi13)) {
			save();
		}
		if (e.getSource().equals(mi14)) {
			exit();
		}
	}

	public abstract void start();

	public abstract void tick();

	public abstract void render();

	public abstract void debug();

	public abstract void dispose();

	public abstract void new0();

	public abstract void open();

	public abstract void save();

	public abstract void exit();
}
