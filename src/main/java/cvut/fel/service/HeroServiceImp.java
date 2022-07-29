package cvut.fel.service;

import cvut.fel.entity.Hero;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImp implements AbstractService<Hero> {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImp(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero findById(Long id){

        if (id == null)
            throw new FieldMissingException();
        return heroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("HERO_NOT_FOUND"));
    }

}
