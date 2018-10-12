package graphicsTools;

import java.awt.Color;
import java.awt.Graphics;

import control.Raton;
import control.Teclado;

public class Plot {

	int x;
	int y;
	int width;
	int height;
	int cX;
	int cY;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 800 - 1;
		this.height = 500;
		this.cX = width / 2;
		this.cY = height / 2;
	}

	public Plot(int x, int y, int width, int height, int cX, int cY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cX = cX;
		this.cY = cY;
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		g.drawRect(x, y, width, height);
		// g.drawLine(cX, y, cX, y + height);
		g.drawLine(x, cY, x + width, cY);
	}

	public void rend(Graphics g, byte[] a, Color c) {
		double ratio = (double) width / (double) a.length;
		for (int i = 0; i < a.length - 1; i++) {
			// g.fillOval((ratio * i) - 5, a[i] - 5, 10, 10);
			g.setColor(c);
			g.drawLine((int) (ratio * i), a[i] + cY, (int) (ratio * (i + 1)), a[i + 1] + cY);
		}
	}
}
