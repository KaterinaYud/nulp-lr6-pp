package commands;
import flower.Flower;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DeleteFlowerCommand implements Command {
    private List<Flower> flowerList;
    private Scanner scanner;

    public DeleteFlowerCommand(List<Flower> flowerList, Scanner scanner) {
        this.flowerList = flowerList;
        this.scanner = scanner;
    }

    public void execute() {
        if (flowerList.isEmpty()) {
            System.out.println("Список квіток порожній. Немає що видаляти.");
            return;
        }
        System.out.println("Наявні квітки:");
        for (int i = 0; i < flowerList.size(); i++) {
            System.out.println((i + 1) + ". " + flowerList.get(i));
        }

        int index = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Введіть номер квітки для видалення (1-" + flowerList.size() + "): ");
            try {
                index = scanner.nextInt();
                if (index >= 1 && index <= flowerList.size()) {
                    flowerList.remove(index - 1);
                    System.out.println("Квітка видалена.");
                    validInput = true;
                } else {
                    System.out.println("Некоректний номер квітки. Спробуйте ще раз.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, введіть ціле число.");
                scanner.next();
            }
        }
    }
}


