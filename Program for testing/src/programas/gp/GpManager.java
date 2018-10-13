package programas.gp;

import java.awt.Graphics;
import java.util.ArrayList;

import control.Raton;
import control.Teclado;

public class GpManager {

	ArrayList<Block> blocks = new ArrayList<Block>();

	public GpManager() {

	}

	public void tick(Raton raton, Teclado teclado) {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).tick(raton, teclado);
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}

}
