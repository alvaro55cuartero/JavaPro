package statemachine;

public class MasterState {

	private static int currentState;
	private static State state;

	public MasterState() {

	}

	public void setCurrentState(int state) {
		this.currentState = state;
		selectState();
	}

	private static void selectState() {
		switch (currentState) {
		case State.MENUINICIO:
			state = new StateMenuInicio();

			break;
		default:
			System.out.println("ERROR");
			break;
		}
	}

}
