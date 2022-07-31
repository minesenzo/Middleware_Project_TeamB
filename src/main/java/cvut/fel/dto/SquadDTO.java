package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The data access object of Squad
 */
@Getter
@Setter
public class SquadDTO extends AbstractDTO{
    /**
     * Name of the squad
     */
    private String name;

    /**
     * Constructor of SquadDTO.
     */
    public SquadDTO() {}

    /**
     * Constructor of SquadDTO.
     * 
     *  @param SquadDTO
     */
    public SquadDTO(SquadDTO dto) {
        super(dto);
        name = dto.getName();
    }

    /**
     * Clone method
     */
    @Override
    public AbstractDTO clone() {
        return new SquadDTO(this);
    }
}
