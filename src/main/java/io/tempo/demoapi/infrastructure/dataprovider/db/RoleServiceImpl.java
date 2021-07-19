package io.tempo.demoapi.infrastructure.dataprovider.db;

import io.tempo.demoapi.core.role.ports.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import java.util.Set;


public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<String> roles() {
        return roleRepository.roles();
    }
}
