package io.tempo.demoapi.infrastructure.delivery.api.user;

import io.tempo.demoapi.core.role.exception.RoleNotFoundException;
import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import io.tempo.demoapi.core.user.entity.User;
import io.tempo.demoapi.core.user.usecase.UserAndRole;
import io.tempo.demoapi.core.user.usecase.UserFindAll;
import io.tempo.demoapi.core.user.usecase.UserFindBy;
import io.tempo.demoapi.infrastructure.shared.user.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserFindBy userFindBy;
    private UserFindAll userFindAll;
    private UserAndRole userAndRole;
    private RoleFindAll roleFindAll;

    public UserController(UserFindBy userFindBy, UserFindAll userFindAll, UserAndRole userAndRole, RoleFindAll roleFindAll) {
        this.userFindBy = userFindBy;
        this.userFindAll = userFindAll;
        this.userAndRole = userAndRole;
        this.roleFindAll = roleFindAll;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userFindAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") String id) {
        return new ResponseEntity<>(userFindBy.execute(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/role/{role}")
    public ResponseEntity<UserDto> addRole(@PathVariable("id") String id, @PathVariable("role") String role) {
        Set<String> roles = roleFindAll.execute();
        String roleFound = roles.stream()
                .filter(r -> r.contains(role))
                .findFirst()
                .orElseThrow(() -> new RoleNotFoundException("Role not found: " + role));
        return new ResponseEntity<>(userAndRole.execute(id, roleFound), HttpStatus.OK);
    }

}
