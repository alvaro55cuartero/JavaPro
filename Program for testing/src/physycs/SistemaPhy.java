package physycs;

import java.awt.Graphics;
import java.util.ArrayList;

import control.Raton;
import control.Teclado;

public class SistemaPhy {

	public static ArrayList<ObjPhy> objetosPhy = new ArrayList<ObjPhy>();

	public SistemaPhy() {

	}

	public void tick(Raton raton, Teclado teclado) {

	}

	public void render(Graphics g) {

	}

	public static void tickObjPhy() {
		for (int i = 0; i < objetosPhy.size(); i++) {
			if (objetosPhy.get(i) instanceof ObjPhy) {
				for (int j = 0; j < objetosPhy.size(); j++) {

				}
			}
		}
	}
}
