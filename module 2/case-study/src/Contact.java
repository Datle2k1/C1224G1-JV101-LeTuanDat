import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String gender;
    private String birth;
    private String group;

    public Contact() {
    }

    public Contact(String name, String phone, String address, String email, String gender, String birth, String group) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public String toData() {
        return name + "," +
                phone + "," +
                address + "," +
                email + "," +
                gender + "," +
                birth + "," +
                group;
    }
}
