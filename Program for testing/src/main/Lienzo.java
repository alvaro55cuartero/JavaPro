package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private BufferStrategy bs;
	private Graphics2D g;
	private Canvas canvas;
	private int ancho;
	private int alto;
	private Renderer renderer;

	public Lienzo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		this.setBackground(Color.BLACK);

	}

	public void paint(Graphics graphics) {
		super.paint(graphics);
		g = (Graphics2D) graphics;
		renderer.render(g);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setRenderer(Object o) {
		renderer = (Renderer) o;
	}

	public Graphics getG() {
		return g;
	}
}