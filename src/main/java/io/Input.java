package io;

import static constant.ErrorMessage.NOT_VALID_ORDER;

import common.tool.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import validation.Validator;

public class Input {
    private final Converter converter = new Converter();

    private final Validator validator = new Validator();

    public String getUserInput() {
        return Console.readLine();
    }

    public Map<String, Integer> orderList() {
        while (true) {
            String input = Console.readLine();
            try {
                return parseOrder(input);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException orderError) {
                System.out.println(NOT_VALID_ORDER);
            }
        }
    }

    private Map<String, Integer> parseOrder(String orderInfo) {
        Map<String, Integer> orderList;
        orderList = converter.parseOrderStringToList(orderInfo);
        return orderList;
    }
}