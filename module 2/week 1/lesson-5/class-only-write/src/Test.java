//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {

    public static void swap(Person p) {
//        p = new Person("Name Swap");
        p.name = "test";
    }

    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("Wick");
//        student.setClasses("COO");

        Person p = new Person("Name Start");
        swap(p);
        System.out.println(p.name);
    }
}

class Person {
    public String name;

    Person(String name) {
        this.name = name;
    }
}