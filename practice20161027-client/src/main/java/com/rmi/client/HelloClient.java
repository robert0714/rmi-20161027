package com.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rmi.server.service.Hello;

public class HelloClient {

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			Hello hello = (Hello) registry.lookup("server.Hello");
			System.out.println(hello.sayHello());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}