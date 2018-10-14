package main;

import programas.music.MenuMusic;
import programas.music.Music;
import programas.pro.Pro;
import tools.Plot;

public class Root {

	private static Program program;

	public Root() {
		switch (Const.program) {
		case 0:
			program = new Pro();
			break;
		case 1:
			program = new Music();
			break;
		case 2:
			program = new Plot(100, 400);
			break;
		case 3:
			program = new MenuMusic();
			break;
		}
	}

	public void start() {
		program.start();
	}

	public void tick() {
		program.tick();
	}

	public void render() {
		program.render();
	}

	public void dispose() {
		program.dispose();
	}
}
