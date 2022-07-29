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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSquad;

    @Column
    private final int belief;

    @OneToMany(targetEntity=Hero.class, mappedBy = "squad")
    private Collection<Hero> member;

    @ManyToOne
    @JoinColumn(name="idFight")
    private Fight fight;

    public Squad(int belief) {
        this.belief = belief;

        member = new HashSet<>();
    }

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
     *
     * @return sum of all Hero's power.
     */
    public int getPower(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getPower()))
                .reduce(0, Integer::sum);
    }

    /**
     *
     * @return sum of all Hero's will.
     */
    public int getWill(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getWill()))
                .reduce(0, Integer::sum);
    }

    /**
     *
     * @return sum of all Hero's magic.
     */
    public int getMagic(){
        return member.stream()
                .flatMap(hero -> Stream.of(hero.getMagic()))
                .reduce(0, Integer::sum);
    }

    /**
     *
     * @return sum of #getMagic + #getWill + #getPower
     */
    public int getValue(){
        return getPower() + getWill() + getMagic();
    }

    public void setFight(Fight fight){
        this.fight = fight;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "idSquad=" + idSquad +
                ", belief=" + belief +
                ", value=" + getValue() +
                '}';
    }
}
