package org.example;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @org.junit.jupiter.api.Test
    void translate1() {
        int number = -1;

        String expected = "-1";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate2() {
        int number = 3;

        String expected = "Fizz";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate3() {
        int number = 5;

        String expected = "Buzz";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate4() {
        int number = 15;

        String expected = "FizzBuzz";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate5() {
        int number = 17;

        String expected = "mot bay";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate6() {
        int number = 13;

        String expected = "Fizz";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate7() {
        int number = 25;

        String expected = "Buzz";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate8() {
        int number = 2;

        String expected = "hai";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void translate9() {
        int number = 26;

        String expected = "hai sau";
        String actual = FizzBuzzTranslate.translate(number).toString();
        assertEquals(expected, actual);
    }
}