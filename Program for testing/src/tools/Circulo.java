package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import test.control.Raton;
import test.control.Teclado;

public class Circulo {

	Point pos;

	public Circulo(Point pos) {
		this.pos = pos;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawOval(pos.x - 5, pos.y - 5, 10, 10);
	}
}
