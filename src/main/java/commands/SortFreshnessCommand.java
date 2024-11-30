package commands;
import bouquet.Bouquet;
import flower.Flower;
import java.util.ArrayList;
import java.util.Comparator;

public class SortFreshnessCommand implements Command {
    private Bouquet bouquet;

    public SortFreshnessCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    public void execute() {
        if (bouquet.getFlowers().isEmpty()) {
            System.out.println("Букет порожній. Немає квіток для сортування.");
        } else {
            ArrayList<Flower> sortedFlowers = new ArrayList<>(bouquet.getFlowers());
            sortedFlowers.sort(Comparator.comparing(Flower::getFreshness));
            System.out.println("Квіти в букеті відсортовані за свіжістю:");
            for (int i = 0; i < sortedFlowers.size(); i++) {
                System.out.println((i + 1) + ". " + sortedFlowers.get(i));
            }
        }
    }
}
