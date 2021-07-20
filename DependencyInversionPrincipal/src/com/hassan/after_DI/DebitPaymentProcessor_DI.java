package com.hassan.after_DI;

import com.hassan.before_DI.IPaymentProcessor_ISP;
import com.hassan.before_DI.Order;
import com.hassan.before_DI.SMSAuthorizer;

public class DebitPaymentProcessor_DI implements IPaymentProcessor_ISP {

    private String _security_code;
    private Authorizer authorizer;

    public DebitPaymentProcessor_DI(String _security_code, Authorizer _authorizer) {
        this._security_code =  _security_code;
        this.authorizer =  _authorizer;
    }
    @Override
    public void processPayment(Order _order) {
        if(!authorizer.isAuthorized()){
            System.out.println("Payment Not Authorized");
            return;
        }
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
