package il.cshaifasweng.OCSFMediatorExample.client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;
import il.cshaifasweng.OCSFMediatorExample.entities.CatalogDAO;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.Label;

public class PrimaryController {
	@FXML // fx:id="catalog"
	private TableView<CatalogItem> catalog; // Value injected by FXMLLoader

	@FXML // fx:id="moreDetails"
	private TableColumn<CatalogItem, Void> Details; // Value injected by FXMLLoader

	@FXML // fx:id="name"
	private TableColumn<CatalogItem, String> name; // Value injected by FXMLLoader

	@FXML // fx:id="price"
	private TableColumn<CatalogItem, Double> price; // Value injected by FXMLLoader

	@FXML // fx:id="showCatalog"
	private Button showCatalog; // Value injected by FXMLLoader

	@FXML // fx:id="type"
	private TableColumn<CatalogItem, String> type;

	@FXML
	private Label address;


	@FXML
	void initialize() {
		catalog.setVisible(false);
		catalog.setManaged(false);
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		type.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
		price.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
		createButton();
	}

	void createButton() {
		Callback<TableColumn<CatalogItem, Void>, TableCell<CatalogItem, Void>> cellFactory = new Callback<>() {
			@Override
			public TableCell<CatalogItem, Void> call(final TableColumn<CatalogItem, Void> param) {
				return new TableCell<>() {
					private final Button btn = new Button("more...");

					{
						btn.setOnAction(event -> {
							CatalogItem item = getTableView().getItems().get(getIndex());
							int idToPass = item.getId();
							try {
								SecondaryController.setSelectedId(idToPass); // make this method static in SecondaryController
								App.setRoot("secondary");
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
			}
		};

		Details.setCellFactory(cellFactory);
	}

	@FXML
	void ShowCatalog(ActionEvent event) {
		CatalogDAO CDB = new CatalogDAO();
		List<CatalogItem> itemList = CDB.getAllItems();// Load from database
		//testing
		/*if (itemList.isEmpty()) {
			System.out.println("Catalog is empty.");
		} else {
			for (CatalogItem item : itemList) {
				System.out.println(item);
			}
		}*/
		ObservableList<CatalogItem> items = FXCollections.observableArrayList(itemList);
		catalog.setItems(items);
		catalog.setVisible(true);
		catalog.setManaged(true);
	}
	public void updateItemPrice(int itemId, double newPrice) {
		catalog.getItems().stream()
				.filter(item -> item.getId() == itemId)
				.findFirst()
				.ifPresent(item -> {
					item.setPrice(newPrice);
					catalog.refresh();
				});
	}

	@FXML
	void sendWarning(ActionEvent event) {
		try {
			SimpleClient.getClient().sendToServer("#warning");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}