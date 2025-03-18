import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class ContactManager implements Comparator<Contact>, ContactManagerFeature {
    private final Scanner scanner = new Scanner(System.in);
    private static final String path = "data/contacts.csv";
    private ArrayList<Contact> contacts;

    public ContactManager() {
        readFromCSV();
    }

    @Override
    public void display() {
        System.out.println("\nDisplay all contacts ");
        for (int i = 0; i < contacts.size(); i++) {
            if (i != 0 && i % 5 == 0) scanner.nextLine();
            System.out.println(contacts.get(i).toString());
        }
        System.out.println("End display");
    }

    @Override
    public void add() {
        System.out.println("\nStart add information new contact ");
        Contact contact = input(null);

        contacts.add(contact);
        System.out.println("Add Contact : " + contact.getName() + " success.");
        System.out.println("End add information new contact ");
    }

    @Override
    public void edit() {
        System.out.println("\nStart Edit contact ");

        do {
            String phone = inputPhone(null);

            Contact needEdit = null;
            for (Contact contact : contacts) {
                if (contact.getPhone().equals(phone)) needEdit = contact;
            }

            if (needEdit == null) System.err.println("Contract not found");
            else {
                System.out.println("Editing contact " + needEdit.getName());
                Contact edit = input(needEdit);
                needEdit.setName(edit.getName().isEmpty() ? needEdit.getName() : edit.getName());
                needEdit.setAddress(edit.getAddress().isEmpty() ? needEdit.getAddress() : edit.getAddress());
                needEdit.setEmail(edit.getEmail().isEmpty() ? needEdit.getEmail() : edit.getEmail());
                needEdit.setGender(edit.getGender().isEmpty() ? needEdit.getGender() : edit.getGender());
                needEdit.setBirth(edit.getBirth().isEmpty() ? needEdit.getBirth() : edit.getBirth());
                needEdit.setGroup(edit.getGroup().isEmpty() ? needEdit.getGroup() : edit.getGroup());
                System.out.println("Edit complete: " + needEdit);
                break;
            }
        } while (reType());

        System.out.println("End Edit contact ");
    }

    @Override
    public void remove() {
        System.out.println("\nStart remove contact phone");
        String phone = inputPhone(null);

        Contact needRemove = null;
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone.trim())) needRemove = contact;
        }

        if (needRemove == null) System.err.println("Not Found Contact");
        else {
            contacts.remove(needRemove);
            System.out.println("Remove contact : " + needRemove.getName() + ", phone: " + phone + " complete.");
        }

        System.out.println("End remove contact phone : ");
    }

    @Override
    public void search() {
        System.out.println("\nStart Search");
        ArrayList<Contact> results = new ArrayList<>();
        System.out.print("Key : ");
        String key = scanner.nextLine().trim();

        if (Util.isNotNumber(key)) {
            System.out.println("Search follow name");
            for (Contact contact : contacts) {
                if (contact.getName().toLowerCase().contains(key.toLowerCase())) {
                    results.add(contact);
                }
            }
        } else {
            System.out.println("Search follow phone");
            for (Contact contact : contacts) {
                if (contact.getPhone().contains(key)) {
                    results.add(contact);
                }
            }
        }

        System.out.println("Count search result: " + results.size());
        for (Contact contact : results) System.out.println(contact.toString());
        System.out.println("End Search");
    }

    @Override
    public void sort() {
        contacts.sort(this);
        System.out.println("\nSort Contact follow name complete");
    }

    @Override
    public void writeToCSV() {
        try (FileWriter fw = new FileWriter(path, false);
             BufferedWriter bfw = new BufferedWriter(fw)) {
            for (Contact contact : contacts) {
                bfw.write(contact.toData());
                bfw.newLine();
            }
            System.out.println("\nWrite to File CSV complete");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void readFromCSV() {
        contacts = new ArrayList<>();
        try (FileReader fr = new FileReader(path);
             BufferedReader bfr = new BufferedReader(fr)) {
            String data = "";
            while ((data = bfr.readLine()) != null) {
                String[] arr = data.split(",");
                contacts.add(new Contact(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
            }
            System.out.println("\nRead from File CSV complete");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Contact input(Contact contact) {
        String phone = inputPhone(contact);
        String name = inputName(contact);
        String address = inputAddress(contact);
        String email = inputEmail(contact);
        String gender = inputGender(contact);
        String birth = Util.format(inputBirthday(contact));
        String group = inputGroup(contact);

        return new Contact(name, phone, address, email, gender, birth, group);
    }

    private String inputGroup(Contact contact) {
        String group;
        do {
            System.out.print("Group : ");
            group = scanner.nextLine().trim();
            if (contact != null && group.isEmpty()) break;
            else if (!group.isEmpty()) break;
        } while (true);
        return group;
    }

    private String inputBirthday(Contact contact) {
        String birth;
        do {
            System.out.print("Birth : ");
            birth = scanner.nextLine().trim();
            if (contact != null && birth.isEmpty()) break;
            else if (Util.isValidBirthday(birth)) break;
        } while (true);
        return birth;
    }

    private String inputGender(Contact contact) {
        String gender;
        do {
            System.out.print("Gender Male/ Female/ Other : ");
            gender = scanner.nextLine().trim();
            if (contact != null && gender.isEmpty()) break;
            else if (Util.isValidGender(gender)) break;
        } while (true);
        return gender;
    }

    private String inputEmail(Contact contact) {
        String email;
        do {
            System.out.print("Email : ");
            email = scanner.nextLine().trim();
            if (contact != null && email.isEmpty()) break;
            else if (Util.isValidEmail(email)) break;
        } while (true);
        return email;
    }

    private String inputAddress(Contact contact) {
        String address = "";
        do {
            System.out.print("Address : ");
            address = scanner.nextLine().trim();
            if (contact != null && address.isEmpty()) break;
            else if (!address.isEmpty()) break;
        } while (true);
        return address;
    }

    private String inputPhone(Contact contact) {
        String phone;
        do {
            System.out.print("\nPhone : ");
            if (contact == null) {
                phone = scanner.nextLine().replace(" ", "");

                boolean isExist = false;
                for (Contact value : contacts) {
                    if (value.getPhone().equals(phone)) {
                        isExist = true;
                        break;
                    }
                }

                if (isExist) {
                    phone = "isExist";
                    System.err.println("Phone is Exist");
                }
            } else {
                phone = contact.getPhone();
                System.out.println(phone);
            }
        } while (Util.isInvalidPhone(phone));
        return phone;
    }

    private String inputName(Contact contact) {
        String name;
        do {
            System.out.print("Name : ");
            name = scanner.nextLine().trim();
            if (contact != null && name.isEmpty()) break;
            else if (!Util.isInvalidName(name)) break;
        } while (true);
        return name;
    }

    private boolean reType() {
        System.out.print("ReType (Enter => retype/ Other => cancel): ");
        String re = scanner.nextLine().trim();
        return re.isEmpty();
    }

    @Override
    public int compare(Contact contact1, Contact contact2) {
        return Objects.compare(contact1.getName(), contact2.getName(), String::compareTo);
    }
}
