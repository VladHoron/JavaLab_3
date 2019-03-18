package ua.lviv.iot.fruitShop.managers;

import java.util.List;

import ua.lviv.iot.fruitShop.models.FruitShop;
import ua.lviv.iot.fruitShop.models.SummerBerries;
import ua.lviv.iot.fruitShop.models.SummerCitrusFruits;

public interface IFruitShopManager<F> {
    List<FruitShop> getFruitShopList();

    List<FruitShop> sortByFruitColor(List<FruitShop> list, boolean sortOrder);

    List<FruitShop> sortByPrice(List<FruitShop> list, boolean sortOrder);

    void addFruit(FruitShop fruit);

    List<FruitShop> searchBySummerCitrusFruits(List<FruitShop> list, SummerCitrusFruits summerCitrusFruits);

    List<FruitShop> searchBySummerBerries(List<FruitShop> list, SummerBerries summerBerries);

    void printList();
}