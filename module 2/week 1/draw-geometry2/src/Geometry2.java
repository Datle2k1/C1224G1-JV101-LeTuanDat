import java.util.Scanner;

public class Geometry2 {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter width: ");
                    int width = scanner.nextInt();
                    System.out.print("Enter height: ");
                    int height = scanner.nextInt();
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.print("Enter left: ");
                    int edge = scanner.nextInt();
                    System.out.println("Draw the square triangle");
                    System.out.println("Square: bottom - left");
                    for (int i = 0; i < edge; i++) {
                        for (int j = 0; j < edge; j++) {
                            if (j <= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }

                    System.out.println("Square: bottom - right");
                    for (int i = 0; i < edge; i++) {
                        for (int j = 0; j < edge; j++) {
                            if (j >= edge - 1 - i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }

                    System.out.println("Square: top - left");
                    for (int i = 0; i < edge; i++) {
                        for (int j = 0; j < edge; j++) {
                            if (j <= edge - 1 - i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }

                    System.out.println("Square: top - right");
                    for (int i = 0; i < edge; i++) {
                        for (int j = 0; j < edge; j++) {
                            if (j >= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter edge bottom (odd number): ");
                    int edgeBottom = scanner.nextInt();
                    System.out.println("Draw the isosceles triangle");

                    int center = edgeBottom/2;
                    for (int i = 0; i < edgeBottom/2; i++) {
                        for (int j = 0; j < edgeBottom; j++) {
                            if (j >= center - i && j <= center + i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print("\n");

                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}