//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(10.0, 2.0, "blue");
        System.out.println("Area : " + cylinder.getArea());
        System.out.println("Volume : " + cylinder.getVolume());
    }
}