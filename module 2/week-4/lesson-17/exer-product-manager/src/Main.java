import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final static String path = "src/products.txt";

    private static void addProduct(Product product) {
        ArrayList<Product> products = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Object data = ois.readObject();
            products.addAll((List<Product>) data);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            products.add(product);
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Object searchProduct(String key) {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            List<Product> products = (List<Product>) ois.readObject();
            return products.stream().filter(product -> product.getName().equalsIgnoreCase(key.trim())).collect(Collectors.toList());
        } catch (IOException | ClassNotFoundException e) {
            return e;
        }
    }

    private static void displayProducts() {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            List<Product> products = (List<Product>) ois.readObject();
            for (Product product: products) {
                System.out.println(product.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert data");
        addProduct(new Product(1, "Product 1", 10000, "Publisher 1", "Description 1"));
        addProduct(new Product(2, "Product 2", 20000, "Publisher 2", "Description 2"));
        addProduct(new Product(3, "Product 3", 30000, "Publisher 3", "Description 3"));
        addProduct(new Product(4, "Product 4", 40000, "Publisher 4", "Description 4"));
        addProduct(new Product(5, "Product 5", 50000, "Publisher 5", "Description 5"));

        System.out.print("\nEnter key to search: ");
        String key = scanner.nextLine();
        Object data = searchProduct(key);
        for (Product product : (List<Product>) data) {
            System.out.println(product.toString());
        }

        System.out.println("\nAll Product");
        displayProducts();
    }
}