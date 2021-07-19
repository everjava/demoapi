package io.tempo.demoapi.core.user.ports;

import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public UserDto findById(String id);

    public UserDto addRole(String id, String role);
}
