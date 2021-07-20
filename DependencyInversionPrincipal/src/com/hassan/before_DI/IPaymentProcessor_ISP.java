package com.hassan.before_DI;

public interface IPaymentProcessor_ISP {
    public void processPayment(Order _order);

    public void isPaid(Order _order);
}
