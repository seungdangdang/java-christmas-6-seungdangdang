package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfWeekDiscountTest {

    private DayOfWeekDiscount dayOfWeekDiscount;
    Map<String, Integer> orderList;

    @BeforeEach
    void setup() {
        dayOfWeekDiscount = new DayOfWeekDiscount();
        orderList = new HashMap<>();
    }

    @DisplayName("방문 요일에 따라서 할인되는 금액을 반환한다.")
    @Test
    void returnDayOfWeekDiscount() {
        orderList.put("샴페인", 1);
        orderList.put("양송이수프", 1);
        orderList.put("초코케이크", 1);
        assertEquals(dayOfWeekDiscount.getDayOfWeekDiscountAmount(1, orderList), 0);
        orderList.clear();

        orderList.put("티본스테이크", 5);
        orderList.put("양송이수프", 1);
        orderList.put("초코케이크", 1);
        assertEquals(dayOfWeekDiscount.getDayOfWeekDiscountAmount(1, orderList), 10115);
    }
}