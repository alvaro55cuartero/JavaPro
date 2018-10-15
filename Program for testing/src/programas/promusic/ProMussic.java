package programas.promusic;

import java.awt.Point;

import main.Program;

public class ProMussic extends Program {

	MenuFrec mf;
	MenuWave mw;

	public ProMussic() {
		mf = new MenuFrec(100, new Point(0, 0), new Point(500, 500));
		mw = new MenuWave(new Point(500, 0), new Point(500, 500));
	}

	public void start() {

	}

	public void tick() {

	}

	public void render() {

	}

	public void dispose() {

	}

}
