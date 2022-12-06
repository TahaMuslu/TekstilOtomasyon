package com.teksoto;

import java.sql.ResultSet;
import java.sql.Statement;

import com.model.Deneme;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MainPageController {
    /*
     * @FXML
     * private void switchToSecondary() throws IOException {
     * App.setRoot("secondary");
     * }
     */

    private double xOffset = 0;
    private double yOffset = 0;
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @FXML
    private HBox topBar;

    @FXML
    private Button personellerButton;
    @FXML
    private Button urunlerButton;
    @FXML
    private Button alimsatimlarButton;
    @FXML
    private Button musterilervenakliyecilerButton;
    @FXML
    private Button ggButton;

    @FXML
    private TabPane personellerTab;
    @FXML
    private TabPane urunlerTab;
    @FXML
    private TabPane alimsatimlarTab;
    @FXML
    private TabPane musterilervenakliyecilerTab;
    @FXML
    private TabPane ggTab;

    @FXML
    private TableView<Deneme> personelTablo;
    @FXML
    private TableColumn<Deneme, Integer> pt_id;
    @FXML
    private TableColumn<Deneme, String> pt_isim;
    @FXML
    private TableColumn<Deneme, String> pt_soyisim;
    @FXML
    private TableColumn<Deneme, String> pt_sehir;
    @FXML
    private TableColumn<Deneme, Integer> pt_maas;

    @FXML
    private void personellerButtonAction() {
        tabloKapat();
        personellerTab.setVisible(true);

        ObservableList<Deneme> personelList = FXCollections.observableArrayList();
        try {
            pt_id.setCellValueFactory(new PropertyValueFactory<Deneme, Integer>("id"));
            pt_isim.setCellValueFactory(new PropertyValueFactory<Deneme, String>("isim"));
            pt_soyisim.setCellValueFactory(new PropertyValueFactory<Deneme, String>("soyisim"));
            pt_sehir.setCellValueFactory(new PropertyValueFactory<Deneme, String>("sehir"));
            pt_maas.setCellValueFactory(new PropertyValueFactory<Deneme, Integer>("maas"));

        } catch (Exception e) {
            // System.out.println(e.getMessage());
        }

        String sql = "SELECT * FROM deneme";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                personelList.add(new Deneme(
                        resultSet.getInt("iddeneme"),
                        resultSet.getString("isim"),
                        resultSet.getString("soyisim"),
                        resultSet.getString("sehir"),
                        resultSet.getInt("maas")));
            }
            personelTablo.setItems(personelList);
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            // e.printStackTrace();
            // e.getCause();
        }

    }

    @FXML
    private void urunlerButtonAction() {
        tabloKapat();
        urunlerTab.setVisible(true);
    }

    @FXML
    private void alimsatimlarButtonAction() {
        tabloKapat();
        alimsatimlarTab.setVisible(true);
    }

    @FXML
    private void musterilervenakliyecilerButtonAction() {
        tabloKapat();
        musterilervenakliyecilerTab.setVisible(true);
    }

    @FXML
    private void ggButtonAction() {
        tabloKapat();
        ggTab.setVisible(true);
    }

    private void tabloKapat() {
        personellerTab.setVisible(false);
        urunlerTab.setVisible(false);
        alimsatimlarTab.setVisible(false);
        musterilervenakliyecilerTab.setVisible(false);
        ggTab.setVisible(false);
    }

    @FXML
    private void stagePressed(MouseEvent event) {
        xOffset = topBar.getScene().getWindow().getX() - event.getScreenX();
        yOffset = topBar.getScene().getWindow().getY() - event.getScreenY();
    }

    @FXML
    private void stageDrag(MouseEvent event) {
        topBar.getScene().getWindow().setX(event.getScreenX() + xOffset);
        topBar.getScene().getWindow().setY(event.getScreenY() + yOffset);
    }

    @FXML
    private void shutdown() {
        Platform.exit();
    }

}
