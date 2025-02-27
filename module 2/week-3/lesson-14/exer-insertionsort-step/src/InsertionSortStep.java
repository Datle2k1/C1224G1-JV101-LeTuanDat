import java.util.Arrays;

public class InsertionSortStep {
    public static void main(String[] args) {
        int[] arr = {12, 2, 6, 1, 5, 4, 3, 8, 5, 3, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int needInsert = arr[i];
            System.out.println("\nPhần tử cần chèn : " + needInsert + ", vị trí ban đầu : " + i);

            int j = i;
            System.out.println("Kiểm tra các phần tử trước vị trí " + i);
            while (j > 0 && needInsert < arr[j - 1]) {
                arr[j] = arr[j - 1];
                System.out.println("Dịch chuyển phần tử " + arr[j-1] + " sang phải");
                j--;
                System.out.println("Cập nhật vị trí cần chèn : " + j);
            }

            arr[j] = needInsert;
            System.out.println("Chèn " + needInsert + " vào vị trí " + j);
            System.out.println(Arrays.toString(arr));
        }
    }
}