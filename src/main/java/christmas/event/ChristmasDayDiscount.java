package christmas.event;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasDayDiscount {
    public int getDiscountChristmasDay(int visitDay) {
        return calculateChristmasDayDiscount(visitDay);
    }

    private static int calculateChristmasDayDiscount(int visitDay) {
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 25);
        LocalDate userDate = LocalDate.of(2023, 12, visitDay);

        int initialAmount = 1000;
        int discountPerDay = 100;

        if (userDate.isAfter(startDate.minusDays(1)) && userDate.isBefore(endDate.plusDays(1))) {
            int daysPassed = (int) startDate.until(userDate, ChronoUnit.DAYS);

            return initialAmount + (daysPassed * discountPerDay);
        }
        return 0;
    }
}