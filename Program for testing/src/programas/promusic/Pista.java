package programas.promusic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;

public class Pista extends Canvas {
	byte data[];

	public Pista(Point pos, Point dim) {
		this.setBounds(pos.x, pos.y, dim.x, dim.y);
		this.setBackground(Color.black);

	}
}
