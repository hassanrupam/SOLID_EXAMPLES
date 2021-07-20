package com.hassan.after_OCP;

import com.hassan.before_OCP.Order_SRP;

public class CreditPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order_SRP _order, String _security_code) {
        System.out.println("Processing Credit Payment");
        System.out.println("Security Code for order : "+ _order.getOrderNumber() +" is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order_SRP _order) {
        if (_order.getPaid().equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }
}
