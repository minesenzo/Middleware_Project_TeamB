package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Entity
@Table(name = "Hero")
@NamedQueries({
        @NamedQuery(name = "Hero.findByName", query = "SELECT u FROM Hero u WHERE u.name = :name"),
})
@Getter
@Setter
public class Hero extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHero;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column
    private int belief, power, will, magic;

    @ManyToOne
    @JoinColumn(name="idSquad")
    private Squad squad;

    public Hero() {
        this.name = String.valueOf((int) (Math.random() * 1000));
        this.belief = new Random().nextInt(2);
        this.power = (int) (Math.random() * 1000);
        this.will = (int) (Math.random() * 1000);
        this.magic = (int) (Math.random() * 1000);
    }

    public Hero(String name, int belief, int power, int will, int magic, Squad squad) {
        this.name = name;
        this.belief = belief;
        this.power = power;
        this.will = will;
        this.magic = magic;
        this.squad = squad;
    }

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
