package programas.promusic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.Const;
import main.Lienzo;
import main.Program;
import main.Renderer;
import main.Ventana;
import tools.Plot;

public class ProMusic extends Program implements ActionListener, Renderer {

	Musica musica;
	JPanel panel;
	JMenuBar menuBar;

	JMenu m2;

	JMenuItem mi21;
	JMenuItem mi22;

	Lienzo lienzo;

	Plot plot;

	int[] amp = { 2147483647 };
	int[] frec = { 880 };

	Nota nota = new Nota(amp, frec, 100000, 50000);

	public ProMusic() {
		Ventana.getFrame().getContentPane().removeAll();

		musica = new Musica(50000);
		panel = new JPanel();
		menuBar = new JMenuBar();

		m2 = new JMenu();

		mi21 = new JMenuItem();
		mi22 = new JMenuItem();

		lienzo = new Lienzo(500, 500);
		plot = new Plot(500, 500);

		panel.setLayout(new BorderLayout());

		m2.setText("Mode");

		mi21.setText("Notas");
		mi22.setText("Frec");

		mi21.addActionListener(this);
		mi22.addActionListener(this);

		m2.add(mi21);
		m2.add(mi22);

		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(lienzo, BorderLayout.CENTER);
		panel.setVisible(true);
		Ventana.getFrame().add(panel);
		Ventana.getFrame().pack();

	}

	public void start() {
	}

	public void tick() {
	}

	public void render(Graphics2D g) {
		g.setColor(Color.green);
		plot.render(g);
		g.fillRect(40, 30, 30, 40);
		g.setColor(Color.black);
	}

	public void debug() {
	}

	public void dispose() {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi21)) {

		}
	}

	public void func1() {
		random(4);
		if (Const.DebugMode) {
			System.out.println("click");
		}
	}

	public void func2() {
		plot.setData(nota.data);
		double[] data = nota.getData();
		// musica.play(data, 0, data.length);
		if (Const.DebugMode) {
			System.out.println("click");
		}
	}

	public void random(int a) {
		for (int i = 0; i < a; i++) {
			byte[] cancion = musica.binToChord(0, Acorde.rand(), 100000);
			musica.play(cancion, 0, cancion.length);
			byte[] slice = Arrays.copyOfRange(cancion, 0, 5000);
			plot.setData(slice);

		}
		// musica.stopLine();
	}

	public void render() {
	}

	public void new0() {
	}

	public void open() {
	}

	public void save() {
	}

	public void exit() {
	}
}