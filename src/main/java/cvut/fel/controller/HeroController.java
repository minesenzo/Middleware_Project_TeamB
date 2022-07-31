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

/**
 * Controller Class for Hero
 * 
 * @see Hero
 */
@RestController
public class HeroController {

    /**
     * Services for Hero
     * 
     * @see AbstractService
     * @see Hero
     */
    private final AbstractService<Hero> heroService;
    /**
     * Mapper for Hero
     * 
     * @see DTOMapper
     */
    private final DTOMapper dtoMapper;

    /**
     * Constructor of HeroController.
     * 
     * @param heroService AbstractService<Hero>
     * @see AbstractService
     * @see Hero
     */
    @Autowired
    public HeroController(AbstractService<Hero> heroService, DTOMapper dtoMapper) {
        this.heroService = heroService;
        this.dtoMapper = dtoMapper;
    }

    /**
     * Getter of hero by Id
     * 
     * @param id @PathVariable Long
     * @return ResponseEntity<HeroDTO>
     * @see ResponseEntity
     * @see HeroDTO
     * @see Hero
     */
    @GetMapping("/hero/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.heroToDto(heroService.findById(id)));
    }
}
