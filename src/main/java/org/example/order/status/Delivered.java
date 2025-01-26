package org.example.order.status;

import org.example.order.Order;

public class Delivered extends OrderStatus {

    public Delivered(Order order) {
        super(order);
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }

    @Override
    public void next() {
        // do nothing
    }
}
