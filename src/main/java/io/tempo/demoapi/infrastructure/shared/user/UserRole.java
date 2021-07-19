package io.tempo.demoapi.infrastructure.shared.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRole {
    private String userId;
    private String role;//removi o = "Developer" aqui
}
