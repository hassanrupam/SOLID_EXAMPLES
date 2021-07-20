package com.hassan.before_OCP;

import com.hassan.before_OCP.Order_SRP;

public class PaymentProcessor {
    public void payDebit(Order_SRP _order,String _security_code){
        System.out.println("Processing Debit Payment");
        System.out.println("Security Code for order : "+ _order.getOrderNumber() +" is : " + _security_code);
        _order.setPaid(true);
    }

    public void payCredit(Order_SRP _order,String _security_code){
        System.out.println("Processing Credit Payment");
        System.out.println("Security Code for order : "+  _order.getOrderNumber()+" is : " + _security_code);
        _order.setPaid(true);
    }

    public void payOnline(Order_SRP _order,String _security_code){
        System.out.println("Processing Online Payment");
        System.out.println("Security Code for order : "+  _order.getOrderNumber()+" is : " + _security_code);
        _order.setPaid(true);
    }

    public void isPaid(Order_SRP _order){
        if (_order.getPaid().equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }
}
