package programas.prolector;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
	JMenuBar bar;
	JFileChooser fileChooser;
	JTextPane area;
	JScrollPane sp;

	JMenu menu1;
	JMenu menu2;
	JMenu menu3;

	JMenuItem mi11;
	JMenuItem mi12;
	JMenuItem mi13;
	JMenuItem mi14;

	JMenuItem mi21;
	JMenuItem mi22;
	JMenuItem mi23;
	JMenuItem mi24;

	JMenuItem mi31;
	JMenuItem mi32;
	JMenuItem mi33;

	boolean ascii = true;

	public ProLector() {
		panel = new JPanel();
		bar = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menu3 = new JMenu();
		mi11 = new JMenuItem();
		mi12 = new JMenuItem();
		mi13 = new JMenuItem();
		mi14 = new JMenuItem();
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

		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		mi14.addActionListener(this);
		mi21.addActionListener(this);
		mi22.addActionListener(this);
		mi23.addActionListener(this);
		mi24.addActionListener(this);
		mi31.addActionListener(this);
		mi32.addActionListener(this);
		mi33.addActionListener(this);

		menu1.setText("File");
		menu2.setText("Edit");
		menu3.setText("Show");

		mi11.setText("New");
		mi12.setText("Open");
		mi13.setText("Save");
		mi14.setText("");

		mi21.setText("Zoom +");
		mi22.setText("Zoom -");
		mi23.setText("");
		mi24.setText("");

		mi31.setText("hex");
		mi32.setText("ascii");
		mi33.setText("Elf");

		menu1.add(mi11);
		menu1.add(mi12);
		menu1.add(mi13);
		menu1.add(mi14);
		menu2.add(mi21);
		menu2.add(mi22);
		menu2.add(mi23);
		menu2.add(mi24);
		menu3.add(mi31);
		menu3.add(mi32);

		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);

		panel.setLayout(new BorderLayout());
		panel.add(bar, BorderLayout.NORTH);
		panel.add(sp, BorderLayout.CENTER);

		Ventana.getFrame().setLocationRelativeTo(null);
		Ventana.getFrame().add(panel);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mi11)) {
		}
		if (e.getSource().equals(mi12)) {
			open();
		}
		if (e.getSource().equals(mi13)) {
		}
		if (e.getSource().equals(mi14)) {
		}
		if (e.getSource().equals(mi21)) {
			size++;
			area.setFont(area.getFont().deriveFont(size));
			System.out.println(size);
		}
		if (e.getSource().equals(mi22)) {
			size--;
			area.setFont(area.getFont().deriveFont(size));
		}
		if (e.getSource().equals(mi23)) {
		}
		if (e.getSource().equals(mi24)) {
		}
		if (e.getSource().equals(mi31)) {

		}
		if (e.getSource().equals(mi31)) {

		}
	}

	private void open() {
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
}