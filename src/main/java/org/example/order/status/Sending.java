package org.example.order.status;

import org.example.order.Order;

public class Sending extends OrderStatus {

    public Sending(Order order) {
        super(order);
    }

    @Override
    public String getStatus() {
        return "Sending";
    }

    @Override
    public void next() {
        this.order.setStatus(new Delivered(order));
    }
}
