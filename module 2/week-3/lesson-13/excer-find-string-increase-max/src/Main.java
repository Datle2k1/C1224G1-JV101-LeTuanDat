import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static StringBuilder findStringIncreaseMax(String str) {
        char[] arr = str.toCharArray();
        StringBuilder result = new StringBuilder();
        result.append(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if ((int) arr[i] <= (int) arr[i + 1]) {
                result.append(arr[i + 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print("Enter string : ");
        String str = scanner.nextLine();
        StringBuilder result = findStringIncreaseMax(str);
        System.out.println("String increase, Max length : " + result);
    }
}