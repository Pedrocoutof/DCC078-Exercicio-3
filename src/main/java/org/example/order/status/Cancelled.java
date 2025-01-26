package org.example.order.status;

import org.example.order.Order;

public class Cancelled extends OrderStatus {

    public Cancelled(Order order) {
        super(order);
    }

    @Override
    public String getStatus() {
        return "Cancelled";
    }

    @Override
    public void next() {
        // do nothing
    }

}
