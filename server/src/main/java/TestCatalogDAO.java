import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogDAO;
import java.util.List;

public class TestCatalogDAO {
    public static void main(String[] args) {
        CatalogDAO dao = new CatalogDAO();
        List<CatalogItem> items = dao.getAllItems();

        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            for (CatalogItem item : items) {
                System.out.println(item);
            }
        }
    }
}