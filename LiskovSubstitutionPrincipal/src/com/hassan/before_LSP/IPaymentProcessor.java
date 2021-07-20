package com.hassan.before_LSP;

public interface IPaymentProcessor {
    public void processPayment(Order _order, String _security_code);

    public void isPaid(Order _order);

    public void sendReceiptOnEmail(String _email);
}
