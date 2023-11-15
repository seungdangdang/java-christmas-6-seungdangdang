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

    public List<String> getMainMenuList() {
        List<String> mainMenuList = new ArrayList<>();
        mainMenuList.add(MENU.T_BONE_STEAK.getKoreanName());
        mainMenuList.add(MENU.BBQ_RIB.getKoreanName());
        mainMenuList.add((MENU.SEAFOOD_PASTA.getKoreanName()));
        mainMenuList.add((MENU.CHRISTMAS_PASTA.getKoreanName()));
        return mainMenuList;
    }

    public List<String> getDessertList() {
        List<String> dessertList = new ArrayList<>();
        dessertList.add(MENU.CHOCOLATE_CAKE.getKoreanName());
        dessertList.add(MENU.ICE_CREAM.getKoreanName());
        return dessertList;
    }

}