package utils;
import flower.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public static List<Flower> flowersFromFile(String filename) {
        List<Flower> flowers = new ArrayList<>();
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("Файл не знайдено: " + filename);
            return flowers;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String color = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                int freshness = Integer.parseInt(parts[3].trim());
                int stemLength = Integer.parseInt(parts[4].trim());
                switch (type) {
                    case "Rose" -> {
                        boolean hasThorns = Boolean.parseBoolean(parts[5].trim());
                        flowers.add(new Rose(color, price, freshness, stemLength, hasThorns));
                    }
                    case "Lily" -> {
                        boolean hasFragrance = Boolean.parseBoolean(parts[5].trim());
                        flowers.add(new Lily(color, price, freshness, stemLength, hasFragrance));
                    }
                    case "Chamomile" -> {
                        int petalsCount = Integer.parseInt(parts[5].trim());
                        flowers.add(new Chamomile(color, price, freshness, stemLength, petalsCount));
                    }
                    default -> System.out.println("Невідомий тип квітки: " + type);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
        return flowers;
    }
}
