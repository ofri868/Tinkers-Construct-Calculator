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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainController {
    public ImageView logoImage;
    private Tool tool;
    private final Queue<Tool> toolsToCompare = new LinkedList<>();
    private final int TOOL_COMPARISON_CAP = 2;
    private boolean recreateComparison = true;
    @FXML
    private StackPane mainWindow;
    @FXML
    private Pane comparisonPane;
    @FXML
    private ComboBox<String> toolComboBox;
    @FXML
    private HBox materialOptionsContainer;
    @FXML
    private VBox toolStatsVBox, toolAbilitiesVBox, comparisonPaneVBox;
    @FXML
    private Text errorLabel;
    @FXML
    private Button calculateButton, addToComparisonButton, compareButton, exitButton;

    @FXML
    public void initialize() {
        comparisonPane.setVisible(false);
        comparisonPane.prefWidthProperty().bind(mainWindow.widthProperty());
        comparisonPane.prefHeightProperty().bind(mainWindow.heightProperty());
        toolComboBox.getItems().addAll("Pickaxe", "Shovel", "Hatchet", "Mattock", "Hammer", "Excavator", "Lumber Axe", "Scythe");
        toolComboBox.setOnAction(event -> handleToolSelection(toolComboBox.getValue()));
        calculateButton.setOnAction(event -> {
            errorLabel.setVisible(false);
            try{
                calculateToolStats();
                addToComparisonButton.setVisible(true);
                addToComparisonButton.setDisable(false);
            }
            catch (Exception e){
                displayError(e.getMessage());
                System.out.println(e.getMessage());
            }

        });
        compareButton.setDisable(true);
        compareButton.setText("Compare (" + toolsToCompare.size() + ")");
        compareButton.setOnAction(event -> {
            if(recreateComparison){
                makeToolComparison();
                recreateComparison = false;
            }
            comparisonPane.setVisible(true);
        });
        addToComparisonButton.setVisible(false);
        addToComparisonButton.setOnAction(event -> {
           try{
               addToComparison(tool);
               addToComparisonButton.setDisable(true);
               compareButton.setDisable(toolsToCompare.size() != 2);
               recreateComparison = true;
           }
           catch (Exception e){
               displayError(e.getMessage());
               System.out.println(e.getMessage());
           }
        });
        exitButton.setCancelButton(true);
        exitButton.setOnAction(event -> comparisonPane.setVisible(false));
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
            displayToolAbilities();
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
        toolStatsVBox.getChildren().clear();
        toolStatsVBox.getChildren().addAll(makeToolStats(tool));
    }

    private void displayToolAbilities(){
        toolAbilitiesVBox.getChildren().clear();
        toolAbilitiesVBox.getChildren().addAll(makeToolAbilities(tool));
    }
    
    private Text createAbilityBox(Ability ability){
        Text abilityBox = new Text(ability.getName() + " - " + ability.getDescription());
        abilityBox.setWrappingWidth(500);
        abilityBox.setStyle("-fx-fill: " + ability.getColor());
        abilityBox.setFont(new Font(18));
        abilityBox.setStroke(Color.BLACK);
        abilityBox.setStrokeWidth(0.3);
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

    private void addToComparison(Tool tool) throws Exception {
        if(tool == null){
            throw new Exception("Select 2 tools to compare");
        }
        if(toolsToCompare.size() == TOOL_COMPARISON_CAP){
            toolsToCompare.remove();
        }
        toolsToCompare.add(tool);
        compareButton.setText("Compare (" + toolsToCompare.size() + ")");
        System.out.println(toolsToCompare);
    }

    private void makeToolComparison() {
        comparisonPaneVBox.getChildren().clear();
        for(Tool tool: toolsToCompare){
            HBox toolDisplay = new HBox();
            VBox toolStats = new VBox();
            toolStats.getChildren().addAll(makeToolStats(tool));
            VBox toolAbilities = new VBox();
            toolAbilities.getStyleClass().add("tool-abilities-box");
            toolAbilities.getChildren().addAll(makeToolAbilities(tool));
            toolDisplay.getChildren().addAll(toolStats, toolAbilities);
            comparisonPaneVBox.getChildren().add(toolDisplay);
        }
    }

    private void displayError(String text){
        errorLabel.setVisible(true);
        errorLabel.setText(text);
    }

    private Text makeText(String text, int fontSize, boolean bold){
        Text newText = new Text(text);
        if (bold) {
            newText.setFont(Font.font("System", FontWeight.BOLD, fontSize));
        } else {
            newText.setFont(new Font(fontSize));
        }
        return newText;
    }

    private List<Text> makeToolStats(Tool tool){
        Text toolName = makeText(tool.toString(), 18, true);
        Text toolParts = makeText(tool.getPartsString(), 16, true);
        Text toolStats = makeText(tool.getStatsString(), 16, false);
        return List.of(toolName, toolParts, toolStats);
    }

    private List<Text> makeToolAbilities(Tool tool){
        List<Text> toolAbilities = new ArrayList<>();
        for(Ability ability: tool.getAbilities()){
            toolAbilities.add(createAbilityBox(ability));
        }
        return toolAbilities;
    }
}
