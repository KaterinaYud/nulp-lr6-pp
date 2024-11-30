package flower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LilyTest {

    @Test
    void testLilyCreation() {
        Lily lily = new Lily("білий", 15.5, 2, 36, true);
        assertEquals("білий", lily.getColor());
        assertEquals(15.5, lily.getPrice());
        assertEquals(2, lily.getFreshness());
        assertEquals(36, lily.getStemLength());
        assertEquals("Лілія, колір: білий, ціна: 15.5, свіжість: 2 днів, довжина стебла: 36 см, має аромат: так", lily.toString());
    }

    @Test
    void testSettersLily() {
        Lily lily = new Lily("Жовтий", 15.5, 2, 36, true);
        lily.setColor("Жовтий");
        lily.setPrice(15.5);
        lily.setFreshness(2);
        lily.setStemLength(36);
        assertEquals("Жовтий", lily.getColor());
        assertEquals(15.5, lily.getPrice());
        assertEquals(2, lily.getFreshness());
        assertEquals(36, lily.getStemLength());
    }

    @Test
    void testLilyWithAroma() {
        Lily lily = new Lily("жовтий", 120.0, 9, 65, true);
        String expected = "Лілія, колір: жовтий, ціна: 120.0, свіжість: 9 днів, довжина стебла: 65 см, має аромат: так";
        assertEquals(expected, lily.toString());
    }

    @Test
    void testLilyWithoutAroma() {
        Lily lily = new Lily("білий", 90.0, 3, 35, false);
        String expected = "Лілія, колір: білий, ціна: 90.0, свіжість: 3 днів, довжина стебла: 35 см, має аромат: ні";
        assertEquals(expected, lily.toString());
    }

}
