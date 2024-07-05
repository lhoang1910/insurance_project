package com.insurance.infrastructure.shared.event.quotation;

import com.insurance.infrastructure.shared.base.BaseEvent;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import com.insurance.infrastructure.shared.constant.JPA_TYPE;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuotationCreatedEvent extends BaseEvent {

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

    @Builder
    public QuotationCreatedEvent(Date updatedAt, String updatedBy, String id, String quotationCode, Integer line, String productName, Integer quotationType, Date createAt, String createBy, Boolean isCoinsurance, Boolean isFixed, Integer currency, Double exchangeRate, Date startDay, Date endDay, String distributionChannel, String managerialStaff, String customerName, String beneficiary, String insurer, String agentCode, String programCode, Integer quantityOfPrincipleContract, String representative, Integer status, List<Map<String, Object>> insuranceObject, Map<String, Object> paymentFee, Boolean isDeleted) {
        super(updatedAt, updatedBy);
        this.id = id;
        this.quotationCode = quotationCode;
        this.line = line;
        this.productName = productName;
        this.quotationType = quotationType;
        this.createAt = createAt;
        this.createBy = createBy;
        this.isCoinsurance = isCoinsurance;
        this.isFixed = isFixed;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.startDay = startDay;
        this.endDay = endDay;
        this.distributionChannel = distributionChannel;
        this.managerialStaff = managerialStaff;
        this.customerName = customerName;
        this.beneficiary = beneficiary;
        this.insurer = insurer;
        this.agentCode = agentCode;
        this.programCode = programCode;
        this.quantityOfPrincipleContract = quantityOfPrincipleContract;
        this.representative = representative;
        this.status = status;
        this.insuranceObjects = insuranceObject;
        this.paymentFee = paymentFee;
        this.isDeleted = isDeleted;
    }
}
