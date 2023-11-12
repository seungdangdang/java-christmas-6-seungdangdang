package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @DisplayName("1~31사이의 숫자가 아닌 입력 시 예외가 발생한다.")
    @Test
    void createInvalidVisitDay() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.isDayOfMonthValid("100")
        );
    }
}