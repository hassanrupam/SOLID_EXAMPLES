package com.hassan.core;

import com.hassan.after_ISP.CreditPaymentProcessor_ISP;
import com.hassan.after_ISP.DebitPaymentProcessor_ISP;
import com.hassan.after_ISP.OnlinePaymentProcessor_ISP;
import com.hassan.before_ISP.CreditPaymentProcessor;
import com.hassan.before_ISP.DebitPaymentProcessor;
import com.hassan.before_ISP.OnlinePaymentProcessor;
import com.hassan.before_ISP.Order;

public class Main {

    public static void main(String[] args) {
	// Before Interface Segregation
        Order oder = new Order("ORD-002");

        oder.add_Item("Keayboard",5.0,300.0);
        oder.add_Item("Mouse",2.0,250.0);
        oder.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + oder.totalPrice());
        CreditPaymentProcessor creditPaymentProcessor =  new CreditPaymentProcessor();
        creditPaymentProcessor.isPaid(oder);
        creditPaymentProcessor.processPayment(oder,"123456");
        creditPaymentProcessor.isPaid(oder);

        DebitPaymentProcessor debitPaymentProcessor =  new DebitPaymentProcessor();
        debitPaymentProcessor.isPaid(oder);
        debitPaymentProcessor.processPayment(oder,"123456");
        debitPaymentProcessor.isPaid(oder);

        OnlinePaymentProcessor onlinePaymentProcessor =  new OnlinePaymentProcessor();
        onlinePaymentProcessor.isPaid(oder);
        onlinePaymentProcessor.processPayment(oder,"123456");
        onlinePaymentProcessor.isPaid(oder);
        onlinePaymentProcessor.sendReceiptOnEmail("Test@LSP.com");

        System.out.println("\n");
        //after Interface Segregation
        CreditPaymentProcessor_ISP creditPaymentProcessor_lsp =  new CreditPaymentProcessor_ISP();
        creditPaymentProcessor_lsp.isPaid(oder);
        creditPaymentProcessor_lsp.processPayment(oder,"123456");
        creditPaymentProcessor_lsp.isPaid(oder);

        DebitPaymentProcessor_ISP debitPaymentProcessor_lsp =  new DebitPaymentProcessor_ISP();
        debitPaymentProcessor_lsp.isPaid(oder);
        debitPaymentProcessor_lsp.processPayment(oder,"123456");
        debitPaymentProcessor_lsp.isPaid(oder);

        OnlinePaymentProcessor_ISP onlinePaymentProcessor_lsp =  new OnlinePaymentProcessor_ISP();
        onlinePaymentProcessor_lsp.isPaid(oder);
        onlinePaymentProcessor_lsp.processPayment(oder,"123456");
        onlinePaymentProcessor_lsp.isPaid(oder);
        onlinePaymentProcessor_lsp.sendReceiptOnEmail("Test@LSP.com");

       

    }
}
