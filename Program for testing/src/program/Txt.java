package program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import control.Raton;
import control.Teclado;

public class Txt extends Obj {

	String txt = "";
	boolean write = true;
	int xOff = 0;
	int yOff = 0;
	int t = 0;

	public Txt(int id, Point2D.Double pos, Point2D.Double dim, String name, boolean focus, boolean vis, Color color) {
		super(id, pos, dim, name, focus, vis, color);
		this.color = color;
	}

	public void tick(Raton raton, Teclado teclado) {
		if (write && focus) {
			txt = txt + teclado.t;
			if (teclado.backSpace.pulsada && t > 60 && !txt.isEmpty()) {
				txt = txt.substring(0, txt.length() - 1);
				t = 0;
			}
		}
		if (t > 60) {
			t = 0;
		}
		t++;
	}

	public void render(Graphics g) {
		if (vis) {
			g.setColor(color);
			g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
			g.setColor(color.black);
			if (write) {
				g.drawLine((int) (pos.x + g.getFontMetrics().stringWidth(txt)) + 10, (int) pos.y + 1,
						(int) (pos.x + g.getFontMetrics().stringWidth(txt)) + 10, (int) (pos.y + dim.y - 2));
			}
			// g.drawString(txt, (int) pos.getX() + 10, (int) pos.getY() + 13);
			drawString(g, txt, (int) dim.x - 20);
		}
	}

	public void drawString(Graphics g, String txt, int ancho) {
		String[] linea = txt.split("\n");
		int line = 1;

		for (int j = 0; j < linea.length; j++) {

			// System.out.println(g.getFontMetrics().getHeight());
			while (!linea[j].matches("")) {
				if (g.getFontMetrics().stringWidth(linea[j]) > ancho) {
					int a = 0;
					int b = 0;
					for (int i = 0; i < ancho; b++) {
						i = g.getFontMetrics().stringWidth(linea[j].substring(0, b));
						if (linea[j].charAt(b) == ' ') {
							a = b;
						}
					}
					g.drawString(linea[j].substring(0, a), (int) pos.getX() + xOff + 10,
							(int) pos.getY() + yOff + 15 * line);
					linea[j] = linea[j].substring(a + 1);

				} else {
					g.drawString(linea[j], (int) pos.getX() + xOff + 10,
							(int) pos.getY() + yOff + g.getFontMetrics().getHeight() * line);
					linea[j] = "";
				}

			}
			line++;
		}
	}
}