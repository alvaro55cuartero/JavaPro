package test.lista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.File;

import javax.swing.JFrame;

import test.control.Raton;

public class Buscador extends JFrame {

	File ruta;
	List list;

	BufferStrategy bs;
	Graphics g;
	Raton raton;

	int ancho = 600;
	int alto = 400;
	private boolean loop = true;

	public Buscador() {
		this("res");
	}

	public Buscador(String ruta) {
		this.ruta = new File(ruta);
		this.setTitle("Buscador");
		this.setSize(ancho, alto);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		list = new List(0, 0, ancho, alto);
		list.lista = this.ruta.list();

		// System.out.println(this.ruta.getAbsolutePath());

		this.setVisible(true);

		loop();
	}

	private void loop() {
		int a = 0;
		while (loop) {
			if (a > 1000000000) {
				System.out.println("hoa");

				a = 0;
			}

			a++;
		}
	}

	public String[] procesar(String[] list) {
		if (list[0].matches(".DS_Store")) {
			list[0] = "Return";
			return list;
		} else {
			for (int i = 0; i < list.length; i++) {
				if (list[i].matches(".DS_Store")) {
					list[i] = "Return";
					return list;
				}
			}
		}
		return list;
	}

	public void render() {
		bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, ancho, alto);
		raton.render(g);

		list.render(g);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}

}
