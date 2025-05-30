/**
 * Sample Skeleton for 'secondary.fxml' Controller Class
 */
package il.cshaifasweng.OCSFMediatorExample.client;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogDAO;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogDAO;
import javax.print.DocFlavor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
public class SecondaryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="id"
    private TableColumn<CatalogItem,Integer > id; // Value injected by FXMLLoader

    @FXML // fx:id="itemsTable"
    private TableView<CatalogItem> itemsTable; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TableColumn<CatalogItem,String > name; // Value injected by FXMLLoader

    @FXML // fx:id="price"
    private TableColumn<CatalogItem,Double > price; // Value injected by FXMLLoader

    @FXML // fx:id="type"
    private TableColumn<CatalogItem, String> type;
    private static int selectedId;
    @FXML
    void initialize() {
        id.setCellValueFactory(cellData -> new  SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        type.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        price.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        int selectedId = getSelectedId(); // <-- Retrieve the selected ID
        CatalogDAO CDB = new CatalogDAO();
        CatalogItem item = CDB.getItemById(selectedId);
        ObservableList<CatalogItem> items = FXCollections.observableArrayList();
        items.add(item);
        itemsTable.setItems(items);
        itemsTable.refresh();
        price.setOnEditCommit(event -> {
            CatalogItem editedItem = event.getRowValue();
            editedItem.setPrice(event.getNewValue());
        });
        price.setEditable(true);


    }
    @FXML
    void CancelClicked(ActionEvent event) {
        try{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
      catch (IOException e) {
        e.printStackTrace();
    }

    }
    public static void setSelectedId(int id) {
        selectedId = id;
    }

    public static int getSelectedId() {
        return selectedId;
    }

  @FXML
    void SaveClicked(ActionEvent event) {
      try {
          CatalogDAO dao = new CatalogDAO();
          CatalogItem item = itemsTable.getItems().get(0);  // since it's one item
          dao.updatePrice(item.getId(), item.getPrice());  // assumes this method exists

          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
          Parent root = loader.load();

          Stage primaryStage = new Stage();
          primaryStage.setScene(new Scene(root));
          primaryStage.show();
      }
      catch (IOException e) {
          e.printStackTrace();
      }
    }

}
