package test.otros;

public class Bloqueos {

	static double k;

	static double a;

	public static void main(String[] args) {

		a = 5.76;
		k = 8;
		bak();

	}

	public static void brk() {

	}

	public static void bak() {

		double ex = Math.pow(a, k) / fac(k);

		double acon = 0;

		for (int i = 0; i < k + 1; i++) {
			acon += Math.pow(a, i) / fac(i);

		}

		System.out.println(ex / acon);

	}

	public static double fac(double a) {

		double r = 1;

		for (int i = 1; i < a + 1; i++) {
			r = r * i;
		}
		return r;
	}
}
