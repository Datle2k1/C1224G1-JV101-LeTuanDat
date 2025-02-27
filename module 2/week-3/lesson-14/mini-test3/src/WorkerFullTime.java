public class WorkerFullTime extends Worker {
    private long bonus;
    private long penalty;
    private long base;

    public WorkerFullTime() {}

    public WorkerFullTime(int id, String name, int age, String phone, String email, long bonus, long penalty, long base) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.penalty = penalty;
        this.base = base;
    }

    @Override
    public long getRealSalary() {
        return base + (bonus - penalty);
    }

    @Override
    public String toString() {
        return super.toString() + ", Real Salary : " + getRealSalary();
    }
}
