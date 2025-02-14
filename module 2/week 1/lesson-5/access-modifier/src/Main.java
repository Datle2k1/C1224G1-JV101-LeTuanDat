//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TestCircle test1 = new TestCircle();
        TestCircle test2 = new TestCircle(2.0);

        System.out.println(test1.getRadius());
        System.out.println(test2.getArea());
    }
}