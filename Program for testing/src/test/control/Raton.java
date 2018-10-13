package test.control;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;


public class Raton extends MouseAdapter{
	public static Point pos = new Point(0, 0);
	private static boolean click;
	private static boolean press;

	public long t = 0;
	
	Canvas canvas;

	public Raton(Canvas canvas) {
		posicion(canvas);
		click = false;
	}

	public void tick(final Canvas canvas) {
		posicion(canvas);

	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawString("raton: " + pos.getX() + " || " + pos.getY(), 10, 20);
	}

	private void posicion(final Canvas canvas) {
		final Point posInicial = MouseInfo.getPointerInfo().getLocation();

		SwingUtilities.convertPointFromScreen(posInicial, canvas);

		pos.setLocation(posInicial.getX(), posInicial.getY());
	}

	public void mouseClicked(MouseEvent e) {
		if (!click) {
			click = true;
		}
	}

	public void mousePressed(MouseEvent e) {
		if (!press && System.nanoTime() - t > 200000000) {
			press = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (press) {
			press = false;
			t = System.nanoTime();
		}
	}

	public void resetClick() {
		if (click) {
			click = false;
		}
	}

	public boolean isClick() {
		return click;
	}

	public boolean isPress() {
		return press;
	}

//	public PointB getPb() {
//		return new PointB(pos.getX(), pos.getY());
//	}
//	
	
}
