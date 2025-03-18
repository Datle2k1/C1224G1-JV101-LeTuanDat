import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Manager manager;

    static {
        manager = new Manager();
    }

    private static void menu() {
        System.out.println("\n============> CHỨC NĂNG <============");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách");
        System.out.println("4. Tìm kiếm giáo viên");
        System.out.println("5. Tìm kiếm học sinh");
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
                    manager.add();
                    break;
                case "2":
                    try {
                        manager.remove();
                    } catch (NotFoundStudentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "3":
                    manager.display();
                    break;
                case "4":
                    manager.searchTeacher();
                    break;
                case "5":
                    manager.searchStudent();
            }
        } while (!choose.equals("0"));
        System.out.println("End Program");
    }
}