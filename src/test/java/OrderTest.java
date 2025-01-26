import org.example.Client;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void tryCreateOrderWithInvalidName() {
        try {
            Client client = new Client("Pedro");
            Order order = new Order("", 10.99, client);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void tryCreateOrderWithInvalidPrice() {
        try {
            Client client = new Client("Pedro");
            Order order = new Order("Hamburguer", -10.0, client);
        } catch (IllegalArgumentException e) {
            assertEquals("Value cannot be negative", e.getMessage());
        }
    }

    @Test
    public void tryCreateValidOrder() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
    }

    @Test
    public void verifyFirstOrderStatus() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);

        assertEquals("Recived", order.getStatus().getStatus());
    }

    @Test
    public void verifySecondOrderStatus() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();

        assertEquals("Preparing", order.getStatus().getStatus());
    }

    @Test
    public void verifyThirdOrderStatus() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();
        order.nextStatus();

        assertEquals("Sending", order.getStatus().getStatus());
    }

    @Test
    public void verifyFourthOrderStatus() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();
        order.nextStatus();
        order.nextStatus();

        assertEquals("Delivered", order.getStatus().getStatus());
    }

    @Test
    public void tryCancelRecivedOrder() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.cancelOrder();

        assertEquals("Cancelled", order.getStatus().getStatus());
    }

    @Test
    public void tryCancelPreparingOrder() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();
        order.cancelOrder();

        assertEquals("Cancelled", order.getStatus().getStatus());
    }

    @Test
    public void trySendingPreparingOrder() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();
        order.nextStatus();
        order.cancelOrder();

        assertEquals("Cancelled", order.getStatus().getStatus());
    }

    @Test
    public void tryCancelDeliveredOrder() {
        Client client = new Client("Pedro");
        Order order = new Order("Hamburguer", 19.99, client);
        order.nextStatus();
        order.nextStatus();
        order.nextStatus();

        try {
            order.cancelOrder();
        } catch (IllegalStateException e) {
            assertEquals("Cancellation refused", e.getMessage());
        }
    }
}
