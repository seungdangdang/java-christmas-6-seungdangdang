package base;

import java.util.Map;
import validation.Validator;

public class Converter {
    Validator validator = new Validator();

    public final int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public void parseOrderStringToList(String orderInfo, Map<String, Integer> orderList) {
        String[] items = orderInfo.split(",");
        for (String item : items) {
            processOrderItem(item, orderList);
        }
    }

    private void processOrderItem(String item, Map<String, Integer> orderList) {
        String[] parts = item.split("-");
        String menu = parts[0].trim();
        int quantity = parseQuantity(parts[1]);
        validator.isValidMenu(menu);
        orderList.put(menu, quantity);
    }

    private int parseQuantity(String quantityString) {
        return Integer.parseInt(quantityString);
    }
}