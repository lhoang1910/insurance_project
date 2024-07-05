package com.insurance.business.core.command.handle;

import com.insurance.infrastructure.shared.command.quotation.CreateQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.DeleteQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.UpdateQuotationCommand;

public interface QuotationCommandHandle {
    void handle(CreateQuotationCommand command);
    void handle(UpdateQuotationCommand command);
    void handle(DeleteQuotationCommand command);
}
