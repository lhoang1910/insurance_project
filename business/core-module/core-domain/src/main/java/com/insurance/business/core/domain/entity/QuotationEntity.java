package com.insurance.business.core.domain.entity;

import com.insurance.infrastructure.shared.constant.JPA_TYPE;
import com.insurance.infrastructure.shared.model.BaseInsuranceObject;
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
    private String quontationCode;
    private Integer operation;
    private String productName;
    private Integer quotationType;
    private Date createAt;
    private String createBy;
    private Boolean isCoinsurance;
    private Boolean isFixed;
    private Integer currency;
    private Double exchangeRate;

    // Thông tin chung
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

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private Map<String, List<Object>> inusranceObject = new HashMap<>();

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private Map<String, Object> paymentFee = new HashMap<>();


}
