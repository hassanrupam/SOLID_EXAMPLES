package com.hassan.after_LSP;

import com.hassan.before_LSP.Order;

public class CreditPaymentProcessor_LSP implements IPaymentProcessor_LSP{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Credit Payment");
        System.out.println("Security Code for order : "+ _order.getOrderNumber() +" is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (_order.getPaid().equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }
}
