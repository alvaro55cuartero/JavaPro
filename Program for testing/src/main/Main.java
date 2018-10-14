package main;

import control.Raton;
import control.Teclado;

public class Main {

	public static Raton raton;
	public static Teclado teclado;
	public int aps;
	public int fps;

	private static Root root;

	public void loop() {
		int actualizaciones = 0;
		int frames = 0;

		final int NS_POR_SEGUNDO = 100000000;
		final int APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long refAct = System.nanoTime();
		long refCont = System.nanoTime();

		double tiempoTrans;
		double delta = 0;

		start();

		while (Const.Loop) {

			final long inicioLoop = System.nanoTime();

			tiempoTrans = inicioLoop - refAct;
			refAct = inicioLoop;
			delta += tiempoTrans / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				tick();
				actualizaciones++;
				delta--;
			}

			render();
			frames++;

			if (System.nanoTime() - refCont > NS_POR_SEGUNDO) {

				aps = actualizaciones;
				fps = frames;

				frames = 0;
				actualizaciones = 0;
				refCont = System.nanoTime();
			}
		}

		dispose();
		System.exit(0);
	}

	private void start() {
		raton = new Raton();
		teclado = new Teclado();

		Ventana.start();

		root = new Root();
		root.start();
	}

	private void tick() {
		root.tick();
	}

	private void render() {
		root.render();
	}

	private void dispose() {
		root.dispose();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.loop();
	}

}
