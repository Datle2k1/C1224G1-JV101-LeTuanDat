package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "animal.Chicken: Cuc tac";
    }

    @Override
    public String howToEat() {
        return "Could be fries";
    }
}
