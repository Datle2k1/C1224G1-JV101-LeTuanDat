import java.util.Arrays;
import java.util.Scanner;

public class SumMainCross {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("Enter element at [" + i + "," + j + "] : ");
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.print("Sum main cross of array : " + Arrays.deepToString(arr) + " is : " + sum);
    }
}
