package statemachine;

public abstract class State {

	public static final int MENUINICIO = 1;
	public static final int OLDJAVA = 2;

	public State() {

	}

	public abstract void tick();

	public abstract void render();

	public abstract void dispose();

}
