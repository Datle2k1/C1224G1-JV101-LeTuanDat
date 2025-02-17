import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2.0f, 3.0f);
        point2D.setXY(5.0f, 5.0f);
        System.out.println("Get XY : " + Arrays.toString(point2D.getXY()));
        System.out.println("Point 2D : " + point2D.toString());

        Point3D point3D = new Point3D(2.0f, 3.0f, 4.0f);
        point3D.setXYZ(6.0f, 6.0f, 6.0f);
        System.out.println("Get XYZ : " + Arrays.toString(point3D.getXYZ()));
        System.out.println("Point 3D : " + point3D.toString());
    }
}