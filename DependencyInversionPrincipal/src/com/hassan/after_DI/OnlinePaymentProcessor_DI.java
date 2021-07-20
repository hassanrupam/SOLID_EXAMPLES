package com.hassan.after_DI;

import com.hassan.before_DI.IPaymentProcessor_ISP;
import com.hassan.before_DI.IReceiptSender;
import com.hassan.before_DI.Order;
import com.hassan.before_DI.SMSAuthorizer;

public class OnlinePaymentProcessor_DI implements IPaymentProcessor_ISP, IReceiptSender {
    private String _email;
    private Authorizer authorizer;

    public OnlinePaymentProcessor_DI(String _email , Authorizer _authorizer) {
        this._email =  _email;
        this.authorizer =  _authorizer;
    }

    @Override
    public void processPayment(Order _order) {
        if(!authorizer.isAuthorized()){
            System.out.println("Payment Not Authorized");
            return;
        }
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
    @Override
    public void sendReceiptOnEmail(String _email) {
        System.out.println("Receipt sent to  : " + _email);
    }
}
