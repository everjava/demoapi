package io.tempo.demoapi.core.role.usecase;

import io.tempo.demoapi.core.role.ports.RoleService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class RoleFindAllUsecase  implements  RoleFindAll{

    private RoleService roleService;

    @Override
    public Set<String> execute() {
        return roleService.roles();
    }
}
