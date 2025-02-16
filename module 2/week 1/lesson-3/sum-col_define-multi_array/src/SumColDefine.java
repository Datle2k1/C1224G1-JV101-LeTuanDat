import java.util.Arrays;
import java.util.Scanner;

public class SumColDefine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("Enter element at [" + i + "," + j + "] : ");
                arr[i][j] = scanner.nextInt();
            }
        }

        while (true) {
            System.out.print("Enter colume you want to sum :");
            int col = scanner.nextInt();

            if (col < 0 || col > arr[0].length - 1) {
                System.out.print("Invalid Column\n");
                continue;
            }

            int sum = 0;
            for (int[] row : arr) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (j == col) {
                        sum += row[j];
                    }
                }
            }

            System.out.print("Sum at column " + col + "array : " + Arrays.deepToString(arr) + " is : " + sum);
            break;
        }
    }
}
