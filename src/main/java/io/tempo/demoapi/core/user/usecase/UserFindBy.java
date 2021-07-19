package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.infrastructure.shared.user.UserDto;

public interface UserFindBy {

    public UserDto execute(String id);
}
