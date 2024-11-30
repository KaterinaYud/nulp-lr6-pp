package commands;
import accessory.*;
import bouquet.Bouquet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.InputUtils;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ChooseAccessoryCommandTest {
    private List<Accessory> accessoryList;
    private Bouquet bouquet;
    private ChooseAccessoryCommand command;

    @BeforeEach
    public void setUp() {
        accessoryList = new ArrayList<>();
        bouquet = new Bouquet();
        command = new ChooseAccessoryCommand(accessoryList, bouquet);
    }

    @Test
    public void testAddBowAccessory() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(1, 10);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(50.0);
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                Bow bow = (Bow) accessory;
                assertEquals(50.0, bow.getPrice());
                assertEquals(10, bow.getSize());
            } catch (ClassCastException e) {
                fail("Аксесуар не Bow");
            }
        }
    }

    @Test
    public void testInvalidAccessoryChoice() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(5, 2);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(30.0);
            mockedInput.when(() -> InputUtils.getStringInput(anyString())).thenReturn("червоний");
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                GiftWrap wrap = (GiftWrap) accessory;
                assertEquals("червоний", wrap.getColor());
            } catch (ClassCastException e) {
                fail("Аксесуар не GiftWrap");
            }
        }
    }

    @Test
    public void testNegativePrice() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(1, 20);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(-50.0, 50.0);
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                Bow bow = (Bow) accessory;
                assertEquals(50.0, bow.getPrice());
            } catch (ClassCastException e) {
                fail("Аксесуар не Bow");
            }
        }
    }

    @Test
    public void testInvalidBowSize() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(1, 25, 10);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(40.0);
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                Bow bow = (Bow) accessory;
                assertEquals(10, bow.getSize());
            } catch (ClassCastException e) {
                fail("аксесуар не Bow");
            }
        }
    }

    @Test
    public void testInvalidGiftWrapColor() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(2);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(30.0);
            mockedInput.when(() -> InputUtils.getStringInput(anyString())).thenReturn("некоректний", "зелений");
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                GiftWrap wrap = (GiftWrap) accessory;
                assertEquals("зелений", wrap.getColor());
            } catch (ClassCastException e) {
                fail("Аксесуар не GiftWrap");
            }
        }
    }

    @Test
    public void testInvalidRibbonLength() {
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            mockedInput.when(() -> InputUtils.getValidInt(anyString())).thenReturn(3, -10, 100);
            mockedInput.when(() -> InputUtils.getValidDouble(anyString())).thenReturn(20.0);
            command.execute();
            assertEquals(1, bouquet.getAccessories().size());
            Accessory accessory = bouquet.getAccessories().get(0);
            try {
                Ribbon ribbon = (Ribbon) accessory;
                assertEquals(100, ribbon.getLength());
            } catch (ClassCastException e) {
                fail("Аксесуар не Ribbon");
            }
        }
    }

    @Test
    public void testMaxAccessoriesLimit() {
        bouquet.addAccessory(new Bow(10.0, 10));
        bouquet.addAccessory(new GiftWrap(20.0, "синій"));
        bouquet.addAccessory(new Ribbon(15.0, 50));
        try (MockedStatic<InputUtils> mockedInput = mockStatic(InputUtils.class)) {
            command.execute();
            assertEquals(3, bouquet.getAccessories().size());
        }
    }
}
