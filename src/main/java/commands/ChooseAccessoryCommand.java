package commands;
import accessory.*;
import bouquet.Bouquet;
import color.Color;
import utils.InputUtils;
import java.util.List;

public class ChooseAccessoryCommand implements Command {
    private List<Accessory> accessoryList;
    private Bouquet bouquet;

    public ChooseAccessoryCommand(List<Accessory> accessoryList, Bouquet bouquet) {
        this.accessoryList = accessoryList;
        this.bouquet = bouquet;
    }

    public void execute() {
        if (bouquet.getAccessories().size() >= 3) {
            System.out.println("Максимальна кількість аксесуарів до букета — 3. Будь ласка, оберіть іншу опцію.");
            return;
        }

        int choice = 0;
        while (true) {
            System.out.println("Введіть номер аксесуара: ");
            System.out.println("1. Бантик");
            System.out.println("2. Подарункова обгортка");
            System.out.println("3. Стрічка");
            choice = InputUtils.getValidInt("Ваш вибір: ");
            if (choice >= 1 && choice <= 3) {
                break;
            } else {
                System.out.println("Неправильний вибір аксесуара. Спробуйте ще раз.");
            }
        }

        double price = InputUtils.getValidDouble("Введіть ціну аксесуара: ");
        while (price < 0) {
            System.out.println("Ціна не може бути від'ємною. Введіть коректну ціну.");
            price = InputUtils.getValidDouble("Введіть ціну аксесуара: ");
        }

        Accessory accessory = null;
        switch (choice) {
            case 1:
                int size = InputUtils.getValidInt("Введіть розмір бантика (10, 20 або 30): ");
                while (size != 10 && size != 20 && size != 30) {
                    System.out.println("Розмір бантика повинен бути 10, 20 або 30. Спробуйте ще раз.");
                    size = InputUtils.getValidInt("Введіть розмір бантика (10, 20 або 30): ");
                }
                accessory = new Bow(price, size);
                break;
            case 2:
                String color = InputUtils.getStringInput("Введіть колір обгортки: ");
                while (!Color.isValidColor(color)) {
                    System.out.println("Такого кольору, на жаль, немає. Оберіть інший колір.");
                    color = InputUtils.getStringInput("Введіть колір обгортки: ");
                }
                accessory = new GiftWrap(price, color);
                break;
            case 3:
                int length = InputUtils.getValidInt("Введіть довжину стрічки (см): ");
                while (length < 0) {
                    System.out.println("Довжина не може бути від'ємною. Введіть коректну довжину.");
                    length = InputUtils.getValidInt("Введіть довжину стрічки (см): ");
                }
                accessory = new Ribbon(price, length);
                break;
        }
        bouquet.addAccessory(accessory);
        System.out.println("Аксесуар додано: " + accessory.getPrice() + " грн");
    }
}

