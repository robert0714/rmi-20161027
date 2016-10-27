package com.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.server.service.Notifier;
import com.rmi.server.service.SimpleNotifier;

public class CallbackServer {
	public static void main(String args[]) {
		try {
			String name = "notifier";
			SimpleNotifier notifier = new SimpleNotifier();
			Notifier stub = (Notifier) UnicastRemoteObject.exportObject(notifier, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(name, stub);
			System.out.println("Notifier ready...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
