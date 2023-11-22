package com.example.partb;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Demo");

        // Create a form with validation
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);

        Button submitButton = new Button("Submit");
        grid.add(submitButton, 1, 2);


        submitButton.setOnAction(e -> {
            if (nameField.getText().isEmpty() || ageField.getText().isEmpty()) {
                showAlert("Please fill in all fields.");
            } else {
                showAlert("Form submitted!\nName: " + nameField.getText() + "\nAge: " + ageField.getText());
            }
        });


        Label animationLabel = new Label("This label will animate");
        grid.add(animationLabel, 0, 3);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), animationLabel);
        translateTransition.setByX(100); // Translate by 100 pixels in the X direction
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();


        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}