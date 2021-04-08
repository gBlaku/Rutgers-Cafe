package application;
/**
 * This interface allows us to add and remove Objects, like add-ins to Coffee or donuts to order.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public interface Customizable {
	boolean add(Object obj);
	boolean remove(Object obj);
}
