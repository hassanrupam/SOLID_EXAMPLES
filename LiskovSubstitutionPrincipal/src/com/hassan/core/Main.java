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
        onlinePaymentProcessor.processPayment(oder,"123456");
        onlinePaymentProcessor.isPaid(oder);
        onlinePaymentProcessor.sendReceiptOnEmail("Test@LSP.com");

        System.out.println("\n");
        //after Open Close


        CreditPaymentProcessor_LSP creditPaymentProcessor_lsp =  new CreditPaymentProcessor_LSP();
        creditPaymentProcessor_lsp.isPaid(oder);
        creditPaymentProcessor_lsp.processPayment(oder,"123456");
        creditPaymentProcessor_lsp.isPaid(oder);

        DebitPaymentProcessor_LSP debitPaymentProcessor_lsp =  new DebitPaymentProcessor_LSP();
        debitPaymentProcessor_lsp.isPaid(oder);
        debitPaymentProcessor_lsp.processPayment(oder,"123456");
        debitPaymentProcessor_lsp.isPaid(oder);

        OnlinePaymentProcessor_LSP onlinePaymentProcessor_lsp =  new OnlinePaymentProcessor_LSP();
        onlinePaymentProcessor_lsp.isPaid(oder);
        onlinePaymentProcessor_lsp.processPayment(oder,"123456");
        onlinePaymentProcessor_lsp.isPaid(oder);
        onlinePaymentProcessor_lsp.sendReceiptOnEmail("Test@LSP.com");

       

    }
}
