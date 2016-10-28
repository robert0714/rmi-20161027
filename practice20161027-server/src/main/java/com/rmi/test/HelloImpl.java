package com.rmi.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.rmi.test.IHello;


public class HelloImpl extends UnicastRemoteObject implements IHello {
 private static final long serialVersionUID = 3509127927099606368L;


 public HelloImpl() throws RemoteException {
 }

 public String helloWorld() throws RemoteException {
  return "HEY";
 }
}