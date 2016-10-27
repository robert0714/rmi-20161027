package com.rmi.server.service;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class SimpleCalculator   implements Calculator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 398079511780635619L;

	public SimpleCalculator() throws RemoteException {
		super();
	}

	public int add(int a, int b) {
		System.out.println("Received: " + a + "and" + b);
		int result = a + b;
		System.out.println("Sent: " + result);
		return result;
	}
}