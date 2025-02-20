package org.example;

import static org.junit.jupiter.api.Assertions.*;
class TriangleClassifierTest {

    @org.junit.jupiter.api.Test
    void testClassifyTriangle1() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 2;

        String expected = "tam giác đều";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testClassifyTriangle2() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;

        String expected = "tam giác cân";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testClassifyTriangle3() {
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;

        String expected = "tam giác thường";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testClassifyTriangle4() {
        int side1 = 8;
        int side2 = 2;
        int side3 = 3;

        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testClassifyTriangle5() {
        int side1 = -1;
        int side2 = 2;
        int side3 = 1;

        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testClassifyTriangle16() {
        int side1 = 0;
        int side2 = 1;
        int side3 = 1;

        String expected = "không phải là tam giác";
        String actual = TriangleClassifier.classifyTriangle(side1, side2, side3);
        assertEquals(expected, actual);
    }
}