package main;

import java.awt.Color;

import javax.swing.JFrame;

import org.lwjgl.glfw.GLFW;

public class Ventana extends JFrame {

	public Ventana(Lienzo lienzo) {
		this.setTitle(Const.Name);
		this.setSize(Const.Width, Const.Height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(lienzo);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	public Ventana() {
		GLFW.glfwCreateWindow(Const.Width, Const.Height, Const.Name, 0, 0);
	}
}
