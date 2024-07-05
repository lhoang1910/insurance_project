package com.insurance.business.core.domain.aggregate;

import com.insurance.infrastructure.shared.base.BaseAggregate;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import com.insurance.infrastructure.shared.command.quotation.CreateQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.DeleteQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.UpdateQuotationCommand;
import com.insurance.infrastructure.shared.event.quotation.QuotationCreatedEvent;
import com.insurance.infrastructure.shared.event.quotation.QuotationDeletedEvent;
import com.insurance.infrastructure.shared.event.quotation.QuotationUpdatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class QuotationAggregate extends BaseAggregate {

    private String id;
    private String quotationCode;
    private Integer line;
    private String productName;
    private Integer quotationType;
    private Date createAt;
    private String createBy;
    private Boolean isCoinsurance;
    private Boolean isFixed;
    private Integer currency;
    private Double exchangeRate;
    private Date startDay;
    private Date endDay;
    private String distributionChannel; // Kênh phân phối
    private String managerialStaff;
    private String customerName;
    private String beneficiary; //Người thụ hưởng
    private String insurer;
    private String agentCode;   // mã đại lý
    private String programCode;
    private Integer quantityOfPrincipleContract;
    private String representative; //Người đại diện
    private Integer status;
    private List<Map<String, Object>> insuranceObjects;
    private Map<String, Object> paymentFee;
    private Boolean isDeleted;
    private String updatedBy;

    public QuotationCreatedEvent apply(CreateQuotationCommand command){
        this.id = UUID.randomUUID().toString();
        this.quotationCode = command.getQuotationCode();
        this.line = command.getLine();
        this.productName = command.getProductName();
        this.quotationType = command.getQuotationType();
        this.createAt = command.getCreateAt();
        this.createBy = command.getCreateBy();
        this.isCoinsurance = command.getIsCoinsurance();
        this.isFixed = command.getIsFixed();
        this.currency = command.getCurrency();
        this.exchangeRate = command.getExchangeRate();
        this.startDay = command.getStartDay();
        this.endDay = command.getEndDay();
        this.distributionChannel = command.getDistributionChannel();
        this.managerialStaff = command.getManagerialStaff();
        this.customerName = command.getCustomerName();
        this.beneficiary = command.getBeneficiary();
        this.insurer = command.getInsurer();
        this.agentCode = command.getAgentCode();
        this.programCode = command.getProgramCode();
        this.quantityOfPrincipleContract = command.getQuantityOfPrincipleContract();
        this.representative = command.getRepresentative();
        this.status = command.getStatus();
        this.insuranceObjects = command.getInsuranceObjects();
        this.paymentFee = command.getPaymentFee();
        this.isDeleted = false;
        this.updatedBy = command.getUpdatedBy();

        return QuotationCreatedEvent.builder()
                .id(this.id)
                .quotationCode(this.quotationCode)
                .line(this.line)
                .productName(this.productName)
                .quotationType(this.quotationType)
                .createAt(this.createAt)
                .createBy(this.createBy)
                .isCoinsurance(this.isCoinsurance)
                .isFixed(this.isFixed)
                .currency(this.currency)
                .exchangeRate(this.exchangeRate)
                .startDay(this.startDay)
                .endDay(this.endDay)
                .distributionChannel(this.distributionChannel)
                .managerialStaff(this.managerialStaff)
                .customerName(this.customerName)
                .beneficiary(this.beneficiary)
                .insurer(this.insurer)
                .agentCode(this.agentCode)
                .programCode(this.programCode)
                .quantityOfPrincipleContract(this.quantityOfPrincipleContract)
                .representative(this.representative)
                .status(this.status)
                .insuranceObject(this.insuranceObjects)
                .paymentFee(this.paymentFee)
                .isDeleted(this.isDeleted)
                .updatedBy(this.updatedBy)
                .updatedAt(new Date())
                .build();
    }

    public QuotationUpdatedEvent apply(UpdateQuotationCommand command){
        this.id = command.getId();
        this.productName = command.getProductName();
        this.quotationType = command.getQuotationType();
        this.createBy = command.getCreateBy();
        this.isCoinsurance = command.getIsCoinsurance();
        this.isFixed = command.getIsFixed();
        this.currency = command.getCurrency();
        this.exchangeRate = command.getExchangeRate();
        this.distributionChannel = command.getDistributionChannel();
        this.managerialStaff = command.getManagerialStaff();
        this.customerName = command.getCustomerName();
        this.beneficiary = command.getBeneficiary();
        this.insurer = command.getInsurer();
        this.agentCode = command.getAgentCode();
        this.programCode = command.getProgramCode();
        this.quantityOfPrincipleContract = command.getQuantityOfPrincipleContract();
        this.representative = command.getRepresentative();
        this.status = command.getStatus();
        this.insuranceObjects = command.getInsuranceObjects();
        this.paymentFee = command.getPaymentFee();
        this.updatedBy = command.getUpdatedBy();

        return QuotationUpdatedEvent.builder()
                .id(this.id)
                .quotationCode(this.quotationCode)
                .line(this.line)
                .productName(this.productName)
                .quotationType(this.quotationType)
                .createBy(this.createBy)
                .isCoinsurance(this.isCoinsurance)
                .isFixed(this.isFixed)
                .currency(this.currency)
                .exchangeRate(this.exchangeRate)
                .distributionChannel(this.distributionChannel)
                .managerialStaff(this.managerialStaff)
                .customerName(this.customerName)
                .beneficiary(this.beneficiary)
                .insurer(this.insurer)
                .agentCode(this.agentCode)
                .programCode(this.programCode)
                .quantityOfPrincipleContract(this.quantityOfPrincipleContract)
                .representative(this.representative)
                .status(this.status)
                .insuranceObject(this.insuranceObjects)
                .paymentFee(this.paymentFee)
                .updatedBy(this.updatedBy)
                .updatedAt(new Date())
                .build();
    }

    public QuotationDeletedEvent apply(DeleteQuotationCommand command){
        this.id = command.getId();
        this.updatedBy = command.getUpdatedBy();
        return QuotationDeletedEvent.builder()
                .id(this.id)
                .updatedBy(this.updatedBy)
                .updatedAt(new Date())
                .build();
    }
}
