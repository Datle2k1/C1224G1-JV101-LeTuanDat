import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[8];
        int i = 0;

        while (i < arr.length) {
            System.out.print("Enter number at " + i + " : ");
            arr[i] = scanner.nextInt();
            i++;
        }

        System.out.print("Enter number want to delete : ");
        int numDelete = scanner.nextInt();
        int index = -1;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == numDelete) {
                index = j;
            }
        }

        if (index != -1) {
            for (int j = index; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = 0;
            System.out.print("Array after delete element :" + Arrays.toString(arr) + ".");
        } else {
            System.out.print("Array not contain element " + numDelete + ".");
        }
    }
}
