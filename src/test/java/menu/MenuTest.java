package menu;
import accessory.Accessory;
import bouquet.Bouquet;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuTest {
    private List<Flower> flowerList;
    private List<Accessory> accessoryList;
    private Bouquet bouquet;
    private Scanner scanner;
    private Menu menu;

    @BeforeEach
    void setUp() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        flowerList = new ArrayList<>();
        flowerList.add(new Rose("червоний", 50, 5, 12, true));
        flowerList.add(new Lily("жовтий", 30, 1, 10, false));
        accessoryList = new ArrayList<>();
        accessoryList.add(new Accessory(20));
        accessoryList.add(new Accessory(32));
        bouquet = new Bouquet();
        scanner = new Scanner(System.in);
        menu = new Menu(flowerList, accessoryList, bouquet, scanner);
    }

    @Test
    void testDisplayMenu() {
        menu.displayMenu();
        assertDoesNotThrow(() -> menu.displayMenu(), "Меню виводиться");
    }

    @Test
    void testSelectDeleteFlowerCommand() {
        flowerList.add(new Rose("білий", 5, 5, 10, false));
        String option = "3";
        int initialSize = flowerList.size();
        menu.selectOption(option);
        assertEquals(initialSize - 1, flowerList.size(), "Кількість квіток зменшується");
    }

    @Test
    void testSelectInvalidChoice() {
        String invalidOption = "11";
        menu.selectOption(invalidOption);
        assertDoesNotThrow(() -> menu.selectOption(invalidOption), "Некоректний вибір");
    }

    @Test
    void testChooseFlowerForBouquet() {
        flowerList.add(new Rose("білий", 5, 5, 10, false));
        String option = "4";
        menu.selectOption(option);
        assertTrue(bouquet.getFlowers().size() > 0, "Букет містить квітку після додавання");
    }

    @Test
    void testExitOption() {
        String option = "0";
        menu.selectOption(option);
        assertDoesNotThrow(() -> menu.selectOption(option), "Вихід не повинен викликати помилок");
    }

    @Test
    void testSelectFlower_ValidInput() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Flower selectedFlower = menu.selectFlower();
        assertNotNull(selectedFlower, "Квітка обрана");
        assertEquals("червоний", selectedFlower.getColor(), "Перевіряємо колір квітки");
    }
}
