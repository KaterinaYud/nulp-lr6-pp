package bouquet;
import flower.*;
import accessory.Accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BouquetTest {
    private Bouquet bouquet;
    private Flower rose;
    private Flower lily;
    private Accessory accessory1;
    private Accessory accessory2;
    private Accessory accessory3;
    private Accessory accessory4;

    @BeforeEach
    public void setUp() {
        bouquet = new Bouquet();
        rose = new Rose("червоний", 12, 1, 10, true);
        lily = new Lily("жовтий", 5.0, 2, 12, false);
        accessory1 = new Accessory(20);
        accessory2 = new Accessory( 15);
        accessory3 = new Accessory(23);
        accessory4 = new Accessory(17);
    }

    @Test
    public void testAddFlower() {
        bouquet.addFlower(rose);
        bouquet.addFlower(lily);
        List<Flower> flowers = bouquet.getFlowers();
        assertEquals(2, flowers.size());
        assertTrue(flowers.contains(rose));
        assertTrue(flowers.contains(lily));
    }

    @Test
    public void testRemoveFlower() {
        bouquet.addFlower(rose);
        bouquet.addFlower(lily);
        bouquet.removeFlower(rose);
        List<Flower> flowers = bouquet.getFlowers();
        assertEquals(1, flowers.size());
        assertFalse(flowers.contains(rose));
        assertTrue(flowers.contains(lily));
        bouquet.removeFlower(rose);
        assertEquals(1, flowers.size());
    }

    @Test
    public void testAddAccessory() {
        bouquet.addAccessory(accessory1);
        bouquet.addAccessory(accessory2);
        bouquet.addAccessory(accessory3);
        List<Accessory> accessories = bouquet.getAccessories();
        assertEquals(3, accessories.size());
        bouquet.addAccessory(accessory4);
        assertEquals(3, accessories.size());
    }

    @Test
    public void testGetFlowers() {
        bouquet.addFlower(rose);
        bouquet.addFlower(lily);
        List<Flower> flowers = bouquet.getFlowers();
        assertNotNull(flowers);
        assertEquals(2, flowers.size());
    }

    @Test
    public void testGetAccessories() {
        bouquet.addAccessory(accessory1);
        bouquet.addAccessory(accessory2);
        List<Accessory> accessories = bouquet.getAccessories();
        assertNotNull(accessories);
        assertEquals(2, accessories.size());
        assertTrue(accessories.contains(accessory1));
        assertTrue(accessories.contains(accessory2));
    }
}
