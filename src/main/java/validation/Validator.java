package validation;

import christmas.menu.MENU;
import christmas.menu.MenuCategory;
import java.util.Map;
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

    public void isValidOrderCount(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }

    public void hasOnlyDrinkOrder(Map<String, Integer> orderList) {
        boolean result = true;
        MenuCategory menuCategory = new MenuCategory();
        for (Map.Entry<String, Integer> entry : orderList.entrySet()) {
            String key = entry.getKey();
            if (!menuCategory.getDrinkList().contains(key)) {
                result = false;
            }
        }
        if (result) {
            throw new IllegalArgumentException();
        }
    }

    public void hasDuplicateMenuOrder(Map<String, Integer> orderList, String menu) {
        if (orderList.containsKey(menu)) {
            throw new IllegalArgumentException();
        }
    }
}