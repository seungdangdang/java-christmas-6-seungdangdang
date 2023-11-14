package christmas.progress;

import christmas.event.FreeGift;
import common.tool.Calculator;
import common.userValue.UserOrder;
import common.userValue.UserVisitDate;
import io.Output;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// MEMO: 매개변수를 넣으면 여러 클래스와 메서드의 기능을 조합해서 값을 도출해내는 창구
public class UserInterface {
    Output output = new Output();
    UserVisitDate userVisitDate = new UserVisitDate();
    UserOrder userOrder = new UserOrder();
    Calculator calculator = new Calculator();
    FreeGift freeGift = new FreeGift();
    Benefit benefit = new Benefit();
    int visitDate = 0;
    public Map<String, Integer> orderList = new HashMap<>();

    public void gatheringVisitDateAndOrderList() {
        output.startMessage();
        output.visitDayRequestMessage();
        visitDate = userVisitDate.getVisitDate();
        output.orderRequestMessage();
        orderList = userOrder.getOrderList();
    }

    public void showEventBenefits(int visitDate, Map<String, Integer> orderList) {
        output.eventPreviewMessage(visitDate);
        showOrderMenu(orderList);
        int totalAmountBeforeDiscount = getTotalAmountBeforeDiscount(orderList);
        showTotalAmountBeforeDiscount(orderList, totalAmountBeforeDiscount);
        String freeGiftMenu = freeGift.getAboutFreeGift(totalAmountBeforeDiscount);
        showFreeGiftMenu(freeGiftMenu);
        outputEachBenefit(visitDate, orderList, totalAmountBeforeDiscount);
        int totalDiscountAmount = getEntireDiscountAmount(visitDate, orderList, totalAmountBeforeDiscount);
        showTotalDiscountAmount(totalDiscountAmount);
        int estimatedPaymentAmountAfterDiscount = getEstimatedPaymentAmountAfterDiscount(totalAmountBeforeDiscount,
                totalDiscountAmount, freeGiftMenu);
        showEstimatedPaymentAmountAfterDiscount(estimatedPaymentAmountAfterDiscount);
        showEventBadge(totalDiscountAmount);
    }

    private void showEventBadge(int totalDiscountAmount) {
        output.outputEventBadge();
        output.outputEventBadgeResult(totalDiscountAmount);
    }

    private void showEstimatedPaymentAmountAfterDiscount(int estimatedPaymentAmountAfterDiscount) {
        output.estimatedPaymentAmountAfterDiscount();
        output.outputFormatNumberWithCommas(estimatedPaymentAmountAfterDiscount);
    }

    private int getEstimatedPaymentAmountAfterDiscount(int totalAmountBeforeDiscount, int totalDiscountAmount,
                                                       String freeGiftMenu) {
        return calculator.getDiscountedAmount(totalAmountBeforeDiscount, totalDiscountAmount, freeGiftMenu);
    }

    private void showTotalDiscountAmount(int totalDiscountAmount) {
        output.outputEntireBenefit();
        output.outputFormatNumberWithCommas(totalDiscountAmount);
    }

    private int getEntireDiscountAmount(int visitDay, Map<String, Integer> orderList, int totalAmountBeforeDiscount) {
        benefit.getUserBenefit(visitDay, orderList, totalAmountBeforeDiscount);
        int christmasDayAmount = benefit.getChristmasDayAmount();
        int dayOfWeekAmount = benefit.getDayOfWeekAmount();
        int specialDayAmount = benefit.getSpecialDayAmount();
        int freeGiftResult = benefit.getFreeGiftResult();
        return christmasDayAmount + dayOfWeekAmount + specialDayAmount + freeGiftResult;
    }

    private void outputEachBenefit(int visitDate, Map<String, Integer> orderList, int totalAmountBeforeDiscount) {
        output.outputTotalDiscountAmount();
        benefit.getUserBenefit(visitDate, orderList, totalAmountBeforeDiscount);
        int christmasCountdownDiscountAmount = benefit.getChristmasDayAmount();
        int dayOfWeekDiscountAmount = benefit.getDayOfWeekAmount();
        String thisDay = benefit.getThisDay();
        int specialDayDiscountAmount = benefit.getSpecialDayAmount();
        int freeGiftResult = benefit.getFreeGiftResult();
        checkEachBenefit(christmasCountdownDiscountAmount, dayOfWeekDiscountAmount, thisDay, specialDayDiscountAmount,
                freeGiftResult);
    }

    private void checkEachBenefit(int christmasCountdownDiscountAmount, int dayOfWeekDiscountAmount, String thisDay,
                                  int specialDayDiscountAmount,
                                  int freeGiftResult) {
        if (christmasCountdownDiscountAmount > 0) {
            output.outputChristmasCountdownDiscountAmount(christmasCountdownDiscountAmount);
        }
        if (dayOfWeekDiscountAmount > 0) {
            output.outputDayOfWeekDiscountAmount(dayOfWeekDiscountAmount, thisDay);
        }
        if (specialDayDiscountAmount > 0) {
            output.outputSpecialDayDiscountAmount(specialDayDiscountAmount);
        }
        if (freeGiftResult > 0) {
            output.outputFreeGiftBenefit(freeGiftResult);
        }
        if (christmasCountdownDiscountAmount == 0 && dayOfWeekDiscountAmount == 0 && specialDayDiscountAmount == 0
                && freeGiftResult == 0) {
            output.outputNothingStatus();
        }
    }

    private void showFreeGiftMenu(String freeGiftMenu) {
        output.outputFreeGiftMenuInformation();
        output.outputInput(freeGiftMenu);
    }

    private void showTotalAmountBeforeDiscount(Map<String, Integer> orderList, int totalAmountBeforeDiscount) {
        output.outputBeforeDiscountAmount(orderList);
        output.outputFormatNumberWithCommas(totalAmountBeforeDiscount);
    }

    private void showOrderMenu(Map<String, Integer> orderList) {
        output.outputOrderMenu();
        for (Entry<String, Integer> entrySet : orderList.entrySet()) {
            output.outputOrdersAndCount(entrySet.getKey(), entrySet.getValue());
        }
    }

    private int getTotalAmountBeforeDiscount(Map<String, Integer> orderList) {
        return calculator.getBeforeDiscountAmount(orderList);
    }
}