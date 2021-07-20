package com.hassan.core;

import com.hassan.after_SRP.Order_SRP;
import com.hassan.after_SRP.PaymentProcessor;
import com.hassan.before_SRP.Order;

public class Main {

    public static void main(String[] args) {
	// Before Single Responsibility
        Order order =  new Order("ORD-001");

        order.add_Item("Keayboard",5.0,300.0);
        order.add_Item("Mouse",2.0,250.0);
        order.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + order.totalPrice());
        order.isPaid();
        order.payment("Debit","123456");
        order.isPaid();

        System.out.println("\n\n");
        // After Single Responsibility
        Order_SRP oder_SRP = new Order_SRP("ORD-002");

        oder_SRP.add_Item("Keayboard",5.0,300.0);
        oder_SRP.add_Item("Mouse",2.0,250.0);
        oder_SRP.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + oder_SRP.totalPrice());
        PaymentProcessor paymentProcessor =  new PaymentProcessor();
        paymentProcessor.isPaid(oder_SRP);
        paymentProcessor.payDebit(oder_SRP,"123456");
        paymentProcessor.isPaid(oder_SRP);



    }
}
