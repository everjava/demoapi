package io.tempo.demoapi.core.teams.usecase;

import io.tempo.demoapi.core.teams.ports.TeamService;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeamFindByUsecase  implements  TeamFindBy{

    private TeamService teamService;

    @Override
    public TeamsDto execute(String id) {
        return teamService.findById(id);
    }
}
