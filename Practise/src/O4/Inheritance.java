package O4;

import java.util.Arrays;

public class Inheritance {
    public static void main(String[] args) {
        Albatross andy = new Albatross("Andy", 3);
        Dog spot = new Dog("Spot", 4);
        EasternBrownSnake susie = new EasternBrownSnake("Susie", 5);
        FruitBat fred = new FruitBat("Fred", 10);
        GreatWhiteShark gustav = new GreatWhiteShark("Gustav", 14);
        Human bob = new Human("Bob", 50);
        RedBackSpider charlotte = new RedBackSpider("Charlotte", 7);
        Platypus phil = new Platypus("Phil", 15);

        Object[] animals = {andy, spot, susie, fred, gustav, bob, charlotte, phil};
        Arrays.stream(animals).forEach(o-> System.out.println(o));
    }
}
