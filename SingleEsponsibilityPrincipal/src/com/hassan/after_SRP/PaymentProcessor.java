package com.hassan.after_SRP;

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

    public void isPaid(Order_SRP _order){
        if (_order.getPaid().equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }
}
