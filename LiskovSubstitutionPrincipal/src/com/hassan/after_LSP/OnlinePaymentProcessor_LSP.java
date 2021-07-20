package com.hassan.after_LSP;

import com.hassan.before_LSP.IPaymentProcessor;
import com.hassan.before_LSP.Order;

public class OnlinePaymentProcessor_LSP implements IPaymentProcessor_LSP {
    private String _email;

    public OnlinePaymentProcessor_LSP(String _email) {
        this._email =  _email;
    }

    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Online Payment");
        System.out.println("Email for order : "+ _order.getOrderNumber() +" is : " + this._email);
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
