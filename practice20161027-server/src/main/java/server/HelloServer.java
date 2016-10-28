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
			// Naming.rebind("server.Hello", hello);
			// TimeRMI timeRMI = new TimeRmiImpl();

			// Naming.rebind("timeRmi", timeRMI);

			Naming.bind("rmi://localhost:1099/hello", hello);
			System.out.println(">>>INFO:TimeRMI Ready!");
		} catch (Exception e) {
			System.out.println(">>>FALSE!");
			e.printStackTrace();
		}
	}
}