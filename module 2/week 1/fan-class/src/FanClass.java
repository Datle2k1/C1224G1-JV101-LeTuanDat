import static java.awt.Color.blue;

public class FanClass {
    final int LOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = LOW;
    private boolean on = false;
    private double radius = 5;
    private String color = blue.toString();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FanClass()  {}

    public String toStr() {
        if (this.on) {
            return "speed : " + this.speed + ", color: " + this.color + ", radius: " + this.radius + ", fan is on";
        } else {
            return "color: " + this.color + ", radius: " + this.radius + ", fan is off";
        }
    }
}
