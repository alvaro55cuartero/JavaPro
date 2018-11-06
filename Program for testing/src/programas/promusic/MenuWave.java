package programas.promusic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class MenuWave extends JComponent {

	Point pos;
	Point dim;
	int size;
	byte[] espectro;
	Nota nota;

	public MenuWave(Point pos, Point dim) {
		this.pos = pos;
		this.dim = dim;
		this.size = 1000;
		this.espectro = new byte[size];
		Nota nota = new Nota(10000, 50000);

	}

	public void tick() {
		rellenar();
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(pos.x, pos.y, dim.x, dim.y);
	}

	public void rellenar() {
		Nota.
	}

}
