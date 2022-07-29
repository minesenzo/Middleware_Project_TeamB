package cvut.fel.repository;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Squad;
import org.springframework.data.repository.CrudRepository;

public interface FightRepository extends CrudRepository<Fight, Long> {
    Squad getWinner(Long id);
}
