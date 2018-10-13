package test.mathycs;

public class Ecuacion {

	public String text;

	public Ecuacion() {

	}

	public static boolean isEcu(String txt) {
		if (txt.contains("=")) {
			return true;
		} else {
			return false;
		}
	}

	public static String[] palabras(String txt) {
		return txt.split(" ");
	}

}
