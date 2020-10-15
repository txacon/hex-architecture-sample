package com.txacon.hex.arch.infrastructure.adapter.rest.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO implements Serializable {

    private String userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean status;
}
