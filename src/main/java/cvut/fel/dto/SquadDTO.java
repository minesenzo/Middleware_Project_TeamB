package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadDTO extends AbstractDTO{
    private String name;

    public SquadDTO() {}

    public SquadDTO(SquadDTO dto) {
        super(dto);
        name = dto.getName();
    }
    @Override
    public AbstractDTO clone() {
        return new SquadDTO(this);
    }
}
