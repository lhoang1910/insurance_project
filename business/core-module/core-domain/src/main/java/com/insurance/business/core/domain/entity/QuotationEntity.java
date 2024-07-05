package com.insurance.business.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.base.BasePremium;
import com.insurance.infrastructure.shared.constant.*;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "quotation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = JPA_TYPE.JSON_BINARY, typeClass = JsonBinaryType.class)
public class QuotationEntity {

    @Id
    private String id;
    private String quotationCode;

    private Integer line;   // Nghiệp vụ
    public void setLine(Integer line) {
        if (line.equals(LINE.CON_NGUOI) || line.equals(LINE.XE_CO_GIOI)){
            this.line = line;
        } else {
            throw new IllegalArgumentException("Nghiệp vụ không hợp lệ");
        }
    }

    private String productName;
    public void setProductName(String productName) {
        if (this.line.equals(LINE.XE_CO_GIOI)){
            if (this.productName.equals(INSURANCE_PRODUCT.XE_MAY) || this.productName.equals(INSURANCE_PRODUCT.XE_O_TO)){
                this.productName = productName;
            }
            else {
                throw new IllegalArgumentException("Sản phẩm không hợp lệ");
            }
        } else if (this.line.equals(LINE.CON_NGUOI)) {
            if (this.productName.equals(INSURANCE_PRODUCT.SUC_KHOE) || this.productName.equals(INSURANCE_PRODUCT.DU_LICH)){
                this.productName = productName;
            }
            else {
                throw new IllegalArgumentException("Sản phẩm không hợp lệ");
            }
        } else {
            throw new IllegalArgumentException("Sản phẩm không hợp lệ");
        }
    }

    private Integer quotationType;
    public void setQuotationTypes(Integer quotationType) {
        if (quotationType.equals(QUOTATION_TYPE.MOI) || quotationType.equals(QUOTATION_TYPE.TAI)){
            this.quotationType = quotationType;
        } else {
            throw new IllegalArgumentException("Loại bản chào không hợp lệ");
        }
    }

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE_TIME)
    private Date createAt;
    private String createBy;
    private Boolean isCoinsurance;
    private Boolean isFixed;
    private Integer currency;
    private Double exchangeRate;

    // Thông tin chung

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE_TIME)
    private Date startDay;
    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE_TIME)
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

//    @Type(type = JPA_TYPE.JSON_BINARY)
//    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
//    private Map<Integer, List<BaseInsured>> inusranceObject = new HashMap<>();   // Key là mã sản phẩm
//
//    @Type(type = JPA_TYPE.JSON_BINARY)
//    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
//    private Map<Integer, List<BasePremium>> paymentFee = new HashMap<>();    // Key là mã nghiệp vụ

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private List<Map<String, Object>> insuranceObjects;

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private Map<String, Object> paymentFee;

    private Integer paymentMethod;
    public void setPaymentMethod(Integer paymentMethod) {
        if (paymentMethod.equals(PAYMENT_METHOD.CHUYEN_KHOAN)
                || paymentMethod.equals(PAYMENT_METHOD.TIEN_MAT)
                || paymentMethod.equals(PAYMENT_METHOD.KHAC)) {
            this.paymentMethod = paymentMethod;
        } else {
            throw new IllegalArgumentException("Phương thức thanh toán không hợp lệ");
        }
    }

    private Boolean isDeleted;

}
