package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Random;

/**
 * A Hero is a part of Squad class
 *
 * @see Hero
 */
@Entity
@Table(name = "Hero")
@NamedQueries({
        @NamedQuery(name = "Hero.findByName", query = "SELECT u FROM Hero u WHERE u.name = :name"),
})
@Getter
@Setter
public class Hero extends AbstractEntity{

    /**
     * Id of the hero
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHero;

    /**
     * Name of the hero
     * 
     * @see Hero#Hero()
     */
    @Column(unique = true)
    @NotNull
    private String name;

    /**
     * Belief of the hero
     * 
     * @see Hero#Hero()
     */
    @Column
    private int belief;
    /**
     * Power of the hero
     * 
     * @see Hero#Hero()
     */
    @Column
    private int power;
    /**
     * Will of the hero
     * 
     * @see Hero#Hero()
     */
    @Column
    private int will;
    /**
     * Magic of the hero
     * 
     * @see Hero#Hero()
     */
    @Column
    private int magic;

    /**
     * Squad of the hero
     * 
     * @see Hero#Hero()
     * @see Squad
     */
    @ManyToOne
    @JoinColumn(name="idSquad")
    private Squad squad;

    /**
     * Constructor of Hero.
     * 
     * @see Hero
     */
    public Hero() {
        this.name = String.valueOf((int) (Math.random() * 1000));
        this.belief = new Random().nextInt(2);
        this.power = (int) (Math.random() * 1000);
        this.will = (int) (Math.random() * 1000);
        this.magic = (int) (Math.random() * 1000);
    }

    /**
     * Constructor of Hero.
     * @param name String
     * @param belief int
     * @param power int
     * @param will int
     * @param magic int
     * @param squad Squad
     * 
     * @see Hero
     */
    public Hero(String name, int belief, int power, int will, int magic, Squad squad) {
        this.name = name;
        this.belief = belief;
        this.power = power;
        this.will = will;
        this.magic = magic;
        this.squad = squad;
    }

    /**
     * Object to String
     *
     * @return object stringify
     * @see Hero#idHero
     * @see Hero#name
     * @see Hero#belief
     * @see Hero#power
     * @see Hero#magic
     */
    @Override
    public String toString() {
        return "Hero{" +
                "id=" + idHero +
                ", name='" + name + '\'' +
                ", belief=" + belief +
                ", power=" + power +
                ", will=" + will +
                ", magic=" + magic +
                '}';
    }
}
