/**
 * Sample Skeleton for 'secondary.fxml' Controller Class
 */

package com.example;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleIntegerProperty;


import javafx.scene.control.TableCell;
import javafx.util.Callback;

import il.cshaifasweng.OCSFMediatorExample.entities.Item;

import java.io.IOException;



public class SecondaryController {

    private static int selectedId;

    @FXML // fx:id="bckToCtg"
    private Button bckToCtg; // Value injected by FXMLLoader

    @FXML // fx:id="fullCatalog"
    private TableView<Item> fullCatalog; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TableColumn<Item, Integer> idColumn; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TableColumn<Item, String> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="newPrice"
    private TextField newPrice; // Value injected by FXMLLoader

    @FXML // fx:id="price"
    private TableColumn<Item, Double> priceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="type"
    private TableColumn<Item, String> typeColumn; // Value injected by FXMLLoader

    @FXML // fx:id="updatePrice"
    private Button updatePrice; // Value injected by FXMLLoader


    @FXML
    void BckToCtg(ActionEvent event) throws IOException {
        App.setRoot("primary",1000,800);
    }

    public static void setSelectedId(int id) {
        selectedId = id;
    }


    @FXML
    public void initialize() {

        System.out.println("Received ID: " + selectedId);

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());


        ObservableList<Item> items = FXCollections.observableArrayList(
                new Item(1, "אביבית", "פרחים לבנים", 15),
                new Item(2, "אירוס הדור", "פרחים לבנים", 9)
        );

        fullCatalog.setItems(items);
        System.out.println("Items loaded: " + fullCatalog.getItems().size());
    }

    @FXML
    void UpdatePrice(ActionEvent event) {

    }

}

