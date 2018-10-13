package test.sever;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Selector implements ActionListener {

	JButton server = new JButton();
	JButton client = new JButton();
	JLabel txt = new JLabel();

	public Selector(JFrame frame) {

		client.setText("Client");
		client.setBounds(20, 50, 100, 50);
		client.addActionListener(this);

		server.setText("Server");
		server.setBounds(20, 100, 100, 50);
		server.addActionListener(this);

		txt.setText("Elegir");
		txt.setBounds(20, 10, 100, 20);

		frame.add(client);
		frame.add(server);
		frame.add(txt);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(client)) {

		}
	}
}
