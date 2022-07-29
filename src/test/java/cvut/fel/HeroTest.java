package cvut.fel;

import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import cvut.fel.entity.factories.HeroFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeroTest {

    @Test
    public void constructorTest(){
        Hero hero = new Hero("Test", 1, 2, 3, 4, new Squad(1));

        Assertions.assertEquals("Test", hero.getName());
        Assertions.assertEquals(1, hero.getBelief());
        Assertions.assertEquals(2, hero.getPower());
        Assertions.assertEquals(3, hero.getWill());
        Assertions.assertEquals(4, hero.getMagic());
    }

    @Test
    public void factoryTest1(){
        HeroFactory factory = new HeroFactory();

        factory.createHero(new Squad(1));
    }

    @Test
    public void factoryTest2(){
        HeroFactory factory = new HeroFactory();

        Hero hero = factory.createHero("Random Dude", 1, 2, 3, 4, new Squad(1));

        Assertions.assertEquals(1, hero.getBelief());
        Assertions.assertEquals(2, hero.getPower());
        Assertions.assertEquals(3, hero.getWill());
        Assertions.assertEquals(4, hero.getMagic());
    }

    @Test
    public void factoryTest3(){
        HeroFactory factory = new HeroFactory();

        Hero hero = factory.createHero(new Squad(1));

        Assertions.assertEquals(1, hero.getBelief());
    }
}
