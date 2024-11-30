package utils;
import flower.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {
    private static final String VALID_FILE = "valid_flowers.txt";
    private static final String EMPTY_FILE = "empty.txt";
    private static final String UNKNOWN_TYPE_FILE = "unknown.txt";

    @Test
    void flowersFromFileEmptyList() {
        List<Flower> flowers = ReadFromFile.flowersFromFile("non_existent_file.txt");
        assertTrue(flowers.isEmpty());
    }

    @Test
    void flowersFromValidFileCorrect() {
        List<Flower> flowers = ReadFromFile.flowersFromFile(VALID_FILE);
        assertEquals(3, flowers.size());
        Flower firstFlower = flowers.get(0);
        assertEquals("Red", firstFlower.getColor());
        assertEquals(10.5, firstFlower.getPrice());
        assertEquals(7, firstFlower.getFreshness());
        assertEquals(40, firstFlower.getStemLength());
        Flower secondFlower = flowers.get(1);
        assertEquals("White", secondFlower.getColor());
        assertEquals(15.0, secondFlower.getPrice());
        assertEquals(5, secondFlower.getFreshness());
        assertEquals(50, secondFlower.getStemLength());
        Flower thirdFlower = flowers.get(2);
        assertEquals("Yellow", thirdFlower.getColor());
        assertEquals(7.5, thirdFlower.getPrice());
        assertEquals(10, thirdFlower.getFreshness());
        assertEquals(30, thirdFlower.getStemLength());
    }

    @Test
    void flowersFromEmptyFile() {
        List<Flower> flowers = ReadFromFile.flowersFromFile(EMPTY_FILE);
        assertTrue(flowers.isEmpty());
    }

    @Test
    void flowersFromUnknownTypeFile() {
        List<Flower> flowers = ReadFromFile.flowersFromFile(UNKNOWN_TYPE_FILE);
        assertTrue(flowers.isEmpty());
    }
}
