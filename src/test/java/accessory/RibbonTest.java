package accessory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RibbonTest {
    private Ribbon ribbon;

    @BeforeEach
    void setUp() {
        ribbon = new Ribbon(17.65, 30);
    }

    @Test
    void testConstructor() {
        Ribbon newRibbon = new Ribbon(20.0, 50);
        assertEquals(20.0, newRibbon.getPrice(), "Ціна повинна бути 20.0");
        assertEquals(50, newRibbon.getLength(), "Довжина повинна бути 50 см");
    }

    @Test
    void testToString() {
        String expected = "Стрічка, довжина: 30 см, ціна: 17.65 грн";
        assertEquals(expected, ribbon.toString(), "Метод має повернути коректно");
    }

    @Test
    void testGetPrice() {
        assertEquals(17.65, ribbon.getPrice(), "Ціна повинна бути 17.65");
    }

    @Test
    void testGetLength() {
        assertEquals(30, ribbon.getLength(), "Довжина повинна бути 30 см");
    }

    @Test
    void testSetLength() {
        ribbon.setLength(40);
        assertEquals(40, ribbon.getLength(), "Довжина повинна бути 40 см");
    }

    @Test
    void testSetNegativeLength() {
        ribbon.setLength(-10);
        assertEquals(-10, ribbon.getLength(), "Довжина може бути від'ємною в даному випадку");
    }
}
