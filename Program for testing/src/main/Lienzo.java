package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import control.Raton;
import control.Teclado;
import program.Program;

public class Lienzo extends Canvas{

	Graphics g;
	BufferStrategy bs;
	
	Root root;
	
	int ancho;
	int alto;
	
	Raton raton;
	Teclado teclado;
	
	public Lienzo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		raton = new Raton(this);
		teclado = new Teclado();

		this.setIgnoreRepaint(true);
		this.setPreferredSize(new Dimension(ancho, alto));
		this.addMouseListener(raton);
		this.addKeyListener(teclado);
		this.setFocusable(true);
		this.requestFocus();
		
		root = new Root(raton, teclado);
		
	}
	
	public void tick() {
		raton.tick(this);
		root.tick(raton, teclado);
		raton.resetClick();
		teclado.clear();
		
	}
	
	public void render() {
		bs =  getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Const.Width, Const.Height);
		
		raton.render(g);
		
		root.render(g);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}
	
	public void stop() {
		root.stop();
	}
}
