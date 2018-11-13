package creational.abstractfactory.drinkfactory;

public class Demo {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink tea = machine.makeDrink(HotDrinkMachine.AvailableDrink.TEA, 200);
        tea.consume();
    }
}
