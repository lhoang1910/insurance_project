package com.insurance.business.ac.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;
    private String userCode;
    private String username;
    private String password;
    private Integer department;
    private Integer workSite;
    private Boolean isDeleted;
    
}
