package com.hassan.after_LSP;

import com.hassan.before_LSP.Order;

public interface IPaymentProcessor_LSP {
    public void processPayment(Order _order);

    public void isPaid(Order _order);
}
