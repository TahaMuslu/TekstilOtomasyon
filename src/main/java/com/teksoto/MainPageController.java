package com.teksoto;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.model.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainPageController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    // Üst Bar
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
    private TableView<Kumas> kumaslarTablo;
    @FXML
    private TableView<Urunler> urunlerTablo;
    @FXML
    private TableView<Musteri> musterilerTablo;
    @FXML
    private TableView<Nakliyeci> nakliyecilerTablo;
    @FXML
    private Tab musterilerTab;
    @FXML
    private Tab nakliyecilerTab;
    @FXML
    private TabPane alimsatimlarTab;
    @FXML
    private TabPane musterilervenakliyecilerTab;
    @FXML
    private TableView<Tedarikciler> tedarikcilerTablo;

    // Müşteriler Tablosu
    @FXML
    private TableColumn<Musteri, Integer> m_id;
    @FXML
    private TableColumn<Musteri, String> m_ad;
    @FXML
    private TableColumn<Musteri, String> m_soyad;
    @FXML
    private TableColumn<Musteri, String> m_unvan;
    @FXML
    private TableColumn<Musteri, String> m_adres;
    @FXML
    private TableColumn<Musteri, String> m_sehir;
    @FXML
    private TableColumn<Musteri, String> m_ulke;
    @FXML
    private TableColumn<Musteri, String> m_telefon;
    @FXML
    private TableColumn<Musteri, String> m_sirketAd;

    // Nakliyeciler Tablosu
    @FXML
    private TableColumn<Nakliyeci, Integer> n_id;
    @FXML
    private TableColumn<Nakliyeci, String> n_sirketAd;
    @FXML
    private TableColumn<Nakliyeci, String> n_telefon;

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

    // Alim-Satim Accordion
    @FXML
    private Accordion satimlarAccordion;
    @FXML
    private Accordion alimlarAccordion;

    // Kumaslar Tablosu
    @FXML
    private TableColumn<Kumas, Integer> k_id;
    @FXML
    private TableColumn<Kumas, String> k_ad;
    @FXML
    private TableColumn<Kumas, Integer> k_stok;
    @FXML
    private TableColumn<Kumas, Integer> k_tedarikciID;
    @FXML
    private TableColumn<Kumas, Integer> k_birimFiyat;

    // Urunler Tablosu
    @FXML
    private TableColumn<Urunler, Integer> u_id;
    @FXML
    private TableColumn<Urunler, String> u_ad;
    @FXML
    private TableColumn<Urunler, Integer> u_kumasID;
    @FXML
    private TableColumn<Urunler, Integer> u_paketMiktar;
    @FXML
    private TableColumn<Urunler, Integer> u_paketFiyat;
    @FXML
    private TableColumn<Urunler, Integer> u_stok;

    // Tedarikciler Tablosu
    @FXML
    private TableColumn<Tedarikciler, Integer> t_id;
    @FXML
    private TableColumn<Tedarikciler, String> t_sirketAd;
    @FXML
    private TableColumn<Tedarikciler, String> t_webSayfasi;
    @FXML
    private TableColumn<Tedarikciler, String> t_adres;
    @FXML
    private TableColumn<Tedarikciler, String> t_sehir;
    @FXML
    private TableColumn<Tedarikciler, String> t_ulke;
    @FXML
    private TableColumn<Tedarikciler, String> t_telefon;

    // Veri Ekleme Silme Güncelleme
    @FXML
    private Button ekleButton;
    @FXML
    private Button silButton;
    @FXML
    private Button guncelleButton;

    // Personeller Tablosu
    @FXML
    private void personellerButtonAction() {
        tabloKapat();
        personellerTablo.setVisible(true);

        ekleButton.setText("Personel Ekle");
        silButton.setText("Personel Sil");
        guncelleButton.setText("Personel Güncelle");
        buttonAc();

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

        ekleButton.setText("Kumaş Ekle");
        silButton.setText("Kumaş Sil");
        guncelleButton.setText("Kumaş Güncelle");
        buttonAc();

        ObservableList<Kumas> kumasList = FXCollections.observableArrayList();

        k_id.setCellValueFactory(new PropertyValueFactory<Kumas, Integer>("kumas_id"));
        k_ad.setCellValueFactory(new PropertyValueFactory<Kumas, String>("kumas_ad"));
        k_stok.setCellValueFactory(new PropertyValueFactory<Kumas, Integer>("stok"));
        k_tedarikciID.setCellValueFactory(new PropertyValueFactory<Kumas, Integer>("tedarikci_id"));
        k_birimFiyat.setCellValueFactory(new PropertyValueFactory<Kumas, Integer>("birim_fiyat"));

        String sql = "SELECT * FROM kumaslar";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                kumasList.add(new Kumas(
                        resultSet.getInt("kumas_id"),
                        resultSet.getString("kumas_ad"),
                        resultSet.getInt("stok"),
                        resultSet.getInt("tedarikci_id"),
                        resultSet.getInt("birim_fiyat")));
            }
            kumaslarTablo.setItems(kumasList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Ürünler Tablosu
    @FXML
    private void urunlerButtonAction() {
        tabloKapat();
        urunlerTablo.setVisible(true);

        ekleButton.setText("Ürün Ekle");
        silButton.setText("Ürün Sil");
        guncelleButton.setText("Ürün Güncelle");
        buttonAc();

        ObservableList<Urunler> urunList = FXCollections.observableArrayList();

        u_id.setCellValueFactory(new PropertyValueFactory<Urunler, Integer>("urun_id"));
        u_ad.setCellValueFactory(new PropertyValueFactory<Urunler, String>("urun_adi"));
        u_kumasID.setCellValueFactory(new PropertyValueFactory<Urunler, Integer>("kumas_id"));
        u_paketMiktar.setCellValueFactory(new PropertyValueFactory<Urunler, Integer>("paket_miktar"));
        u_paketFiyat.setCellValueFactory(new PropertyValueFactory<Urunler, Integer>("paket_fiyat"));
        u_stok.setCellValueFactory(new PropertyValueFactory<Urunler, Integer>("stok"));

        String sql = "SELECT * FROM urunler";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                urunList.add(new Urunler(
                        resultSet.getInt("urun_id"),
                        resultSet.getString("urun_adi"),
                        resultSet.getInt("kumas_id"),
                        resultSet.getInt("paket_miktar"),
                        resultSet.getInt("paket_fiyat"),
                        resultSet.getInt("stok")));
            }
            urunlerTablo.setItems(urunList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Alım-Satım Tablosu
    @FXML
    private void alimsatimlarButtonAction() {
        tabloKapat();
        alimsatimlarTab.setVisible(true);
        satimlarOlustur();
        alimlarOlustur();

        ekleButton.setText("Fatura Kes");
        silButton.setText("Fatura Sil");
        buttonAc();
        guncelleButton.setVisible(false);

    }

    private void satimlarOlustur() {
        // Satimlar Tablosu
        ObservableList<Satislar> satislarList = FXCollections.observableArrayList();
        ObservableList<SatisDetay> satisDetayList = FXCollections.observableArrayList();

        try {
            // İlk Sorgu
            String sql = "SELECT * FROM tekstil_otomasyonu.satislar s INNER JOIN tekstil_otomasyonu.musteriler m on s.musteri_id=m.musteri_id ORDER BY satis_tarihi;";
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                satislarList.add(new Satislar(
                        resultSet.getInt("satis_id"),
                        resultSet.getInt("musteri_id"),
                        resultSet.getString("satis_tarihi"),
                        resultSet.getInt("nakliye_ucreti"),
                        resultSet.getInt("nakliyeci_id")));

                String sql2 = "SELECT * FROM tekstil_otomasyonu.satis_detay " + "WHERE satis_id="
                        + satislarList.get(satislarList.size() - 1).getSatis_id() + ";";
                Statement statement2 = databaseConnection.getConnection().createStatement();
                ResultSet resultSet2 = statement2.executeQuery(sql2);

                while (resultSet2.next()) {
                    satisDetayList.add(new SatisDetay(
                            resultSet2.getInt("satis_id"),
                            resultSet2.getInt("miktar"),
                            resultSet2.getInt("urun_id")));
                }
                TableView<SatisDetay> table = new TableView<SatisDetay>();
                tableViewSablon(table, satisDetayList);
                satisDetayList.clear();

                Pane pane = new Pane();
                pane.getChildren().add(table);

                // Titled Pane Şablonu
                TitledPane sablon = new TitledPane(
                        "{ID: " + resultSet.getInt("satis_id") + "}  -  " + resultSet.getString("satis_tarihi") + " - "
                                + resultSet.getString("ad") + " "
                                + resultSet.getString("soyad"),
                        pane);
                sablon.setId(resultSet.getString("satis_id"));
                satimlarAccordion.getPanes().add(sablon);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        // satimlarAccordion.getPanes().get(0).isExpanded();
    }

    private void alimlarOlustur() {
        // Satimlar Tablosu
        ObservableList<SatinAlimlar> satinAlimlarList = FXCollections.observableArrayList();
        ObservableList<SatinAlimDetay> satinAlimDetayList = FXCollections.observableArrayList();

        try {
            // İlk Sorgu
            String sql = "SELECT * FROM tekstil_otomasyonu.satin_alimlar s INNER JOIN tekstil_otomasyonu.tedarikciler t ON s.tedarikci_id=t.tedarikci_id ORDER BY satin_alim_tarih;";
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                satinAlimlarList.add(new SatinAlimlar(
                        resultSet.getInt("satin_alim_id"),
                        resultSet.getInt("tedarikci_id"),
                        resultSet.getString("satin_alim_tarih")));

                String sql2 = "SELECT * FROM tekstil_otomasyonu.satin_alim_detay " + "WHERE satin_alim_id="
                        + satinAlimlarList.get(satinAlimlarList.size() - 1).getSatin_alim_id() + ";";
                Statement statement2 = databaseConnection.getConnection().createStatement();
                ResultSet resultSet2 = statement2.executeQuery(sql2);

                while (resultSet2.next()) {
                    satinAlimDetayList.add(new SatinAlimDetay(
                            resultSet2.getInt("satin_alim_id"),
                            resultSet2.getInt("kumas_id"),
                            resultSet2.getInt("miktar")));
                }
                TableView<SatinAlimDetay> table = new TableView<SatinAlimDetay>();
                tableViewSablon2(table, satinAlimDetayList);
                satinAlimDetayList.clear();

                Pane pane = new Pane();
                pane.getChildren().add(table);

                // Titled Pane Şablonu
                TitledPane sablon = new TitledPane(
                        "{ID: " + resultSet.getInt("satin_alim_id") + "}  -  " + resultSet.getString("satin_alim_tarih")
                                + " - "
                                + resultSet.getString("sirket_adi"),
                        pane);
                sablon.setId(resultSet.getString("satin_alim_id"));
                alimlarAccordion.getPanes().add(sablon);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Müşteriler ve Nakliyeciler Tablosu
    @FXML
    private void musterilervenakliyecilerButtonAction() {
        tabloKapat();
        musterilervenakliyecilerTab.setVisible(true);

        if (musterilervenakliyecilerTab.getTabs().get(0).isSelected())
            musterilerAction();
        else
            nakliyecilerAction();
        buttonAc();

        ObservableList<Musteri> musteriList = FXCollections.observableArrayList();
        ObservableList<Nakliyeci> nakliyeciList = FXCollections.observableArrayList();

        m_id.setCellValueFactory(new PropertyValueFactory<Musteri, Integer>("musteri_id"));
        m_ad.setCellValueFactory(new PropertyValueFactory<Musteri, String>("ad"));
        m_soyad.setCellValueFactory(new PropertyValueFactory<Musteri, String>("soyad"));
        m_unvan.setCellValueFactory(new PropertyValueFactory<Musteri, String>("unvan"));
        m_adres.setCellValueFactory(new PropertyValueFactory<Musteri, String>("adres"));
        m_sehir.setCellValueFactory(new PropertyValueFactory<Musteri, String>("sehir"));
        m_ulke.setCellValueFactory(new PropertyValueFactory<Musteri, String>("ulke"));
        m_telefon.setCellValueFactory(new PropertyValueFactory<Musteri, String>("telefon"));
        m_sirketAd.setCellValueFactory(new PropertyValueFactory<Musteri, String>("sirket_ad"));

        n_id.setCellValueFactory(new PropertyValueFactory<Nakliyeci, Integer>("nakliyeci_id"));
        n_sirketAd.setCellValueFactory(new PropertyValueFactory<Nakliyeci, String>("sirket_ad"));
        n_telefon.setCellValueFactory(new PropertyValueFactory<Nakliyeci, String>("telefon"));

        String sql1 = "SELECT * FROM musteriler";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                musteriList.add(new Musteri(
                        resultSet.getInt("musteri_id"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("unvan"),
                        resultSet.getString("adres"),
                        resultSet.getString("sehir"),
                        resultSet.getString("ulke"),
                        resultSet.getString("telefon"),
                        resultSet.getString("sirket_ad")));
            }
            musterilerTablo.setItems(musteriList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        String sql2 = "SELECT * FROM nakliyeciler";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql2);
            while (resultSet.next()) {
                nakliyeciList.add(new Nakliyeci(
                        resultSet.getInt("nakliyeci_id"),
                        resultSet.getString("sirket_ad"),
                        resultSet.getString("telefon")));
            }
            nakliyecilerTablo.setItems(nakliyeciList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        musterilerTab.setContent(musterilerTablo);
        nakliyecilerTab.setContent(nakliyecilerTablo);

    }

    // Tedarikçiler Tablosu
    @FXML
    private void tedarikcilerButtonAction() {
        tabloKapat();
        tedarikcilerTablo.setVisible(true);

        ekleButton.setText("Tedarikçi Ekle");
        silButton.setText("Tedarikçi Sil");
        guncelleButton.setText("Tedarikçi Güncelle");
        buttonAc();

        ObservableList<Tedarikciler> tedarikciList = FXCollections.observableArrayList();

        t_id.setCellValueFactory(new PropertyValueFactory<Tedarikciler, Integer>("tedarikci_id"));
        t_sirketAd.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("sirket_adi"));
        t_webSayfasi.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("web_sayfasi"));
        t_adres.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("adres"));
        t_sehir.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("sehir"));
        t_ulke.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("ulke"));
        t_telefon.setCellValueFactory(new PropertyValueFactory<Tedarikciler, String>("telefon"));

        String sql = "SELECT * FROM tedarikciler";

        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tedarikciList.add(new Tedarikciler(
                        resultSet.getInt("tedarikci_id"),
                        resultSet.getString("sirket_adi"),
                        resultSet.getString("web_sayfasi"),
                        resultSet.getString("adres"),
                        resultSet.getString("sehir"),
                        resultSet.getString("ulke"),
                        resultSet.getString("telefon")));
            }
            tedarikcilerTablo.setItems(tedarikciList);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Ekleme İşlemleri
    @FXML
    private void ekleAction() {
        if (personellerTablo.isVisible())
            personelEkle();
        else if (kumaslarTablo.isVisible())
            kumasEkle();
        else if (urunlerTablo.isVisible())
            urunEkle();
        else if (alimsatimlarTab.isVisible())
            faturaKes();
        else if (musterilervenakliyecilerTab.isVisible()) {
            if (musterilerTab.isSelected())
                musteriEkle();
            else if (nakliyecilerTab.isSelected())
                nakliyeciEkle();

        } else if (tedarikcilerTablo.isVisible())
            tedarikciEkle();

    }

    private void faturaKes() {
    }

    private void musteriEkle() {
    }

    private void nakliyeciEkle() {
    }

    private void tedarikciEkle() {
    }

    private void urunEkle() {
    }

    private void kumasEkle() {
    }

    private void personelEkle() {

        String[] istenenler = { "Personel Adı*:", "Personel Soyadı*:", "Personel İşe Giriş Tarihi* (yyyy-mm-dd):",
                "Personel Ünvanı*:", "Personel Adresi:", "Personel Şehri:", "Personel Ülkesi:",
                "Personel Telefonu (xxx-xxx-xxxx):",
                "Personel Doğum Tarihi* (yyyy-mm-dd):", "Personel Maaşı*:",
                "Personel Cinsiyeti* (E/K):" };

        VBox vBox = eklemeFirst("Personel Ekleme", istenenler);

        // Eventler
        HBox hBox = (HBox) vBox.getChildren().get(vBox.getChildren().size() - 2);
        hBox.getChildren().get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String sql = "INSERT INTO personeller (ad, soyad, ise_baslama_tarih, unvan, adres, sehir, ulke, telefon, dogum_tarihi, maas, cinsiyet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try {
                    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
                    for (int i = 1; i < vBox.getChildren().size() - 2; i++) {
                        HBox hBoxTemp = (HBox) vBox.getChildren().get(i);
                        preparedStatement.setString(i, ((TextField) hBoxTemp.getChildren().get(1)).getText());
                    }
                    preparedStatement.executeUpdate();
                    App.setRoot("MainPage");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                    vBox.getChildren().get(vBox.getChildren().size() - 1).setVisible(true);
                }
            }
        });

        hBox.getChildren().get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    App.setRoot("MainPage");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        App.setRoot(vBox);

    }

    private VBox eklemeFirst(String baslik, String[] istenenler) {

        // VBox
        VBox vBox = new VBox();

        // Label
        Label label = new Label(baslik);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setPadding(new Insets(10, 0, 10, 0));
        vBox.setAlignment(Pos.CENTER);

        // Label2
        Label label2 = new Label("Lütfen İstenilenleri Uygun Şekilde Doldurunuz.\n*Zorunlu Alanlar");
        label2.setFont(Font.font("Arial", 15));
        label2.setTextFill(Paint.valueOf("red"));
        label2.setPadding(new Insets(10, 0, 10, 30));
        label2.setVisible(false);

        vBox.getChildren().add(label);

        for (int i = 0; i < istenenler.length; i++) {
            vBoxEkleme(vBox, istenenler[i]);
        }

        HBox hBox = new HBox();
        hBox.getChildren().add(new Button("İptal"));
        hBox.getChildren().add(new Button("Ekle"));
        ((Button) hBox.getChildren().get(0)).setMinWidth(100);
        ((Button) hBox.getChildren().get(1)).setMinWidth(100);
        hBox.setMargin(hBox.getChildren().get(0), new Insets(0, 125, 0, 25));

        vBox.getChildren().add(hBox);
        vBox.getChildren().add(label2);

        for (int i = 0; i < vBox.getChildren().size(); i++) {
            vBox.setMargin(vBox.getChildren().get(i), new Insets(10, 10, 10, 10));
        }

        vBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = vBox.getScene().getWindow().getX() - event.getScreenX();
                yOffset = vBox.getScene().getWindow().getY() - event.getScreenY();
            }
        });

        vBox.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                vBox.getScene().getWindow().setX(event.getScreenX() + xOffset);
                vBox.getScene().getWindow().setY(event.getScreenY() + yOffset);
            }
        });

        return vBox;

    }

    private void vBoxEkleme(VBox vBox, String label) {
        HBox hBox = new HBox();
        hBox.getChildren().add(new Label(label));
        hBox.setMargin(hBox.getChildren().get(0), new Insets(0, 10, 0, 0));
        ((Label) hBox.getChildren().get(0)).setMinWidth(210);
        hBox.getChildren().add(new TextField());
        vBox.getChildren().add(hBox);

    }

    // Silme İşlemleri
    @FXML
    private void silAction() {
        if (personellerTablo.isVisible())
            personelSil();
        else if (kumaslarTablo.isVisible())
            kumasSil();
        else if (urunlerTablo.isVisible())
            urunSil();
        else if (alimsatimlarTab.isVisible())
            faturaSil();
        else if (musterilervenakliyecilerTab.isVisible()) {
            if (musterilerTab.isSelected())
                musteriSil();
            else if (nakliyecilerTab.isSelected())
                nakliyeciSil();
        } else if (tedarikcilerTablo.isVisible())
            tedarikciSil();
    }

    private void tedarikciSil() {
    }

    private void nakliyeciSil() {
    }

    private void musteriSil() {
    }

    private void faturaSil() {
    }

    private void urunSil() {
    }

    private void kumasSil() {
    }

    private void personelSil() {
    }

    // Güncelleme İşlemleri
    @FXML
    private void guncelleAction() {
        if (personellerTablo.isVisible())
            personelGuncelle();
        else if (kumaslarTablo.isVisible())
            kumasGuncelle();
        else if (urunlerTablo.isVisible())
            urunGuncelle();
        else if (musterilervenakliyecilerTab.isVisible()) {
            if (musterilerTab.isSelected())
                musteriGuncelle();
            else if (nakliyecilerTab.isSelected())
                nakliyeciGuncelle();

        } else if (tedarikcilerTablo.isVisible())
            tedarikciGuncelle();

    }

    private void tedarikciGuncelle() {
    }

    private void nakliyeciGuncelle() {
    }

    private void musteriGuncelle() {
    }

    private void urunGuncelle() {
    }

    private void kumasGuncelle() {
    }

    private void personelGuncelle() {
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

    // Buttonları Kapatma
    private void buttonKapat() {
        ekleButton.setVisible(false);
        guncelleButton.setVisible(false);
        silButton.setVisible(false);
    }

    // Buttonları Açma
    private void buttonAc() {
        ekleButton.setVisible(true);
        guncelleButton.setVisible(true);
        silButton.setVisible(true);
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

    private void tableViewSablon(TableView<SatisDetay> sablon, ObservableList<SatisDetay> satisDetayList) {
        // Satışlar Tablosu Şablonu
        TableColumn<SatisDetay, Integer> kol1 = new TableColumn<SatisDetay, Integer>("satis_id");
        TableColumn<SatisDetay, Integer> kol2 = new TableColumn<SatisDetay, Integer>("miktar");
        TableColumn<SatisDetay, Integer> kol3 = new TableColumn<SatisDetay, Integer>("urun_id");
        kol1.setText("Satış ID");
        kol2.setText("Miktar");
        kol3.setText("Ürün ID");
        kol1.setCellValueFactory(new PropertyValueFactory<SatisDetay, Integer>("satis_id"));
        kol2.setCellValueFactory(new PropertyValueFactory<SatisDetay, Integer>("miktar"));
        kol3.setCellValueFactory(new PropertyValueFactory<SatisDetay, Integer>("urun_id"));
        sablon.getColumns().add(kol1);
        sablon.getColumns().add(kol2);
        sablon.getColumns().add(kol3);
        sablon.setMinHeight(300);
        sablon.setMinWidth(1018);
        sablon.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<SatisDetay> veriler = FXCollections.observableArrayList();
        veriler.addAll(satisDetayList);
        sablon.setItems(veriler);

    }

    private void tableViewSablon2(TableView<SatinAlimDetay> sablon, ObservableList<SatinAlimDetay> satinAlimDetayList) {
        // Satin Alimlar Tablosu Şablonu
        TableColumn<SatinAlimDetay, Integer> kol1 = new TableColumn<SatinAlimDetay, Integer>("satin_alim_id");
        TableColumn<SatinAlimDetay, Integer> kol2 = new TableColumn<SatinAlimDetay, Integer>("kumas_id");
        TableColumn<SatinAlimDetay, Integer> kol3 = new TableColumn<SatinAlimDetay, Integer>("miktar");
        kol1.setText("Satın Alım ID");
        kol2.setText("Kumaş ID");
        kol3.setText("Miktar");
        kol1.setCellValueFactory(new PropertyValueFactory<SatinAlimDetay, Integer>("satin_alim_id"));
        kol2.setCellValueFactory(new PropertyValueFactory<SatinAlimDetay, Integer>("kumas_id"));
        kol3.setCellValueFactory(new PropertyValueFactory<SatinAlimDetay, Integer>("miktar"));
        sablon.getColumns().add(kol1);
        sablon.getColumns().add(kol2);
        sablon.getColumns().add(kol3);
        sablon.setMinHeight(300);
        sablon.setMinWidth(1018);
        sablon.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<SatinAlimDetay> veriler = FXCollections.observableArrayList();
        veriler.addAll(satinAlimDetayList);
        sablon.setItems(veriler);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tabloKapat();
        buttonKapat();

    }

    @FXML
    private void musterilerAction() {
        ekleButton.setText("Müşteri Ekle");
        silButton.setText("Müşteri Sil");
        guncelleButton.setText("Müşteri Guncelle");
    }

    @FXML
    private void nakliyecilerAction() {
        ekleButton.setText("Nakliyeci Ekle");
        silButton.setText("Nakliyeci Sil");
        guncelleButton.setText("Nakliyeci Guncelle");
    }

}