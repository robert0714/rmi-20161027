package com.rmi.server.service;

import java.rmi.*;

public interface Receiver extends Remote {
	public void notify(String s) throws RemoteException;
}