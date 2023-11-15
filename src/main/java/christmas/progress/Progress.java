package christmas.progress;

import java.util.HashMap;
import java.util.Map;

public class Progress {
    public int visitDate = 0;
    public Map<String, Integer> orderList = new HashMap<>();
    public UserInterface userInterface = new UserInterface();

    public final void run() {
        userInterface.gatheringVisitDateAndOrderList();
        this.visitDate = userInterface.visitDate;
        this.orderList = userInterface.orderList;
        userInterface.showUserOrderInformation(visitDate, orderList);
    }
}