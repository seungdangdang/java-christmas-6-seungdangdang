package christmas.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory {
    public List<String> getDrinkList() {
        List<String> drinkList = new ArrayList<>();
        drinkList.add(MENU.ZERO_COLA.getKoreanName());
        drinkList.add(MENU.RED_WINE.getKoreanName());
        drinkList.add((MENU.CHAMPAGNE.getKoreanName()));
        return drinkList;
    }
}