package programas.pro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import control.Raton;
import control.Tecla;
import control.Teclado;
import main.Const;
import main.Lienzo;
import main.Program;
import main.Ventana;
import test.mathycs.PointB;
import tools.Lector;

public class Pro extends Program {

	Lienzo lienzo = new Lienzo(Const.Width, Const.Height);

	// El ArrayList comandos se encarga de guardar los comandos que se ejecutaran
	// una vez por tick

	ArrayList<String> comandos = new ArrayList<String>();

	// El ArrayList hijos se encarga de guardar las ralaciones entre los objetos del
	// arraylist objetos

	static ArrayList<PointB> hijos = new ArrayList<PointB>();

	// el ArrayList tipos se encarga de guarda un ejemplar de cada tipo

	static ArrayList<Tipo> tipos = new ArrayList<Tipo>();

	// el ArrayList objetos se encarga de guarda cada uno de los tipos con sus
	// variables

	static ArrayList<Tipo> objetos = new ArrayList<Tipo>();

	static String[] primitivo = { "Int", "Dou", "Bool", "String", "Color" };

	String[] palabraClave = { "if", "and", "or", "then", "==" };

	Teclado teclado;
	Raton raton;

	int focusObj;

	// Constructor

	public Pro() {
		super();
		Ventana.getFrame().add(lienzo.getCanvas());

		tipos.add(new Tipo("program"));

		objetos.add(tipos.get(findTipo("program")));

		// tickHijos();
	}

	// funciones de tick

	public void tick() {
		// tickObjetos(raton, teclado);
		// focus(raton);
		tickTipos();
	}

	// funciones de renderizado

	public void render() {
		lienzo.renderStart();

		renderObjetos(lienzo.getG());
		// objetos.get(focusObj).rendFocus(g);
		dibujo(lienzo.getG(), 50, 40);

		for (int i = 0; i < objetos.size(); i++) {
			lienzo.getG().drawString(objetos.get(i).tipo, 500, 100 + (20 * i));
		}
		for (int i = 0; i < objetos.size(); i++) {
			// g.drawString(objetos.get(i).shape[0].toString(), 500, 100 + (20 * i));
		}
		lienzo.getG().drawString("" + focusObj, 50, 10);

		lienzo.renderEnd();

	}

