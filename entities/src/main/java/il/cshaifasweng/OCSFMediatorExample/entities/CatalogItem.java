package il.cshaifasweng.OCSFMediatorExample.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static java.lang.reflect.Array.set;
@Entity
public class CatalogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String type;
    private String path;
    private boolean available;
    public CatalogItem(int id, String name, String type, double price,String path,boolean available) {
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
        this.path=path;
        this.available=available;
    }

    public CatalogItem() {
    }

    // Getters and setters
    public int getId() { return id;}
    public String getName() { return name;}
    public double getPrice() { return price;}
    public String getType() { return type; }
    public double priceProperty() { return price; }
    public String getPath() { return path; }
    public boolean isAvailable() { return available; }
    public void setId(int id) { this.id=id; }
    public void setName(String name) { this.name=name; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) {  this.price=price; }
    public void setPath(String path) { this.path=path; }
    public void setAvailable(boolean available) { this.available=available; }

    public String toString() {
        return String.format("CatalogItem{id=%d, name='%s', type='%s', price=%.2f}",
                id, name, type, price);
    }
}
