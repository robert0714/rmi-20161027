package com.rmi.server.service;

import java.io.Serializable;
import java.rmi.RemoteException;

public class HelloImpl implements Hello{
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
