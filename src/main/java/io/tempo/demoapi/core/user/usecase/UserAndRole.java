package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.infrastructure.shared.user.UserDto;

public interface UserAndRole {

    public UserDto execute(String id, String role);
}
