package christmas.progress;

import java.util.Map;
import java.util.Set;

public class AmountCalculator {

    public int getBeforeDiscountAmount(Map<String, Integer> orderList) {
        int beforeDisCountAmount = 0;

        Set<String> keys = orderList.keySet();
        for (String input : keys) {
            for (MENU menu : MENU.values()) {
                if (menu.getKoreanName().equals(input)) {
                    int value = orderList.get(input);
                    int price = value * menu.getMatchPrice();
                    beforeDisCountAmount += price;
                }
            }
        }
        return beforeDisCountAmount;
    }
}