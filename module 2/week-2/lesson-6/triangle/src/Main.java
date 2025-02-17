import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side1 :");
        float side1 = scanner.nextFloat();
        System.out.print("Enter side2 :");
        float side2 = scanner.nextFloat();
        System.out.print("Enter side3 :");
        float side3 = scanner.nextFloat();

        scanner.nextLine();

        System.out.print("Enter color :");
        String color = scanner.nextLine();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(true);

        System.out.println("\nColor of triangle : " + triangle.getColor());
        System.out.println("Area of triangle : " + triangle.getArea());
        System.out.println("Perimeter of triangle : " + triangle.getPerimeter());
    }
}