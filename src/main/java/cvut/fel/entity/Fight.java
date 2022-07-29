package cvut.fel.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Fight")
@NamedQueries({
        @NamedQuery(name = "Fight.getWinner", query = "SELECT f FROM Fight f WHERE f.idFight = :name"),
})
@Getter
public class Fight extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFight;

    @OneToMany(targetEntity=Squad.class, mappedBy = "fight")
    private final Collection<Squad> fighters;

    public Fight(Squad... fighters) {
        if(fighters.length != 2 || fighters[0].getBelief() == fighters[1].getBelief()) {
            throw new IllegalArgumentException("A fight must be between two squads of different belief. " +
                    "Current configuration : " + Arrays.toString(fighters));
        } else {
            this.fighters = Set.of(fighters);
            this.fighters.forEach(squad -> squad.setFight(this));
        }
    }

    public Fight() {
        fighters = new HashSet<>();
    }

    public Squad getWinner() {
        Optional<Squad> optionalWinner = getFighters().stream()
                .max(Comparator.comparingInt(Squad::getValue));

        if(optionalWinner.isPresent()){
            return optionalWinner.get();
        } else {
            throw new RuntimeException("Winner not found, maybe squad have the same value.");
        }
    }

    @Override
    public String toString() {
        return "Fight{" +
                "idFight=" + idFight +
                ", fighters=" + fighters +
                '}';
    }
}
