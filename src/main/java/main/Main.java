package main;
import flower.*;
import menu.Menu;
import bouquet.Bouquet;
import accessory.Accessory;
import utils.ReadFromFile;
import java.util.*;
import java.util.Scanner;

public class Main {
    private static List<Accessory> accessoryList = new ArrayList<>();
    private static Bouquet bouquet = new Bouquet();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        List<Flower> flowerList = ReadFromFile.flowersFromFile("src/Flower.txt");
        if (flowerList.isEmpty()) {
            System.out.println("Не вдалося завантажити квіти з файлу або файл порожній.");
            return;
        }
        startMenu(flowerList);
    }

    public static void startMenu(List<Flower> flowerList) {
        Menu menu = new Menu(flowerList, accessoryList, bouquet, scan);
        String option;
        do {
            menu.displayMenu();
            System.out.print("Оберіть пункт меню: ");
            option = scan.next();
            menu.selectOption(option);
        } while (!option.equals("0"));
        scan.close();
    }
}
