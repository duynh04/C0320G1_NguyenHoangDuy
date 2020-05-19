package P5InterfaceAndAbstract.thuchanh.animalAndEdible.animal;

import P5InterfaceAndAbstract.thuchanh.animalAndEdible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "cluck - cluck";
    }

    @Override
    public String howToEat() {
        return "can be fried";
    }
}
