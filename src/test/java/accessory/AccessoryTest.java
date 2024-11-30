package accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest {
    private Accessory accessory;

    @BeforeEach
    void setUp() {
        accessory = new Accessory(50.0);
    }

    @Test
    void getPrice() {
        assertEquals(50.0, accessory.getPrice(), "Ціна - 50");
    }

    @Test
    void setPrice() {
        accessory.setPrice(200.0);
        assertEquals(200.0, accessory.getPrice(), "Ціна - 200");
    }

    @Test
    void setZeroPrice(){
        accessory.setPrice(0.0);
        assertEquals(0.0, accessory.getPrice(), "Ціна - 0");
    }
}