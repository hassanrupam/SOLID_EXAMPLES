package com.hassan.before_ISP;

public class DebitPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Debit Payment");
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

    @Override
    public void sendReceiptOnEmail(String _email) {
    }
}
