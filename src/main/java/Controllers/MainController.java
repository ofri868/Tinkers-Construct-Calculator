package Controllers;

import Logic.Abilities.Ability;
import Logic.Materials.Material;
import Logic.Tools.Tool;
import Logic.Utils.PartType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public ImageView logoImage;
    private Tool tool;
    @FXML
    private ComboBox<String> toolComboBox;
    @FXML
    private HBox materialOptionsContainer;
    @FXML
    private VBox toolAbilitiesVBox;
    @FXML
    private Text toolName, toolStats, toolParts, errorLabel;
    @FXML
    private Button calculateButton;

    @FXML
    public void initialize() {
        toolComboBox.getItems().addAll("Pickaxe", "Shovel", "Hatchet", "Mattock", "Hammer", "Excavator", "Lumber Axe", "Scythe");
        toolComboBox.setOnAction(event -> handleToolSelection(toolComboBox.getValue()));
        calculateButton.setOnAction(event -> {
            errorLabel.setVisible(false);
            try{
                calculateToolStats();
            }
            catch (Exception e){
                displayError(e.getMessage());
                System.out.println(e.getMessage());
            }

        });
    }
    private void handleToolSelection(String selectedTool) {

        materialOptionsContainer.getChildren().clear();

        switch (selectedTool) {
            case "Pickaxe" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Pickaxe Head:"),
                        createLabelWithComboBox("Binding:"),
                        createLabelWithComboBox("Tool Rod:")
                );

            case "Shovel" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Shovel Head:"),
                        createLabelWithComboBox("Tool Rod:")
                );

            case "Hatchet" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Hatchet Head:"),
                        createLabelWithComboBox("Tool Rod:")
                );

            case "Mattock" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Axe Head:"),
                        createLabelWithComboBox("Shovel Head:"),
                        createLabelWithComboBox("Tool Rod:")
                );

            case "Hammer" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Hammer Head:"),
                        createLabelWithComboBox("Large Plate:"),
                        createLabelWithComboBox("Large Plate:"),
                        createLabelWithComboBox("Tough Tool Rod:")
                );

            case "Scythe" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Scythe Head:"),
                        createLabelWithComboBox("Tough Tool Binding:"),
                        createLabelWithComboBox("Tough Tool Rod:"),
                        createLabelWithComboBox("Tough Tool Rod:")
                );

            case "Excavator" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Broad Shovel Head:"),
                        createLabelWithComboBox("Large Plate:"),
                        createLabelWithComboBox("Tough Tool Binding:"),
                        createLabelWithComboBox("Tough Tool Rod:")
                );

            case "Lumber Axe" ->
                materialOptionsContainer.getChildren().addAll(
                        createLabelWithComboBox("Broad Axe Head:"),
                        createLabelWithComboBox("Large Plate:"),
                        createLabelWithComboBox("Tough Tool Binding:"),
                        createLabelWithComboBox("Tough Tool Rod:")
                );
        }
    }

    private VBox createLabelWithComboBox(String labelText) {
        VBox vbox = new VBox(5); // 5 is the spacing between the label and combo box
        vbox.setPadding(new Insets(0, 20, 10, 0)); // Padding: top, right, bottom, left
        Label label = new Label(labelText);
        label.setPadding(new Insets(0, 15, 5, 5)); // Optional: add padding to the label itself
        ComboBox<String> comboBox = createMaterialDropdown(labelText);
        comboBox.setPadding(new Insets(10, 15, 5, 5)); // Optional: add padding to the combo box
        vbox.getChildren().addAll(label, comboBox);
        return vbox;
    }

    private ComboBox<String> createMaterialDropdown(String id) {
        ComboBox<String> materialDropdown = new ComboBox<>();
        materialDropdown.setPromptText("--Select Material--");
        materialDropdown.setItems(FXCollections.observableArrayList(Material.MATERIALS));
        materialDropdown.setId(id);
        return materialDropdown;
    }

    private void calculateToolStats(){
        String selectedTool = toolComboBox.getValue();
        if (selectedTool == null || selectedTool.isEmpty()) {
            displayError("No Tool Selected");
            return;
        }
        List<Pair<PartType, String>> selectedMaterials;
        try{
            selectedMaterials = getMaterials();
            List<Pair<PartType, Material>> parts = new ArrayList<>();
            for (Pair<PartType, String> pair : selectedMaterials) {
                parts.add(new Pair<>(pair.getKey(), Material.createMaterialInstance(pair.getValue())));
            }
            tool = Tool.getTool(toolComboBox.getValue(), parts);
            displayToolStats();
        } catch (Exception e){
            displayError(e.getMessage());
        }
    }

    private List<Pair<PartType, String>> getMaterials() throws Exception {
        List<Pair<PartType, String>> selectedMaterials = new ArrayList<>();
        for (Node node : materialOptionsContainer.getChildren()) {
            if (node instanceof VBox) {
                for (Node child : ((VBox) node).getChildren()) {
                    if (child instanceof ComboBox) {
                        @SuppressWarnings("unchecked")
                        ComboBox<String> materialBox = (ComboBox<String>) child;
                        PartType partType = getSelectedPartType(child.getId());
                        String selectedMaterial = materialBox.getValue();
                        if (selectedMaterial != null) {
                            selectedMaterials.add(new Pair<>(partType, selectedMaterial));
                        }
                        else {
                            throw new Exception("please select " + materialBox.getId().replace(":", "") + " material");
                        }
                    }
                }
            }
        }
        return selectedMaterials;
    }

    private void displayToolStats() {
        if(tool == null){
            displayError("No Tool Selected");
            return;
        }
        toolName.setText(tool.toString());
        toolParts.setText(tool.getPartsString());
        toolStats.setText(tool.getStatsString());
        displayToolAbilities();
    }

    private void displayToolAbilities(){
        toolAbilitiesVBox.getChildren().clear();
        for(Ability ability: tool.getAbilities()){
            toolAbilitiesVBox.getChildren().add(createAbilityBox(ability));
        }
    }
    
    private Text createAbilityBox(Ability ability){
        Text abilityBox = new Text(ability.getName() + " - " + ability.getDescription());
        abilityBox.setWrappingWidth(500);
        abilityBox.setStyle("-fx-fill: " + ability.getColor());
        abilityBox.setFont(new Font(16));
        return abilityBox;
    }

    private PartType getSelectedPartType(String boxName) {
        if(boxName.toLowerCase().contains("rod")){
            return PartType.HANDLE;
        }
        else if(boxName.toLowerCase().contains("binding") || boxName.toLowerCase().contains("plate")){
            return PartType.EXTRA;
        }
        else if(boxName.toLowerCase().contains("head")){
            return PartType.HEAD;
        }
        throw new IllegalArgumentException("no material type found");
    }

    private void displayError(String text){
        errorLabel.setVisible(true);
        errorLabel.setText(text);
    }
}
