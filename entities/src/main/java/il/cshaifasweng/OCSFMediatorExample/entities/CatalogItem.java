package il.cshaifasweng.OCSFMediatorExample.entities;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static java.lang.reflect.Array.set;

public class CatalogItem {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();
    private String type;


    public CatalogItem(int id, String name, String type, double price) {
        this.id.set(id);
        this.name.set(name);
        this.type=type;
        this.price.set(price);
    }

    // Getters and setters
    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public String getType() { return type; }
    public DoubleProperty priceProperty() { return price; }
    public void setId(int id) { this.id.set(id); }
    public void setName(String name) { this.name.set(name); }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) {  this.price.set(price); }

    @Override
    public String toString() {
        return String.format("CatalogItem{id=%d, name='%s', type='%s', price=%.2f}", id, name, type, price);
    }
}
