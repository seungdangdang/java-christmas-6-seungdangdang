package christmas.progress;

import io.InputView;
import io.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Game {
    public OutputView outputView = new OutputView();
    public InputView inputView = new InputView();
    public int visitDate = 0;
    public Map<String, Integer> orderList = new HashMap<>();

    public void run() {
        outputView.startMessage();
        outputView.visitDayRequestMessage();
        this.visitDate = inputView.visitDate();
        outputView.orderRequestMessage();
        this.orderList = inputView.orderList();
        outputView.eventPreviewMessage();
    }
}