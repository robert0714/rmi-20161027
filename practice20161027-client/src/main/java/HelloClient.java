import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmi.test.IHello;

public class HelloClient {

	public static void main(String args[]) {
		try {
//			 Registry registry = LocateRegistry.getRegistry("192.168.201.148");
//		        IHello rhello = (IHello) registry.lookup("server.Hello");
			IHello rhello = (IHello) Naming.lookup("rmi://192.168.7.185:1099/server.Hello");
			System.out.println(rhello.helloWorld());
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
//		catch (MalformedURLException e) {
//			e.printStackTrace();
//		} 
		catch (RemoteException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Server發生問題，請檢察!.....");
			System.out.println("-----------------------------------");
			e.printStackTrace();
		}
	}
}