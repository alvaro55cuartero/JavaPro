package test.calculator;

public class Main {

	String txt = "1 + 2";

	String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	String[] letra = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public static void main(String[] args) {

		Main main = new Main();

		// main.procesar(main.txt);

		System.out.println(combi(30, 20));

	}

	public void procesar(String s) {

		int r = 0;

		String[] temp = s.split("\\+");

		for (int i = 0; i < temp.length; i++) {
			if (isNumero(temp[i])) {
				r += numero(temp[i]);
			}
		}

		System.out.println("Resultado: " + r);
	}

	public boolean isNumero(String s) {

		for (int i = 0; i < numeros.length; i++) {
			if (s.contains(numeros[i])) {
				return true;
			}
		}

		return false;

	}

	public double numero(String s) {
		if (s.contains(" ")) {
			s = s.trim();
		}
		return Integer.parseInt(s);
	}

	public boolean isLetra(String s) {

		for (int i = 0; i < letra.length; i++) {
			if (s.contains(letra[i])) {
				return true;
			}
		}

		return false;

	}

	public static double combi(int x, int y) {
		return fac(x, y) / fac(x - y);
	}

	public static double fac(int x) {
		int r = 1;
		for (int i = 1; i < x + 1; i++) {
			r *= i;
		}
		return r;
	}

	public static double fac(int x, int y) {
		double r = 1;
		for (int i = y; i < x + 1; i++) {
			r *= i;
		}
		return r;
	}

	public void a() {
		double r = 0;
		double p = 0.89325;
		
		for(int i = 20; i < 31; i++) {
			r += Math.pow((1-p),30-i) * Math.pow(p, i) * combi()
		}
	}

}
