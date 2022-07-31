package cvut.fel.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * A Squad represent a Collection of Hero.<br>
 * A squad can have many heroes, and at the same time all heroes in the squad must have the same belief.<br>
 * The clash of bad and good squads means a fight.
 *
 * @see Hero
 * @see Fight
 */
@Entity
@Table(name = "SQUAD")
@Getter
public class Squad extends AbstractEntity{

    /**
     * Id of the squad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSquad;

    /**
     * Belief of the squad
     * 
     * @see Squad#Squad(int belief)
     * @see Squad#Squad()
     */
    @Column
    private final int belief;

    /**
     * Members of the squad
     * 
     * @see Squad#addMember(Hero hero)
     * @see Squad#removeMember(Hero hero)
     */
    @OneToMany(targetEntity=Hero.class, mappedBy = "squad")
    private Collection<Hero> member;

    /**
     * Id of the fight
     * 
     * @see Squad#setFight(Fight fight)
     * @see Fight
     */
    @ManyToOne
    @JoinColumn(name="idFight")
    private Fight fight;

    /**
     * Constructor of Squad.
     * 
     * @param belief Belief of squad
     * 
     * @see Squad
     * @see Squad#belief
     */
    public Squad(int belief) {
        this.belief = belief;

        member = new HashSet<>();
    }

    /**
     * Constructor of Squad.
     * 
     * @see Squad
     */
    public Squad() {
        belief = 0;
    }

    /**
     * This method allows to add a Hero in this Squad
     * @param hero is the Hero that we want to add in this Squad
     * @return true if the Hero is correctly added
     * @see Hero
     */
    public boolean addMember(Hero hero) {
        return member.add(hero);
    }

    /**
     * This method allows to remove a Hero in this Squad
     * @param hero is the Hero that we want to remove in this Squad
     * @return true if the Hero is correctly removed
     * @see Hero
     */
    public boolean removeMember(Hero hero) {
        return member.remove(hero);
    }

    /**
     * Getter of power
     * 
     * @return sum of all Hero's power.
     */
    public int getPower(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getPower()))
                .reduce(0, Integer::sum);
    }

    /**
     * Getter of Hero's will
     *
     * @return sum of all Hero's will.
     */
    public int getWill(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getWill()))
                .reduce(0, Integer::sum);
    }

    /**
     * Getter of Hero's magic
     *
     * @return sum of all Hero's magic.
     */
    public int getMagic(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getMagic()))
                .reduce(0, Integer::sum);
    }

    /**
     * Getter of getPower, getWill and getMagic
     *
     * @return sum of #getPower + #getWill + #getMagic
     * @see Squad#getPower()
     * @see Squad#getWill()
     * @see Squad#getMagic()
     */
    public int getValue(){
        return getPower() + getWill() + getMagic();
    }

    /**
     * Setter of fight
     *
     * @param fight Fight
     * @see Fight
     */
    public void setFight(Fight fight){
        this.fight = fight;
    }

    /**
     * Object to String
     *
     * @return object stringify
     * @see Squad#idSquad
     * @see Squad#belief
     * @see Squad#getValue()
     */
    @Override
    public String toString() {
        return "Squad{" +
                "idSquad=" + idSquad +
                ", belief=" + belief +
                ", value=" + getValue() +
                '}';
    }
}
