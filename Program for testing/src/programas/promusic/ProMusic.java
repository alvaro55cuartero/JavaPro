package programas.promusic;

import java.awt.BorderLayout;
import java.awt.Color;
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
import main.Ventana;
import tools.Plot;

public class ProMusic extends Program implements ActionListener {

	Musica musica;
	JPanel panel;
	JMenuBar menuBar;

	JMenu m1;
	JMenu m2;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;

	Lienzo lienzo;

	Plot plot;

	int[] amp = { 2147483647 };
	int[] frec = { 880 };

	Nota nota = new Nota(amp, frec, 100000, 50000);

	public ProMusic() {

		musica = new Musica(50000);
		panel = new JPanel();
		menuBar = new JMenuBar();

		m1 = new JMenu();
		m2 = new JMenu();

		mi11 = new JMenuItem();
		mi12 = new JMenuItem();
		mi13 = new JMenuItem();

		mi21 = new JMenuItem();
		mi22 = new JMenuItem();
		mi23 = new JMenuItem();

		lienzo = new Lienzo(500, 500);
		plot = new Plot(500, 500);

		panel.setLayout(new BorderLayout());

		m1.setText("File");
		m2.setText("Mode");

		mi11.setText("Guardar");
		mi12.setText("root");

		mi21.setText("Notas");
		mi22.setText("Frec");

		mi11.addActionListener(this);
		mi12.addActionListener(this);

		mi21.addActionListener(this);
		mi22.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);

		m2.add(mi21);
		m2.add(mi22);

		menuBar.add(m1);
		menuBar.add(m2);
		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(lienzo.getCanvas(), BorderLayout.CENTER);
		panel.setVisible(true);
		Ventana.getFrame().add(panel);

	}

	public void start() {

	}

	public void tick() {

	}

	public void render() {
		lienzo.renderStart();
		lienzo.getG().setColor(Color.green);
		plot.render(lienzo.getG());
		lienzo.getG().setColor(Color.black);
		lienzo.renderEnd();
	}

	public void debug() {

	}

	public void dispose() {

	}

	public void actionPerformed(ActionEvent e) {
		if (mi11.equals(e.getSource())) {
			random(4);
			if (Const.DebugMode) {
				System.out.println("click");
			}
		} else if (mi12.equals(e.getSource())) {
			plot.setData(nota.data);
			double[] data = nota.getData();
			// musica.play(data, 0, data.length);
			if (Const.DebugMode) {
				System.out.println("click");
			}
		} else if (e.getSource().equals(mi21)) {

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

}
