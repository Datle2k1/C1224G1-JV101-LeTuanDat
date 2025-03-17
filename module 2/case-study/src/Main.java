import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactManager manager;

    static {
        manager = new ContactManager();
    }

    private static void menu() {
        System.out.println("\n============> CHỨC NĂNG <============");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Sửa");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Sắp xếp");
        System.out.println("7. Ghi vào File");
        System.out.println("8. Đọc từ File");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng : ");
    }

    public static void main(String[] args) {
        System.out.println("Start Program");
        String choose = "";

        do {
            menu();
            choose = scanner.nextLine().trim();

            switch (choose) {
                case "1":
                    manager.display();
                    break;
                case "2":
                    manager.add();
                    break;
                case "3":
                    manager.edit();
                    break;
                case "4":
                    manager.remove();
                    break;
                case "5":
                    manager.search();
                    break;
                case "6":
                    manager.sort();
                    break;
                case "7":
                    manager.writeToCSV();
                    break;
                case "8":
                    manager.readFromCSV();
            }
        } while (!choose.equals("0"));
        System.out.println("End Program");
    }
}