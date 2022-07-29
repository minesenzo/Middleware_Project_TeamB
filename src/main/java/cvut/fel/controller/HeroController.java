package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.HeroDTO;
import cvut.fel.entity.Hero;
import cvut.fel.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    private final AbstractService<Hero> heroService;
    private final DTOMapper dtoMapper;

    @Autowired
    public HeroController(AbstractService<Hero> heroService, DTOMapper dtoMapper) {
        this.heroService = heroService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.heroToDto(heroService.findById(id)));
    }
}
