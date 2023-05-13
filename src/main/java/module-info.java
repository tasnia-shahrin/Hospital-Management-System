module com.example.oopproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.oopproject to javafx.fxml;
    exports com.example.oopproject;
}