package christmas.event;

import base.Calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialDayDiscount {
    Calculator calculator;

    public SpecialDayDiscount(Calculator calculator) {
        this.calculator = calculator;
        specialDayList = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 25, 31));
    }

    List<Integer> specialDayList;

    public int getSpecialDayDiscount(int visitDay) {
        return calculator.calculateSpecialDayDiscount(visitDay, specialDayList);
    }
}