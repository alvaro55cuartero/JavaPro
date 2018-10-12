package main;

import org.lwjgl.glfw.GLFW;

public class Main {

	Ventana ventana;
	String string;

	public void loop() {
		start();

		while (Const.Loop) {
			tick();
			render();
		}

		dispose();

	}

	private void start() {
		GLFW.glfwInit();

		ventana = new Ventana();
	}

	private void tick() {

	}

	private void render() {

	}

	private void dispose() {

		GLFW.glfwTerminate();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.loop();
	}

}
