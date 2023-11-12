package validation;

import christmas.progress.MENU;
import java.util.regex.Pattern;

public class Validator {

    public void isDayOfMonthValid(String input) {
        final Pattern VISIT_DAY_PATTERN = Pattern.compile("^(?:[1-9]|[12]\\d|31)$");
        if (!VISIT_DAY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidMenu(String input) {
        boolean isValid = false;
        for (MENU menu : MENU.values()) {
            if (menu.getKoreanName().equals(input)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }
}