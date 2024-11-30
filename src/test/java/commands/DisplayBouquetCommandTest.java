package commands;
import bouquet.Bouquet;
import accessory.*;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DisplayBouquetCommandTest {
    private Bouquet bouquet;
    private DisplayBouquetCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        command = new DisplayBouquetCommand(bouquet);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testDisplayFlowersAndAccessories() {
        bouquet.addFlower(new Rose("червоний", 120, 3, 15, true));
        bouquet.addFlower(new Chamomile("жовтий", 80, 1, 20, 13));
        bouquet.addAccessory(new Bow(50, 20));
        bouquet.addAccessory(new GiftWrap(70, "червоний"));
        command.execute();
        String expectedOutput = "Ваш букет містить такі квіти та аксесуари:\n" +
                "Квіти:\n" +
                "1. Троянда, колір: червоний, ціна: 120.0, свіжість: 3 днів, довжина стебла: 15 см, має шипи: так\n" +
                "2. Ромашка, колір: жовтий, ціна: 80.0, свіжість: 1 днів, довжина стебла: 20 см, кількість пелюсток: 13\n" +
                "Аксесуари:\n" +
                "1. Бант, розмір: 20 см, ціна: 50.0 грн\n" +
                "2. Подарункова обгортка, колір: червоний, ціна: 70.0 грн";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testDisplayBouquetWithNoFlowers() {
        bouquet.addAccessory(new Bow(50, 10));
        command.execute();
        String expectedOutput = "Ваш букет містить такі квіти та аксесуари:\n" +
                "Букет не містить квітів.\n" +
                "Аксесуари:\n" +
                "1. Бант, розмір: 10 см, ціна: 50.0 грн\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void testDisplayBouquetWithNoFlowersAndNoAccessories() {
        command.execute();
        String expectedOutput = "Ваш букет містить такі квіти та аксесуари:\n" +
                "Букет не містить квітів.\n" +
                "Букет не містить аксесуарів.\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
