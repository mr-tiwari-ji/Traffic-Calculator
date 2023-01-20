module com.traffic.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.traffic.calculator to javafx.fxml;
    exports com.traffic.calculator;
}