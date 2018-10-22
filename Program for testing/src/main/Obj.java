package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;

public class Obj {

	public int id;

	public Point2D.Double pos;
	public Point2D.Double dim;

	public Color color;

	public String name;

	public boolean vis;
	public boolean focus;

	public Obj(int id, Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, Color color) {
		this.id = id;
		this.pos = pos;
		this.dim = dim;
		this.name = name;
		this.vis = vis;
		this.focus = focus;
		this.color = color;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {

	}

	public void rendFocus(Graphics g) {
		g.setColor(Color.black);
		g.drawOval((int) pos.getX(), (int) pos.getY(), 5, 5);
		g.setColor(Color.green);
		g.fillOval((int) pos.getX(), (int) pos.getY(), 5, 5);
	}

}
