import java.util.Arrays;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = {12, 2, 6, 1, 5, 4, 3, 8, 5, 3, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int needInsert = arr[i];

            int j = i;
            while (j > 0 && needInsert < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = needInsert;
        }
    }
}