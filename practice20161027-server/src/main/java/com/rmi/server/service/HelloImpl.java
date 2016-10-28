package com.rmi.server.service;
 
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * 
 * 這邊最關鍵是用了UnicastRemoteObject
 * */
public class HelloImpl extends UnicastRemoteObject implements Hello{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7232279183161544530L;
	public HelloImpl ()throws RemoteException{
	}
	public String sayHello() throws RemoteException{
        return "Hello, world!";
    }
}
