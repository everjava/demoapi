package io.tempo.demoapi.infrastructure.configuration;

import io.tempo.demoapi.core.role.ports.RoleService;
import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.user.usecase.UserAndRoleUseCase;
import io.tempo.demoapi.core.user.usecase.UserFindAllUseCase;
import io.tempo.demoapi.core.user.usecase.UserFindByUseCase;
import io.tempo.demoapi.infrastructure.dataprovider.api.user.UserClient;
import io.tempo.demoapi.infrastructure.dataprovider.api.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConfig {

    @Autowired
    private UserClient userClient;
    @Autowired
     private RoleFindAll roleFindAll;


    public UserServiceImpl userServiceImpl(){
        return new UserServiceImpl(userClient , roleFindAll);
    }

    @Bean
    public UserFindAllUseCase userFindAll(){
        return new UserFindAllUseCase(userServiceImpl());
    }

    @Bean
    public UserFindByUseCase userFindBy(){

        return new UserFindByUseCase(userServiceImpl());
    }

    @Bean
    public UserAndRoleUseCase userAndRole(){

        return new UserAndRoleUseCase(userServiceImpl());
    }

}
