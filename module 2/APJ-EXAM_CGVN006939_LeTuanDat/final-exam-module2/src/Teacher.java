public class Teacher extends Person{
    public Teacher(int id, String name, String birthday, String gender, String phone) {
        super(id, name, birthday, gender, phone);
    }

    @Override
    public String toData() {
        return this.getId() + "," + this.getName() + "," + this.getBirthday() + "," + this.getGender() + "," + this.getPhone();
    }
}
