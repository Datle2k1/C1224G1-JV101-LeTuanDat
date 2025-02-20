package org.example;

public class FizzBuzzTranslate {
    public static StringBuilder translate(int number) {
        if (number <= 0) {
            return new StringBuilder("" + -1);
        } else {
            if (number % 3 == 0 && number % 5 == 0) {
              return new StringBuilder("FizzBuzz");
            } else if (number % 3 == 0 || ("" + number).contains("3")) {
                return new StringBuilder("Fizz");
            } else if (number % 5 == 0 || ("" + number).contains("5")) {
                return new StringBuilder("Buzz");
            } else {
                return readResultByLetter(number);
            }
        }
    }

    private static StringBuilder readResultByLetter(int number) {
        StringBuilder result = new StringBuilder();
        int size = ("" + number).length() - 1;

        for (double i = Math.pow(10, size); i >= 1; i/=10) {
            int num = number / (int)i;
            read(num, result);
            number = number - num * (int)i;
            if (i != 1) result.append(" ");
        }
        return  result;
    }

    private static void read(int num, StringBuilder result) {
        switch (num) {
            case 1:
                result.append("mot");
                break;
            case 2:
                result.append("hai");
                break;
            case 3:
                result.append("ba");
                break;
            case 4:
                result.append("bon");
                break;
            case 6:
                result.append("sau");
                break;
            case 7:
                result.append("bay");
                break;
            case 8:
                result.append("tam");
                break;
            case 9:
                result.append("chin");
                break;
        }
    }
}
