package io.tempo.demoapi.infrastructure.configuration;

import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.role.usecase.RoleFindAllUsecase;
import io.tempo.demoapi.infrastructure.dataprovider.db.RoleRepository;
import io.tempo.demoapi.infrastructure.dataprovider.db.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl roleServiceImpl() {
        return new RoleServiceImpl(roleRepository);
    }

    @Bean
    public RoleFindAll roleFindAll() {
        return new RoleFindAllUsecase(roleServiceImpl());
    }
}
