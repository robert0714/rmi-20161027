package com.rmi.client;

//CalculatorClient.java
import java.rmi.*;
import java.rmi.registry.*;

import com.rmi.server.service.Calculator;
import com.rmi.server.service.SimpleRegistry;

public class CalculatorClient {
	public static void main(String args[]) {
		try {
			String name = "calculator";
//			Registry registry = LocateRegistry.getRegistry(args[0]);
			
			// System.out.println(registry);
			// uncomment above line if you want to display the info. about
			// registry
			
//			Calculator cal = (Calculator) registry.lookup(name);
			
			Calculator cal = (Calculator)SimpleRegistry.lookup(args[0],
					Integer.parseInt(args[1]), name);
			
			
			
			// System.out.println(cal);
			// uncomment above line if you want to display the info. about cal
			int x = 4, y = 3;
			int result = cal.add(x, y);
			System.out.println("Sent: " + x + " and " + y);
			System.out.print("Received(" + x + "+" + y + "=): " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}