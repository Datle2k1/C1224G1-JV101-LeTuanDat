import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        double a = scanner.nextDouble();
        System.out.print("Enter b : ");
        double b = scanner.nextDouble();
        System.out.print("Enter c : ");
        double c = scanner.nextDouble();

        QuadraticEquation object = new QuadraticEquation(a,b,c);
        double root1 = object.getRoot1();
        double root2 = object.getRoot2();

        if (root1 == 0.0 || root2 == 0.0) {
            System.out.println("The equation has no roots");
        } else if (root1 == root2) {
            System.out.println("The equation has one roots is " + root1);
        } else {
            System.out.println("The equation has two roots is " + root1 + " , " + root2);
        }
    }
}