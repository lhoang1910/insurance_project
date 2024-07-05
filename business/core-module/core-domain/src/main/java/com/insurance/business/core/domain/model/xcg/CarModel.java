package com.insurance.business.core.domain.model.xcg;

import com.insurance.business.core.domain.model.premium.MotorPremium;
import com.insurance.business.core.domain.model.PaymentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class CarModel extends XCGModel{

    // Thông tin chính
    private String vehicleType;     // Dòng xe
    private Boolean iSUselectric;
    private Boolean isIncludesBatteryValue;
    private Double payload;

    // Thông tin bổ sung
    private String fuelType;
    private Integer odometerReading; // Số công tơ mét
    private String color;
    private String transmissionType; // Kiểu hộp số
    private Double engineDisplacement; // Dung tích

    public CarModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels, String vehicleType, Boolean iSUselectric, Boolean isIncludesBatteryValue, Double payload, String fuelType, Integer odometerReading, String color, String transmissionType, Double engineDisplacement) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate, brand, version, numberOfSeats, purposeOfUse, mfg, manufacturingFacility, referenceValue, actualValue, model, firstRegistrationDate, licensePlate, chassisNumber, engineNumber, motorPremiums, paymentModels);
        this.vehicleType = vehicleType;
        this.iSUselectric = iSUselectric;
        this.isIncludesBatteryValue = isIncludesBatteryValue;
        this.payload = payload;
        this.fuelType = fuelType;
        this.odometerReading = odometerReading;
        this.color = color;
        this.transmissionType = transmissionType;
        this.engineDisplacement = engineDisplacement;
    }

    public CarModel(String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels, String vehicleType, Boolean iSUselectric, Boolean isIncludesBatteryValue, Double payload, String fuelType, Integer odometerReading, String color, String transmissionType, Double engineDisplacement) {
        super(brand, version, numberOfSeats, purposeOfUse, mfg, manufacturingFacility, referenceValue, actualValue, model, firstRegistrationDate, licensePlate, chassisNumber, engineNumber, motorPremiums, paymentModels);
        this.vehicleType = vehicleType;
        this.iSUselectric = iSUselectric;
        this.isIncludesBatteryValue = isIncludesBatteryValue;
        this.payload = payload;
        this.fuelType = fuelType;
        this.odometerReading = odometerReading;
        this.color = color;
        this.transmissionType = transmissionType;
        this.engineDisplacement = engineDisplacement;
    }
}
