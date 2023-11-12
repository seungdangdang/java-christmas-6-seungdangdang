package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDayDiscountTest {
    private ChristmasDayDiscount christmasDayDiscount;

    @BeforeEach
    void setup() {
        christmasDayDiscount = new ChristmasDayDiscount();
    }

    @DisplayName("입력일자에 따른 할인금액 반환")
    @Test
    void returnDiscountAmount() {
        assertEquals(christmasDayDiscount.getDiscountChristmasDay(25), 3400);
        assertEquals(christmasDayDiscount.getDiscountChristmasDay(1), 1000);
        assertEquals(christmasDayDiscount.getDiscountChristmasDay(26), 0);
    }
}