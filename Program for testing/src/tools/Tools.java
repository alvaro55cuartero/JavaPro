package tools;

import java.awt.Point;
import java.awt.geom.Point2D;

import main.Obj;

public class Tools {

	public static boolean between(double a, double b, double c) {
		boolean var = false;
		if (a > b && a < c) {
			var = true;
		}
		return var;
	}

	public static boolean inside(Point2D.Double p, Point2D.Double pos, Point2D.Double dim) {
		boolean r = false;
		if (between(p.getX(), pos.getX(), pos.getX() + dim.getX())
				&& between(p.getY(), pos.getY(), pos.getY() + dim.getY())) {
			r = true;
		}
		return r;
	}

	public static boolean inside(Point p, Point pos, Point dim) {
		boolean r = false;
		if (between(p.getX(), pos.getX(), pos.getX() + dim.getX())
				&& between(p.getY(), pos.getY(), pos.getY() + dim.getY())) {
			r = true;
		}
		return r;
	}

	public static boolean inside(Point2D.Double p, Obj obj) {
		return inside(p, obj.pos, obj.dim);
	}

	public static boolean overlap(Obj obj1, Obj obj2) {
		boolean r = false;
		if (inside(obj1.pos, obj2)
				|| inside(new Point2D.Double(obj1.pos.getX() + obj1.dim.getX(), obj1.pos.getY() + obj1.dim.getY()),
						obj2)
				|| inside(new Point2D.Double(obj1.pos.getX(), obj1.pos.getY() + obj1.dim.getY()), obj2)
				|| inside(new Point2D.Double(obj1.pos.getX() + obj1.dim.getX(), obj1.pos.getY()), obj2)) {

			r = true;
		}
		return r;
	}
}
