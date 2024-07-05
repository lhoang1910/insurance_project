package com.insurance.infrastructure.shared.command.user;


import com.insurance.infrastructure.shared.base.BaseCommand;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class UpdateUserCommand extends BaseCommand {
    private String id;
    private String password;
    private Integer department;
    private Integer workSite;
    private String updatedBy;


}
