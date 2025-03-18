public class Student extends Person{
    private final String idClass;

    public Student(int id, String name, String birthday, String gender, String phone, String idClass) {
        super(id, name, birthday, gender, phone);
        this.idClass = idClass;
    }

    public String getIdClass() {
        return idClass;
    }

    @Override
    public String toData() {
        return this.getId() + "," +
                this.getName() + "," +
                this.getBirthday() + "," +
                this.getGender() + "," +
                this.getPhone() + "," +
                idClass;
    }
}
