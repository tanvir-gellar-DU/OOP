import java.util.ArrayList;
import java.util.List;

class Product {
    private int serialNumber;
    private String title;
    private double cost;
    private int quantity;

    public Product(int serialNumber, String title, double cost, int quantity) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public void exhibitDetails() {
        System.out.println("Serial Number: " + serialNumber + " Title: " + title + " Cost: " + cost + " Quantity: " + quantity);
    }

    public void adjustPrice(double newCost) {
        this.cost = newCost;
    }

    public void modifyQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}

class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(int serialNumber, String title, double cost, int quantity, String brand, int warrantyPeriod) {
        super(serialNumber, title, cost, quantity);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void exhibitDetails() {
        super.exhibitDetails();
        System.out.println("Brand: " + brand + " Warranty Period: " + warrantyPeriod + " Months");
    }

    public void adjustWarrantyPeriod(int newWarrantyPeriod) {
        this.warrantyPeriod = newWarrantyPeriod;
    }
}

class OutfitProduct extends Product {
    private String size;
    private String shade;

    public OutfitProduct(int serialNumber, String title, double cost, int quantity, String size, String shade) {
        super(serialNumber, title, cost, quantity);
        this.size = size;
        this.shade = shade;
    }

    public void exhibitDetails() {
        super.exhibitDetails();
        System.out.println("Size: " + size + " Shade: " + shade);
    }
}

class GroceryProduct extends Product {
    private String expiryDate;
    private double storageTemperature;

    public GroceryProduct(int serialNumber, String title, double cost, int quantity, String expiryDate, double storageTemperature) {
        super(serialNumber, title, cost, quantity);
        this.expiryDate = expiryDate;
        this.storageTemperature = storageTemperature;
    }

    public void exhibitDetails() {
        super.exhibitDetails();
        System.out.println("Expiry Date: " + expiryDate + " Storage Temperature: " + storageTemperature);
    }
}

class Warehouse {
    private List<Product> items;

    public Warehouse() {
        this.items = new ArrayList<>();
    }

    public void includeItem(Product item) {
        this.items.add(item);
    }

    public void discardItem(int serialNumber) {
        items.removeIf(item -> item.getSerialNumber() == serialNumber);
    }

    public List<Product> searchByTitle(String title) {
        List<Product> results = new ArrayList<>();
        for (Product item : items) {
            if (item.getTitle().equals(title)) {
                results.add(item);
            }
        }
        return results;
    }
}

  

public class shop {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        ElectronicProduct gadget = new ElectronicProduct(1, "processor", 1000, 10, "macos", 24);
        OutfitProduct attire = new OutfitProduct(2, "shirts", 20, 50, "s", "Blue");
        GroceryProduct groceries = new GroceryProduct(3, "Milk", 2, 100, "5.10.24", 4);

        warehouse.includeItem(gadget);
        warehouse.includeItem(attire);
        warehouse.includeItem(groceries);

      
    }
}
    

