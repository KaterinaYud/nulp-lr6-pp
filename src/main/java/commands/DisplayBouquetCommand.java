package commands;
import bouquet.Bouquet;
import accessory.*;
import flower.Flower;

public class DisplayBouquetCommand implements Command {
    private Bouquet bouquet;

    public DisplayBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    public void execute() {
        System.out.println("Ваш букет містить такі квіти та аксесуари:");
        if (!bouquet.getFlowers().isEmpty()) {
            System.out.println("Квіти:");
            for (int i = 0; i < bouquet.getFlowers().size(); i++) {
                Flower flower = bouquet.getFlowers().get(i);
                System.out.println((i + 1) + ". " + flower);
            }
        } else {
            System.out.println("Букет не містить квітів.");
        }

        if (!bouquet.getAccessories().isEmpty()) {
            System.out.println("Аксесуари:");
            for (int i = 0; i < bouquet.getAccessories().size(); i++) {
                Accessory accessory = bouquet.getAccessories().get(i);
                System.out.println((i + 1) + ". " + accessory.toString());
            }
        } else {
            System.out.println("Букет не містить аксесуарів.");
        }
    }
}
