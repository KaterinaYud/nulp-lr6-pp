package flower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChamomileTest {

    @Test
    void testChamomileCreation() {
        Chamomile chamomile = new Chamomile("Білий", 10.5, 5, 15, 20);
        assertEquals("Білий", chamomile.getColor());
        assertEquals(10.5, chamomile.getPrice());
        assertEquals(5, chamomile.getFreshness());
        assertEquals(15, chamomile.getStemLength());
        assertEquals("Ромашка, колір: Білий, ціна: 10.5, свіжість: 5 днів, довжина стебла: 15 см, кількість пелюсток: 20", chamomile.toString());
    }

    @Test
    void testSettersChamomile() {
        Chamomile chamomile = new Chamomile("Білий", 10.5, 5, 15, 20);
        chamomile.setColor("Жовтий");
        chamomile.setPrice(12.0);
        chamomile.setFreshness(7);
        chamomile.setStemLength(20);
        assertEquals("Жовтий", chamomile.getColor());
        assertEquals(12.0, chamomile.getPrice());
        assertEquals(7, chamomile.getFreshness());
        assertEquals(20, chamomile.getStemLength());
    }
}
