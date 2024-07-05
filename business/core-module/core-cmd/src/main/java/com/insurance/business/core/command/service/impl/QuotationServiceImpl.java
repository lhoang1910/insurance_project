package com.insurance.business.core.command.service.impl;

import com.insurance.business.core.command.handle.QuotationCommandHandle;
import com.insurance.business.core.command.service.QuotationService;
import com.insurance.business.core.command.utils.InsuranceObjectTransfer;
import com.insurance.business.core.command.utils.PaymentFeeTransfer;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import com.insurance.infrastructure.shared.command.quotation.CreateQuotationCommand;
import com.insurance.infrastructure.shared.request.quotation.CreateQuotationRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuotationServiceImpl implements QuotationService {

    private final QuotationCommandHandle handle;

    @Override
    public WrapResponse<?> createQuotation(CreateQuotationRequest request, String username) {

        handle.handle(CreateQuotationCommand.builder()
                        .quotationCode(UUID.randomUUID().toString())
                        .line(request.getLine())
                        .productName(request.getProductName())
                        .quotationType(request.getQuotationType())
                        .createAt(request.getCreateAt())
                        .createBy(username)
                        .isCoinsurance(request.getIsCoinsurance())
                        .isFixed(request.getIsFixed())
                        .currency(request.getCurrency())
                        .exchangeRate(request.getExchangeRate())
                        .startDay(request.getStartDay())
                        .endDay(request.getEndDay())
                        .distributionChannel(request.getDistributionChannel())
                        .managerialStaff(request.getManagerialStaff())
                        .customerName(request.getCustomerName())
                        .beneficiary(request.getBeneficiary())
                        .insurer(request.getInsurer())
                        .agentCode(request.getAgentCode())
                        .programCode(request.getProgramCode())
                        .quantityOfPrincipleContract(request.getQuantityOfPrincipleContract())
                        .representative(request.getRepresentative())
                        .status(request.getStatus())
                        .insuranceObjects(InsuranceObjectTransfer.insuranceObjects(
                                BaseInsured.builder()
                                        .registrationCertificateType(request.getRegistrationCertificateType())
                                        .registrationEndDate(request.getRegistrationEndDate())
                                        .insuranceCertificateNumber(request.getInsuranceCertificateNumber())
                                        .insuranceCertificateIssueDate(request.getInsuranceCertificateIssueDate())
                                        .registrationStartDate(request.getRegistrationStartDate())
                                        .build(),  request.getInsuranceObjectInfos()))
                        .isDeleted(request.getIsDeleted())
                        .paymentFee(PaymentFeeTransfer.paymentFee(
                                BasePremium.builder()
                                        .type(request.getType())
                                        .sumInsured(request.getSumInsured())
                                        .premiumRate(request.getPremiumRate())
                                        .standardPremium(request.getStandardPremium())
                                        .discountRate(request.getDiscountRate())
                                        .premiumRateRatio(request.getPremiumRateRatio())
                                        .paymentPremium(request.getPaymentPremium())
                                        .sumPremium(request.getSumPremium())
                                        .build(), request.getPaymentFee()
                        ))
                        .updatedBy(username)
                .build());
        return new WrapResponse<>(true, HttpStatus.OK.value(), "Create User Successfully", null);
    }
}
