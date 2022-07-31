package cvut.fel;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import cvut.fel.entity.factories.SquadFactory;
import cvut.fel.repository.FightRepository;
import cvut.fel.repository.HeroRepository;
import cvut.fel.repository.SquadRepository;
import cvut.fel.service.FightServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class StartApplication
 */
@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    /**
     * Logger of Class
     * 
     * @see LoggerFactory
     * @see Logger
     * @see StartApplication
     */
    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    /**
     * Repository of Hero
     * 
     * @see HeroRepository
     */
    @Autowired
    private HeroRepository heroRepository;

    /**
     * Repository of Squad
     * 
     * @see SquadRepository
     */
    @Autowired
    private SquadRepository squadRepository;

    /**
     * Repository of Fight
     * 
     * @see FightRepository
     */
    @Autowired
    private FightRepository fightRepository;

    /**
     * Main function
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    /**
     * Run function
     * 
     * @param args String...
     */
    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        /*Hero hero1 = new Hero();
        hero1.setBelief(1);
        hero1.setWill(10);
        hero1.setPower(15);
        hero1.setMagic(20);
        Hero hero2 = new Hero();
        Hero hero3 = new Hero();*/

        Hero hero1 = new Hero();
        hero1.setBelief(1);
        hero1.setWill(10);
        hero1.setPower(15);
        hero1.setMagic(20);

        heroRepository.save(hero1);

        hero1.setName("Simple Dude");


        heroRepository.save(hero1);

        SquadFactory squadFactory = new SquadFactory();

        Squad s1 = squadFactory.createSquad(0, 2);
        Squad s2 = squadFactory.createSquad(1, 4);
        Squad s3 = squadFactory.createSquad(1, 10);

        Fight fight = new Fight(s1, s2);

        fightRepository.save(fight);
        squadRepository.save(s1);
        squadRepository.save(s2);
        squadRepository.save(s3);

        heroRepository.saveAll(s1.getMember());
        heroRepository.saveAll(s2.getMember());
        heroRepository.saveAll(s3.getMember());

        System.out.println("\nfindAll()");
        heroRepository.findAll().forEach(System.out::println);

        System.out.println("\nfindById(2L)");
        heroRepository.findById(2L).ifPresent(System.out::println);

        System.out.println("\nfindByName('Simple Dude')");
        heroRepository.findByName("Simple Dude").forEach(System.out::println);

        System.out.println("\ngetWinner");
        System.out.println(fight.getWinner());


    }

}