package program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

import control.Raton;
import control.Tecla;
import control.Teclado;
import main.Const;
import mathycs.PointB;
import tools.Lector;

public class Program2 {

	ArrayList<Obj> objetos = new ArrayList<Obj>();
	ArrayList<String> comandos = new ArrayList<String>();
	ArrayList<PointB> hijos = new ArrayList<PointB>();

	ArrayList<Tipo> tipos = new ArrayList<Tipo>();

	String[] primitivo = { "Int", "Dou", "Bool" };

	String[] palabraClave = { "if", "and", "or", "then", "==" };

	Teclado teclado;
	Raton raton;

	String tio = "";
	int focusObj = -1;

	// Constructor

	public Program2(Raton raton, Teclado teclado) {

		// temp

		// tipos.add("panel");
		// tipos.add("txt");
		// tipos.add("boton");

		// temp fin

		this.raton = raton;
		this.teclado = teclado;

		leer("program");

		tickHijos();
	}

	public void tick(Raton raton, Teclado teclado) {
		tickObjetos(raton, teclado);
		focus(raton);
		loop();
	}

	public void render(Graphics g) {
		renderObjetos(g);
		if (focusObj != -1) {
			objetos.get(focusObj).rendFocus(g);
		}

		for (int i = 0; i < objetos.size(); i++) {
			g.setColor(Color.GREEN);
			g.drawString(objetos.get(i).id + "  " + objetos.get(i).name + "  pos:" + objetos.get(i).pos.toString()
					+ "  dim:" + objetos.get(i).dim.toString() + "  vis:" + objetos.get(i).vis, 50, 170 + (20 * i));
		}
		g.drawString("" + focusObj, 50, 10);

		for (int i = 0; i < hijos.size(); i++) {
			g.setColor(Color.GREEN);
			g.drawString(hijos.get(i).toString(), 600, 170 + (20 * i));
		}

		for (int i = 0; i < comandos.size(); i++) {
			g.setColor(Color.GREEN);
			g.drawString(comandos.get(i).toString(), 50, 400 + (20 * i));
		}
	}

	public void stop() {

	}

	// funciones de renderizado

