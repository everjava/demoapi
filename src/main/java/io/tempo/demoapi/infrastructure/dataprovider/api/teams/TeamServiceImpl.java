package io.tempo.demoapi.infrastructure.dataprovider.api.teams;

import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.core.teams.exception.TeamNotFoundException;
import io.tempo.demoapi.core.teams.ports.TeamService;
import io.tempo.demoapi.core.user.usecase.UserFindBy;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import io.tempo.demoapi.infrastructure.shared.user.UserRole;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamServiceImpl  implements TeamService {

    private TeamsClient teamsClient;
    private UserFindBy userFindBy;

    public TeamServiceImpl(TeamsClient teamsClient, UserFindBy userFindBy) {
        this.teamsClient = teamsClient;
        this.userFindBy = userFindBy;
    }

    @Override
    public List<Teams> findAll() {
        return teamsClient.findAll();
    }

    @Override
    public TeamsDto findById(String id) {
        TeamsDto teamsDto = Optional
                .ofNullable(teamsClient.findById(id))
                .orElseThrow(() -> new TeamNotFoundException("Team not found for id: " + id));

        List<UserRole> collect = teamsDto.getTeamMemberIds().stream()
                .filter(Objects::nonNull)
                .map(userId -> {
                    UserDto userDto = userFindBy.execute(userId);
                    UserRole userRole = UserRole.builder().userId(userId).role(userDto.getRole()).build();
                    return userRole;
                })
                .collect(Collectors.toList());
        teamsDto.setTeamMembers(collect);
        return teamsDto;
    }
}