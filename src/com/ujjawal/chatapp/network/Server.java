package com.ujjawal.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.ujjawal.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>();
	
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started waiting for the Client...");
		handleClientRequest();
	}
	
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = serverSocket.accept();
			//Per Client Per Thread
			ServerWorker serverWorker = new ServerWorker(clientSocket, this);
			workers.add(serverWorker);
			serverWorker.start();
		}
	}
	//Single Client
	/*
	    public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started waiting for client connection...");
		
		Socket socket = serverSocket.accept();
		System.out.println("Client Joined!!");
		
		InputStream in = socket.getInputStream();
		byte arr[] = in.readAllBytes();
		String str = new String(arr);
		System.out.println("Message recevied from cleint is "+str);
		in.close();
		socket.close();
		}
	 */
	public static void main(String[] args) throws IOException {
		Server server = new Server();
	}
}
