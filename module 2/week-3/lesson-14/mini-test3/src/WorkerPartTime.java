public class WorkerPartTime extends Worker {
    private int timeWork;

    public WorkerPartTime() {}

    public WorkerPartTime(int id, String name, int age, String phone, String email, int timeWork) {
        super(id, name, age, phone, email);
        this.timeWork = timeWork;
    }

    @Override
    public long getRealSalary() {
        return 100000L * timeWork;
    }

    @Override
    public String toString() {
        return super.toString() + ", Real Salary : " + getRealSalary();
    }
}
