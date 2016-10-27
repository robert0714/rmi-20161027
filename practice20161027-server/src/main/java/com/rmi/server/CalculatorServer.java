package com.rmi.server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

import com.rmi.server.service.Calculator;
import com.rmi.server.service.SimpleCalculator;
import com.rmi.server.service.SimpleRegistry;

public class CalculatorServer {
	public static void main(String args[])  {
		try {
//			String url = "rmi://" + args[0] + "/calculator";
			
			String name = "calculator";		
			SimpleCalculator calculator = new SimpleCalculator();
//			Naming.rebind(url, calculator);
			
			Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calculator, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, (Remote)stub);
			
//			SimpleRegistry reg = new SimpleRegistry();
//			reg.rebind(stub, name);
			
			System.out.println("Calculator server ready...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}