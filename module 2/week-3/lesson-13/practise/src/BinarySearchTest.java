
public class BinarySearchTest {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int center = 0;
        int end = arr.length - 1;

        while (end >= start) {
            center = start + (end - start) / 2;

            if (arr[center] < target) {
                start = center + 1;
            } else if (arr[center] > target){
                end = center - 1;
            } else {
                return center;
            }

            if (end < start) {
                break;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int search = 79;
        int result = binarySearch(arr, search);
        System.out.println(result == -1 ? "Not found" : search + " at " + result);
    }
}