package christmas.progress;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountCalculatorTest {

    private AmountCalculator amountCalculator;

    @BeforeEach
    void setup() {
        amountCalculator = new AmountCalculator();
    }

    @DisplayName("주문메뉴의 할인 전 금액을 반환한다.")
    @Test
    void getAmount() {
        Map<String, Integer> list = new HashMap<>();
        list.put("양송이수프", 1);
        list.put("샴페인", 5);
        int amount = amountCalculator.getBeforeDiscountAmount(list);
        assertEquals(amount, 131000);
    }
}