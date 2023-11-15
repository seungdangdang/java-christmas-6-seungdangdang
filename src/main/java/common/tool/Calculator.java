package common.tool;

import christmas.menu.MENU;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.DayOfWeek;

public class Calculator {
    public String getDiscountMenu(int visitDay) {
        return checkMainOrDessertDiscount(visitDay);
    }

    public final int getBeforeDiscountAmount(Map<String, Integer> orderList) {
        int beforeDiscountAmount = 0;

        Set<String> keys = orderList.keySet();
        for (String input : keys) {
            int price = getPriceForMenu(input, orderList.get(input));
            beforeDiscountAmount += price;
        }
        return beforeDiscountAmount;
    }

    public final int calculateChristmasDayDiscount(int visitDay) {
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

    public final int calculateSpecialDayDiscount(int visitDay, List<Integer> specialDayList) {
        for (Integer specialDay : specialDayList) {
            if (visitDay == specialDay) {
                return 1000;
            }
        }
        return 0;
    }

    public final int calculateDayOfWeekDiscountAmount(int visitDay, Map<String, Integer> orderList) {
        String discountMenu = getDiscountMenu(visitDay);
        int discountAmount = 0;
        Set<String> orderKeys = orderList.keySet();

        for (String myOrder : orderKeys) {
            discountAmount = getDiscountAmount(orderList, myOrder, discountMenu, discountAmount);
        }
        return discountAmount;
    }

    public final int getDiscountedAmount(int beforeAmount, int entireDiscountAmount, String freeGiftResult) {
        if (freeGiftResult.equals("샴페인 1개")) {
            return beforeAmount - (entireDiscountAmount - 25000);
        }
        if (freeGiftResult.equals("없음")) {
            return beforeAmount - entireDiscountAmount;
        }
        return 0;
    }

    private static int getDiscountAmount(Map<String, Integer> orderList, String myOrder, String discountMenu,
                                         int discountAmount) {
        for (MENU menu : MENU.values()) {
            if (menu.getKoreanName().equals(myOrder)) {
                discountAmount = getDiscountAmount(orderList, myOrder, discountMenu, discountAmount, menu);
            }
        }
        return discountAmount;
    }

    private static int getDiscountAmount(Map<String, Integer> orderList, String myOrder, String discountMenu,
                                         int discountAmount, MENU menu) {
        if (menu.getMatchKind().equals(discountMenu)) {
            int value = orderList.get(myOrder);
            int discount = value * 2023;
            discountAmount += discount;
        }
        return discountAmount;
    }

    private String checkMainOrDessertDiscount(int visitDay) {
        LocalDate date = LocalDate.of(2023, 12, visitDay);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        if (dayOfWeekNumber == 5 || dayOfWeekNumber == 6) {
            return "메인";
        }
        return "디저트";
    }

    private int getPriceForMenu(String input, int quantity) {
        for (MENU menu : MENU.values()) {
            if (menu.getKoreanName().equals(input)) {
                return quantity * menu.getMatchPrice();
            }
        }
        return 0;
    }
}