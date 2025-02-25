package arraylist;

import product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager implements Comparator<Product> {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> products;
    private boolean isIncrease = false;

    ProductManager() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        System.out.println("\nAdd product name " + product.getName());
        products.add(product);
    }

    public void edit(int id) {
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
            }
        }

        if (product == null) System.out.println("Không tồn tại sản phẩm với id : " + id);
        else {
            System.out.println("\nEdit product with id " + id);
            System.out.print("Edit name : ");
            product.setName(scanner.nextLine());
            System.out.print("Edit value : ");
            product.setValue(scanner.nextInt());
        }
    }

    public void delete(int id) {
        System.out.println("\nDelete product wirh id " + id);
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
            }
        }

        if (product == null) System.out.println("Không tồn tại sản phẩm");
        else products.remove(product);
    }

    public void display() {
        System.out.println("\nDisplay");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void search(String name) {
        System.out.println("\nSearch with key: " + name);
        for (Product product : products) {
            if (product.getName().trim().contains(name.trim())) {
                System.out.println(product.toString());
            }
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean isIncrease() {
        return isIncrease;
    }

    public void setIncrease(boolean increase) {
        this.isIncrease = increase;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return this.isIncrease ? Integer.compare(o1.getValue(), o2.getValue())
                    : Integer.compare(o2.getValue(), o1.getValue());
    }
}