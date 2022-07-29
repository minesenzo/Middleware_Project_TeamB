package cvut.fel.dto;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    HeroDTO heroToDto(Hero entity);
    SquadDTO squadToDto(Squad entity);

    FightDTO fightToDto(Fight entity);

}
