package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import atlantafx.base.theme.CupertinoLight;




/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage pstage) throws IOException {
        stage =pstage;
        Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
        scene = new Scene(loadFXML("primary"));
        //scene = new Scene(loadFXML("secondary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml, double width, double height) throws IOException {
        Parent root =loadFXML(fxml);
        Scene newScene = new Scene(root, width, height);
        stage.setScene(newScene);
        stage.centerOnScreen();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}