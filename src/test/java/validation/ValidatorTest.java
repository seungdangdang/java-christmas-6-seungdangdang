package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @Test
    void createInvalidVisitDay() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.isDayOfMonthValid("100")
        );
    }
}