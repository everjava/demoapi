package io.tempo.demoapi.core.teams.ports;

import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;

import java.util.List;

public interface TeamService {

    public List<Teams> findAll();
    public TeamsDto findById(String id);

}
