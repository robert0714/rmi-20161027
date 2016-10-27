package com.rmi.server.service;

import java.rmi.*;
import java.rmi.server.*;
 
public class SimpleReceiver extends UnicastRemoteObject implements Receiver, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3177726890154003498L;

	public SimpleReceiver() throws RemoteException {
	}

	public void notify(String msg) {
		try {
			System.out.println("received : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}