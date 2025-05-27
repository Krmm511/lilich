package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;

public class PriceUpdateMessage implements Serializable {
    private final int itemId;
    private final double newPrice;

    public PriceUpdateMessage(int itemId, double newPrice) {
        this.itemId = itemId;
        this.newPrice = newPrice;
    }

    // Getters
    public int getItemId() { return itemId; }
    public double getNewPrice() { return newPrice; }
}