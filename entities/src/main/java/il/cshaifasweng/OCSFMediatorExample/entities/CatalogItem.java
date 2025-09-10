package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Catalog")
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String type;

    private double price;

    @Column(name = "pic_path")
    private String picPath;

    // Availability in stores
    //@ManyToMany(mappedBy = "items")
    //private Set<Store> availableInStores = new HashSet<>();

    // Orders containing this item (many-to-many with extra info via OrderItem)
    /*@OneToMany(mappedBy = "catalogItem")
    private Set<Order> orderItems = new HashSet<>();

    // Complaints related to this item
    @OneToMany(mappedBy = "catalogItem")
    private Set<Complaint> complaints = new HashSet<>();*/

    public CatalogItem() {}

    public CatalogItem(String name, String type, double price, String picPath) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.picPath = picPath;
    }

    // Getters and setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPicPath() { return picPath; }
    public void setPicPath(String picPath) { this.picPath = picPath; }


    @Override
    public String toString() {
        return String.format("CatalogItem{id=%d, name='%s', type='%s', price=%.2f, picPath='%s'}",
                id, name, type, price, picPath);
    }
}
