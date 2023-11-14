package christmas.event;

import common.tool.Calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialDayDiscount {
    Calculator calculator;
    final List<Integer> specialDayList = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 25, 31));

    public SpecialDayDiscount(Calculator calculator) {
        this.calculator = calculator;
    }

    public int getSpecialDayDiscount(int visitDay) {
        return calculator.calculateSpecialDayDiscount(visitDay, specialDayList);
    }
}