import java.util.Arrays;
import java.util.Scanner;

public class FindMinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];

        System.out.println("Enter element arr");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number at " + i + " : ");
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];

        for (int item : arr) {
            if (item <= min) {
                min = item;
            }
        }

        System.out.print("Max in array " + Arrays.toString(arr) + " is " + min);
    }
}
