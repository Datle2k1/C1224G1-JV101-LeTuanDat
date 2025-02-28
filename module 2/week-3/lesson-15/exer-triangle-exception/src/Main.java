import java.util.Scanner;

public class Main {

    public static void validateTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh của tam giác phải là số dương.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập cạnh thứ nhất: ");
            double a = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ hai: ");
            double b = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ ba: ");
            double c = scanner.nextDouble();

            validateTriangle(a, b, c);

            System.out.println("Ba cạnh nhập vào hợp lệ tạo thành một tam giác.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu: Vui lòng nhập số hợp lệ.");
        }
    }
}
