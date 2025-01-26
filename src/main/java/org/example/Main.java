package org.example;

import org.example.order.Order;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("João");
        client.makeRequest("Hamburguer", 19.99);

        Order order = client.getOrder();

        System.out.println("Order Name: " + order.getName());
        System.out.println("Order Value: " + order.getValue());

        order.nextStatus();
        order.nextStatus();
        order.nextStatus();

        System.out.println();

        client.makeRequest("Pizza", 39.59);
        order = client.getOrder();
        System.out.println("Order Name: " + order.getName());
        System.out.println("Order Value: " + order.getValue());

        order.nextStatus();
        order.nextStatus();
        client.cancelOrder();


    }
}