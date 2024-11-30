package commands;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class DeleteFlowerCommandTest {
    private List<Flower> flowerList;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        flowerList = new ArrayList<>();
        flowerList.add(new Lily("червоний", 10, 5, 50, true));
        flowerList.add(new Rose("жовтий", 7, 2,30, false));
        flowerList.add(new Chamomile("білий", 40, 1, 24, 23));
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testDeleteValidFlower() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("2\n".getBytes()));
        DeleteFlowerCommand deleteFlowerCommand = new DeleteFlowerCommand(flowerList, scanner);
        deleteFlowerCommand.execute();
        assertEquals(2, flowerList.size());
        String output = outputStream.toString();
        assertTrue(output.contains("Квітка видалена."));
    }

    @Test
    void testDeleteFlowerEmptyList() {
        flowerList.clear();
        Scanner scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        DeleteFlowerCommand deleteFlowerCommand = new DeleteFlowerCommand(flowerList, scanner);
        deleteFlowerCommand.execute();
        String output = outputStream.toString();
        assertTrue(output.contains("Список квіток порожній. Немає що видаляти."));
    }

    @Test
    void testDeleteFlowerInvalidIndex() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("5\n2\n".getBytes()));
        DeleteFlowerCommand deleteFlowerCommand = new DeleteFlowerCommand(flowerList, scanner);
        deleteFlowerCommand.execute();
        assertEquals(2, flowerList.size());
        String output = outputStream.toString();
        assertTrue(output.contains("Некоректний номер квітки"));
        assertTrue(output.contains("Квітка видалена."));
    }

    @Test
    void testDeleteFlowerNonIntegerInput() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("abc\n1\n".getBytes()));
        DeleteFlowerCommand deleteFlowerCommand = new DeleteFlowerCommand(flowerList, scanner);
        deleteFlowerCommand.execute();
        assertEquals(2, flowerList.size());
        String output = outputStream.toString();
        assertTrue(output.contains("Будь ласка, введіть ціле число."));
        assertTrue(output.contains("Квітка видалена."));
    }
}
