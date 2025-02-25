import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.add(new Product(1, "Product 1", 3000));
        productManager.add(new Product(2, "Product 2", 2000));
        productManager.add(new Product(3, "Product 3", 4000));
        productManager.add(new Product(4, "Product 4", 1000));
        productManager.add(new Product(5, "Product 5", 1000));
        productManager.display();

//        productManager.edit(3);
//        productManager.display();

        productManager.delete(5);
        productManager.display();

        productManager.search("Product");

        System.out.println("\nSort follow value increase");
        productManager.setIncrease(true);
        productManager.getProducts().sort(productManager);
        productManager.display();

        System.out.println("\nSort follow value decrease");
        productManager.setIncrease(false);
        productManager.getProducts().sort(productManager);
        productManager.display();
    }
}
