
package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;
import java.util.List;

public class CatalogResponseMessage implements Serializable {
    private List<Item> items;

    public CatalogResponseMessage(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
