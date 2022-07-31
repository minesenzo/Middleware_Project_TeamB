package cvut.fel.dto;

import cvut.fel.entity.Fight;
import cvut.fel.entity.Hero;
import cvut.fel.entity.Squad;
import org.mapstruct.Mapper;

/**
 * Mapper of DTO Classes
 */
@Mapper(componentModel = "spring")
public interface DTOMapper {

    /**
     * Hero to DTO method
     * 
     * @param Hero
     * 
     * @see HeroDTO
     * @see Hero
     */
    HeroDTO heroToDto(Hero entity);
    
    /**
     * Squad to DTO method
     * 
     * @param Squad
     * 
     * @see SquadDTO
     * @see Squad
     */
    SquadDTO squadToDto(Squad entity);

    /**
     * Fight to DTO method
     * 
     * @param Fight
     * 
     * @see FightDTO
     * @see Fight
     */
    FightDTO fightToDto(Fight entity);

}
