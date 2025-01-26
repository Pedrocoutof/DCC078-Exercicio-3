import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    public void tryCreateClientWithValidName() {
        Client client = new Client("Pedro");
        assertEquals("Pedro", client.getName());
    }

    @Test
    public void tryCreateClientWithInvalidName() {
        try {
            Client client = new Client("");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null or empty", e.getMessage());
        }
    }

}
