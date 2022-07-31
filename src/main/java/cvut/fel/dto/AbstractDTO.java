package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The data access object abstract
 */
@Getter
@Setter
public abstract class AbstractDTO implements Cloneable{

    /**
     * Id of abstract class
     */
    private Long id;
    /**
     * Name of abstract class
     */
    private String name;

    /**
     * Constructor of AbstractDTO.
     */
    public AbstractDTO() {
    }

    /**
     * Constructor of AbstractDTO.
     * 
     * @param AbstractDTO
     */
    public AbstractDTO(AbstractDTO dto) {
        id = dto.getId();
        name = dto.getName();
    }

    /**
     * Clone method
     */
    protected abstract AbstractDTO clone();
}
