package christmas.event;

public class FreeGift {

    public String getAboutFreeGift(int amount) {
        boolean result = checkFreeGift(amount);
        if (result) {
            return "샴페인 1개";
        }
        return "없음";
    }

    private boolean checkFreeGift(int amount) {
        return amount >= 120000;
    }
}