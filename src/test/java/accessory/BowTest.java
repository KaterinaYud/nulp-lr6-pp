package accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowTest {
    private Bow bow;

    @BeforeEach
    void setUp() {
        bow = new Bow(12.56, 20);
    }

    @Test
    void testGetPrice() {
        assertEquals(12.56, bow.getPrice(), "Ціна - 12.56");
    }

    @Test
    void testGetSize() {
        assertEquals(20, bow.getSize(), "Розмір банта - 20 см");
    }

    @Test
    void testSetSize() {
        bow.setSize(30);
        assertEquals(30, bow.getSize(), "Розмір банта - 30 см");
    }

    @Test
    void testConstructor() {
        Bow newBow = new Bow(25.0, 35);
        assertEquals(25.0, newBow.getPrice(), "Ціна - 25.0");
        assertEquals(35, newBow.getSize(), "Розмір банта - 35 см");
    }

    @Test
    void testChangeProperties() {
        bow.setPrice(15.00);
        bow.setSize(25);
        assertEquals(15.00, bow.getPrice(), "Ціна - 15.00");
        assertEquals(25, bow.getSize(), "Розмір банта - 25 см");
    }

    @Test
    void testString() {
        String expected = "Бант, розмір: 20 см, ціна: 12.56 грн";
        assertEquals(expected, bow.toString(), "Метод має повернути коректно");
    }
}
