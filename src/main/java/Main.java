import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_view.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        URL styles = getClass().getResource("/css/styles.css");
        if (styles != null) scene.getStylesheets().add(styles.toExternalForm());
        else System.err.println("Could not load CSS file!");
        primaryStage.setTitle("Tinker's Construct Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
