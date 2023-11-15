package common.tool;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class Converter {
    DecimalFormat formatter = new DecimalFormat("###,###");
    Validator validator = new Validator();

    public String formatNumberWithCommas(int number) {
        return formatter.format(number);
    }

    public final int stringToInteger(String value) {
        validator.isDayOfMonthValid(value);
        return Integer.parseInt(value);
    }

    public Map<String, Integer> parseOrder(String orderInfo) {
        Map<String, Integer> orderList;
        orderList = parseOrderStringToList(orderInfo);
        validator.hasOnlyDrinkOrder(orderList);
        return orderList;
    }

    private Map<String, Integer> parseOrderStringToList(String orderInfo) {
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
        validator.hasDuplicateMenuOrder(orderList, menu);
        orderList.put(menu, quantity);
    }

    private int parseQuantity(String quantityString) {
        return Integer.parseInt(quantityString);
    }
}