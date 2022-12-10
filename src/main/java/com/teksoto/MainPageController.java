package com.teksoto;

import java.sql.ResultSet;
import java.sql.Statement;

import com.model.Personel;

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

    // Menü Butonları
    @FXML
    private Button personellerButton;
    @FXML
    private Button kumaslarButton;
    @FXML
    private Button urunlerButton;
    @FXML
    private Button alimsatimlarButton;
    @FXML
    private Button musterilervenakliyecilerButton;
    @FXML
    private Button tedarikcilerButton;

    // Menü Tabları ve Tablolar
    @FXML
    private TableView<Personel> personellerTablo;
    @FXML
    private TableView kumaslarTablo;
    @FXML
    private TableView urunlerTablo;
    @FXML
    private TabPane alimsatimlarTab;
    @FXML
    private TabPane musterilervenakliyecilerTab;
    @FXML
    private TableView tedarikcilerTablo;

    // Personeller Tablosu
    @FXML
    private TableColumn<Personel, Integer> p_id;
    @FXML
    private TableColumn<Personel, String> p_ad;
    @FXML
    private TableColumn<Personel, String> p_soyad;
    @FXML
    private TableColumn<Personel, String> p_iseBaslamaTarih;
    @FXML
    private TableColumn<Personel, String> p_unvan;
    @FXML
    private TableColumn<Personel, String> p_adres;
    @FXML
    private TableColumn<Personel, String> p_sehir;
    @FXML
    private TableColumn<Personel, String> p_ulke;
    @FXML
    private TableColumn<Personel, String> p_telefon;
    @FXML
    private TableColumn<Personel, String> p_dogumTarihi;
    @FXML
    private TableColumn<Personel, Integer> p_maas;
    @FXML
    private TableColumn<Personel, String> p_cinsiyet;

    // Personeller Tablosu
    @FXML
    private void personellerButtonAction() {
        tabloKapat();
        personellerTablo.setVisible(true);

        ObservableList<Personel> personelList = FXCollections.observableArrayList();

        p_id.setCellValueFactory(new PropertyValueFactory<Personel, Integer>("personel_id"));
        p_ad.setCellValueFactory(new PropertyValueFactory<Personel, String>("ad"));
        p_soyad.setCellValueFactory(new PropertyValueFactory<Personel, String>("soyad"));
        p_iseBaslamaTarih.setCellValueFactory(new PropertyValueFactory<Personel, String>("ise_baslama_tarih"));
        p_unvan.setCellValueFactory(new PropertyValueFactory<Personel, String>("unvan"));
        p_adres.setCellValueFactory(new PropertyValueFactory<Personel, String>("adres"));
        p_sehir.setCellValueFactory(new PropertyValueFactory<Personel, String>("sehir"));
        p_ulke.setCellValueFactory(new PropertyValueFactory<Personel, String>("ulke"));
        p_telefon.setCellValueFactory(new PropertyValueFactory<Personel, String>("telefon"));
        p_dogumTarihi.setCellValueFactory(new PropertyValueFactory<Personel, String>("dogum_tarihi"));
        p_maas.setCellValueFactory(new PropertyValueFactory<Personel, Integer>("maas"));
        p_cinsiyet.setCellValueFactory(new PropertyValueFactory<Personel, String>("cinsiyet"));

        String sql = "SELECT * FROM personeller";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                personelList.add(new Personel(
                        resultSet.getInt("personel_id"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("ise_baslama_tarih"),
                        resultSet.getString("unvan"),
                        resultSet.getString("adres"),
                        resultSet.getString("sehir"),
                        resultSet.getString("ulke"),
                        resultSet.getString("telefon"),
                        resultSet.getString("dogum_tarihi"),
                        resultSet.getInt("maas"),
                        resultSet.getString("cinsiyet")));
            }
            personellerTablo.setItems(personelList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    // Kumaşlar Tablosu
    @FXML
    private void kumaslarButtonAction() {
        tabloKapat();
        kumaslarTablo.setVisible(true);
    }

    // Ürünler Tablosu
    @FXML
    private void urunlerButtonAction() {
        tabloKapat();
        urunlerTablo.setVisible(true);
    }

    // Alım-Satım Tablosu
    @FXML
    private void alimsatimlarButtonAction() {
        tabloKapat();
        alimsatimlarTab.setVisible(true);
    }

    // Müşteriler ve Nakliyeciler Tablosu
    @FXML
    private void musterilervenakliyecilerButtonAction() {
        tabloKapat();
        musterilervenakliyecilerTab.setVisible(true);
    }

    // Tedarikçiler Tablosu
    @FXML
    private void tedarikcilerButtonAction() {
        tabloKapat();
        tedarikcilerTablo.setVisible(true);
    }

    // Tabloları Kapatma
    private void tabloKapat() {
        personellerTablo.setVisible(false);
        kumaslarTablo.setVisible(false);
        urunlerTablo.setVisible(false);
        alimsatimlarTab.setVisible(false);
        musterilervenakliyecilerTab.setVisible(false);
        tedarikcilerTablo.setVisible(false);
    }

    // Drag and Drop
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

    // Kapatma Butonu
    @FXML
    private void shutdown() {
        Platform.exit();
    }

}
