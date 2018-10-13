package test.mussic;

public class Main {

	public static int fps = 0;
	public static int aps = 0;

	Window ventana;
	Lienzo lienzo;

	public Main() {

		int actualizaciones = 0;
		int frames = 0;

		final int NS_POR_SEGUNDO = 100000000;
		final int APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long refAct = System.nanoTime();
		long refCont = System.nanoTime();

		double tiempoTrans;
		double delta = 0;

		init();

		while (Cte.loop) {

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

		stop();
		System.exit(0);
	}

	public void init() {
		lienzo = new Lienzo(0, 0, Cte.ancho, Cte.alto - 40);
		ventana = new Window(Cte.ancho, Cte.alto, Cte.nombre, lienzo);
		lienzo.start();
	}

	public void tick() {
		lienzo.tick();
	}

	public void render() {
		lienzo.render();
	}

	public void stop() {
		lienzo.stop();
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

}
