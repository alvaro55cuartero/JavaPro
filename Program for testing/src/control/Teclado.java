package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	public Tecla[] teclas = new Tecla[2000];

	public Teclado() {
		for (int i = 0; i < teclas.length; i++) {
			teclas[i] = new Tecla();
		}
	}

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()].teclaPulsada();

		// System.out.println(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()].teclaLiberada();

	}

	public void keyTyped(KeyEvent e) {

	}

}