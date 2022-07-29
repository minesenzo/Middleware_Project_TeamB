package cvut.fel.service;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Squad;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class FightServiceImp implements AbstractService<Fight> {
    private final FightRepository fightRepository;

    @Autowired
    public FightServiceImp(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    @Override
    public Fight findById(Long id) {
        if (id == null)
            throw new FieldMissingException();
        return fightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("FIGHT_NOT_FOUND"));
    }

    public Squad getWinner(Long id) {
        Fight fight = findById(id);
        Optional<Squad> optionalWinner = fight.getFighters().stream()
                .max(Comparator.comparingInt(Squad::getValue));

        if(optionalWinner.isPresent()){
            return optionalWinner.get();
        } else {
            throw new RuntimeException("Winner not found, maybe squad have the same value.");
        }
    }
}
