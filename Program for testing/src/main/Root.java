package main;

import programas.pro.Pro;
import programas.prolector.ProLector;
import programas.prolista.ProLista;
import programas.promusic.MenuMusic;
import programas.promusic.Music;
import programas.promusic.ProMusic;
import programas.protexto.ProTexto;

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
		case 5:
			program = new ProLector();
			break;
		case 6:
			program = new ProTexto();
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
