package main;

import programas.pro.Pro;
import programas.prolista.ProLista;
import programas.promusic.MenuMusic;
import programas.promusic.Music;
import programas.promusic.ProMusic;

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
			program = new MenuMusic();
			break;
		case 3:
			program = new ProMusic();
			break;
		case 4:
			program = new ProLista();
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

	public void debug() {
		program.debug();
	}

	public void dispose() {
		program.dispose();
	}
}
