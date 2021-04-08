package application;

import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * This Controller class is for the current order menu
 * and allows for storing and manipulation of the user's order of Coffee and/or Donuts.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class CurrentOrderController {
	
	
	
	
	
	@FXML
	private ListView<String> TextArea;
	@FXML
	private TextField SubTotalBox;
	@FXML
	private TextField TaxBox;
	@FXML
	private TextField TotalBox;
	@FXML
	private Button RemoveSelectedButton;
	@FXML
	private Button PlaceOrderButton;
	
	
	
	
	/**
	 * This method initializes the scene for the current order.
	 */
	@FXML
	private void initialize() {
		update();
	}
	
	
	
	
	/**
	 * This helper method updates the current page to match any changes made by the user.
	 */
	@FXML
	private void update() {
		MMController.myOrder.calculatePayment();
		this.TextArea.getItems().clear();
		StringTokenizer tokens = new StringTokenizer(MMController.myOrder.toString() + "\n" , "\n");
		while (tokens.hasMoreTokens()) {
			this.TextArea.getItems().add(tokens.nextToken());
		}
		
		SubTotalBox.setText(""+MMController.myOrder.getSubtotal());
		TaxBox.setText(""+MMController.myOrder.getSalesTax());	
		TotalBox.setText(""+MMController.myOrder.getTotal());	
	}
	
	
	
	
	
	/**
	 * This method removes an Object from the current order
	 */
	@FXML
	private void removeItem() {
		String badItem = this.TextArea.getSelectionModel().getSelectedItem();
		MMController.myOrder.remove(badItem);
		update();
	}
	
	
	
	
	/**
	 * This method adds the current order to store orders and is triggered when the user clicks the Place Order button.
	 */
	@FXML
	private void placeMyOrder() {
		if (MMController.myOrder.isEmpty()) {
			Alert confirmation = new Alert(AlertType.WARNING);
			confirmation.setTitle("WARNING!");
			confirmation.setHeaderText("Warning");
			confirmation.setContentText("You have an empty order. Please select some donuts and coffee :)");
			confirmation.show();
			return;
		}
		
		
		
		if (MMController.myOrder != null) {
			
			
			Alert confirmation = new Alert(AlertType.INFORMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Confirmation");
			confirmation.setContentText("Order has been placed");
			confirmation.show();
			
			
			
			MMController.myStore.add(MMController.myOrder);
			MMController.myOrder = new Order();
			
			
			
		}
		update();
		Stage stage = (Stage) this.PlaceOrderButton.getScene().getWindow();     // do what you have to do     
		stage.close();
	}
	
	
}
