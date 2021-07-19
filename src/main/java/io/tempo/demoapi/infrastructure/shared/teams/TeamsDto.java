package io.tempo.demoapi.infrastructure.shared.teams;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.tempo.demoapi.infrastructure.shared.user.UserRole;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamsDto {
    private String id;
    private String name;
    private String teamLeadId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> teamMemberIds;
    private List<UserRole> teamMembers;
}