	private void renderObjetos(Graphics g) {
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).render(g);
		}
	}

	// funciones de tick

	private void tickObjetos(Raton raton, Teclado teclado) {
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).tick(raton, teclado);
		}
	}

	private void focus(Raton raton) {
		boolean temp = true;
		for (int i = 0; i < objetos.size(); i++) {
			if (tools.Tools.inside(raton.getPD(), objetos.get(i)) && objetos.get(i).vis) {
				focusObj = i;
				temp = false;
			}
			objetos.get(i).focus = false;
		}
		if (temp) {
			focusObj = -1;
		}
		if (focusObj != -1) {
			objetos.get(focusObj).focus = true;
		}
	}

	// funciones de programa

	private void leer(String ruta) {
		tio = ruta;
		String txt = "";
		try {
			txt = Lector.leerArchivoTexto("res/" + ruta + ".pro");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ejecutar(txt);
	}

	private void ejecutar(String txt) {
		txt = txt.replace("\n", "");
		String[] linea = txt.split(";");

		for (int i = 0; i < linea.length; i++) {
			selector(linea[i]);
		}
	}

	// ejecuta todos los comandos dentro del arraylist comandos

	private void loop() {
		for (int i = 0; i < comandos.size(); i++) {
			selector(comandos.get(i));
		}
	}

	// comprueba si el comando es un comando standar, es un comado de punto
	// o es una palabra clave

	private void selector(String linea) {
		String[] frase = linea.split(" ");

		if (frase[0].startsWith("in.")) {
			leer(frase[0].replace("in.", ""));

		} else if (isPalabraClave(frase[0])) {
			palabraClave(linea);

		} else {
			comando(frase[0], linea);
		}
	}

	// crea un objeto del standar y lo añade al array list de objetos

	private void declaracion(String linea) {
		String[] frase = linea.split(" ");

		int o = createObj(frase[0]);

		for (int i = 1; i < frase.length; i++) {
			objComand(frase[i], objetos.get(o));
		}
	}

	private int createObj(String tipo) {
		Obj obj;

		Point2D.Double pos = new Point2D.Double(0, 0);
		Point2D.Double dim = new Point2D.Double(0, 0);

		boolean vis = false;
		boolean focus = false;

		Color color = Color.gray;

		String nombre = "";

		int id = objetos.size();

		switch (tipo) {
		case "panel":
			obj = new Panel(id, pos, dim, nombre, vis, focus, color);
			break;
		case "boton":
			obj = new Boton(id, pos, dim, nombre, vis, focus, color);
			break;
		case "txt":
			obj = new Txt(id, pos, dim, nombre, vis, focus, color);
			break;
		default:
			obj = new Obj(id, pos, dim, nombre, vis, focus, color);
			break;
		}
		objetos.add(obj);

		return id;
	}

	private void objComand(String frase, Obj o) {
		String[] palabra = frase.split("\\.");

		switch (palabra[0]) {
		case "name":
			o.name = palabra[1];
			break;

		case "pos":
			if (palabra[1].matches("x")) {
				o.pos.x = operacion(palabra[2], (int) o.pos.getX());

			} else if (palabra[1].matches("y")) {
				o.pos.y = operacion(palabra[2], (int) o.pos.getY());

			} else {
				o.pos.x = operacion(palabra[1], 0);
				o.pos.y = operacion(palabra[2], 0);
			}
			break;

		case "dim":
			o.dim.x = operacion(palabra[1], 0);
			o.dim.y = operacion(palabra[2], 0);
			break;

		case "vis":
			o.vis = bool(palabra[1], o.vis);
			hijos(findId(o.name));
			break;

		case "color":
			o.color = new Color(operacion(palabra[1], 0), operacion(palabra[2], 0), operacion(palabra[3], 0));
			break;

		case "press":
			((Boton) o).press = bool(palabra[1], ((Boton) o).press);
			break;

		case "write":
			((Txt) o).write = bool(palabra[1], ((Txt) o).write);
			break;

		case "txt":

			if (palabra[1].matches("add")) {
				((Txt) o).txt += ((Txt) objetos.get(findId(palabra[2]))).txt + "\n";
			} else if (palabra[1].matches("null")) {
				((Txt) o).txt = "";
			} else {
				((Txt) o).txt = ((Txt) objetos.get(findId(palabra[1]))).txt;
			}
			break;
		case "off":
			if (palabra[1].matches("x")) {
				((Txt) o).xOff = operacion(palabra[2], ((Txt) o).xOff);

			} else if (palabra[1].matches("y")) {
				((Txt) o).yOff = operacion(palabra[2], ((Txt) o).yOff);

			} else {
				((Txt) o).xOff = operacion(palabra[1], 0);
				((Txt) o).yOff = operacion(palabra[2], 0);
			}
			break;

		}
	}

	private void comando(String frase, String linea) {
		String[] palabra = frase.split("\\.");
		int indice = findTipo(palabra[0]);

		if (isPrimitivo(palabra[0])) {
			switch (palabra[0]) {
			case "Int":
			case "Dou":
			case "Bool":
			default:
				System.out.println("Error en la clase programa en el metodo comando en el switch primitivo");
			}

		} else if (indice != -1) {
			frase = frase.substring(palabra[0].length() + 1);
			objComand(frase, objetos.get(indice));
		} else {
			switch (palabra[0]) {
			case "in":
				leer(palabra[1]);

				try {
					tipos.add(new Tipo(palabra[1], numVar(palabra[1])));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				break;

			case "hijo":
				hijos.add(new PointB(findId(palabra[1]), findId(palabra[2])));
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
				ejecutar(((Txt) objetos.get(findId(palabra[1]))).txt);
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
				leer("res/" + palabra[1] + ".txt");
				break;

			case "lista":
				String[] emp = Lector.lista("res");

				for (int i = 0; i < emp.length; i++) {
					System.out.println(emp[i].toString());
				}

			case "abrir":
				try {
					((Txt) objetos.get(findId(palabra[1]))).txt += Lector
							.leerArchivoTexto("res/" + palabra[2] + ".txt");

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case "debug":

				break;

			case "math":
				// ejecutar(((Txt) objetos.get(findId(palabra[1]))).txt);
				break;
			}
		}
	}

	private Tipo crearTipo(String ruta) throws IOException {
		String txt = Lector.leerArchivoTexto("res/" + ruta + ".pro");

		return new Tipo(ruta, numVar(ruta));
	}

	private Var[] numVar(String s) throws IOException {
		int r = 0;
		String txt = Lector.leerArchivoTexto("res/" + s + ".pro");
		txt = txt.replace("\n", "");
		String[] linea = txt.split("\\;");
		for (int i = 0; i < linea.length; i++) {
			if (numVarX(linea[i])) {
				r++;
			}
		}

		Var[] var = new Var[r];
		r = 0;
		for (int i = 0; i < linea.length; i++) {
			if (numVarX(linea[i])) {
				var[r] = var(linea[i]);
				r++;
			}
		}
		return var;
	}

	private Var var(String linea) {
		String[] frase = linea.split(" ");
		switch (frase[0]) {
		case "Int":
			return new Var(new Integer(0), frase[1]);
		case "Dou":
			return new Var(new Double(0), frase[1]);
		case "Bool":
			return new Var(new Boolean(false), frase[1]);
		default:
			for (int i = 0; i < tipos.size(); i++) {
				if (frase[0].matches(tipos.get(i).tipo)) {
					return new Var(tipos.get(i), frase[1]);
				}
			}

			System.out.println("Error en la clase programa en el metodo var en el switch");
			return null;
		}
	}

	private boolean numVarX(String s) {
		for (int i = 0; i < tipos.size(); i++) {
			if (s.startsWith(tipos.get(i).tipo)) {
				return true;
			}
		}

		for (int i = 0; i < primitivo.length; i++) {
			if (s.startsWith(primitivo[i])) {
				return true;
			}
		}
		return false;
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
						temp = boolX(frase[i], not);
						bool = bool && temp;
						temp = false;
						and = false;
					} else if (or) {
						temp = boolX(frase[i], not);
						bool = bool || temp;
						temp = false;
						or = false;
					} else {
						bool = boolX(frase[i], not);
					}
				} else if (bool) {
					String[] s = linea.split("then ");
					comando(frase[i], s[1]);
				}
			}
		}
	}

	private boolean boolX(String frase, boolean not) {
		boolean bool = condicional(frase);

		if (not) {
			return !bool;
		}
		return bool;
	}

	private void tickHijos() {
		for (int i = 0; i < hijos.size(); i++) {
			hijos(i);
		}
	}

	private void hijos(int a) {
		for (int j = 0; j < hijos.size(); j++) {
			if ((int) hijos.get(j).x == a) {
				objetos.get((int) hijos.get(j).y).vis = objetos.get(a).vis;
			}
		}
	}

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

	private boolean condicional(String frase) {
		String[] palabra = frase.split("\\.");
		boolean bool = false;
		int indice = findId(palabra[0]);

		if (indice != -1) {
			switch (palabra[1]) {
			case "vis":
				return objetos.get(indice).vis;
			case "press":
				return ((Boton) objetos.get(indice)).press;
			}
		} else {

			switch (palabra[0]) {
			case "key":
				bool = key(palabra[1]);
				break;
			}
		}

		return bool;

	}

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

	private boolean isStandar(String s) {
		for (int i = 0; i < tipos.size(); i++) {
			if (tipos.get(i).tipo.startsWith(s)) {
				return true;
			}
		}
		return false;
	}

	private boolean isPrimitivo(String s) {
		for (int i = 0; i < primitivo.length; i++) {
			if (s.matches(primitivo[i])) {
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

	private int findId(String s) {
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).name.matches(s)) {
				return i;
			}
		}
		return -1;
	}

	private int findPrimitivo(String s) {
		for (int i = 0; i < primitivo.length; i++) {
			if (s.matches(primitivo[i])) {
				return i;
			}
		}
		return -1;
	}

	private int findTipo(String s) {
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
}
