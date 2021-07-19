package io.tempo.demoapi.core.user.usecase;

import io.tempo.demoapi.core.user.entity.User;

import java.util.List;

public interface UserFindAll {

    public List<User> execute();
}
