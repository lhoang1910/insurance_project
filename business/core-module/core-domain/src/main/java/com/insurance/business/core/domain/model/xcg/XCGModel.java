package com.insurance.business.core.domain.model.xcg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.business.core.domain.model.premium.MotorPremium;
import com.insurance.business.core.domain.model.PaymentModel;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.constant.Date_TIME_FOMARTTER;
import com.insurance.infrastructure.shared.constant.JPA_TYPE;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = JPA_TYPE.JSON_BINARY, typeClass = JsonBinaryType.class)
public class XCGModel extends BaseInsured {

    // Thông tin chính
    private String brand;
    private String version;
    private Integer numberOfSeats;
    private String purposeOfUse;    // Mục đích sử dụng

    @JsonFormat(pattern = Date_TIME_FOMARTTER.YEAR)
    private Date mfg;               // Năm sản xuất
    private String manufacturingFacility;   // Nơi sản xuất
    private String referenceValue;
    private String actualValue;
    private String model;    // Loại xe

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE)
    private Date firstRegistrationDate;
    private String licensePlate;    // Biển kiểm soát
    private String chassisNumber; // Số khung
    private String engineNumber; // Số máy

    //thanh toán phí
    private List<MotorPremium> motorPremiums;
    @Type(type = JPA_TYPE.JSON_BINARY)
    private Map<Integer, PaymentModel> paymentModels;

    @Builder
    public XCGModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate);
        this.brand = brand;
        this.version = version;
        this.numberOfSeats = numberOfSeats;
        this.purposeOfUse = purposeOfUse;
        this.mfg = mfg;
        this.manufacturingFacility = manufacturingFacility;
        this.referenceValue = referenceValue;
        this.actualValue = actualValue;
        this.model = model;
        this.firstRegistrationDate = firstRegistrationDate;
        this.licensePlate = licensePlate;
        this.chassisNumber = chassisNumber;
        this.engineNumber = engineNumber;
        this.motorPremiums = motorPremiums;
        this.paymentModels = paymentModels;
    }

    public XCGModel(String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels) {
        this.brand = brand;
        this.version = version;
        this.numberOfSeats = numberOfSeats;
        this.purposeOfUse = purposeOfUse;
        this.mfg = mfg;
        this.manufacturingFacility = manufacturingFacility;
        this.referenceValue = referenceValue;
        this.actualValue = actualValue;
        this.model = model;
        this.firstRegistrationDate = firstRegistrationDate;
        this.licensePlate = licensePlate;
        this.chassisNumber = chassisNumber;
        this.engineNumber = engineNumber;
        this.motorPremiums = motorPremiums;
        this.paymentModels = paymentModels;
    }
}
