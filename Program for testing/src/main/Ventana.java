package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Raton;
import control.Teclado;

public class Ventana {
	private static JFrame frame;

	public static void start(Teclado teclado, Raton raton) {
		frame = new JFrame();
		frame.setTitle(Const.Name);
		frame.setSize(Const.Width, Const.Height);
		frame.setPreferredSize(new Dimension(Const.Width, Const.Height));
		frame.addKeyListener(teclado);
		frame.addMouseListener(raton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK);

	}

	public static JFrame getFrame() {
		return frame;
	}
}