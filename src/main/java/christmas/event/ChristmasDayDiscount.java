package christmas.event;

import common.tool.Calculator;

public class ChristmasDayDiscount {
    Calculator calculator = new Calculator();

    public int getChristmasDayDiscount(int visitDay) {
        return calculator.calculateChristmasDayDiscount(visitDay);
    }
}