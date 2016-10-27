package com.rmi.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator  extends  Remote{

	int add(int x, int y)throws RemoteException;
	

}
