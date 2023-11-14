package common.userValue;

import common.tool.Converter;
import io.Input;
import io.Output;
import validation.Validator;

public class UserVisitDate {
    private final Converter converter = new Converter();
    private final Validator validator = new Validator();
    private final Input input = new Input();
    private final Output output = new Output();

    public int getVisitDate() {
        return visitDate();
    }

    //TODO: visitDate 메서드 책임 상세 분리 (validator을 StringToInteger메서드에서)
    private int visitDate() {
        while (true) {
            String value = input.getUserInput();
            try {
                validator.isDayOfMonthValid(value);
                return converter.stringToInteger(value);
            } catch (IllegalArgumentException dayError) {
                output.outputOrderErrorMessage();
            }
        }
    }
}