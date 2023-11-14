package common.userValue;

import static constant.ErrorMessage.NOT_VALID_NUMBER;

import common.tool.Converter;
import io.Input;
import validation.Validator;

public class UserVisitDate {
    private final Converter converter = new Converter();
    private final Validator validator = new Validator();
    private final Input input = new Input();

    public int getVisitDate() {
        return visitDate();
    }

    //TODO: visitDate 메서드 책임 상세 분리
    //TODO: visitDate 메서드 출력 방법 변경
    private int visitDate() {
        while (true) {
            String value = input.getUserInput();
            try {
                validator.isDayOfMonthValid(value);
                return converter.stringToInteger(value);
            } catch (IllegalArgumentException dayError) {
                System.out.println(NOT_VALID_NUMBER);
            }
        }
    }
}