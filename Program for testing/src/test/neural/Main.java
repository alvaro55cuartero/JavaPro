package test.neural;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import test.control.Teclado;



@SuppressWarnings("serial")
public class Main extends JFrame{
	
	public boolean loop = true;
	
	public int ancho = 600;
	public int alto = 400;
	
	public Teclado teclado;
	
	public BufferStrategy bs;
	public Graphics g;
	
	Canvas canvas;
	
	Test test;

	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.loop();
	}
	
	
	public void loop() {
		init();
		while(loop) {
			tick();
			render();
		}
		
	}
	
	
	public void init() {
		
		test = new Test();
		canvas = new Canvas();
		teclado = new Teclado();
		
		canvas.addKeyListener(teclado);
		canvas.setIgnoreRepaint(true);
		canvas.setPreferredSize(new Dimension(ancho, alto));
		canvas.addKeyListener(teclado);
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		this.setTitle("dibujo");
		this.setSize(ancho, alto);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas);
	}
	
	private void tick() {
		
		test.tick();
		
		teclado.clear();
		
	}
	
	private void render() {
		bs =  getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ancho, alto);
		
		test.render(g);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}

}
