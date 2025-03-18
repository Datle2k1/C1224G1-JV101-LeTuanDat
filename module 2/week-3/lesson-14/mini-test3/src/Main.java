import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] list = {4,5,3,2,1,7,5,3,7};

        WorkerManager manager = new WorkerManager();

        manager.addWorker(new WorkerFullTime(1,"Name 1", 21, "0123456789", "name1@gmail.com", 1000L, 500L, 10000L));
        manager.addWorker(new WorkerPartTime(2,"Name 2", 22, "0123456789", "name2@gmail.com", 100));
        manager.addWorker(new WorkerFullTime(3,"Name 3", 23, "0123456789", "name3@gmail.com", 400L, 450L, 10000L));
        manager.addWorker(new WorkerPartTime(4,"Name 4", 24, "0123456789", "name4@gmail.com", 120));
        manager.addWorker(new WorkerPartTime(5,"Name 5", 25, "0123456789", "name5@gmail.com", 85));
        manager.addWorker(new WorkerFullTime(6,"Name 6", 26, "0123456789", "name6@gmail.com", 500L, 100L, 10000L));
        manager.addWorker(new WorkerFullTime(7,"Name 7", 27, "0123456789", "name7@gmail.com", 1100L, 0L, 10000L));
        manager.addWorker(new WorkerPartTime(8,"Name 8", 28, "0123456789", "name8@gmail.com", 90));

        System.out.println("Hiện thị các nhân viên : ");
        for (Worker worker: manager.getWorkers()) {
            System.out.println(worker.toString());
        }

        System.out.println("\nLương trung bình của cả công ty : " + manager.averageSalary());

        System.out.println("\nNhân viên fulltime có lương nhỏ hơn lương trung bình là ");
        manager.workerSalaryLessAverage();

        System.out.println("\nTổng lương trả cho nhân viên parttime : " + manager.getAllSalaryForPartTimeWorker());

        System.out.println("\nDanh sách nhân viên fulltime sắp xếp theo lương tăng dần : ");
        manager.sortFullTimeWorkerFollowSalaryIncrease();

        String key = "6";
        System.out.println("\nTìm kiếm theo từ khóa : " + key);
        for (Worker worker : manager.search(key)) {
            System.out.println(worker.toString());
        }

    }
}