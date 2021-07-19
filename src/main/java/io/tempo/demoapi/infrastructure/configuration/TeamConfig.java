package io.tempo.demoapi.infrastructure.configuration;

import io.tempo.demoapi.core.teams.usecase.TeamFindAll;
import io.tempo.demoapi.core.teams.usecase.TeamFindAllUsecase;
import io.tempo.demoapi.core.teams.usecase.TeamFindBy;
import io.tempo.demoapi.core.teams.usecase.TeamFindByUsecase;
import io.tempo.demoapi.core.user.usecase.UserFindBy;
import io.tempo.demoapi.infrastructure.dataprovider.api.teams.TeamServiceImpl;
import io.tempo.demoapi.infrastructure.dataprovider.api.teams.TeamsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TeamConfig {

    @Autowired
    private TeamsClient teamsClient;
    @Autowired
    private UserFindBy userFindBy;


    public TeamServiceImpl teamServiceImpl(){
        return  new TeamServiceImpl(teamsClient, userFindBy);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TeamFindAllUsecase teamFindAll(){
        return new TeamFindAllUsecase(teamServiceImpl());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TeamFindByUsecase teamFindBy(){
        return new TeamFindByUsecase(teamServiceImpl());
    }

}
