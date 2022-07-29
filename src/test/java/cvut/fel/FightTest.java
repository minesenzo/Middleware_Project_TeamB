package cvut.fel;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import cvut.fel.entity.factories.HeroFactory;
import cvut.fel.entity.factories.SquadFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FightTest {

    @Test
    public void ConstructorTestNoArgNotThrowException() {
        //0 args NOT OK
        Assertions.assertDoesNotThrow(() -> new Fight());
    }

    @Test
    public void ConstructorTestOneArgThrowException() {
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 2);

        Assertions.assertNotNull(s1);

        //1 args NOT OK
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fight(s1));
    }

    @Test
    public void ConstructorTestTwoArgNotThrowException() {
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 2);
        Squad s2 = squadFactory.createSquad(1, 2);

        Assertions.assertNotNull(s1);
        Assertions.assertNotNull(s2);
        Assertions.assertEquals(0, s1.getBelief());
        Assertions.assertEquals(1, s2.getBelief());

        //2 args and different belief OK
        Assertions.assertDoesNotThrow(() -> new Fight(s1, s2));
    }

    @Test
    public void ConstructorTestTwoArgSameBeliefThrowException() {
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 2);
        Squad s2 = squadFactory.createSquad(0, 2);

        Assertions.assertNotNull(s1);
        Assertions.assertNotNull(s2);
        Assertions.assertEquals(0, s1.getBelief());
        Assertions.assertEquals(0, s2.getBelief());

        //2 args but same belief NOT OK
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fight(s1, s2));
    }

    @Test
    public void ConstructorTestThreeArgThrowException() {
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 2);
        Squad s2 = squadFactory.createSquad(1, 2);
        Squad s3 = squadFactory.createSquad(0, 2);

        Assertions.assertNotNull(s1);
        Assertions.assertNotNull(s2);
        Assertions.assertNotNull(s3);

        //3 args NOT OK
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Fight(s1, s2, s3));
    }

    @Test
    public void ConstructorTest() {
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 2);
        Squad s2 = squadFactory.createSquad(1, 2);

        Assertions.assertNotNull(s1);
        Assertions.assertNotNull(s2);
        Assertions.assertEquals(0, s1.getBelief());
        Assertions.assertEquals(1, s2.getBelief());

        Fight fight = new Fight(s1, s2);

        Assertions.assertEquals(2, fight.getFighters().size());
    }

    @Test
    public void WinnerTest(){
        HeroFactory heroFactory = new HeroFactory();
        SquadFactory squadFactory = new SquadFactory();

        Assertions.assertNotNull(heroFactory);
        Assertions.assertNotNull(squadFactory);

        Squad s1 = squadFactory.createSquad(0, 0);
        Squad s2 = squadFactory.createSquad(1, 0);

        Assertions.assertNotNull(s1);
        Assertions.assertNotNull(s2);
        Assertions.assertEquals(0, s1.getBelief());
        Assertions.assertEquals(1, s2.getBelief());

        Hero h11 = heroFactory.createHero("h11", s1.getBelief(), 100, 100, 100, s1);
        Hero h12 = heroFactory.createHero("h12", s1.getBelief(), 50, 50, 50, s1);
        Hero h21 = heroFactory.createHero("h21", s2.getBelief(), 10, 10, 10, s2);
        Hero h22 = heroFactory.createHero("h22", s2.getBelief(), 5, 5, 5, s2);

        Assertions.assertNotNull(h11);
        Assertions.assertNotNull(h12);
        Assertions.assertNotNull(h21);
        Assertions.assertNotNull(h22);

        s1.addMember(h11);
        s1.addMember(h12);
        s2.addMember(h21);
        s2.addMember(h22);

        Assertions.assertEquals(450, s1.getValue());
        Assertions.assertEquals(45, s2.getValue());

        Fight fight = new Fight(s1, s2);

        Assertions.assertEquals(s1, fight.getWinner());
    }
}

