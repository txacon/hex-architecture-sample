package com.txacon.hex.arch.domain.domain;

import com.txacon.hex.arch.domain.domain.ids.UserId;
import com.txacon.hex.arch.domain.domain.values.Email;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private UserId userId;
    private String name;
    private String lastName;
    private Email email;
    private String password;
    private UserStatus userStatus;


}
