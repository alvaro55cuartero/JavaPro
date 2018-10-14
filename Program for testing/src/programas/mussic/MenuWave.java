package programas.mussic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import test.control.Raton;
import test.control.Teclado;

public class MenuWave {

	Point pos;
	Point dim;
	Wave[] waves;
	double[] espectro;

	public MenuWave(Point pos, Point dim, double[] espectro) {
		this.pos = pos;
		this.dim = dim;
		this.espectro = espectro;

	}

	public void tick(Raton raton, Teclado teclado) {
		rellenar();
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(pos.x, pos.y, dim.x, dim.y);
	}

	public void rellenar() {
		for (int i = 0; i < espectro.length; i++) {
			for (int j = 0; j < waves[i].valor.length; j++) {

			}
		}
	}

}
