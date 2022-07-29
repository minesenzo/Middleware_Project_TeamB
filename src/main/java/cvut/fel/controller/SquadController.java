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

@RestController
public class SquadController {

    private final AbstractService<Squad> squadService;
    private final DTOMapper dtoMapper;

    @Autowired
    public SquadController(AbstractService<Squad> squadService, DTOMapper dtoMapper) {
        this.squadService = squadService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/squad/{id}")
    public ResponseEntity<SquadDTO> getSquadById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.squadToDto(squadService.findById(id)));
    }
}
