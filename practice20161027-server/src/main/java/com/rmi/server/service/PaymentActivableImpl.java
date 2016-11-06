package com.rmi.server.service;

import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;

public class PaymentActivableImpl extends Activatable implements PaymentActivable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6877213377856545275L;
	public PaymentActivableImpl(ActivationID id, MarshalledObject data) 
                                                throws RemoteException {
        super(id, 0);
    }    
    public double calculatePayment(double principal, double annRate, int years)
                                  throws RemoteException {
        double monthlyInt = annRate / 12;
        double monthlyPayment = (principal * monthlyInt)
                    / (1 - Math.pow(1/ (1 + monthlyInt), years * 12));
        return format(monthlyPayment, 2);
    }
    public double format(double amount, int places) {
        double temp = amount; 
        temp = temp * Math.pow(10, places);
        temp = Math.round(temp);
        temp = temp/Math.pow(10, places);
        return temp;
    }
}