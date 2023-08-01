package com.ujjawal.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
	private Server server;
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();
		out = clientSocket.getOutputStream();
		System.out.println("New Client Comes...");
	}

	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while(true) {
				line = br.readLine();
				if(line.equalsIgnoreCase("quit")) {
					break;
				}
//				out.write(line.getBytes()); //To Single Client
				//BroadCast to all
				for(ServerWorker serverWorker : server.workers) {
					line = line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(in!=null) {
					in.close();
				}
				if(out!=null) {
					out.close();
				}
				if(clientSocket!=null) {
					clientSocket.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
}
