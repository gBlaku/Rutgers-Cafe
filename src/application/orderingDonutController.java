package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

import javafx.scene.control.ComboBox;


/**
 * This controller class provides the functionality for ordering donuts.
 * This is the controller class of the "Ordering Donuts.fxml" Window.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class orderingDonutController {
	public final static int ZERO = 0;
	public final static int ONE = 1;
	public final static int TWO = 2;
	public final static int THREE = 3;
	public final static int FOUR = 4;
	public final static int FIVE = 5;
	public final static int SIX = 6;
	public final static int SEVEN = 7;
	public final static int EIGHT = 8;
	public final static int NINE = 9;
	public final static int TEN = 10;
	public final static int ELEVEN = 11;
	public final static int TWELVE = 12;

	private ArrayList<Donut> myDonuts;
	
	@FXML
	private ComboBox<String> donutTypeComboBox;
	@FXML
	private ListView<String> listDonutFlavor;
	@FXML
	private ComboBox<Integer> numDonutComboBox;
	@FXML
	private Button addDonutButton;
	@FXML
	private Button removeDonutButton;
	@FXML
	private ListView<String> donutOrderTextArea;
	@FXML
	private TextField runningTotalDonut;
	@FXML
	private Button addToOrderDonutButton;

	/**
	 * This function is called automatically. It gives the combo box it's options.
	 */
	@FXML
	private void initialize() {
		this.myDonuts = new ArrayList<Donut>();
		this.donutTypeComboBox.getItems().addAll("Yeast" , "Donut Hole", "Cake Donut");
		this.numDonutComboBox.getItems().addAll(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE);
		
		this.numDonutComboBox.setValue(ONE);
		this.donutTypeComboBox.setValue("Yeast");
		this.pickedType();
		this.listDonutFlavor.getSelectionModel().select(ZERO);
	}
	
	/**
	 * This is a helper function that is called several times through out the class. It changes the page to match any changes made by the user.
	 */
	@FXML
	private void update() {
		this.donutOrderTextArea.getItems().clear();
		
		double subtotal = 0;
		
		for (int x = 0; x < this.myDonuts.size(); x++) {
			this.donutOrderTextArea.getItems().add(this.myDonuts.get(x).toString());
			subtotal += this.myDonuts.get(x).itemPrice();
		}
		
		MenuItem formatter = new MenuItem();
		
		this.runningTotalDonut.setText(formatter.formatPrice(subtotal));
	}
	
	/**
	 * This function is called when the combobox is interacted with and updates the selection to reflect what is available for the current donut type.
	 */
	@FXML
	private void pickedType() {
		if (donutTypeComboBox.getValue() == "Yeast") {
			listDonutFlavor.getItems().clear();
			listDonutFlavor.getItems().addAll("Jelly Filled", "Boston Kreme", "Strawberry Lemon Swirl");
		}
		else if (donutTypeComboBox.getValue() == "Donut Hole") {
			listDonutFlavor.getItems().clear();
			listDonutFlavor.getItems().addAll("Choco-Loco", "Glazed", "Berry Beautiful");
		}
		else if (donutTypeComboBox.getValue() == "Cake Donut") {
			listDonutFlavor.getItems().clear();
			listDonutFlavor.getItems().addAll("Maple Frosted", "Blueberry Cake", "Ice Cream Cake");
		}
		

		this.listDonutFlavor.getSelectionModel().select(ZERO);
		this.update();
		
	}
	
	/**
	 * This function takes a selected item of a specific type and flavor into the list
	 */
	@FXML
	private void addToList() {
		String typeS = this.donutTypeComboBox.getValue();
		int type = 0;
		if (typeS.equals("Yeast")){
			type = ONE;
		}
		else if (typeS.equals("Cake Donut")) {
			type = TWO;
		}
		else if (typeS.equals("Donut Hole")){
			type = THREE;
		}
		int flavor = this.listDonutFlavor.getSelectionModel().getSelectedIndex();
		int quantity = this.numDonutComboBox.getValue();
		Donut myDonut = new Donut(quantity, type, flavor+ONE);
		
		this.myDonuts.add(myDonut);
		update();
	}
	

	/**
	 * This methods removes a selected item from the list.
	 */
	@FXML
	private void removeFromList() {
		try {
			int badDonut = this.donutOrderTextArea.getSelectionModel().getSelectedIndex();
			this.myDonuts.remove(badDonut);
			this.update();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Please select something to remove");
			alert.show();
		}
	}
	
	/**
	 * This method adds the selected items to the order.
	 */
	@FXML
	private void addToOrder() {
		if (myDonuts.isEmpty()) {
			Alert confirmation = new Alert(AlertType.WARNING);
			confirmation.setTitle("WARNING!");
			confirmation.setHeaderText("Warning");
			confirmation.setContentText("Please pick a donut!");
			confirmation.show();
			return;
		}
		
		
		Alert confirmation = new Alert(AlertType.INFORMATION);
		confirmation.setTitle("Confirmation");
		confirmation.setHeaderText("Confirmation");
		confirmation.setContentText("Donut(s) have been added to Order");
		confirmation.show();
		
		
		for (int x = 0; x < this.myDonuts.size(); x++) {
			MMController.myOrder.add(this.myDonuts.get(x));
		}
		this.myDonuts = new ArrayList<Donut>();
		this.update();
	}
}
