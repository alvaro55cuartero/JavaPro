package programas.pro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.IOException;

import main.Const;
import tools.Lector;

public class Tipo {

	String tipo;
	String txt;

	Var[] var;
	Shape[] shape;

	boolean bool = true;

	private String text = "";

	public Tipo(String ruta) {
		tipo = ruta;
		this.txt = abrir();
		processTxt();
	}

	public Tipo(Var[] var, String tipo) {
		this.var = var;
		this.tipo = tipo;
	}

	public void processTxt() {
		text = this.txt.replace("\n", "");
		in();

		String[] varLineas = numVar(text);
		var = new Var[varLineas.length];
		rellenarVar(varLineas);

		String[] shapeLineas = numShape(text);
		shape = new Shape[shapeLineas.length];
		rellenarShape(shapeLineas);

		comandos();

		if (!text.matches("")) {
			System.out.println("Error estas funciones no se procesaron: " + text);
		}
	}

	public void tick() {

	}

	public void render(Graphics2D g) {
		for (int i = 0; i < shape.length; i++) {
			g.setColor(Color.red);
			if (shape[i] != null) {
				g.fill(shape[i]);
			} else {
				if (bool) {
					System.out.println("clase Tipo: " + tipo + " Metodo: Render  no existe una shape");
					bool = false;
				}
			}
		}
	}

	private void comandos() {
		String[] linea = text.split("\\;");
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			for (int j = 0; j < frase.length; j++) {
				String[] palabra = frase[j].split("\\.");
				if (tr2(palabra)) {
					text = text.replaceFirst(linea[i] + ";", "");
				}
			}
		}
	}

	private String[] numShape(String txt) {
		int c = 0;
		String[] linea = txt.split("\\;");
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			if (frase[0].matches("render")) {
				c++;
			}
		}

		String[] line = new String[c];
		c = 0;
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			if (frase[0].matches("render")) {
				line[c] = linea[i];
				c++;
				text = text.replaceFirst(linea[i] + ";", "");
			}
		}
		return line;
	}

	private String[] numVar(String txt) {
		int c = 0;
		String[] linea = txt.split("\\;");
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			if (Pro.isPrimitivo(frase[0]) || Pro.isTipo(frase[0])) {
				c++;
			}
		}

		String[] line = new String[c];

		c = 0;
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			if (Pro.isPrimitivo(frase[0]) || Pro.isTipo(frase[0])) {
				line[c] = linea[i];
				c++;
				text = text.replaceFirst(linea[i] + ";", "");
			}
		}
		return line;
	}

	private void rellenarShape(String[] linea) {
		int c = 0;
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");

			for (int j = 0; j < frase.length; j++) {
				String[] palabra = frase[j].split("\\,");

				switch (palabra[0]) {
				case "rect":
					if (palabra.length > 2) {
						shape[c] = new Rectangle(num(palabra[1]), num(palabra[2]), num(palabra[3]), num(palabra[4]));
					} else {
						shape[c] = new Rectangle();
					}
					c++;
					break;

				default:
					System.out.println("Error clase Tipo  |  Render:  " + palabra[0]);
				}
			}
			text = text.replaceFirst(linea[i] + ";", "");
		}
	}

	private int numero(String s) {
		if (s.matches("ancho")) {
			return Const.Width;
		}
		if (s.matches("alto")) {
			return Const.Height;
		}

		return Integer.parseInt(s);
	}

	private int num(String frase) {
		String[] palabra = frase.split("\\.");
		Var[] vr = this.var;

		for (int i = 0; i < frase.length(); i++) {
			if (findVar(palabra[i], vr) != -1) {
				if (vr[findVar(palabra[i], vr)].valor instanceof Tipo) {
					vr = ((Tipo) vr[findVar(palabra[i], vr)].valor).var;
				} else {

					return (int) Double.parseDouble(vr[findVar(palabra[i], vr)].valor.toString());
				}
			}
		}
		return 0;
	}

	private int operacion(String txt, int i) {

		int a = 0;

		if (txt.contains("+")) {
			String[] temp = txt.split("\\+");
			if (temp[0].matches("")) {
				a = i + numero(temp[1]);
			} else {
				a = numero(temp[0]) + numero(temp[1]);
			}

		} else if (txt.contains("-")) {
			String[] temp = txt.split("-");
			if (temp[0].matches("")) {
				a = i - numero(temp[1]);
			} else {
				a = numero(temp[0]) - numero(temp[1]);
			}

		} else {
			a = numero(txt);
		}

		return a;
	}

	private void rellenarVar(String[] linea) {
		int c = 0;
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");

			if (Pro.isPrimitivo(frase[0])) {
				var[c] = primitiva(frase[0], frase[1]);
				c++;
			} else if (Pro.isTipo(frase[0])) {
				var[c] = tipo(frase[0], frase[1]);
				c++;
			} else {
				System.out.println("Error clase: Tipo  Metodo: RellenarVar() No existe el tipo: " + frase[0]);
			}
		}
	}

	private Var tipo(String a, String b) {
		Object o = null;
		Var[] x = Pro.tipos.get(Pro.findTipo(a)).var;
		Var[] y = new Var[x.length];
		int c = 0;
		for (int i = 0; i < x.length; i++) {
			if (Pro.isPrimitivo(x[i].tipo)) {
				y[c] = primitiva(x[i].tipo, x[i].name);
				c++;
			} else {
				y[c] = tipo(x[i].tipo, x[i].name);
				c++;
			}
		}
		return new Var(new Tipo(y, a), b, a);
	}

	private Var primitiva(String a, String b) {
		Object o = null;
		String tipo = "";

		switch (a) {
		case "Int":
			o = new Integer(0);
			tipo = a;
			break;
		case "Dou":
			o = new Double(0);
			tipo = a;
			break;
		case "Bool":
			o = new Boolean(false);
			tipo = a;
			break;
		case "String":
			o = "";
			tipo = a;
			break;
		case "Color":
			o = Color.black;
			tipo = a;
			break;
		default:
			System.out.println("Error en la clase: Tipo  Metodo: primitiva  no existe la primitiva: " + a);
		}
		return new Var(o, b, tipo);
	}

	private boolean tr2(String[] palabra) {
		Var[] var = this.var;
		for (int i = 0; i < palabra.length; i++) {

			if (findVar(palabra[i], var) != -1) {
				if (var[findVar(palabra[i], var)].valor instanceof Tipo) {
					var = ((Tipo) var[findVar(palabra[i], var)].valor).var;
				} else {
					var[findVar(palabra[i], var)].valor = palabra[i + 1];
					return true;
				}

			}

		}
		return false;
	}

	private int findVar(String s) {
		for (int i = 0; i < var.length; i++) {
			if (s.matches(var[i].name)) {
				return i;
			}
		}
		return -1;
	}

	private int findVar(String s, Var[] var) {
		for (int i = 0; i < var.length; i++) {
			if (s.matches(var[i].name)) {
				return i;
			}
		}
		return -1;
	}

	private void in() {
		String[] linea = text.split("\\;");
		for (int i = 0; i < linea.length; i++) {
			String[] frase = linea[i].split(" ");
			if (frase[0].matches("in")) {
				if (!Pro.isTipo(frase[1])) {
					Pro.tipos.add(new Tipo(frase[1]));
				}
				text = text.replaceFirst(linea[i] + ";", "");
			}
		}
	}

	public String abrir() {
		try {
			return Lector.leerArchivoTexto("res/" + tipo + ".pro");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void guardar() {
		try {
			Lector.createFile(tipo, txt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}