package com.ujjawal.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.ujjawal.chatapp.network.Client;
import com.ujjawal.chatapp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientChatScreen frame = new ClientChatScreen();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		setBackground(Color.WHITE);
		textArea = new JTextArea();
		client = new Client(textArea);
		setFont(new Font("Serif", Font.BOLD, 25));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientChatScreen.class.getResource("/images/chit.png")));
		System.out.println(UserInfo.USER_NAME);
		setTitle(UserInfo.USER_NAME);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 11, 1000, 425);
		contentPane.add(scrollPane);
		setVisible(true);
		textArea.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		textArea.setBounds(42, 11, 1000, 425);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(42, 447, 818, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendit = new JButton("Send Message");
		sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendit.setForeground(Color.DARK_GRAY);
		sendit.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		sendit.setBounds(897, 457, 123, 32);
		contentPane.add(sendit);
		setVisible(true);
	}

	protected void sendIt() {
		// TODO Auto-generated method stub
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+" : "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
