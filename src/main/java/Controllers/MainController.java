package Controllers;

import Logic.Materials.Material;
import Logic.Tools.Tool;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ComboBox<String> toolComboBox;

    @FXML
    private HBox toolOptionsContainer;

    @FXML
    private HBox toolStatsContainer;

    @FXML
    private Button calculateButton;

    @FXML
    public void initialize() {
        toolComboBox.getItems().addAll("Pickaxe", "Shovel", "Hatchet", "Mattock", "Hammer", "Excavator", "Lumber Axe", "Scythe");
        toolComboBox.setOnAction(event -> handleToolSelection(toolComboBox.getValue()));
        calculateButton.setOnAction(event -> {
            toolOptionsContainer.getChildren().removeIf((Node n) -> n.getId() != null && n.getId().equals("errorLabel"));
            try{
                calculateToolStats();
            }
            catch (Exception e){
                Label errorLabel = new Label(e.getMessage());
                errorLabel.setId("errorLabel");
                toolOptionsContainer.getChildren().add(errorLabel);
                System.out.println(e.getMessage());
            }

        });
    }
    private void handleToolSelection(String selectedTool) {
        toolOptionsContainer.getChildren().clear(); // Clear previous dropdowns

        switch (selectedTool) {
            case "Pickaxe" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Pickaxe Head:"),
                    createMaterialDropdown("Pickaxe Head"),
                    new Label("Binding:"),
                    createMaterialDropdown("Binding"),
                    new Label("Tool Rod:"),
                    createMaterialDropdown("Tool Rod")
            );

            case "Shovel" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Shovel Head:"),
                    createMaterialDropdown("Shovel Head"),
                    new Label("Tool Rod:"),
                    createMaterialDropdown("Tool Rod")
            );

            case "Hatchet" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Hatchet Head:"),
                    createMaterialDropdown("Hatchet Head"),
                    new Label("Tool Rod:"),
                    createMaterialDropdown("Tool Rod")
            );

            case "Mattock" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Axe Head:"),
                    createMaterialDropdown("Axe Head"),
                    new Label("Shovel Head:"),
                    createMaterialDropdown("Shovel Head"),
                    new Label("Tool Rod:"),
                    createMaterialDropdown("Tool Rod")
            );

            case "Hammer" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Hammer Head:"),
                    createMaterialDropdown("Hammer Head"),
                    new Label("Large Plate:"),
                    createMaterialDropdown("Large Plate"),
                    new Label("Large Plate:"),
                    createMaterialDropdown("Large Plate"),
                    new Label("Tough Tool Rod:"),
                    createMaterialDropdown("Tough Tool Rod")
            );

            case "Scythe" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Scythe Head:"),
                    createMaterialDropdown("Scythe Head"),
                    new Label("Tough Tool Binding:"),
                    createMaterialDropdown("Tough Tool Binding"),
                    new Label("Tough Tool Rod:"),
                    createMaterialDropdown("Tough Tool Rod"),
                    new Label("Tough Tool Rod:"),
                    createMaterialDropdown("Tough Tool Rod")
            );
            case "Excavator" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Broad Shovel Head:"),
                    createMaterialDropdown("Broad Shovel Head"),
                    new Label("Large Plate:"),
                    createMaterialDropdown("Large Plate"),
                    new Label("Tough Tool Binding:"),
                    createMaterialDropdown("Tough Tool Binding"),
                    new Label("Tough Tool Rod:"),
                    createMaterialDropdown("Tough Tool Rod")
            );
            case "Lumber Axe" ->
                    toolOptionsContainer.getChildren().addAll(
                    new Label("Broad Axe Head:"),
                    createMaterialDropdown("Broad Axe Head"),
                    new Label("Large Plate:"),
                    createMaterialDropdown("Large Plate"),
                    new Label("Tough Tool Binding:"),
                    createMaterialDropdown("Tough Tool Binding"),
                    new Label("Tough Tool Rod:"),
                    createMaterialDropdown("Tough Tool Rod")
            );
        }
        System.out.println(toolOptionsContainer.getChildren().size());
    }

    private ComboBox<String> createMaterialDropdown(String id) {
        ComboBox<String> materialDropdown = new ComboBox<>();
        materialDropdown.setPromptText("--Select Material--");
        materialDropdown.setItems(FXCollections.observableArrayList(Material.MATERIALS));
        materialDropdown.setId(id);
        return materialDropdown;
    }

    private void calculateToolStats() throws Exception{
        String selectedTool = toolComboBox.getValue();
        if (selectedTool == null || selectedTool.isEmpty()) {
            System.out.println("No tool selected!");
            return;
        }
        List<String> selectedMaterials = getMaterials();
        System.out.println("Created ToolStats: " + selectedTool + " " + selectedMaterials);
    }

    private List<String> getMaterials() throws Exception {
        List<String> selectedMaterials = new ArrayList<>();

        for (Node node : toolOptionsContainer.getChildren()) {
            if (node instanceof ComboBox<?>) {
                @SuppressWarnings("unchecked")
                ComboBox<String> materialBox = (ComboBox<String>) node;
                String selectedMaterial = materialBox.getValue();
                if (selectedMaterial != null) {
                    selectedMaterials.add(selectedMaterial);
                }
                else {

                    throw new Exception("please select " + materialBox.getId() + " material");
                }
            }
        }
        return selectedMaterials;
    }
}
