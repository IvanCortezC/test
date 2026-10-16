module com.cortez.ivan.ivancortez {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.cortez.ivan.ivancortez to javafx.fxml;
    exports com.cortez.ivan.ivancortez;
    exports com.cortez.ivan.ivancortez.controllerApp;
    opens com.cortez.ivan.ivancortez.controllerApp to javafx.fxml;
}