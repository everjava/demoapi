package io.tempo.demoapi.infrastructure.dataprovider.api.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserClient userClient;
    @Mock
    private RoleFindAll roleFindAll;
    @InjectMocks
    private UserServiceImpl userServiceImpl;


    @Test
    void testFindById_ShouldReturnExpectedValue() throws Exception {
        UserDto userDto = UserDto.builder().id("1").firstName("Luke").role("Developer").build();
        Mockito.when(userClient.findById("1")).thenReturn(userDto);
        String expectedValue = new ObjectMapper().writeValueAsString(userDto);

        UserDto result = userServiceImpl.findById("1");
        String current = new ObjectMapper().writeValueAsString(result);

        Assertions.assertEquals(expectedValue, current);
    }

    @Test
    void testFindAll_ShouldReturnSizeOne() {
        User user = User.builder().id("1").firstName("Luke").build();
        Mockito.when(userClient.findAll()).thenReturn(List.of(user));

        List<User> result = userServiceImpl.findAll();
        int expectedValue = 1;

        Assertions.assertEquals(expectedValue, result.size());
    }
}
