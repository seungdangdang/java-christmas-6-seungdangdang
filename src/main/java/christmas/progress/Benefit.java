package christmas.progress;

import common.Calculator;
import christmas.event.ChristmasDayDiscount;
import christmas.event.DayOfWeekDiscount;
import christmas.event.FreeGift;
import christmas.event.SpecialDayDiscount;
import java.util.Map;

public class Benefit {
    ChristmasDayDiscount christmasDayDiscount = new ChristmasDayDiscount();
    DayOfWeekDiscount dayOfWeekDiscount = new DayOfWeekDiscount();
    Calculator calculator = new Calculator();

    SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(calculator);
    FreeGift freeGift = new FreeGift();
    private int christmasDayAmount = 0;
    private int dayOfWeekAmount = 0;
    private int specialDayAmount = 0;
    private int freeGiftResult;
    private String thisDay;

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

    public void getUserBenefit(int visitDay, Map<String, Integer> orderList, int beforeAmount) {
        christmasDayAmount = christmasDayDiscount.getChristmasDayDiscount(visitDay);
        dayOfWeekAmount = dayOfWeekDiscount.getDayOfWeekDiscountAmount(visitDay, orderList);
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
}