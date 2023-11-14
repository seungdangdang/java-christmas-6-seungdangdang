package common.userValue;

import common.tool.Converter;
import io.Input;
import io.Output;

public class UserVisitDate {
    private final Converter converter = new Converter();
    private final Input input = new Input();
    private final Output output = new Output(converter);

    public int getVisitDate() {
        return visitDate();
    }

    private int visitDate() {
        while (true) {
            String value = input.getUserInput();
            try {
                return converter.stringToInteger(value);
            } catch (IllegalArgumentException dayError) {
                output.outputVisitDayErrorMessage();
            }
        }
    }
}