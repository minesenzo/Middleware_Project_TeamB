package cvut.fel.service;

import cvut.fel.entity.Squad;
import org.springframework.stereotype.Service;

@Service
public class SquadServiceImp implements AbstractService<Squad>{
    @Override
    public Squad findById(Long id) {
        return null;
    }

    public int getStrength(Long id){
        return findById(id).getValue();
    }
}
