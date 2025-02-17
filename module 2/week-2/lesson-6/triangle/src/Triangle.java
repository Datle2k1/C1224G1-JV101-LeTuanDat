public class Triangle extends Shape {
    private float side1 = 1.0f;
    private float side2 = 1.0f;
    private float side3 = 1.0f;

    public Triangle() {}

    public Triangle(float side1, float side2, float side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public float getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        float perimeter = getPerimeter()/2;
        return  Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));
    }

    @Override
    public String toString() {
        return "A Triangle with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled")
                + "side1, side2, side 3 : " + side1 + "," + side2 + "," + side3;
    }

    public float getSide1() {
        return side1;
    }

    public void setSide1(float side1) {
        this.side1 = side1;
    }

    public float getSide2() {
        return side2;
    }

    public void setSide2(float side2) {
        this.side2 = side2;
    }

    public float getSide3() {
        return side3;
    }

    public void setSide3(float side3) {
        this.side3 = side3;
    }
}
