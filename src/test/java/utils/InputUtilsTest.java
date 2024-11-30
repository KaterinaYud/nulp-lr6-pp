package utils;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    @Test
    void getValidInt() {
        String input = "42";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = InputUtils.getValidInt("Введіть число: ");
        assertEquals(42, result, "Введене число - 42");
        System.setIn(stdin);
    }

    @Test
    void getValidDouble() {
        String input = "42.5";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        double result = InputUtils.getValidDouble("Введіть десяткове число: ");
        assertEquals(42.5, result, "Введене число - 42.5");
        input = "abc\n45.5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        result = InputUtils.getValidDouble("Введіть десяткове число: ");
        assertEquals(45.5, result, "Введене число - 45.5");
        System.setIn(stdin);
    }

    @Test
    void getValidBoolean() {
        String input = "true";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean result = InputUtils.getValidBoolean("Введіть true або false: ");
        assertTrue(result, "Введене значення - true");
        input = "maybe\nfalse";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        result = InputUtils.getValidBoolean("Введіть true або false: ");
        assertFalse(result, "Після неправильного - false");
        System.setIn(stdin);
    }

    @Test
    void getStringInput() {
        String input = "Test";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = InputUtils.getStringInput("Введіть рядок: ");
        assertEquals("Test", result, "Введений рядок - 'Test'");
        input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        result = InputUtils.getStringInput("Введіть рядок: ");
        assertEquals("", result, "Введений рядок порожній");
        input = "   This is a test   ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        result = InputUtils.getStringInput("Введіть рядок: ");
        assertEquals("   This is a test   ", result, "Введений рядок - '   This is a test   '");
        System.setIn(stdin);
    }
}
