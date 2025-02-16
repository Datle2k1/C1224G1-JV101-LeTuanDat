import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[8];
        int[] newArr = new int[9];
        int i = 0;

        while (i < arr.length) {
            System.out.print("Enter number at " + i + " : ");
            arr[i] = scanner.nextInt();
            i++;
        }

        while (true) {
            System.out.print("Enter number want to add : ");
            int numAdd = scanner.nextInt();
            System.out.print("Enter position want to add : ");
            int index = scanner.nextInt();

            if (index <= -1 || index > arr.length - 1) {
                System.out.println("Invalid Position");
                continue;
            }


            for (int j = 0; j < newArr.length; j++) {
                if (j < index) {
                    newArr[j] = arr[j];
                } else if (j == index) {
                    newArr[j] = numAdd;
                } else {
                    newArr[j] = arr[j - 1];
                }
            }

            System.out.print("Array after add element :" + Arrays.toString(newArr) + ".");
            break;
        }
    }
}
