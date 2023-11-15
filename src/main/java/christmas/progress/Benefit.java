package christmas.progress;

import common.tool.Calculator;
import christmas.event.FreeGift;
import christmas.event.SpecialDayDiscount;
import java.util.Map;

public class Benefit {
    Calculator calculator = new Calculator();

    SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(calculator);
    FreeGift freeGift = new FreeGift();

    public int getChristmasDayAmount() {
        return christmasDayAmount;
    }

    public int getDayOfWeekAmount() {
        return dayOfWeekAmount;
    }

    public int getSpecialDayAmount() {
        return specialDayAmount;
    }

    public int getFreeGiftResult() {
        return freeGiftResult;
    }

    public String getThisDay() {
        return thisDay;
    }

    public final void getUserBenefit(int visitDay, Map<String, Integer> orderList, int beforeAmount) {
        christmasDayAmount = calculator.calculateChristmasDayDiscount(visitDay);
        dayOfWeekAmount = calculator.calculateDayOfWeekDiscountAmount(visitDay, orderList);
        specialDayAmount = specialDayDiscount.getSpecialDayDiscount(visitDay);
        if (calculator.getDiscountMenu(visitDay).equals("메인")) {
            thisDay = "주말";
        }
        if (calculator.getDiscountMenu(visitDay).equals("디저트")) {
            thisDay = "평일";
        }
        if (freeGift.getAboutFreeGift(beforeAmount).equals("샴페인 1개")) {
            freeGiftResult = 25000;
        }
    }

    private int christmasDayAmount = 0;
    private int dayOfWeekAmount = 0;
    private int specialDayAmount = 0;
    private int freeGiftResult;
    private String thisDay;


}