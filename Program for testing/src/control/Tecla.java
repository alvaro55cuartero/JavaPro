package control;

public class Tecla {

	public boolean pulsada = false;
	
	public static int t = 500000000;

	private long ultimaPulsacion = System.nanoTime();

	public Tecla() {

	}

	public void teclaPulsada() {
		pulsada = true;
	}

	public void teclaLiberada() {
		pulsada = false;
	}

	public boolean isPulsada() {
		return pulsada;
	}
	
	public boolean isReleased(int time) {
		if(System.nanoTime() - ultimaPulsacion > time && pulsada) {
			ultimaPulsacion = System.nanoTime();
			return true;
		}else{
			
			return false;
		}
	}

	public long ultimaPulsacion() {
		return ultimaPulsacion;
	}
}