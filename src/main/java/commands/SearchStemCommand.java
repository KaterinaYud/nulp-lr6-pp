package commands;
import bouquet.Bouquet;
import flower.Flower;
import java.util.Scanner;

public class SearchStemCommand implements Command {
    private Bouquet bouquet;
    private Scanner scanner;

    public SearchStemCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    public void execute() {
        int minLength = -1, maxLength = -1;
        while (minLength < 0) {
            System.out.print("Введіть мінімальну довжину з діапазону: ");
            minLength = scanner.nextInt();
        }
        while (maxLength <= minLength) {
            System.out.print("Введіть максимальну довжину з діапазону: ");
            maxLength = scanner.nextInt();
            if (maxLength <= minLength) {
                System.out.println("Максимальна довжина повинна бути більшою за мінімальну. Спробуйте ще раз.");
            }
        }
        System.out.println("Квіти з довжиною стебла від " + minLength + " до " + maxLength + ":");
        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                System.out.println(flower);
            }
        }
    }
}

