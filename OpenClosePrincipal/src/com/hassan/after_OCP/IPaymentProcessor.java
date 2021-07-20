package com.hassan.after_OCP;

import com.hassan.before_OCP.Order_SRP;

public interface IPaymentProcessor {
    public void processPayment(Order_SRP _order, String _security_code);

    public void isPaid(Order_SRP _order);
}
