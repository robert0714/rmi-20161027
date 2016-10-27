package com.rmi.client;

import java.rmi.Naming;

import com.rmi.server.service.Notifier;
import com.rmi.server.service.SimpleReceiver;

public class CallbackClient {
	public static void main(String[] args) {
		String ip =null; 
		if(args==null ||args.length==0){
			ip = "127.0.0.1" ;
		}else{
			ip = args[0] ;
		}
		try {
			String url = "rmi://" + ip  + "/notifier";
			Notifier notifier = (Notifier) Naming.lookup(url);
			SimpleReceiver recv = new SimpleReceiver();
			notifier.registerMe(recv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
