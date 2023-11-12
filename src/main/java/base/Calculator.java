package base;

import christmas.menu.MENU;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;

public class Calculator {
    public int getBeforeDiscountAmount(Map<String, Integer> orderList) {
        int beforeDisCountAmount = 0;

        Set<String> keys = orderList.keySet();
        for (String input : keys) {
            for (MENU menu : MENU.values()) {
                if (menu.getKoreanName().equals(input)) {
                    int value = orderList.get(input);
                    int price = value * menu.getMatchPrice();
                    beforeDisCountAmount += price;
                }
            }
        }
        return beforeDisCountAmount;
    }

    public int calculateChristmasDayDiscount(int visitDay) {
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