package programas.promusic;

public class Acorde {

	boolean[] serie = new boolean[12];

	public Acorde(boolean serie[]) {
		this.serie = serie;
	}

	public Acorde() {

	}

	public static Acorde rand() {
		Acorde acorde = new Acorde();
		for (int i = 0; i < 12; i++) {
			if (Math.random() > 0.5) {
				acorde.serie[i] = true;
			} else {
				acorde.serie[i] = false;
			}
		}
		return acorde;
	}

	public String toString() {
		return "";

	}
}
