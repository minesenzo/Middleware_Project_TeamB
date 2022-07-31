package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.HeroDTO;
import cvut.fel.dto.SquadDTO;
import cvut.fel.entity.Squad;
import cvut.fel.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class for Squad
 * 
 * @see Squad
 */
@RestController
public class SquadController {

    /**
     * Services for Squad
     * 
     * @see AbstractService
     * @see Squad
     */
    private final AbstractService<Squad> squadService;
    /**
     * Mapper for Squad
     * 
     * @see DTOMapper
     */
    private final DTOMapper dtoMapper;

    /**
     * Constructor of SquadController.
     * 
     * @param squadService AbstractService<Squad>
     * @see AbstractService
     * @see Squad
     */
    @Autowired
    public SquadController(AbstractService<Squad> squadService, DTOMapper dtoMapper) {
        this.squadService = squadService;
        this.dtoMapper = dtoMapper;
    }

    /**
     * Getter of squad by Id
     * 
     * @param id @PathVariable Long
     * @return ResponseEntity<SquadDTO>
     * @see ResponseEntity
     * @see SquadDTO
     * @see Squad
     */
    @GetMapping("/squad/{id}")
    public ResponseEntity<SquadDTO> getSquadById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.squadToDto(squadService.findById(id)));
    }
}
