package application;
/**
 * This class holds properties of the Donut object, such as type, flavor, quantity.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class Donut extends MenuItem {
	
	enum DonutTypes { YEASTDONUT, CAKEDONUT, DONUTHOLES} 
	
	enum YeastFlavors { JELLYFILLED, BOSTONKREME, STRAWBERRYLEMONSWIRL }
	
	enum CakeFlavors {	MAPLEFROSTED, BLUEBERRYCAKE, ICECREAMCAKE}
	
	enum HoleFlavors { CHOCOLOCO, GLAZED, BERRYBEAUTIFUL}
	
	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int YEAST = 1;
	private static final int CAKE = 2;
	private static final int HOLE = 3;
	private static final double YEASTPRICE= 1.39;
	private static final double CAKEPRICE= 1.59;
	private static final double HOLEPRICE= 0.33;

	private DonutTypes myType;
	private YeastFlavors myYFlav;
	private CakeFlavors myCFlav;
	private HoleFlavors myHFlav;
	
	/**
	 * This constructor initializes a Donut object with it's properties.
	 * @param number the number of donuts
	 * @param type the type of donut e.g. yeast
	 * @param flavor the donut flavor e.g. jelly filled
	 */
	public Donut(int number, int type, int flavor) {
		super();
		super.setQuantity(number);
		
		switch(type) 
		{
		case YEAST:
			super.setPrice(YEASTPRICE);
			this.myType = DonutTypes.YEASTDONUT;
			
			switch(flavor) 
			{
			case ONE:
				this.myYFlav = YeastFlavors.JELLYFILLED;
				break;
			case TWO:
				this.myYFlav = YeastFlavors.BOSTONKREME;
				break;
			case THREE:
				this.myYFlav = YeastFlavors.STRAWBERRYLEMONSWIRL;
				break;
			}
			
			break;
		case CAKE:
			super.setPrice(CAKEPRICE);
			this.myType = DonutTypes.CAKEDONUT;
			
			switch(flavor) 
			{
			case ONE:
				this.myCFlav = CakeFlavors.MAPLEFROSTED ;
				break;
			case TWO:
				this.myCFlav =CakeFlavors.BLUEBERRYCAKE;
				break;
			case THREE:
				this.myCFlav = CakeFlavors.ICECREAMCAKE;
				break;
			}
			
			break;
		case HOLE:
			super.setPrice(HOLEPRICE);
			this.myType = DonutTypes.DONUTHOLES;
			
			switch(flavor) 
			{
			case ONE:
				this.myHFlav = HoleFlavors.CHOCOLOCO;
				break;
			case TWO:
				this.myHFlav = HoleFlavors.GLAZED;
				break;
			case THREE:
				this.myHFlav = HoleFlavors.BERRYBEAUTIFUL;
				break;
			}
		
			break;
		}
	}
	
	/**
	 * This method fetches the price of a Donut object.
	 * @return a double, the price of a Donut object.
	 */
	public double itemPrice() {
		return super.getPrice() * super.getQuantity();
	}
	
	
	
	
	
	/**
	 * This method checks if two Donut objects are equal.
	 * @param obj Donut object to be checked against
	 * @return true if the objects are equal, false if not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut other = (Donut)obj;
			
			String shortOther = other.toString().substring(0,other.toString().length()-FIVE);
			String shortThis = this.toString().substring(0, this.toString().length()-FIVE);
			
			return shortOther.equals(shortThis);
		}
		
		
		return false;
	}
	
	
	
	
	/**
	 * This method returns a String representation of a Donut object.
	 * @return String representation of a Donut object.
	 */
	@Override
	public String toString() {
		String myDonut = "";
		
		if (this.myType == DonutTypes.YEASTDONUT) {
			if (this.myYFlav == YeastFlavors.JELLYFILLED) {
				myDonut = new String(myDonut + "jelly filled(");
			}
			else if (this.myYFlav == YeastFlavors.BOSTONKREME) {
				myDonut = new String(myDonut + "boston kreme(");
			}
			else if (this.myYFlav == YeastFlavors.STRAWBERRYLEMONSWIRL) {
				myDonut = new String(myDonut + "strawberry-lemon swirl(");
			}
		}
		else if (this.myType == DonutTypes.CAKEDONUT) {
			if (this.myCFlav == CakeFlavors.BLUEBERRYCAKE) {
				myDonut = new String(myDonut + "blueberry cake(");
			}
			else if (this.myCFlav == CakeFlavors.ICECREAMCAKE) {
				myDonut = new String(myDonut + "ice-creame cake(");
			}
			else if (this.myCFlav == CakeFlavors.MAPLEFROSTED) {
				myDonut = new String(myDonut + "maple frosted(");
			}
		}
		else if (this.myType == DonutTypes.DONUTHOLES) {
			if (this.myHFlav == HoleFlavors.BERRYBEAUTIFUL) {
				myDonut = new String(myDonut + "berry beautiful(");
			}
			else if (this.myHFlav == HoleFlavors.CHOCOLOCO) {
				myDonut = new String(myDonut + "choco loco(");
			}
			else if (this.myHFlav == HoleFlavors.GLAZED) {
				myDonut = new String(myDonut + "glazed(");
			}
		}
		
		myDonut = new String(myDonut + super.getQuantity() + ")");
		
		return myDonut;
	}
}
