package com.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rmi.server.service.Hello; 

public class HelloClient {

	public static void main(String[] args) {
//		new HelloClient().method01(args) ;
		new HelloClient().method02(args) ;
	}
	
	protected void method01(String[] args){
		String host = (args.length < 1) ? null : args[0];
		host ="192.168.7.185" ;
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			Hello hello = (Hello) registry.lookup("hello");
			System.out.println(hello.sayHello());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	protected void method02(String[] args){
		try {
			Hello rhello = (Hello) Naming.lookup("rmi://192.168.7.185:1099/hello");
			System.out.println(rhello.sayHello());
		} catch (Exception e) { 
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		} 
		
	}
}