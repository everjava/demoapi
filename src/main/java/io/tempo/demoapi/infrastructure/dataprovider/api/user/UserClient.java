package io.tempo.demoapi.infrastructure.dataprovider.api.user;

import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "UserClient", url = "https://cgjresszgg.execute-api.eu-west-1.amazonaws.com")
public interface UserClient {

    @Cacheable("users")
    @GetMapping("/users")
    public List<User> findAll();

    @Cacheable("user")
    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable("id") String id);

}
