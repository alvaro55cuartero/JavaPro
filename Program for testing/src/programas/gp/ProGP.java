package programas.gp;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Const;
import main.Lienzo;
import main.Main;
import main.Program;
import main.Renderer;
import main.Ventana;

public class ProGP extends Program implements Renderer {

	ArrayList<Block> blocks = new ArrayList<Block>();
	Lienzo lienzo;
	Object[] options = { "block" };

	public ProGP() {
		Ventana.getFrame().getContentPane().removeAll();
		lienzo = new Lienzo(Const.Width, Const.Height);
		lienzo.setRenderer(this);

		Ventana.getFrame().add(lienzo);
		Ventana.getFrame().pack();

	}

	public void start() {

	}

	public void tick() {
		System.out.println(Main.teclado.teclas[KeyEvent.VK_N].isPulsada());
		if (Main.teclado.teclas[KeyEvent.VK_N].isPulsada()) {
			create();

		}

		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).tick();
		}
	}

	public void render() {

	}

	public void debug() {

	}

	public void dispose() {

	}

	public void render(Graphics2D g) {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}

	}

	private void create() {
		int n = JOptionPane.showOptionDialog(null, "selecciona un block", "selector", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

}