	public void dibujo(Graphics g, int x, int y) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < tipos.size(); i++) {
			y = rend(g, x, y, tipos.get(i));
			y += 20;
		}
	}

	public int rend(Graphics g, int x, int y, Object tipo) {

		if (tipo instanceof Tipo) {
			g.drawString(((Tipo) tipo).tipo, x, y);
		} else {
			// g.drawString(((Var) tipo).tipo, x, y);
		}

		y += 20;
		Var var = null;
		for (int i = 0; i < ((Tipo) tipo).var.length; i++) {
			var = ((Tipo) tipo).var[i];
			if (var.valor instanceof Tipo) {
				y = rend(g, x + 10, y, ((Tipo) tipo).var[i].valor);
			} else {
				g.drawString(var.name + "  " + var.valor, x + 10, y);
				y += 20;
			}
		}
		return y;
	}

	private void renderObjetos(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).render(g2);
		}
	}

	private void tickTipos() {
		for (int i = 0; i < tipos.size(); i++) {
			tipos.get(i).tick();
		}
	}

	// private void tickObjetos(Raton raton, Teclado teclado) {
	// for (int i = 0; i < objetos.size(); i++) {
	// objetos.get(i).tick(raton, teclado);
	// }
	// }

	// private void focus(Raton raton) {
	// boolean temp = true;
	// for (int i = 0; i < objetos.size(); i++) {
	// if (tools.Tools.inside(raton.getPD(), objetos.get(i)) && objetos.get(i).vis)
	// {
	// focusObj = i;
	// temp = false;
	// }
	// objetos.get(i).focus = false;
	// }
	// if (temp) {
	// focusObj = 0;
	// }
	// objetos.get(focusObj).focus = true;
	// }

	// funciones de programa

	private void comando(String frase, String linea) {
		String[] palabra = frase.split("\\.");
		int indice = findTipo(palabra[0]);

		if (indice != -1) {
			frase = frase.substring(palabra[0].length() + 1);
			// objComand(frase, objetos.get(indice));
		} else {
			switch (palabra[0]) {
			case "hijo":
				// hijos.add(new PointB(findId(palabra[1]), findId(palabra[2])));
				break;

			case "loop":
				if (palabra[1].matches("add")) {
					String[] temp = linea.split("loop.add ");
					comandos.add(temp[1]);
					break;

				} else if (palabra[1].matches("remove")) {
					comandos.remove(operacion(palabra[2], 0));
					break;
				}
				break;

			case "create":
				try {
					Lector.createFile("res/" + palabra[1] + ".txt", "");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "ejecutar":
				// ejecutar(((Txt) objetos.get(findId(palabra[1]))).txt);
				break;

			case "escribir":
				String[] temp = linea.split("\\.");

				if (temp[2].matches("linen")) {
					try {
						Lector.salto(temp[1]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						Lector.createFile("res/" + temp[1] + ".txt", temp[2]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;

			case "leer":

				break;

			case "lista":
				String[] emp = Lector.lista("res");

				for (int i = 0; i < emp.length; i++) {
					System.out.println(emp[i].toString());
				}

			case "abrir":
				// try {
				// ((Txt) objetos.get(findId(palabra[1]))).txt += Lector
				// .leerArchivoTexto("res/" + palabra[2] + ".txt");
				//
				// } catch (IOException e) {
				// e.printStackTrace();
				// }

				break;

			case "debug":

				break;

			case "math":
				// ejecutar(((Txt) objetos.get(findId(palabra[1]))).txt);
				break;
			}
		}
	}

	private boolean bool(String s, boolean bool) {
		boolean b = false;

		switch (s) {
		case "true":
			b = true;
			break;
		case "false":
			b = false;
			break;
		case "change":
			b = !bool;
			break;
		}

		return b;
	}

	private void palabraClave(String linea) {
		String[] frase = linea.split(" ");
		boolean condicion = false;
		boolean bool = false;
		boolean and = false;
		boolean or = false;
		boolean temp = false;
		boolean not = false;

		for (int i = 0; i < frase.length; i++) {

			switch (frase[i]) {
			case "if":
				condicion = true;
				break;

			case "then":
				condicion = false;
				break;

			case "and":
				and = true;
				break;

			case "or":
				or = true;
				break;

			case "not":
				not = true;
				break;

			default:

				if (condicion) {
					if (and) {
						// temp = boolX(frase[i], not);
						bool = bool && temp;
						temp = false;
						and = false;
					} else if (or) {
						// temp = boolX(frase[i], not);
						bool = bool || temp;
						temp = false;
						or = false;
					} else {
						// bool = boolX(frase[i], not);
					}
				} else if (bool) {
					String[] s = linea.split("then ");
					comando(frase[i], s[1]);
				}
			}
		}
	}

	// private boolean boolX(String frase, boolean not) {
	// boolean bool = condicional(frase);
	//
	// if (not) {
	// return !bool;
	// }
	// return bool;
	// }

	// private void tickHijos() {
	// for (int i = 0; i < hijos.size(); i++) {
	// hijos(i);
	// }
	// }

	// private void hijos(int a) {
	// for (int j = 0; j < hijos.size(); j++) {
	// if ((int) hijos.get(j).x == a) {
	// objetos.get((int) hijos.get(j).y).vis = objetos.get(a).vis;
	// }
	// }
	// }

	// transforma una string en un numero;

	private int numero(String s) {
		if (s.matches("ancho")) {
			return Const.Width;
		}
		if (s.matches("alto")) {
			return Const.Height;
		}

		return Integer.parseInt(s);
	}

	// transforma una operacion en un numero

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

	// private boolean condicional(String frase) {
	// String[] palabra = frase.split("\\.");
	// boolean bool = false;
	// int indice = findId(palabra[0]);
	//
	// if (indice != -1) {
	// switch (palabra[1]) {
	// case "vis":
	// return objetos.get(indice).vis;
	// case "press":
	// return ((Boton) objetos.get(indice)).press;
	// }
	// } else {
	//
	// switch (palabra[0]) {
	// case "key":
	// bool = key(palabra[1]);
	// break;
	// }
	// }
	//
	// return bool;
	//
	// }

	private boolean key(String txt) {
		switch (txt) {
		case "tE":
			if (teclado.tE.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tEnter":
			if (teclado.tEnter.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tN":
			if (teclado.tN.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tEsc":

			if (teclado.tEsc.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tA":
			if (teclado.tA.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tS":
			if (teclado.tS.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tD":
			if (teclado.tD.isReleased(Tecla.t)) {
				return true;
			}
			break;
		case "tW":

			if (teclado.tW.isReleased(Tecla.t)) {
				return true;
			}
			break;
		}
		return false;
	}

	// devuelve true si el parametro de tipo String se encuntra
	// en el array standar

	public static boolean isPrimitivo(String s) {
		for (int i = 0; i < primitivo.length; i++) {
			if (s.matches(primitivo[i])) {
				return true;
			}
		}
		return false;
	}

	public static String primitivo(String s) {
		for (int i = 0; i < primitivo.length; i++) {
			if (s.matches(primitivo[i])) {
				return primitivo[i];
			}
		}
		return "";
	}

	public static boolean isTipo(String s) {
		for (int i = 0; i < tipos.size(); i++) {
			if (s.matches(tipos.get(i).tipo)) {
				return true;
			}
		}
		return false;
	}

	// devuelve la posicion dentro del array si el parametro
	// de tipo String se encuntra en el arraylist objetos

	// private Obj findObj(int a) {
	// for (int i = 0; i < objetos.size(); i++) {
	// if (objetos.get(i).id == a)) {
	// return objetos;
	// }
	// }
	// return -1;
	// }

	// private int findId(String s) {
	// for (int i = 0; i < objetos.size(); i++) {
	// if (objetos.get(i).name.matches(s)) {
	// return i;
	// }
	// }
	// return -1;
	// }

	private int findPrimitivo(String s) {
		for (int i = 0; i < primitivo.length; i++) {
			if (s.matches(primitivo[i])) {
				return i;
			}
		}
		return -1;
	}

	public static int findTipo(String s) {
		for (int i = 0; i < tipos.size(); i++) {
			if (tipos.get(i).tipo.matches(s)) {
				return i;
			}
		}
		return -1;
	}

	// devuelve true si el parametro de tipo String se encuntra
	// en el array palabraClave

	private boolean isPalabraClave(String s) {
		for (int i = 0; i < palabraClave.length; i++) {
			if (palabraClave[i].matches(s)) {
				return true;
			}
		}
		return false;
	}

	public void start() {

	}

	public void debug() {

	}

	public void dispose() {

	}
}
