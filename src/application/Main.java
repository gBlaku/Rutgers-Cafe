package application;
	
import javafx.application.Application; 
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;




/**
 * This class serves as a driver for the GUI.
 * @author Abdullah Salem, Gent Blaku
 *
 */

public class Main extends Application {
	
	/**
	 * This method starts the GUI.
	 * @param primaryStage the main menu stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Main Menu");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Launches the Gui.
	 * @param args the stage
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
