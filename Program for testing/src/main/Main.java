package main;

import java.awt.Graphics;

import control.Raton;
import control.Teclado;

public class Main {

	public static Raton raton;
	public static Teclado teclado;
	public static Graphics g;
	private static Root root;

	public void loop() {
		start();
		while (Const.Loop) {
			tick();
			render();
		}
		dispose();
	}

	private void start() {
		raton = new Raton();
		teclado = new Teclado();

		Ventana.start();
		Lienzo.start(640, 480);
		Ventana.getFrame().add(Lienzo.getCanvas());
		root = new Root();
		root.start();
	}

	private void tick() {
		raton.tick(Lienzo.getCanvas());
		root.tick();
	}

	private void render() {
		Lienzo.renderStart();
		root.render();
		Lienzo.renderEnd();
	}

	private void dispose() {
		root.dispose();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.loop();
	}

}
