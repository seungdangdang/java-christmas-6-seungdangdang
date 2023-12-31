package constant;

public class SystemMessage {
    private SystemMessage() {
    }

    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_PREVIEW_NOTIFICATION_MESSAGE = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + LINE_SEPARATOR;
    public static final String NOTICE_WHEN_ORDER_BELOW_THE_STANDARD = "10,000원 이상 결제 시 이벤트 혜택을 받을 수 있습니다.";
}