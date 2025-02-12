import java.util.Arrays;
import java.util.Scanner;

public class FindMaxMultiArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[4][5];

        System.out.println("Enter element arr");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("Enter number at " + "[" + i + "," + j + "]"  + " : ");
                arr[i][j] = scanner.nextInt();
            }
        }
        int max = arr[0][0];

        for (int[] item : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if (item[j] >= max) {
                    max = item[j];
                }
            }
        }

        System.out.print("Max in array " + Arrays.deepToString(arr) + " is " + max);
    }
}
