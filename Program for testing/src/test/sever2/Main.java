package test.sever2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	int width = 600;
	int height = 400;

	Selector s;

	boolean loop;

	public static void main(String[] arg) {
		Main main = new Main();
	}

	public Main() {
		loop();
	}

	public void loop() {
		start();

		while (loop) {
			tick();
			render();
		}

		stop();

	}

	public void start() {
		this.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);

		s = new Selector(this);
	}

	public void tick() {

	}

	public void render() {

	}

	public void stop() {

	}

}
