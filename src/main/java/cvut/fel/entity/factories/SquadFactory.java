package cvut.fel.entity.factories;

import cvut.fel.entity.Squad;

public class SquadFactory {
    public Squad createSquad(int belief, int nbHeros) {
        Squad squad = new Squad(belief);

        HeroFactory heroFactory = new HeroFactory();

        for (int i = 0; i < nbHeros; i++) {
            squad.addMember(heroFactory.createHero(squad));
        }

        return squad;
    }
}
