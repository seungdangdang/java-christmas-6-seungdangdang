package christmas.progress;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {
    Benefit benefit;

    @BeforeEach
    void setup() {
        benefit = new Benefit();
    }

    @DisplayName("방문일자와 주문내용에 따라서 혜택을 적용한다.")
    @Test
    void checkBenefit() {
        int visitDay = 3;
        Map<String, Integer> orderList = new HashMap<>();
        orderList.put("티본스테이크", 1);
        orderList.put("바비큐립", 1);
        orderList.put("초코케이크", 2);
        orderList.put("제로콜라", 1);
        int beforeAmount = 142000;

        benefit.getUserBenefit(visitDay, orderList, beforeAmount);

        assertEquals(1200, benefit.getChristmasDayAmount());
        assertEquals("평일", benefit.getThisDay());
        assertEquals(4046, benefit.getDayOfWeekAmount());
        assertEquals(1000, benefit.getSpecialDayAmount());
        assertEquals(25000, benefit.getFreeGiftResult());
    }
}