package com.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.server.service.Hello;
import com.rmi.server.service.HelloImpl;
import com.rmi.test.IHello;

public class HelloServer {
	public static void main(String args[]) {

		try {
			LocateRegistry.createRegistry(1099);
	        Hello hello = new HelloImpl();
	        Naming.rebind("rmi://192.168.7.185:1099/hello", hello);
	        System.out.println("server.RMI Server is ready.");
	        
		} catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
	public static void main0(String args[]) {

		try {
			LocateRegistry.createRegistry(1099);
			IHello hello = new com.rmi.test.HelloImpl();	
			Naming.bind("rmi://192.168.7.185:1099/hello", hello);
			System.out.println(">>>INFO:hello Ready!");
		} catch (Exception e) {
			System.out.println(">>>FALSE!");
			e.printStackTrace();
		}
	}
}
