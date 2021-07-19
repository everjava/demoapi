package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.core.user.ports.UserService;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFindByUseCase implements  UserFindBy{

    private UserService userService;

    public UserDto execute(String id){
        return userService.findById(id);
    }

}
