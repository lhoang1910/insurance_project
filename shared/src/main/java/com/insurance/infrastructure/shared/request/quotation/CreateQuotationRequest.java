package com.insurance.infrastructure.shared.request.quotation;

import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuotationRequest {
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
    private String registrationCertificateType; // Kiểu giấy chứng nhận
    private Date registrationStartDate;
    private Date registrationEndDate;
    private String insuranceCertificateNumber; // Số giấy chứng nhận bảo hiểm
    private Date insuranceCertificateIssueDate; // Ngày cấp chứng nhận bảo hiểm
    private List<Map<String, Object>> insuranceObjectInfos;
    private Boolean isDeleted;
    private String updatedBy;
    private String type;    // Quyền lợi/loại hình
    private Double sumInsured;  //STBH
    private Double premiumRate;     //Tỉ lệ phí
    private Double standardPremium; // Phí chuẩn
    private Double discountRate;    // Tỉ lệ giảm phí
    private Double premiumRateRatio;     // Tỉ lệ phí thanh toán
    private Double paymentPremium;     // Phí thanh toán
    private Long sumPremium;
    private Map<String, Object> paymentFee;
}
