import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter money : ");
        double money = scanner.nextDouble();
        System.out.print("Enter month : ");
        int month = scanner.nextInt();
        System.out.print("Enter rate / year : ");
        double rate = scanner.nextDouble();

        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * ((rate/100)/12)*month;
        }

        System.out.print("Total of Interest : " + totalInterest);
    }
}
