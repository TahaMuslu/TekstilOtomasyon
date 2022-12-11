package com.teksoto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MainPageController {

    private double xOffset = 0;
    private double yOffset = 0;

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
    private void personellerButtonAction() {
        tabloKapat();
        personellerTab.setVisible(true);
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
