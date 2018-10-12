package gp;

import java.awt.Graphics;
import java.awt.geom.Point2D.Double;

import control.Raton;
import control.Teclado;
import program.Obj;

public class Block extends Obj {

	Input[] in;
	Output[] out;

	public Block(int id, Double pos, Double dim, String name, boolean focus, boolean vis, int in, int out) {
		super(id, pos, dim, name, focus, vis);
		this.in = new Input[in];
		this.out = new Output[out];
	}

	public Block(Obj obj, int in, int out) {
		super(obj.id, obj.pos, obj.dim, obj.name, obj.focus, obj.vis);
	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {
		g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
	}
}
