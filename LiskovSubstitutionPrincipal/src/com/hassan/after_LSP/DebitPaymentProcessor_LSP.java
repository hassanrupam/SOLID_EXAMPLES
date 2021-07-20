package com.hassan.after_LSP;

import com.hassan.before_LSP.IPaymentProcessor;
import com.hassan.before_LSP.Order;

public class DebitPaymentProcessor_LSP implements IPaymentProcessor_LSP {
    private String _security_code;

    public DebitPaymentProcessor_LSP(String _security_code) {
        this._security_code =  _security_code;
    }
    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Debit Payment");
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
