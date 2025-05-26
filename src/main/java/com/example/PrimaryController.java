/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package com.example;

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




import il.cshaifasweng.OCSFMediatorExample.entities.Item;

import java.io.IOException;

public class PrimaryController {

    @FXML // fx:id="catalog"
    private TableView<Item> catalog; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetails"
    private TableColumn<Item, Void> moreDetails; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TableColumn<Item, String> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="price"
    private TableColumn<Item, Double> priceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="showCatalog"
    private Button showCatalog; // Value injected by FXMLLoader

    @FXML // fx:id="type"
    private TableColumn<Item, String> typeColumn; // Value injected by FXMLLoader


    @FXML
    public void initialize() {
        catalog.setVisible(false);
        addButtonToTable();

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());


        ObservableList<Item> items = FXCollections.observableArrayList(
                new Item(1, "אביבית", "פרחים לבנים", 15),
                new Item(2, "אירוס הדור", "פרחים לבנים", 9),
                new Item(3, "אסתר מרצעני", "פרחים לבנים", 12),
                new Item(4, "גזר קיפח", "פרחים לבנים", 20),
                new Item(5, "חבלבל השדה", "פרחים לבנים", 7)
        );

        catalog.setItems(items);
        System.out.println("Items loaded: " + catalog.getItems().size());
    }


    private void addButtonToTable() {
        Callback<TableColumn<Item, Void>, TableCell<Item, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Item, Void> call(final TableColumn<Item, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button("עוד...");

                    {
                        btn.setOnAction(event ->  {
                            Item item = getTableView().getItems().get(getIndex());
                            int idToPass = item.getId();
                            try {
                                SecondaryController.setSelectedId(idToPass);
                                App.setRoot("secondary", 600, 400);
                            } catch (IOException e) {
                                e.printStackTrace(); // Or show an alert, log it, etc.
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

        moreDetails.setCellFactory(cellFactory);
    }

    @FXML
    void ShowCatalog(ActionEvent event) {
        catalog.setVisible(true);
    }

}

