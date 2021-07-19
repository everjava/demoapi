package io.tempo.demoapi.infrastructure.delivery.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.core.user.exception.UserNotFoundException;
import io.tempo.demoapi.core.user.usecase.UserAndRole;
import io.tempo.demoapi.core.user.usecase.UserFindAll;
import io.tempo.demoapi.core.user.usecase.UserFindBy;
import io.tempo.demoapi.infrastructure.delivery.api.user.UserController;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
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

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserFindAll userFindAllMock;
    @MockBean
    private UserFindBy userFindByMock;
    @MockBean
    private UserAndRole userAndRoleMock;
    @MockBean
    private RoleFindAll roleFindAllMock;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void testFindById_ShouldReturnExpectedValueAndOK() throws Exception {
        UserDto dto = UserDto.builder()
                .firstName("Luke")
                .role("Developer")
                .build();
        Mockito.when(userFindByMock.execute("1")).thenReturn(dto);
        String expected = mapper.writeValueAsString(dto);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected)).andReturn();

        String content = response.getResponse().getContentAsString();
        Assertions.assertEquals(expected, content);
    }

    @Test
    void testFindById_ShouldReturnException() throws Exception {
        Mockito.when(userFindByMock.execute("1")).thenThrow(new UserNotFoundException("User not found"));
        String expectedException = "{\"message\":\"User not found\",\"status\":404}";

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().string(expectedException)).andReturn();

        String content = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedException, content);
    }


    @Test
    void testFindAll_ShouldReturndOK() throws Exception {
        User user = User.builder().firstName("Luke").build();
        Mockito.when(userFindAllMock.execute()).thenReturn(List.of(user));

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Integer content = response.getResponse().getStatus();
        Assertions.assertEquals(200, content);
    }

}
