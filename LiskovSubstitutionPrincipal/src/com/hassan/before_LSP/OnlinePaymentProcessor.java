package com.hassan.before_LSP;

public class OnlinePaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Online Payment");
        System.out.println("Email for order : "+ _order.getOrderNumber() +" is : " + _security_code);
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
