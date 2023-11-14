package common.userValue;

import common.tool.Converter;
import io.Input;
import io.Output;
import java.util.Map;

public class UserOrder {
    private final Converter converter = new Converter();
    private final Input input = new Input();
    private final Output output = new Output(converter);

    public Map<String, Integer> getOrderList() {
        return orderList();
    }

    private Map<String, Integer> orderList() {
        while (true) {
            String value = input.getUserInput();
            try {
                return converter.parseOrder(value);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException orderError) {
                output.outputOrderErrorMessage();
            }
        }
    }
}