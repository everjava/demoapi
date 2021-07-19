package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.core.user.ports.UserService;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAndRoleUseCase  implements  UserAndRole{

    private UserService userService;

    @Override
    public UserDto execute(String id, String role) {
        return userService.addRole(id, role);
    }
}
