package io.tempo.demoapi.infrastructure.delivery.team;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.core.teams.exception.TeamNotFoundException;
import io.tempo.demoapi.core.teams.usecase.TeamFindAll;
import io.tempo.demoapi.core.teams.usecase.TeamFindBy;
import io.tempo.demoapi.infrastructure.delivery.api.teams.TeamsController;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = TeamsController.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TeamFindAll teamFindAllMock;
    @MockBean
    private TeamFindBy teamFindByMock;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void testFindById_ShouldReturnExpectedValueAndOK() throws Exception {
        TeamsDto dto = TeamsDto.builder()
                .name("Luke")
                .teamLeadId("1")
                .build();
        Mockito.when(teamFindByMock.execute("1")).thenReturn(dto);
        String expected = mapper.writeValueAsString(dto);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/teams/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected)).andReturn();

        String content = response.getResponse().getContentAsString();
        Assertions.assertEquals(expected, content);
    }

    @Test
    void testFindById_ShouldReturnException() throws Exception {
        Mockito.when(teamFindByMock.execute("1")).thenThrow(new TeamNotFoundException("Team not found"));
        String expectedException = "{\"message\":\"Team not found\",\"status\":404}";

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/teams/1"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().string(expectedException)).andReturn();

        String content = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedException, content);
    }


    @Test
    void testFindAll_ShouldReturndOK() throws Exception {
        Teams teams = Teams.builder()
                .id("1")
                .teamLeadId("1")
                .teamMemberIds(List.of("1", "2"))
                .name("Luke").build();
        Mockito.when(teamFindAllMock.excute()).thenReturn(List.of(teams));
        String expectedException = mapper.writeValueAsString(List.of(teams));

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/teams/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedException)).andReturn();

        String content = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedException, content);
    }
}
