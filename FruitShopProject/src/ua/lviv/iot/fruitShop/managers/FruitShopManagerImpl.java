 package ua.lviv.iot.fruitShop.managers;

 import java.util.Comparator;
 import java.util.LinkedList;
 import java.util.List;

 import ua.lviv.iot.fruitShop.models.Berries;
 import ua.lviv.iot.fruitShop.models.CitrusFruits;
 import ua.lviv.iot.fruitShop.models.FruitShop;
 import ua.lviv.iot.fruitShop.models.SummerBerries;
 import ua.lviv.iot.fruitShop.models.SummerCitrusFruits;

 public class FruitShopManagerImpl implements IFruitShopManager<FruitShop> {

     private List<FruitShop> fruitShopList = new LinkedList<FruitShop>();

     CitrusFruits citrusFruits;
     Berries berries;

     public List<FruitShop> getFruitShopList() {
         return this.fruitShopList;
     }

     @Override
     public List<FruitShop> sortByFruitColor(List<FruitShop> list, boolean sortOrder) {
         if (sortOrder) {
             fruitShopList.sort(Comparator.comparing(FruitShop::getColor));
         } else {
             fruitShopList.sort(Comparator.comparing(FruitShop::getColor).reversed());
         }
         return fruitShopList;
     }

     @Override
     public List<FruitShop> sortByPrice(List<FruitShop> list, boolean sortOrder) {
         if (sortOrder) {
             fruitShopList.sort(Comparator.comparing(FruitShop::getPrice));
         } else {
             fruitShopList.sort(Comparator.comparing(FruitShop::getPrice).reversed());
         }
         return fruitShopList;
     }

     @Override
     public List<FruitShop> searchBySummerCitrusFruits(List<FruitShop> list, SummerCitrusFruits summerCitrusFruits) {
    	 List<FruitShop> searchedList = new LinkedList<FruitShop>();
    	 for (FruitShop fruit : list) {
             if (fruit.getClass().equals(citrusFruits.getClass())
                     && summerCitrusFruits.equals(citrusFruits.getSummerCitrusFruits())) {
                 searchedList.add(fruit);
             }
         }
         return searchedList;
     }

     @Override
     public List<FruitShop> searchBySummerBerries(List<FruitShop> list, SummerBerries summerBerries) {
    	 List<FruitShop> searchedList = new LinkedList<FruitShop>();
    	 for (FruitShop fruit : list) {
             if (fruit.getClass().equals(berries.getClass()) && summerBerries.equals(berries.getSummerBerries())) {
                 searchedList.add(fruit);
             }
         }
         return searchedList;
     }

     @Override
     public void addFruit(FruitShop fruit) {
         fruitShopList.add(fruit);
     }

     @Override
     public void printList() {
         System.out.println("Printing...\n");
         for (int i = 0; i < fruitShopList.size(); i++) {
             System.out.println(fruitShopList.get(i).getName());
             System.out.println(fruitShopList.get(i).getPrice());
             System.out.println(fruitShopList.get(i).getWeight());
             System.out.println(fruitShopList.get(i).getColor());
             System.out.println(fruitShopList.get(i).getVitamin() + "\n");
         }
     }

 }