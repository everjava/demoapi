package io.tempo.demoapi.infrastructure.delivery.api.teams;

import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.core.teams.usecase.TeamFindAll;
import io.tempo.demoapi.core.teams.usecase.TeamFindBy;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {

    private TeamFindBy teamFindBy;
    private TeamFindAll teamFindAll;

    public TeamsController(TeamFindBy teamFindBy, TeamFindAll teamFindAll) {
        this.teamFindBy = teamFindBy;
        this.teamFindAll = teamFindAll;
    }

    @GetMapping()
    public ResponseEntity<List<Teams>> getAll() {
        List<Teams> all = teamFindAll.excute();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamsDto> getUser(@PathVariable("id") String id) {
        TeamsDto dto = teamFindBy.execute(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
