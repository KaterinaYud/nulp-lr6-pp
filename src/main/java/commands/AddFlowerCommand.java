package commands;

import color.Color;
import flower.*;
import utils.InputUtils;
import java.util.List;

public class AddFlowerCommand implements Command {
    private List<Flower> flowerList;

    public AddFlowerCommand(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public void execute() {
        int choice = 0;
        while (true) {
            System.out.println("Оберіть тип квітки: ");
            System.out.println("1. Троянда");
            System.out.println("2. Лілія");
            System.out.println("3. Ромашка");
            choice = InputUtils.getValidInt("Ваш вибір: ");
            if (choice >= 1 && choice <= 3) {
                break;
            } else {
                System.out.println("Неправильний вибір квітки. Спробуйте ще раз.");
            }
        }

        String color = InputUtils.getStringInput("Введіть колір квітки: ");
        while (!Color.isValidColor(color)) {
            System.out.println("Такого кольору, на жаль, немає. Оберіть інший колір.");
            color = InputUtils.getStringInput("Введіть колір квітки: ");
        }

        double price = InputUtils.getValidDouble("Введіть ціну квітки: ");
        while (price <= 0) {
            System.out.println("Ціна має бути додатньою. Спробуйте ще раз.");
            price = InputUtils.getValidDouble("Введіть ціну квітки: ");
        }

        int freshnessday = InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): ");
        while (freshnessday < 0 || freshnessday > 10) {
            System.out.println("Свіжість квітки має бути від 0 до 10 днів. Спробуйте ще раз.");
            freshnessday = InputUtils.getValidInt("Введіть свіжість квітки у днях (від 0 до 10): ");
        }

        int stemlength = InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): ");
        while (stemlength < 1 || stemlength > 200) {
            System.out.println("Довжина стебла повинна бути від 1 до 200 см. Спробуйте ще раз.");
            stemlength = InputUtils.getValidInt("Введіть довжину стебла квітки у см (до 200): ");
        }
        Flower flower = null;

        switch (choice) {
            case 1:
                boolean hasSpikes = InputUtils.getValidBoolean("Чи має квітка шипи? (true/false): ");
                flower = new Rose(color, price, freshnessday, stemlength, hasSpikes);
                break;
            case 2:
                boolean hasAroma = InputUtils.getValidBoolean("Чи має квітка аромат? (true/false): ");
                flower = new Lily(color, price, freshnessday, stemlength, hasAroma);
                break;
            case 3:
                int petals = InputUtils.getValidInt("Введіть кількість пелюсток: ");
                flower = new Chamomile(color, price, freshnessday, stemlength, petals);
                break;
        }
        flowerList.add(flower);
        System.out.println("Квітку додано: " + flower);
    }
}
