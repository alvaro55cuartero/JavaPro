package main;

import java.awt.Graphics;

import control.Raton;
import control.Teclado;
import musica.Music;
import program.Program;

public class Root {

	Program program;
	Music m;
	// Plot plot;

	public Root(Raton raton, Teclado teclado) {
		// program = new Program(raton, teclado);
		m = new Music();

		// plot = new Plot(100, 400);
	}

	public void tick(Raton raton, Teclado teclado) {
		m.tick(raton, teclado);
		// program.tick(raton, teclado);
		// plot.tick(raton, teclado);
	}

	public void render(Graphics g) {
		m.render(g);
		// program.render(g);
		// plot.render(g);
	}

	public void stop() {
		// program.stop();
	}
}
