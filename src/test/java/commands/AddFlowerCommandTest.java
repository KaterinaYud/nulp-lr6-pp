package commands;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import utils.InputUtils;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AddFlowerCommandTest {
    private List<Flower> flowerList;
    private AddFlowerCommand addFlowerCommand;

    @BeforeEach
    void setUp() {
        flowerList = new ArrayList<>();
        addFlowerCommand = new AddFlowerCommand(flowerList);
    }

    @Test
    void testAddRose() {
        try (MockedStatic<InputUtils> mockedInput = Mockito.mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt("Ваш вибір: ")).thenReturn(1);
            mockedInput.when(() -> InputUtils.getStringInput("Введіть колір квітки: ")).thenReturn("червоний");
            mockedInput.when(() -> InputUtils.getValidDouble("Введіть ціну квітки: ")).thenReturn(50.0);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): ")).thenReturn(7);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): ")).thenReturn(100);
            mockedInput.when(() -> InputUtils.getValidBoolean("Чи має квітка шипи? (true/false): ")).thenReturn(true);
            addFlowerCommand.execute();
            assertEquals(1, flowerList.size());
            Flower flower = flowerList.get(0);
            assertTrue(flower instanceof Rose, "Очікувана квітка - це троянда.");
            Rose rose = (Rose) flower;
            assertTrue(rose.hasSpikes(), "Троянда має шипи.");
        }
    }

    @Test
    void testInvalidPrice() {
        try (MockedStatic<InputUtils> mockedInput = Mockito.mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidDouble("Введіть ціну квітки: "))
                    .thenReturn(-1.0)
                    .thenReturn(0.0)
                    .thenReturn(20.0);
            mockedInput.when(() -> InputUtils.getValidInt("Ваш вибір: ")).thenReturn(1);
            mockedInput.when(() -> InputUtils.getStringInput("Введіть колір квітки: ")).thenReturn("червоний");
            mockedInput.when(() -> InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): ")).thenReturn(7);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): ")).thenReturn(50);
            mockedInput.when(() -> InputUtils.getValidBoolean("Чи має квітка шипи? (true/false): ")).thenReturn(true);
            addFlowerCommand.execute();
            assertEquals(1, flowerList.size());
            assertEquals(20.0, flowerList.get(0).getPrice());
        }
    }

    @Test
    void testInvalidFreshness() {
        try (MockedStatic<InputUtils> mockedInput = Mockito.mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): "))
                    .thenReturn(-5)
                    .thenReturn(15)
                    .thenReturn(5);
            mockedInput.when(() -> InputUtils.getValidDouble("Введіть ціну квітки: ")).thenReturn(20.0);
            mockedInput.when(() -> InputUtils.getStringInput("Введіть колір квітки: ")).thenReturn("синій");
            mockedInput.when(() -> InputUtils.getValidInt("Ваш вибір: ")).thenReturn(2);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): ")).thenReturn(80);
            mockedInput.when(() -> InputUtils.getValidBoolean("Чи має квітка аромат? (true/false): ")).thenReturn(true);
            addFlowerCommand.execute();
            assertEquals(1, flowerList.size());
            assertEquals(5, flowerList.get(0).getFreshness());
        }
    }

    @Test
    void testInvalidStemLength() {
        try (MockedStatic<InputUtils> mockedInput = Mockito.mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): "))
                    .thenReturn(-10)
                    .thenReturn(300)
                    .thenReturn(150);
            mockedInput.when(() -> InputUtils.getValidDouble("Введіть ціну квітки: ")).thenReturn(25.0);
            mockedInput.when(() -> InputUtils.getStringInput("Введіть колір квітки: ")).thenReturn("білий");
            mockedInput.when(() -> InputUtils.getValidInt("Ваш вибір: ")).thenReturn(3);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): ")).thenReturn(6);
            mockedInput.when(() -> InputUtils.getValidInt("Введіть кількість пелюсток: ")).thenReturn(15);
            addFlowerCommand.execute();
            assertEquals(1, flowerList.size());
            assertEquals(150, flowerList.get(0).getStemLength());
        }
    }
}
