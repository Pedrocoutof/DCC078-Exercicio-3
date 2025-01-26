package org.example.order;

import org.example.Client;
import org.example.order.status.*;

import java.util.Observable;

public class Order extends Observable {

    private String name;
    private Double value;
    private OrderStatus status;
    private Client client;

    public Order(String name, Double value, Client client) {
        setName(name);
        setValue(value);
        this.status = new Recived(this);
        this.client = client;
        this.addObserver(this.client);
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
    }

    public void setValue(Double value) {
        if(value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }

        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void nextStatus() {
        setChanged();
        this.status.next();
        notifyObservers();
    }

    public void cancelOrder() {
        if (this.canCancel()) {
            setChanged();
            this.status = new Cancelled(this);
            notifyObservers();
        } else {
            throw new IllegalStateException("Cancellation refused");
        }
    }

    private boolean canCancel() {
        String currentStatus = this.status.getStatus();
        return !currentStatus.equals("Delivered") && !currentStatus.equals("Cancelled");
    }

}