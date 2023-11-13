package base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("주문메뉴의 할인 전 금액을 반환한다.")
    @Test
    void getAmount() {
        Map<String, Integer> list = new HashMap<>();
        list.put("양송이수프", 1);
        list.put("샴페인", 5);
        int amount = calculator.getBeforeDiscountAmount(list);
        assertEquals(amount, 131000);
    }

    @DisplayName("방문날짜에 따라 크리스마스 디데이 할인이 적용된다.")
    @Test
    void calculateChristmasDayDiscount() {
        assertEquals(calculator.calculateChristmasDayDiscount(31), 0);
        assertEquals(calculator.calculateChristmasDayDiscount(25), 3400);
    }

    @DisplayName("방문요일에 따라 적용되는 할인 메뉴가 반환된다.")
    @Test
    void getDiscountMenu() {
        assertEquals(calculator.getDiscountMenu(31), "디저트");
        assertEquals(calculator.getDiscountMenu(30), "메인");
    }
}