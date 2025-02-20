package org.example;

public class TriangleClassifier {
    public static String classifyTriangle(int side1, int side2, int side3) {
        if (isTriangle(side1, side2, side3)) {
            if (side1 == side2 && side2 == side3) {
                return "tam giác đều";
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                return  "tam giác cân";
            } else {
                return "tam giác thường";
            }
        } else {
            return "không phải là tam giác";
        }
    }

    public static boolean isTriangle(int side1, int side2, int side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1 && side1 > 0 && side2 > 0 && side3 > 0;
    }
}
