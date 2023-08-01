package com.ujjawal.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.ujjawal.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	private InputStream in;
	private OutputStream out;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessages();
//		System.out.println("Client Joined!!");
//		System.out.println("Enter the Message Send to the Server....");
//		Scanner sc = new Scanner(System.in);
//		String message = sc.nextLine();
//		OutputStream out = socket.getOutputStream();
//		out.write(message.getBytes());
//		System.out.println("Message Sent!!");
//		sc.close();
//		out.close();
//		socket.close();
	}
	
	public void sendMessage(String message) throws IOException {
		message = message + "\n";
		out.write(message.getBytes());
	}
	public void readMessages() {
		worker= new ClientWorker(in, textArea);
		worker.start();
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//	}
}
