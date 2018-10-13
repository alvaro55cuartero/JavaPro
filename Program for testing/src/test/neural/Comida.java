package test.neural;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public class Comida {
	
	public Point2D.Double pos;
	public Point2D.Double vel;
	public Point2D.Double force;
	public int masa;
	
	
	public Comida(Point2D.Double pos, Point2D.Double vel, int masa) {
		this.pos = pos;
		this.vel = vel;
		this.masa = masa;
	}
	
	
	public void tick(){
		pos = add(pos, vel);	
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((int)pos.x, (int)pos.y, masa, masa);
		//g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	
	public void seek(Point2D.Double p) {

	}
	
	public Point2D.Double add(Point2D a, Point2D b) {
		return new Point2D.Double(a.getX() + b.getX(), a.getX() + b.getY());
	}
	
	
	public void dir() {
		
	}
	
}
