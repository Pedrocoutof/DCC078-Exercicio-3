package org.example.order.status;
import org.example.order.Order;

public abstract class OrderStatus {

    protected Order order;

    public OrderStatus(Order order) {
        this.order = order;
    }

    public abstract String getStatus();

    public abstract void next();
}
