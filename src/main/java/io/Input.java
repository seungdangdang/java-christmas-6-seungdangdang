package io;

import camp.nextstep.edu.missionutils.Console;
import common.tool.Converter;
import java.util.Map;

public class Input {
    Converter converter;
    Output output;

    public Input(Converter converter, Output output) {
        this.converter = converter;
        this.output = output;
    }

    public final Map<String, Integer> getOrderList() {
        return orderList();
    }

    public final int getVisitDate() {
        return visitDate();
    }

    private int visitDate() {
        while (true) {
            String value = getUserInput();
            try {
                return converter.stringToInteger(value);
            } catch (IllegalArgumentException dayError) {
                output.outputVisitDayErrorMessage();
            }
        }
    }

    private Map<String, Integer> orderList() {
        while (true) {
            String value = getUserInput();
            try {
                return converter.parseOrder(value);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException orderError) {
                output.outputOrderErrorMessage();
            }
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }
}