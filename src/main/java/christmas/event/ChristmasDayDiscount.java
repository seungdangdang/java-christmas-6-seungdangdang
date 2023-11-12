package christmas.event;

import base.Calculator;

public class ChristmasDayDiscount {
    Calculator calculator = new Calculator();

    public int getChristmasDayDiscount(int visitDay) {
        return calculator.calculateChristmasDayDiscount(visitDay);
    }
}