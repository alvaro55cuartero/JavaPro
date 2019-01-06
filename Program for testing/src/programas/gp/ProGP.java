package programas.gp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Const;
import main.Lienzo;
import main.Program;
import main.Renderer;
import main.Ventana;

public class ProGP extends Program implements Renderer, ActionListener {

	ArrayList<Block> blocks = new ArrayList<Block>();
	Lienzo lienzo;
	Object[] options = { "block" };

	JPanel panel;
	JMenuBar bar;
	JMenu m1;
	JMenu m2;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;
	JMenuItem mi14;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;
	JMenuItem mi24;

	public ProGP() {
		Ventana.getFrame().getContentPane().removeAll();
		panel = new JPanel();

		bar = new JMenuBar();

		m1 = new JMenu();
		m1.setText("File");

		m2 = new JMenu();
		m2.setText("Edit");

		mi11 = new JMenuItem();
		mi11.setText("New");
		mi11.addActionListener(this);

		mi12 = new JMenuItem();
		mi12.setText("Open");
		mi12.addActionListener(this);

		mi13 = new JMenuItem();
		mi13.setText("Guardar");
		mi13.addActionListener(this);

		mi14 = new JMenuItem();
		mi14.setText("Exit");
		mi14.addActionListener(this);

		mi21 = new JMenuItem();
		mi21.setText("Block");
		mi21.addActionListener(this);

		mi22 = new JMenuItem();
		mi22.setText("Open");
		mi22.addActionListener(this);

		mi23 = new JMenuItem();
		mi23.setText("Guardar");
		mi23.addActionListener(this);

		mi24 = new JMenuItem();
		mi24.setText("Exit");
		mi24.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);

		m2.add(mi21);
		m2.add(mi22);
		m2.add(mi23);
		m2.add(mi24);

		bar.add(m1);
		bar.add(m2);

		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		lienzo = new Lienzo(Const.Width, Const.Height);
		lienzo.setRenderer(this);
		Ventana.getFrame().add(bar, BorderLayout.NORTH);
		Ventana.getFrame().add(lienzo, BorderLayout.CENTER);
		Ventana.getFrame().pack();

	}

	public void start() {

	}

	public void tick() {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).tick();
		}

	}

	public void render() {

	}

	public void debug() {

	}

	public void dispose() {

	}

	public void render(Graphics2D g) {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
		g.setColor(Color.red);
		g.drawRect(10, 10, 200, 200);

	}

	private void create() {
		int n = JOptionPane.showOptionDialog(null, "selecciona un block", "selector", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n != -1) {
			blocks.add(new Block(0, new Point2D.Double(100, 100), new Point2D.Double(100, 100), "block", true, false, 1,
					1));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi21)) {
			create();
		}

	}

}
