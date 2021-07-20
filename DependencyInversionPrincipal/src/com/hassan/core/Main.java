package com.hassan.core;

import com.hassan.after_DI.*;
import com.hassan.before_DI.*;

public class Main {

    public static void main(String[] args) {
	// Before Dependency Inversion
        Order oder = new Order("ORD-002");

        oder.add_Item("Keyboard",5.0,300.0);
        oder.add_Item("Mouse",2.0,250.0);
        oder.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + oder.totalPrice());
        SMSAuthorizer smsAuthorizer =  new SMSAuthorizer();
        CreditPaymentProcessor_ISP creditPaymentProcessor =  new CreditPaymentProcessor_ISP("123456",smsAuthorizer);
        creditPaymentProcessor.isPaid(oder);
        creditPaymentProcessor.processPayment(oder);
        creditPaymentProcessor.isPaid(oder);

        DebitPaymentProcessor_ISP debitPaymentProcessor =  new DebitPaymentProcessor_ISP("123456",smsAuthorizer);
        debitPaymentProcessor.isPaid(oder);
        debitPaymentProcessor.processPayment(oder);
        debitPaymentProcessor.isPaid(oder);

        OnlinePaymentProcessor_ISP onlinePaymentProcessor =  new OnlinePaymentProcessor_ISP("Test@DI.com",smsAuthorizer);
        onlinePaymentProcessor.isPaid(oder);
        onlinePaymentProcessor.processPayment(oder);
        onlinePaymentProcessor.isPaid(oder);
        onlinePaymentProcessor.sendReceiptOnEmail("Test@LSP.com");

        System.out.println("\n");
        //After Dependency Inversion
        System.out.println("Total Price : " + oder.totalPrice());
        SMSAuthorizer_DI smsAuthorizer_DI =  new SMSAuthorizer_DI();


        CreditPaymentProcessor_DI creditPaymentProcessor_di =  new CreditPaymentProcessor_DI("123456",smsAuthorizer_DI);
        creditPaymentProcessor_di.isPaid(oder);
        smsAuthorizer_DI.authorizeCode("123456");
        creditPaymentProcessor_di.processPayment(oder);
        creditPaymentProcessor_di.isPaid(oder);

        DebitPaymentProcessor_DI debitPaymentProcessor_di =  new DebitPaymentProcessor_DI("123456",smsAuthorizer_DI);
        debitPaymentProcessor_di.isPaid(oder);
        smsAuthorizer_DI.authorizeCode("123456");
        debitPaymentProcessor_di.processPayment(oder);
        debitPaymentProcessor_di.isPaid(oder);


        BotAuthorizer_DI botAuthorizer_DI =  new BotAuthorizer_DI();
        OnlinePaymentProcessor_DI onlinePaymentProcessor_di =  new OnlinePaymentProcessor_DI("Test@DI.com",botAuthorizer_DI);
        onlinePaymentProcessor_di.isPaid(oder);
        botAuthorizer_DI.isABot();
        onlinePaymentProcessor_di.processPayment(oder);
        onlinePaymentProcessor_di.isPaid(oder);
        onlinePaymentProcessor_di.sendReceiptOnEmail("Test@LSP.com");
    }
}
