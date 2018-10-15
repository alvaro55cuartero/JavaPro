package tools;

import java.util.ArrayList;

public class Binario {

	public static void main(String[] args) {

		String[] a = grupus(rellenar(toBin(GenInt(4096)), 12));
		print(a);
		// print(escalas(a, "100101010010"));
	}

	public static String[] grupus(String[] a) {

		int cont = 0;
		for (int i = 0; i < 13; i++) {
			cont += eqPos(grupo(a, i)).length;
		}
		String[] b = new String[cont];
		cont = 0;
		for (int i = 0; i < 13; i++) {
			String[] txt = eqPos(grupo(a, i));
			for (int j = 0; j < txt.length; j++) {
				b[cont] = txt[j];
				cont++;
			}
		}

		System.out.println("Grupus echo");

		return b;
	}

	public static String[] escalas(String[] txt, String s) {
		int c = 0;
		for (int i = 0; i < txt.length; i++) {
			if (inside2(txt[i], s)) {
				c++;
			}
		}
		String[] l = new String[c];
		c = 0;
		for (int i = 0; i < txt.length; i++) {
			if (inside2(txt[i], s)) {
				l[c] = txt[i];
				c++;
			}
		}
		return l;
	}

	public static boolean inside2(String a, String b) {
		boolean bool = false;
		for (int i = 0; i < 12; i++) {
			a = rotar(a);
			if (inside(a, b)) {
				bool = true;
			}
		}
		return bool;
	}

	public static boolean inside(String a, String b) {
		boolean bool = true;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '1') {
				if (b.charAt(i) != '1') {
					bool = false;
				}
			}
		}
		return bool;
	}

	// rellenar un array de intcon numeros consecutivos de 0 a A

	public static int[] GenInt(int a) {

		int[] r = new int[a];
		for (int i = 0; i < a; i++) {
			r[i] = i;
		}
		System.out.println("Get Int echo!");
		return r;
	}

	public static String[] toCode(String[] s) {
		String[] txt = new String[s.length];
		for (int i = 0; i < s.length; i++) {
			txt[i] = toCode(s[i]);
		}
		return txt;
	}

	public static String toCode(String s) {
		char[] txt = s.toCharArray();
		int cont = contUnos(s);
		int[] a = zeros(cont);
		char[] b = new char[cont];
		int c = -1;
		if (cont > 0) {
			for (int i = 0; i < s.length(); i++) {

				if (txt[i] == '1') {
					c++;
					a[c] = 0;
				}
				if (txt[i] == '0') {
					a[c]++;
				}
			}
			for (int i = 0; i < a.length; i++) {
				b[i] = Integer.toString(a[i]).charAt(0);
			}
		} else {
			return "0";
		}

		return new String(b);
	}

	public static int[] zeros(int a) {
		int[] b = new int[a];
		for (int i = 0; i < a; i++) {
			b[i] = 0;
		}
		return b;
	}

	public static int contUnos(String a) {
		int c = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '1') {
				c++;
			}
		}
		return c;
	}

	// Devuelve un Array de Strings convirtiendo los numeros del array de int a
	// binario

	public static String[] toBin(int[] a) {

		String[] r = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			r[i] = Integer.toBinaryString(a[i]);
		}
		System.out.println("To Bin echo!");
		return r;
	}

	public static String[] eqPos(String[] a) {
		int c = 0;
		boolean bool = true;
		for (int i = 0; i < a.length; i++) {
			bool = true;
			for (int j = i + 1; j < a.length; j++) {
				String f = a[i];
				for (int k = 0; k < 12; k++) {
					if (f.matches(a[j])) {
						bool = false;
					}
					f = rotar(f);
				}
			}

			if (bool) {
				c++;
			}
		}

		String[] s = new String[c];
		c = 0;
		for (int i = 0; i < a.length; i++) {
			String f = a[i];
			bool = true;
			for (int j = i + 1; j < a.length; j++) {
				for (int k = 0; k < 12; k++) {
					if (f.matches(a[j])) {
						bool = false;
					}
					f = rotar(f);
				}
			}

			if (bool) {
				s[c] = f;
				c++;
			}
		}

		return s;
	}

	// desplaza un bit

	public static String rotar(String s) {
		String b = "";
		char[] a = s.toCharArray();
		char c;

		c = a[0];
		for (int i = 1; i < a.length; i++) {
			a[i - 1] = a[i];
		}
		a[a.length - 1] = c;
		b = new String(a);

		return b;
	}

	// rellena con ceros a la izquierda hasta tener b cifras

	public static String[] rellenar(String[] a, int b) {
		String[] r = new String[a.length];

		for (int i = 0; i < a.length; i++) {
			int dif = b - size(a[i]);
			r[i] = a[i];
			if (dif > 0) {

				for (int j = 0; j < dif; j++) {
					r[i] = "0" + r[i];
				}
			}
		}
		System.out.println("Rellenar echo!");
		return r;
	}

	// devuelve un array con el numero de unos especificadopor el parametro b

	public static String[] grupo(String[] s, int a) {
		int c = 0;
		for (int i = 0; i < s.length; i++) {
			if (unos(s[i]) == a) {
				c++;
			}
		}

		String[] r = new String[c];
		c = 0;
		for (int i = 0; i < s.length; i++) {
			if (unos(s[i]) == a) {
				r[c] = s[i];
				c++;
			}
		}
		System.out.println("Grupo " + a + " echo!");
		return r;
	}

	// cuenta el numero de un string

	public static int unos(String a) {
		int c = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '1') {
				c++;
			}
		}
		return c;
	}

	public static int size(String a) {
		int r = a.length();
		return r;
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("" + a[i]);
		}
	}

	public static void print(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static byte[][] binario(int a) {
		byte[][] b = new byte[(int) Math.pow(2, a)][12];

		for (int i = 1; i < b.length; i++) {
			b[i] = by(b[i - 1]);
		}

		return b;
	}

	public static byte[] by(byte[] b) {
		byte[] k = new byte[12];
		byte[] uno = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int f;

		int c = 0;
		for (int i = 0; i < 12; i++) {

			f = bu(b[i], uno[i], c);
			c = 0;
			if (f == 0) {
				k[i] = 0;

			} else if (f == 1) {
				k[i] = 1;

			} else if (f == 2) {
				k[i] = 0;
				c = 1;
			} else {
				k[i] = 1;
				c = 1;
			}
		}
		return k;
	}

	public static int bu(byte a, byte b, int c) {
		return a + b + c;
	}

	public byte[][] rep(byte[][] k) {
		ArrayList<byte[]> ok = new ArrayList<byte[]>();

		for (int i = 0; i < Math.pow(2, 12); i++) {
			ok.add(k[i]);
		}

		for (int i = 0; i < Math.pow(2, 12); i++) {

			byte[] h = shift(ok.get(i));

			for (int j = 0; j < 10; j++) {

				shift(h);

			}

		}

		return null;

	}

	public static byte[] shift(byte[] k) {

		byte[] p = new byte[k.length];

		for (int i = 1; i < p.length; i++) {
			p[i] = k[i - 1];
		}
		p[0] = k[k.length - 1];

		return p;
	}

}
