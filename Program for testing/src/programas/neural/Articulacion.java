package programas.neural;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;

public class Articulacion {

	Point2D.Double pos;

	public Articulacion(Point2D.Double pos) {
		this.pos = pos;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		g.fillOval((int) pos.x, (int) pos.y, 5, 5);
	}

}
