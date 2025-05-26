package il.cshaifasweng.OCSFMediatorExample.entities;

public class CatalogItem {
    private int id;
    private String name;
    private String type;
    private double price;

    public CatalogItem(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("CatalogItem{id=%d, name='%s', type='%s', price=%.2f}", id, name, type, price);
    }
}
