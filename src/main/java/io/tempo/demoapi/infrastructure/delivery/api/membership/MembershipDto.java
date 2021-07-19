package io.tempo.demoapi.infrastructure.delivery.api.membership;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDto {
    private String teamsId;
    private String userId;
    private String role;
}
