package co.com.test.screenplay.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static String getFormattedDateFrom(int daysToAdd) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(daysToAdd);
        return futureDate.format(FORMATTER);
    }

    public static String getFormattedDateTo(int daysToAdd) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(daysToAdd);
        return futureDate.format(FORMATTER);
    }
}
