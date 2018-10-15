package programas.promusic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import test.control.Raton;
import test.control.Teclado;
import tools.Circulo;
import tools.Tools;

public class MenuFrec {

	byte[] nota;
	static int[] espectro;
	Point.Double pos;
	Point.Double dim;

	ArrayList<Circulo> circ = new ArrayList<Circulo>();

	public MenuFrec(int tam, Point pos, Point dim) {
		nota = new byte[tam];
		this.pos = pos;
		this.dim = dim;
		circ.add(new Circulo(new Point(pos.x, 100)));

		circ.add(new Circulo(new Point(pos.x + dim.x, pos.y + dim.y / 2)));
	}

	public void tick(Raton raton, Teclado teclado) {
		boolean temp = true;
		if (raton.isClick() && Tools.inside(Raton.pos, pos, dim)) {
			for (int i = 0; i < circ.size(); i++) {
				if (Tools.inside(Raton.pos, circ.get(i).pos, new Point(10, 10))) {
					System.out.println("Error tick MenuFrec");

					temp = false;
				}
			}
			for (int i = 0; i < circ.size() - 1; i++) {
				if (temp && Tools.between(raton.pos.getX(), circ.get(i).pos.getX(), circ.get(i + 1).pos.getX())) {
					circ.add(i + 1, new Circulo(new Point(Raton.pos)));
				}
			}

			// ordenar();
		}
		espectro = poc1();
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(pos.x, pos.y, dim.x, dim.y);

		for (int i = 0; i < circ.size(); i++) {
			circ.get(i).render(g);
		}

		for (int i = 0; i < espectro.length - 1; i++) {

			g.drawLine(i, espectro[i], i + 1, espectro[i + 1]);

		}

	}

	public byte[] poc() {
		byte[] valores = new byte[(int) dim.getY()];
		for (int i = 0; i < circ.size() - 1; i++) {
			int ancho = circ.get(i + 1).pos.x - circ.get(i).pos.x;
			int alto = circ.get(i + 1).pos.y - circ.get(i).pos.y;

			for (int j = 0; j < ancho; j++) {
				valores[j] = (byte) ((alto / (1 + Math.exp(-((((2 * j) / ancho) - 1) / 0.1)))));
			}
		}
		return valores;
	}

	public int[] poc1() {
		int acumula = 0;
		int[] valores = new int[(int) dim.getY()];
		for (int i = 0; i < circ.size() - 1; i++) {
			double ancho = circ.get(i + 1).pos.x - circ.get(i).pos.x;
			double alto = circ.get(i + 1).pos.y - circ.get(i).pos.y;
			double ratio = alto / ancho;

			for (int j = acumula; j < ancho + acumula; j++) {
				valores[j] = (int) ((ratio * j) + (circ.get(i).pos.y - (ratio * circ.get(i).pos.x)));
			}
			acumula += ancho;
		}
		return valores;
	}

	public static byte[] nota(int size) {
		byte[] note = new byte[size];
		byte[] noti = new byte[size];

		for (int i = 0; i < 10000; i++) {
			for (int t = 0; t < noti.length; t++) {
				noti[t] = (byte) ((127 / 1000) * espectro[i] * Math.sin(2 * Math.PI * t));
			}
			note = mathycs.Mathycs.add(note, noti);
		}

		return note;
	}

}
