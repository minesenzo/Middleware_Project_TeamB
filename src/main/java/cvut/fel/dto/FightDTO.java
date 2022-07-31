package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The data access object of Fight
 */
@Getter
@Setter
public class FightDTO extends AbstractDTO{

    /**
     * Constructor of FightDTO.
     */
    public FightDTO() {}

    /**
     * Constructor of FightDTO.
     * 
     * @param FightDTO
     */
    public FightDTO(FightDTO dto) {
        super(dto);
    }

    /**
     * Clone method
     */
    @Override
    public AbstractDTO clone() {
        return new FightDTO(this);
    }
}