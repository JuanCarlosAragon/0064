
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    private StockManager stockmanager;
    public Test(){
        stockmanager = new StockManager();
        
    }
    public void recargarTienda(){
        Product producto1 = new Product(001, "mesa");
        Product producto2 = new Product(002, "silla");
        Product producto3 = new Product(003, "pisa papeles");
        
        stockmanager.addProduct(producto1);
        stockmanager.addProduct(producto2);
        stockmanager.addProduct(producto3);
    }
    
    public void testPrint(){
        stockmanager.printProductDetails();
    }
}
