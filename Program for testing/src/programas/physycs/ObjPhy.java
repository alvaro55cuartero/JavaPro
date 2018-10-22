package programas.physycs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;
import main.Obj;

public class ObjPhy extends Obj {

	public double masa;

	public boolean gravedad;

	public ObjPhy(int id, Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, Color color,
			double masa) {
		super(id, pos, dim, name, focus, vis, color);
		this.masa = masa;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {

	}
}
