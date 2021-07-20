package com.hassan.after_LSP;

import com.hassan.before_LSP.IPaymentProcessor;
import com.hassan.before_LSP.Order;

public class CreditPaymentProcessor_LSP implements IPaymentProcessor_LSP {
    private String _security_code;

    public CreditPaymentProcessor_LSP(String _security_code) {
        this._security_code =  _security_code;
    }

    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Credit Payment");
        System.out.println("Security Code for order : "+ _order.getOrderNumber() +" is : " + this._security_code);
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
