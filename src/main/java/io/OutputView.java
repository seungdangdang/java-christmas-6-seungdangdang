package io;

import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;
import static constant.SystemMessage.EVENT_PREVIEW_NOTIFICATION_MESSAGE;
import static constant.SystemMessage.WELCOME_MESSAGE;

public class OutputView {
    public void startMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void eventPreviewMessage() {
        System.out.println(EVENT_PREVIEW_NOTIFICATION_MESSAGE);
    }
}
