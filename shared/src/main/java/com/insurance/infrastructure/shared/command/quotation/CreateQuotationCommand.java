package com.insurance.infrastructure.shared.command.quotation;

import com.insurance.infrastructure.shared.base.BaseCommand;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class CreateQuotationCommand extends BaseCommand {

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

}
