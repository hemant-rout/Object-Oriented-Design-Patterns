package creational.abstractfactory.drinkfactory;

public class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind beans, boil water, pour " + amount + "ml, add cream & sugar. Enjoy");
        return new Coffee();
    }
}
