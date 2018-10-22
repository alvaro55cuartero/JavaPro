package programas.physycs;

import java.util.ArrayList;

public class SistemaPhy {

	public static ArrayList<ObjPhy> objetosPhy = new ArrayList<ObjPhy>();

	public SistemaPhy() {

	}

	public void tick() {

	}

	public void render() {

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
