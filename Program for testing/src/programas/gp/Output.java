package programas.gp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D.Double;

import control.Raton;
import control.Teclado;
import main.Obj;

public class Output extends Obj {

	public Output(int id, Double pos, Double dim, String name, boolean focus, boolean vis) {
		super(id, pos, dim, name, focus, vis, Color.green);
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
	}
}
