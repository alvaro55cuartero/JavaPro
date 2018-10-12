package program;

public class Var {

	Object valor;

	String name;

	String tipo;

	public Var(Object valor, String name, String tipo) {
		this.valor = valor;
		this.name = name;
		this.tipo = tipo;
	}

	public Var(String name, String tipo) {
		this.valor = new Object();
		this.name = name;
		this.tipo = tipo;
	}

}
