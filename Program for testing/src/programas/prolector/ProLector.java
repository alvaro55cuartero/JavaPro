package programas.prolector;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import main.Program;
import main.Ventana;
import tools.Lector;

public class ProLector extends Program implements ActionListener {

	float size = 15f;

	String txt;
	File file;
	JPanel panel;
	JFileChooser fileChooser;
	JTextPane area;
	JScrollPane sp;

	JMenu m2;
	JMenu m3;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;
	JMenuItem mi24;

	JMenuItem mi31;
	JMenuItem mi32;
	JMenuItem mi33;

	boolean ascii = true;

	public ProLector() {
		Ventana.getFrame().getContentPane().removeAll();
		panel = new JPanel();
		m2 = new JMenu();
		m3 = new JMenu();
		mi21 = new JMenuItem();
		mi22 = new JMenuItem();
		mi23 = new JMenuItem();
		mi24 = new JMenuItem();
		mi31 = new JCheckBoxMenuItem();
		mi32 = new JCheckBoxMenuItem();
		mi33 = new JCheckBoxMenuItem();

		fileChooser = new JFileChooser();
		area = new JTextPane();
		area.setEditable(false);
		area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		sp = new JScrollPane(area);

		area.setFont(area.getFont().deriveFont(size));

		mi21.addActionListener(this);
		mi22.addActionListener(this);
		mi23.addActionListener(this);
		mi24.addActionListener(this);
		mi31.addActionListener(this);
		mi32.addActionListener(this);
		mi33.addActionListener(this);

		m2.setText("Edit");
		m3.setText("Show");

		mi21.setText("Zoom +");
		mi22.setText("Zoom -");
		mi23.setText("");
		mi24.setText("");

		mi31.setText("hex");
		mi32.setText("ascii");
		mi33.setText("Elf");

		m2.add(mi21);
		m2.add(mi22);
		m2.add(mi23);
		m2.add(mi24);
		m3.add(mi31);
		m3.add(mi32);

		bar.add(m2);
		bar.add(m3);

		panel.setLayout(new BorderLayout());
		panel.add(bar, BorderLayout.NORTH);
		panel.add(sp, BorderLayout.CENTER);

		Ventana.getFrame().add(panel);
		Ventana.getFrame().pack();

	}

	public void start() {

	}

	public void tick() {

	}

	public void render() {

	}

	public void debug() {

	}

	public void dispose() {

	}

	public void open() {
		int r = fileChooser.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try {
				txt = Lector.leerArchivoTexto(file.getPath());
				String hex = String.format("%040x", new BigInteger(1, txt.getBytes()));
				hex = Lector.insert(hex, " ", 16);
				String hexs[] = hex.split(" ");

				String form = Lector.insert(txt, " ", 8);
				String forms[] = form.split(" ");

				for (int i = 0; i < hexs.length; i++) {

					hexs[i] = Lector.insert(hexs[i], " ", 2);
					hexs[i] = Lector.insert(hexs[i], " ", 12);
					if (mi32.isSelected()) {
						hexs[i] = hexs[i] + "  " + forms[i];
					}
				}

				area.setText(String.join("\n", hexs));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void new0() {

	}

	public void save() {

	}

	public void exit() {

	}
}