package base;

import java.util.Map;

public class Converter {
    public void parseOrderStringToList(String orderInfo, Map<String, Integer> orderList) {
        String[] items = orderInfo.split(",");
        for (String item : items) {
            processOrderItem(item, orderList);
        }
    }

    private void processOrderItem(String item, Map<String, Integer> orderList) {
        String[] parts = item.split("-");
        if (parts.length == 2) {
            String menu = parts[0].trim();
            int quantity = parseQuantity(parts[1]);
            orderList.put(menu, quantity);
        }
    }

    private int parseQuantity(String quantityString) {
        return Integer.parseInt(quantityString);
    }
}