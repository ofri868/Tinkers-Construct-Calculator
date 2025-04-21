package Controllers;

import Logic.Materials.Material;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ComboBox<String> toolComboBox;

    @FXML
    private HBox toolOptionsContainer;

    @FXML
    private Button calculateButton;

    @FXML
    public void initialize() {
        toolComboBox.getItems().addAll("Pickaxe", "Shovel", "Hatchet", "Mattock", "Hammer", "Excavator", "Lumber Axe", "Scythe");

        toolComboBox.setOnAction(event -> {
            String selectedTool = toolComboBox.getValue();
            toolOptionsContainer.getChildren().clear();

            if (selectedTool == null) return;

            switch (selectedTool) {
                case "Pickaxe" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Pickaxe Head:"),
                            new ComboBox<>(),
                            new Label("Binding:"),
                            new ComboBox<>(),
                            new Label("Tool Rod:"),
                            new ComboBox<>()
                    );
                }

                case "Shovel" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Shovel Head:"),
                            new ComboBox<>(),
                            new Label("Tool Rod:"),
                            new ComboBox<>()
                    );
                }

                case "Hatchet" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Hatchet Head:"),
                            new ComboBox<>(),
                            new Label("Tool Rod:"),
                            new ComboBox<>()
                    );
                }

                case "Mattock" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Axe Head:"),
                            new ComboBox<>(),
                            new Label("Shovel Head:"),
                            new ComboBox<>(),
                            new Label("Tool Rod:"),
                            new ComboBox<>()
                    );
                }

                case "Hammer" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Head:"),
                            new ComboBox<>(),
                            new Label("Large Plate:"),
                            new ComboBox<>(),
                            new Label("Large Plate:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Rod:"),
                            new ComboBox<>()
                    );
                }

                case "Scythe" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Scythe Head:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Binding:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Rod:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Rod:"),
                            new ComboBox<>()
                    );
                }
                case "Excavator" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Broad Shovel Head:"),
                            new ComboBox<>(),
                            new Label("Large Plate:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Binding:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Rod:"),
                            new ComboBox<>()
                    );
                }
                case "Lumber Axe" -> {
                    toolOptionsContainer.getChildren().addAll(
                            new Label("Broad Axe Head:"),
                            new ComboBox<>(),
                            new Label("Large Plate:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Binding:"),
                            new ComboBox<>(),
                            new Label("Tough Tool Rod:"),
                            new ComboBox<>()
                    );
                }
            }
        });
    }
}
