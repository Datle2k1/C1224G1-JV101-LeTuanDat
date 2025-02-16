import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch;

        int[] arr = new int[100000];
        for (int i = 99999; i >= 0; i--) {
            arr[arr.length - 1 - i] = i;
        }

        stopWatch = new StopWatch();
        for (int i = 0; i < 100000; i++) {
            int index = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= arr[i]) {
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        stopWatch.stop();

        System.out.println("Selection sort arr : " + Arrays.toString(arr));
        System.out.println("Selection sort time : " + stopWatch.getElapsedTime());
    }
}