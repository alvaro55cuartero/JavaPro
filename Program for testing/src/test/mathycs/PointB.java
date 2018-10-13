package test.mathycs;

public class PointB {

	public double x;
	public double y;

	public PointB() {
	}

	public PointB(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static PointB div(PointB p, double m) {
		p.x = p.x / m;
		p.y = p.y / m;
		return p;
	}

	public static PointB sum(PointB p, PointB v) {
		p.x = p.x + v.getX();
		p.y = p.y + v.getY();
		return p;
	}

	public static PointB sub(PointB p, PointB v) {
		p.x = p.x - v.getX();
		p.y = p.y - v.getY();
		return p;
	}

	public String toString() {
		return x + " || " + y;
	}
}
