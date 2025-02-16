public class PrimeLessThan100 {
    public static void main(String[] args) {
        int number = 2;

        while (number < 100) {
            int start = 2;
            boolean check = true;
            while (start <= Math.sqrt(number)) {
                if (number % start == 0) {
                    check = false;
                    break;
                }
                start ++;
            }

            if (check) {
                System.out.print(number + ", ");
            }
            number ++;
        }
    }
}
