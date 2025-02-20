package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @org.junit.jupiter.api.Test
    void testGetNextDay1() throws ParseException {
        LocalDate input = LocalDate.parse("01/01/2018", formatter);
        LocalDate expected = LocalDate.parse("02/01/2018", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay2() throws ParseException {
        LocalDate input = LocalDate.parse("31/01/2018", formatter);
        LocalDate expected = LocalDate.parse("01/02/2018", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay3() throws ParseException {
        LocalDate input = LocalDate.parse("30/04/2018", formatter);
        LocalDate expected = LocalDate.parse("01/05/2018", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay4() throws ParseException {
        LocalDate input = LocalDate.parse("28/02/2018", formatter);
        LocalDate expected = LocalDate.parse("01/03/2018", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay5() throws ParseException {
        LocalDate input = LocalDate.parse("29/02/2020", formatter);
        LocalDate expected = LocalDate.parse("01/03/2020", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay6() throws ParseException {
        LocalDate input = LocalDate.parse("31/12/2018", formatter);
        LocalDate expected = LocalDate.parse("01/01/2019", formatter);
        LocalDate actual = NextDayCalculator.getNextDay(input);
        assertEquals(expected, actual);
    }
}