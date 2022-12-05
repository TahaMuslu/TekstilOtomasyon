module com.teksoto {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.teksoto to javafx.fxml;
    exports com.teksoto;
}
