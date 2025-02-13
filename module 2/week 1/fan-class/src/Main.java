import static java.awt.Color.blue;
import static java.awt.Color.yellow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FanClass fan1 = new FanClass();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor(yellow.toString());
        fan1.setOn(true);
        System.out.println("fan 1 : " + fan1.toStr());

        FanClass fan2 = new FanClass();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor(blue.toString());
        fan2.setOn(false);
        System.out.println("fan 2 : " + fan2.toStr());
    }
}