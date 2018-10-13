package test.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import mathycs.Mathycs;

public class Musica {

	AudioFormat af;
	SourceDataLine line;

	int sampleRate;

	public enum acorde {
		mayor, menor, aumentado, disminuido, sus2, sus4
	}

	public Musica(int sampleRate) {
		this.sampleRate = sampleRate;

		af = new AudioFormat(sampleRate, 8, 1, true, true);
		try {
			line = AudioSystem.getSourceDataLine(af);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		startLine();
	}

	public void play(byte[] l, int off, int len) {
		line.write(l, off, len);
	}

	private void startLine() {
		try {
			line.open(af, sampleRate);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		line.start();
	}

	public void stopLine() {
		line.drain();
		line.close();
	}

	public byte[] nota(double frec) {
		byte[] sin = new byte[2 * sampleRate];
		for (int i = 0; i < sin.length; i++) {
			double period = (double) sampleRate / frec;
			double angle = 2.0 * Math.PI * i / period;
			sin[i] = (byte) (Math.sin(angle) * 127f);
		}
		return sin;
	}

	public byte[] nota(double frec, int size) {
		byte[] sin = new byte[size];
		for (int i = 0; i < sin.length; i++) {
			double period = (double) sampleRate / frec;
			double angle = 2.0 * Math.PI * i / period;
			sin[i] = (byte) (Math.sin(angle) * 127f);
		}
		return sin;
	}

	public int length(int ms) {
		ms = Math.min(ms, 2 * 1000);
		int length = sampleRate * ms / 1000;
		return length;
	}

	public double frec(int nota, int octava) {
		return 440.0 * Math.exp(((octava - 4) + (nota - 10) / 12.0) * Math.log(2));
	}

	public byte[] arcodar(int n, acorde a) {

		byte[] chord = new byte[500];

		switch (a) {
		case mayor:
			chord = Mathycs.add(nota(frec(n, 4)), nota(frec(monos(n + 4), 4)));
			chord = Mathycs.add(chord, nota(frec(monos(n + 7), 4)));

			break;
		case aumentado:
			chord = Mathycs.add(nota(frec(n, 4)), nota(frec(monos(n + 4), 4)));
			chord = Mathycs.add(chord, nota(frec(monos(n + 8), 4)));
			break;
		case disminuido:
			chord = Mathycs.add(nota(frec(n, 4)), nota(frec(monos(n + 3), 4)));
			chord = Mathycs.add(chord, nota(frec(monos(n + 6), 4)));
			break;
		case menor:
			chord = Mathycs.add(nota(frec(n, 4)), nota(frec(monos(n + 3), 4)));
			chord = Mathycs.add(chord, nota(frec(monos(n + 7), 4)));
			break;
		case sus2:
			break;
		case sus4:
			break;
		default:
			break;

		}

		return chord;
	}

	public int monos(int a) {
		if (a > 12) {
			a = a - 12;
		}
		return a;
	}

	public byte[] binToChord(int root, Acorde acorde, int size) {
		byte[] chord = rellenar(size);

		for (int i = 0; i < acorde.serie.length; i++) {
			if (acorde.serie[i]) {
				chord = Mathycs.add(chord, nota(frec(monos(root + i), 4), size));
			}
		}

		return chord;
	}

	public byte[] rellenar(int size) {
		byte[] r = new byte[size];
		for (int i = 0; i < size; i++) {
			r[i] = 0;
		}
		return r;
	}

	public static void main(String[] args) {
		acumula += ancho;
	}

}
