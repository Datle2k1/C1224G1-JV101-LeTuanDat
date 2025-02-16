public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b - Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }

    public double getRoot2() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b + Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }
}
