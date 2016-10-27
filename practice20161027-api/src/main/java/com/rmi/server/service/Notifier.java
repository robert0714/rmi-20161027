package com.rmi.server.service;

import java.rmi.*;

public interface Notifier extends Remote {
	public void registerMe(Receiver r) throws RemoteException;
}