package programas.physycs;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;
import test.neural.Tools;

public class Cuadrado extends ObjPhy {

	public Point2D.Double[] points = new Point2D.Double[4];

	public Point2D.Double pos;
	public Point2D.Double dir;

	public double lado;

	public Cuadrado(double lado, Point2D.Double pos, boolean focus, String name) {
		super(pos, null, name, focus, focus, lado);
		this.pos = pos;
		this.lado = lado;
		this.dir = new Point2D.Double(1, 0);
		centrar();
	}

	public void tick(Raton raton, Teclado teclado) {
		centrar();
	}

	public void render(Graphics g) {

		g.fillPolygon(Tools.poligonGetX(points), Tools.poligonGetY(points), points.length);

	}

	public void centrar() {
		points[0] = new Point2D.Double(pos.getX() + lado / 2, pos.getY() + lado / 2);
		points[1] = new Point2D.Double(pos.getX() + lado / 2, pos.getY() - lado / 2);
		points[2] = new Point2D.Double(pos.getX() - lado / 2, pos.getY() - lado / 2);
		points[3] = new Point2D.Double(pos.getX() - lado / 2, pos.getY() + lado / 2);

		Tools.rotar(points, Math.toDegrees(Tools.angle(dir)), pos);
	}
}
