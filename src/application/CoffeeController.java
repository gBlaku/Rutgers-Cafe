package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
/**
 * This class is a Controller for the Coffee menu and allows users to add Coffee to their order.
 * @author Abdullah Salem, Gent Blaku
 *
 */

public class CoffeeController {
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
	
	Coffee myCoffee;
	
	@FXML
	private CheckBox Cream;
	@FXML
	private CheckBox Syrup;
	@FXML
	private CheckBox Milk;
	@FXML
	private CheckBox Caramel;
	@FXML
	private CheckBox WhippedCream;
	@FXML
	private TextField RunningTotal;
	@FXML
	private ComboBox<String> CoffeeSize;
	@FXML
	private ComboBox<Integer> NumberOfCoffee;
	@FXML
	private Button AddToOrderButton;
	
	
	/**
	 * This method initializes the scene as well as some default options for the user
	 */
	@FXML
	private void initialize() {
		myCoffee = new Coffee();
		myCoffee.setSize(ONE);
		
		CoffeeSize.getItems().addAll("Short" , "Tall", "Grande" , "Venti");
		NumberOfCoffee.getItems().addAll( ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE);
		update();
	}
	/**
	 * This helper method updates the current page to match any changes made by the user.
	 */
	@FXML
	private void update() {
		
		double total = myCoffee.itemPrice();
		RunningTotal.setText(myCoffee.formatPrice(total));
	}
	
	/**
	 * This function is called when the Cream option is selected, it adds Cream to the Coffee Object.
	 * @param e event checking the box.
	 */
	@FXML
	private void handleCream(ActionEvent e){
		if (Cream.isSelected()) 
			myCoffee.add("Cream");
			
        else
            myCoffee.remove("Cream");
		update();
    }
	/**
	 * This function is called when the Syrup option is selected, it adds Syrup to the Coffee Object.
	 * @param e event checking the box.
	 */
	@FXML
	private void handleSyrup(ActionEvent e){
		if (Syrup.isSelected()) 
			myCoffee.add("Syrup");
			
        else
            myCoffee.remove("Syrup");
		update();
    }
	/**
	 * This function is called when the Milk option is selected, it adds Milk to the Coffee Object.
	 * @param e event checking the box.
	 */
	@FXML
	private void handleMilk(ActionEvent e){
		if (Milk.isSelected()) 
			myCoffee.add("Milk");
			
        else
            myCoffee.remove("Milk");
		update();
    }
	/**
	 * This function is called when the Caramel option is selected, it adds Caramel to the Coffee Object.
	 * @param e event checking the box.
	 */
	@FXML
	private void handleCaramel(ActionEvent e){
		if (Caramel.isSelected()) 
			myCoffee.add("Caramel");
			
        else
            myCoffee.remove("Caramel");
		update();
    }
	/**
	 * This function is called when the Whipped Cream option is selected, it adds Whipped Cream to the Coffee Object.
	 * @param e event checking the box.
	 */
	@FXML
	private void handleWhippedCream(ActionEvent e){
		if (WhippedCream.isSelected()) 
			myCoffee.add("Whipped Cream");
			
        else
            myCoffee.remove("Whipped Cream");
		update();
    }
	/**
	 * This function is called when the Coffee size is selected, it adds the size to the Coffee object.
	 * @param e event of picking the size e.g Venti, Grande
	 */
	@FXML 
	private void handleSize(ActionEvent e) {
		String size = CoffeeSize.getValue();
		
		if (size.equals("Short")) {
			myCoffee.setSize(ONE);
		}
		else if (size.equals("Tall")) {
			myCoffee.setSize(TWO);
		}
		else if (size.equals("Grande")) {
			myCoffee.setSize(THREE);
		}
		else if (size.equals("Venti")) {
			myCoffee.setSize(FOUR);
		}
		update();
		//RunningTotal.setText(myCoffee.toString());
	}
	/**
	 * This function is called when the quantity of Coffee is selected it adds the quantity to the Coffee object.
	 * @param e event of picking the quantity e.g 1, 2
	 */
	@FXML
	private void handleQuantity(ActionEvent e) {
		Integer quantity = NumberOfCoffee.getValue();
		myCoffee.setQuantity(quantity);
		update();
		//RunningTotal.setText(""+myCoffee.getQuantity());
	}
	/**
	 * This function is called when user clicks Add to Order, it adds a Coffee Object to the current Order
	 * @param e event of clicking the add to order button
	 */
	@FXML
	private void addToOrder(ActionEvent e) {
		
		Alert confirmation = new Alert(AlertType.INFORMATION);
		confirmation.setTitle("Confirmation");
		confirmation.setHeaderText("Confirmation");
		confirmation.setContentText("Coffee has been added to Order");
		confirmation.show();
		
		//RunningTotal.setText("gent1");
		MMController.myOrder.add(myCoffee);
		Cream.setSelected(false); 
		Milk.setSelected(false);
		Caramel.setSelected(false);
		WhippedCream.setSelected(false);
		Syrup.setSelected(false);
		
		myCoffee = new Coffee();
	
		String size = CoffeeSize.getValue();
		if(size == null) {
			myCoffee.setSize(ONE);
		}
		else if (size.equals("Short")) {
			myCoffee.setSize(ONE);
		}
		else if (size.equals("Tall")) {
			myCoffee.setSize(TWO);
		}
		else if (size.equals("Grande")) {
			myCoffee.setSize(THREE);
		}
		else if (size.equals("Venti")) {
			myCoffee.setSize(FOUR);
		}
		
		NumberOfCoffee.setValue(ONE);
		myCoffee.setQuantity(ONE);
		update();
	}

	
	
	
	
}
