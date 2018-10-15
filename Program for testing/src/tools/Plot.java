package tools;

import java.awt.Canvas;
import java.awt.Graphics;

public class Plot extends Canvas {

	private int x;
	private int y;
	private int width;
	private int height;
	private int cX;
	private int cY;
	private int[] data;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 800 - 1;
		this.height = 500;
		this.cX = width / 2;
		this.cY = height / 2;
	}

	public Plot(int width, int height) {
		this.x = 0;
		this.y = 0;
		this.width = width;
		this.height = height;
		this.cX = width / 2;
		this.cY = height / 2;
	}

	public Plot(int x, int y, int width, int height, int cX, int cY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cX = cX;
		this.cY = cY;
	}

	public void render() {

	}

	public void render(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawLine(cX, y, cX, y + height);
		g.drawLine(x, cY, x + width, cY);
		if (data != null) {
			renderData(g);
		}
	}

	public void renderData(Graphics g) {
		double ratio = (double) width / (double) data.length;
		for (int i = 0; i < data.length - 1; i++) {
			// g.fillOval((ratio * i) - 5, data[i] - 5, 10, 10);
			g.drawLine((int) (ratio * i), data[i] + cY, (int) (ratio * (i + 1)), data[i + 1] + cY);
		}
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public void setData(byte[] data) {
		this.data = new int[data.length];
		for (int i = 0; i < data.length - 1; i++) {
			this.data[i] = data[i];
		}

	}
}
