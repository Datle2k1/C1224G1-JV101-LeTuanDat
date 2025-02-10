import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number <= 3 digit :");
        int number = scanner.nextInt();

        int firstNumber = number / 100;
        int secondNumber = (number - firstNumber * 100) / 10;
        int thirdNumber = number - firstNumber * 100 - secondNumber * 10;

        String result = readNumber(firstNumber) + " hundred and ";
        result += readNumber(secondNumber);
        result += readNumber(thirdNumber);

        System.out.println("Read number " + number + " : " + result);
    }

    public static String readNumber(int number) {
        switch (number) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Siv";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }
}