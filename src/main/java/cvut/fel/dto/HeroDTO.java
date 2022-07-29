package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroDTO extends AbstractDTO {

    private String name;

    public HeroDTO() {}

    public HeroDTO(HeroDTO dto) {
        super(dto);
        name = dto.getName();
    }
    @Override
    public AbstractDTO clone() {
        return new HeroDTO(this);
    }

}