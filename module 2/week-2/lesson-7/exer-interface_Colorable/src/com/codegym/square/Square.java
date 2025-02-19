package com.codegym.square;

import com.codegym.Shape;
import com.codegym.colorable.Colorable;

public class Square extends Shape implements Colorable {
    private double side = 1.0;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
