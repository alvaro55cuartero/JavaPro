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
	JPanel area;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	Lienzo lienzo;

	Plot plot;

	int[] amp = { 2147483647 };
	int[] frec = { 880 };

	Nota nota = new Nota(amp, frec, 100000, 50000);

	public ProMusic() {

		musica = new Musica(50000);
		panel = new JPanel();
		menuBar = new JMenuBar();
		menu = new JMenu();
		area = new JPanel();
		menuItem = new JMenuItem();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		lienzo = new Lienzo(500, 500);
		plot = new Plot(500, 500);

		panel.setLayout(new BorderLayout());

		menu.setText("hola");

		menuItem1.setText("root");
		menuItem1.addActionListener(this);

		menuItem.setText("Guardar");
		menuItem.addActionListener(this);

		menu.add(menuItem);
		menu.add(menuItem1);
		menuBar.add(menu);
		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(lienzo.getCanvas(), BorderLayout.CENTER);
		panel.setVisible(true);
		Ventana.getFrame().add(panel);
		Ventana.getFrame().pack();

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

	public void dispose() {

	}

	public void actionPerformed(ActionEvent e) {
		if (menuItem.equals(e.getSource())) {
			random(4);
			if (Const.DebugMode) {
				System.out.println("click");
			}
		}
		if (menuItem1.equals(e.getSource())) {
			plot.setData(nota.data);
			double[] data = nota.getData();
			// musica.play(data, 0, data.length);
			if (Const.DebugMode) {
				System.out.println("click");
			}
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
