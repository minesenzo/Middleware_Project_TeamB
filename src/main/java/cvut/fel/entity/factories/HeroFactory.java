package cvut.fel.entity.factories;

import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;

import java.util.Random;

public class HeroFactory {

    public Hero createHero(Squad squad) {
        Random random = new Random();
        return createHero("Random Dude", squad.getBelief(),
                random.nextInt(1000), random.nextInt(1000), random.nextInt(1000),
                squad);
    }

    public Hero createHero(String name, int belief, int power, int will, int magic, Squad squad) {
        return new Hero(name + belief + power + will + magic, belief, power, will, magic, squad);
    }
}
