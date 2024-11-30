package commands;
import bouquet.Bouquet;
import flower.Rose;
import flower.Lily;
import flower.Flower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AddToBouquetCommandTest {
    List<Flower> flowerList = new ArrayList<>();
    Bouquet bouquet = new Bouquet();

    @Test
    void testExecuteAddFlowerToBouquet() {
        flowerList.add(new Rose("червоний", 10, 5, 30, true));
        flowerList.add(new Lily("білий", 12, 7, 40, true));
        Scanner scanner = new Scanner("1");
        AddToBouquetCommand command = new AddToBouquetCommand(bouquet, flowerList, scanner);
        command.execute();
        assertEquals(1, bouquet.getFlowers().size());
        Flower flower = bouquet.getFlowers().get(0);
        assertEquals("червоний", flower.getColor());
        assertEquals(10, flower.getPrice());
        assertEquals(5, flower.getFreshness());
        assertEquals(30, flower.getStemLength());
        Rose roseFlower = (Rose) flower;
        assertTrue(roseFlower.hasSpikes());
    }

    @Test
    void testExecuteInvalidFlowerSelect() {
        flowerList.add(new Rose("червоний", 10, 5, 30, true));
        flowerList.add(new Lily("білий", 12, 7, 40, true));
        String input = "3\n3\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        AddToBouquetCommand command = new AddToBouquetCommand(bouquet, flowerList, scanner);
        command.execute();
        assertEquals(1, bouquet.getFlowers().size());
        assertEquals(flowerList.get(1), bouquet.getFlowers().get(0));
        System.setIn(System.in);
    }
}
