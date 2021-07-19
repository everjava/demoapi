package io.tempo.demoapi.infrastructure.dataprovider.api.user;

import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.core.user.exception.UserNotFoundException;
import io.tempo.demoapi.core.user.ports.UserService;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private UserClient userClient;
    private RoleFindAll roleFindAll;


    public UserServiceImpl(UserClient userClient,RoleFindAll roleFindAll ) {
        this.userClient = userClient;
        this.roleFindAll = roleFindAll;
    }

    @Override
    public List<User> findAll() {
        return userClient.findAll();
    }

    @Override
    public UserDto findById(String id) {
        UserDto dto = Optional
                .ofNullable(userClient.findById(id))
                .orElseThrow(()-> new UserNotFoundException("User not found for id: "+ id));

        if (dto.getRole() == null) {
            dto.setRole(roleFindAll.execute().iterator().next());
        }
        return dto;
    }

    @Override
    public UserDto addRole(String id, String role) {
        UserDto dto = userClient.findById(id);
//        ModelMapper mapper = new ModelMapper();
//        UserDto dto = mapper.map(user, UserDto.class);
        dto.setRole(role);
        return dto;
    }
}
