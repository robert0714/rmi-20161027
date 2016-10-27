package com.rmi.server.service;

import java.rmi.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleRegistry implements Runnable {
	int port;
	Hashtable objects = new Hashtable();

	public SimpleRegistry(int prt) {
		this.port = prt;
		new Thread(this).start();
	}

	public SimpleRegistry() {
		this(6789);
	}

	public void rebind(Remote o, String name) {
		objects.put(name, o);
	}

	public static Object lookup(String host, int port, String name) throws IOException, ClassNotFoundException {
		Socket clientEnd = new Socket(host, port);
		PrintWriter toServer = new PrintWriter(clientEnd.getOutputStream(), true);
		toServer.println(name);
		ObjectInputStream in = new ObjectInputStream(clientEnd.getInputStream());
		return in.readObject();
	}

	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket serverEnd = serverSocket.accept();
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(serverEnd.getInputStream()));
				String name = fromClient.readLine();
				Remote o = (Remote) objects.get(name);
				ObjectOutputStream oos = new ObjectOutputStream(serverEnd.getOutputStream());
				oos.writeObject(o);
			}
		} catch (Exception e) {
		}
	}
}