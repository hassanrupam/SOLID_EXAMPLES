package com.hassan.core;

import com.hassan.after_OCP.CreditPaymentProcessor;
import com.hassan.after_OCP.DebitPaymentProcessor;
import com.hassan.after_OCP.OnlinePaymentProcessor;
import com.hassan.before_OCP.Order_SRP;
import com.hassan.before_OCP.PaymentProcessor;

public class Main {

    public static void main(String[] args) {
	// before Open Close Principal
        Order_SRP oder_SRP = new Order_SRP("ORD-002");

        oder_SRP.add_Item("Keayboard",5.0,300.0);
        oder_SRP.add_Item("Mouse",2.0,250.0);
        oder_SRP.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + oder_SRP.totalPrice());
        PaymentProcessor paymentProcessor =  new PaymentProcessor();
        paymentProcessor.isPaid(oder_SRP);
        paymentProcessor.payDebit(oder_SRP,"123456");
        paymentProcessor.isPaid(oder_SRP);

        System.out.println("\n");
        //after Open Close

        System.out.println("Total Price : " + oder_SRP.totalPrice());
        CreditPaymentProcessor creditPaymentProcessor =  new CreditPaymentProcessor();
        creditPaymentProcessor.isPaid(oder_SRP);
        creditPaymentProcessor.processPayment(oder_SRP,"123456");
        creditPaymentProcessor.isPaid(oder_SRP);

        DebitPaymentProcessor debitPaymentProcessor =  new DebitPaymentProcessor();
        debitPaymentProcessor.isPaid(oder_SRP);
        debitPaymentProcessor.processPayment(oder_SRP,"123456");
        debitPaymentProcessor.isPaid(oder_SRP);

        OnlinePaymentProcessor onlinePaymentProcessor =  new OnlinePaymentProcessor();
        onlinePaymentProcessor.isPaid(oder_SRP);
        onlinePaymentProcessor.processPayment(oder_SRP,"123456");
        onlinePaymentProcessor.isPaid(oder_SRP);
    }
}
