package test.sever2;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable {

	JTextArea ta;
	JPanel panel;
	Socket socket;
	DataInputStream ds;
	Thread thread;
	ServerSocket ss;

	public static void main(String[] args) {
		Server server = new Server();
	}

	public Server() {
		panel = new JPanel();
		ta = new JTextArea();
		thread = new Thread(this);

		this.setTitle("Server");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		panel.setLayout(new BorderLayout());

		ta.setEditable(false);

		panel.add(ta, BorderLayout.CENTER);

		this.add(panel);

		this.setVisible(true);

		thread.start();

	}

	public void run() {
		try {
			ss = new ServerSocket(9999);

			while (true) {

				Socket s = ss.accept();

				s.getInputStream();

				ds = new DataInputStream(s.getInputStream());

				String string = ds.readUTF();

				ta.append(ta.getText() + "\n" + string);

				s.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
