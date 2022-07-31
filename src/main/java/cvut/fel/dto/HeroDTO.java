package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The data access object of Hero
 */
@Getter
@Setter
public class HeroDTO extends AbstractDTO {

    /**
     * Name of the hero
     */
    private String name;

    /**
     * Constructor of HeroDTO.
     */
    public HeroDTO() {}

    /**
     * Constructor of HeroDTO.
     * 
     * @param HeroDTO
     */
    public HeroDTO(HeroDTO dto) {
        super(dto);
        name = dto.getName();
    }
    
    /**
     * Clone method
     */
    @Override
    public AbstractDTO clone() {
        return new HeroDTO(this);
    }

}