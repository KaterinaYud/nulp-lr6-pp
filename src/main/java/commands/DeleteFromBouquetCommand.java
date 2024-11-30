package commands;
import bouquet.Bouquet;
import flower.Flower;
import java.util.Scanner;

public class DeleteFromBouquetCommand implements Command {
    private Bouquet bouquet;
    private Scanner scanner;

    public DeleteFromBouquetCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    public void execute() {
        if (bouquet.getFlowers().isEmpty()) {
            System.out.println("Букет порожній, немає квіток для видалення.");
            return;
        }
        System.out.println("Квіти у букеті:");
        for (int i = 0; i < bouquet.getFlowers().size(); i++) {
            System.out.println((i + 1) + ". " + bouquet.getFlowers().get(i));
        }
        int index = -1;
        while (true) {
            System.out.print("Введіть номер квітки для видалення (1-" + bouquet.getFlowers().size() + "): ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt() - 1;
                if (index >= 0 && index < bouquet.getFlowers().size()) {
                    Flower removedFlower = bouquet.getFlowers().get(index);
                    bouquet.removeFlower(removedFlower);
                    System.out.println("Квітка видалена з букета.");
                    break;
                } else {
                    System.out.println("Некоректний номер. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Будь ласка, введіть числове значення.");
                scanner.next();
            }
        }
    }
}



