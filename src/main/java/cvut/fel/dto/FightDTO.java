package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FightDTO extends AbstractDTO{

    public FightDTO() {}

    public FightDTO(FightDTO dto) {
        super(dto);
    }

    @Override
    public AbstractDTO clone() {
        return new FightDTO(this);
    }
}