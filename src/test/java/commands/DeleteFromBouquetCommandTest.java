package commands;
import bouquet.Bouquet;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class DeleteFromBouquetCommandTest {
    private Bouquet bouquet;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        bouquet.addFlower(new Lily("червоний", 10, 5, 50, true));
        bouquet.addFlower(new Rose("жовтий", 7, 2, 30, false));
        bouquet.addFlower(new Chamomile("білий", 40, 1, 24, 23));
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
        DeleteFromBouquetCommand deleteCommand = new DeleteFromBouquetCommand(bouquet, scanner);
        deleteCommand.execute();
        assertEquals(2, bouquet.getFlowers().size());
        String output = outputStream.toString();
        assertTrue(output.contains("Квітка видалена з букета."));
    }

    @Test
    void testDeleteFromEmptyBouquet() {
        bouquet.getFlowers().clear();
        Scanner scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        DeleteFromBouquetCommand deleteCommand = new DeleteFromBouquetCommand(bouquet, scanner);
        deleteCommand.execute();
        String output = outputStream.toString();
        assertTrue(output.contains("Букет порожній, немає квіток для видалення."));
    }

    @Test
    void testDeleteFlowerInvalidIndex() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("5\n1\n".getBytes()));
        DeleteFromBouquetCommand deleteCommand = new DeleteFromBouquetCommand(bouquet, scanner);
        deleteCommand.execute();
        assertEquals(2, bouquet.getFlowers().size());
        String output = outputStream.toString();
        assertTrue(output.contains("Некоректний номер"));
        assertTrue(output.contains("Квітка видалена з букета."));
    }

    @Test
    void testDeleteFlowerNonIntegerInput() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("abc\n1\n".getBytes()));
        DeleteFromBouquetCommand deleteCommand = new DeleteFromBouquetCommand(bouquet, scanner);
        deleteCommand.execute();
        assertEquals(2, bouquet.getFlowers().size());
        String output = outputStream.toString();
        assertTrue(output.contains("Будь ласка, введіть числове значення."));
        assertTrue(output.contains("Квітка видалена з букета."));
    }
}
