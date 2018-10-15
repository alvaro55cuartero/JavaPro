package programas.promusic;

import test.mathycs.Mathycs;

public class Nota {

	int[] data;

	public Nota(int amp, double frec, int dur, int sampleRate) {
		data = nota(amp, frec, dur, sampleRate);
	}

	public Nota(double frec, int dur, int sampleRate) {
		this(127, frec, dur, sampleRate);
	}

	public Nota(int[] espectro, int dur, int sampleRate) {
		data = new int[dur];
		for (int i = 0; i < espectro.length; i++) {
			data = Mathycs.add(data, nota(espectro[i], i, dur, sampleRate));
		}
	}

	public Nota(int[] amp, int[] frec, int dur, int sampleRate) {
		data = new int[dur];
		for (int i = 0; i < amp.length; i++) {
			data = Mathycs.add(data, nota(amp[i], frec[i], dur, sampleRate));
		}
	}

	public static int[] nota(int amp, double frec, int dur, int sampleRate) {
		int[] data = new int[dur];
		for (int i = 0; i < data.length; i++) {
			double period = (double) sampleRate / frec;
			double angle = 2.0 * Math.PI * i / period;
			data[i] = (int) (Math.sin(angle) * amp);
		}
		return data;
	}

	public double[] getData() {
		double[] r = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			r[i] = (data[i] / 2147483647);
		}
		return r;
	}

}
