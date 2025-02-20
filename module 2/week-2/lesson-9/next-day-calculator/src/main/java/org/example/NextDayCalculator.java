package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NextDayCalculator {
    public static LocalDate getNextDay(LocalDate input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int day = input.getDayOfMonth();
        int month = input.getMonthValue();
        int year = input.getYear();

        boolean isLastMonth = false;
        boolean isLastYear = false;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12: //31
                if (month == 12) isLastYear = true;
                if (day == 31) isLastMonth = true;
                break;
            case 4, 6, 9, 11: //30
                if (day == 30) isLastMonth = true;
                break;
            case 2:
                int dayOfFeb = isLeapYear(year) ? 29 : 28;
                if (day == dayOfFeb) isLastMonth = true;
                break;
        }

        if (isLastYear && isLastMonth) {
            day = 1;
            month = 1;
            year ++;
        } else if (isLastMonth) {
            day = 1;
            month ++;
        } else {
            day ++;
        }

        return LocalDate.parse(format(day) + "/" + format(month) + "/" + year, formatter);
    }

    private static String format(int value) {
        return ("" + value).length() == 2 ? "" + value : "0" + value;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
