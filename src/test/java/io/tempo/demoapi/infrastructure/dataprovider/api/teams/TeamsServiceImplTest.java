package io.tempo.demoapi.infrastructure.dataprovider.api.teams;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.core.user.usecase.UserFindBy;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import io.tempo.demoapi.infrastructure.shared.user.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TeamsServiceImplTest {

    @Mock
    private TeamsClient teamsClient;
    @Mock
    private UserFindBy userFindBy;
    @InjectMocks
    private TeamServiceImpl teamServiceImpl;

    @Test
    void testFindById_ShouldReturnExpectedValue() throws Exception {
        TeamsDto dto = TeamsDto.builder()
                .id("1")
                .teamLeadId("1")
                .teamMemberIds(List.of("1"))
                .teamMembers(List.of(UserRole.builder().role("Developer").userId("1").build()))
                .name("Luke").build();
        UserDto userDto = UserDto.builder().firstName("Luke").role("Developer").build();
        Mockito.when(teamsClient.findById("1")).thenReturn(dto);
        Mockito.when(userFindBy.execute("1")).thenReturn(userDto);
        String expectedValue = new ObjectMapper().writeValueAsString(dto);

        TeamsDto result = teamServiceImpl.findById("1");
        String current = new ObjectMapper().writeValueAsString(result);

        Assertions.assertEquals(expectedValue, current);
    }

    @Test
    void testFindAll_ShouldReturnSizeOne() {
        Teams teams = Teams.builder()
                .id("1")
                .teamLeadId("1")
                .teamMemberIds(List.of("1"))
                .name("Luke").build();
        Mockito.when(teamsClient.findAll()).thenReturn(List.of(teams));

        List<Teams> result = teamServiceImpl.findAll();
        int expectedValue = 1;

        Assertions.assertEquals(expectedValue, result.size());
    }

}
