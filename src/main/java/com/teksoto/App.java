package com.teksoto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainPage"), 1200, 800);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("Teksoto");
        stage.getIcons().add(new Image("file:src/main/resources/com/assets/data-processing.png"));
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().setWidth(1200);
        scene.getWindow().setHeight(800);
        scene.getWindow().centerOnScreen();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void setRoot(Parent root, int width, int height) {
        scene.getWindow().setWidth(width);
        scene.getWindow().setHeight(height);
        scene.getWindow().centerOnScreen();
        scene.setRoot(root);
    }

    public static void main(String[] args) {
        launch();
    }

}