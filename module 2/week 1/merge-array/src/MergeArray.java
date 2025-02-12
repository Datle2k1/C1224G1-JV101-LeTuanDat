import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr1 = new int[4];
        int[] arr2 = new int[5];
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;

        System.out.println("Enter element arr 1");
        while (i < arr1.length) {
            System.out.print("Enter number at " + i + " : ");
            arr1[i] = scanner.nextInt();
            i++;
        }

        i = 0;
        System.out.println("Enter element arr 2");
        while (i < arr2.length) {
            System.out.print("Enter number at " + i + " : ");
            arr2[i] = scanner.nextInt();
            i++;
        }

        for (int j = 0; j < arr3.length; j++) {
            if (j <= arr1.length - 1) {
                arr3[j] = arr1[j];
            } else {
                arr3[j] = arr2[j - arr1.length];
            }
        }

        System.out.print("Array merged : " + Arrays.toString(arr3));
    }
}
