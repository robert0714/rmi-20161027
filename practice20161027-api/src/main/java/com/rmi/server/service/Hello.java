package com.rmi.server.service;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello  extends  Remote,Serializable{

	public String sayHello()throws RemoteException;

}
