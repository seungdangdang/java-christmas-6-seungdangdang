package io;

import static constant.ErrorMessage.NOT_VALID_NUMBER;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class InputView {
    private final Converter converter;

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
        converter = new Converter();
    }

    public int visitDate() {
        while (true) {
            String input = Console.readLine();
            try {
                validator.isDayOfMonthValid(input);
                return converter.stringToInteger(input);
            } catch (IllegalArgumentException dayError) {
                System.out.println(NOT_VALID_NUMBER);
            }
        }
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
