package common.userValue;

import common.tool.Converter;
import io.Input;
import io.Output;
import java.util.Map;

public class UserOrder {
    private final Input input = new Input();
    private final Output output = new Output();
    private final Converter converter = new Converter();

    public Map<String, Integer> getOrderList() {
        return orderList();
    }

    //TODO: orderLlist 메서드 책임 상세 분리
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