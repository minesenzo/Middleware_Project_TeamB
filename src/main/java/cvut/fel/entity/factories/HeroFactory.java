package cvut.fel.entity.factories;

import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;

import java.util.Random;

/**
 * Factory of Heroes
 *
 * @see Hero
 */
public class HeroFactory {

    /**
     * Creator of Hero
     * @param Squad squad
     * @return Hero
     * 
     * @see Hero
     * @see Squad
     */
    public Hero createHero(Squad squad) {
        Random random = new Random();
        return createHero("Random Dude", squad.getBelief(),
                random.nextInt(1000), random.nextInt(1000), random.nextInt(1000),
                squad);
    }

    /**
     * Creator of Hero
     * @param name String
     * @param belief int
     * @param power int
     * @param will int
     * @param magic int     
     * @param Squad squad
     * @return Hero
     * 
     * @see Hero
     * @see Squad
     */
    public Hero createHero(String name, int belief, int power, int will, int magic, Squad squad) {
        return new Hero(name + belief + power + will + magic, belief, power, will, magic, squad);
    }
}
