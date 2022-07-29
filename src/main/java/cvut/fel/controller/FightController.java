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

@RestController
public class FightController {

    private final FightServiceImp fightService;
    private final DTOMapper dtoMapper;

    @Autowired
    public FightController(FightServiceImp fightService, DTOMapper dtoMapper) {
        this.fightService = fightService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/fight/{id}")
    public ResponseEntity<FightDTO> getFightById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.fightToDto(fightService.findById(id)));
    }

    @GetMapping("/fight/{id}/winner")
    public ResponseEntity<SquadDTO> getFightWinner(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.squadToDto(fightService.getWinner(id)));
    }
}
