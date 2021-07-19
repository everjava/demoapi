package io.tempo.demoapi.infrastructure.delivery.api.role;


import io.tempo.demoapi.core.role.usecase.RoleFindAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private RoleFindAll roleFindAll;
    private Set<String> roles ;

    public RoleController(RoleFindAll roleFindAll) {
        this.roles = new HashSet<>(roleFindAll.execute());
        this.roleFindAll = roleFindAll;
    }

    @GetMapping()
    public ResponseEntity<Set<String>> getAll(){
        return new ResponseEntity<>(roleFindAll.execute()  , HttpStatus.OK);
    }

    @PutMapping("/{role}")
    public ResponseEntity<Set<String>> addRole(@PathVariable("role") String role){
        roleFindAll.execute().add(role);
        return new ResponseEntity<>(roleFindAll.execute(), HttpStatus.OK);
    }

}
