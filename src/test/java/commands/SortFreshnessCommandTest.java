package commands;
import bouquet.Bouquet;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SortFreshnessCommandTest {
    private Bouquet bouquet;
    private SortFreshnessCommand sortFreshnessCommand;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        sortFreshnessCommand = new SortFreshnessCommand(bouquet);
    }

    @Test
    void executeEmptyBouquet() {
        sortFreshnessCommand.execute();
    }

    @Test
    void executeSingleFlower() {
        Flower flower = new Rose("червоний", 10, 5, 37, true);
        bouquet.addFlower(flower);
        sortFreshnessCommand.execute();
        List<Flower> flowers = bouquet.getFlowers();
        assertEquals(1, flowers.size());
        assertEquals(flower, flowers.get(0));
    }

    @Test
    void executeSameFreshness() {
        Flower flower1 = new Rose("Червоний", 10.0, 5, 30, true);
        Flower flower2 = new Lily("Білий", 12.0, 5, 40, true);
        Flower flower3 = new Rose("Жовтий", 8.0, 5, 25, true);
        bouquet.addFlower(flower1);
        bouquet.addFlower(flower2);
        bouquet.addFlower(flower3);
        sortFreshnessCommand.execute();
        List<Flower> flowers = bouquet.getFlowers();
        assertEquals(flower1, flowers.get(0));
        assertEquals(flower2, flowers.get(1));
        assertEquals(flower3, flowers.get(2));
    }
}
