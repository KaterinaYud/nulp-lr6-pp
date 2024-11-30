package commands;
import bouquet.Bouquet;
import flower.Flower;
import accessory.Accessory;

public class CalculatePriceCommand implements Command {
    private Bouquet bouquet;

    public CalculatePriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    public void execute() {
        double totalPrice = calculatePrice();
        System.out.println("Загальна вартість букета: " + totalPrice + " грн");
    }

    public double calculatePrice() {
        double flowersPrice = bouquet.getFlowers().stream().mapToDouble(Flower::getPrice).sum();
        double accessoriesPrice = bouquet.getAccessories().stream().mapToDouble(Accessory::getPrice).sum();
        return flowersPrice + accessoriesPrice;
    }
}
