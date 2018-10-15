package test.mathycs;

public class Mathycs {

	public static PointB cuadrada(double a, double b, double c) {
		PointB p = new PointB();
		p.setX((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a);
		p.setY((-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a);
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

	public static int[] add(int[] a, int[] b) {
		int[] c;
		if (a.length < b.length) {
			c = new int[b.length];

		} else {
			c = new int[a.length];
		}

		for (int i = 0; i < c.length; i++) {
			if (i > a.length) {
				c[i] = b[i];
			} else if (i > b.length) {
				c[i] = a[i];
			} else {
				c[i] = (int) ((b[i] + a[i]) / 2);
			}
		}

		return c;
	}
}
