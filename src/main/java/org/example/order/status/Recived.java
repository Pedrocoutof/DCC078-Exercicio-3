package org.example.order.status;

import org.example.order.Order;

public class Recived extends OrderStatus {

    public Recived(Order order) {
        super(order);
    }

    @Override
    public String getStatus() {
        return "Recived";
    }

    @Override
    public void next() {
        this.order.setStatus(new Preparing(order));
    }
}
