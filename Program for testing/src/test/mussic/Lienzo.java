package test.mussic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import test.control.Raton;
import test.control.Teclado;

public class Lienzo extends Canvas {

	private int x;
	private int y;
	private int ancho;
	private int alto;

	public Graphics g;
	BufferStrategy bs;

	Root root;

	Raton raton;
	Teclado teclado;

	public Lienzo(final int x, final int y, final int ancho, final int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;

		raton = new Raton(this);
		teclado = new Teclado();

		this.setIgnoreRepaint(true);
		this.setLocation(x, y);
		this.setPreferredSize(new Dimension(ancho, alto));
		this.addMouseListener(raton);
		this.addKeyListener(teclado);
		this.setFocusable(true);
		this.requestFocus();

		root = new Root(raton, teclado);

	}

	public void start() {
		root.start();
	}

	public void tick() {
		raton.tick(this);
		root.tick(raton, teclado);
		raton.resetClick();
		teclado.clear();
	}

	public void render() {
		bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, ancho, alto);
		raton.render(g);
		root.render(g);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}

	public void stop() {
		root.stop();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
}