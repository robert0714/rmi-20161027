package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.rmi.test.HelloImpl;
import com.rmi.test.IHello;

public class HelloServer {
	public static void main(String args[]) {

		try {
			LocateRegistry.createRegistry(1099);
			IHello hello = new HelloImpl();	
			Naming.bind("rmi://192.168.7.185:1099/hello", hello);
			System.out.println(">>>INFO:hello Ready!");
		} catch (Exception e) {
			System.out.println(">>>FALSE!");
			e.printStackTrace();
		}
	}
}