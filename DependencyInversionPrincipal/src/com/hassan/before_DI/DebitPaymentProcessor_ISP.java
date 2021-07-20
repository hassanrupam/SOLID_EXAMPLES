package com.hassan.before_DI;

public class DebitPaymentProcessor_ISP implements IPaymentProcessor_ISP {

    private String _security_code;
    private SMSAuthorizer smsAuthorizer;

    public DebitPaymentProcessor_ISP(String _security_code,SMSAuthorizer _smsAuthorizer) {
        this._security_code =  _security_code;
        this.smsAuthorizer =  _smsAuthorizer;
    }
    @Override
    public void processPayment(Order _order) {
        smsAuthorizer.authorizeCode(_security_code);
        if(!smsAuthorizer.isAuthorized()){
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
