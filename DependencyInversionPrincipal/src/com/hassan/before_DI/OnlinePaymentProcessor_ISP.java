package com.hassan.before_DI;

public class OnlinePaymentProcessor_ISP implements IPaymentProcessor_ISP,IReceiptSender {
    private String _email;
    private SMSAuthorizer smsAuthorizer;

    public OnlinePaymentProcessor_ISP(String _email ,SMSAuthorizer _smsAuthorizer) {
        this._email =  _email;
        this.smsAuthorizer =  _smsAuthorizer;
    }

    @Override
    public void processPayment(Order _order) {
        smsAuthorizer.authorizeCode(_email);
        if(!smsAuthorizer.isAuthorized()){
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
