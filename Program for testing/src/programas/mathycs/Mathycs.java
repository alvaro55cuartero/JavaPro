package programas.mathycs;

import java.awt.Point;

public class Mathycs {

	public static Point.Double cuadrada(double a, double b, double c) {
		Point.Double p = new Point.Double();
		p.setLocation((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a,
				(-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a);
		return p;
	}

	public static byte[] add(byte[] b, byte[] a) {
		byte[] c;
		if (a.length < b.length) {
			c = new byte[b.length];

		} else {
			c = new byte[a.length];
		}

		for (int i = 0; i < c.length; i++) {
			if (i > a.length) {
				c[i] = b[i];
			} else if (i > b.length) {
				c[i] = a[i];
			} else {
				c[i] = (byte) ((b[i] + a[i]) / 2);
			}
		}

		return c;
	}
}
