package io;

import static constant.RequestMessage.ORDER_REQUEST_MESSAGE;
import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;
import static constant.SystemMessage.EVENT_PREVIEW_NOTIFICATION_MESSAGE;
import static constant.SystemMessage.WELCOME_MESSAGE;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public void startMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void eventPreviewMessage() {
        System.out.println(EVENT_PREVIEW_NOTIFICATION_MESSAGE);
    }

    public void visitDayRequestMessage() {
        System.out.println(VISIT_DAY_REQUEST_MESSAGE);
    }

    public void orderRequestMessage() {
        System.out.println(ORDER_REQUEST_MESSAGE);
    }

    public void outputOrderMenu(Map<String, Integer> orderList) {
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> entrySet : orderList.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue() + "개");
        }
    }
}
