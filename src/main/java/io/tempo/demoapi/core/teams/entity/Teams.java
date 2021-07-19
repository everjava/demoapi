package io.tempo.demoapi.core.teams.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teams {
    public String id;
    public String name;
    public String teamLeadId;
    public List<String> teamMemberIds;
}
