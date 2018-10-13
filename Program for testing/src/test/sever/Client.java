package test.sever;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {

	JPanel panel;
	JTextField textField;
	JButton boton;
	Socket socket;
	DataOutputStream ds;

	public static void main(String[] args) {
		Client client = new Client();
	}

	public Client() {
		panel = new JPanel();
		textField = new JTextField();
		boton = new JButton();

		this.setTitle("Cliente");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		panel.setLayout(null);

		boton.addActionListener(this);
		boton.setText("Enviar");
		boton.setBounds(520, 10, 50, 20);

		textField.setBounds(10, 10, 500, 20);

		panel.add(textField);
		panel.add(boton);

		this.add(panel);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e1) {
		try {
			socket = new Socket("localhost", 9999);
			ds = new DataOutputStream(socket.getOutputStream());
			ds.writeUTF(textField.getText());
			ds.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField.setText("");

	}

}
