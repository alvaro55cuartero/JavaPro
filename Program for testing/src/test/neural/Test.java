package test.neural;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.Program;

public class Test extends Program {

	ArrayList<Nave> naves = new ArrayList<Nave>();
	ArrayList<Comida> comidas = new ArrayList<Comida>();

	Nave nave;

	public Test() {
		nave = new Nave(new Point2D.Double(100, 100), new Point2D.Double(0, 0), 10);
		naves.add(nave);
	}

	public void start() {

	}

	public void tick() {
		tickNaves();
	}

	public void render() {
		renderArray(g);
	}

	public void renderArray(Graphics g, ArrayList<Object> a) {
		for (int i = 0; i < a.size(); i++) {
			a.get(i).render(g);
		}
	}

	public void dispose() {

	}

	public void division(Nave nave) {
		naves.remove(nave);

	}

	// public int find(Nave nave) {
	// for(int i = 0; i < naves.size(); i++) {
	// if(naves.get(i) == nave) {
	// return i;
	// }
	// }
	// return -1;
	// }

	public void tickNaves() {
		for (int i = 0; i < naves.size(); i++) {
			naves.get(i).tick();
		}
	}

}
