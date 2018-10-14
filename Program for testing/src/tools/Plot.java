package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import main.Const;
import main.Program;

public class Plot extends Program {

	int x;
	int y;
	Point2D pos;
	int[] sin;
	int[] sin2;
	boolean bool = false;

	public Plot(int x, int y) {
		this.x = x;
		this.y = y;
		this.pos = new Point2D.Double(x, y);
		sin = sin(100, 600, 0.1);
		for (int i = 3; i < 1000; i += 2) {
			sin2 = sin(100 / i, 600, i * 0.1);
			sin = suma(sin, sin2);
		}

	}

	public void start() {

	}

	public void tick() {
		if (Tools.inside(raton.getPD(), new Point2D.Double(x - 5, y - 5), new Point2D.Double(10, 10))) {
			bool = true;
		} else {
			bool = false;
		}
		if (bool && raton.isPress()) {
			x = (int) raton.getPD().getX();
			y = (int) raton.getPD().getY();
		}
	}

	public void render() {
		g.setColor(Color.GREEN);
		g.drawLine(x, 0, x, Const.Height);
		g.drawLine(0, y, Const.Width, y);
		renderObj(g, sin);

		if (bool) {
			g.setColor(Color.red);
			g.drawRect(x - 5, y - 5, 10, 10);
		}

	}

	public int[] sin(int a, int l, double f) {
		int[] r = new int[l];
		for (int i = 0; i < l; i++) {
			r[i] = (int) (a * Math.sin(i * f));
		}
		return r;
	}

	public void renderObj(Graphics g, int[] vertex) {
		for (int i = 0; i < vertex.length - 1; i++) {
			g.drawLine(x + i, y + vertex[i], x + i + 1, y + vertex[i + 1]);
		}
	}

	public void dispose() {

	}

	private void print(int[] sin) {
		for (int i = 0; i < sin.length; i++) {
			System.out.println(sin[i]);
		}
	}

	public int[] suma(int[] a, int[] b) {
		int[] r = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			r[i] = (a[i] + b[i]);
		}
		return r;
	}
}
