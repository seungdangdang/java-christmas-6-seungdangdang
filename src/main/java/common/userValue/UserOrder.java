package common.userValue;

import static constant.ErrorMessage.NOT_VALID_ORDER;

import common.tool.Converter;
import io.Input;
import java.util.Map;

public class UserOrder {
    private final Input input = new Input();
    private final Converter converter = new Converter();

    public Map<String, Integer> getOrderList() {
        return orderList();
    }

    //TODO: orderLlist 메서드 책임 상세 분리
    //TODO: orderList 메서드 출력 방법 변경
    private Map<String, Integer> orderList() {
        while (true) {
            String value = input.getUserInput();
            try {
                return converter.parseOrder(value);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException orderError) {
                System.out.println(NOT_VALID_ORDER);
            }
        }
    }
}