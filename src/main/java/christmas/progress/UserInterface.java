package christmas.progress;

import common.userValue.UserOrder;
import common.userValue.UserVisitDate;
import io.Output;
import java.util.HashMap;
import java.util.Map;

// MEMO: 매개변수를 넣으면 여러 클래스와 메서드의 기능을 조합해서 값을 도출해내는 창구
public class UserInterface {
    Output output = new Output();
    UserVisitDate userVisitDate = new UserVisitDate();
    UserOrder userOrder = new UserOrder();
    int visitDate = 0;
    public Map<String, Integer> orderList = new HashMap<>();

    public void GatheringVisitDateAndOrderList() {
        output.startMessage();
        output.visitDayRequestMessage();
        visitDate = userVisitDate.getVisitDate();
        output.orderRequestMessage();
        orderList = userOrder.getOrderList();
    }
}