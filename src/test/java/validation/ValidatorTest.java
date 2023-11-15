package validation;

import common.tool.Converter;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;
    Converter converter;
    Map<String, Integer> orderList;

    @BeforeEach
    void setup() {
        validator = new Validator();
        converter = new Converter();
        orderList = new HashMap<>();
    }

    @DisplayName("1~31사이의 숫자가 아닌 입력 시 예외가 발생한다.")
    @Test
    void createInvalidVisitDay() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.isDayOfMonthValid("100")
        );
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력하면 예외가 발생한다.")
    @Test
    void notHasMenu() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.isValidMenu("밥")
        );
    }

    @DisplayName("개수를 잘 못 입력하면 예외가 발생한다.")
    @Test
    void createInvalidOrderCount() {
        Assertions.assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> converter.parseOrder("양송이수프")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> converter.parseOrder("양송이수프-양송이수프")
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> converter.parseOrder("양송이수프-0")
        );
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void createOnlyDrinkOrder() {
        orderList.put("샴페인", 1);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.hasOnlyDrinkOrder(orderList)
        );

        orderList.put("레드와인", 15);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.hasOnlyDrinkOrder(orderList)
        );
    }

    @DisplayName("이미 입력한 메뉴를 중복 입력하면 예외가 발생한다.")
    @Test
    void createDuplicateMenuOrder() {
        orderList.put("시저샐러드", 1);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.hasDuplicateMenuOrder(orderList, "시저샐러드")
        );
    }

    @DisplayName("주문 메뉴가 20개를 초과하면 에러가 발생한다.")
    @Test
    void createOverOrder() {
        orderList.put("시저샐러드", 21);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateOrderMenuCount(orderList)
        );
    }
}