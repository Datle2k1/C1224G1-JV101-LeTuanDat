import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager implements ManagerFeature {
    private final Scanner scanner = new Scanner(System.in);
    private static final String pathStudent = "data/students.csv";
    private static final String pathBatch = "data/batchs.csv";
    private static final String pathTeacher = "data/teachers.csv";
    private ArrayList<Person> students;
    private ArrayList<Classes> batches;
    private ArrayList<Person> teachers;

    public Manager() {
        readStudentsFromCSV();
        readFileBatches();
        readFileTeacher();
    }

    @Override
    public void display() {
        System.out.println("\nDisplay all students ");
        for (int i = 0; i < students.size(); i++) {
            if (i != 0 && i % 5 == 0) scanner.nextLine();
            Student student = (Student) students.get(i);
            String nameClasses = getCLasses(student.getIdClass());
            System.out.println(students.get(i).toString() + ",Class = " + nameClasses);
        }
        System.out.println("End display");
    }

    public void searchTeacher() {
        System.out.println("\nStart Search Teacher");
        String idTeacher;

        do {
            System.out.print("Id Teacher : ");
            idTeacher = scanner.nextLine().trim();
        } while (Util.isNotNumber(idTeacher));

        System.out.println("Search follow name");
        Person result = null;
        for (Person teacher : teachers) {
            if (teacher.getId() == Integer.parseInt(idTeacher)) {
                result = teacher;
            }
        }

        if (result == null) System.err.println("Not found Teacher");
        else System.out.println((result));
        System.out.println("End Search");
    }

    @Override
    public void add() {
        System.out.println("\nStart add information new student ");
        Student student = input();

        students.add(student);
        System.out.println("Add Student : " + student.getName() + " success.");
        System.out.println("End add information new student ");

        saveAndLoadNewData();
    }

    @Override
    public void remove() throws NotFoundStudentException {
        System.out.println("\nStart remove student");
        String idStudent;
        do {
            System.out.print("Id Student: ");
            idStudent = scanner.nextLine().trim();
        } while (Util.isNotNumber(idStudent));

        Person needRemove = null;
        for (Person student : students) {
            if ((student.getId() == Integer.parseInt(idStudent))) needRemove = student;
        }

        if (needRemove == null) throw new NotFoundStudentException("Not Found Exception");
        else {
            String select;
            System.out.println("Are you sure remove student " + needRemove.getName());
            System.out.print("Remove (Y / N) : ");
            select = scanner.nextLine().trim();

            if (select.equalsIgnoreCase("N")) System.out.println("Cancel remove student " + needRemove.getName());
            else {
                students.remove(needRemove);
                System.out.println("Remove student : " + needRemove.getName() + " complete.");

                saveAndLoadNewData();
            }
        }

        System.out.println("End remove student");
    }

    @Override
    public void searchStudent() {
        System.out.println("\nStart Search");
        ArrayList<Person> results = new ArrayList<>();
        System.out.print("Key : ");
        String key = scanner.nextLine().trim();

        System.out.println("Search follow name");
        for (Person student : students) {
            if (student.getName().toLowerCase().contains(key.toLowerCase())) {
                results.add(student);
            }
        }

        System.out.println("Count search result: " + results.size());
        for (Person student : results) System.out.println(student.toString());
        System.out.println("End Search");
    }

    public void writeStudentsToCSV() {
        try (FileWriter fw = new FileWriter(pathStudent, false);
             BufferedWriter bfw = new BufferedWriter(fw)) {
            for (Person student : students) {
                bfw.write(student.toData());
                bfw.newLine();
            }
            System.out.println("\nWrite to File CSV complete");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void readStudentsFromCSV() {
        students = new ArrayList<>();
        try (FileReader fr = new FileReader(pathStudent);
             BufferedReader bfr = new BufferedReader(fr)) {
            String data = "";
            while ((data = bfr.readLine()) != null) {
                String[] arr = data.split(",");
                students.add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5]));
            }
            System.out.println("\nRead from File CSV complete");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void readFileBatches() {
        batches = new ArrayList<>();
        try (FileReader fr = new FileReader(pathBatch);
             BufferedReader bfr = new BufferedReader(fr)) {
            String data;
            while ((data = bfr.readLine()) != null) {
                String[] arr = data.split(",");
                batches.add(new Classes(arr[0],arr[1],arr[2]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void readFileTeacher() {
        teachers = new ArrayList<>();
        try (FileReader fr = new FileReader(pathTeacher);
             BufferedReader bfr = new BufferedReader(fr)) {
            String data;
            while ((data = bfr.readLine()) != null) {
                String[] arr = data.split(",");
                teachers.add(new Teacher(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Student input() {
        int id = generateId();
        String name = inputName();
        String birth = Util.format(inputBirthday());
        String phone = inputPhone();
        String gender = inputGender();
        String group = inputIdClass();

        return new Student(id, name, phone, gender, birth, group);
    }

    private int generateId() {
        return students.size() + 1;
    }

    private String inputName() {
        String name;
        do {
            System.out.print("Name : ");
            name = scanner.nextLine().trim();
        } while (!Util.isInvalidName(name));
        return name;
    }

    private String inputBirthday() {
        String birth;
        do {
            System.out.print("Birth : ");
            birth = scanner.nextLine().trim();
        } while (!Util.isValidBirthday(birth));
        return birth;
    }

    private String inputPhone() {
        String phone;
        do {
            System.out.print("\nPhone : ");
            phone = scanner.nextLine().replace(" ", "");

            boolean isExist = false;
            for (Person value : students) {
                if (value.getPhone().equals(phone)) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                phone = "isExist";
                System.err.println("Phone is Exist");
            }
        } while (Util.isInvalidPhone(phone));
        return phone;
    }

    private String inputGender() {
        String gender;
        do {
            System.out.print("Gender Male/ Female/ Other : ");
            gender = scanner.nextLine().trim();
        } while (!Util.isValidGender(gender));
        return gender;
    }

    private String inputIdClass() {
        String idClass;
        do {
            System.out.print("Class : ");
            idClass = scanner.nextLine().trim();
        } while (!isClasses(idClass));
        return idClass;
    }

    private void saveAndLoadNewData() {
        writeStudentsToCSV();
        readStudentsFromCSV();
        display();
    }

    private boolean isClasses(String idClass) {
        boolean check = false;
        for (Classes batch : batches) {
            if (batch.getIdClasses().equals(idClass)) {
                check = true;
                break;
            }
        }

        return check;
    }

    private String getCLasses(String idClasses) {
        String nameClasses = "";
        for (Classes batch : batches) {
            if (batch.getIdClasses().equals(idClasses)) {
                nameClasses = batch.getNameClasses();
                break;
            }
        }

        return nameClasses;
    }
}
