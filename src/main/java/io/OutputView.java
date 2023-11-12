package io;

import static constant.RequestMessage.ORDER_REQUEST_MESSAGE;
import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;
import static constant.SystemMessage.EVENT_PREVIEW_NOTIFICATION_MESSAGE;
import static constant.SystemMessage.LINE_SEPARATOR;
import static constant.SystemMessage.WELCOME_MESSAGE;

import christmas.progress.AmountCalculator;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    AmountCalculator amountCalculator = new AmountCalculator();
    DecimalFormat formatter = new DecimalFormat("###,###");

    public void startMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void eventPreviewMessage() {
        System.out.print(EVENT_PREVIEW_NOTIFICATION_MESSAGE);
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
        int amount = amountCalculator.getBeforeDiscountAmount(orderList);
        System.out.println(formatter.format(amount) + "원");
    }
}
