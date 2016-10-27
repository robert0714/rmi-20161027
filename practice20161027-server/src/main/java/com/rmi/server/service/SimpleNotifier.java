package com.rmi.server.service;

import java.rmi.RemoteException;

public class SimpleNotifier implements Notifier {
	public void registerMe(Receiver r) {
		try {
			System.out.println("registered the receiver : " + r);
			String msg = "A message from SimpleNotifier";
			r.notify(msg); // callback
			System.out.println("Sent : " + msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}