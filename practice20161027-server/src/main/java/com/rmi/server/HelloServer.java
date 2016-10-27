package com.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.server.service.Hello;
import com.rmi.server.service.HelloImpl;

public class HelloServer {
	public static void main(String args[]) {

		try {
			LocateRegistry.createRegistry(1099);
	        Hello hello = new HelloImpl();
	        Naming.rebind("server.Hello", hello);
	        System.out.println("server.RMI Server is ready.");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
