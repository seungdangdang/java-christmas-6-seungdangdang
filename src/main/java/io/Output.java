package io;

import static constant.ErrorMessage.NOT_VALID_NUMBER;
import static constant.ErrorMessage.NOT_VALID_ORDER;
import static constant.RequestMessage.ORDER_REQUEST_MESSAGE;
import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;
import static constant.SystemMessage.EVENT_PREVIEW_NOTIFICATION_MESSAGE;
import static constant.SystemMessage.LINE_SEPARATOR;
import static constant.SystemMessage.NOTICE_WHEN_ORDER_BELOW_THE_STANDARD;
import static constant.SystemMessage.WELCOME_MESSAGE;

import common.tool.Converter;
import java.util.Map;

public class Output {
    Converter converter;

    public Output(Converter converter) {
        this.converter = converter;
    }

    public final void startMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public final void noneMessage() {
        System.out.println("없음");
    }

    public final void outputMessageWhenOrderlessThanTenThousandWon() {
        System.out.println(NOTICE_WHEN_ORDER_BELOW_THE_STANDARD);
    }

    public final void eventPreviewMessage(int visitDay) {
        System.out.print("12월 " + visitDay + EVENT_PREVIEW_NOTIFICATION_MESSAGE);
    }

    public final void visitDayRequestMessage() {
        System.out.println(VISIT_DAY_REQUEST_MESSAGE);
    }

    public final void orderRequestMessage() {
        System.out.println(ORDER_REQUEST_MESSAGE);
    }

    public final void outputOrderErrorMessage() {
        System.out.println(NOT_VALID_ORDER);
    }

    public final void outputVisitDayErrorMessage() {
        System.out.println(NOT_VALID_NUMBER);
    }

    public final void outputFormatNumberWithCommas(int number) {
        System.out.println(converter.formatNumberWithCommas(number) + "원");
    }

    public final void outputOrdersAndCount(String order, int count) {
        System.out.println(order + " " + count + "개");
    }

    public final void outputOrderMenu() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<주문 메뉴>");
    }

    public final void outputBeforeDiscountAmount(Map<String, Integer> orderList) {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<할인 전 총주문 금액>");
    }

    public final void outputFreeGiftMenuInformation() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<증정 메뉴>");
    }

    public final void outputInput(String input) {
        System.out.println(input);
    }

    public final void outputEachBenefit() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<혜택 내역>");
    }

    public final void outputChristmasCountdownDiscountAmount(int christmasCountdownDiscountAmount) {
        System.out.println(converter.formatNumberWithCommas(christmasCountdownDiscountAmount));
    }

    public final void outputDayOfWeekDiscountAmount(int dayOfWeekDiscountAmount, String thisDay) {
        System.out.println(thisDay + " 할인: -" + converter.formatNumberWithCommas(dayOfWeekDiscountAmount) + "원");
    }

    public final void outputSpecialDayDiscountAmount(int specialDayDiscountAmount) {
        System.out.println("특별 할인: -" + converter.formatNumberWithCommas(specialDayDiscountAmount) + "원");
    }

    public final void outputFreeGiftBenefit(int freeGiftResult) {
        System.out.println("증정 이벤트: -" + converter.formatNumberWithCommas(freeGiftResult) + "원");
    }

    public final void outputNothingStatus() {
        System.out.println("없음");
    }

    public final void outputEntireBenefit() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<총혜택 금액>");
    }

    public final void outputEstimatedPaymentAmountAfterDiscount() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<할인 후 예상 결제 금액>");
    }


    public final void outputEventBadge() {
        System.out.print(LINE_SEPARATOR);
        System.out.println("<12월 이벤트 배지>");
    }

    public final void outputEventBadgeResult(int totalDiscountAmount) {
        String eventBadge = getEventBadge(totalDiscountAmount);
        if (eventBadge != null) {
            System.out.println(eventBadge);
        }
        if (eventBadge == null) {
            System.out.println("없음");
        }
    }

    private String getEventBadge(int entireDiscountAmount) {
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