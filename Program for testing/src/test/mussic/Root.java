package test.mussic;

import java.awt.Graphics;
import java.awt.Point;

import test.control.Raton;
import test.control.Teclado;

public class Root {

	MenuFrec mf;
	MenuWave mw;

	public Root(Raton raton, Teclado teclado) {
		mf = new MenuFrec(100, new Point(0, 0), new Point(500, 500));
		mw = new MenuWave(new Point(500, 0), new Point(500, 500));
	}

	public void start() {

	}

	public void tick(Raton raton, Teclado teclado) {
		mf.tick(raton, teclado);
		mw.tick(raton, teclado);
	}

	public void render(Graphics g) {
		mf.render(g);
		mw.render(g);
	}

	public void stop() {

	}

}
