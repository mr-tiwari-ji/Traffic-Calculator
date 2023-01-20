package com.traffic.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

public class TrafficCalculator extends Application {
    // Constants for the click-through rates for each position
    private static final double[] CTR = {20.5, 13.32, 13.14, 8.98, 9.21, 6.73, 7.61, 6.92, 5.52, 7.95};

    public void start(Stage stage) {
        // Create the input fields
        TextField currentPositionField = new TextField("Current Position (2-100)");
        TextField targetPositionField = new TextField("Target Position (1-10)");
        TextField keywordField = new TextField("Keyword");
        TextField volumeField = new TextField("Total Search Volumne");
        TextField conversionField = new TextField("Conversion Rate (%)");
        TextField valueField = new TextField("Average Value");
        ToggleGroup businessTypeGroup = new ToggleGroup();
        RadioButton ecommerceButton = new RadioButton("E-commerce");
        ecommerceButton.setToggleGroup(businessTypeGroup);
        RadioButton serviceButton = new RadioButton("Service-based");
        serviceButton.setToggleGroup(businessTypeGroup);
        TextField closeRateField = new TextField("Sales Close Rate (%)");

        // Create the calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> {
            // Get the values from the input fields
            int currentPos = Integer.parseInt(currentPositionField.getText());
            int targetPos = Integer.parseInt(targetPositionField.getText());
            String keyword = keywordField.getText();
            int volume = Integer.parseInt(volumeField.getText());
            double convRate = Double.parseDouble(conversionField.getText());
            double value = Double.parseDouble(valueField.getText());
            String businessType = ((RadioButton)businessTypeGroup.getSelectedToggle()).getText().toLowerCase();
            double closeRate = 0;
            if (businessType.equals("service-based")) {
                closeRate = Double.parseDouble(closeRateField.getText());
            }

            // Calculate the estimated traffic
            double traffic = volume * CTR[targetPos - 1] / 100;

            // Calculate the total conversions
            double conversions = traffic * convRate / 100;
            if (businessType.equals("service-based")) {
                conversions *= closeRate / 100;
            }

            // Calculate the revenue
            double revenue = conversions * value;

            // Display the result
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText(null);
            alert.setContentText(String.format("Estimated revenue: £%.2f", revenue));
            alert.showAndWait();
        });

        // Create the layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(7);
        grid.setHgap(7);
        grid.addRow(0, new Label("Current position:"), currentPositionField);
        grid.addRow(1, new Label("Target position:"), targetPositionField);
        grid.addRow(2, new Label("Keyword:"), keywordField);
        grid.addRow(3, new Label("Keyword total search volume:"), volumeField);
        grid.addRow(4, new Label("Average conversion rate:"), conversionField);
        grid.addRow(5, new Label("Average order value/customer value:"), valueField);
        grid.addRow(6, new Label("Type of business:"), ecommerceButton, serviceButton);
        ecommerceButton.setOnAction(actionEvent -> {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 7);
//            grid.getChildren().remove(16);

        });
        serviceButton.setOnAction(
                actionEvent -> {
                    grid.addRow(7, new Label("Average sales close rate:"), closeRateField);
                }
        );
        grid.addRow(8, calculateButton);

               // Set the layout and show the stage
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(calculateButton);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);
        borderPane.setBottom(vBox);
        BorderPane.setAlignment(vBox,Pos.CENTER);
        Scene scene = new Scene(borderPane, 700,350);
        stage.setTitle("Traffic Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

