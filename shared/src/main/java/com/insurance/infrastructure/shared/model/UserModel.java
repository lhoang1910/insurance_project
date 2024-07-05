package com.insurance.infrastructure.shared.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserModel {
    private String id;
    private String userCode;
    private String username;
    private String password;
    private Integer department;
    private Integer workSite;
    private Boolean isDeleted;
}
