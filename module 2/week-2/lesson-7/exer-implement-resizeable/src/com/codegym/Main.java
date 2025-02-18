package com.codegym;

import com.codegym.resize.Resizeable;
import javafx.scene.SubScene;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2);
        shapes[1] = new Rectangle(2,3);
        shapes[2] = new Square(5);

        System.out.println("Arr Shape before increase size");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape + " . \nArea : " + ((Circle) shape).getArea());
                ((Circle) shape).resize(50);
            } else if (shape instanceof Rectangle) {
                System.out.println(shape + " . \nArea : " + ((Rectangle) shape).getArea());
                ((Rectangle) shape).resize(50);
            } else if (shape instanceof Square) {
                System.out.println(shape + " . \nArea : " + ((Square) shape).getArea());
                ((Square) shape).resize(50);
            } else {
                System.out.println("Shape invalid");
            }
        }

        System.out.println("Arr Shape after increase size");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape + " . \nArea : " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println(shape + " . \nArea : " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println(shape + " . \nArea : " + ((Square) shape).getArea());
            } else {
                System.out.println("Shape invalid");
            }
        }
    }
}
