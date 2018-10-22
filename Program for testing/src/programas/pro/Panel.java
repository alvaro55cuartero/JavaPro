package programas.pro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;
import main.Obj;

public class Panel extends Obj {

	public Panel(int id, Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, Color color) {
		super(id, pos, dim, name, focus, vis, color);
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		if (vis) {
			g.setColor(color);
			g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
		}
	}
}
