module com.teksoto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.teksoto to javafx.fxml;
    opens com.model to javafx.base;

    exports com.teksoto;
}
