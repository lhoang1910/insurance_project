package com.insurance.business.core.command.service;

import com.insurance.infrastructure.shared.command.quotation.CreateQuotationCommand;
import com.insurance.infrastructure.shared.request.quotation.CreateQuotationRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;

public interface QuotationService {
    WrapResponse<?> createQuotation (CreateQuotationRequest request, String username);
}
