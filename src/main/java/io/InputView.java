package io;

import static constant.RequestMessage.MENU_REQUEST_MESSAGE;
import static constant.RequestMessage.VISIT_DAY_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    public int getVisitDate() {
        System.out.println(MENU_REQUEST_MESSAGE);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public Map<String, Integer> getMenuList() {
        System.out.println(VISIT_DAY_REQUEST_MESSAGE);
        String input = Console.readLine();
        return parseOrder(input);
    }

    private static Map<String, Integer> parseOrder(String orderInfo) {
        Map<String, Integer> orderMenuList = new HashMap<>();

        String[] items = orderInfo.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            if (parts.length == 2) {
                String menu = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                orderMenuList.put(menu, quantity);
            }
        }
        return orderMenuList;
    }
}
