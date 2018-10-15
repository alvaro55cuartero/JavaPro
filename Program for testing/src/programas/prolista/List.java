package programas.prolista;

import java.awt.Color;
import java.awt.Graphics;

public class List {

	int x, y, ancho, alto;

	String[] lista;

	public List(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		for (int i = 0; i < lista.length; i++) {
			celda(i, g);
		}
	}

	public void celda(int i, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x + 10, 10 + y, ancho - 10, 20);
		g.drawString(lista[i], x + 20, y + 20 + (20 * i));
	}

}
