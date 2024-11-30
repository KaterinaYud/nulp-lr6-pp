package menu;
import commands.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void testGetDescription() {
        String expectedDescription = "Додати квітку";
        Command dummyCommand = new Command() {
            public void execute() {
            }
        };
        MenuItem menuItem = new MenuItem(expectedDescription, dummyCommand);
        assertEquals(expectedDescription, menuItem.getDescription(), "Опис меню");
    }

    @Test
    void testExecute() {
        final boolean[] executed = {false};
        Command dummyCommand = new Command() {
            public void execute() {
                executed[0] = true;
            }
        };
        MenuItem menuItem = new MenuItem("Додати квітку", dummyCommand);
        menuItem.execute();
        assertTrue(executed[0], "Команда виконана");
    }
}