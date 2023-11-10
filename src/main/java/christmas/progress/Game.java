package christmas.progress;

import io.InputView;
import io.OutputView;

public class Game {
    public OutputView outputView = new OutputView();
    public InputView inputView = new InputView();

    public void run() {
        outputView.startMessage();
        outputView.visitDayRequestMessage();
        inputView.visitDate();
        outputView.orderRequestMessage();
        inputView.orderList();
        outputView.eventPreviewMessage();
    }
}