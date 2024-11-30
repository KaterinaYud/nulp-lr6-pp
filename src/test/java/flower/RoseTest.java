package flower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoseTest {

    @Test
    void testRoseCreation() {
        Rose rose = new Rose("червоний", 25.0, 4, 56, true);
        assertEquals("червоний", rose.getColor());
        assertEquals(25.0, rose.getPrice());
        assertEquals(4, rose.getFreshness());
        assertEquals(56, rose.getStemLength());
        assertEquals("Троянда, колір: червоний, ціна: 25.0, свіжість: 4 днів, довжина стебла: 56 см, має шипи: так", rose.toString());
    }

    @Test
    void testRoseWithSpikes() {
        Rose rose = new Rose("червоний", 100.0, 2, 50, true);
        String expected = "Троянда, колір: червоний, ціна: 100.0, свіжість: 2 днів, довжина стебла: 50 см, має шипи: так";
        assertEquals(expected, rose.toString());
    }
}

