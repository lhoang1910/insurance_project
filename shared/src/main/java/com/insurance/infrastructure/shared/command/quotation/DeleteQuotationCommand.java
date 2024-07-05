package com.insurance.infrastructure.shared.command.quotation;

import com.insurance.infrastructure.shared.base.BaseCommand;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class DeleteQuotationCommand extends BaseCommand {

    private String id;
    private String updatedBy;

    public DeleteQuotationCommand(String id) {
        this.id = id;
    }
}
