package programas.physycs;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;
import programas.pro.Obj;

public class ObjPhy extends Obj {

	public double masa;

	public boolean gravedad;

	public ObjPhy(Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, double masa) {
		super(pos, dim, name, focus, vis);
		this.masa = masa;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {

	}
}
