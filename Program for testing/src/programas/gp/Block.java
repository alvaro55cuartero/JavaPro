package programas.gp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D.Double;

import main.Obj;

public class Block extends Obj {

	Input[] in;
	Output[] out;

	public Block(int id, Double pos, Double dim, String name, boolean focus, boolean vis, int in, int out) {
		super(id, pos, dim, name, focus, vis, Color.GRAY);
		this.in = new Input[in];
		this.out = new Output[out];
	}

	public Block(Obj obj, int in, int out) {
		this(obj.id, obj.pos, obj.dim, obj.name, obj.focus, obj.vis, in, out);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.fillRect((int) pos.x, (int) pos.y, (int) dim.x, (int) dim.y);
	}
}
