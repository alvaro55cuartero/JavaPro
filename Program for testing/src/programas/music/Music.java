package programas.music;

import java.awt.Color;
import java.awt.Graphics;

import graphicsTools.Plot;
import main.Program;

public class Music extends Program {

	static Musica music;

	static String[] acorde = { "1", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0" };

	byte[] cancion;

	Plot p;

	int size = 4000;

	public Music() {
		p = new Plot();
		music = new Musica(50000);

		cancion = music.binToChord(1, acorde, size);

		// music.play(cancion, 0, cancion.length);
		music.stopLine();
	}

	public void start() {
	}

	public void tick() {
	}

	public void render() {
		p.render(g);

		render(g, acorde, size);
		p.rend(g, cancion, Color.red);
	}

	public void render(Graphics g, String[] a, int s) {
		byte[] b;
		String[] sb = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i].matches("1")) {
				for (int j = 0; j < a.length; j++) {
					if (i == j) {
						sb[j] = "1";
					} else {
						sb[j] = "0";
					}
				}
			}
			b = music.binToChord(1, sb, s);
			p.rend(g, b, Color.cyan);
		}
	}

	public void dispose() {
	}
}
