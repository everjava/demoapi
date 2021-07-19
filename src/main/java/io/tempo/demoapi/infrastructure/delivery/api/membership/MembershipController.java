package io.tempo.demoapi.infrastructure.delivery.api.membership;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/membership")
public class MembershipController {

//    private TeamsService2 teamsService;
//    private UserFindByUseCase userService;
//    private RoleService roleService;
//    private MembershipService membershipService;
//
//    public MembershipController(TeamsService2 teamsService, UserFindByUseCase userService, RoleService roleService, MembershipService membershipService) {
//        this.teamsService = teamsService;
//        this.userService = userService;
//        this.roleService = roleService;
//        this.membershipService = membershipService;
//    }
//
//    @GetMapping("/role")
//    public ResponseEntity<?> findRoleForMembership(@RequestBody MembershipDto membershipDto) {
////        List<TeamsDto> teamsDtos = teamsService.findAll();
////        List<UserDto> userDtos = userService.findAll();
////
////        TeamsDto teamsDto = teamsService.findById(membershipDto.getTeamsId());
////        UserRole userRole = teamsDto.getTeamMembers().stream()
////                .filter(ur -> ur.getUserId().equals(membershipDto.getUserId()))
////                .findFirst().get();
////
//
//
//        return new ResponseEntity<>("testi", HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<?> findMembershipForRole(@RequestBody MembershipDto membershipDto) {
////        TeamsDto teamsDto = teamsService.findById(membershipDto.getTeamsId());
////        UserDto userDto = userService.findById(membershipDto.getUserId());
////        List<String> roles = roleService.roles();
////
////        teamsDto.getTeamMembers().stream()
////                .filter(e -> e.getUserId().equals(userDto.getId()))
////                .filter(e -> e.getRole().equals(membershipDto.getRole())).findFirst();
//
//        return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
//    }



}
