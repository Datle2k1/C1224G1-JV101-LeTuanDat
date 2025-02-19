package com.codegym;

import com.codegym.circle.Circle;
import com.codegym.colorable.Colorable;
import com.codegym.rectangle.Rectangle;
import com.codegym.square.Square;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2);
        shapes[1] = new Rectangle(2,3);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape + ", Area : " +  ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println(shape + ", Area : " +  ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println(shape + ", Area : " +  ((Square) shape).getArea());
            } else {
                System.out.println("Invalid");
            }

            if (shape instanceof Colorable) {
                System.out.print(shape + ", ");
                ((Colorable) shape).howToColor();
            }
        }
    }
}
