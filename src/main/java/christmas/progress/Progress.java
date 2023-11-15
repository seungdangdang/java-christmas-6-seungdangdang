package christmas.progress;

import christmas.event.FreeGift;
import common.tool.Calculator;
import common.tool.Converter;
import io.Input;
import io.Output;
import java.util.HashMap;
import java.util.Map;
import validation.Validator;

public class Progress {
    Validator validator = new Validator();
    Converter converter = new Converter(validator);
    Output output = new Output(converter);
    Input input = new Input(converter, output);
    Calculator calculator = new Calculator();
    FreeGift freeGift = new FreeGift();
    Benefit benefit = new Benefit();
    int visitDate;
    public Map<String, Integer> orderList = new HashMap<>();
    public UserInterface userInterface = new UserInterface(validator, converter, output, input, calculator, freeGift,
            benefit);

    public final void run() {
        userInterface.gatheringVisitDateAndOrderList();
        this.visitDate = userInterface.visitDate;
        this.orderList = userInterface.orderList;
        userInterface.showUserOrderInformation(visitDate, orderList);
    }
}