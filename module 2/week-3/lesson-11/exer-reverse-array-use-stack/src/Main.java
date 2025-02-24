import java.util.Arrays;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("reverse - array integer");
        Stack<Integer> stack1 = new Stack<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));

        for (int i: arr) {
            stack1.push(i);
        }

        int i = 0;
        while (!stack1.isEmpty()) {
            arr[i++] = stack1.pop();
        }

        System.out.println(Arrays.toString(arr));

        System.out.println("\nreverse - string");
        Stack<String> stack2 = new Stack<>();
        StringBuilder str = new StringBuilder("Code Gym");
        System.out.println(str);

        String[] arrStr = str.toString().split("");
        for (String s: arrStr) {
            stack2.push(s);
        }

        str = new StringBuilder();
        while (!stack2.isEmpty()) {
            str.append(stack2.pop());
        }
        System.out.println(str);
    }
}