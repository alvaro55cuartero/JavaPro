package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circulo {

	public Point pos;

	public Circulo(Point pos) {
		this.pos = pos;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawOval(pos.x - 5, pos.y - 5, 10, 10);
	}
}
