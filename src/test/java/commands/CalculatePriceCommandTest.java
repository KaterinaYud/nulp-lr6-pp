package commands;
import bouquet.Bouquet;
import flower.Flower;
import flower.Rose;
import flower.Lily;
import accessory.Accessory;
import accessory.Ribbon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CalculatePriceCommandTest {
    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
    }

    @Test
    void testCalculatePriceFlowers() {
        Flower rose = new Rose("синій", 15, 5, 30, true);
        Flower lily = new Lily("білий", 35, 7, 40, true);
        bouquet.addFlower(rose);
        bouquet.addFlower(lily);
        CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand(bouquet);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        calculatePriceCommand.execute();
        String expectedOutput = "Загальна вартість букета: 50.0 грн";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    void testCalculatePriceAccessories() {
        Accessory ribbon = new Ribbon(20, 12);
        bouquet.addAccessory(ribbon);
        CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand(bouquet);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        calculatePriceCommand.execute();
        String expectedOutput = "Загальна вартість букета: 20.0 грн\n";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    void testPriceFlowersAndAccessories() {
        Flower rose = new Rose("жовтий", 15, 5, 30, true);
        Flower lily = new Lily("оранжевий", 35, 7, 40, true);
        bouquet.addFlower(rose);
        bouquet.addFlower(lily);
        Accessory ribbon = new Ribbon(20, 13);
        bouquet.addAccessory(ribbon);
        CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand(bouquet);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        calculatePriceCommand.execute();
        String expectedOutput = "Загальна вартість букета: 70.0 грн\n";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    void testCalculateEmptyBouquet() {
        CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand(bouquet);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        calculatePriceCommand.execute();
        String expectedOutput = "Загальна вартість букета: 0.0 грн\n";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }
}
