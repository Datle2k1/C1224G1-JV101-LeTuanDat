import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println("Point: " + point.toString());
        point.setXY(1.0f, 1.0f);
        System.out.println("Point: " + point.toString());
        point.setX(3.0f);
        point.setY(3.0f);
        System.out.println("Get XY: " + Arrays.toString(point.getXY()));

        MovablePoint movablePoint = new MovablePoint(1.0f, 1.0f, 4.0f, 4.0f);
        System.out.println("\nGet XY: " + Arrays.toString(movablePoint.getXY()));
        System.out.println("Movable Point: " + movablePoint.toString());
        movablePoint.setSpeed(5.0f, 5.0f);
        System.out.println("getSpeed: " + Arrays.toString(movablePoint.getSpeed()));
        System.out.println("Movable Point move: " + movablePoint.move().toString());
    }
}