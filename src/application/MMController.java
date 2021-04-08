package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * This class is the controller for the Main Menu and allows for data to be manipulated based on the user's actions
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class MMController {
	
	public static Order myOrder = new Order();
	public static StoreOrders myStore = new StoreOrders();
	
	/**
	 * This method initializes the main menu scene.
	 */
	@FXML
	public void initialize() {
		//myOrder = new Order();
	}
	
	@FXML
	private ImageView mmDonutImage;
	
	@FXML
	private ImageView YourOrderImage;
	
	@FXML
	private ImageView StoreOrders;

	// Event Listener on ImageView[#mmDonutImage].onMouseClicked
	/**
	 * This method opens the Donut menu. This is called when the Donut image is clicked.
	 * @param event clicking of the Donut image.
	 */
	@FXML
	public void openDonutPage(MouseEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering Donuts.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Donut Menu");
			stage.setScene(new Scene(root1));  
			stage.show();
		}
		catch (Exception e) {
		}
	}
	
	// Event Listener on ImageView[#mmCoffeeImage].onMouseClicked
	/**
	 * This method opens the Coffee menu. This is called when the Coffee image is clicked.
	 * @param event clicking of the Coffee image.
	 */
		@FXML
		public void openCoffeePage(MouseEvent event) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering Coffee.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Coffee Menu");
				stage.setScene(new Scene(root1));  
				stage.show();
			}
			catch (Exception e) {
			}
		}
		
		
		// Event Listener on ImageView[#mmYourOrdersImage].onMouseClicked
		/**
		 * This method opens the Order page. This is called when the Orders image is clicked.
		 * @param event clicking of the Orders image.
		 */
		@FXML
		public void openYourOrdersPage(MouseEvent event) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Current order detail.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Your Orders");
				stage.setScene(new Scene(root1));  
				stage.show();
			}
			catch (Exception e) {
			}
		}
		
		// Event Listener on ImageView[#mmStoreOrdersImage].onMouseClicked
		/**
		 * This method opens the Store Orders page. This is called when the Store Orders image is clicked.
		 * @param event clicking of the Store Orders image.
		 */
		@FXML
		public void openStoreOrdersPage(MouseEvent event) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Store orders page.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Store Orders");
				stage.setScene(new Scene(root1));  
				stage.show();
			}
			catch (Exception e) {
			}
		}
	
	
}
