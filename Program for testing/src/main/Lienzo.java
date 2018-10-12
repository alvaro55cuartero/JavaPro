package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Lienzo {

	private static BufferStrategy bs;
	private static Canvas canvas;
	private static int ancho;
	private static int alto;

	public static void start(int ancho, int alto) {
		Lienzo.ancho = ancho;
		Lienzo.alto = alto;
		canvas = new Canvas();

		canvas.setIgnoreRepaint(true);
		canvas.setPreferredSize(new Dimension(ancho, alto));
		canvas.addMouseListener(Main.raton);
		canvas.addKeyListener(Main.teclado);
		canvas.setFocusable(true);
		canvas.requestFocus();
	}

	public static void renderStart() {
		if (bs == null) {
			Lienzo.canvas.createBufferStrategy(3);
			bs = Lienzo.canvas.getBufferStrategy();
		}
		Main.g = bs.getDrawGraphics();
		Main.g.setColor(Color.BLACK);
		Main.g.fillRect(0, 0, ancho, alto);
	}

	public static void renderEnd() {
		Toolkit.getDefaultToolkit().sync();
		Main.g.dispose();
		bs.show();
	}

	public static Canvas getCanvas() {
		return canvas;
	}
}