package io;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private Converter converter;

    public InputView() {
        converter = new Converter();
    }

    public int visitDate() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public Map<String, Integer> orderList() {
        String input = Console.readLine();
        return parseOrder(input);
    }

    private Map<String, Integer> parseOrder(String orderInfo) {
        Map<String, Integer> orderList = new HashMap<>();
        converter.parseOrderStringToList(orderInfo, orderList);
        return orderList;
    }
}