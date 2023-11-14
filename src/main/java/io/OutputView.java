package io;

import static constant.RequestMessage.ORDER_REQUEST_MESSAGE;
import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;
import static constant.SystemMessage.EVENT_PREVIEW_NOTIFICATION_MESSAGE;
import static constant.SystemMessage.LINE_SEPARATOR;
import static constant.SystemMessage.WELCOME_MESSAGE;

import common.tool.Calculator;
import christmas.event.FreeGift;
import christmas.progress.Benefit;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public FreeGift event = new FreeGift();
    private int amount = 0;

    Calculator calculator = new Calculator();

    DecimalFormat formatter = new DecimalFormat("###,###");
    Benefit benefit = new Benefit();

    public void startMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void eventPreviewMessage(int visitDay) {
        System.out.print("12월 " + visitDay + EVENT_PREVIEW_NOTIFICATION_MESSAGE);
    }

    public void visitDayRequestMessage() {
        System.out.println(VISIT_DAY_REQUEST_MESSAGE);
    }

    public void orderRequestMessage() {
        System.out.println(ORDER_REQUEST_MESSAGE);
    }

    public void outputOrderMenu(Map<String, Integer> orderList) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> entrySet : orderList.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue() + "개");
        }
    }

    public void outputBeforeDiscountAmount(Map<String, Integer> orderList) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<할인 전 총주문 금액>");
        this.amount = calculator.getBeforeDiscountAmount(orderList);
        System.out.println(formatter.format(amount) + "원");
    }

    public void outputFreeGift() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<증정 메뉴>");
        String freeGiftMenu = event.getAboutFreeGift(amount);
        System.out.println(freeGiftMenu);
    }

    public void outputBenefit(int visitDay, Map<String, Integer> orderList, int beforeAmount) {
        benefit.getUserBenefit(visitDay, orderList, beforeAmount);
        int christmasDayAmount = benefit.getChristmasDayAmount();
        int dayOfWeekAmount = benefit.getDayOfWeekAmount();
        String thisDay = benefit.getThisDay();
        int specialDayAmount = benefit.getSpecialDayAmount();
        int freeGiftResult = benefit.getFreeGiftResult();
        System.out.print(LINE_SEPARATOR);
        System.out.println("<혜택 내역>");

        if (christmasDayAmount > 0) {
            System.out.println("크리스마스 디데이 할인: -" + formatter.format(christmasDayAmount) + "원");
        }
        if (dayOfWeekAmount > 0) {
            System.out.println(thisDay + " 할인: -" + formatter.format(dayOfWeekAmount) + "원");
        }
        if (specialDayAmount > 0) {
            System.out.println("특별 할인: -" + formatter.format(specialDayAmount) + "원");
        }
        if (freeGiftResult > 0) {
            System.out.println("증정 이벤트: -" + formatter.format(freeGiftResult) + "원");
        }
        if (christmasDayAmount == 0 && dayOfWeekAmount == 0 && specialDayAmount == 0 && freeGiftResult == 0) {
            System.out.println("없음");
        }
    }

    public void outputEntireBenefit(int amountAfterDiscount) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<총혜택 금액>");
        System.out.println("-" + formatter.format(amountAfterDiscount) + "원");
    }

    public int getEntireDiscountAmount(int visitDay, Map<String, Integer> orderList, int beforeAmount) {
        benefit.getUserBenefit(visitDay, orderList, beforeAmount);
        int christmasDayAmount = benefit.getChristmasDayAmount();
        int dayOfWeekAmount = benefit.getDayOfWeekAmount();
        int specialDayAmount = benefit.getSpecialDayAmount();
        int freeGiftResult = benefit.getFreeGiftResult();

        return christmasDayAmount + dayOfWeekAmount + specialDayAmount + freeGiftResult;
    }

    public void outputDiscountedAmount(int discountedAmount) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatter.format(discountedAmount) + "원");
    }

    public int getAfterDiscountedAmount(int beforeAmount, int entireDiscountAmount) {
        int freeGiftResult = benefit.getFreeGiftResult();
        return calculator.getDiscountedAmount(beforeAmount, entireDiscountAmount, freeGiftResult);
    }

    public void outputEventBadge(String eventBadge) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<12월 이벤트 배지>");
        if (eventBadge != null) {
            System.out.println(eventBadge);
        }
    }

    public String getEventBadge(int entireDiscountAmount) {
        if (entireDiscountAmount >= 20000) {
            return "산타";
        }
        if (entireDiscountAmount >= 10000) {
            return "트리";
        }
        if (entireDiscountAmount >= 5000) {
            return "별";
        }
        return null;
    }
}