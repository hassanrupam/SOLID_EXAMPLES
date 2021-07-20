package com.hassan.after_ISP;

import com.hassan.before_ISP.Order;

public interface IPaymentProcessor_ISP {
    public void processPayment(Order _order, String _security_code);

    public void isPaid(Order _order);
}
