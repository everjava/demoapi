package io.tempo.demoapi.core.teams.usecase;

import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;

public interface TeamFindBy {
    public TeamsDto execute(String id);
}
