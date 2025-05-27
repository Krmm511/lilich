
package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;
import java.util.List;

public class CatalogResponseMessage implements Serializable {
    private List<CatalogItem> items;

    public CatalogResponseMessage(List<CatalogItem> items) {
        this.items = items;
    }

    public List<CatalogItem> getItems() {
        return items;
    }
}
