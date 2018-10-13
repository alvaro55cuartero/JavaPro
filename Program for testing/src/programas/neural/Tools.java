package programas.neural;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Tools {
	
	
	public static Point2D.Double rotar(Point2D.Double a, double angulo){
		
		double mod = magnitud(a);
		double angle;
		
		if(a.x < 0) {
			angle = Math.atan(a.getY() / a.getX()) + Math.toRadians(angulo) + Math.PI;
		}else {
			angle = Math.atan(a.getY() / a.getX()) + Math.toRadians(angulo);
		}
		
		return new Point2D.Double(mod * Math.cos(angle), mod * Math.sin(angle));
		
	}
	
	public static double magnitud(Point2D.Double a) {
		return Math.sqrt(Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2));
	}
	
	public static void rotar(Point2D.Double[] p, double angle, Point2D.Double centro) {
		for(int i = 0; i < p.length; i++) {
			p[i] = sumar(rotar(restar(p[i],centro), angle), centro);
		}
		
	}
	
	public static Point2D.Double restar(Point2D.Double p, Point2D.Double c){
		return new Point2D.Double(p.getX() - c.getX(), p.getY() - c.getY());
	}
	
	public static Point2D.Double sumar(Point2D.Double p, Point2D.Double c){
		return new Point2D.Double(p.getX() + c.getX(), p.getY() + c.getY());
	}
	
	
	public Point2D.Double centro(Point2D.Double[] p) {
		return null;
	}
	
	public static void centrar(Point2D.Double[] p, Point2D.Double a) {
		for(int i = 0; i < p.length; i++) {
			p[i] = sumar(p[i],a);
		}
	}
	
	public static int[] poligonGetX(Double[] a) {
		
		int[] x = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			x[i] = (int)a[i].getX();
		}
		
		return x;
	}
	
	public static int[] poligonGetY(Double[] a) {
		int[] y = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			y[i] = (int)a[i].getY();
		}
		
		return y;
	}
	
	public static double angle(Point2D.Double dir) {
		double angle;
		
		if(dir.x < 0) {
			angle = Math.atan(dir.getY() / dir.getX()) + Math.PI;
		}else {
			angle = Math.atan(dir.getY() / dir.getX());
		}
		return angle;
	}

}
