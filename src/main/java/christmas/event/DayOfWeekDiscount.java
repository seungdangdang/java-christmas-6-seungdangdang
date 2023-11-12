package christmas.event;

import base.Calculator;
import java.util.Map;

public class DayOfWeekDiscount {

    Calculator calculator = new Calculator();

    public int getDayOfWeekDiscountAmount(int visitDay, Map<String, Integer> orderList) {
        return calculator.calculateDayOfWeekDiscountAmount(visitDay, orderList);
    }
}