package io.tempo.demoapi.core.user.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public String id;
    public String firstName;
    public String lastName;
    public String displayName;
    public String avatarUrl;
    public String location;
}
