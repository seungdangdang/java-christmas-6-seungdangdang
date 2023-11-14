package common.userValue;

import static constant.ErrorMessage.NOT_VALID_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import common.tool.Converter;
import validation.Validator;

public class UserVisitDay {
    private final Converter converter = new Converter();

    private final Validator validator = new Validator();

    public int getVisitDay() {
        return visitDate();
    }

    private int visitDate() {
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
}