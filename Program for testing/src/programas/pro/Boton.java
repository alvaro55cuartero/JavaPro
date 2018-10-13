package programas.pro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;

public class Boton extends Obj {

	public boolean press = false;

	public Boton(int id, Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, Color color) {
		super(id, pos, dim, name, focus, vis, color);
	}

	public void tick(Raton raton, Teclado teclado) {
		if (raton.isClick() && focus) {
			press = !press;
		}
	}

	public void render(Graphics g) {
		if (vis) {
			if (press) {
				g.setColor(color.darker());
			} else {
				g.setColor(color);
			}
			g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
			g.setColor(color.black);

			// agregar un metodo para centrar el texto
			g.drawString(name, (int) pos.x + 15, (int) pos.y + 15);
		}
	}

}
