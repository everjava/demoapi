package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.core.user.ports.UserService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class UserFindAllUseCase implements UserFindAll{

    private UserService userService;

    public List<User> execute(){
        return userService.findAll();
    }
}
