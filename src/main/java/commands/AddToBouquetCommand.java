package commands;
import bouquet.Bouquet;
import flower.Flower;
import java.util.List;
import java.util.Scanner;

public class AddToBouquetCommand implements Command {
    private Bouquet bouquet;
    private List<Flower> flowerList;
    private Scanner scanner;

    public AddToBouquetCommand(Bouquet bouquet, List<Flower> flowerList, Scanner scanner) {
        this.bouquet = bouquet;
        this.flowerList = flowerList;
        this.scanner = scanner;
    }

    public void execute() {
        int index;
        System.out.println("Оберіть квітку для додавання до букета:");
        for (int i = 0; i < flowerList.size(); i++) {
            System.out.println((i + 1) + ". " + flowerList.get(i));
        }
        while (true) {
            System.out.print("Введіть номер квітки для додавання до букета (1-" + flowerList.size() + "): ");
            index = scanner.nextInt() - 1;
            if (index >= 0 && index < flowerList.size()) {
                bouquet.addFlower(flowerList.get(index));
                System.out.println("Квітка додана до букета: " + flowerList.get(index));
                break;
            } else {
                System.out.println("Некоректний номер квітки. Спробуйте ще раз.");
            }
        }
    }
}

