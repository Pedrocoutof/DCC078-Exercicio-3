package org.example.order.status;

import org.example.order.Order;

public class Preparing extends OrderStatus {

    public Preparing(Order order) {
        super(order);
    }

    @Override
    public String getStatus() {
        return "Preparing";
    }

    @Override
    public void next() {
        this.order.setStatus(new Sending(order));
    }
}