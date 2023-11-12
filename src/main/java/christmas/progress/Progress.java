package christmas.progress;

import christmas.event.ChristmasDayDiscount;
import io.InputView;
import io.OutputView;
import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class Progress {
    public Validator validator = new Validator();
    public OutputView outputView = new OutputView();
    public InputView inputView = new InputView(validator);
    public ChristmasDayDiscount christmasDayDiscount = new ChristmasDayDiscount();
    public int visitDate = 0;
    public Map<String, Integer> orderList = new HashMap<>();

    public void run() {
        outputView.startMessage();
        outputView.visitDayRequestMessage();
        this.visitDate = inputView.visitDate();
        outputView.orderRequestMessage();
        this.orderList = inputView.orderList();
        outputView.eventPreviewMessage(visitDate);
        outputView.outputOrderMenu(orderList);
        outputView.outputBeforeDiscountAmount(orderList);
        outputView.outputFreeGift();

        int discountAmount = 0;
        discountAmount += christmasDayDiscount.getChristmasDayDiscount(visitDate);
    }
}