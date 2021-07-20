package com.hassan.core;

import com.hassan.after_LSP.CreditPaymentProcessor_LSP;
import com.hassan.after_LSP.DebitPaymentProcessor_LSP;
import com.hassan.after_LSP.OnlinePaymentProcessor_LSP;
import com.hassan.before_LSP.CreditPaymentProcessor;
import com.hassan.before_LSP.DebitPaymentProcessor;
import com.hassan.before_LSP.OnlinePaymentProcessor;
import com.hassan.before_LSP.Order;

public class Main {

    public static void main(String[] args) {
	// Before Liskov Substitution
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
        onlinePaymentProcessor.processPayment(oder,"Test@LSP.com");
        onlinePaymentProcessor.isPaid(oder);

        System.out.println("\n");
        //after Open Close


        CreditPaymentProcessor_LSP creditPaymentProcessor_lsp =  new CreditPaymentProcessor_LSP("123456");
        creditPaymentProcessor_lsp.isPaid(oder);
        creditPaymentProcessor_lsp.processPayment(oder);
        creditPaymentProcessor_lsp.isPaid(oder);

        DebitPaymentProcessor_LSP debitPaymentProcessor_lsp =  new DebitPaymentProcessor_LSP("123456");
        debitPaymentProcessor_lsp.isPaid(oder);
        debitPaymentProcessor_lsp.processPayment(oder);
        debitPaymentProcessor_lsp.isPaid(oder);

        OnlinePaymentProcessor_LSP onlinePaymentProcessor_lsp =  new OnlinePaymentProcessor_LSP("Test@LSP.com");
        onlinePaymentProcessor_lsp.isPaid(oder);
        onlinePaymentProcessor_lsp.processPayment(oder);
        onlinePaymentProcessor_lsp.isPaid(oder);

       

    }
}
