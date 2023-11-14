package common;

import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class Converter {
    Validator validator = new Validator();

    public final int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public Map<String, Integer> parseOrderStringToList(String orderInfo) {
        Map<String, Integer> orderList = new HashMap<>();
        String[] items = orderInfo.split(",");
        for (String item : items) {
            processOrderItem(item, orderList);
        }
        return orderList;
    }

    private void processOrderItem(String item, Map<String, Integer> orderList) {
        String[] parts = item.split("-");
        String menu = parts[0].trim();
        int quantity = parseQuantity(parts[1]);
        validator.isValidMenu(menu);
        validator.isValidOrderCount(quantity);
        orderList.put(menu, quantity);
    }

    private int parseQuantity(String quantityString) {
        return Integer.parseInt(quantityString);
    }
}