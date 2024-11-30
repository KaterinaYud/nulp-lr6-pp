package main;
import flower.*;
import org.junit.jupiter.api.*;
import utils.ReadFromFile;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testFlowersFromFile() {
        List<Flower> flowerList = ReadFromFile.flowersFromFile("src/Flower.txt");
        assertNotNull(flowerList);
        assertFalse(flowerList.isEmpty(), "Список квітів не повинен бути порожнім.");
    }

    @Test
    void testEmptyFlowerList() {
        List<Flower> emptyList = ReadFromFile.flowersFromFile("src/EmptyFlower.txt");
        assertTrue(emptyList.isEmpty(), "Список квітів має бути порожнім.");
    }

    @Test
    void testFileNotFound() {
        List<Flower> flowers = ReadFromFile.flowersFromFile("src/NonExistentFile.txt");
        assertTrue(flowers.isEmpty(), "Список квітів має бути порожнім, якщо файл не існує.");
        String output = outputStream.toString();
        assertTrue(output.contains("Файл не знайдено"), "Має бути виведено повідомлення про відсутність файлу.");
    }

    @Test
    void testMainWithEmptyFlowerFile() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
        outputStream.reset();
        List<Flower> emptyList = ReadFromFile.flowersFromFile("src/EmptyFlower.txt");
        assertTrue(emptyList.isEmpty(), "Список квітів має бути порожнім.");
    }

    @Test
    void testMainWithNonEmptyFile() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        outputStream.reset();
        Main.main(new String[]{});
        String output = outputStream.toString();
        assertTrue(output.contains("Оберіть пункт меню:"), "Програма повинна переходити до меню.");
    }
}
