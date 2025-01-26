package org.example;

import org.example.order.Order;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
    private String name;
    Order order;

    public Client(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public Order makeRequest(String name, Double price) {
        this.order = new Order(name, price, this);
        return order;
    }

    public void cancelOrder() {
        this.order.cancelOrder();
        this.order = null;
    }

    @Override
    public void update(Observable order, Object arg) {
        if (order instanceof Order) {
            Order currentOrder = (Order) order;
            System.out.println("Status updated: " + currentOrder.getStatus().getStatus());
        } else {
            System.out.println("Update received from unknown observable");
        }
    }
}
