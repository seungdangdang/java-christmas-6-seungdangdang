package io;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    public int visitDate() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public Map<String, Integer> orderList() {
        String input = Console.readLine();
        return parseOrder(input);
    }

    private static Map<String, Integer> parseOrder(String orderInfo) {
        Map<String, Integer> orderList = new HashMap<>();

        String[] items = orderInfo.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            if (parts.length == 2) {
                String menu = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                orderList.put(menu, quantity);
            }
        }
        return orderList;
    }
}
