import java.util.Arrays;

public class BubbleSortTest {

    public static void bubbleSort(int[] arr) {
        boolean isSwapped = true;
        int pass = 0;

        while (isSwapped) {
            isSwapped = false;
            for (int j = 0; j < arr.length - (pass + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }

            pass++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 6, 4, 2, 7, 5, 6, 4, 9, 7, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}