package christmas.progress;

import common.Calculator;
import io.InputView;
import io.OutputView;
import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class Progress {
    public Validator validator = new Validator();
    public OutputView outputView = new OutputView();
    public InputView inputView = new InputView(validator);
    Calculator calculator = new Calculator();
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
        int beforeAmount = calculator.getBeforeDiscountAmount(orderList);
        outputView.outputBeforeDiscountAmount(orderList);
        outputView.outputFreeGift();
        outputView.outputBenefit(visitDate, orderList, beforeAmount);
        int entireDiscountAmount = outputView.getEntireDiscountAmount(visitDate, orderList, beforeAmount);
        outputView.outputEntireBenefit(entireDiscountAmount);
        int discountedAMount = outputView.getAfterDiscountedAmount(beforeAmount, entireDiscountAmount);
        outputView.outputDiscountedAmount(discountedAMount);
        String eventBadge = outputView.getEventBadge(entireDiscountAmount);
        outputView.outputEventBadge(eventBadge);
    }
}