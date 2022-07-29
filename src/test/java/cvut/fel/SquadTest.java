package cvut.fel;

import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import cvut.fel.entity.factories.HeroFactory;
import cvut.fel.entity.factories.SquadFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SquadTest {

    @Test
    public void ConstructorTest() {
        Squad squad = new Squad(0);

        Assertions.assertNotNull(squad);
        Assertions.assertEquals(0, squad.getBelief());
    }

    @Test
    public void AddMemberTest() {
        Squad squad = new Squad(0);

        HeroFactory heroFactory = new HeroFactory();
        Hero hero = heroFactory.createHero(squad);

        boolean result = squad.addMember(hero);

        Assertions.assertNotNull(squad);
        Assertions.assertNotNull(heroFactory);
        Assertions.assertNotNull(hero);
        Assertions.assertTrue(result);
    }

    @Test
    public void RemoveMemberTest() {
        Squad squad = new Squad(0);

        HeroFactory heroFactory = new HeroFactory();
        Hero hero = heroFactory.createHero(squad);

        Assertions.assertNotNull(squad);
        Assertions.assertNotNull(heroFactory);
        Assertions.assertNotNull(hero);
        Assertions.assertTrue(squad.addMember(hero));
        Assertions.assertTrue(squad.removeMember(hero));
    }

    @Test
    public void FactoryTest() {
        SquadFactory factory = new SquadFactory();

        Squad squad = factory.createSquad(1, 2);

        Assertions.assertNotNull(factory);
        Assertions.assertNotNull(squad);
    }

    @Test
    public void ValuesTest() {
        Squad squad = new Squad(1);
        Hero h1 = new Hero("h1", 1, 10, 20, 30, squad);
        Hero h2 = new Hero("h2", 1, 15, 25, 35, squad);

        squad.addMember(h1);
        squad.addMember(h2);

        Assertions.assertNotNull(h1);
        Assertions.assertNotNull(h2);
        Assertions.assertNotNull(squad);
        Assertions.assertEquals(1, h1.getBelief());
        Assertions.assertEquals(1, h2.getBelief());
        Assertions.assertEquals(1, squad.getBelief());
        Assertions.assertEquals(25, squad.getPower());
        Assertions.assertEquals(45, squad.getWill());
        Assertions.assertEquals(65, squad.getMagic());
        Assertions.assertEquals(25+45+65, squad.getValue());
    }
}

