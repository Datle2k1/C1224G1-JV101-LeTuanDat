import java.util.ArrayList;
import java.util.Comparator;

public class WorkerManager implements Comparator<WorkerFullTime> {
    private final ArrayList<Worker> workers;

    public WorkerManager() {
        this.workers = new ArrayList<>();
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public long averageSalary() {
        long total = 0;
        for (Worker worker : workers) {
            total += worker.getRealSalary();
        }
        return total / workers.size();
    }

    public void workerSalaryLessAverage() {
        long average = averageSalary();
        for (Worker worker : workers) {
            if (worker.getRealSalary() < average) System.out.println(worker);
        }
    }

    public long getAllSalaryForPartTimeWorker() {
        long total = 0L;
        for (Worker worker : workers) {
            if (worker instanceof WorkerPartTime) {
                total += worker.getRealSalary();
            }
        }
        return total;
    }

    public void sortFullTimeWorkerFollowSalaryIncrease() {
        ArrayList<WorkerFullTime> fullTimes = fullTimeWorker();
        fullTimes.sort(this);
        fullTimes.forEach(System.out::println);
    }

    public ArrayList<Worker> search(String key) {
        ArrayList<Worker> result = new ArrayList<>();
        workers.forEach(worker -> {
            if (worker.getName().contains(key)) {
                result.add(worker);
            }
        });
        return result;
    }

    public ArrayList<WorkerFullTime> fullTimeWorker() {
        ArrayList<WorkerFullTime> fullTimes = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker instanceof WorkerFullTime) {
                fullTimes.add((WorkerFullTime) worker);
            }
        }
        return fullTimes;
    }

    @Override
    public int compare(WorkerFullTime worker1, WorkerFullTime worker2) {
        return Long.compare(worker1.getRealSalary(), worker2.getRealSalary());
    }
}
