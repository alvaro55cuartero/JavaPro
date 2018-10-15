package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana {
	private static JFrame frame;

	public static void start() {
		frame = new JFrame();
		frame.setTitle(Const.Name);
		frame.setSize(Const.Width, Const.Height);
		frame.setPreferredSize(new Dimension(Const.Width, Const.Height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);

	}

	public static JFrame getFrame() {
		return frame;
	}
}