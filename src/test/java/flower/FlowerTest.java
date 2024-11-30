package flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Chamomile("червоний", 20.0, 10, 25, 30);
    }

    @Test
    void getColor() {
        assertEquals("червоний", flower.getColor());
    }

    @Test
    void getPrice() {
        assertEquals(20.0, flower.getPrice());
    }

    @Test
    void getFreshness() {
        assertEquals(10, flower.getFreshness());
    }

    @Test
    void getStemLength() {
        assertEquals(25, flower.getStemLength());
    }

    @Test
    void testToString() {
        String expectedString = "Ромашка, колір: червоний, ціна: 20.0, свіжість: 10 днів, довжина стебла: 25 см, кількість пелюсток: 30";
        assertEquals(expectedString, flower.toString());
    }

    @Test
    void setColor() {
        flower.setColor("синій");
        assertEquals("синій", flower.getColor());
    }

    @Test
    void setPrice() {
        flower.setPrice(25.0);
        assertEquals(25.0, flower.getPrice());
    }

    @Test
    void setFreshness() {
        flower.setFreshness(15);
        assertEquals(15, flower.getFreshness());
    }

    @Test
    void setStemLength() {
        flower.setStemLength(30);
        assertEquals(30, flower.getStemLength());
    }
}
