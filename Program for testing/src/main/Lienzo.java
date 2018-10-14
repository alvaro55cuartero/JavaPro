package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Lienzo {

	private BufferStrategy bs;
	private Graphics g;
	private Canvas canvas;
	private int ancho;
	private int alto;

	public Lienzo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		canvas = new Canvas();

		canvas.setIgnoreRepaint(true);
		canvas.setPreferredSize(new Dimension(ancho, alto));
		canvas.addMouseListener(Main.raton);
		canvas.addKeyListener(Main.teclado);
		canvas.setFocusable(true);
		canvas.requestFocus();
	}

	public void renderStart() {
		if (bs == null) {
			canvas.createBufferStrategy(3);
			bs = canvas.getBufferStrategy();
		}
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ancho, alto);
	}

	public void renderEnd() {
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public Graphics getG() {
		return g;
	}
}