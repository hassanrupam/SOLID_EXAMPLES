package com.hassan.after_ISP;

import com.hassan.before_ISP.Order;

public class OnlinePaymentProcessor_ISP implements IPaymentProcessor_ISP,IReceiptSender {
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

    @Override
    public void sendReceiptOnEmail(String _email) {
        System.out.println("Receipt sent to  : " + _email);
    }
}
