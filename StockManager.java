import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(findProduct(item.getID()) !=  null){
            System.out.println("Error: El Artículo ya existe.");
        }
        else{
            stock.add(item);
        }
        
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product toDelivery = findProduct(id);
        
        if(toDelivery != null){
            toDelivery.increaseQuantity(amount);
        }
        else{
            System.out.println("Error: ID product don´t found");
        }
        
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product search = null;
        Product toReturn = null;
        boolean found = false;
        Iterator<Product> it = stock.iterator();
        
        while((found == false) && it.hasNext()){
            search = it.next();
            if(search.getID() == id){
                found = true;
                toReturn = search;
            }
        }
        
            
        return toReturn;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int quantityStock = -1;
            if(findProduct(id) != null){
                quantityStock = findProduct(id).getQuantity();
            }
        return quantityStock;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product : stock){
            System.out.println(product.toString());
        }
    }
    /**
     * Imprime por pantalla todos los detalles de los productos
     * cuyo stock está por encima de la cantidad indicada.
     */
    public void printProductDownStock(int numberStock){
        for(Product product : stock){
            if(product.getQuantity() < numberStock){
                System.out.println(product.toString());
            }
        }
    }
    
    
}
