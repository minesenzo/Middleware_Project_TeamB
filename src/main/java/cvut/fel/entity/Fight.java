package cvut.fel.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.*;

/**
 * A Fight represent a fight between 2 Squad
 *
 * @see Squad
 */
@Entity
@Table(name = "Fight")
@NamedQueries({
        @NamedQuery(name = "Fight.getWinner", query = "SELECT f FROM Fight f WHERE f.idFight = :name"),
})
@Getter
public class Fight extends AbstractEntity {

    /**
     * Id of the fight
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFight;

    /**
     * List of Squads
     * 
     * @see Squad
     */
    @OneToMany(targetEntity=Squad.class, mappedBy = "fight")
    private final Collection<Squad> fighters;

    /**
     * Constructor of Fight.
     * 
     * @param fighters List of Squad
     * 
     * @see Squad
     */
    public Fight(Squad... fighters) {
        if(fighters.length != 2 || fighters[0].getBelief() == fighters[1].getBelief()) {
            throw new IllegalArgumentException("A fight must be between two squads of different belief. " +
                    "Current configuration : " + Arrays.toString(fighters));
        } else {
            this.fighters = Set.of(fighters);
            this.fighters.forEach(squad -> squad.setFight(this));
        }
    }

    /**
     * Constructor of Fight.
     * 
     *  @see Fight
     */
    public Fight() {
        fighters = new HashSet<>();
    }

    /**
     * Getter of squad winner of fight
     * 
     *  @return Squad winner
     *  @see Squad
     */
    public Squad getWinner() {
        Optional<Squad> optionalWinner = getFighters().stream()
                .max(Comparator.comparingInt(Squad::getValue));

        if(optionalWinner.isPresent()){
            return optionalWinner.get();
        } else {
            throw new RuntimeException("Winner not found, maybe squad have the same value.");
        }
    }

    /**
     * Object to String
     *
     * @return object stringify
     * @see Fight#idFight
     * @see Fight#fighters
     */
    @Override
    public String toString() {
        return "Fight{" +
                "idFight=" + idFight +
                ", fighters=" + fighters +
                '}';
    }
}
