package color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testValidColors() {
        assertTrue(Color.isValidColor("ЧЕРВОНИЙ"));
        assertTrue(Color.isValidColor("БІЛИЙ"));
        assertTrue(Color.isValidColor("рожевий"));
        assertTrue(Color.isValidColor("блакитний"));
    }

    @Test
    void testInvalidColors() {
        assertFalse(Color.isValidColor("ФУКСІЯ"));
        assertFalse(Color.isValidColor("СРІБНИЙ"));
        assertFalse(Color.isValidColor(""));
    }

    @Test
    void testCaseInsensitivity() {
        assertTrue(Color.isValidColor("червоний"));
        assertTrue(Color.isValidColor("БІЛИЙ"));
        assertTrue(Color.isValidColor("ЖовТиЙ"));
        assertTrue(Color.isValidColor("бЛаКиТнИй"));
    }
}
