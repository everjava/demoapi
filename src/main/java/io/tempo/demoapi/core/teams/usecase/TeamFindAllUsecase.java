package io.tempo.demoapi.core.teams.usecase;

import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.core.teams.ports.TeamService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TeamFindAllUsecase implements  TeamFindAll{

    private TeamService teamService;

    @Override
    public List<Teams> excute() {
        return teamService.findAll();
    }
}
