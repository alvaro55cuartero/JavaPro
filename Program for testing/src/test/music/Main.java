package test.music;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main implements ActionListener {

	Musica musica;
	JFrame frame;
	JPanel panel;
	JPanel area;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JMenuItem menuItem1;
	JMenuItem menuItem2;

	public Main() {
		musica = new Musica(50000);
		frame = new JFrame();
		panel = new JPanel();
		menuBar = new JMenuBar();
		menu = new JMenu();
		area = new JPanel();
		menuItem = new JMenuItem();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();

		frame.setTitle("Music");
		// frame.setLocationRelativeTo(null);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(new BorderLayout());

		menu.setText("hola");

		menuItem.setText("root");
		menuItem.addActionListener(this);

		menuItem.setText("Guardar");
		menuItem.addActionListener(this);

		menu.add(menuItem);
		menuBar.add(menu);
		panel.add(menuBar, BorderLayout.BEFORE_FIRST_LINE);

		frame.add(panel);

		panel.setVisible(true);
		frame.setVisible(true);

		// for (int i = 0; i < 4096; i++) {
		// System.out.println(Integer.toString(i, 2));
		// }
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (menuItem.equals(e.getSource())) {
			random(4);
			System.out.println("click");
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