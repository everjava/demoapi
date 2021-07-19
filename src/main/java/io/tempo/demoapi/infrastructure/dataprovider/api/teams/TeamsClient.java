package io.tempo.demoapi.infrastructure.dataprovider.api.teams;

import io.tempo.demoapi.core.teams.entity.Teams;
import io.tempo.demoapi.infrastructure.shared.teams.TeamsDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "TeamsClient" , url = "https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/")
public interface TeamsClient {

    @Cacheable("teams")
    @GetMapping("/teams")
    public List<Teams> findAll();

    @Cacheable("team")
    @GetMapping("/teams/{id}")
    public TeamsDto findById(@PathVariable("id") String id);

}
