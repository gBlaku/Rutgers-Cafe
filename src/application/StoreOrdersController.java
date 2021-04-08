package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javafx.scene.control.ComboBox;

/**
 * A controller class that provides the functionality to manage multiple orders
 * This is the controller class of the "Store orders page.fxml" Window.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class StoreOrdersController {
	private static final int ONE = 1;
	
	@FXML
	private TextArea TextArea;
	@FXML
	private Button CancelOrderButton;
	@FXML
	private Button ExportButton;
	@FXML
	private TextField TotalBox;
	@FXML
	private ComboBox<Integer> OrderNumberBoxs;
	
	/**
	 * This function is called automatically. It gives the combo box it's options.
	 */
	@FXML
	private void initialize () {
		for (int x =0; x < MMController.myStore.getSize(); x++) {
			this.OrderNumberBoxs.getItems().add(x+1);
		}
		if (OrderNumberBoxs.getItems().isEmpty()) {
			return;
		}
		this.OrderNumberBoxs.setValue(ONE);
		
		this.update();
	}
	
	/**
	 * This is a helper function that is called several times through out the class. It changes the page to match any changes made by the user.
	 */
	private void update() {
		if (OrderNumberBoxs.getItems().isEmpty()) {
			return;
		}
		int num = this.OrderNumberBoxs.getValue() - 1;
		
		this.TextArea.setText(MMController.myStore.getOrder(num).toString());
		this.TotalBox.setText(MMController.myStore.getOrder(num).getTotal());
		
	}
	
	/**
	 * This function is called when the cancel order button is clicked. It removes the selected order from the list.
	 */
	@FXML
	private void cancelThisOrder() {
		try {
		int num = this.OrderNumberBoxs.getValue() - 1;
		this.OrderNumberBoxs.getItems().remove(MMController.myStore.getSize()-ONE);
		MMController.myStore.remove(MMController.myStore.getOrder(num));
		
		
		if (this.OrderNumberBoxs.getItems().isEmpty()) {
			this.TextArea.clear();
			this.TotalBox.clear();
		}
		
		this.update();
		}
		catch (Exception e) {
			
		}
	}
	
	/**
	 * Switching through the combo box calls this function. It calls the update helper function to dynamically shows the order on the textbox.
	 * @param e, A generic action that is checked 
	 */
	@FXML 
	private void handleOrder(ActionEvent e) {
		this.update();
	}
	
	/**
	 * Clicking the export button calls this function. It exports all the orders into a txt file
	 * @param e, A generic action that is checked 
	 */
	@FXML
	private void exportOrder(ActionEvent e) {
		if (MMController.myStore.getSize() <= 0){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setContentText("You have no orders");
			alert.show();
			return;
		}
		MMController.myStore.exportDatabase();
	}
	
	
	
}
