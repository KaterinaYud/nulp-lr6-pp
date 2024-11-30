package commands;
import color.Color;
import flower.Flower;
import utils.InputUtils;
import java.util.Scanner;

public class EditFlowerCommand implements Command {
    private Flower flower;
    private Scanner scanner;

    public EditFlowerCommand(Flower flower, Scanner scanner) {
        this.flower = flower;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("Початкова квітка: " + flower);
        String color = InputUtils.getStringInput("Введіть колір квітки: ");
        while (!Color.isValidColor(color)) {
            System.out.println("Такого кольору, на жаль, немає. Оберіть інший колір.");
            color = InputUtils.getStringInput("Введіть колір квітки: ");
        }
        flower.setColor(color);

        double price;
        while (true) {
            System.out.print("Оновлена ціна квітки: ");
            price = scanner.nextDouble();
            if (price > 0) {
                flower.setPrice(price);
                break;
            } else {
                System.out.println("Ціна повинна бути додатньою. Спробуйте знову.");
            }
        }

        int freshness;
        while (true) {
            System.out.print("Оновлена свіжість квітки (в днях): ");
            freshness = scanner.nextInt();
            if (freshness > 0) {
                flower.setFreshness(freshness);
                break;
            } else {
                System.out.println("Свіжість квітки має бути додатньою. Спробуйте ще раз.");
            }
        }

        int stemLength;
        while (true) {
            System.out.print("Оновлена довжина стебла квітки (в см): ");
            stemLength = scanner.nextInt();
            if (stemLength > 0) {
                flower.setStemLength(stemLength);
                break;
            } else {
                System.out.println("Довжина стебла має бути додатньою. Спробуйте знову.");
            }
        }
        System.out.println("Оновлений стан квітки: " + flower);
        System.out.println("Квітку оновлено.");
    }
}