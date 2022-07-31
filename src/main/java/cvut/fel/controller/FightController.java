package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.FightDTO;
import cvut.fel.dto.SquadDTO;
import cvut.fel.service.FightServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class for Fight
 * 
 * @see Fight
 */
@RestController
public class FightController {

    /**
     * Services for Fight
     * 
     * @see FightServiceImp
     * @see Fight
     */
    private final FightServiceImp fightService;
    /**
     * Mapper for Fight
     * 
     * @see DTOMapper
     */
    private final DTOMapper dtoMapper;

    /**
     * Constructor of FightController.
     * 
     * @param fightService AbstractService<Fight>
     * @see AbstractService
     * @see Fight
     */
    @Autowired
    public FightController(FightServiceImp fightService, DTOMapper dtoMapper) {
        this.fightService = fightService;
        this.dtoMapper = dtoMapper;
    }

    /**
     * Getter of fight by Id
     * 
     * @param id @PathVariable Long
     * @return ResponseEntity<FightDTO>
     * @see ResponseEntity
     * @see FightDTO
     * @see Fight
     */
    @GetMapping("/fight/{id}")
    public ResponseEntity<FightDTO> getFightById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.fightToDto(fightService.findById(id)));
    }

    /**
     * Getter of fight winner (Squad) by Id
     * 
     * @param id @PathVariable Long
     * @return ResponseEntity<SquadDTO>
     * @see ResponseEntity
     * @see SquadDTO
     * @see Squad
     */
    @GetMapping("/fight/{id}/winner")
    public ResponseEntity<SquadDTO> getFightWinner(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.squadToDto(fightService.getWinner(id)));
    }
}
