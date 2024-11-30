package accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GiftWrapTest {
    private GiftWrap giftWrap;

    @BeforeEach
    void setUp() {
        giftWrap = new GiftWrap(25.5, "червоний");
    }

    @Test
    void testGetPrice() {
        assertEquals(25.5, giftWrap.getPrice(), "Ціна - 25.5");
    }

    @Test
    void testConstructor() {
        GiftWrap newGiftWrap = new GiftWrap(30.0, "зелений");
        assertEquals(30.0, newGiftWrap.getPrice(), "Ціна - 30.0");
        assertEquals("зелений", newGiftWrap.getColor(), "Колір обгортки - зелений");
    }

    @Test
    void ToString() {
        String expected = "Подарункова обгортка, колір: червоний, ціна: 25.5 грн";
        assertEquals(expected, giftWrap.toString(), "Метод має повернути коректно");
    }

    @Test
    void testGetColor() {
        assertEquals("червоний", giftWrap.getColor(), "Колір обгортки - червоний");
    }

    @Test
    void testSetColor() {
        giftWrap.setColor("синій");
        assertEquals("синій", giftWrap.getColor(), "Колір обгортки - синій");
    }

    @Test
    void testSetPrice() {
        giftWrap.setPrice(40.0);
        assertEquals(40.0, giftWrap.getPrice(), "Ціна - 40.0");
    }
}
