package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;

public class UpdatePriceMessage implements Serializable {
    private int itemId;
    private double newPrice;

    public UpdatePriceMessage(int itemId, double newPrice) {
        this.itemId = itemId;
        this.newPrice = newPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public double getNewPrice() {
        return newPrice;
    }
}
