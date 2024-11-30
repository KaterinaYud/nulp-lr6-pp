package commands;
import bouquet.Bouquet;
import flower.Rose;
import flower.Lily;
import flower.Chamomile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class SearchStemCommandTest {
    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        bouquet.addFlower(new Rose("червоний", 25, 5, 30, true));
        bouquet.addFlower(new Lily("білий", 20, 3, 15, false));
        bouquet.addFlower(new Chamomile("жовтий", 18, 4, 22, 50));
    }

    @Test
    void testSearchWithRange() {
        Scanner scanner = new Scanner("10\n30\n");
        SearchStemCommand command = new SearchStemCommand(bouquet, scanner);
        assertDoesNotThrow(command::execute, "Команда виконується");
    }

    @Test
    void testNoFlowersRange() {
        Scanner scanner = new Scanner("40\n50\n");
        SearchStemCommand command = new SearchStemCommand(bouquet, scanner);
        assertDoesNotThrow(() -> {
            command.execute();
        }, "Команда виконується");
    }

    @Test
    void testEmptyBouquet() {
        Bouquet emptyBouquet = new Bouquet();
        Scanner scanner = new Scanner("5\n10\n");
        SearchStemCommand command = new SearchStemCommand(emptyBouquet, scanner);
        assertDoesNotThrow(command::execute, "Команда виконується для порожнього букета.");
    }

    @Test
    void testInvalidRange() {
        Scanner scanner = new Scanner("30\n20\n40\n50\n");
        SearchStemCommand command = new SearchStemCommand(bouquet, scanner);
        assertDoesNotThrow(() -> {
            command.execute();
        }, "Команда виконується");
    }
}
