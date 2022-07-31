package cvut.fel.entity.factories;

import cvut.fel.entity.Squad;

/**
 * Factory of Squads
 *
 * @see Squad
 */
public class SquadFactory {
    
    /**
     * Creator of Squad
     * @param belief int
     * @param nbHeros int
     * @return Squad
     * 
     * @see Hero
     * @see Squad
     */
    public Squad createSquad(int belief, int nbHeros) {
        Squad squad = new Squad(belief);

        HeroFactory heroFactory = new HeroFactory();

        for (int i = 0; i < nbHeros; i++) {
            squad.addMember(heroFactory.createHero(squad));
        }

        return squad;
    }
}
