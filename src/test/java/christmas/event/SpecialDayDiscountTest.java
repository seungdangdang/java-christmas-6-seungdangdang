package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import common.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDayDiscountTest {
    private SpecialDayDiscount specialDayDiscount;
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
        specialDayDiscount = new SpecialDayDiscount(calculator);
    }

    @DisplayName("방문날짜가 스페셜데이라면 할인금액 1000원을 리턴한다.")
    @Test
    void setSpecialDayDiscount() {
        assertEquals(specialDayDiscount.getSpecialDayDiscount(3), 1000);
        assertEquals(specialDayDiscount.getSpecialDayDiscount(4), 0);
        assertEquals(specialDayDiscount.getSpecialDayDiscount(31), 1000);
    }
}