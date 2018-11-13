package creational.abstractfactory.drinkfactory;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

class HotDrinkMachine {
    public enum AvailableDrink {
        COFFEE, TEA
    }

    private Dictionary<AvailableDrink, HotDrinkFactory> factories =
            new Hashtable<>();

    private List<Pair<String, HotDrinkFactory>> namedFactories =
            new ArrayList<>();

    public HotDrinkMachine() throws Exception {
        for (AvailableDrink drink : AvailableDrink.values()) {
            String s = drink.toString();

            String factoryName = "" + Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
            Class<?> factory = Class.forName("creational.abstractfactory.DrinkFactory." + factoryName + "Factory");

            factories.put(drink, (HotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }
    }

    public HotDrink makeDrink(AvailableDrink drink, int amount) {
        return factories.get(drink).prepare(amount);
    }
}
